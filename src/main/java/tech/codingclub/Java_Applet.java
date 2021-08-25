package tech.codingclub;

// A Hello World Applet
// Save file as HelloWorld.java

import java.applet.*;
import java.awt.*;

public class Java_Applet extends Applet
{
    // Overriding paint() method
    @Override
    public void paint( Graphics g )
    {
        // call superclass version of method paint
        super.paint( g );
        // draw a String at x-coordinate 25 and y-coordinate 25
        g.drawString( "Welcome to Java Programming!", 25, 25 );
    }
}
/*
<applet code="Java_Applet" width=200 height=60>
</applet>
*/