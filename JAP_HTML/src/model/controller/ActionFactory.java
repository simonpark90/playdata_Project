package model.controller;

import controller.action.Action;
import controller.action.InsertAction;
import controller.action.SelectAction;

public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();
	
	private ActionFactory(){}
	
	public static ActionFactory getInstance(){
		return instance;
	}
	
	public Action getAction(String command){
		Action action = null;
		
		if(command.equals("insert")) {
			action = new InsertAction();
		}else if(command.equals("select")) {
			action = new SelectAction();
		}
		
		return action;
	}
}
