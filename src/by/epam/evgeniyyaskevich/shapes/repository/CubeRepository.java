package by.epam.evgeniyyaskevich.shapes.repository;

import by.epam.evgeniyyaskevich.shapes.entity.Cube;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CubeRepository implements ISortedRepository<Cube> {

    private static final Logger LOGGER = LogManager.getLogger(CubeRepository.class);
    private List<Cube> members = new LinkedList<>();


    public List<Cube> getListOfMembers() {
        return members;
    }

    public List<Cube> searchGroup(Predicate<Cube> predicate) {
        return members.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public Cube searchFirst(Predicate<Cube> predicate) {
        for (Cube cube : members) {
            if (predicate.test(cube)) {
                return cube;
            }
        }
        LOGGER.warn("Nothing is found.");
        return null;
    }

    public void clear() {
        members.clear();
    }

    @Override
    public void sort(Comparator<? super Cube> comparator) {
        members.sort(comparator);
    }

    @Override
    public boolean add(Cube obj) {
        return  members.add(obj);
    }

    @Override
    public boolean remove(Cube obj) {
        return members.remove(obj);
    }

    @Override
    public boolean replace(Cube oldObj, Cube newObj) {
        members.remove(oldObj);
        return members.add(newObj);
    }
}
