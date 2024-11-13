package br.com.rezende.spanner.liquibase.repository;

import br.com.rezende.spanner.liquibase.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StatusRepository extends JpaRepository<Status, UUID> {
}