package com.discord.widgets.servers.auditlog;

import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilterAdapter$onAuditLogAvatarClicked$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetServerSettingsAuditLogFilterAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLogFilterAdapter5 extends Lambda implements Function2<Long, Long, Unit> {
    public static final WidgetServerSettingsAuditLogFilterAdapter5 INSTANCE = new WidgetServerSettingsAuditLogFilterAdapter5();

    public WidgetServerSettingsAuditLogFilterAdapter5() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Long l, Long l2) {
        invoke(l.longValue(), l2);
        return Unit.a;
    }

    public final void invoke(long j, Long l) {
    }
}
