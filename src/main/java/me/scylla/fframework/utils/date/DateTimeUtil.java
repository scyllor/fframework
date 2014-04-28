package me.scylla.fframework.utils.date;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;

;

public class DateTimeUtil {
	private static final String[] fmts = new String[] { "yyyy-MM-dd HH:mm:ss",
			"yyyy-MM-dd HH:mm", "yyyy-MM-dd", };

	public static Date parse(String dateStr) {
		if (StringUtils.isEmpty(dateStr)) {
			return null;
		}
		try {
			return DateUtils.parseDate(dateStr, fmts);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String formatToDate(Date date) {
		return format(date, 2);
	}

	public static String formatToDateTime(Date date) {
		return format(date, 0);
	}

	private static String format(Date date, int fmtIdx) {
		if (date == null) {
			return null;
		}
		String fmt = fmts[fmtIdx];
		return DateFormatUtils.format(date, fmt);
	}
}