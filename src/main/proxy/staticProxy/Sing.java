package main.proxy.staticProxy;

/**
 * 需要增强的目标类，target
 * Created by chenbin on 2019\11\15 0015.
 */
public class Sing implements ISing {

    @Override
    public void folkMusic() {
        System.out.println("Folk music.海阔天空");
    }
}
