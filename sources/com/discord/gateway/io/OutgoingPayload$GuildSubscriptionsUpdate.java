package com.discord.gateway.io;

import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: Outgoing.kt */
/* JADX INFO: loaded from: classes.dex */
public final class OutgoingPayload$GuildSubscriptionsUpdate extends OutgoingPayload {
    private final Boolean activities;
    private final Map<Long, List<List<Integer>>> channels;
    private final long guildId;
    private final List<Long> members;
    private final List<Long> threadMemberLists;
    private final Boolean threads;
    private final Boolean typing;

    /* JADX WARN: Multi-variable type inference failed */
    public OutgoingPayload$GuildSubscriptionsUpdate(long j, Boolean bool, Boolean bool2, List<Long> list, Map<Long, ? extends List<? extends List<Integer>>> map, Boolean bool3, List<Long> list2) {
        super(null);
        this.guildId = j;
        this.typing = bool;
        this.activities = bool2;
        this.members = list;
        this.channels = map;
        this.threads = bool3;
        this.threadMemberLists = list2;
    }

    public final Boolean getActivities() {
        return this.activities;
    }

    public final Map<Long, List<List<Integer>>> getChannels() {
        return this.channels;
    }

    public final long getGuildId() {
        return this.guildId;
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
}
