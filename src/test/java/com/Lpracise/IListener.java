package com.Lpracise;

public interface IListener {
	
	void duringTest();
	
	void aftertest();
	
	void beforetest();
	
	default void generatetest() {

}}
