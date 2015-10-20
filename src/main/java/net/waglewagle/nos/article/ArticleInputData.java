package net.waglewagle.nos.article;

import net.waglewagle.nos.InputData;

/**
 * <p>NDSL 논문 검색 요청 정보를 담고 있는 클래스.</p>
 *
 * @author 강신원
 * @since 2015. 10. 20
 */
public class ArticleInputData extends InputData {
	/** 검색대상 필드. */
	private SearchField searchField;

	/** 검색결과 출력 범위. */
	private ResponseGroup responseGroup;

	/** 검색결과 형식. */
	private ReturnType returnType;

	/** 검색대상 콘텐츠. */
	private Target target;

	/** 정렬항목: 기본값 정확도. */
	private SortBy sortBy;


	/**
	 * @return the searchField
	 */
	public SearchField getSearchField() {
		return searchField;
	}

	/**
	 * @param searchField the searchField to set
	 */
	public void setSearchField(String searchField) {
		this.searchField = SearchField.valueOf(searchField);
	}


	/**
	 * @param searchField the searchField to set
	 */
	public void setSearchField(SearchField searchField) {
		this.searchField = searchField;
	}


	/**
	 * @return the responseGroup
	 */
	public ResponseGroup getResponseGroup() {
		return responseGroup;
	}

	/**
	 * @param responseGroup the responseGroup to set
	 */
	public void setResponseGroup(ResponseGroup responseGroup) {
		this.responseGroup = responseGroup;
	}

	/**
	 * @param responseGroup the responseGroup to set
	 */
	public void setResponseGroup(String responseGroup) {
		this.responseGroup = ResponseGroup.find(responseGroup);
	}

	/**
	 * @return the returnType
	 */
	public ReturnType getReturnType() {
		return returnType;
	}

	/**
	 * @param returnType the returnType to set
	 */
	public void setReturnType(ReturnType returnType) {
		this.returnType = returnType;
	}

	/**
	 * @param returnType the returnType to set
	 */
	public void setReturnType(String returnType) {
		this.returnType = ReturnType.find(returnType);
	}

	/**
	 * @return the target
	 */
	public Target getTarget() {
		return target;
	}

	/**
	 * @param target the target to set
	 */
	public void setTarget(Target target) {
		this.target = target;
	}

	/**
	 * @param target the target to set
	 */
	public void setTarget(String target) {
		this.target = Target.valueOf(target);
	}

	/**
	 * @return the sortBy
	 */
	public SortBy getSortBy() {
		return sortBy;
	}


	/**
	 * @param sortBy the sortBy to set
	 */
	public void setSortBy(SortBy sortBy) {
		this.sortBy = sortBy;
	}


	/**
	 * @param sortBy the sortBy to set
	 */
	public void setSortBy(String sortBy) {
		this.sortBy = SortBy.find(sortBy);
	}

}
