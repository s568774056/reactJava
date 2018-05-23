package routine.dao.impl;

public interface BaseDao<T> {

    int insert(T obj);
	int update(T obj);
}
