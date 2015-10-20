package net.waglewagle.nos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class QueryResultBase<I extends InputData, E> implements QueryResult<I, E> {

	/** 전체 검색 건수. */
	private int totalCount;

	/** 현재 검색결과 페이지 번호. */
	private int pageNo;

	/** 처리시간. */
	private float processingTime;

	/** 검색 요청 파라미터. */
	private I inputData;

	/** 검색 결과 레코드. */
	private List<E> recordList;

	public void add(E record) {
		if ( this.recordList == null ) {
			this.recordList = new ArrayList<E>();
		}

		this.recordList.add(record);
	}

	public Iterator<E> iterator() {
		return this.recordList == null
				? getEmptyIterator()
				: this.recordList.iterator();
	}

	public int getCount() {
		return this.recordList == null ? 0 : this.recordList.size();
	}

	/**
	 * @return the totalCount
	 */
	public int getTotalCount() {
		return totalCount;
	}

	/**
	 * @param totalCount the totalCount to set
	 */
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	/**
	 * @return the pageNo
	 */
	public int getPageNo() {
		return pageNo;
	}

	/**
	 * @param pageNo the pageNo to set
	 */
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	/**
	 * @return the processingTime
	 */
	public float getProcessingTime() {
		return processingTime;
	}

	/**
	 * @param processingTime the processingTime to set
	 */
	public void setProcessingTime(float processingTime) {
		this.processingTime = processingTime;
	}

	/**
	 * @return the inputData
	 */
	public I getInputData() {
		return inputData;
	}

	/**
	 * @param inputData the inputData to set
	 */
	public void setInputData(I inputData) {
		this.inputData = inputData;
	}


	private Iterator<E> emptyIterator = Collections.<E>emptyList().iterator();

	protected Iterator<E> getEmptyIterator() {
		return this.emptyIterator;
	}
}
