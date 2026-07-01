package com.discord.widgets.share;

import android.content.Context;
import android.view.MenuItem;
import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import rx.functions.Action2;

/* JADX INFO: compiled from: WidgetIncomingShare.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetIncomingShare$configureUi$2<T1, T2> implements Action2<MenuItem, Context> {
    public final /* synthetic */ WidgetIncomingShare$Model $this_configureUi;
    public final /* synthetic */ WidgetIncomingShare this$0;

    public WidgetIncomingShare$configureUi$2(WidgetIncomingShare widgetIncomingShare, WidgetIncomingShare$Model widgetIncomingShare$Model) {
        this.this$0 = widgetIncomingShare;
        this.$this_configureUi = widgetIncomingShare$Model;
    }

    @Override // rx.functions.Action2
    public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
        call2(menuItem, context);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(MenuItem menuItem, Context context) {
        m.checkNotNullExpressionValue(menuItem, "menuItem");
        if (menuItem.getItemId() != 2131364404) {
            return;
        }
        WidgetIncomingShare widgetIncomingShare = this.this$0;
        m.checkNotNullExpressionValue(context, "ctx");
        WidgetIncomingShare.onSendClicked$default(widgetIncomingShare, context, this.$this_configureUi.getReceiver(), this.$this_configureUi.getGameInviteModel(), this.$this_configureUi.getContentModel(), this.$this_configureUi.getIsOnCooldown(), this.$this_configureUi.getMaxFileSizeMB(), this.$this_configureUi.getIsUserPremium(), null, 128, null);
    }
}
