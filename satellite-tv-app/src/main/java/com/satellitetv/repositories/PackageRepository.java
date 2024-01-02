package com.satellitetv.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PackageRepository extends JpaRepository<Package , Long>
{
    Optional<Package> findById(Long id);
}
