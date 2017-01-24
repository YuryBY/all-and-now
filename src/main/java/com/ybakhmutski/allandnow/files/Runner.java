package com.epam.allandnow.files;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Yury_Bakhmutski on 4/7/2016.
 */
public class Runner {
  public static void main(String[] args) {
    try {

      //String content = "This is the content to write into file";

      String start = "d:/files/cn=report author";
      String end = ".ldif";

      for ( int i = 0; i < 500; i++ ) {
        int digit = 5000;
        digit = digit + i;
        String content = "dn: cn=Report Author" + i +"\n"
            + "l: Orlando\n" + "objectClass: organizationalRole\n" + "objectClass: top\n"
            + "description: Development Manager\n" + "roleOccupant: uid=tiffany,ou=Users,dc=pentaho,dc=org\n"
            + "cn: Report Author" + i + "\n"
            + "structuralObjectClass: organizationalRole\n"
            + "entryUUID: 61547550-cfa7-4b1d-bbaf-308e71d9" + digit + "\n"
            + "creatorsName: cn=Manager,dc=pentaho,dc=org\n" + "createTimestamp: 20140806123303Z\n"
            + "entryCSN: 20140806123303.782696Z#000000#000#000000\n" + "modifiersName: cn=Manager,dc=pentaho,dc=org\n"
            + "modifyTimestamp: 20140806123303Z\n";
        String pathname = start + i + end;

        File file = new File( pathname );

        // if file doesnt exists, then create it
        if (!file.exists()) {
          file.createNewFile();
        }

        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(content);
        bw.close();

        System.out.println( "Done " + i );
      }




    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
