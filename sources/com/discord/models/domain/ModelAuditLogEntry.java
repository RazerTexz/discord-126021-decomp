package com.discord.models.domain;

import b.d.b.a.outline;
import com.discord.models.domain.Model;
import com.discord.models.domain.ModelAuditLogEntry;
import com.google.gson.stream.JsonToken;
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
    private List<Change> changes;
    private Long guildId;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private long f2715id;
    private Options options;
    private String reason;
    private long targetId;
    private Long timestampEnd;
    private long userId;

    /* JADX INFO: renamed from: com.discord.models.domain.ModelAuditLogEntry$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$google$gson$stream$JsonToken;

        static {
            JsonToken.values();
            int[] iArr = new int[10];
            $SwitchMap$com$google$gson$stream$JsonToken = iArr;
            try {
                iArr[6] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[5] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public enum ActionType {
        ALL,
        CREATE,
        UPDATE,
        DELETE
    }

    public static class Change implements Model {
        private String key;
        private Object newValue;
        private Object oldValue;

        public Change() {
        }

        @Override // com.discord.models.domain.Model
        public void assignField(Model.JsonReader jsonReader) throws IOException {
            ValueFactory valueFactory = new ValueFactory(jsonReader);
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "new_value":
                    this.newValue = jsonReader.parseUnknown(valueFactory);
                    break;
                case "key":
                    this.key = jsonReader.nextString(this.key);
                    break;
                case "old_value":
                    this.oldValue = jsonReader.parseUnknown(valueFactory);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }

        public boolean canEqual(Object obj) {
            return obj instanceof Change;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Change)) {
                return false;
            }
            Change change = (Change) obj;
            if (!change.canEqual(this)) {
                return false;
            }
            String key = getKey();
            String key2 = change.getKey();
            if (key != null ? !key.equals(key2) : key2 != null) {
                return false;
            }
            Object oldValue = getOldValue();
            Object oldValue2 = change.getOldValue();
            if (oldValue != null ? !oldValue.equals(oldValue2) : oldValue2 != null) {
                return false;
            }
            Object newValue = getNewValue();
            Object newValue2 = change.getNewValue();
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
            StringBuilder sbU = outline.U("ModelAuditLogEntry.Change(key=");
            sbU.append(getKey());
            sbU.append(", oldValue=");
            sbU.append(getOldValue());
            sbU.append(", newValue=");
            sbU.append(getNewValue());
            sbU.append(")");
            return sbU.toString();
        }

        public Change(String str, Object obj, Object obj2) {
            this.key = str;
            this.oldValue = obj;
            this.newValue = obj2;
        }
    }

    public static class ChangeNameId implements Model {

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private long f2716id;
        private String name;

        @Override // com.discord.models.domain.Model
        public void assignField(Model.JsonReader jsonReader) throws IOException {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals(ModelAuditLogEntry.CHANGE_KEY_ID)) {
                this.f2716id = jsonReader.nextLong(this.f2716id);
            } else if (strNextName.equals(ModelAuditLogEntry.CHANGE_KEY_NAME)) {
                this.name = jsonReader.nextString(this.name);
            } else {
                jsonReader.skipValue();
            }
        }

        public boolean canEqual(Object obj) {
            return obj instanceof ChangeNameId;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ChangeNameId)) {
                return false;
            }
            ChangeNameId changeNameId = (ChangeNameId) obj;
            if (!changeNameId.canEqual(this) || getId() != changeNameId.getId()) {
                return false;
            }
            String name = getName();
            String name2 = changeNameId.getName();
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
            StringBuilder sbU = outline.U("ModelAuditLogEntry.ChangeNameId(name=");
            sbU.append(getName());
            sbU.append(", id=");
            sbU.append(getId());
            sbU.append(")");
            return sbU.toString();
        }
    }

    public class Options implements Model {
        private long channelId;
        private int count;
        private int deleteMemberDays;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private long f2717id;
        private int membersRemoved;
        private String roleName;
        private int type;

        public Options() {
        }

        @Override // com.discord.models.domain.Model
        public void assignField(Model.JsonReader jsonReader) throws IOException {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "channel_id":
                    this.channelId = jsonReader.nextLong(this.channelId);
                    break;
                case "members_removed":
                    this.membersRemoved = jsonReader.nextInt(this.membersRemoved);
                    break;
                case "delete_member_days":
                    this.deleteMemberDays = jsonReader.nextInt(this.deleteMemberDays);
                    break;
                case "id":
                    this.f2717id = jsonReader.nextLong(this.f2717id);
                    break;
                case "type":
                    this.type = jsonReader.nextInt(this.type);
                    break;
                case "count":
                    this.count = jsonReader.nextInt(this.count);
                    break;
                case "role_name":
                    this.roleName = jsonReader.nextString(this.roleName);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }

        public boolean canEqual(Object obj) {
            return obj instanceof Options;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Options)) {
                return false;
            }
            Options options = (Options) obj;
            if (!options.canEqual(this) || getCount() != options.getCount() || getChannelId() != options.getChannelId() || getDeleteMemberDays() != options.getDeleteMemberDays() || getMembersRemoved() != options.getMembersRemoved() || getType() != options.getType() || getId() != options.getId()) {
                return false;
            }
            String roleName = getRoleName();
            String roleName2 = options.getRoleName();
            return roleName != null ? roleName.equals(roleName2) : roleName2 == null;
        }

        public long getChannelId() {
            return this.channelId;
        }

        public int getCount() {
            return this.count;
        }

        public int getDeleteMemberDays() {
            return this.deleteMemberDays;
        }

        public long getId() {
            return this.f2717id;
        }

        public int getMembersRemoved() {
            return this.membersRemoved;
        }

        public String getRoleName() {
            return this.roleName;
        }

        public int getType() {
            return this.type;
        }

        public int hashCode() {
            int count = getCount() + 59;
            long channelId = getChannelId();
            int type = getType() + ((getMembersRemoved() + ((getDeleteMemberDays() + (((count * 59) + ((int) (channelId ^ (channelId >>> 32)))) * 59)) * 59)) * 59);
            long id2 = getId();
            String roleName = getRoleName();
            return (((type * 59) + ((int) ((id2 >>> 32) ^ id2))) * 59) + (roleName == null ? 43 : roleName.hashCode());
        }

        public String toString() {
            StringBuilder sbU = outline.U("ModelAuditLogEntry.Options(count=");
            sbU.append(getCount());
            sbU.append(", channelId=");
            sbU.append(getChannelId());
            sbU.append(", roleName=");
            sbU.append(getRoleName());
            sbU.append(", deleteMemberDays=");
            sbU.append(getDeleteMemberDays());
            sbU.append(", membersRemoved=");
            sbU.append(getMembersRemoved());
            sbU.append(", type=");
            sbU.append(getType());
            sbU.append(", id=");
            sbU.append(getId());
            sbU.append(")");
            return sbU.toString();
        }
    }

    public enum TargetType {
        ALL,
        UNKNOWN,
        GUILD,
        CHANNEL,
        CHANNEL_OVERWRITE,
        USER,
        ROLE,
        INVITE,
        WEBHOOK,
        EMOJI,
        INTEGRATION,
        STAGE_INSTANCE,
        GUILD_SCHEDULED_EVENT,
        STICKER,
        THREAD
    }

    public static class ValueFactory implements Model.JsonReader.ItemFactory<Object> {
        private final Model.JsonReader reader;

        public ValueFactory(Model.JsonReader jsonReader) {
            this.reader = jsonReader;
        }

        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
        public Object get() throws IOException {
            int iOrdinal = this.reader.peek().ordinal();
            if (iOrdinal == 2) {
                return this.reader.parse(new ChangeNameId());
            }
            if (iOrdinal == 5) {
                return this.reader.nextStringOrNull();
            }
            if (iOrdinal != 6) {
                return null;
            }
            return this.reader.nextLongOrNull();
        }
    }

    public ModelAuditLogEntry() {
    }

    @Override // com.discord.models.domain.Model
    public void assignField(final Model.JsonReader jsonReader) throws IOException {
        String strNextName = jsonReader.nextName();
        strNextName.hashCode();
        switch (strNextName) {
            case "options":
                this.options = (Options) jsonReader.parse(new Options());
                break;
            case "reason":
                this.reason = jsonReader.nextString(this.reason);
                break;
            case "target_id":
                this.targetId = jsonReader.nextLong(this.targetId);
                break;
            case "user_id":
                this.userId = jsonReader.nextLong(this.userId);
                break;
            case "id":
                this.f2715id = jsonReader.nextLong(this.f2715id);
                break;
            case "changes":
                this.changes = jsonReader.nextList(new Model.JsonReader.ItemFactory() { // from class: b.a.m.a.h
                    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
                    public final Object get() {
                        return (ModelAuditLogEntry.Change) jsonReader.parse(new ModelAuditLogEntry.Change());
                    }
                });
                break;
            case "action_type":
                this.actionTypeId = jsonReader.nextInt(this.actionTypeId);
                break;
            default:
                jsonReader.skipValue();
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
        List<Change> changes = getChanges();
        List<Change> changes2 = modelAuditLogEntry.getChanges();
        if (changes != null ? !changes.equals(changes2) : changes2 != null) {
            return false;
        }
        Options options = getOptions();
        Options options2 = modelAuditLogEntry.getOptions();
        if (options != null ? !options.equals(options2) : options2 != null) {
            return false;
        }
        String reason = getReason();
        String reason2 = modelAuditLogEntry.getReason();
        return reason != null ? reason.equals(reason2) : reason2 == null;
    }

    public ActionType getActionType() {
        return getActionType(this.actionTypeId);
    }

    public int getActionTypeId() {
        return this.actionTypeId;
    }

    public List<Change> getChanges() {
        return this.changes;
    }

    public Long getGuildId() {
        return this.guildId;
    }

    public long getId() {
        return this.f2715id;
    }

    public Options getOptions() {
        return this.options;
    }

    public String getReason() {
        return this.reason;
    }

    public long getTargetId() {
        return this.targetId;
    }

    public TargetType getTargetType() {
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
        List<Change> changes = getChanges();
        int iHashCode3 = (iHashCode2 * 59) + (changes == null ? 43 : changes.hashCode());
        Options options = getOptions();
        int iHashCode4 = (iHashCode3 * 59) + (options == null ? 43 : options.hashCode());
        String reason = getReason();
        return (iHashCode4 * 59) + (reason != null ? reason.hashCode() : 43);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelAuditLogEntry(id=");
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

    public ModelAuditLogEntry(long j, int i, long j2, long j3, List<Change> list, Options options, long j4, Long l) {
        this.f2715id = j;
        this.actionTypeId = i;
        this.targetId = j2;
        this.userId = j3;
        this.changes = list;
        this.options = options;
        this.guildId = Long.valueOf(j4);
        this.timestampEnd = l;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0021  */
    /* JADX WARN: Code duplicated, block: B:16:0x0024  */
    /* JADX WARN: Code duplicated, block: B:18:0x0027  */
    public static ActionType getActionType(int i) {
        switch (i) {
            case 1:
            case 24:
            case 25:
            case 26:
            case 111:
                return ActionType.UPDATE;
            case 20:
            case 21:
            case 22:
            case 27:
            case 112:
                return ActionType.DELETE;
            case 23:
            case 28:
            case 110:
                return ActionType.CREATE;
            default:
                switch (i) {
                    case 10:
                    case 13:
                        return ActionType.CREATE;
                    case 11:
                    case 14:
                        return ActionType.UPDATE;
                    case 12:
                    case 15:
                        return ActionType.DELETE;
                    default:
                        switch (i) {
                            case 30:
                                return ActionType.CREATE;
                            case 31:
                                return ActionType.UPDATE;
                            case 32:
                                return ActionType.DELETE;
                            default:
                                switch (i) {
                                    case 40:
                                        return ActionType.CREATE;
                                    case 41:
                                        return ActionType.UPDATE;
                                    case 42:
                                        return ActionType.DELETE;
                                    default:
                                        switch (i) {
                                            case 50:
                                                return ActionType.CREATE;
                                            case 51:
                                                return ActionType.UPDATE;
                                            case 52:
                                                return ActionType.DELETE;
                                            default:
                                                switch (i) {
                                                    case 60:
                                                        return ActionType.CREATE;
                                                    case 61:
                                                        return ActionType.UPDATE;
                                                    case 62:
                                                        return ActionType.DELETE;
                                                    default:
                                                        switch (i) {
                                                            case 72:
                                                            case 73:
                                                            case 75:
                                                                return ActionType.DELETE;
                                                            case 74:
                                                                return ActionType.CREATE;
                                                            default:
                                                                switch (i) {
                                                                    case 80:
                                                                    case 83:
                                                                        return ActionType.CREATE;
                                                                    case 81:
                                                                    case 84:
                                                                        return ActionType.UPDATE;
                                                                    case 82:
                                                                    case 85:
                                                                        return ActionType.DELETE;
                                                                    default:
                                                                        switch (i) {
                                                                            case 90:
                                                                                return ActionType.CREATE;
                                                                            case 91:
                                                                                return ActionType.UPDATE;
                                                                            case 92:
                                                                                return ActionType.DELETE;
                                                                            default:
                                                                                switch (i) {
                                                                                    case 100:
                                                                                        return ActionType.CREATE;
                                                                                    case 101:
                                                                                        return ActionType.UPDATE;
                                                                                    case 102:
                                                                                        return ActionType.DELETE;
                                                                                    default:
                                                                                        return ActionType.ALL;
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

    public static TargetType getTargetType(int i) {
        if (i == 0) {
            return TargetType.ALL;
        }
        if (i <= 1) {
            return TargetType.GUILD;
        }
        if (i <= 12 || i == 73) {
            return TargetType.CHANNEL;
        }
        if (i <= 15) {
            return TargetType.CHANNEL_OVERWRITE;
        }
        if (i <= 28 || i == 72 || i == 74 || i == 75) {
            return TargetType.USER;
        }
        if (i <= 32) {
            return TargetType.ROLE;
        }
        if (i <= 42) {
            return TargetType.INVITE;
        }
        if (i <= 52) {
            return TargetType.WEBHOOK;
        }
        if (i <= 62) {
            return TargetType.EMOJI;
        }
        if (i <= 82) {
            return TargetType.INTEGRATION;
        }
        if (i <= 85) {
            return TargetType.STAGE_INSTANCE;
        }
        if (i <= 92) {
            return TargetType.STICKER;
        }
        if (i <= 102) {
            return TargetType.GUILD_SCHEDULED_EVENT;
        }
        return i <= 112 ? TargetType.THREAD : TargetType.ALL;
    }
}
