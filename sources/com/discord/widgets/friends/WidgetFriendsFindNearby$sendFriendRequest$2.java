package com.discord.widgets.friends;

import androidx.core.app.NotificationCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPIAbortMessages;
import d0.z.d.m;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetFriendsFindNearby.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsFindNearby$sendFriendRequest$2<T> implements Action1<Error> {
    public final /* synthetic */ int $discriminator;
    public final /* synthetic */ String $username;
    public final /* synthetic */ WidgetFriendsFindNearby this$0;

    public WidgetFriendsFindNearby$sendFriendRequest$2(WidgetFriendsFindNearby widgetFriendsFindNearby, String str, int i) {
        this.this$0 = widgetFriendsFindNearby;
        this.$username = str;
        this.$discriminator = i;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Error error) {
        call2(error);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Error error) {
        RestAPIAbortMessages restAPIAbortMessages = RestAPIAbortMessages.INSTANCE;
        m.checkNotNullExpressionValue(error, "error");
        RestAPIAbortMessages.handleAbortCodeOrDefault$default(restAPIAbortMessages, error, new WidgetFriendsFindNearby$sendFriendRequest$2$1(this, error), null, 4, null);
    }
}
