package com.sms.genericutility;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class ITransform implements IAnnotationTransformer{

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		// TODO Auto-generated method stub
	//	IAnnotationTransformer.super.transform(annotation, testClass, testConstructor, testMethod);
	annotation.setRetryAnalyzer(com.sms.genericutility.RetryImplementation.class);
	}
	
}
