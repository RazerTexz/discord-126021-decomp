package com.discord.stores;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelAuditLogEntry$TargetType;
import com.discord.models.domain.ModelGuildIntegration;
import com.discord.models.domain.ModelWebhook;
import com.discord.models.user.User;
import d0.t.h0;
import d0.t.n;
import d0.z.d.m;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StoreAuditLog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreAuditLog$AuditLogState {
    private final Map<ModelAuditLogEntry$TargetType, Map<Long, CharSequence>> deletedTargets;
    private final List<ModelAuditLogEntry> entries;
    private final StoreAuditLog$AuditLogFilter filter;
    private final long guildId;
    private final List<GuildScheduledEvent> guildScheduledEvents;
    private final List<ModelGuildIntegration> integrations;
    private final boolean isLoading;
    private final Long selectedItemId;
    private final List<Channel> threads;
    private final Map<Long, User> users;
    private final List<ModelWebhook> webhooks;

    public StoreAuditLog$AuditLogState() {
        this(0L, null, null, null, null, null, null, null, null, null, false, 2047, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StoreAuditLog$AuditLogState(long j, Map<Long, ? extends User> map, List<? extends ModelAuditLogEntry> list, List<? extends ModelWebhook> list2, List<? extends ModelGuildIntegration> list3, List<GuildScheduledEvent> list4, List<Channel> list5, Long l, StoreAuditLog$AuditLogFilter storeAuditLog$AuditLogFilter, Map<ModelAuditLogEntry$TargetType, ? extends Map<Long, CharSequence>> map2, boolean z2) {
        m.checkNotNullParameter(map, "users");
        m.checkNotNullParameter(list2, "webhooks");
        m.checkNotNullParameter(list3, "integrations");
        m.checkNotNullParameter(list4, "guildScheduledEvents");
        m.checkNotNullParameter(list5, "threads");
        m.checkNotNullParameter(storeAuditLog$AuditLogFilter, "filter");
        m.checkNotNullParameter(map2, "deletedTargets");
        this.guildId = j;
        this.users = map;
        this.entries = list;
        this.webhooks = list2;
        this.integrations = list3;
        this.guildScheduledEvents = list4;
        this.threads = list5;
        this.selectedItemId = l;
        this.filter = storeAuditLog$AuditLogFilter;
        this.deletedTargets = map2;
        this.isLoading = z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StoreAuditLog$AuditLogState copy$default(StoreAuditLog$AuditLogState storeAuditLog$AuditLogState, long j, Map map, List list, List list2, List list3, List list4, List list5, Long l, StoreAuditLog$AuditLogFilter storeAuditLog$AuditLogFilter, Map map2, boolean z2, int i, Object obj) {
        return storeAuditLog$AuditLogState.copy((i & 1) != 0 ? storeAuditLog$AuditLogState.guildId : j, (i & 2) != 0 ? storeAuditLog$AuditLogState.users : map, (i & 4) != 0 ? storeAuditLog$AuditLogState.entries : list, (i & 8) != 0 ? storeAuditLog$AuditLogState.webhooks : list2, (i & 16) != 0 ? storeAuditLog$AuditLogState.integrations : list3, (i & 32) != 0 ? storeAuditLog$AuditLogState.guildScheduledEvents : list4, (i & 64) != 0 ? storeAuditLog$AuditLogState.threads : list5, (i & 128) != 0 ? storeAuditLog$AuditLogState.selectedItemId : l, (i & 256) != 0 ? storeAuditLog$AuditLogState.filter : storeAuditLog$AuditLogFilter, (i & 512) != 0 ? storeAuditLog$AuditLogState.deletedTargets : map2, (i & 1024) != 0 ? storeAuditLog$AuditLogState.isLoading : z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    public final Map<ModelAuditLogEntry$TargetType, Map<Long, CharSequence>> component10() {
        return this.deletedTargets;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final boolean getIsLoading() {
        return this.isLoading;
    }

    public final Map<Long, User> component2() {
        return this.users;
    }

    public final List<ModelAuditLogEntry> component3() {
        return this.entries;
    }

    public final List<ModelWebhook> component4() {
        return this.webhooks;
    }

    public final List<ModelGuildIntegration> component5() {
        return this.integrations;
    }

    public final List<GuildScheduledEvent> component6() {
        return this.guildScheduledEvents;
    }

    public final List<Channel> component7() {
        return this.threads;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Long getSelectedItemId() {
        return this.selectedItemId;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final StoreAuditLog$AuditLogFilter getFilter() {
        return this.filter;
    }

    public final StoreAuditLog$AuditLogState copy(long guildId, Map<Long, ? extends User> users, List<? extends ModelAuditLogEntry> entries, List<? extends ModelWebhook> webhooks, List<? extends ModelGuildIntegration> integrations, List<GuildScheduledEvent> guildScheduledEvents, List<Channel> threads, Long selectedItemId, StoreAuditLog$AuditLogFilter filter, Map<ModelAuditLogEntry$TargetType, ? extends Map<Long, CharSequence>> deletedTargets, boolean isLoading) {
        m.checkNotNullParameter(users, "users");
        m.checkNotNullParameter(webhooks, "webhooks");
        m.checkNotNullParameter(integrations, "integrations");
        m.checkNotNullParameter(guildScheduledEvents, "guildScheduledEvents");
        m.checkNotNullParameter(threads, "threads");
        m.checkNotNullParameter(filter, "filter");
        m.checkNotNullParameter(deletedTargets, "deletedTargets");
        return new StoreAuditLog$AuditLogState(guildId, users, entries, webhooks, integrations, guildScheduledEvents, threads, selectedItemId, filter, deletedTargets, isLoading);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreAuditLog$AuditLogState)) {
            return false;
        }
        StoreAuditLog$AuditLogState storeAuditLog$AuditLogState = (StoreAuditLog$AuditLogState) other;
        return this.guildId == storeAuditLog$AuditLogState.guildId && m.areEqual(this.users, storeAuditLog$AuditLogState.users) && m.areEqual(this.entries, storeAuditLog$AuditLogState.entries) && m.areEqual(this.webhooks, storeAuditLog$AuditLogState.webhooks) && m.areEqual(this.integrations, storeAuditLog$AuditLogState.integrations) && m.areEqual(this.guildScheduledEvents, storeAuditLog$AuditLogState.guildScheduledEvents) && m.areEqual(this.threads, storeAuditLog$AuditLogState.threads) && m.areEqual(this.selectedItemId, storeAuditLog$AuditLogState.selectedItemId) && m.areEqual(this.filter, storeAuditLog$AuditLogState.filter) && m.areEqual(this.deletedTargets, storeAuditLog$AuditLogState.deletedTargets) && this.isLoading == storeAuditLog$AuditLogState.isLoading;
    }

    public final Map<ModelAuditLogEntry$TargetType, Map<Long, CharSequence>> getDeletedTargets() {
        return this.deletedTargets;
    }

    public final List<ModelAuditLogEntry> getEntries() {
        return this.entries;
    }

    public final StoreAuditLog$AuditLogFilter getFilter() {
        return this.filter;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final List<GuildScheduledEvent> getGuildScheduledEvents() {
        return this.guildScheduledEvents;
    }

    public final List<ModelGuildIntegration> getIntegrations() {
        return this.integrations;
    }

    public final Long getSelectedItemId() {
        return this.selectedItemId;
    }

    public final List<Channel> getThreads() {
        return this.threads;
    }

    public final Map<Long, User> getUsers() {
        return this.users;
    }

    public final List<ModelWebhook> getWebhooks() {
        return this.webhooks;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v21, types: [int] */
    /* JADX WARN: Type inference failed for: r1v26, types: [int] */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v36 */
    public int hashCode() {
        int iA = b.a(this.guildId) * 31;
        Map<Long, User> map = this.users;
        int iHashCode = (iA + (map != null ? map.hashCode() : 0)) * 31;
        List<ModelAuditLogEntry> list = this.entries;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        List<ModelWebhook> list2 = this.webhooks;
        int iHashCode3 = (iHashCode2 + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<ModelGuildIntegration> list3 = this.integrations;
        int iHashCode4 = (iHashCode3 + (list3 != null ? list3.hashCode() : 0)) * 31;
        List<GuildScheduledEvent> list4 = this.guildScheduledEvents;
        int iHashCode5 = (iHashCode4 + (list4 != null ? list4.hashCode() : 0)) * 31;
        List<Channel> list5 = this.threads;
        int iHashCode6 = (iHashCode5 + (list5 != null ? list5.hashCode() : 0)) * 31;
        Long l = this.selectedItemId;
        int iHashCode7 = (iHashCode6 + (l != null ? l.hashCode() : 0)) * 31;
        StoreAuditLog$AuditLogFilter storeAuditLog$AuditLogFilter = this.filter;
        int iHashCode8 = (iHashCode7 + (storeAuditLog$AuditLogFilter != null ? storeAuditLog$AuditLogFilter.hashCode() : 0)) * 31;
        Map<ModelAuditLogEntry$TargetType, Map<Long, CharSequence>> map2 = this.deletedTargets;
        int iHashCode9 = (iHashCode8 + (map2 != null ? map2.hashCode() : 0)) * 31;
        boolean z2 = this.isLoading;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode9 + r1;
    }

    public final boolean isLoading() {
        return this.isLoading;
    }

    public String toString() {
        StringBuilder sbU = a.U("AuditLogState(guildId=");
        sbU.append(this.guildId);
        sbU.append(", users=");
        sbU.append(this.users);
        sbU.append(", entries=");
        sbU.append(this.entries);
        sbU.append(", webhooks=");
        sbU.append(this.webhooks);
        sbU.append(", integrations=");
        sbU.append(this.integrations);
        sbU.append(", guildScheduledEvents=");
        sbU.append(this.guildScheduledEvents);
        sbU.append(", threads=");
        sbU.append(this.threads);
        sbU.append(", selectedItemId=");
        sbU.append(this.selectedItemId);
        sbU.append(", filter=");
        sbU.append(this.filter);
        sbU.append(", deletedTargets=");
        sbU.append(this.deletedTargets);
        sbU.append(", isLoading=");
        return a.O(sbU, this.isLoading, ")");
    }

    public /* synthetic */ StoreAuditLog$AuditLogState(long j, Map map, List list, List list2, List list3, List list4, List list5, Long l, StoreAuditLog$AuditLogFilter storeAuditLog$AuditLogFilter, Map map2, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? -1L : j, (i & 2) != 0 ? h0.emptyMap() : map, (i & 4) != 0 ? null : list, (i & 8) != 0 ? n.emptyList() : list2, (i & 16) != 0 ? n.emptyList() : list3, (i & 32) != 0 ? n.emptyList() : list4, (i & 64) != 0 ? n.emptyList() : list5, (i & 128) == 0 ? l : null, (i & 256) != 0 ? StoreAuditLog$AuditLogFilter.Companion.emptyFilter() : storeAuditLog$AuditLogFilter, (i & 512) != 0 ? h0.emptyMap() : map2, (i & 1024) != 0 ? false : z2);
    }
}
