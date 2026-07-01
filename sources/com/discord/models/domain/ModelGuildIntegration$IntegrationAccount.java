package com.discord.models.domain;

import b.d.b.a.a;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class ModelGuildIntegration$IntegrationAccount implements Model {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f2722id;
    private String name;

    @Override // com.discord.models.domain.Model
    public void assignField(Model$JsonReader model$JsonReader) throws IOException {
        String strNextName = model$JsonReader.nextName();
        strNextName.hashCode();
        if (strNextName.equals(ModelAuditLogEntry.CHANGE_KEY_ID)) {
            this.f2722id = model$JsonReader.nextString(this.f2722id);
        } else if (strNextName.equals(ModelAuditLogEntry.CHANGE_KEY_NAME)) {
            this.name = model$JsonReader.nextString(this.name);
        } else {
            model$JsonReader.skipValue();
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof ModelGuildIntegration$IntegrationAccount;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ModelGuildIntegration$IntegrationAccount)) {
            return false;
        }
        ModelGuildIntegration$IntegrationAccount modelGuildIntegration$IntegrationAccount = (ModelGuildIntegration$IntegrationAccount) obj;
        if (!modelGuildIntegration$IntegrationAccount.canEqual(this)) {
            return false;
        }
        String id2 = getId();
        String id3 = modelGuildIntegration$IntegrationAccount.getId();
        if (id2 != null ? !id2.equals(id3) : id3 != null) {
            return false;
        }
        String name = getName();
        String name2 = modelGuildIntegration$IntegrationAccount.getName();
        return name != null ? name.equals(name2) : name2 == null;
    }

    public String getId() {
        return this.f2722id;
    }

    public String getName() {
        return this.name;
    }

    public int hashCode() {
        String id2 = getId();
        int iHashCode = id2 == null ? 43 : id2.hashCode();
        String name = getName();
        return ((iHashCode + 59) * 59) + (name != null ? name.hashCode() : 43);
    }

    public String toString() {
        StringBuilder sbU = a.U("ModelGuildIntegration.IntegrationAccount(id=");
        sbU.append(getId());
        sbU.append(", name=");
        sbU.append(getName());
        sbU.append(")");
        return sbU.toString();
    }
}
