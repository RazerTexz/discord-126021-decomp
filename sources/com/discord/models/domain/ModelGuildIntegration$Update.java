package com.discord.models.domain;

import b.d.b.a.a;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class ModelGuildIntegration$Update implements Model {
    private long guildId;

    @Override // com.discord.models.domain.Model
    public void assignField(Model$JsonReader model$JsonReader) throws IOException {
        String strNextName = model$JsonReader.nextName();
        strNextName.hashCode();
        if (strNextName.equals(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID)) {
            this.guildId = model$JsonReader.nextLong(this.guildId);
        } else {
            model$JsonReader.skipValue();
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof ModelGuildIntegration$Update;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ModelGuildIntegration$Update)) {
            return false;
        }
        ModelGuildIntegration$Update modelGuildIntegration$Update = (ModelGuildIntegration$Update) obj;
        return modelGuildIntegration$Update.canEqual(this) && getGuildId() == modelGuildIntegration$Update.getGuildId();
    }

    public long getGuildId() {
        return this.guildId;
    }

    public int hashCode() {
        long guildId = getGuildId();
        return 59 + ((int) (guildId ^ (guildId >>> 32)));
    }

    public String toString() {
        StringBuilder sbU = a.U("ModelGuildIntegration.Update(guildId=");
        sbU.append(getGuildId());
        sbU.append(")");
        return sbU.toString();
    }
}
