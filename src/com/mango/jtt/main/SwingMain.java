package com.mango.jtt.main;

import com.mango.jtt.swing.FreightSwing;
import com.mango.jtt.util.FileUtil;


/**
 * @author HHL
 * @data 2016年8月14日
 * main程序
 * 
 */
public class SwingMain {

	public static void main(String args[]) {
		//初始化数据
		FileUtil.initData();
		//启动系统
		new FreightSwing("JTT卷烟运费计算系统");
	}

}
