package utils;

public enum Environments {

    LOCAL("DEVELOPMENT", "env-local");

    private String env;
    private String fileProperties;

    Environments(String env, String fileProperties) {
        this.env = env;
        this.fileProperties = fileProperties;
    }

    public String getFileProperties(){
        return this.fileProperties;
    }

}
