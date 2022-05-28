package ua.lviv.iot.lab8.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.lviv.iot.lab8.entity.Door;
import ua.lviv.iot.lab8.repository.DoorRepository;
import ua.lviv.iot.lab8.service.DoorService;


import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DoorServiceImpl implements DoorService {

    private final DoorRepository doorRepository;

    @Override
    public Iterable<Door> getAll() {
        return doorRepository.findAll();
    }

    @Override
    public Optional<Door> getById(Long id) {
        return doorRepository.findById(id);
    }

    @Override
    public void save(Door door) {
        doorRepository.save(door);
    }


    @Override
    public void delete(Long id) {
        doorRepository.deleteById(id);
    }
}
