package com.discord.gateway.io;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Outgoing.kt */
/* JADX INFO: loaded from: classes.dex */
public final class OutgoingPayload$GuildSubscriptions extends OutgoingPayload {
    private final Boolean activities;
    private final Map<Long, List<List<Integer>>> channels;
    private final List<Long> members;
    private final List<Long> threadMemberLists;
    private final Boolean threads;
    private final Boolean typing;

    public /* synthetic */ OutgoingPayload$GuildSubscriptions(Map map, Boolean bool, Boolean bool2, List list, Boolean bool3, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : map, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : bool2, (i & 8) != 0 ? null : list, (i & 16) != 0 ? null : bool3, list2);
    }

    public final Boolean getActivities() {
        return this.activities;
    }

    public final Map<Long, List<List<Integer>>> getChannels() {
        return this.channels;
    }

    public final List<Long> getMembers() {
        return this.members;
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

    /* JADX WARN: Multi-variable type inference failed */
    public OutgoingPayload$GuildSubscriptions(Map<Long, ? extends List<? extends List<Integer>>> map, Boolean bool, Boolean bool2, List<Long> list, Boolean bool3, List<Long> list2) {
        super(null);
        this.channels = map;
        this.typing = bool;
        this.activities = bool2;
        this.members = list;
        this.threads = bool3;
        this.threadMemberLists = list2;
    }
}
