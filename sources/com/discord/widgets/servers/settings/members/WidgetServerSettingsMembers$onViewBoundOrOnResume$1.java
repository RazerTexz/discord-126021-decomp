package com.discord.widgets.servers.settings.members;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetServerSettingsMembers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsMembers$onViewBoundOrOnResume$1<T> implements Action1<String> {
    public final /* synthetic */ WidgetServerSettingsMembers this$0;

    public WidgetServerSettingsMembers$onViewBoundOrOnResume$1(WidgetServerSettingsMembers widgetServerSettingsMembers) {
        this.this$0 = widgetServerSettingsMembers;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(String str) {
        call2(str);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(String str) {
        WidgetServerSettingsMembers.access$getNameFilterPublisher$p(this.this$0).onNext(str);
    }
}
