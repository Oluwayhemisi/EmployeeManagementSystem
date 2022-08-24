package africa.semicolon.employeemanagement.data.model.enums;

public enum Department {
    ACCOUNT("Account"),
    INFORMATION_AND_TECHNOLOGY("IT"),
    MARKETING("Marketing"),
    RESEARCH_AND_DEVELOPMENT("Research");
    private  String type;
    Department(String type) {
        this.type = type;
    }
}
