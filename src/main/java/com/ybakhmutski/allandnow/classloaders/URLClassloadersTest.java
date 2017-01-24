package com.epam.allandnow.classloaders;

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;
import java.util.Properties;

public class URLClassloadersTest {

  public static void main( String[] args ) throws Exception, ClassNotFoundException, MalformedURLException {
 /*   URL classUrl;
    classUrl = new URL( "file:///home/kent/eclipsews/SmallExample/bin/IndependentClass.class" );
    URL[] classUrls = { classUrl };
    URLClassLoader ucl = new URLClassLoader( classUrls );
    Class c = ucl.loadClass( "IndependentClass" ); // LINE 14
    for ( Field f : c.getDeclaredFields() ) {
      System.out.println( "Field name" + f.getName() );
    }*/
    
    
   /* URL classUrl;
    
    String url="file:///d:/sp_1549_test/pentaho/ojdbc6.jar";
    
    classUrl = new URL(url );//"file:///home/kent/eclipsews/SmallExample/bin/IndependentClass.class" );
    
    System.out.println("classUrl.getPath(): "+classUrl.getFile());
    
    URL[] classUrls = { classUrl };
    URLClassLoader ucl = new URLClassLoader( classUrls );
    Class c = ucl.loadClass( "OracleDriver" ); // LINE 14
    for ( Field f : c.getDeclaredFields() ) {
      System.out.println( "Field name" + f.getName() );
    }*/
    doCool();
  }

  private static void doCool() throws Exception{
    String javaHome = System.getProperty( "java.home" );
    System.out.println("javaHome: "+javaHome);
    String sqoop =
        javaHome + File.separator + ".." + File.separator+ ".." + File.separator + "test" + File.separator + "sqoop" + File.separator
            + "ojdbc6.jar";
    
    String pentaho =
        javaHome + File.separator + ".." + File.separator+ ".." + File.separator + "test" + File.separator + "pentaho" + File.separator
            + "ojdbc6.jar";
    
    
    System.out.println("sqoop: "+sqoop);
    
    System.out.println("pentaho: "+pentaho);
    
    URLClassLoader loader = new URLClassLoader( new URL[] { new File( sqoop ).toURI().toURL(), new File( pentaho ).toURI().toURL() } );
    
    String className = "com.sun.tools.attach.VirtualMachine";
    
    className = "oracle.jdbc.OracleDriver";
    
    Class virtualMachine = Class.forName( className, true, loader );
    
    /*Class virtualMachineDescriptor = Class.forName( "com.sun.tools.attach.VirtualMachineDescriptor", true, loader );
    Method getVMList = virtualMachine.getMethod( "list", (Class[]) null );
    Method attachToVM = virtualMachine.getMethod( "attach", String.class );
    Method getAgentProperties = virtualMachine.getMethod( "getAgentProperties", (Class[]) null );
    Method getVMId = virtualMachineDescriptor.getMethod( "id", (Class[]) null );
    List allVMs = (List) getVMList.invoke( null, (Object[]) null );*/
    
/*    for ( Object vmInstance : allVMs ) {
      String id = (String) getVMId.invoke( vmInstance, (Object[]) null );
      if ( id.equals( Integer.toString( pid ) ) ) {
        Object vm = attachToVM.invoke( null, id );  
        Properties agentProperties = (Properties) getAgentProperties.invoke( vm, (Object[]) null );
        String connectorAddress = agentProperties.getProperty( CONNECTOR_ADDRESS );
        if ( connectorAddress != null ) {
          return connectorAddress;
        }

      }
    }*/
  }
}
