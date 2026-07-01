package com.discord.widgets.servers.auditlog;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreStream;
import kotlin.jvm.functions.Function0;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetServerSettingsAuditLogFilterAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLogFilterAdapter$AuditLogFilterActionViewHolder$onConfigure$1<T> implements Action1<Boolean> {
    public final /* synthetic */ WidgetServerSettingsAuditLogFilterAdapter$AuditLogActionFilterItem $item;
    public final /* synthetic */ WidgetServerSettingsAuditLogFilterAdapter$AuditLogFilterActionViewHolder this$0;

    public WidgetServerSettingsAuditLogFilterAdapter$AuditLogFilterActionViewHolder$onConfigure$1(WidgetServerSettingsAuditLogFilterAdapter$AuditLogFilterActionViewHolder widgetServerSettingsAuditLogFilterAdapter$AuditLogFilterActionViewHolder, WidgetServerSettingsAuditLogFilterAdapter$AuditLogActionFilterItem widgetServerSettingsAuditLogFilterAdapter$AuditLogActionFilterItem) {
        this.this$0 = widgetServerSettingsAuditLogFilterAdapter$AuditLogFilterActionViewHolder;
        this.$item = widgetServerSettingsAuditLogFilterAdapter$AuditLogActionFilterItem;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Boolean bool) {
        call2(bool);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Boolean bool) {
        StoreStream.Companion.getAuditLog().setAuditLogFilterActionId(this.$item.getActionId());
        Function0 function0Access$getOnFilterSelectedCallback$p = WidgetServerSettingsAuditLogFilterAdapter.access$getOnFilterSelectedCallback$p(WidgetServerSettingsAuditLogFilterAdapter$AuditLogFilterActionViewHolder.access$getAdapter$p(this.this$0));
        if (function0Access$getOnFilterSelectedCallback$p != null) {
        }
    }
}
