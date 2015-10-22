package net.waglewagle.nos.article;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import net.waglewagle.nos.NosException;
import net.waglewagle.nos.XmlResultBaseHandler;
import net.waglewagle.nos.util.ValueUtil;

/**
 * <p>논문검색결과 XML 처리 Handler.</p>
 *
 * @author 강신원
 * @since 2015. 10. 20
 */
class ArticleSearchResultXmlHandler extends XmlResultBaseHandler {
		private static enum RecordType { ARTICLE, JOURNAL, DISSERTATION };

		private ThreadLocal<ArticleQueryResult> threadLocal;

		public ArticleSearchResultXmlHandler() {
			this.threadLocal = new ThreadLocal<ArticleQueryResult>();
		}

		private void prepareQueryResult() {
			this.threadLocal.set(new ArticleQueryResult());
		}

		/**
		 * <p>현재 동작 중인 Thread와 관련된 QueryResult 객체를 얻는다.</p>
		 *
		 * @return
		 */
		public ArticleQueryResult getQueryResult() {
			return this.threadLocal.get();
		}


		/** 현재 진행 중인 태그. */
		private String currentTag;

		/** 현재 진행 중인 record의 dbCode. */
		private String dbCode;

		/** 현재 진행 중인 record의 kistiID. */
		private String kistiID;

		/** 현재 진행 중인 ArticleInputData 객체. */
		private ArticleInputData inputData;

		/** 현재 진행 중인 NdslArticle 객체. */
		private NdslArticle article;

		/** 현재 진행 중인 NdslDissertation 객체. */
		private NdslDissertation dissertation;

		/** 현재 진행 중인 NdslJournal 객체. */
		private NdslJournal journal;

		/** 현재 진행 중인 자료 종류. */
		private RecordType recordType;

		/**
		 * @see org.xml.sax.helpers.DefaultHandler#startDocument()
		 */
		@Override
		public void startDocument() throws SAXException {
			prepareQueryResult();
		}

		/**
		 * @see org.xml.sax.helpers.DefaultHandler#endDocument()
		 */
		@Override
		public void endDocument() throws SAXException {
		}


		/**
		 * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String, java.lang.String, java.lang.String, org.xml.sax.Attributes)
		 */
		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes)
				throws SAXException {
			buff.delete(0,  buff.length());

			this.currentTag = qName;

			// System.out.printf("<%s>", qName);
			if ( "inputData".equals(qName) ) {
				this.inputData = new ArticleInputData();
			}
			/* record 태그. */
			else if ( "record".equals(qName) ) { // record
				this.dbCode  = attributes.getValue(uri, "dbCode");
				this.kistiID = attributes.getValue(uri, "kistiID");
			}
			else if ( "journalInfo".equals(qName) ) {
				this.recordType = RecordType.JOURNAL;
				this.journal = new NdslJournal();

				this.journal.setKistiID(attributes.getValue(uri, "kistiID"));
			}
			else if ( "articleInfo".equals(qName) ) {
				this.recordType = RecordType.ARTICLE;
				this.article = new NdslArticle();

				this.article.setDbCode(this.dbCode);
				this.article.setKistiID(attributes.getValue(uri, "kistiID"));
			}
			else if ( "dissertation".equals(qName) ) {
				this.recordType = RecordType.DISSERTATION;

				this.dissertation = new NdslDissertation();

				this.dissertation.setDbCode (this.dbCode );
				this.dissertation.setKistiID(this.kistiID);
			}
		}

		/**
		 * @see org.xml.sax.helpers.DefaultHandler#endElement(java.lang.String, java.lang.String, java.lang.String)
		 */
		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			if ( buff.indexOf("<![CDATA[") > -1 ) {
				buff.delete(0, buff.indexOf("<![CDATA[") + 9);
			}
			if ( buff.indexOf("]]>") > -1 ) {
				buff.delete(buff.indexOf("]]>"), buff.length());
			}

			setText(buff.toString());
			buff.delete(0,  buff.length());

			ArticleQueryResult queryResult = getQueryResult();

			if ( "inputData".equals(qName) ) {
				queryResult.setInputData(this.inputData);
			}
			else if ( "articleInfo".equals(qName) ) {
				this.article.setJournal(this.journal);
				queryResult.add(this.article);

				this.article = null;
				this.journal = null;
			}
			else if ( "dissertation".equals(qName) ) {
				queryResult.add(this.dissertation);

				this.dissertation = null;
			}

			this.currentTag = null;
		}


		private StringBuilder buff = new StringBuilder();

		/**
		 * @see org.xml.sax.helpers.DefaultHandler#characters(char[], int, int)
		 */
		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			buff.append(ch, start, length);
		}


		private void setText(String text) {
			if ( "".equals(text.trim()) ) return;

			// System.out.printf("%s%n", text);


			ArticleQueryResult queryResult = getQueryResult();


			/* resultSummary 태그. */
			if ( "totalCount".equals(this.currentTag) ) { // resultSummary/totalCount
				queryResult.setTotalCount(ValueUtil.parseInt(text, 10));
			}
			else if ( "processingTime".equals(this.currentTag) ) { // resultSummary/processingTime
				queryResult.setProcessingTime(ValueUtil.parseFloat(text));
			}
			/* inputData 태그. */
			else if ( "searchfield".equals(this.currentTag) ) { // inputData/searchfield
				this.inputData.setSearchField(text);
			}
			else if ( "responsegroup".equals(this.currentTag) ) { // inputData/responsegroup
				this.inputData.setResponseGroup(text);
			}
			else if ( "returntype".equals(this.currentTag) ) { // inputData/returntype
				this.inputData.setReturnType(text);
			}
			else if ( "target".equals(this.currentTag) ) { // inputData/target
				this.inputData.setTarget(text);
			}
			else if ( "displaycount".equals(this.currentTag) ) { // inputData/displaycount
				this.inputData.setDisplayCount(ValueUtil.parseInt(text));
			}
			else if ( "keyvalue".equals(this.currentTag) ) { // inputData/keyvalue
				this.inputData.setKeyValue(text);
			}
			else if ( "query".equals(this.currentTag) ) { // inputData/query
				this.inputData.setQuery(text);
			}
			else if ( "startposition".equals(this.currentTag) ) { // inputData/startposition
				this.inputData.setStartPosition(ValueUtil.parseInt(text));
			}
			else if ( "sortby".equals(this.currentTag) ) { // inputData/sortby
				this.inputData.setSortBy(text);
			}
			/* journalInfo 태그. */
			else if ( this.recordType == RecordType.JOURNAL ) {
				if ( "publisher".equals(this.currentTag) ) { // inputData/publisher
					this.journal.setPublisher(text);
				}
				else if ( "journalTitle".equals(this.currentTag) ) { // inputData/journalTitle
					this.journal.setTitle(text);
				}
				else if ( "issn".equals(this.currentTag) ) { // inputData/issn
					this.journal.addIssn(text);
				}
				else if ( "isbn".equals(this.currentTag) ) { // inputData/isbn
					this.journal.addIsbn(text);
				}
				else if ( "volume".equals(this.currentTag) ) { // inputData/volume
					this.journal.setVolume(text);
				}
				else if ( "issue".equals(this.currentTag) ) { // inputData/issue
					this.journal.setIssue(text);
				}
				else if ( "year".equals(this.currentTag) ) { // inputData/year
					this.journal.setYear(text);
				}
				else if ( "content_url".equals(this.currentTag) ) { // inputData/content_url
					this.journal.setContentUrl(text);
				}
				else if ( "urlflag".equals(this.currentTag) ) { // inputData/urlflag
					this.journal.setHasContent("2".equals(text));
				}
				else if ( "abstractflag".equals(this.currentTag) ) { // inputData/abstractflag
					this.journal.setHasAbstract("2".equals(text));
				}
				else if ( "holdingflag".equals(this.currentTag) ) { // inputData/holdingflag
					this.journal.setHasPaper("2".equals(text));
				}
			}
			/* articleInfo 태그. */
			else if ( this.recordType == RecordType.ARTICLE ) {
				if ( "articleTitle".equals(this.currentTag) ) { // record/articleInfo/articleTitle
					this.article.setTitle(text);
				}
				else if ( "abstract".equals(this.currentTag) ) { // record/articleInfo/abstract
					this.article.setAbstract(text);
				}
				else if ( "author".equals(this.currentTag) ) { // record/articleInfo/author
					this.article.addAuthor(text);
				}
				else if ( "content_url".equals(this.currentTag) ) { // record/articleInfo/content_url
					this.article.setContentUrl(text);
				}
				else if ( "urlflag".equals(this.currentTag) ) { // record/articleInfo/urlflag
					this.article.setHasContent("2".equals(text));
				}
				else if ( "abstractflag".equals(this.currentTag) ) { // record/articleInfo/abstractflag
					this.article.setHasAbstract("2".equals(text));
				}
				else if ( "page".equals(this.currentTag) ) { // record/articleInfo/page
					this.article.setPage(text);
				}
				else if ( "deeplink".equals(this.currentTag) ) { // record/articleInfo/deeplink
					this.article.setLinkForDesktop(text);
				}
				else if ( "mobilelink".equals(this.currentTag) ) { // record/articleInfo/mobilelink
					this.article.setLinkForMobile(text);
				}
				else if ( "sciencesub".equals(this.currentTag) ) { // record/articleInfo/sciencesub
				}
				else if ( "keyword".equals(this.currentTag) ) { // record/articleInfo/keyword
					this.article.addKeyword(text);
				}
			}
			/* dissertation 태그. */
			else if ( this.recordType == RecordType.DISSERTATION ) {
				if ( "schoolName".equals(this.currentTag) ) { // record/dissertation/schoolName
					this.dissertation.setSchoolName(text);
				}
				else if ( "degree".equals(this.currentTag) ) { // record/dissertation/degree
					this.dissertation.setDegree(text);
				}
				else if ( "year".equals(this.currentTag) ) { // record/dissertation/year
					this.dissertation.setYear(text);
				}
				else if ( "dissertationTitle".equals(this.currentTag) ) { // record/dissertation/dissertationTitle
					this.dissertation.setTitle(text);
				}
				else if ( "author".equals(this.currentTag) ) { // record/dissertation/author
					this.dissertation.addAuthor(text);
				}
				else if ( "keyword".equals(this.currentTag) ) { // record/dissertation/keyword
					this.dissertation.addKeyword(text);
				}
				else if ( "holdingPlace".equals(this.currentTag) ) { // record/dissertation/holdingPlace
					this.dissertation.setHoldingPlace(text);
				}
				else if ( "abstract".equals(this.currentTag) ) { // record/dissertation/abstract
					this.dissertation.setAbstract(text);
				}
				else if ( "page".equals(this.currentTag) ) { // record/dissertation/page
					this.dissertation.setPage(text);
				}
				else if ( "deeplink".equals(this.currentTag) ) { // record/dissertation/deeplink
					this.dissertation.setLinkForDesktop(text);
				}
			}
			/* 오류가 발생했을 경우. */
			else if ( "errorMasseage".equals(this.currentTag) ) {
				throw new NosException(text);
			}
		}
	}