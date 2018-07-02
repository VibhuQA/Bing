package com.qait.maven.bingTranslator;

public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
        System.out.println( "Hello World!" );
        Bing bng = new Bing();
        bng.launchBrowser();
        //bng.openText();
        bng.searchBox();
        bng.drop_down1();
        bng.set_text();
        Thread.sleep(2000);
        bng.interchange();
        bng.shareIcon();
        bng.charCount();
    }
}
