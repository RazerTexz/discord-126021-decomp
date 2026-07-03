package com.discord.utilities.press;

import android.view.MotionEvent;
import android.view.View;
import com.discord.utilities.analytics.Traits;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p592z.p594d.C12238m;
import p637j0.p638j.p640b.C12586a;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p653p.C12781a;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Action0;
import p658rx.functions.Action1;

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
        C12238m.checkNotNullParameter(timeUnit, "timeUnit");
        C12238m.checkNotNullParameter(action0, "action");
        C12238m.checkNotNullParameter(action1, "initialAction");
        this.initialDelay = j;
        this.repeatRate = j2;
        this.timeUnit = timeUnit;
        this.action = action0;
        this.initialAction = action1;
    }

    private final void subscribe() {
        this.subscription = Observable.m11068d0(this.initialDelay, this.timeUnit).m11082A(new InterfaceC12589b<Long, Observable<? extends Long>>() { // from class: com.discord.utilities.press.RepeatingOnTouchListener.subscribe.1
            @Override // p637j0.p641k.InterfaceC12589b
            public final Observable<? extends Long> call(Long l) {
                long repeatRate = RepeatingOnTouchListener.this.getRepeatRate();
                return Observable.m11062F(repeatRate, repeatRate, RepeatingOnTouchListener.this.getTimeUnit(), C12781a.m10873a());
            }
        }).m11084J(C12586a.m10738a()).m11097W(new Action1<Long>() { // from class: com.discord.utilities.press.RepeatingOnTouchListener.subscribe.2
            @Override // p658rx.functions.Action1
            public final void call(Long l) {
                RepeatingOnTouchListener.this.getAction().call();
            }
        }, new Action1<Throwable>() { // from class: com.discord.utilities.press.RepeatingOnTouchListener.subscribe.3
            @Override // p658rx.functions.Action1
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
