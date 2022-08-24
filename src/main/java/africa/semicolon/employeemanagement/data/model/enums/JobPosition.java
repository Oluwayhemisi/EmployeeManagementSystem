package africa.semicolon.employeemanagement.data.model.enums;




public enum JobPosition {
    ENTRY_LEVEL("Entry"),INTERNSHIP("Internship"), MID_LEVEL("MidLevel"), SENIOR("Senior");
    private final String level;

    JobPosition(String type) {
        this.level = type;
    }
    public String getLevel() {
        return level;
    }

}
