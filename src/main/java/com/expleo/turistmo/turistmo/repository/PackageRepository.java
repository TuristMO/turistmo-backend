package com.expleo.turistmo.turistmo.repository;

import com.expleo.turistmo.turistmo.domain.Application;
import com.expleo.turistmo.turistmo.domain.Package;
import com.expleo.turistmo.turistmo.domain.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PackageRepository extends JpaRepository<Package, Long> {

    @Query("SELECT e FROM Package e WHERE LOWER(e.city) = LOWER(?1)")
    Page<Package> findByCity(String city, Pageable pageable);

    @Query("select pack FROM Package pack JOIN pack.usefulApplications u WHERE u = (?1)")
    Page<Package> findAllByApplications(Application application, Pageable pageable);

    @Query("select pack FROM Package pack JOIN pack.usefulApplications u WHERE LOWER(u.title) = LOWER(?1)")
    Page<Package> findAllByApplicationTitle(String applicationTitle, Pageable pageable);

    @Query("select pack FROM Package pack JOIN pack.tags u WHERE u = (?1)")
    Page<Package> findAllByTags(Tag searchTag, Pageable pageable);

    @Query("select pack FROM Package pack JOIN pack.tags u WHERE LOWER(u.title) = LOWER(?1)")
    Page<Package> findAllByTagsTitle(String searchTag, Pageable pageable);

}
