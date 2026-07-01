package com.discord.utilities.press;

import androidx.core.app.NotificationCompat;
import rx.functions.Action1;

/* JADX INFO: compiled from: RepeatingOnTouchListener.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RepeatingOnTouchListener$subscribe$2<T> implements Action1<Long> {
    public final /* synthetic */ RepeatingOnTouchListener this$0;

    public RepeatingOnTouchListener$subscribe$2(RepeatingOnTouchListener repeatingOnTouchListener) {
        this.this$0 = repeatingOnTouchListener;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Long l) {
        call2(l);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Long l) {
        this.this$0.getAction().call();
    }
}
