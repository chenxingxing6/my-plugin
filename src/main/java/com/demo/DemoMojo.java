package com.demo;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.util.List;

/**
 * User: lanxinghua
 * Date: 2019/3/11 10:17
 * Desc: maven插件
 */
//这里的cxx就为该插件的goal
@Mojo(name = "cxx", defaultPhase = LifecyclePhase.PACKAGE)
public class DemoMojo extends AbstractMojo {
    @Parameter
    private String msg;

    @Parameter
    private List<String> options;

    @Parameter(property = "args")
    private String args;

    public void execute() throws MojoExecutionException, MojoFailureException {
        System.out.println("my plugin  !!!" + msg);
        System.out.println("my plugin  !!!" + options);
        System.out.println("my plugin  !!!" + args);
    }
}
