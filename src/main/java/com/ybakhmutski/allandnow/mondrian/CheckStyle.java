package com.epam.allandnow.mondrian;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CheckStyle {

	static String input = "  private void writeHierarchyInfo(\r\n" + 
			"            SaxWriter writer,\r\n" + 
			"            List<Hierarchy> hierarchies,\r\n" + 
			"            List<Property> props)\r\n" + 
			"        {\r\n" + 
			"            writer.startSequence(null, \"HierarchyInfo\");\r\n" + 
			"            for (Hierarchy hierarchy : hierarchies) {\r\n" + 
			"                writer.startElement(\r\n" + 
			"                    \"HierarchyInfo\", \"name\", hierarchy.getName());\r\n" + 
			"                for (final Property prop : props) {\r\n" + 
			"                    if (prop instanceof IMondrianOlap4jProperty) {\r\n" + 
			"                        writeProperty(writer, hierarchy, prop);\r\n" + 
			"                    } else {\r\n" + 
			"                        writeElement(writer, hierarchy, prop);\r\n" + 
			"                    }\r\n" + 
			"                }\r\n" + 
			"                writer.endElement();\r\n" + 
			"            }\r\n" + 
			"            writer.endSequence(); // \"HierarchyInfo\"\r\n" + 
			"        }\r\n" + 
			"\r\n" + 
			"		private void writeProperty(SaxWriter writer, Hierarchy hierarchy,\r\n" + 
			"				final Property prop) {\r\n" + 
			"			IMondrianOlap4jProperty currentProperty =\r\n" + 
			"			    (IMondrianOlap4jProperty) prop;\r\n" + 
			"			String thisHierarchyName = hierarchy.getName();\r\n" + 
			"			String thatHierarchiName = currentProperty.getLevel()\r\n" + 
			"			    .getHierarchy().getName();\r\n" + 
			"			if (thisHierarchyName.equals(thatHierarchiName)) {\r\n" + 
			"			    writeElement(writer, hierarchy, prop);\r\n" + 
			"			}\r\n" + 
			"		}\r\n" + 
			"\r\n" + 
			"		private void writeElement(SaxWriter writer, Hierarchy hierarchy,\r\n" + 
			"				final Property prop) {\r\n" + 
			"			final String encodedProp = encoder\r\n" + 
			"			    .encode(prop.getName());\r\n" + 
			"			final Object[] attributes = getAttributes(\r\n" + 
			"			    prop, hierarchy);\r\n" + 
			"			writer.element(encodedProp, attributes);\r\n" + 
			"		}";

	public static void main(String[] args) {
		String result = input.replaceAll("\t", "    ");
		toConsole(result);
		// toFile(result);
	}

	private static void toConsole(String result) {
		System.out.println(result);

	}

	private static void toFile(String result) {
		PrintWriter out = null;
		try {
			out = new PrintWriter("d:/filename.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		out.println("dsaf");
	}

}
