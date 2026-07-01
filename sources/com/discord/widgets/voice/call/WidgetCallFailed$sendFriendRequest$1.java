package com.discord.widgets.voice.call;

import androidx.core.app.NotificationCompat;
import b.a.d.m;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetCallFailed.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallFailed$sendFriendRequest$1<T> implements Action1<Void> {
    public final /* synthetic */ WidgetCallFailed this$0;

    public WidgetCallFailed$sendFriendRequest$1(WidgetCallFailed widgetCallFailed) {
        this.this$0 = widgetCallFailed;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Void r1) {
        call2(r1);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Void r4) {
        m.i(this.this$0, 2131889469, 0, 4);
        this.this$0.dismiss();
    }
}
