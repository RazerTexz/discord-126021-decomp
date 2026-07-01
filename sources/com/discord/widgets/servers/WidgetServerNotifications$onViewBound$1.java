package com.discord.widgets.servers;

import android.content.Context;
import android.view.View;
import com.discord.widgets.channels.settings.WidgetChannelNotificationSettings;
import com.discord.widgets.channels.settings.WidgetChannelNotificationSettings$Companion;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetServerNotifications.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerNotifications$onViewBound$1 extends o implements Function2<View, NotificationsOverridesAdapter$Item, Unit> {
    public static final WidgetServerNotifications$onViewBound$1 INSTANCE = new WidgetServerNotifications$onViewBound$1();

    public WidgetServerNotifications$onViewBound$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(View view, NotificationsOverridesAdapter$Item notificationsOverridesAdapter$Item) {
        invoke2(view, notificationsOverridesAdapter$Item);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view, NotificationsOverridesAdapter$Item notificationsOverridesAdapter$Item) {
        m.checkNotNullParameter(view, "itemView");
        m.checkNotNullParameter(notificationsOverridesAdapter$Item, "item");
        WidgetChannelNotificationSettings$Companion widgetChannelNotificationSettings$Companion = WidgetChannelNotificationSettings.Companion;
        Context context = view.getContext();
        m.checkNotNullExpressionValue(context, "itemView.context");
        WidgetChannelNotificationSettings$Companion.launch$default(widgetChannelNotificationSettings$Companion, context, notificationsOverridesAdapter$Item.getChannel().getId(), false, 4, null);
    }
}
