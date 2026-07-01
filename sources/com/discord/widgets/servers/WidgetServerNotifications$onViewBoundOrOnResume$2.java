package com.discord.widgets.servers;

import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerNotifications.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerNotifications$onViewBoundOrOnResume$2 extends o implements Function1<List<? extends NotificationsOverridesAdapter$Item>, Unit> {
    public final /* synthetic */ WidgetServerNotifications this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerNotifications$onViewBoundOrOnResume$2(WidgetServerNotifications widgetServerNotifications) {
        super(1);
        this.this$0 = widgetServerNotifications;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends NotificationsOverridesAdapter$Item> list) {
        invoke2((List<NotificationsOverridesAdapter$Item>) list);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<NotificationsOverridesAdapter$Item> list) {
        NotificationsOverridesAdapter notificationsOverridesAdapterAccess$getOverrideAdapter$p = WidgetServerNotifications.access$getOverrideAdapter$p(this.this$0);
        m.checkNotNullExpressionValue(list, "it");
        notificationsOverridesAdapterAccess$getOverrideAdapter$p.setData(list);
    }
}
