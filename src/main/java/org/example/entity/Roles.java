package org.example.entity;

public class Roles {
    private long rolesId;
    private String roleName;

    public Roles() {};
    public Roles(long rolesId, String roleName) {
        this.rolesId = rolesId;
        this.roleName = roleName;
    }

    public long getRolesId() {
        return rolesId;
    }

    public void setRolesId(long rolesId) {
        this.rolesId = rolesId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    @Override
    public String toString(){
        return "Role id: "+ rolesId +" Role name: "+roleName;
    }
}
