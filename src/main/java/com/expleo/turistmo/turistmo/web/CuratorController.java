package com.expleo.turistmo.turistmo.web;


import com.expleo.turistmo.turistmo.domain.Curator;
import com.expleo.turistmo.turistmo.domain.Package;
import com.expleo.turistmo.turistmo.repository.PackageRepository;
import com.expleo.turistmo.turistmo.services.CuratorService;
import com.expleo.turistmo.turistmo.services.PackageService;
import com.expleo.turistmo.turistmo.web.request.SavePackageRequest;
import com.expleo.turistmo.turistmo.web.response.PackageResponse;
import com.expleo.turistmo.turistmo.web.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/v1/curator")
@RequiredArgsConstructor
public class CuratorController {

    private final CuratorService curatorService;
    private final PackageService packageService;

    //få alla paket som tillhör curator

    @GetMapping
    @PreAuthorize("hasAuthority('CURATOR')")
    public ResponseEntity<?> getAllPackagesBelongingToCurator() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        try {
            Curator curator = curatorService.findCuratorByEmail(email);
            return ResponseEntity.status(OK).body(curator);
        } catch (Exception e) {
            throw new ResponseStatusException(BAD_REQUEST, e.getMessage());
        }
    }

    //skapa ett paket

    @PostMapping("/save")
    @PreAuthorize("hasAuthority('CURATOR')")
    public ResponseEntity<?> savePackagesBelongingToCurator(@Valid @RequestBody SavePackageRequest savePackage) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        try {
            Curator curator = curatorService.findCuratorByEmail(email);
            curatorService.saveCuratorPackages(curator, savePackage);
            return new ResponseEntity<>(
                    new Response("Package is created successfully!"),
                    CREATED);
        } catch (Exception e) {
            throw new ResponseStatusException(BAD_REQUEST, e.getMessage());
        }
    }

    //ta bort ett paket
    @DeleteMapping("/delete")
    @PreAuthorize("hasAuthority('CURATOR')")
    //public ResponseEntity<?> deletePackageBelongingToCurator(@RequestBody Package deletePackage) {
    public ResponseEntity<?> deletePackageBelongingToCurator(@RequestParam UUID uuid) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        try {
            Curator findCurator = curatorService.findCuratorByEmail(email);
            Package findPackage = packageService.getPackageByGuid(uuid);
            curatorService.deleteCuratorPackageFromPackageGuid(findCurator, findPackage);
            return new ResponseEntity<>(
                    new Response("Package is deleted successfully!"),
                    OK);
        } catch (Exception e) {
            throw new ResponseStatusException(BAD_REQUEST, e.getMessage());
        }
    }

    //redigera paket
}
