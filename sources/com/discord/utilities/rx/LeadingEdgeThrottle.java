package com.discord.utilities.rx;

import j0.p.a;
import java.util.concurrent.TimeUnit;
import rx.Observable$b;
import rx.Scheduler;
import rx.Scheduler$Worker;
import rx.Subscriber;
import rx.observers.SerializedSubscriber;
import rx.subscriptions.SerialSubscription;

/* JADX INFO: loaded from: classes2.dex */
public class LeadingEdgeThrottle<T> implements Observable$b<T, T> {
    public final Scheduler scheduler;
    public final long timeInMilliseconds;

    public LeadingEdgeThrottle(long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.timeInMilliseconds = timeUnit.toMillis(j);
        this.scheduler = scheduler;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) obj);
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        Scheduler$Worker scheduler$WorkerA = this.scheduler.a();
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        SerialSubscription serialSubscription = new SerialSubscription();
        serializedSubscriber.add(scheduler$WorkerA);
        serializedSubscriber.add(serialSubscription);
        return new LeadingEdgeThrottle$1(this, subscriber, serializedSubscriber, serialSubscription, scheduler$WorkerA);
    }

    public LeadingEdgeThrottle(long j, TimeUnit timeUnit) {
        this(j, timeUnit, a.a());
    }
}
