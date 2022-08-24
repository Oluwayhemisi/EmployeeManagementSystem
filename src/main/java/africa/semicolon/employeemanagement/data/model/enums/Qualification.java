package africa.semicolon.employeemanagement.data.model.enums;

public enum Qualification {
    BACHELORS_DEGREE("BSc"), MASTERS_DEGREE("MSc"), DOCTORATE_DEGREE("Phd");
    private final String type;

    Qualification(String type){
        this.type = type;
    }

    public String getType(){
        return type;
    }

}
