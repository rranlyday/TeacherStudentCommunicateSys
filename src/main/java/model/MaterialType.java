package model;

public class MaterialType {
    private Integer id;

    private String materialTypeName;

    private String materialTypeDescription;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaterialTypeName() {
        return materialTypeName;
    }

    public void setMaterialTypeName(String materialTypeName) {
        this.materialTypeName = materialTypeName == null ? null : materialTypeName.trim();
    }

    public String getMaterialTypeDescription() {
        return materialTypeDescription;
    }

    public void setMaterialTypeDescription(String materialTypeDescription) {
        this.materialTypeDescription = materialTypeDescription == null ? null : materialTypeDescription.trim();
    }
}