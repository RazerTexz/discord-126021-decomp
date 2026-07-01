package com.discord.models.domain;

import b.d.b.a.a;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class ModelAuditLogEntry$Change implements Model {
    private String key;
    private Object newValue;
    private Object oldValue;

    public ModelAuditLogEntry$Change() {
    }

    @Override // com.discord.models.domain.Model
    public void assignField(Model$JsonReader model$JsonReader) throws IOException {
        ModelAuditLogEntry$ValueFactory modelAuditLogEntry$ValueFactory = new ModelAuditLogEntry$ValueFactory(model$JsonReader);
        String strNextName = model$JsonReader.nextName();
        strNextName.hashCode();
        switch (strNextName) {
            case "new_value":
                this.newValue = model$JsonReader.parseUnknown(modelAuditLogEntry$ValueFactory);
                break;
            case "key":
                this.key = model$JsonReader.nextString(this.key);
                break;
            case "old_value":
                this.oldValue = model$JsonReader.parseUnknown(modelAuditLogEntry$ValueFactory);
                break;
            default:
                model$JsonReader.skipValue();
                break;
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof ModelAuditLogEntry$Change;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ModelAuditLogEntry$Change)) {
            return false;
        }
        ModelAuditLogEntry$Change modelAuditLogEntry$Change = (ModelAuditLogEntry$Change) obj;
        if (!modelAuditLogEntry$Change.canEqual(this)) {
            return false;
        }
        String key = getKey();
        String key2 = modelAuditLogEntry$Change.getKey();
        if (key != null ? !key.equals(key2) : key2 != null) {
            return false;
        }
        Object oldValue = getOldValue();
        Object oldValue2 = modelAuditLogEntry$Change.getOldValue();
        if (oldValue != null ? !oldValue.equals(oldValue2) : oldValue2 != null) {
            return false;
        }
        Object newValue = getNewValue();
        Object newValue2 = modelAuditLogEntry$Change.getNewValue();
        return newValue != null ? newValue.equals(newValue2) : newValue2 == null;
    }

    public String getKey() {
        return this.key;
    }

    public Object getNewValue() {
        return this.newValue;
    }

    public Object getOldValue() {
        return this.oldValue;
    }

    public Object getValue() {
        Object obj = this.newValue;
        return obj != null ? obj : this.oldValue;
    }

    public int hashCode() {
        String key = getKey();
        int iHashCode = key == null ? 43 : key.hashCode();
        Object oldValue = getOldValue();
        int iHashCode2 = ((iHashCode + 59) * 59) + (oldValue == null ? 43 : oldValue.hashCode());
        Object newValue = getNewValue();
        return (iHashCode2 * 59) + (newValue != null ? newValue.hashCode() : 43);
    }

    public String toString() {
        StringBuilder sbU = a.U("ModelAuditLogEntry.Change(key=");
        sbU.append(getKey());
        sbU.append(", oldValue=");
        sbU.append(getOldValue());
        sbU.append(", newValue=");
        sbU.append(getNewValue());
        sbU.append(")");
        return sbU.toString();
    }

    public ModelAuditLogEntry$Change(String str, Object obj, Object obj2) {
        this.key = str;
        this.oldValue = obj;
        this.newValue = obj2;
    }
}
