package com.discord.widgets.channels.permissions;

import android.content.Context;
import android.view.MenuItem;
import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import rx.functions.Action2;

/* JADX INFO: compiled from: WidgetChannelSettingsEditPermissions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSettingsEditPermissions$configureUI$1<T1, T2> implements Action2<MenuItem, Context> {
    public final /* synthetic */ WidgetChannelSettingsEditPermissionsModel $model;
    public final /* synthetic */ WidgetChannelSettingsEditPermissions this$0;

    public WidgetChannelSettingsEditPermissions$configureUI$1(WidgetChannelSettingsEditPermissions widgetChannelSettingsEditPermissions, WidgetChannelSettingsEditPermissionsModel widgetChannelSettingsEditPermissionsModel) {
        this.this$0 = widgetChannelSettingsEditPermissions;
        this.$model = widgetChannelSettingsEditPermissionsModel;
    }

    @Override // rx.functions.Action2
    public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
        call2(menuItem, context);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(MenuItem menuItem, Context context) {
        m.checkNotNullExpressionValue(menuItem, "menuItem");
        if (menuItem.getItemId() != 2131364386) {
            return;
        }
        WidgetChannelSettingsEditPermissions.access$deletePermissionOverwrites(this.this$0, this.$model.getChannel().getId(), WidgetChannelSettingsEditPermissions.access$getTargetId$p(this.this$0));
    }
}
