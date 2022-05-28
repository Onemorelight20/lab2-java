package ua.lviv.iot.lab8.service;

import ua.lviv.iot.lab8.entity.Door;

import java.util.Optional;

public interface DoorService {

    Iterable<Door> getAll();

    Optional<Door> getById(Long id);

    void save(Door door);

    void delete(Long id);
}
