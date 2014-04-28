package me.scylla.fframework.utils.date;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;

public class DateTimeEditor extends PropertyEditorSupport {
	final private String[] fmts = new String[] { "yyyy-MM-dd HH:mm:ss",
			"yyyy-MM-dd", };

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.beans.PropertyEditorSupport#getAsText()
	 */
	@Override
	public String getAsText() {
		Date value = (Date) getValue();
		if (value == null) {
			return null;
		}
		return DateFormatUtils.format(value, "yyyy-MM-dd");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.beans.PropertyEditorSupport#setAsText(java.lang.String)
	 */
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if (text == null || text.length() == 0) {
			setValue(null);
		} else {
			try {
				setValue(DateUtils.parseDate(text, fmts));
			} catch (ParseException ex) {
				throw new IllegalArgumentException("Could not parse date: "
						+ ex.getMessage(), ex);
			}
		}
	}

}