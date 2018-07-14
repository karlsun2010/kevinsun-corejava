package com.kevinsun.corejava.thread.day20180714;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Test01 {

	public static Map m = Collections.synchronizedMap(new HashMap());
	public static List linkedLis= Collections.synchronizedList(new LinkedList()); 
    public static List ArrayList = Collections.synchronizedList(new java.util.ArrayList()); 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map map = new ConcurrentHashMap();
	}

}
