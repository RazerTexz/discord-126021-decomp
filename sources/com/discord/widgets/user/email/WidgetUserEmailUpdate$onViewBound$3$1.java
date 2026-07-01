package com.discord.widgets.user.email;

import androidx.core.app.NotificationCompat;
import com.discord.api.user.User;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetUserEmailUpdate.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserEmailUpdate$onViewBound$3$1<T> implements Action1<User> {
    public final /* synthetic */ WidgetUserEmailUpdate$onViewBound$3 this$0;

    public WidgetUserEmailUpdate$onViewBound$3$1(WidgetUserEmailUpdate$onViewBound$3 widgetUserEmailUpdate$onViewBound$3) {
        this.this$0 = widgetUserEmailUpdate$onViewBound$3;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(User user) {
        call2(user);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(User user) {
        WidgetUserEmailUpdate.access$onEmailUpdated(this.this$0.this$0);
    }
}
