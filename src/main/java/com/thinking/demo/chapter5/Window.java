package com.thinking.demo.chapter5;

/**
 * ~~~~~~~~~~
 *
 * @author Alphonse
 * @date 2019/10/16 15:51
 * @since 1.0
 **/
public class Window {
    Window(int maker) {
        System.out.println("Window(" + maker + ")");
    }

    protected void finalize(){
        System.out.println("Window cleanup!");
    }
}
