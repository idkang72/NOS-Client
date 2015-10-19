package net.waglewagle.nos;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class JaxpTest1 {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		DefaultHandler handler = new NdslHandler();

		InputStream is = JaxpTest1.class.getResourceAsStream("/ndsl-result.xml");

		SAXParserFactory factory = SAXParserFactory.newInstance();

		SAXParser parser = factory.newSAXParser();

		parser.parse(is, handler);
	}


	static class NdslHandler extends DefaultHandler {

		/* (non-Javadoc)
		 * @see org.xml.sax.helpers.DefaultHandler#startDocument()
		 */
		@Override
		public void startDocument() throws SAXException {
			System.out.println("시작 =====================");
		}

		/* (non-Javadoc)
		 * @see org.xml.sax.helpers.DefaultHandler#endDocument()
		 */
		@Override
		public void endDocument() throws SAXException {
			System.out.println("===================== 종료");
		}

		/* (non-Javadoc)
		 * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String, java.lang.String, java.lang.String, org.xml.sax.Attributes)
		 */
		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes)
				throws SAXException {
			System.out.printf("<%s:%s - %s>%n",qName,uri, localName);

			for (int i = 0; i < attributes.getLength(); i++) {
				System.out.printf("   @%s:%s - %s%n", attributes.getQName(i), attributes.getLocalName(i), attributes.getValue(i));
			}
		}

		/* (non-Javadoc)
		 * @see org.xml.sax.helpers.DefaultHandler#endElement(java.lang.String, java.lang.String, java.lang.String)
		 */
		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			System.out.printf("</%s:%s - %s>%n",qName,uri, localName);
		}

		/* (non-Javadoc)
		 * @see org.xml.sax.helpers.DefaultHandler#characters(char[], int, int)
		 */
		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			System.out.printf("<![CDATA[%s]]>%n", new String(ch, start, length));
		}
	}
}
