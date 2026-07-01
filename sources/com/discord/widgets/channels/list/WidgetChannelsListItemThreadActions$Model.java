package com.discord.widgets.channels.list;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreThreadsJoined$JoinedThread;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChannelsListItemThreadActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChannelsListItemThreadActions$Model {
    public static final WidgetChannelsListItemThreadActions$Model$Companion Companion = new WidgetChannelsListItemThreadActions$Model$Companion(null);
    private final boolean canManageThread;
    private final boolean canUnarchiveThread;
    private final Channel channel;
    private final Guild guild;
    private final boolean isActiveThread;
    private final boolean isDeveloper;
    private final boolean isModerator;
    private final boolean isMuted;
    private final StoreThreadsJoined$JoinedThread joinedThread;
    private final MeUser meUser;
    private final int notificationSetting;
    private final Channel parentChannel;

    public WidgetChannelsListItemThreadActions$Model(MeUser meUser, Channel channel, Guild guild, Channel channel2, int i, StoreThreadsJoined$JoinedThread storeThreadsJoined$JoinedThread, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        m.checkNotNullParameter(meUser, "meUser");
        m.checkNotNullParameter(channel, "channel");
        this.meUser = meUser;
        this.channel = channel;
        this.guild = guild;
        this.parentChannel = channel2;
        this.notificationSetting = i;
        this.joinedThread = storeThreadsJoined$JoinedThread;
        this.isActiveThread = z2;
        this.isModerator = z3;
        this.canManageThread = z4;
        this.canUnarchiveThread = z5;
        this.isMuted = z6;
        this.isDeveloper = StoreStream.Companion.getUserSettings().getIsDeveloperMode();
    }

    public static /* synthetic */ WidgetChannelsListItemThreadActions$Model copy$default(WidgetChannelsListItemThreadActions$Model widgetChannelsListItemThreadActions$Model, MeUser meUser, Channel channel, Guild guild, Channel channel2, int i, StoreThreadsJoined$JoinedThread storeThreadsJoined$JoinedThread, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i2, Object obj) {
        return widgetChannelsListItemThreadActions$Model.copy((i2 & 1) != 0 ? widgetChannelsListItemThreadActions$Model.meUser : meUser, (i2 & 2) != 0 ? widgetChannelsListItemThreadActions$Model.channel : channel, (i2 & 4) != 0 ? widgetChannelsListItemThreadActions$Model.guild : guild, (i2 & 8) != 0 ? widgetChannelsListItemThreadActions$Model.parentChannel : channel2, (i2 & 16) != 0 ? widgetChannelsListItemThreadActions$Model.notificationSetting : i, (i2 & 32) != 0 ? widgetChannelsListItemThreadActions$Model.joinedThread : storeThreadsJoined$JoinedThread, (i2 & 64) != 0 ? widgetChannelsListItemThreadActions$Model.isActiveThread : z2, (i2 & 128) != 0 ? widgetChannelsListItemThreadActions$Model.isModerator : z3, (i2 & 256) != 0 ? widgetChannelsListItemThreadActions$Model.canManageThread : z4, (i2 & 512) != 0 ? widgetChannelsListItemThreadActions$Model.canUnarchiveThread : z5, (i2 & 1024) != 0 ? widgetChannelsListItemThreadActions$Model.isMuted : z6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MeUser getMeUser() {
        return this.meUser;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getCanUnarchiveThread() {
        return this.canUnarchiveThread;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final boolean getIsMuted() {
        return this.isMuted;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Channel getParentChannel() {
        return this.parentChannel;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getNotificationSetting() {
        return this.notificationSetting;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final StoreThreadsJoined$JoinedThread getJoinedThread() {
        return this.joinedThread;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getIsActiveThread() {
        return this.isActiveThread;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getIsModerator() {
        return this.isModerator;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getCanManageThread() {
        return this.canManageThread;
    }

    public final WidgetChannelsListItemThreadActions$Model copy(MeUser meUser, Channel channel, Guild guild, Channel parentChannel, int notificationSetting, StoreThreadsJoined$JoinedThread joinedThread, boolean isActiveThread, boolean isModerator, boolean canManageThread, boolean canUnarchiveThread, boolean isMuted) {
        m.checkNotNullParameter(meUser, "meUser");
        m.checkNotNullParameter(channel, "channel");
        return new WidgetChannelsListItemThreadActions$Model(meUser, channel, guild, parentChannel, notificationSetting, joinedThread, isActiveThread, isModerator, canManageThread, canUnarchiveThread, isMuted);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChannelsListItemThreadActions$Model)) {
            return false;
        }
        WidgetChannelsListItemThreadActions$Model widgetChannelsListItemThreadActions$Model = (WidgetChannelsListItemThreadActions$Model) other;
        return m.areEqual(this.meUser, widgetChannelsListItemThreadActions$Model.meUser) && m.areEqual(this.channel, widgetChannelsListItemThreadActions$Model.channel) && m.areEqual(this.guild, widgetChannelsListItemThreadActions$Model.guild) && m.areEqual(this.parentChannel, widgetChannelsListItemThreadActions$Model.parentChannel) && this.notificationSetting == widgetChannelsListItemThreadActions$Model.notificationSetting && m.areEqual(this.joinedThread, widgetChannelsListItemThreadActions$Model.joinedThread) && this.isActiveThread == widgetChannelsListItemThreadActions$Model.isActiveThread && this.isModerator == widgetChannelsListItemThreadActions$Model.isModerator && this.canManageThread == widgetChannelsListItemThreadActions$Model.canManageThread && this.canUnarchiveThread == widgetChannelsListItemThreadActions$Model.canUnarchiveThread && this.isMuted == widgetChannelsListItemThreadActions$Model.isMuted;
    }

    public final boolean getCanManageThread() {
        return this.canManageThread;
    }

    public final boolean getCanUnarchiveThread() {
        return this.canUnarchiveThread;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final StoreThreadsJoined$JoinedThread getJoinedThread() {
        return this.joinedThread;
    }

    public final MeUser getMeUser() {
        return this.meUser;
    }

    public final int getNotificationSetting() {
        return this.notificationSetting;
    }

    public final Channel getParentChannel() {
        return this.parentChannel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r0v18, types: [int] */
    /* JADX WARN: Type inference failed for: r0v20, types: [int] */
    /* JADX WARN: Type inference failed for: r0v22, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9, types: [int] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12, types: [int] */
    /* JADX WARN: Type inference failed for: r2v13 */
    public int hashCode() {
        MeUser meUser = this.meUser;
        int iHashCode = (meUser != null ? meUser.hashCode() : 0) * 31;
        Channel channel = this.channel;
        int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
        Guild guild = this.guild;
        int iHashCode3 = (iHashCode2 + (guild != null ? guild.hashCode() : 0)) * 31;
        Channel channel2 = this.parentChannel;
        int iHashCode4 = (((iHashCode3 + (channel2 != null ? channel2.hashCode() : 0)) * 31) + this.notificationSetting) * 31;
        StoreThreadsJoined$JoinedThread storeThreadsJoined$JoinedThread = this.joinedThread;
        int iHashCode5 = (iHashCode4 + (storeThreadsJoined$JoinedThread != null ? storeThreadsJoined$JoinedThread.hashCode() : 0)) * 31;
        boolean z2 = this.isActiveThread;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i = (iHashCode5 + r1) * 31;
        boolean z3 = this.isModerator;
        ?? r2 = z3;
        if (z3) {
            r2 = 1;
        }
        int i2 = (i + r2) * 31;
        boolean z4 = this.canManageThread;
        ?? r3 = z4;
        if (z4) {
            r3 = 1;
        }
        int i3 = (i2 + r3) * 31;
        boolean z5 = this.canUnarchiveThread;
        ?? r4 = z5;
        if (z5) {
            r4 = 1;
        }
        int i4 = (i3 + r4) * 31;
        boolean z6 = this.isMuted;
        return i4 + (z6 ? 1 : z6);
    }

    public final boolean isActiveThread() {
        return this.isActiveThread;
    }

    /* JADX INFO: renamed from: isDeveloper, reason: from getter */
    public final boolean getIsDeveloper() {
        return this.isDeveloper;
    }

    public final boolean isModerator() {
        return this.isModerator;
    }

    public final boolean isMuted() {
        return this.isMuted;
    }

    public String toString() {
        StringBuilder sbU = a.U("Model(meUser=");
        sbU.append(this.meUser);
        sbU.append(", channel=");
        sbU.append(this.channel);
        sbU.append(", guild=");
        sbU.append(this.guild);
        sbU.append(", parentChannel=");
        sbU.append(this.parentChannel);
        sbU.append(", notificationSetting=");
        sbU.append(this.notificationSetting);
        sbU.append(", joinedThread=");
        sbU.append(this.joinedThread);
        sbU.append(", isActiveThread=");
        sbU.append(this.isActiveThread);
        sbU.append(", isModerator=");
        sbU.append(this.isModerator);
        sbU.append(", canManageThread=");
        sbU.append(this.canManageThread);
        sbU.append(", canUnarchiveThread=");
        sbU.append(this.canUnarchiveThread);
        sbU.append(", isMuted=");
        return a.O(sbU, this.isMuted, ")");
    }
}
