package com.discord.models.domain;

import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import com.discord.models.domain.Model;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ModelNotificationSettings implements Model {
    public static int FORUM_THREAD_CREATED_MASK = 8192 | 16384;
    public static int FORUM_THREAD_CREATED_OFF = 8192;
    public static int FORUM_THREAD_CREATED_ON = 16384;
    public static int FREQUENCY_ALL = 0;
    public static int FREQUENCY_MENTIONS = 1;
    public static int FREQUENCY_NOTHING = 2;
    public static int FREQUENCY_UNSET = 3;
    public static int HIGHLIGHTS_DISABLED = 1;
    public static int HIGHLIGHTS_ENABLED = 2;
    public static int HIGHLIGHTS_NULL;
    public static int NEW_FORUM_POSTS_UNSET;
    private List<ChannelOverride> channelOverrides;
    private transient boolean derivedMute;
    private long guildId;
    private int messageNotifications;
    private boolean mobilePush;
    private ModelMuteConfig muteConfig;
    private boolean muted;
    private int notifyHighlights;
    private boolean suppressEveryone;
    private boolean suppressRoles;
    private int version;

    public ModelNotificationSettings() {
        this.suppressEveryone = false;
        this.suppressRoles = false;
        this.muted = false;
        this.muteConfig = null;
        this.mobilePush = true;
        this.messageNotifications = FREQUENCY_UNSET;
        this.guildId = 0L;
        this.channelOverrides = new ArrayList();
        this.version = 0;
        this.notifyHighlights = HIGHLIGHTS_NULL;
    }

    @Override // com.discord.models.domain.Model
    public void assignField(final Model.JsonReader jsonReader) throws IOException {
        String strNextName = jsonReader.nextName();
        strNextName.hashCode();
        switch (strNextName) {
            case "mute_config":
                if (jsonReader.peek() != JsonToken.NULL) {
                    this.muteConfig = ModelMuteConfig.INSTANCE.parse(jsonReader);
                    break;
                } else {
                    jsonReader.nextNull();
                    break;
                }
                break;
            case "mobile_push":
                this.mobilePush = jsonReader.nextBoolean(this.mobilePush);
                break;
            case "guild_id":
                this.guildId = jsonReader.nextLong(this.guildId);
                break;
            case "channel_overrides":
                this.channelOverrides = jsonReader.nextList(new Model.JsonReader.ItemFactory() { // from class: b.a.m.a.k
                    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
                    public final Object get() {
                        Model.JsonReader jsonReader2 = jsonReader;
                        int i = ModelNotificationSettings.FREQUENCY_ALL;
                        return (ModelNotificationSettings.ChannelOverride) jsonReader2.parse(new ModelNotificationSettings.ChannelOverride());
                    }
                });
                break;
            case "notify_highlights":
                this.notifyHighlights = jsonReader.nextInt(this.notifyHighlights);
                break;
            case "muted":
                this.muted = jsonReader.nextBoolean(this.muted);
                break;
            case "version":
                this.version = jsonReader.nextInt(this.version);
                break;
            case "message_notifications":
                this.messageNotifications = jsonReader.nextInt(this.messageNotifications);
                break;
            case "suppress_roles":
                this.suppressRoles = jsonReader.nextBoolean(this.suppressRoles);
                break;
            case "suppress_everyone":
                this.suppressEveryone = jsonReader.nextBoolean(this.suppressEveryone);
                break;
            default:
                jsonReader.skipValue();
                break;
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof ModelNotificationSettings;
    }

    public ModelNotificationSettings copyAndRecomputeTransientFields(Clock clock) {
        boolean zIsMuted = NotificationSettingsModelUtils.isMuted(this.muted, this.muteConfig, clock);
        ArrayList arrayList = new ArrayList();
        Iterator<ChannelOverride> it = this.channelOverrides.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().copyAndRecomputeTransientFields(clock));
        }
        return new ModelNotificationSettings(this.suppressEveryone, this.suppressRoles, this.muted, this.muteConfig, zIsMuted, this.mobilePush, this.messageNotifications, this.guildId, arrayList, this.version, this.notifyHighlights);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ModelNotificationSettings)) {
            return false;
        }
        ModelNotificationSettings modelNotificationSettings = (ModelNotificationSettings) obj;
        if (!modelNotificationSettings.canEqual(this) || isSuppressEveryone() != modelNotificationSettings.isSuppressEveryone() || isSuppressRoles() != modelNotificationSettings.isSuppressRoles() || isMuted() != modelNotificationSettings.isMuted() || this.derivedMute != modelNotificationSettings.derivedMute || isMobilePush() != modelNotificationSettings.isMobilePush() || getMessageNotifications() != modelNotificationSettings.getMessageNotifications() || getGuildId() != modelNotificationSettings.getGuildId() || getVersion() != modelNotificationSettings.getVersion() || getNotifyHighlights() != modelNotificationSettings.getNotifyHighlights()) {
            return false;
        }
        ModelMuteConfig muteConfig = getMuteConfig();
        ModelMuteConfig muteConfig2 = modelNotificationSettings.getMuteConfig();
        if (muteConfig != null ? !muteConfig.equals(muteConfig2) : muteConfig2 != null) {
            return false;
        }
        List<ChannelOverride> channelOverrides = getChannelOverrides();
        List<ChannelOverride> channelOverrides2 = modelNotificationSettings.getChannelOverrides();
        return channelOverrides != null ? channelOverrides.equals(channelOverrides2) : channelOverrides2 == null;
    }

    public ChannelOverride getChannelOverride(long j) {
        List<ChannelOverride> list = this.channelOverrides;
        if (list == null) {
            return null;
        }
        for (ChannelOverride channelOverride : list) {
            if (channelOverride.getChannelId() == j) {
                return channelOverride;
            }
        }
        return null;
    }

    public List<ChannelOverride> getChannelOverrides() {
        return this.channelOverrides;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public int getMessageNotifications() {
        return this.messageNotifications;
    }

    public ModelMuteConfig getMuteConfig() {
        return this.muteConfig;
    }

    public String getMuteEndTime() {
        ModelMuteConfig modelMuteConfig = this.muteConfig;
        if (modelMuteConfig != null) {
            return modelMuteConfig.getEndTime();
        }
        return null;
    }

    public long getNextMuteEndTimeMs(Clock clock) {
        Long endTimeMs;
        long jCurrentTimeMillis = clock.currentTimeMillis();
        ModelMuteConfig modelMuteConfig = this.muteConfig;
        long jLongValue = (modelMuteConfig == null || (endTimeMs = modelMuteConfig.getEndTimeMs()) == null || endTimeMs.longValue() <= jCurrentTimeMillis) ? RecyclerView.FOREVER_NS : endTimeMs.longValue();
        Iterator<ChannelOverride> it = this.channelOverrides.iterator();
        while (it.hasNext()) {
            ModelMuteConfig modelMuteConfig2 = it.next().muteConfig;
            Long endTimeMs2 = modelMuteConfig2 != null ? modelMuteConfig2.getEndTimeMs() : Long.MIN_VALUE;
            if (endTimeMs2 != null && endTimeMs2.longValue() > jCurrentTimeMillis) {
                jLongValue = Math.min(jLongValue, endTimeMs2.longValue());
            }
        }
        return jLongValue;
    }

    public int getNotifyHighlights() {
        return this.notifyHighlights;
    }

    public int getVersion() {
        return this.version;
    }

    public int hashCode() {
        int messageNotifications = getMessageNotifications() + (((((((((((isSuppressEveryone() ? 79 : 97) + 59) * 59) + (isSuppressRoles() ? 79 : 97)) * 59) + (isMuted() ? 79 : 97)) * 59) + (this.derivedMute ? 79 : 97)) * 59) + (isMobilePush() ? 79 : 97)) * 59);
        long guildId = getGuildId();
        int notifyHighlights = getNotifyHighlights() + ((getVersion() + (((messageNotifications * 59) + ((int) (guildId ^ (guildId >>> 32)))) * 59)) * 59);
        ModelMuteConfig muteConfig = getMuteConfig();
        int iHashCode = (notifyHighlights * 59) + (muteConfig == null ? 43 : muteConfig.hashCode());
        List<ChannelOverride> channelOverrides = getChannelOverrides();
        return (iHashCode * 59) + (channelOverrides != null ? channelOverrides.hashCode() : 43);
    }

    public boolean isMobilePush() {
        return this.mobilePush;
    }

    public boolean isMuted() {
        return this.derivedMute;
    }

    public boolean isSuppressEveryone() {
        return this.suppressEveryone;
    }

    public boolean isSuppressRoles() {
        return this.suppressRoles;
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelNotificationSettings(suppressEveryone=");
        sbU.append(isSuppressEveryone());
        sbU.append(", suppressRoles=");
        sbU.append(isSuppressRoles());
        sbU.append(", muted=");
        sbU.append(isMuted());
        sbU.append(", muteConfig=");
        sbU.append(getMuteConfig());
        sbU.append(", derivedMute=");
        sbU.append(this.derivedMute);
        sbU.append(", mobilePush=");
        sbU.append(isMobilePush());
        sbU.append(", messageNotifications=");
        sbU.append(getMessageNotifications());
        sbU.append(", guildId=");
        sbU.append(getGuildId());
        sbU.append(", channelOverrides=");
        sbU.append(getChannelOverrides());
        sbU.append(", version=");
        sbU.append(getVersion());
        sbU.append(", notifyHighlights=");
        sbU.append(getNotifyHighlights());
        sbU.append(")");
        return sbU.toString();
    }

    public static class ChannelOverride implements Model {
        private long channelId;
        private transient boolean derivedMute;
        private int flags;
        private int messageNotifications;
        private ModelMuteConfig muteConfig;
        private boolean muted;

        public ChannelOverride() {
            this.muted = false;
            this.messageNotifications = ModelNotificationSettings.FREQUENCY_UNSET;
            this.channelId = 0L;
            this.flags = ModelNotificationSettings.NEW_FORUM_POSTS_UNSET;
        }

        @Override // com.discord.models.domain.Model
        public void assignField(Model.JsonReader jsonReader) throws IOException {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "mute_config":
                    if (jsonReader.peek() != JsonToken.NULL) {
                        this.muteConfig = ModelMuteConfig.INSTANCE.parse(jsonReader);
                        break;
                    } else {
                        jsonReader.nextNull();
                        break;
                    }
                    break;
                case "channel_id":
                    this.channelId = jsonReader.nextLong(this.channelId);
                    break;
                case "flags":
                    this.flags = jsonReader.nextInt(this.flags);
                    break;
                case "muted":
                    this.muted = jsonReader.nextBoolean(this.muted);
                    break;
                case "message_notifications":
                    this.messageNotifications = jsonReader.nextInt(this.messageNotifications);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
            this.derivedMute = NotificationSettingsModelUtils.isMuted(this.muted, this.muteConfig, ClockFactory.get());
        }

        public boolean canEqual(Object obj) {
            return obj instanceof ChannelOverride;
        }

        public ChannelOverride copyAndRecomputeTransientFields(Clock clock) {
            return new ChannelOverride(this.muted, this.muteConfig, NotificationSettingsModelUtils.isMuted(this.muted, this.muteConfig, clock), this.messageNotifications, this.flags, this.channelId);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ChannelOverride)) {
                return false;
            }
            ChannelOverride channelOverride = (ChannelOverride) obj;
            if (!channelOverride.canEqual(this) || isMuted() != channelOverride.isMuted() || this.derivedMute != channelOverride.derivedMute || getMessageNotifications() != channelOverride.getMessageNotifications() || getFlags() != channelOverride.getFlags() || getChannelId() != channelOverride.getChannelId()) {
                return false;
            }
            ModelMuteConfig muteConfig = getMuteConfig();
            ModelMuteConfig muteConfig2 = channelOverride.getMuteConfig();
            return muteConfig != null ? muteConfig.equals(muteConfig2) : muteConfig2 == null;
        }

        public long getChannelId() {
            return this.channelId;
        }

        public int getFlags() {
            return this.flags;
        }

        public int getForumPostNotificationSetting() {
            int i = this.flags;
            int i2 = ModelNotificationSettings.FORUM_THREAD_CREATED_OFF;
            if ((i & i2) == i2) {
                return i2;
            }
            int i3 = ModelNotificationSettings.FORUM_THREAD_CREATED_ON;
            return (i & i3) == i3 ? i3 : ModelNotificationSettings.NEW_FORUM_POSTS_UNSET;
        }

        public int getMessageNotifications() {
            return this.messageNotifications;
        }

        public ModelMuteConfig getMuteConfig() {
            return this.muteConfig;
        }

        public String getMuteEndTime() {
            ModelMuteConfig modelMuteConfig = this.muteConfig;
            if (modelMuteConfig != null) {
                return modelMuteConfig.getEndTime();
            }
            return null;
        }

        public int hashCode() {
            int flags = getFlags() + ((getMessageNotifications() + (((((isMuted() ? 79 : 97) + 59) * 59) + (this.derivedMute ? 79 : 97)) * 59)) * 59);
            long channelId = getChannelId();
            int i = (flags * 59) + ((int) (channelId ^ (channelId >>> 32)));
            ModelMuteConfig muteConfig = getMuteConfig();
            return (i * 59) + (muteConfig == null ? 43 : muteConfig.hashCode());
        }

        public boolean isMuted() {
            return this.derivedMute;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ModelNotificationSettings.ChannelOverride(muted=");
            sbU.append(isMuted());
            sbU.append(", muteConfig=");
            sbU.append(getMuteConfig());
            sbU.append(", derivedMute=");
            sbU.append(this.derivedMute);
            sbU.append(", messageNotifications=");
            sbU.append(getMessageNotifications());
            sbU.append(", flags=");
            sbU.append(getFlags());
            sbU.append(", channelId=");
            sbU.append(getChannelId());
            sbU.append(")");
            return sbU.toString();
        }

        public ChannelOverride(boolean z2, ModelMuteConfig modelMuteConfig, boolean z3, int i, int i2, long j) {
            this.muted = z2;
            this.muteConfig = modelMuteConfig;
            this.derivedMute = z3;
            this.messageNotifications = i;
            this.flags = i2;
            this.channelId = j;
        }
    }

    public ModelNotificationSettings(boolean z2, boolean z3, boolean z4, ModelMuteConfig modelMuteConfig, boolean z5, boolean z6, int i, long j, List<ChannelOverride> list, int i2, int i3) {
        this.suppressEveryone = z2;
        this.suppressRoles = z3;
        this.muted = z4;
        this.muteConfig = modelMuteConfig;
        this.derivedMute = z5;
        this.mobilePush = z6;
        this.messageNotifications = i;
        this.guildId = j;
        this.channelOverrides = list;
        this.version = i2;
        this.notifyHighlights = i3;
    }
}
