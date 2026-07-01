package com.discord.widgets.voice.call;

import androidx.core.app.NotificationCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPIAbortMessages;
import d0.z.d.m;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetCallFailed.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallFailed$sendFriendRequest$2<T> implements Action1<Error> {
    public final /* synthetic */ long $userId;
    public final /* synthetic */ String $username;
    public final /* synthetic */ WidgetCallFailed this$0;

    public WidgetCallFailed$sendFriendRequest$2(WidgetCallFailed widgetCallFailed, long j, String str) {
        this.this$0 = widgetCallFailed;
        this.$userId = j;
        this.$username = str;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Error error) {
        call2(error);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Error error) {
        RestAPIAbortMessages restAPIAbortMessages = RestAPIAbortMessages.INSTANCE;
        m.checkNotNullExpressionValue(error, "error");
        RestAPIAbortMessages.handleAbortCodeOrDefault$default(restAPIAbortMessages, error, new WidgetCallFailed$sendFriendRequest$2$1(this, error), null, 4, null);
    }
}
