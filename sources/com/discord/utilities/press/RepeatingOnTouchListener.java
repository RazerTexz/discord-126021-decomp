package com.discord.utilities.press;

import android.view.MotionEvent;
import android.view.View;
import com.discord.utilities.analytics.Traits;
import d0.z.d.Intrinsics3;
import j0.j.b.AndroidSchedulers;
import j0.k.Func1;
import j0.p.Schedulers2;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: compiled from: RepeatingOnTouchListener.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RepeatingOnTouchListener implements View.OnTouchListener {
    private final Action0 action;
    private final Action0 initialAction;
    private final long initialDelay;
    private final long repeatRate;
    private Subscription subscription;
    private final TimeUnit timeUnit;

    public RepeatingOnTouchListener(long j, long j2, TimeUnit timeUnit, Action0 action0) {
        this(j, j2, timeUnit, action0, null, 16, null);
    }

    public RepeatingOnTouchListener(long j, long j2, TimeUnit timeUnit, Action0 action0, Action0 action1) {
        Intrinsics3.checkNotNullParameter(timeUnit, "timeUnit");
        Intrinsics3.checkNotNullParameter(action0, "action");
        Intrinsics3.checkNotNullParameter(action1, "initialAction");
        this.initialDelay = j;
        this.repeatRate = j2;
        this.timeUnit = timeUnit;
        this.action = action0;
        this.initialAction = action1;
    }

    private final void subscribe() {
        this.subscription = Observable.d0(this.initialDelay, this.timeUnit).A(new Func1<Long, Observable<? extends Long>>() { // from class: com.discord.utilities.press.RepeatingOnTouchListener.subscribe.1
            @Override // j0.k.Func1
            public final Observable<? extends Long> call(Long l) {
                long repeatRate = RepeatingOnTouchListener.this.getRepeatRate();
                return Observable.F(repeatRate, repeatRate, RepeatingOnTouchListener.this.getTimeUnit(), Schedulers2.a());
            }
        }).J(AndroidSchedulers.a()).W(new Action1<Long>() { // from class: com.discord.utilities.press.RepeatingOnTouchListener.subscribe.2
            @Override // rx.functions.Action1
            public final void call(Long l) {
                RepeatingOnTouchListener.this.getAction().call();
            }
        }, new Action1<Throwable>() { // from class: com.discord.utilities.press.RepeatingOnTouchListener.subscribe.3
            @Override // rx.functions.Action1
            public final void call(Throwable th) {
            }
        });
    }

    public final Action0 getAction() {
        return this.action;
    }

    public final Action0 getInitialAction() {
        return this.initialAction;
    }

    public final long getInitialDelay() {
        return this.initialDelay;
    }

    public final long getRepeatRate() {
        return this.repeatRate;
    }

    public final TimeUnit getTimeUnit() {
        return this.timeUnit;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        Integer numValueOf = event != null ? Integer.valueOf(event.getAction()) : null;
        if (numValueOf != null && numValueOf.intValue() == 0) {
            this.initialAction.call();
            subscribe();
            return true;
        }
        if (numValueOf != null && numValueOf.intValue() == 2) {
            return true;
        }
        Subscription subscription = this.subscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.subscription = null;
        return true;
    }

    public /* synthetic */ RepeatingOnTouchListener(long j, long j2, TimeUnit timeUnit, Action0 action0, Action0 action1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, timeUnit, action0, (i & 16) != 0 ? action0 : action1);
    }
}
