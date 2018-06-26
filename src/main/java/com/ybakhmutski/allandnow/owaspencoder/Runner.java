package com.ybakhmutski.allandnow.owaspencoder;

import org.owasp.html.PolicyFactory;
import org.owasp.html.Sanitizers;

/**
 * Created by Yury_Bakhmutski on 8/10/2016.
 */
public class Runner {

  public static void main(String[] args ) {

    sanitize();

  }

  private static void sanitize() {
    PolicyFactory formatingAndBlockssanitizer = Sanitizers.FORMATTING.and(Sanitizers.BLOCKS);
       System.out.println( formatingAndBlockssanitizer.sanitize( "<p>Hello, <b>World!</b>" ) );
    //System.out.println("<p>Hello, <b>World!</b>\n"+formatingAndBlockssanitizer.sanitize("<p>Hello, <b>World!</b>"));
    PolicyFactory linksSanitizer = Sanitizers.LINKS;
    System.out.println(linksSanitizer.sanitize("<a href=\"url\">link text</a>"));
    PolicyFactory formattingSanitizer = Sanitizers.FORMATTING;
    System.out.println(formattingSanitizer.sanitize("<a href=\"url\">link text</a>"));
    PolicyFactory blocksSanitizer = Sanitizers.BLOCKS;
    System.out.println(blocksSanitizer.sanitize("<a href=\"url\">link text</a>"));

    System.out.println(formatingAndBlockssanitizer.sanitize("<a 1href=\"url\">2link text</a3>"));

    System.out.println(formatingAndBlockssanitizer.sanitize("db_con_3306"));

    System.out.println(formatingAndBlockssanitizer.sanitize("<a href=\"url\">link text"));
  }

  private static void sanitize1() {

    PolicyFactory policy = Sanitizers.FORMATTING.and( Sanitizers.LINKS );
    String untrustedHTML = "<font color=\"red\">\"AAAAAAAAAAAA\"";
    untrustedHTML = "<input type=\"button\" onClick=\"dangerous code\">";
    System.out.println( "untrustedHTML: " + untrustedHTML );
    String safeHTML = policy.sanitize( untrustedHTML );
    System.out.println( "safeHTML:      " + safeHTML );
  }
}
