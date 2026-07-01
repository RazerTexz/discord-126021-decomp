package com.discord.models.domain;

import androidx.annotation.Nullable;
import b.d.b.a.outline;
import com.discord.api.user.User;
import com.discord.models.deserialization.gson.InboundGatewayGsonParser;
import com.discord.models.domain.Model;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class ModelBan implements Model {
    private long guildId;

    @Nullable
    private String reason;
    private User user;

    @Override // com.discord.models.domain.Model
    public void assignField(Model.JsonReader jsonReader) throws IOException {
        String strNextName = jsonReader.nextName();
        strNextName.hashCode();
        switch (strNextName) {
            case "guild_id":
                this.guildId = jsonReader.nextLong(-1L);
                break;
            case "reason":
                this.reason = jsonReader.nextStringOrNull();
                break;
            case "user":
                this.user = (User) InboundGatewayGsonParser.fromJson(jsonReader, User.class);
                break;
            default:
                jsonReader.skipValue();
                break;
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof ModelBan;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ModelBan)) {
            return false;
        }
        ModelBan modelBan = (ModelBan) obj;
        if (!modelBan.canEqual(this) || getGuildId() != modelBan.getGuildId()) {
            return false;
        }
        User user = getUser();
        User user2 = modelBan.getUser();
        if (user != null ? !user.equals(user2) : user2 != null) {
            return false;
        }
        String reason = getReason();
        String reason2 = modelBan.getReason();
        return reason != null ? reason.equals(reason2) : reason2 == null;
    }

    public long getGuildId() {
        return this.guildId;
    }

    @Nullable
    public String getReason() {
        return this.reason;
    }

    public User getUser() {
        return this.user;
    }

    public int hashCode() {
        long guildId = getGuildId();
        User user = getUser();
        int iHashCode = ((((int) (guildId ^ (guildId >>> 32))) + 59) * 59) + (user == null ? 43 : user.hashCode());
        String reason = getReason();
        return (iHashCode * 59) + (reason != null ? reason.hashCode() : 43);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelBan(user=");
        sbU.append(getUser());
        sbU.append(", guildId=");
        sbU.append(getGuildId());
        sbU.append(", reason=");
        sbU.append(getReason());
        sbU.append(")");
        return sbU.toString();
    }
}
