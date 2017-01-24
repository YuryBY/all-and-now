package com.epam.allandnow.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListToString {
	public static void main(String[] args) {
		constructFirstList();
		constructSecondList();
	}

	private static List constructSecondList() {
		List result = new ArrayList();

		String methodElement = "[Consumption Method].[PVR]";
		String measuresElement = "[Measures].[Average Timeshift]";

		String[] timeArray = { "00:00", "14:00", "15:00", "16:00", "23:00" };

		String[] dateArray = { "2014-07-25", "2014-07-26", "2014-07-27",
				"2014-07-28" };

		for (int i = 0; i < dateArray.length; i++) {
			String dateElement = "[Consumption Date.Calendar].[" + dateArray[i]
					+ "]";
			for (int j = 0; j < timeArray.length; j++) {
				String timeElement = "[Consumption Time.Time].[" + timeArray[j]
						+ "]";

				String[] brickArray = { dateElement, methodElement,
						measuresElement, timeElement };
				result.add(Arrays.asList(brickArray));
				// System.out.println(result + "lenth:" + result.size());
			}
		}
		return result;
	}

	private static List constructFirstList() {
		List result = new ArrayList();

		String methodElement = "[Consumption Method].[PVR]";
		String measuresElement = "[Measures].[Total Viewing Time]";

		String[] timeArray = { "00:00", "14:00", "15:00", "16:00", "23:00" };

		String[] dateArray = { "2014-07-25", "2014-07-26", "2014-07-27",
				"2014-07-28" };

		for (int i = 0; i < dateArray.length; i++) {
			String dateElement = "[Consumption Date.Calendar].[" + dateArray[i]
					+ "]";
			for (int j = 0; j < timeArray.length; j++) {
				String timeElement = "[Consumption Time.Time].[" + timeArray[j]
						+ "]";

				String[] brickArray = { dateElement, methodElement,
						measuresElement, timeElement };
				result.add(Arrays.asList(brickArray));
				// System.out.println(result + "lenth:" + result.size());
			}
		}
		return result;
	}
}
