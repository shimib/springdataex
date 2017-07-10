package com.example.bigproj.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.AbstractEndpoint;
import org.springframework.stereotype.Component;

import com.example.bigproj.daos.GeneralDAO;

@Component
public class TableNamesEndpoint extends AbstractEndpoint<List<String>>{

	private final GeneralDAO dao;
	private final List<String> additional = new ArrayList<>();
	
	@Autowired
	public TableNamesEndpoint(GeneralDAO dao) {
		super("showtables");
		this.dao = dao;
	}


	@Override
	public List<String> invoke() {
		List<String> result = new ArrayList<>();
		result.addAll(dao.getAllDBNames());
		result.addAll(additional);
		return result;
	}

	public void addTable(String name) {
		additional.add(name);
	}
	
}
