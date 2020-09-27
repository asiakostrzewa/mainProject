package mainProject.user;

public enum RoleTypeEnum {
    USER("ROLE_USER"),
    ADMIN("ROLE_ADMIN");

    private String roleName;

    RoleTypeEnum(String roleName) {
        this.roleName = roleName;
    }
}
