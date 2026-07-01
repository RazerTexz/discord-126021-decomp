package com.discord.models.domain;

import b.d.b.a.a;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.google.gson.stream.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class ModelNotificationSettings$ChannelOverride implements Model {
    private long channelId;
    private transient boolean derivedMute;
    private int flags;
    private int messageNotifications;
    private ModelMuteConfig muteConfig;
    private boolean muted;

    public ModelNotificationSettings$ChannelOverride() {
        this.muted = false;
        this.messageNotifications = ModelNotificationSettings.FREQUENCY_UNSET;
        this.channelId = 0L;
        this.flags = ModelNotificationSettings.NEW_FORUM_POSTS_UNSET;
    }

    public static /* synthetic */ ModelMuteConfig access$000(ModelNotificationSettings$ChannelOverride modelNotificationSettings$ChannelOverride) {
        return modelNotificationSettings$ChannelOverride.muteConfig;
    }

    @Override // com.discord.models.domain.Model
    public void assignField(Model$JsonReader model$JsonReader) throws IOException {
        String strNextName = model$JsonReader.nextName();
        strNextName.hashCode();
        switch (strNextName) {
            case "mute_config":
                if (model$JsonReader.peek() != JsonToken.NULL) {
                    this.muteConfig = ModelMuteConfig.Parser.parse(model$JsonReader);
                    break;
                } else {
                    model$JsonReader.nextNull();
                    break;
                }
                break;
            case "channel_id":
                this.channelId = model$JsonReader.nextLong(this.channelId);
                break;
            case "flags":
                this.flags = model$JsonReader.nextInt(this.flags);
                break;
            case "muted":
                this.muted = model$JsonReader.nextBoolean(this.muted);
                break;
            case "message_notifications":
                this.messageNotifications = model$JsonReader.nextInt(this.messageNotifications);
                break;
            default:
                model$JsonReader.skipValue();
                break;
        }
        this.derivedMute = NotificationSettingsModelUtils.isMuted(this.muted, this.muteConfig, ClockFactory.get());
    }

    public boolean canEqual(Object obj) {
        return obj instanceof ModelNotificationSettings$ChannelOverride;
    }

    public ModelNotificationSettings$ChannelOverride copyAndRecomputeTransientFields(Clock clock) {
        return new ModelNotificationSettings$ChannelOverride(this.muted, this.muteConfig, NotificationSettingsModelUtils.isMuted(this.muted, this.muteConfig, clock), this.messageNotifications, this.flags, this.channelId);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ModelNotificationSettings$ChannelOverride)) {
            return false;
        }
        ModelNotificationSettings$ChannelOverride modelNotificationSettings$ChannelOverride = (ModelNotificationSettings$ChannelOverride) obj;
        if (!modelNotificationSettings$ChannelOverride.canEqual(this) || isMuted() != modelNotificationSettings$ChannelOverride.isMuted() || this.derivedMute != modelNotificationSettings$ChannelOverride.derivedMute || getMessageNotifications() != modelNotificationSettings$ChannelOverride.getMessageNotifications() || getFlags() != modelNotificationSettings$ChannelOverride.getFlags() || getChannelId() != modelNotificationSettings$ChannelOverride.getChannelId()) {
            return false;
        }
        ModelMuteConfig muteConfig = getMuteConfig();
        ModelMuteConfig muteConfig2 = modelNotificationSettings$ChannelOverride.getMuteConfig();
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
        StringBuilder sbU = a.U("ModelNotificationSettings.ChannelOverride(muted=");
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

    public ModelNotificationSettings$ChannelOverride(boolean z2, ModelMuteConfig modelMuteConfig, boolean z3, int i, int i2, long j) {
        this.muted = z2;
        this.muteConfig = modelMuteConfig;
        this.derivedMute = z3;
        this.messageNotifications = i;
        this.flags = i2;
        this.channelId = j;
    }
}
