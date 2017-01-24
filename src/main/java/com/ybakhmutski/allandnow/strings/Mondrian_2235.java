package com.epam.allandnow.strings;

public class Mondrian_2235 {
public static void main(String[] args) {

	System.out.println(Mondrian_2235.getBaseToken("[All].[Territory].[APAC]"));
	System.out.println(Mondrian_2235.getBaseToken1("[All].[Territory].[APAC]"));
}

public static String getBaseToken( String member ) {
    return member.substring( member.lastIndexOf( '[' ) + 1, member.lastIndexOf( ']' ) );
}
public static String getBaseToken1( String member ) {
    return member.substring( member.lastIndexOf( '[' ), member.lastIndexOf( ']' ) + 1 );
}
}
