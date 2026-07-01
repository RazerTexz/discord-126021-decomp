package com.discord.utilities.rx;

import androidx.recyclerview.widget.RecyclerView;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import rx.Scheduler$Worker;
import rx.Subscriber;
import rx.observers.SerializedSubscriber;
import rx.subscriptions.SerialSubscription;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes2.dex */
public class LeadingEdgeThrottle$1<T> extends Subscriber<T> {
    public long lastOnNext;
    public final Subscriber<?> self;
    public final LeadingEdgeThrottle$DebounceState<T> state;
    public final /* synthetic */ LeadingEdgeThrottle this$0;
    public final /* synthetic */ SerializedSubscriber val$s;
    public final /* synthetic */ SerialSubscription val$serial;
    public final /* synthetic */ Scheduler$Worker val$worker;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LeadingEdgeThrottle$1(LeadingEdgeThrottle leadingEdgeThrottle, Subscriber subscriber, SerializedSubscriber serializedSubscriber, SerialSubscription serialSubscription, Scheduler$Worker scheduler$Worker) {
        super(subscriber);
        this.this$0 = leadingEdgeThrottle;
        this.val$s = serializedSubscriber;
        this.val$serial = serialSubscription;
        this.val$worker = scheduler$Worker;
        this.lastOnNext = -1L;
        this.state = new LeadingEdgeThrottle$DebounceState<>();
        this.self = this;
    }

    @Override // j0.g
    public void onCompleted() {
        this.state.emitAndComplete(this.val$s, this);
    }

    @Override // j0.g
    public void onError(Throwable th) {
        this.val$s.j.onError(th);
        unsubscribe();
        this.state.clear();
    }

    @Override // j0.g
    public void onNext(T t) {
        Objects.requireNonNull(this.this$0.scheduler);
        long jCurrentTimeMillis = System.currentTimeMillis();
        int next = this.state.next(t);
        long j = this.lastOnNext;
        if (j != -1 && jCurrentTimeMillis - j < this.this$0.timeInMilliseconds) {
            this.val$serial.a(this.val$worker.b(new LeadingEdgeThrottle$1$1(this, next), this.this$0.timeInMilliseconds, TimeUnit.MILLISECONDS));
        } else {
            this.lastOnNext = jCurrentTimeMillis;
            this.state.emit(next, this.val$s, this.self);
        }
    }

    @Override // rx.Subscriber
    public void onStart() {
        request(RecyclerView.FOREVER_NS);
    }
}
