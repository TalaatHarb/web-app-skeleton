package net.talaatharb.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.talaatharb.webapp.domain.Resource;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {
}
