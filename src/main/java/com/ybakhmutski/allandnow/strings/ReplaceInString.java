package com.epam.allandnow.strings;

public class ReplaceInString {
static	String input ="select \"time_by_day\".\"the_year\" as \"c0\", \"time_by_day\".\"quarter\" as \"c1\", \"time_by_day\".\"month_of_year\" as \"c2\", \"time_by_day\".\"the_date\" as \"c3\", \r\n" + 
			"\"customer\".\"state_province\" as \"c4\", \"customer\".\"city\" as \"c5\", \"customer\".\"education\" as \"c6\", \"customer\".\"gender\" as \"c7\", sum(\"sales_fact_1997\".\"unit_sales\")\r\n" + 
			" as \"m0\" from \"time_by_day\" \"time_by_day\", \"sales_fact_1997\" \"sales_fact_1997\", \"customer\" \"customer\" where \"sales_fact_1997\".\"time_id\" = \"time_by_day\".\"time_id\"\r\n" + 
			" and \"time_by_day\".\"the_year\" = 1997 and \"time_by_day\".\"the_date\" in ('1997-01-01', '1997-01-06', '1997-01-12', '1997-01-14', '1997-01-17', '1997-01-19', '1997-01-20',\r\n" + 
			" '1997-02-05', '1997-02-07', '1997-02-12', '1997-02-16', '1997-02-17', '1997-02-25', '1997-03-02', '1997-03-10', '1997-03-13', '1997-03-20', '1997-03-21', '1997-03-24',\r\n" + 
			" '1997-03-30', '1997-04-04', '1997-04-07', '1997-04-13', '1997-04-14', '1997-04-16', '1997-04-20', '1997-04-22', '1997-04-27', '1997-05-01', '1997-05-09', '1997-05-10',\r\n" + 
			" '1997-05-16', '1997-05-18', '1997-05-21', '1997-06-05', '1997-06-07', '1997-06-12', '1997-06-14', '1997-06-15', '1997-06-21', '1997-06-22', '1997-06-29', '1997-07-05', \r\n" + 
			"'1997-07-10', '1997-07-14', '1997-07-17', '1997-07-20', '1997-07-23', '1997-07-28', '1997-08-01', '1997-08-04', '1997-08-05', '1997-08-07', '1997-08-17', '1997-08-26', \r\n" + 
			"'1997-08-28', '1997-08-30', '1997-09-05', '1997-09-06', '1997-09-09', '1997-09-10', '1997-09-19', '1997-10-07', '1997-10-13', '1997-10-15', '1997-10-19', '1997-10-20', \r\n" + 
			"'1997-10-22', '1997-10-24', '1997-10-27', '1997-11-01', '1997-11-02', '1997-11-07', '1997-11-08', '1997-11-10', '1997-11-13', '1997-11-18', '1997-11-21', '1997-11-26', \r\n" + 
			"'1997-12-01', '1997-12-02', '1997-12-04', '1997-12-13', '1997-12-16', '1997-12-19', '1997-12-20', '1997-12-29') and \"sales_fact_1997\".\"customer_id\" = \r\n" + 
			"\"customer\".\"customer_id\" and \"customer\".\"state_province\" = 'CA' and \"customer\".\"city\" = 'Altadena' group by \"time_by_day\".\"the_year\", \"time_by_day\".\"quarter\",\r\n" + 
			" \"time_by_day\".\"month_of_year\", \"time_by_day\".\"the_date\", \"customer\".\"state_province\", \"customer\".\"city\",\r\n" + 
			" \"customer\".\"education\", \"customer\".\"gender\"";
	public static void main(String[] args) {
		System.out.println(input.replace("\"", ""));
	}


}
