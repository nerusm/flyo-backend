package com.flyosports2.manage.InventoryManagementApp.UIModels;

public class CheckedItems {

    String value;
    String label;
    boolean checked;
    String entity;

    public CheckedItems() {
    }

    public CheckedItems(String value, String label, boolean checked, String entity) {
        this.value = value;
        this.label = label;
        this.checked = checked;
        this.entity = entity;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }
}
