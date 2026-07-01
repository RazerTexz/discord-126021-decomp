package com.discord.widgets.servers;

import android.content.Context;
import android.view.MenuItem;
import androidx.core.app.NotificationCompat;
import b.a.d.o;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import rx.functions.Action2;

/* JADX INFO: compiled from: WidgetServerSettingsEditRole.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEditRole$setupMenu$1<T1, T2> implements Action2<MenuItem, Context> {
    public final /* synthetic */ WidgetServerSettingsEditRole$Model $data;
    public final /* synthetic */ WidgetServerSettingsEditRole this$0;

    public WidgetServerSettingsEditRole$setupMenu$1(WidgetServerSettingsEditRole widgetServerSettingsEditRole, WidgetServerSettingsEditRole$Model widgetServerSettingsEditRole$Model) {
        this.this$0 = widgetServerSettingsEditRole;
        this.$data = widgetServerSettingsEditRole$Model;
    }

    @Override // rx.functions.Action2
    public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
        call2(menuItem, context);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(MenuItem menuItem, Context context) {
        m.checkNotNullParameter(menuItem, "menuItem");
        if (menuItem.getItemId() == 2131364387) {
            ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().deleteRole(this.$data.getGuildId(), this.$data.getRole().getId()), false, 1, null), this.this$0, null, 2, null).k(o.j(new WidgetServerSettingsEditRole$setupMenu$1$1(this), this.this$0.getContext(), null, 4));
        }
    }
}
