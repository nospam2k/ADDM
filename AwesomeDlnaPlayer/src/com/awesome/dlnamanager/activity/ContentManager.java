package com.awesome.dlnamanager.activity;

import com.awesome.dlnamanager.upnp.MediaItem;

import java.util.List;
import java.util.Stack;


public class ContentManager {

	private static ContentManager mInstance = null;
	
	private Stack<List<MediaItem>> mStack;
	
	public synchronized static ContentManager getInstance(){
		if (mInstance == null){
			mInstance =  new ContentManager();
		}
		
		return mInstance;
	}
	
	private ContentManager()
	{
		mStack = new Stack<List<MediaItem>>();
	}
	
	public void pushListItem(List<MediaItem> dataList)
	{
		if (dataList != null)
			mStack.add(dataList);
	}
	
	public List<MediaItem> peekListItem()
	{
		if (mStack.empty()){
			return null;
		}
		
		return mStack.peek();
	}
	
	public List<MediaItem> popListItem()
	{
		if (mStack.empty()){
			return null;
		}
		
		return mStack.pop();
	}
	
	public void clear()
	{
		mStack.clear();
	}
	
	
}
