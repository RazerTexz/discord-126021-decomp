package com.discord.models.domain;

import b.a.m.a.h;
import b.d.b.a.a;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ModelAuditLogEntry implements Model {
    public static final int ACTION_ALL = 0;
    public static final int ACTION_BOT_ADD = 28;
    public static final int ACTION_CHANNEL_CREATE = 10;
    public static final int ACTION_CHANNEL_DELETE = 12;
    public static final int ACTION_CHANNEL_OVERWRITE_CREATE = 13;
    public static final int ACTION_CHANNEL_OVERWRITE_DELETE = 15;
    public static final int ACTION_CHANNEL_OVERWRITE_UPDATE = 14;
    public static final int ACTION_CHANNEL_UPDATE = 11;
    public static final int ACTION_EMOJI_CREATE = 60;
    public static final int ACTION_EMOJI_DELETE = 62;
    public static final int ACTION_EMOJI_UPDATE = 61;
    public static final int ACTION_GUILD_SCHEDULED_EVENT_CREATE = 100;
    public static final int ACTION_GUILD_SCHEDULED_EVENT_DELETE = 102;
    public static final int ACTION_GUILD_SCHEDULED_EVENT_UPDATE = 101;
    public static final int ACTION_GUILD_UPDATE = 1;
    public static final int ACTION_INTEGRATION_CREATE = 80;
    public static final int ACTION_INTEGRATION_DELETE = 82;
    public static final int ACTION_INTEGRATION_UPDATE = 81;
    public static final int ACTION_INVITE_CREATE = 40;
    public static final int ACTION_INVITE_DELETE = 42;
    public static final int ACTION_INVITE_UPDATE = 41;
    public static final int ACTION_MEMBER_BAN_ADD = 22;
    public static final int ACTION_MEMBER_BAN_REMOVE = 23;
    public static final int ACTION_MEMBER_DISCONNECT = 27;
    public static final int ACTION_MEMBER_KICK = 20;
    public static final int ACTION_MEMBER_MOVE = 26;
    public static final int ACTION_MEMBER_PRUNE = 21;
    public static final int ACTION_MEMBER_ROLE_UPDATE = 25;
    public static final int ACTION_MEMBER_UPDATE = 24;
    public static final int ACTION_MESSAGE_BULK_DELETE = 73;
    public static final int ACTION_MESSAGE_DELETE = 72;
    public static final int ACTION_MESSAGE_PIN = 74;
    public static final int ACTION_MESSAGE_UNPIN = 75;
    public static final int ACTION_ROLE_CREATE = 30;
    public static final int ACTION_ROLE_DELETE = 32;
    public static final int ACTION_ROLE_UPDATE = 31;
    public static final int ACTION_STAGE_INSTANCE_CREATE = 83;
    public static final int ACTION_STAGE_INSTANCE_DELETE = 85;
    public static final int ACTION_STAGE_INSTANCE_UPDATE = 84;
    public static final int ACTION_STICKER_CREATE = 90;
    public static final int ACTION_STICKER_DELETE = 92;
    public static final int ACTION_STICKER_UPDATE = 91;
    public static final int ACTION_THREAD_CREATE = 110;
    public static final int ACTION_THREAD_DELETE = 112;
    public static final int ACTION_THREAD_UPDATE = 111;
    public static final int ACTION_WEBHOOK_CREATE = 50;
    public static final int ACTION_WEBHOOK_DELETE = 52;
    public static final int ACTION_WEBHOOK_UPDATE = 51;
    public static final String CHANGE_KEY_AFK_CHANNEL_ID = "afk_channel_id";
    public static final String CHANGE_KEY_AFK_TIMEOUT = "afk_timeout";
    public static final String CHANGE_KEY_APPLICATION_ID = "application_id";
    public static final String CHANGE_KEY_ARCHIVED = "archived";
    public static final String CHANGE_KEY_ASSET = "asset";
    public static final String CHANGE_KEY_AUTO_ARCHIVE_DURATION = "auto_archive_duration";
    public static final String CHANGE_KEY_AVAILABLE = "available";
    public static final String CHANGE_KEY_AVATAR_HASH = "avatar_hash";
    public static final String CHANGE_KEY_BANNER_HASH = "banner_hash";
    public static final String CHANGE_KEY_BITRATE = "bitrate";
    public static final String CHANGE_KEY_CHANNEL_ID = "channel_id";
    public static final String CHANGE_KEY_CODE = "code";
    public static final String CHANGE_KEY_COLOR = "color";
    public static final String CHANGE_KEY_DEAF = "deaf";
    public static final String CHANGE_KEY_DEFAULT_AUTO_ARCHIVE_DURATION = "default_auto_archive_duration";
    public static final String CHANGE_KEY_DEFAULT_MESSAGE_NOTIFICATIONS = "default_message_notifications";
    public static final String CHANGE_KEY_DESCRIPTION = "description";
    public static final String CHANGE_KEY_DISCOVERY_SPLASH_HASH = "discovery_splash_hash";
    public static final String CHANGE_KEY_ENABLE_EMOTICONS = "enable_emoticons";
    public static final String CHANGE_KEY_ENTITY_TYPE = "entity_type";
    public static final String CHANGE_KEY_EXPIRE_BEHAVIOR = "expire_behavior";
    public static final String CHANGE_KEY_EXPIRE_GRACE_PERIOD = "expire_grace_period";
    public static final String CHANGE_KEY_EXPLICIT_CONTENT_FILTER = "explicit_content_filter";
    public static final String CHANGE_KEY_FORMAT_TYPE = "format_type";
    public static final String CHANGE_KEY_GUILD_COMMUNICATION_DISABLED = "communication_disabled_until";
    public static final String CHANGE_KEY_GUILD_ID = "guild_id";
    public static final String CHANGE_KEY_HOIST = "hoist";
    public static final String CHANGE_KEY_ICON_HASH = "icon_hash";
    public static final String CHANGE_KEY_ID = "id";
    public static final String CHANGE_KEY_IMAGE_HASH = "image_hash";
    public static final String CHANGE_KEY_INVITER_ID = "inviter_id";
    public static final String CHANGE_KEY_LOCATION = "location";
    public static final String CHANGE_KEY_LOCKED = "locked";
    public static final String CHANGE_KEY_MAX_AGE = "max_age";
    public static final String CHANGE_KEY_MAX_USES = "max_uses";
    public static final String CHANGE_KEY_MENTIONABLE = "mentionable";
    public static final String CHANGE_KEY_MFA_LEVEL = "mfa_level";
    public static final String CHANGE_KEY_MUTE = "mute";
    public static final String CHANGE_KEY_NAME = "name";
    public static final String CHANGE_KEY_NICK = "nick";
    public static final String CHANGE_KEY_NSFW = "nsfw";
    public static final String CHANGE_KEY_OWNER_ID = "owner_id";
    public static final String CHANGE_KEY_PERMISSIONS = "permissions";
    public static final String CHANGE_KEY_PERMISSIONS_DENIED = "deny";
    public static final String CHANGE_KEY_PERMISSIONS_GRANTED = "allow";
    public static final String CHANGE_KEY_PERMISSIONS_RESET = "reset";
    public static final String CHANGE_KEY_PERMISSION_OVERWRITES = "permission_overwrites";
    public static final String CHANGE_KEY_POSITION = "position";
    public static final String CHANGE_KEY_PREFERRED_LOCALE = "preferred_locale";
    public static final String CHANGE_KEY_PREMIUM_PROGRESS_BAR_ENABLED = "premium_progress_bar_enabled";
    public static final String CHANGE_KEY_PRIVACY_LEVEL = "privacy_level";
    public static final String CHANGE_KEY_PRUNE_DELETE_DAYS = "prune_delete_days";
    public static final String CHANGE_KEY_RATE_LIMIT_PER_USER = "rate_limit_per_user";
    public static final String CHANGE_KEY_REASON = "reason";
    public static final String CHANGE_KEY_REGION = "region";
    public static final String CHANGE_KEY_REGION_OVERRIDE = "rtc_region";
    public static final String CHANGE_KEY_ROLES_ADD = "$add";
    public static final String CHANGE_KEY_ROLES_REMOVE = "$remove";
    public static final String CHANGE_KEY_RULES_CHANNEL_ID = "rules_channel_id";
    public static final String CHANGE_KEY_SPLASH_HASH = "splash_hash";
    public static final String CHANGE_KEY_STATUS = "status";
    public static final String CHANGE_KEY_SYSTEM_CHANNEL_FLAGS = "system_channel_flags";
    public static final String CHANGE_KEY_SYSTEM_CHANNEL_ID = "system_channel_id";
    public static final String CHANGE_KEY_TAGS = "tags";
    public static final String CHANGE_KEY_TEMPORARY = "temporary";
    public static final String CHANGE_KEY_TOPIC = "topic";
    public static final String CHANGE_KEY_TYPE = "type";
    public static final String CHANGE_KEY_UNICODE_EMOJI = "unicode_emoji";
    public static final String CHANGE_KEY_UPDATES_CHANNEL_ID = "public_updates_channel_id";
    public static final String CHANGE_KEY_USES = "uses";
    public static final String CHANGE_KEY_VANITY_URL_CODE = "vanity_url_code";
    public static final String CHANGE_KEY_VERIFICATION_LEVEL = "verification_level";
    public static final String CHANGE_KEY_VIDEO_QUALITY_MODE = "video_quality_mode";
    public static final String CHANGE_KEY_WIDGET_CHANNEL_ID = "widget_channel_id";
    public static final String CHANGE_KEY_WIDGET_ENABLED = "widget_enabled";
    private int actionTypeId;
    private List<ModelAuditLogEntry$Change> changes;
    private Long guildId;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private long f2715id;
    private ModelAuditLogEntry$Options options;
    private String reason;
    private long targetId;
    private Long timestampEnd;
    private long userId;

    public ModelAuditLogEntry() {
    }

    @Override // com.discord.models.domain.Model
    public void assignField(Model$JsonReader model$JsonReader) throws IOException {
        String strNextName = model$JsonReader.nextName();
        strNextName.hashCode();
        switch (strNextName) {
            case "options":
                this.options = (ModelAuditLogEntry$Options) model$JsonReader.parse(new ModelAuditLogEntry$Options(this));
                break;
            case "reason":
                this.reason = model$JsonReader.nextString(this.reason);
                break;
            case "target_id":
                this.targetId = model$JsonReader.nextLong(this.targetId);
                break;
            case "user_id":
                this.userId = model$JsonReader.nextLong(this.userId);
                break;
            case "id":
                this.f2715id = model$JsonReader.nextLong(this.f2715id);
                break;
            case "changes":
                this.changes = model$JsonReader.nextList(new h(model$JsonReader));
                break;
            case "action_type":
                this.actionTypeId = model$JsonReader.nextInt(this.actionTypeId);
                break;
            default:
                model$JsonReader.skipValue();
                break;
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof ModelAuditLogEntry;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ModelAuditLogEntry)) {
            return false;
        }
        ModelAuditLogEntry modelAuditLogEntry = (ModelAuditLogEntry) obj;
        if (!modelAuditLogEntry.canEqual(this) || getId() != modelAuditLogEntry.getId() || getActionTypeId() != modelAuditLogEntry.getActionTypeId() || getTargetId() != modelAuditLogEntry.getTargetId() || getUserId() != modelAuditLogEntry.getUserId()) {
            return false;
        }
        Long guildId = getGuildId();
        Long guildId2 = modelAuditLogEntry.getGuildId();
        if (guildId != null ? !guildId.equals(guildId2) : guildId2 != null) {
            return false;
        }
        Long timestampEnd = getTimestampEnd();
        Long timestampEnd2 = modelAuditLogEntry.getTimestampEnd();
        if (timestampEnd != null ? !timestampEnd.equals(timestampEnd2) : timestampEnd2 != null) {
            return false;
        }
        List<ModelAuditLogEntry$Change> changes = getChanges();
        List<ModelAuditLogEntry$Change> changes2 = modelAuditLogEntry.getChanges();
        if (changes != null ? !changes.equals(changes2) : changes2 != null) {
            return false;
        }
        ModelAuditLogEntry$Options options = getOptions();
        ModelAuditLogEntry$Options options2 = modelAuditLogEntry.getOptions();
        if (options != null ? !options.equals(options2) : options2 != null) {
            return false;
        }
        String reason = getReason();
        String reason2 = modelAuditLogEntry.getReason();
        return reason != null ? reason.equals(reason2) : reason2 == null;
    }

    public ModelAuditLogEntry$ActionType getActionType() {
        return getActionType(this.actionTypeId);
    }

    public int getActionTypeId() {
        return this.actionTypeId;
    }

    public List<ModelAuditLogEntry$Change> getChanges() {
        return this.changes;
    }

    public Long getGuildId() {
        return this.guildId;
    }

    public long getId() {
        return this.f2715id;
    }

    public ModelAuditLogEntry$Options getOptions() {
        return this.options;
    }

    public String getReason() {
        return this.reason;
    }

    public long getTargetId() {
        return this.targetId;
    }

    public ModelAuditLogEntry$TargetType getTargetType() {
        return getTargetType(this.actionTypeId);
    }

    public Long getTimestampEnd() {
        return this.timestampEnd;
    }

    public long getUserId() {
        return this.userId;
    }

    public int hashCode() {
        long id2 = getId();
        int actionTypeId = getActionTypeId() + ((((int) (id2 ^ (id2 >>> 32))) + 59) * 59);
        long targetId = getTargetId();
        int i = (actionTypeId * 59) + ((int) (targetId ^ (targetId >>> 32)));
        long userId = getUserId();
        Long guildId = getGuildId();
        int iHashCode = (((i * 59) + ((int) ((userId >>> 32) ^ userId))) * 59) + (guildId == null ? 43 : guildId.hashCode());
        Long timestampEnd = getTimestampEnd();
        int iHashCode2 = (iHashCode * 59) + (timestampEnd == null ? 43 : timestampEnd.hashCode());
        List<ModelAuditLogEntry$Change> changes = getChanges();
        int iHashCode3 = (iHashCode2 * 59) + (changes == null ? 43 : changes.hashCode());
        ModelAuditLogEntry$Options options = getOptions();
        int iHashCode4 = (iHashCode3 * 59) + (options == null ? 43 : options.hashCode());
        String reason = getReason();
        return (iHashCode4 * 59) + (reason != null ? reason.hashCode() : 43);
    }

    public String toString() {
        StringBuilder sbU = a.U("ModelAuditLogEntry(id=");
        sbU.append(getId());
        sbU.append(", actionTypeId=");
        sbU.append(getActionTypeId());
        sbU.append(", targetId=");
        sbU.append(getTargetId());
        sbU.append(", userId=");
        sbU.append(getUserId());
        sbU.append(", changes=");
        sbU.append(getChanges());
        sbU.append(", options=");
        sbU.append(getOptions());
        sbU.append(", reason=");
        sbU.append(getReason());
        sbU.append(", guildId=");
        sbU.append(getGuildId());
        sbU.append(", timestampEnd=");
        sbU.append(getTimestampEnd());
        sbU.append(")");
        return sbU.toString();
    }

    public ModelAuditLogEntry(long j, int i, long j2, long j3, List<ModelAuditLogEntry$Change> list, ModelAuditLogEntry$Options modelAuditLogEntry$Options, long j4, Long l) {
        this.f2715id = j;
        this.actionTypeId = i;
        this.targetId = j2;
        this.userId = j3;
        this.changes = list;
        this.options = modelAuditLogEntry$Options;
        this.guildId = Long.valueOf(j4);
        this.timestampEnd = l;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0021  */
    /* JADX WARN: Code duplicated, block: B:16:0x0024  */
    /* JADX WARN: Code duplicated, block: B:18:0x0027  */
    public static ModelAuditLogEntry$ActionType getActionType(int i) {
        switch (i) {
            case 1:
            case 24:
            case 25:
            case 26:
            case 111:
                return ModelAuditLogEntry$ActionType.UPDATE;
            case 20:
            case 21:
            case 22:
            case 27:
            case 112:
                return ModelAuditLogEntry$ActionType.DELETE;
            case 23:
            case 28:
            case 110:
                return ModelAuditLogEntry$ActionType.CREATE;
            default:
                switch (i) {
                    case 10:
                    case 13:
                        return ModelAuditLogEntry$ActionType.CREATE;
                    case 11:
                    case 14:
                        return ModelAuditLogEntry$ActionType.UPDATE;
                    case 12:
                    case 15:
                        return ModelAuditLogEntry$ActionType.DELETE;
                    default:
                        switch (i) {
                            case 30:
                                return ModelAuditLogEntry$ActionType.CREATE;
                            case 31:
                                return ModelAuditLogEntry$ActionType.UPDATE;
                            case 32:
                                return ModelAuditLogEntry$ActionType.DELETE;
                            default:
                                switch (i) {
                                    case 40:
                                        return ModelAuditLogEntry$ActionType.CREATE;
                                    case 41:
                                        return ModelAuditLogEntry$ActionType.UPDATE;
                                    case 42:
                                        return ModelAuditLogEntry$ActionType.DELETE;
                                    default:
                                        switch (i) {
                                            case 50:
                                                return ModelAuditLogEntry$ActionType.CREATE;
                                            case 51:
                                                return ModelAuditLogEntry$ActionType.UPDATE;
                                            case 52:
                                                return ModelAuditLogEntry$ActionType.DELETE;
                                            default:
                                                switch (i) {
                                                    case 60:
                                                        return ModelAuditLogEntry$ActionType.CREATE;
                                                    case 61:
                                                        return ModelAuditLogEntry$ActionType.UPDATE;
                                                    case 62:
                                                        return ModelAuditLogEntry$ActionType.DELETE;
                                                    default:
                                                        switch (i) {
                                                            case 72:
                                                            case 73:
                                                            case 75:
                                                                return ModelAuditLogEntry$ActionType.DELETE;
                                                            case 74:
                                                                return ModelAuditLogEntry$ActionType.CREATE;
                                                            default:
                                                                switch (i) {
                                                                    case 80:
                                                                    case 83:
                                                                        return ModelAuditLogEntry$ActionType.CREATE;
                                                                    case 81:
                                                                    case 84:
                                                                        return ModelAuditLogEntry$ActionType.UPDATE;
                                                                    case 82:
                                                                    case 85:
                                                                        return ModelAuditLogEntry$ActionType.DELETE;
                                                                    default:
                                                                        switch (i) {
                                                                            case 90:
                                                                                return ModelAuditLogEntry$ActionType.CREATE;
                                                                            case 91:
                                                                                return ModelAuditLogEntry$ActionType.UPDATE;
                                                                            case 92:
                                                                                return ModelAuditLogEntry$ActionType.DELETE;
                                                                            default:
                                                                                switch (i) {
                                                                                    case 100:
                                                                                        return ModelAuditLogEntry$ActionType.CREATE;
                                                                                    case 101:
                                                                                        return ModelAuditLogEntry$ActionType.UPDATE;
                                                                                    case 102:
                                                                                        return ModelAuditLogEntry$ActionType.DELETE;
                                                                                    default:
                                                                                        return ModelAuditLogEntry$ActionType.ALL;
                                                                                }
                                                                        }
                                                                }
                                                        }
                                                }
                                        }
                                }
                        }
                }
        }
    }

    public static ModelAuditLogEntry$TargetType getTargetType(int i) {
        if (i == 0) {
            return ModelAuditLogEntry$TargetType.ALL;
        }
        if (i <= 1) {
            return ModelAuditLogEntry$TargetType.GUILD;
        }
        if (i <= 12 || i == 73) {
            return ModelAuditLogEntry$TargetType.CHANNEL;
        }
        if (i <= 15) {
            return ModelAuditLogEntry$TargetType.CHANNEL_OVERWRITE;
        }
        if (i <= 28 || i == 72 || i == 74 || i == 75) {
            return ModelAuditLogEntry$TargetType.USER;
        }
        if (i <= 32) {
            return ModelAuditLogEntry$TargetType.ROLE;
        }
        if (i <= 42) {
            return ModelAuditLogEntry$TargetType.INVITE;
        }
        if (i <= 52) {
            return ModelAuditLogEntry$TargetType.WEBHOOK;
        }
        if (i <= 62) {
            return ModelAuditLogEntry$TargetType.EMOJI;
        }
        if (i <= 82) {
            return ModelAuditLogEntry$TargetType.INTEGRATION;
        }
        if (i <= 85) {
            return ModelAuditLogEntry$TargetType.STAGE_INSTANCE;
        }
        if (i <= 92) {
            return ModelAuditLogEntry$TargetType.STICKER;
        }
        if (i <= 102) {
            return ModelAuditLogEntry$TargetType.GUILD_SCHEDULED_EVENT;
        }
        return i <= 112 ? ModelAuditLogEntry$TargetType.THREAD : ModelAuditLogEntry$TargetType.ALL;
    }
}
