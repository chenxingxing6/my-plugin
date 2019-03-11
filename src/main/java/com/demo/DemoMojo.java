package com.demo;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;

/**
 * User: lanxinghua
 * Date: 2019/3/11 10:17
 * Desc: maven插件
 */
//这里的cxx就为该插件的goal
@Mojo(name = "cxx", defaultPhase = LifecyclePhase.PACKAGE)
public class DemoMojo extends AbstractMojo {

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException{
        System.out.println("maven插件");
    }
}
