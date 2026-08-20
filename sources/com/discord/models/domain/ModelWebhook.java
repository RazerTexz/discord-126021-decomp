package com.discord.models.domain;

import java.io.IOException;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: loaded from: classes.dex */
public class ModelWebhook implements Model {
    private String avatar;
    private long channelId;
    private long guildId;

    /* JADX INFO: renamed from: id */
    private long f18586id;
    private String name;

    @Override // com.discord.models.domain.Model
    public void assignField(Model.JsonReader jsonReader) throws IOException {
        String strNextName = jsonReader.nextName();
        strNextName.hashCode();
        switch (strNextName) {
            case "channel_id":
                this.channelId = jsonReader.nextLong(this.channelId);
                break;
            case "avatar":
                this.avatar = jsonReader.nextString(this.avatar);
                break;
            case "guild_id":
                this.guildId = jsonReader.nextLong(this.guildId);
                break;
            case "id":
                this.f18586id = jsonReader.nextLong(this.f18586id);
                break;
            case "name":
                this.name = jsonReader.nextString(this.name);
                break;
            default:
                jsonReader.skipValue();
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
        return this.f18586id;
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
        StringBuilder sbM833U = C1643a.m833U("ModelWebhook(avatar=");
        sbM833U.append(getAvatar());
        sbM833U.append(", name=");
        sbM833U.append(getName());
        sbM833U.append(", channelId=");
        sbM833U.append(getChannelId());
        sbM833U.append(", guildId=");
        sbM833U.append(getGuildId());
        sbM833U.append(", id=");
        sbM833U.append(getId());
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
