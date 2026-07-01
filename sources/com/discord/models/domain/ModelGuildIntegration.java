package com.discord.models.domain;

import b.d.b.a.a;
import com.discord.api.user.User;
import com.discord.models.deserialization.gson.InboundGatewayGsonParser;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class ModelGuildIntegration implements Model {
    public static final String[] SUPPORTED_TYPES = {"twitch", "youtube"};
    private static final String TWITCH_URL_PREFIX = "twitch.tv/";
    public static final String TYPE_TWITCH = "twitch";
    public static final String TYPE_YOUTUBE = "youtube";
    private ModelGuildIntegration$IntegrationAccount account;
    private boolean enableEmoticons;
    private boolean enabled;
    private int expireBehavior;
    private int expireGracePeriod;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private long f2721id;
    private String name;
    private long roleId;
    private int subscriberCount;
    private String syncedAt;
    private boolean syncing;
    private String type;
    private User user;

    @Override // com.discord.models.domain.Model
    public void assignField(Model$JsonReader model$JsonReader) throws IOException {
        String strNextName = model$JsonReader.nextName();
        strNextName.hashCode();
        switch (strNextName) {
            case "enable_emoticons":
                this.enableEmoticons = model$JsonReader.nextBoolean(this.enableEmoticons);
                break;
            case "syncing":
                this.syncing = model$JsonReader.nextBoolean(this.syncing);
                break;
            case "enabled":
                this.enabled = model$JsonReader.nextBoolean(this.enabled);
                break;
            case "account":
                this.account = (ModelGuildIntegration$IntegrationAccount) model$JsonReader.parse(new ModelGuildIntegration$IntegrationAccount());
                break;
            case "expire_behavior":
                this.expireBehavior = model$JsonReader.nextInt(this.expireBehavior);
                break;
            case "id":
                this.f2721id = model$JsonReader.nextLong(this.f2721id);
                break;
            case "name":
                this.name = model$JsonReader.nextString(this.name);
                break;
            case "type":
                this.type = model$JsonReader.nextString(this.type);
                break;
            case "user":
                this.user = (User) InboundGatewayGsonParser.fromJson(model$JsonReader, User.class);
                break;
            case "synced_at":
                this.syncedAt = model$JsonReader.nextString(this.syncedAt);
                break;
            case "role_id":
                this.roleId = model$JsonReader.nextLong(this.roleId);
                break;
            case "expire_grace_period":
                this.expireGracePeriod = model$JsonReader.nextInt(this.expireGracePeriod);
                break;
            case "subscriber_count":
                this.subscriberCount = model$JsonReader.nextInt(this.subscriberCount);
                break;
            default:
                model$JsonReader.skipValue();
                break;
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof ModelGuildIntegration;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ModelGuildIntegration)) {
            return false;
        }
        ModelGuildIntegration modelGuildIntegration = (ModelGuildIntegration) obj;
        if (!modelGuildIntegration.canEqual(this) || isEnableEmoticons() != modelGuildIntegration.isEnableEmoticons() || isEnabled() != modelGuildIntegration.isEnabled() || getExpireBehavior() != modelGuildIntegration.getExpireBehavior() || getExpireGracePeriod() != modelGuildIntegration.getExpireGracePeriod() || getId() != modelGuildIntegration.getId() || getRoleId() != modelGuildIntegration.getRoleId() || getSubscriberCount() != modelGuildIntegration.getSubscriberCount() || isSyncing() != modelGuildIntegration.isSyncing()) {
            return false;
        }
        String name = getName();
        String name2 = modelGuildIntegration.getName();
        if (name != null ? !name.equals(name2) : name2 != null) {
            return false;
        }
        String syncedAt = getSyncedAt();
        String syncedAt2 = modelGuildIntegration.getSyncedAt();
        if (syncedAt != null ? !syncedAt.equals(syncedAt2) : syncedAt2 != null) {
            return false;
        }
        String type = getType();
        String type2 = modelGuildIntegration.getType();
        if (type != null ? !type.equals(type2) : type2 != null) {
            return false;
        }
        User user = getUser();
        User user2 = modelGuildIntegration.getUser();
        if (user != null ? !user.equals(user2) : user2 != null) {
            return false;
        }
        ModelGuildIntegration$IntegrationAccount account = getAccount();
        ModelGuildIntegration$IntegrationAccount account2 = modelGuildIntegration.getAccount();
        return account != null ? account.equals(account2) : account2 == null;
    }

    public ModelGuildIntegration$IntegrationAccount getAccount() {
        return this.account;
    }

    public String getDisplayName() {
        if (!"twitch".equals(this.type)) {
            return this.name;
        }
        StringBuilder sbU = a.U("twitch.tv/");
        sbU.append(this.name);
        return sbU.toString();
    }

    public int getExpireBehavior() {
        return this.expireBehavior;
    }

    public int getExpireGracePeriod() {
        return this.expireGracePeriod;
    }

    public long getId() {
        return this.f2721id;
    }

    public String getName() {
        return this.name;
    }

    public long getRoleId() {
        return this.roleId;
    }

    public int getSubscriberCount() {
        return this.subscriberCount;
    }

    public String getSyncedAt() {
        return this.syncedAt;
    }

    public String getType() {
        return this.type;
    }

    public User getUser() {
        return this.user;
    }

    public int hashCode() {
        int expireGracePeriod = getExpireGracePeriod() + ((getExpireBehavior() + (((((isEnableEmoticons() ? 79 : 97) + 59) * 59) + (isEnabled() ? 79 : 97)) * 59)) * 59);
        long id2 = getId();
        int i = (expireGracePeriod * 59) + ((int) (id2 ^ (id2 >>> 32)));
        long roleId = getRoleId();
        int subscriberCount = (getSubscriberCount() + (((i * 59) + ((int) (roleId ^ (roleId >>> 32)))) * 59)) * 59;
        int i2 = isSyncing() ? 79 : 97;
        String name = getName();
        int iHashCode = ((subscriberCount + i2) * 59) + (name == null ? 43 : name.hashCode());
        String syncedAt = getSyncedAt();
        int iHashCode2 = (iHashCode * 59) + (syncedAt == null ? 43 : syncedAt.hashCode());
        String type = getType();
        int iHashCode3 = (iHashCode2 * 59) + (type == null ? 43 : type.hashCode());
        User user = getUser();
        int iHashCode4 = (iHashCode3 * 59) + (user == null ? 43 : user.hashCode());
        ModelGuildIntegration$IntegrationAccount account = getAccount();
        return (iHashCode4 * 59) + (account != null ? account.hashCode() : 43);
    }

    public boolean isEnableEmoticons() {
        return this.enableEmoticons;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public boolean isSyncing() {
        return this.syncing;
    }

    public String toString() {
        StringBuilder sbU = a.U("ModelGuildIntegration(enableEmoticons=");
        sbU.append(isEnableEmoticons());
        sbU.append(", enabled=");
        sbU.append(isEnabled());
        sbU.append(", expireBehavior=");
        sbU.append(getExpireBehavior());
        sbU.append(", expireGracePeriod=");
        sbU.append(getExpireGracePeriod());
        sbU.append(", id=");
        sbU.append(getId());
        sbU.append(", name=");
        sbU.append(getName());
        sbU.append(", roleId=");
        sbU.append(getRoleId());
        sbU.append(", subscriberCount=");
        sbU.append(getSubscriberCount());
        sbU.append(", syncedAt=");
        sbU.append(getSyncedAt());
        sbU.append(", syncing=");
        sbU.append(isSyncing());
        sbU.append(", type=");
        sbU.append(getType());
        sbU.append(", user=");
        sbU.append(getUser());
        sbU.append(", account=");
        sbU.append(getAccount());
        sbU.append(")");
        return sbU.toString();
    }
}
