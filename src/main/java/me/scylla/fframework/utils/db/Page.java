package me.scylla.fframework.utils.db;

import java.util.List;

import me.scylla.fframework.model.entity.AbstractModuleEntity;

public class Page<E extends AbstractModuleEntity<E>> {
	private List<E> elems;// OUT
	private int totalCount = -1;// OUT
	private int pageNo = 0;// INOUT
	private int pageSize = 20;// IN
	private int offset = 0;// TEMP
	private int pageCount = -1;// OUT
	private String query;
	private String queryType;
	private String sortName = "id";
	private String sortOrder = "asc";

	private String ext;

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("Paging@").append(hashCode())
				.append("{").append("pageNo:").append(pageNo).append(",")
				.append(" pageSize:").append(pageSize).append(",")
				.append(" query:\"").append(query).append("\",")
				.append(" queryType:\"").append(queryType).append("\",")
				.append(" sortName:\"").append(sortName).append("\",")
				.append(" sortOrder:\"").append(sortOrder).append("\"")
				.append("}");
		return sb.toString();
	}

	public List<E> getElems() {
		return elems;
	}

	public void setElems(List<E> elems) {
		this.elems = elems;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return the offset
	 */
	public int getOffset() {
		return offset;
	}

	/**
	 * @param offset
	 *            the offset to set
	 */
	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public String getQuery() {
		if (query != null) {
			if (query.indexOf(",") > -1) {
				String[] values = query.split(",");
				boolean set = false;
				for (String value : values) {
					if (value != null && value.length() > 0) {
						query = value;
						set = true;
						break;
					}
				}
				if (!set) {
					query = "";
				}
			}
		}
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getQueryType() {
		return queryType;
	}

	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}

	public String getSortName() {
		return sortName;
	}

	public void setSortName(String sortName) {
		this.sortName = sortName;
	}

	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}
}