package com.discord.widgets.servers;

import android.content.Context;
import com.discord.widgets.channels.settings.WidgetChannelNotificationSettings;
import com.discord.widgets.channels.settings.WidgetChannelNotificationSettings$Companion;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerNotificationsOverrideSelector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerNotificationsOverrideSelector$onViewBound$2 extends o implements Function1<Long, Unit> {
    public final /* synthetic */ WidgetServerNotificationsOverrideSelector this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerNotificationsOverrideSelector$onViewBound$2(WidgetServerNotificationsOverrideSelector widgetServerNotificationsOverrideSelector) {
        super(1);
        this.this$0 = widgetServerNotificationsOverrideSelector;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
        invoke(l.longValue());
        return Unit.a;
    }

    public final void invoke(long j) {
        Context context = this.this$0.getContext();
        if (context != null) {
            WidgetChannelNotificationSettings$Companion widgetChannelNotificationSettings$Companion = WidgetChannelNotificationSettings.Companion;
            m.checkNotNullExpressionValue(context, "it");
            WidgetChannelNotificationSettings$Companion.launch$default(widgetChannelNotificationSettings$Companion, context, j, false, 4, null);
        }
    }
}
