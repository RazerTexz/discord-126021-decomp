package com.discord.utilities.press;

import androidx.core.app.NotificationCompat;
import j0.k.b;
import j0.p.a;
import rx.Observable;

/* JADX INFO: compiled from: RepeatingOnTouchListener.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RepeatingOnTouchListener$subscribe$1<T, R> implements b<Long, Observable<? extends Long>> {
    public final /* synthetic */ RepeatingOnTouchListener this$0;

    public RepeatingOnTouchListener$subscribe$1(RepeatingOnTouchListener repeatingOnTouchListener) {
        this.this$0 = repeatingOnTouchListener;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends Long> call(Long l) {
        return call2(l);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Long> call2(Long l) {
        long repeatRate = this.this$0.getRepeatRate();
        return Observable.F(repeatRate, repeatRate, this.this$0.getTimeUnit(), a.a());
    }
}
