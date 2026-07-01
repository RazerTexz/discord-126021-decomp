package com.discord.widgets.servers.auditlog;

import com.discord.models.member.GuildMember;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Map$Entry;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsAuditLogFilter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLogFilter$Model$Companion$getPermissionUserIds$1$2 extends o implements Function1<Map$Entry<? extends Long, ? extends GuildMember>, Long> {
    public static final WidgetServerSettingsAuditLogFilter$Model$Companion$getPermissionUserIds$1$2 INSTANCE = new WidgetServerSettingsAuditLogFilter$Model$Companion$getPermissionUserIds$1$2();

    public WidgetServerSettingsAuditLogFilter$Model$Companion$getPermissionUserIds$1$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Long invoke(Map$Entry<? extends Long, ? extends GuildMember> map$Entry) {
        return Long.valueOf(invoke2((Map$Entry<Long, GuildMember>) map$Entry));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2(Map$Entry<Long, GuildMember> map$Entry) {
        m.checkNotNullParameter(map$Entry, "it");
        return map$Entry.getKey().longValue();
    }
}
