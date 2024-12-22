package org.example.controller;

import org.example.entity.Roles;
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
    public ResponseEntity<Roles> getRolesById(@RequestParam long rolesId){
        try{
            Roles roles = rolesService.getRoleById(rolesId);
            if(roles==null){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(roles, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
