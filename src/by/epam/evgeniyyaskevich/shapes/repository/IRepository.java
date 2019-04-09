package by.epam.evgeniyyaskevich.shapes.repository;

public interface IRepository<T> {

    boolean add(T obj);

    boolean remove(T obj);

    boolean replace(T oldObj, T newObj);
}