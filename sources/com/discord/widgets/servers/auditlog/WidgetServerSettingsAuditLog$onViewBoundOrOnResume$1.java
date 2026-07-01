package com.discord.widgets.servers.auditlog;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsAuditLog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsAuditLog$onViewBoundOrOnResume$1 extends k implements Function1<WidgetServerSettingsAuditLog$Model, Unit> {
    public WidgetServerSettingsAuditLog$onViewBoundOrOnResume$1(WidgetServerSettingsAuditLog widgetServerSettingsAuditLog) {
        super(1, widgetServerSettingsAuditLog, WidgetServerSettingsAuditLog.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/auditlog/WidgetServerSettingsAuditLog$Model;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetServerSettingsAuditLog$Model widgetServerSettingsAuditLog$Model) {
        invoke2(widgetServerSettingsAuditLog$Model);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetServerSettingsAuditLog$Model widgetServerSettingsAuditLog$Model) {
        m.checkNotNullParameter(widgetServerSettingsAuditLog$Model, "p1");
        WidgetServerSettingsAuditLog.access$configureUI((WidgetServerSettingsAuditLog) this.receiver, widgetServerSettingsAuditLog$Model);
    }
}
