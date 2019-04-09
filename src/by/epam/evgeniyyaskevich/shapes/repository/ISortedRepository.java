package by.epam.evgeniyyaskevich.shapes.repository;

import java.util.Comparator;

public interface ISortedRepository<T> extends IRepository<T>  {
    void sort(Comparator<? super T> comparator);
}