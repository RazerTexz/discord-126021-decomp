package com.discord.stores;

import androidx.media.AudioAttributesCompat;
import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.user.User;
import com.discord.models.domain.ModelAuditLog;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelGuildIntegration;
import com.discord.models.domain.ModelWebhook;
import com.discord.models.user.CoreUser;
import d0.d0.f;
import d0.t.g0;
import d0.t.h0;
import d0.t.n;
import d0.t.u;
import d0.z.d.m;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreAuditLog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAuditLog$handleFetchSuccess$1 extends o implements Function0<Unit> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ ModelAuditLog $newAuditLog;
    public final /* synthetic */ StoreAuditLog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreAuditLog$handleFetchSuccess$1(StoreAuditLog storeAuditLog, ModelAuditLog modelAuditLog, long j) {
        super(0);
        this.this$0 = storeAuditLog;
        this.$newAuditLog = modelAuditLog;
        this.$guildId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (this.$newAuditLog.getUsers() != null) {
            Map mutableMap = h0.toMutableMap(StoreAuditLog.access$getState$p(this.this$0).getUsers());
            List<User> users = this.$newAuditLog.getUsers();
            m.checkNotNullExpressionValue(users, "newAuditLog.users");
            ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(users, 10));
            for (User user : users) {
                m.checkNotNullExpressionValue(user, "it");
                arrayList.add(new CoreUser(user));
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(f.coerceAtLeast(g0.mapCapacity(d0.t.o.collectionSizeOrDefault(arrayList, 10)), 16));
            for (Object obj : arrayList) {
                linkedHashMap.put(Long.valueOf(((CoreUser) obj).getId()), obj);
            }
            mutableMap.putAll(linkedHashMap);
            StoreAuditLog storeAuditLog = this.this$0;
            StoreAuditLog.access$setState$p(storeAuditLog, StoreAuditLog$AuditLogState.copy$default(StoreAuditLog.access$getState$p(storeAuditLog), 0L, mutableMap, null, null, null, null, null, null, null, null, false, 2045, null));
        }
        if (this.$newAuditLog.getWebhooks() != null) {
            List mutableList = u.toMutableList((Collection) StoreAuditLog.access$getState$p(this.this$0).getWebhooks());
            List<ModelWebhook> webhooks = this.$newAuditLog.getWebhooks();
            m.checkNotNullExpressionValue(webhooks, "newAuditLog.webhooks");
            mutableList.addAll(webhooks);
            StoreAuditLog storeAuditLog2 = this.this$0;
            StoreAuditLog.access$setState$p(storeAuditLog2, StoreAuditLog$AuditLogState.copy$default(StoreAuditLog.access$getState$p(storeAuditLog2), 0L, null, null, mutableList, null, null, null, null, null, null, false, 2039, null));
        }
        if (this.$newAuditLog.getIntegrations() != null) {
            List mutableList2 = u.toMutableList((Collection) StoreAuditLog.access$getState$p(this.this$0).getIntegrations());
            List<ModelGuildIntegration> integrations = this.$newAuditLog.getIntegrations();
            m.checkNotNullExpressionValue(integrations, "newAuditLog.integrations");
            mutableList2.addAll(integrations);
            StoreAuditLog storeAuditLog3 = this.this$0;
            StoreAuditLog.access$setState$p(storeAuditLog3, StoreAuditLog$AuditLogState.copy$default(StoreAuditLog.access$getState$p(storeAuditLog3), 0L, null, null, null, mutableList2, null, null, null, null, null, false, 2031, null));
        }
        if (this.$newAuditLog.getGuildScheduledEvents() != null) {
            StoreAuditLog storeAuditLog4 = this.this$0;
            StoreAuditLog$AuditLogState storeAuditLog$AuditLogStateAccess$getState$p = StoreAuditLog.access$getState$p(storeAuditLog4);
            List<GuildScheduledEvent> guildScheduledEvents = StoreAuditLog.access$getState$p(this.this$0).getGuildScheduledEvents();
            List<GuildScheduledEvent> guildScheduledEvents2 = this.$newAuditLog.getGuildScheduledEvents();
            m.checkNotNullExpressionValue(guildScheduledEvents2, "newAuditLog.guildScheduledEvents");
            StoreAuditLog.access$setState$p(storeAuditLog4, StoreAuditLog$AuditLogState.copy$default(storeAuditLog$AuditLogStateAccess$getState$p, 0L, null, null, null, null, u.plus((Collection) guildScheduledEvents, (Iterable) guildScheduledEvents2), null, null, null, null, false, 2015, null));
        }
        if (this.$newAuditLog.getThreads() != null) {
            StoreAuditLog storeAuditLog5 = this.this$0;
            StoreAuditLog$AuditLogState storeAuditLog$AuditLogStateAccess$getState$p2 = StoreAuditLog.access$getState$p(storeAuditLog5);
            List<Channel> threads = StoreAuditLog.access$getState$p(this.this$0).getThreads();
            List<Channel> threads2 = this.$newAuditLog.getThreads();
            m.checkNotNullExpressionValue(threads2, "newAuditLog.threads");
            StoreAuditLog.access$setState$p(storeAuditLog5, StoreAuditLog$AuditLogState.copy$default(storeAuditLog$AuditLogStateAccess$getState$p2, 0L, null, null, null, null, null, u.plus((Collection) threads, (Iterable) threads2), null, null, null, false, 1983, null));
        }
        List<ModelAuditLogEntry> entries = StoreAuditLog.access$getState$p(this.this$0).getEntries();
        if (entries == null) {
            entries = n.emptyList();
        }
        List mutableList3 = u.toMutableList((Collection) entries);
        StoreAuditLog storeAuditLog6 = this.this$0;
        long j = this.$guildId;
        List<ModelAuditLogEntry> auditLogEntries = this.$newAuditLog.getAuditLogEntries();
        m.checkNotNullExpressionValue(auditLogEntries, "newAuditLog.auditLogEntries");
        mutableList3.addAll(StoreAuditLog.access$transformEntries(storeAuditLog6, j, auditLogEntries));
        StoreAuditLog storeAuditLog7 = this.this$0;
        StoreAuditLog.access$setState$p(storeAuditLog7, StoreAuditLog$AuditLogState.copy$default(StoreAuditLog.access$getState$p(storeAuditLog7), 0L, null, mutableList3, null, null, null, null, null, null, null, false, 2043, null));
        StoreAuditLog storeAuditLog8 = this.this$0;
        StoreAuditLog.access$setState$p(storeAuditLog8, StoreAuditLog$AuditLogState.copy$default(StoreAuditLog.access$getState$p(storeAuditLog8), 0L, null, null, null, null, null, null, null, null, null, false, AudioAttributesCompat.FLAG_ALL, null));
        this.this$0.markChanged();
    }
}
