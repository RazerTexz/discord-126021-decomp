package com.discord.widgets.servers.auditlog;

import com.discord.stores.StoreAuditLog$AuditLogState;
import com.discord.utilities.auditlogs.AuditLogUtils;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsAuditLogFilter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLogFilter$Model$Companion$get$2$2 extends o implements Function1<Integer, WidgetServerSettingsAuditLogFilterAdapter$AuditLogActionFilterItem> {
    public final /* synthetic */ StoreAuditLog$AuditLogState $auditLogState;
    public final /* synthetic */ WidgetServerSettingsAuditLogFilter$Model$Companion$get$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsAuditLogFilter$Model$Companion$get$2$2(WidgetServerSettingsAuditLogFilter$Model$Companion$get$2 widgetServerSettingsAuditLogFilter$Model$Companion$get$2, StoreAuditLog$AuditLogState storeAuditLog$AuditLogState) {
        super(1);
        this.this$0 = widgetServerSettingsAuditLogFilter$Model$Companion$get$2;
        this.$auditLogState = storeAuditLog$AuditLogState;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetServerSettingsAuditLogFilterAdapter$AuditLogActionFilterItem invoke(Integer num) {
        return invoke(num.intValue());
    }

    public final WidgetServerSettingsAuditLogFilterAdapter$AuditLogActionFilterItem invoke(int i) {
        String string = this.this$0.$context.getString(AuditLogUtils.INSTANCE.getActionName(i));
        m.checkNotNullExpressionValue(string, "context.getString(AuditLogUtils.getActionName(it))");
        return new WidgetServerSettingsAuditLogFilterAdapter$AuditLogActionFilterItem(i, string, this.$auditLogState.getFilter().getActionFilter() == i);
    }
}
