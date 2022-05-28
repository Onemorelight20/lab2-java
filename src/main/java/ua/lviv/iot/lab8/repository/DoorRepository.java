package ua.lviv.iot.lab8.repository;

import org.springframework.data.repository.CrudRepository;
import ua.lviv.iot.lab8.entity.Door;

public interface DoorRepository extends CrudRepository<Door, Long> {
}
