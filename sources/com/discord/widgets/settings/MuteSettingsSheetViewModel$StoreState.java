package com.discord.widgets.settings;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreThreadsJoined$JoinedThread;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: MuteSettingsSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class MuteSettingsSheetViewModel$StoreState {
    private final Channel channel;
    private final Guild guild;
    private final ModelNotificationSettings guildNotificationSettings;
    private final StoreThreadsJoined$JoinedThread joinedThread;

    public MuteSettingsSheetViewModel$StoreState(Guild guild, Channel channel, ModelNotificationSettings modelNotificationSettings, StoreThreadsJoined$JoinedThread storeThreadsJoined$JoinedThread) {
        this.guild = guild;
        this.channel = channel;
        this.guildNotificationSettings = modelNotificationSettings;
        this.joinedThread = storeThreadsJoined$JoinedThread;
    }

    public static /* synthetic */ MuteSettingsSheetViewModel$StoreState copy$default(MuteSettingsSheetViewModel$StoreState muteSettingsSheetViewModel$StoreState, Guild guild, Channel channel, ModelNotificationSettings modelNotificationSettings, StoreThreadsJoined$JoinedThread storeThreadsJoined$JoinedThread, int i, Object obj) {
        if ((i & 1) != 0) {
            guild = muteSettingsSheetViewModel$StoreState.guild;
        }
        if ((i & 2) != 0) {
            channel = muteSettingsSheetViewModel$StoreState.channel;
        }
        if ((i & 4) != 0) {
            modelNotificationSettings = muteSettingsSheetViewModel$StoreState.guildNotificationSettings;
        }
        if ((i & 8) != 0) {
            storeThreadsJoined$JoinedThread = muteSettingsSheetViewModel$StoreState.joinedThread;
        }
        return muteSettingsSheetViewModel$StoreState.copy(guild, channel, modelNotificationSettings, storeThreadsJoined$JoinedThread);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final ModelNotificationSettings getGuildNotificationSettings() {
        return this.guildNotificationSettings;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final StoreThreadsJoined$JoinedThread getJoinedThread() {
        return this.joinedThread;
    }

    public final MuteSettingsSheetViewModel$StoreState copy(Guild guild, Channel channel, ModelNotificationSettings guildNotificationSettings, StoreThreadsJoined$JoinedThread joinedThread) {
        return new MuteSettingsSheetViewModel$StoreState(guild, channel, guildNotificationSettings, joinedThread);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MuteSettingsSheetViewModel$StoreState)) {
            return false;
        }
        MuteSettingsSheetViewModel$StoreState muteSettingsSheetViewModel$StoreState = (MuteSettingsSheetViewModel$StoreState) other;
        return m.areEqual(this.guild, muteSettingsSheetViewModel$StoreState.guild) && m.areEqual(this.channel, muteSettingsSheetViewModel$StoreState.channel) && m.areEqual(this.guildNotificationSettings, muteSettingsSheetViewModel$StoreState.guildNotificationSettings) && m.areEqual(this.joinedThread, muteSettingsSheetViewModel$StoreState.joinedThread);
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final ModelNotificationSettings getGuildNotificationSettings() {
        return this.guildNotificationSettings;
    }

    public final StoreThreadsJoined$JoinedThread getJoinedThread() {
        return this.joinedThread;
    }

    public int hashCode() {
        Guild guild = this.guild;
        int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
        Channel channel = this.channel;
        int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
        ModelNotificationSettings modelNotificationSettings = this.guildNotificationSettings;
        int iHashCode3 = (iHashCode2 + (modelNotificationSettings != null ? modelNotificationSettings.hashCode() : 0)) * 31;
        StoreThreadsJoined$JoinedThread storeThreadsJoined$JoinedThread = this.joinedThread;
        return iHashCode3 + (storeThreadsJoined$JoinedThread != null ? storeThreadsJoined$JoinedThread.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreState(guild=");
        sbU.append(this.guild);
        sbU.append(", channel=");
        sbU.append(this.channel);
        sbU.append(", guildNotificationSettings=");
        sbU.append(this.guildNotificationSettings);
        sbU.append(", joinedThread=");
        sbU.append(this.joinedThread);
        sbU.append(")");
        return sbU.toString();
    }

    public /* synthetic */ MuteSettingsSheetViewModel$StoreState(Guild guild, Channel channel, ModelNotificationSettings modelNotificationSettings, StoreThreadsJoined$JoinedThread storeThreadsJoined$JoinedThread, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(guild, channel, (i & 4) != 0 ? null : modelNotificationSettings, storeThreadsJoined$JoinedThread);
    }
}
