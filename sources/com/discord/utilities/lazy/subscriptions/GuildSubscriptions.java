package com.discord.utilities.lazy.subscriptions;

import b.d.b.a.outline;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.Ranges2;

/* JADX INFO: compiled from: GuildSubscriptions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildSubscriptions {
    private final Boolean activities;
    private final Map<Long, List<Ranges2>> channels;
    private final Set<Long> members;

    /* JADX INFO: renamed from: serializedRanges$delegate, reason: from kotlin metadata */
    private final Lazy serializedRanges;
    private final List<Long> threadMemberLists;
    private final Boolean threads;
    private final Boolean typing;

    public GuildSubscriptions() {
        this(null, null, null, null, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GuildSubscriptions(Map<Long, ? extends List<Ranges2>> map, Boolean bool, Boolean bool2, Set<Long> set, Boolean bool3, List<Long> list) {
        this.channels = map;
        this.typing = bool;
        this.activities = bool2;
        this.members = set;
        this.threads = bool3;
        this.threadMemberLists = list;
        this.serializedRanges = LazyJVM.lazy(new GuildSubscriptions2(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GuildSubscriptions copy$default(GuildSubscriptions guildSubscriptions, Map map, Boolean bool, Boolean bool2, Set set, Boolean bool3, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            map = guildSubscriptions.channels;
        }
        if ((i & 2) != 0) {
            bool = guildSubscriptions.typing;
        }
        Boolean bool4 = bool;
        if ((i & 4) != 0) {
            bool2 = guildSubscriptions.activities;
        }
        Boolean bool5 = bool2;
        if ((i & 8) != 0) {
            set = guildSubscriptions.members;
        }
        Set set2 = set;
        if ((i & 16) != 0) {
            bool3 = guildSubscriptions.threads;
        }
        Boolean bool6 = bool3;
        if ((i & 32) != 0) {
            list = guildSubscriptions.threadMemberLists;
        }
        return guildSubscriptions.copy(map, bool4, bool5, set2, bool6, list);
    }

    public final Map<Long, List<Ranges2>> component1() {
        return this.channels;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Boolean getTyping() {
        return this.typing;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Boolean getActivities() {
        return this.activities;
    }

    public final Set<Long> component4() {
        return this.members;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Boolean getThreads() {
        return this.threads;
    }

    public final List<Long> component6() {
        return this.threadMemberLists;
    }

    public final GuildSubscriptions copy(Map<Long, ? extends List<Ranges2>> channels, Boolean typing, Boolean activities, Set<Long> members, Boolean threads, List<Long> threadMemberLists) {
        return new GuildSubscriptions(channels, typing, activities, members, threads, threadMemberLists);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildSubscriptions)) {
            return false;
        }
        GuildSubscriptions guildSubscriptions = (GuildSubscriptions) other;
        return Intrinsics3.areEqual(this.channels, guildSubscriptions.channels) && Intrinsics3.areEqual(this.typing, guildSubscriptions.typing) && Intrinsics3.areEqual(this.activities, guildSubscriptions.activities) && Intrinsics3.areEqual(this.members, guildSubscriptions.members) && Intrinsics3.areEqual(this.threads, guildSubscriptions.threads) && Intrinsics3.areEqual(this.threadMemberLists, guildSubscriptions.threadMemberLists);
    }

    public final Boolean getActivities() {
        return this.activities;
    }

    public final Map<Long, List<Ranges2>> getChannels() {
        return this.channels;
    }

    public final Set<Long> getMembers() {
        return this.members;
    }

    public final Map<Long, List<List<Integer>>> getSerializedRanges() {
        return (Map) this.serializedRanges.getValue();
    }

    public final List<Long> getThreadMemberLists() {
        return this.threadMemberLists;
    }

    public final Boolean getThreads() {
        return this.threads;
    }

    public final Boolean getTyping() {
        return this.typing;
    }

    public int hashCode() {
        Map<Long, List<Ranges2>> map = this.channels;
        int iHashCode = (map != null ? map.hashCode() : 0) * 31;
        Boolean bool = this.typing;
        int iHashCode2 = (iHashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.activities;
        int iHashCode3 = (iHashCode2 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Set<Long> set = this.members;
        int iHashCode4 = (iHashCode3 + (set != null ? set.hashCode() : 0)) * 31;
        Boolean bool3 = this.threads;
        int iHashCode5 = (iHashCode4 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        List<Long> list = this.threadMemberLists;
        return iHashCode5 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildSubscriptions(channels=");
        sbU.append(this.channels);
        sbU.append(", typing=");
        sbU.append(this.typing);
        sbU.append(", activities=");
        sbU.append(this.activities);
        sbU.append(", members=");
        sbU.append(this.members);
        sbU.append(", threads=");
        sbU.append(this.threads);
        sbU.append(", threadMemberLists=");
        return outline.L(sbU, this.threadMemberLists, ")");
    }

    public /* synthetic */ GuildSubscriptions(Map map, Boolean bool, Boolean bool2, Set set, Boolean bool3, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : map, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : bool2, (i & 8) != 0 ? null : set, (i & 16) != 0 ? null : bool3, (i & 32) != 0 ? null : list);
    }
}
