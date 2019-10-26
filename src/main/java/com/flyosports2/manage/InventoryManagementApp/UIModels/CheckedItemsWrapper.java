package com.flyosports2.manage.InventoryManagementApp.UIModels;

public class CheckedItemsWrapper {
    String entity;
    CheckedItems[] checkedItems;

    public CheckedItemsWrapper() {
    }

    public CheckedItemsWrapper(String entity, CheckedItems[] checkedItems) {
        this.entity = entity;
        this.checkedItems = checkedItems;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public CheckedItems[] getCheckedItems() {
        return checkedItems;
    }

    public void setCheckedItems(CheckedItems[] checkedItems) {
        this.checkedItems = checkedItems;
    }
}
