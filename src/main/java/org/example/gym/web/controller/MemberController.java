package org.example.gym.web.controller;

import org.example.gym.domain.Member;
import org.example.gym.domain.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService service;

    public MemberController(MemberService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Member>> getAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Member> getById(@PathVariable Integer id) {
        return service.findById(id)
                .map(member -> new ResponseEntity<>(member, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND)); // Manejo seguro del Optional
    }

    @PostMapping
    public ResponseEntity<Member> save(@RequestBody Member member) {
        return new ResponseEntity<>(service.save(member), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (service.delete(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 No Content si se borró
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // 404 Not Found si no existía
        }
    }
}