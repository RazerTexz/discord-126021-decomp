package com.discord.widgets.status;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreThreadsActiveJoined$ActiveJoinedThread;
import d0.z.d.m;
import java.util.Map;

/* JADX INFO: compiled from: WidgetThreadStatusViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetThreadStatusViewModel$StoreState {
    private final Map<Long, Map<Long, StoreThreadsActiveJoined$ActiveJoinedThread>> activeJoinedThreads;
    private final boolean canAccessRedesignedForumChannels;
    private final boolean canArchive;
    private final boolean isModerator;
    private final Channel parentChannel;
    private final Channel selectedChannel;

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetThreadStatusViewModel$StoreState(Map<Long, ? extends Map<Long, StoreThreadsActiveJoined$ActiveJoinedThread>> map, Channel channel, Channel channel2, boolean z2, boolean z3, boolean z4) {
        m.checkNotNullParameter(map, "activeJoinedThreads");
        this.activeJoinedThreads = map;
        this.selectedChannel = channel;
        this.parentChannel = channel2;
        this.canArchive = z2;
        this.isModerator = z3;
        this.canAccessRedesignedForumChannels = z4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetThreadStatusViewModel$StoreState copy$default(WidgetThreadStatusViewModel$StoreState widgetThreadStatusViewModel$StoreState, Map map, Channel channel, Channel channel2, boolean z2, boolean z3, boolean z4, int i, Object obj) {
        if ((i & 1) != 0) {
            map = widgetThreadStatusViewModel$StoreState.activeJoinedThreads;
        }
        if ((i & 2) != 0) {
            channel = widgetThreadStatusViewModel$StoreState.selectedChannel;
        }
        Channel channel3 = channel;
        if ((i & 4) != 0) {
            channel2 = widgetThreadStatusViewModel$StoreState.parentChannel;
        }
        Channel channel4 = channel2;
        if ((i & 8) != 0) {
            z2 = widgetThreadStatusViewModel$StoreState.canArchive;
        }
        boolean z5 = z2;
        if ((i & 16) != 0) {
            z3 = widgetThreadStatusViewModel$StoreState.isModerator;
        }
        boolean z6 = z3;
        if ((i & 32) != 0) {
            z4 = widgetThreadStatusViewModel$StoreState.canAccessRedesignedForumChannels;
        }
        return widgetThreadStatusViewModel$StoreState.copy(map, channel3, channel4, z5, z6, z4);
    }

    public final Map<Long, Map<Long, StoreThreadsActiveJoined$ActiveJoinedThread>> component1() {
        return this.activeJoinedThreads;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Channel getSelectedChannel() {
        return this.selectedChannel;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Channel getParentChannel() {
        return this.parentChannel;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getCanArchive() {
        return this.canArchive;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsModerator() {
        return this.isModerator;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getCanAccessRedesignedForumChannels() {
        return this.canAccessRedesignedForumChannels;
    }

    public final WidgetThreadStatusViewModel$StoreState copy(Map<Long, ? extends Map<Long, StoreThreadsActiveJoined$ActiveJoinedThread>> activeJoinedThreads, Channel selectedChannel, Channel parentChannel, boolean canArchive, boolean isModerator, boolean canAccessRedesignedForumChannels) {
        m.checkNotNullParameter(activeJoinedThreads, "activeJoinedThreads");
        return new WidgetThreadStatusViewModel$StoreState(activeJoinedThreads, selectedChannel, parentChannel, canArchive, isModerator, canAccessRedesignedForumChannels);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetThreadStatusViewModel$StoreState)) {
            return false;
        }
        WidgetThreadStatusViewModel$StoreState widgetThreadStatusViewModel$StoreState = (WidgetThreadStatusViewModel$StoreState) other;
        return m.areEqual(this.activeJoinedThreads, widgetThreadStatusViewModel$StoreState.activeJoinedThreads) && m.areEqual(this.selectedChannel, widgetThreadStatusViewModel$StoreState.selectedChannel) && m.areEqual(this.parentChannel, widgetThreadStatusViewModel$StoreState.parentChannel) && this.canArchive == widgetThreadStatusViewModel$StoreState.canArchive && this.isModerator == widgetThreadStatusViewModel$StoreState.isModerator && this.canAccessRedesignedForumChannels == widgetThreadStatusViewModel$StoreState.canAccessRedesignedForumChannels;
    }

    public final Map<Long, Map<Long, StoreThreadsActiveJoined$ActiveJoinedThread>> getActiveJoinedThreads() {
        return this.activeJoinedThreads;
    }

    public final boolean getCanAccessRedesignedForumChannels() {
        return this.canAccessRedesignedForumChannels;
    }

    public final boolean getCanArchive() {
        return this.canArchive;
    }

    public final Channel getParentChannel() {
        return this.parentChannel;
    }

    public final Channel getSelectedChannel() {
        return this.selectedChannel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    public int hashCode() {
        Map<Long, Map<Long, StoreThreadsActiveJoined$ActiveJoinedThread>> map = this.activeJoinedThreads;
        int iHashCode = (map != null ? map.hashCode() : 0) * 31;
        Channel channel = this.selectedChannel;
        int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
        Channel channel2 = this.parentChannel;
        int iHashCode3 = (iHashCode2 + (channel2 != null ? channel2.hashCode() : 0)) * 31;
        boolean z2 = this.canArchive;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i = (iHashCode3 + r1) * 31;
        boolean z3 = this.isModerator;
        ?? r2 = z3;
        if (z3) {
            r2 = 1;
        }
        int i2 = (i + r2) * 31;
        boolean z4 = this.canAccessRedesignedForumChannels;
        return i2 + (z4 ? 1 : z4);
    }

    public final boolean isModerator() {
        return this.isModerator;
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreState(activeJoinedThreads=");
        sbU.append(this.activeJoinedThreads);
        sbU.append(", selectedChannel=");
        sbU.append(this.selectedChannel);
        sbU.append(", parentChannel=");
        sbU.append(this.parentChannel);
        sbU.append(", canArchive=");
        sbU.append(this.canArchive);
        sbU.append(", isModerator=");
        sbU.append(this.isModerator);
        sbU.append(", canAccessRedesignedForumChannels=");
        return a.O(sbU, this.canAccessRedesignedForumChannels, ")");
    }
}
