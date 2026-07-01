package com.discord.widgets.servers.auditlog;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsAuditLogFilter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsAuditLogFilter$onViewBoundOrOnResume$2 extends k implements Function1<WidgetServerSettingsAuditLogFilter$Model, Unit> {
    public WidgetServerSettingsAuditLogFilter$onViewBoundOrOnResume$2(WidgetServerSettingsAuditLogFilter widgetServerSettingsAuditLogFilter) {
        super(1, widgetServerSettingsAuditLogFilter, WidgetServerSettingsAuditLogFilter.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/auditlog/WidgetServerSettingsAuditLogFilter$Model;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetServerSettingsAuditLogFilter$Model widgetServerSettingsAuditLogFilter$Model) {
        invoke2(widgetServerSettingsAuditLogFilter$Model);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetServerSettingsAuditLogFilter$Model widgetServerSettingsAuditLogFilter$Model) {
        m.checkNotNullParameter(widgetServerSettingsAuditLogFilter$Model, "p1");
        WidgetServerSettingsAuditLogFilter.access$configureUI((WidgetServerSettingsAuditLogFilter) this.receiver, widgetServerSettingsAuditLogFilter$Model);
    }
}
