package test;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import Demo.person;

public class beanUtilsDemo {

	public static void main(String[] args) {
		person p=new person();
		try {
			//每次为一个赋值
			BeanUtils.setProperty(p,"name","jack");
			BeanUtils.setProperty(p,"age",10);
			String name=BeanUtils.getProperty(p, "name");
			String age=BeanUtils.getProperty(p, "age");
			System.out.println(name+"111111"+age);
			//一次性赋多个值
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("name","tom");
			map.put("age", 11);
			BeanUtils.populate(p, map);
			System.out.print(p.getName()+"111111"+p.getAge());
			p.toString();
			System.out.print(p.toString());
		} catch (Exception  e) {
			e.printStackTrace();
		}
	}

}
