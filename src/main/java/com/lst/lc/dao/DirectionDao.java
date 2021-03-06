package com.lst.lc.dao;

import java.util.List;

import com.lst.lc.entities.Direction;

public interface DirectionDao {

	public void addDirection(Direction direction);

	public Direction getDirection(int id);

	public List<Direction> getAllDirections();

	public void update(int directionId, String name, String description,
			String enabled);

	public void delete(int directionId);
	
	public List<Direction> getEnabledDirections();
	
	public Direction getDirectionByName(String name);
	
}
