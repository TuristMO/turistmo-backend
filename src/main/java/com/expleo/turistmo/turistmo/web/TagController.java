package com.expleo.turistmo.turistmo.web;

import com.expleo.turistmo.turistmo.domain.Application;

import com.expleo.turistmo.turistmo.domain.Tag;
import com.expleo.turistmo.turistmo.services.ApplicationService;
import com.expleo.turistmo.turistmo.services.CuratorService;
import com.expleo.turistmo.turistmo.services.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/v1/tag")
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;
    private final CuratorService curatorService;

    @GetMapping
//    @PreAuthorize("hasAuthority('CURATOR')")
    public ResponseEntity<?> findAllTags(@RequestParam(defaultValue = "0") Integer page,
                                                 @RequestParam(defaultValue = "10") Integer size) {
        try {
//            String email = SecurityContextHolder.getContext().getAuthentication().getName();

            Page<Tag> allTags = tagService.getAllTags(page, size);
            return ResponseEntity.status(HttpStatus.OK).body(allTags);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
