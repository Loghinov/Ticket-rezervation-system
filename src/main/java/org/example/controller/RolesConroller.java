package org.example.controller;

import org.example.entity.Role;
import org.example.service.RolesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/roles")
public class RolesConroller {
    private final RolesService rolesService;

    public RolesConroller(RolesService rolesService){
        this.rolesService = rolesService;
    }

    @GetMapping("/get-roles-by-id")
    public ResponseEntity<Role> getRolesById(@RequestParam long rolesId){
        try{
            Role role = rolesService.getRoleById(rolesId);
            if(role ==null){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(role, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
