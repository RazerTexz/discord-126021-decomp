package com.discord.models.domain;

import b.d.b.a.a;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class ModelAuditLogEntry$ChangeNameId implements Model {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private long f2716id;
    private String name;

    @Override // com.discord.models.domain.Model
    public void assignField(Model$JsonReader model$JsonReader) throws IOException {
        String strNextName = model$JsonReader.nextName();
        strNextName.hashCode();
        if (strNextName.equals(ModelAuditLogEntry.CHANGE_KEY_ID)) {
            this.f2716id = model$JsonReader.nextLong(this.f2716id);
        } else if (strNextName.equals(ModelAuditLogEntry.CHANGE_KEY_NAME)) {
            this.name = model$JsonReader.nextString(this.name);
        } else {
            model$JsonReader.skipValue();
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof ModelAuditLogEntry$ChangeNameId;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ModelAuditLogEntry$ChangeNameId)) {
            return false;
        }
        ModelAuditLogEntry$ChangeNameId modelAuditLogEntry$ChangeNameId = (ModelAuditLogEntry$ChangeNameId) obj;
        if (!modelAuditLogEntry$ChangeNameId.canEqual(this) || getId() != modelAuditLogEntry$ChangeNameId.getId()) {
            return false;
        }
        String name = getName();
        String name2 = modelAuditLogEntry$ChangeNameId.getName();
        return name != null ? name.equals(name2) : name2 == null;
    }

    public long getId() {
        return this.f2716id;
    }

    public String getName() {
        return this.name;
    }

    public int hashCode() {
        long id2 = getId();
        String name = getName();
        return ((((int) (id2 ^ (id2 >>> 32))) + 59) * 59) + (name == null ? 43 : name.hashCode());
    }

    public String toString() {
        StringBuilder sbU = a.U("ModelAuditLogEntry.ChangeNameId(name=");
        sbU.append(getName());
        sbU.append(", id=");
        sbU.append(getId());
        sbU.append(")");
        return sbU.toString();
    }
}
