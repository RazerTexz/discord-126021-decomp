package com.discord.widgets.servers;

import android.content.Context;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserGuildSettings;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerNotifications.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerNotifications$configureUI$1 extends o implements Function1<Integer, Unit> {
    public final /* synthetic */ WidgetServerNotifications$Model $model;
    public final /* synthetic */ WidgetServerNotifications this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerNotifications$configureUI$1(WidgetServerNotifications widgetServerNotifications, WidgetServerNotifications$Model widgetServerNotifications$Model) {
        super(1);
        this.this$0 = widgetServerNotifications;
        this.$model = widgetServerNotifications$Model;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.a;
    }

    public final void invoke(int i) {
        StoreUserGuildSettings userGuildSettings = StoreStream.Companion.getUserGuildSettings();
        NotificationHighlightsSettingsView notificationHighlightsSettingsView = WidgetServerNotifications.access$getBinding$p(this.this$0).j;
        m.checkNotNullExpressionValue(notificationHighlightsSettingsView, "binding.serverNotificationsHighlights");
        Context context = notificationHighlightsSettingsView.getContext();
        m.checkNotNullExpressionValue(context, "binding.serverNotificationsHighlights.context");
        userGuildSettings.setNotifyHighlights(context, this.$model.getGuild(), i);
    }
}
