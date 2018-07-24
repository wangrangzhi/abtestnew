package main.repository;

import main.domain.soldproduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface soldRepository extends JpaRepository<soldproduct, Integer> {
}
