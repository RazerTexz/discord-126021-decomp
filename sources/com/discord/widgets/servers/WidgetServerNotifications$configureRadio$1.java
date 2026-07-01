package com.discord.widgets.servers;

import android.view.View;
import android.view.View$OnClickListener;
import b.d.b.a.a;
import com.discord.stores.StoreStream;

/* JADX INFO: compiled from: WidgetServerNotifications.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerNotifications$configureRadio$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetServerNotifications$Model $model;
    public final /* synthetic */ int $type;

    public WidgetServerNotifications$configureRadio$1(WidgetServerNotifications$Model widgetServerNotifications$Model, int i) {
        this.$model = widgetServerNotifications$Model;
        this.$type = i;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        StoreStream.Companion.getUserGuildSettings().setGuildFrequency(a.x(view, "view", "view.context"), this.$model.getGuild(), this.$type);
    }
}
