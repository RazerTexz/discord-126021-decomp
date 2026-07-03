package com.discord.widgets.settings.connections;

import com.discord.models.domain.ModelAuditLogEntry;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetSettingsUserConnections.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsUserConnections$onViewBound$$inlined$let$lambda$1 extends AbstractC12240o implements Function1<String, Unit> {
    public final /* synthetic */ WidgetSettingsUserConnections this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsUserConnections$onViewBound$$inlined$let$lambda$1(WidgetSettingsUserConnections widgetSettingsUserConnections) {
        super(1);
        this.this$0 = widgetSettingsUserConnections;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_ID);
        this.this$0.getViewModel().joinConnectionIntegrationGuild(str);
    }
}
