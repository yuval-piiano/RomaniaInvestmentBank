package rib.dao;

import java.util.List;

public interface EntityDao<Entity, No> {
	public Entity findByNo(int no);

	public void delete(Entity entity);

	public void deleteAll();
	
	public List<Entity> orderByCityAsc();

	public List<Entity> orderByCityDesc();

	public List<Entity> orderByNoAsc();

	public List<Entity> orderByNoDesc();

//	public List<Entity> orderByIdAsc();
//
//	public List<Entity> orderByIdDesc();
	
	public void persist(Entity entity);

	public List<Entity> showAll();
	
	public void update(Entity entity);
}
