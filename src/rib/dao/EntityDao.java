package rib.dao;

import java.util.List;

public interface EntityDao<Entity, No> {

	public void delete(Entity entity);

	public void deleteAll();
	
	public List<Entity> orderByCityAsc();

	public List<Entity> orderByCityDesc();

	public List<Entity> orderByNoAsc();

	public List<Entity> orderByNoDesc();
	
	public void persist(Entity entity);

	public List<Entity> showAll();
}
