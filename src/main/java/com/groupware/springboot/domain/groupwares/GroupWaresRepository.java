package com.groupware.springboot.domain.groupwares;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface GroupWaresRepository extends JpaRepository<GroupWares, Long> {

}
