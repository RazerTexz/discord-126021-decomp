package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetServerDeleteDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerDeleteDialog$configureUI$2$1<T> implements Action1<Void> {
    public final /* synthetic */ WidgetServerDeleteDialog$configureUI$2 this$0;

    public WidgetServerDeleteDialog$configureUI$2$1(WidgetServerDeleteDialog$configureUI$2 widgetServerDeleteDialog$configureUI$2) {
        this.this$0 = widgetServerDeleteDialog$configureUI$2;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Void r1) {
        call2(r1);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Void r4) {
        WidgetServerDeleteDialog$configureUI$2 widgetServerDeleteDialog$configureUI$2 = this.this$0;
        WidgetServerDeleteDialog.access$afterDeleteGuild(widgetServerDeleteDialog$configureUI$2.this$0, widgetServerDeleteDialog$configureUI$2.$this_configureUI.getGuild().getId());
    }
}
