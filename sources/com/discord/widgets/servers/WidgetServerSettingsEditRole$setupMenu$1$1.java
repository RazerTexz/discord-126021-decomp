package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import com.discord.app.AppActivity;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetServerSettingsEditRole.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEditRole$setupMenu$1$1<T> implements Action1<Void> {
    public final /* synthetic */ WidgetServerSettingsEditRole$setupMenu$1 this$0;

    public WidgetServerSettingsEditRole$setupMenu$1$1(WidgetServerSettingsEditRole$setupMenu$1 widgetServerSettingsEditRole$setupMenu$1) {
        this.this$0 = widgetServerSettingsEditRole$setupMenu$1;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Void r1) throws Exception {
        call2(r1);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Void r1) throws Exception {
        AppActivity appActivity = this.this$0.this$0.getAppActivity();
        if (appActivity != null) {
            appActivity.onBackPressed();
        }
    }
}
