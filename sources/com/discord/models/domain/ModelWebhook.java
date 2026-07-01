package com.discord.models.domain;

import b.d.b.a.a;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class ModelWebhook implements Model {
    private String avatar;
    private long channelId;
    private long guildId;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private long f2737id;
    private String name;

    @Override // com.discord.models.domain.Model
    public void assignField(Model$JsonReader model$JsonReader) throws IOException {
        String strNextName = model$JsonReader.nextName();
        strNextName.hashCode();
        switch (strNextName) {
            case "channel_id":
                this.channelId = model$JsonReader.nextLong(this.channelId);
                break;
            case "avatar":
                this.avatar = model$JsonReader.nextString(this.avatar);
                break;
            case "guild_id":
                this.guildId = model$JsonReader.nextLong(this.guildId);
                break;
            case "id":
                this.f2737id = model$JsonReader.nextLong(this.f2737id);
                break;
            case "name":
                this.name = model$JsonReader.nextString(this.name);
                break;
            default:
                model$JsonReader.skipValue();
                break;
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof ModelWebhook;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ModelWebhook)) {
            return false;
        }
        ModelWebhook modelWebhook = (ModelWebhook) obj;
        if (!modelWebhook.canEqual(this) || getChannelId() != modelWebhook.getChannelId() || getGuildId() != modelWebhook.getGuildId() || getId() != modelWebhook.getId()) {
            return false;
        }
        String avatar = getAvatar();
        String avatar2 = modelWebhook.getAvatar();
        if (avatar != null ? !avatar.equals(avatar2) : avatar2 != null) {
            return false;
        }
        String name = getName();
        String name2 = modelWebhook.getName();
        return name != null ? name.equals(name2) : name2 == null;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public long getId() {
        return this.f2737id;
    }

    public String getName() {
        return this.name;
    }

    public int hashCode() {
        long channelId = getChannelId();
        long guildId = getGuildId();
        int i = ((((int) (channelId ^ (channelId >>> 32))) + 59) * 59) + ((int) (guildId ^ (guildId >>> 32)));
        long id2 = getId();
        String avatar = getAvatar();
        int iHashCode = (((i * 59) + ((int) ((id2 >>> 32) ^ id2))) * 59) + (avatar == null ? 43 : avatar.hashCode());
        String name = getName();
        return (iHashCode * 59) + (name != null ? name.hashCode() : 43);
    }

    public String toString() {
        StringBuilder sbU = a.U("ModelWebhook(avatar=");
        sbU.append(getAvatar());
        sbU.append(", name=");
        sbU.append(getName());
        sbU.append(", channelId=");
        sbU.append(getChannelId());
        sbU.append(", guildId=");
        sbU.append(getGuildId());
        sbU.append(", id=");
        sbU.append(getId());
        sbU.append(")");
        return sbU.toString();
    }
}
