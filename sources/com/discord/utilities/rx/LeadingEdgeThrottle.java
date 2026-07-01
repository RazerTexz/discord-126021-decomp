package com.discord.utilities.rx;

import androidx.recyclerview.widget.RecyclerView;
import b.i.a.f.e.o.f;
import j0.p.Schedulers2;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action0;
import rx.observers.SerializedSubscriber;
import rx.subscriptions.SerialSubscription;

/* JADX INFO: loaded from: classes2.dex */
public class LeadingEdgeThrottle<T> implements Observable.b<T, T> {
    public final Scheduler scheduler;
    public final long timeInMilliseconds;

    /* JADX INFO: renamed from: com.discord.utilities.rx.LeadingEdgeThrottle$1, reason: invalid class name */
    public class AnonymousClass1 extends Subscriber<T> {
        public long lastOnNext;
        public final Subscriber<?> self;
        public final DebounceState<T> state;
        public final /* synthetic */ SerializedSubscriber val$s;
        public final /* synthetic */ SerialSubscription val$serial;
        public final /* synthetic */ Scheduler.Worker val$worker;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Subscriber subscriber, SerializedSubscriber serializedSubscriber, SerialSubscription serialSubscription, Scheduler.Worker worker) {
            super(subscriber);
            this.val$s = serializedSubscriber;
            this.val$serial = serialSubscription;
            this.val$worker = worker;
            this.lastOnNext = -1L;
            this.state = new DebounceState<>();
            this.self = this;
        }

        @Override // j0.Observer2
        public void onCompleted() {
            this.state.emitAndComplete(this.val$s, this);
        }

        @Override // j0.Observer2
        public void onError(Throwable th) {
            this.val$s.j.onError(th);
            unsubscribe();
            this.state.clear();
        }

        @Override // j0.Observer2
        public void onNext(T t) {
            Objects.requireNonNull(LeadingEdgeThrottle.this.scheduler);
            long jCurrentTimeMillis = System.currentTimeMillis();
            final int next = this.state.next(t);
            long j = this.lastOnNext;
            if (j != -1 && jCurrentTimeMillis - j < LeadingEdgeThrottle.this.timeInMilliseconds) {
                this.val$serial.a(this.val$worker.b(new Action0() { // from class: com.discord.utilities.rx.LeadingEdgeThrottle.1.1
                    @Override // rx.functions.Action0
                    public void call() {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        anonymousClass1.state.emit(next, anonymousClass1.val$s, anonymousClass1.self);
                    }
                }, LeadingEdgeThrottle.this.timeInMilliseconds, TimeUnit.MILLISECONDS));
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

    public static final class DebounceState<T> {
        public boolean emitting;
        public boolean hasValue;
        public int index;
        public boolean terminate;
        public T value;

        public synchronized void clear() {
            this.index++;
            this.value = null;
            this.hasValue = false;
        }

        public void emit(int i, Subscriber<T> subscriber, Subscriber<?> subscriber2) {
            synchronized (this) {
                if (!this.emitting && this.hasValue && i == this.index) {
                    T t = this.value;
                    this.value = null;
                    this.hasValue = false;
                    this.emitting = true;
                    try {
                        subscriber.onNext(t);
                        synchronized (this) {
                            if (this.terminate) {
                                subscriber.onCompleted();
                            } else {
                                this.emitting = false;
                            }
                        }
                    } catch (Throwable th) {
                        f.p1(th, subscriber2, t);
                    }
                }
            }
        }

        public void emitAndComplete(Subscriber<T> subscriber, Subscriber<?> subscriber2) {
            synchronized (this) {
                if (this.emitting) {
                    this.terminate = true;
                    return;
                }
                T t = this.value;
                boolean z2 = this.hasValue;
                this.value = null;
                this.hasValue = false;
                this.emitting = true;
                if (z2) {
                    try {
                        subscriber.onNext(t);
                    } catch (Throwable th) {
                        f.p1(th, subscriber2, t);
                        return;
                    }
                }
                subscriber.onCompleted();
            }
        }

        public synchronized int next(T t) {
            int i;
            this.value = t;
            this.hasValue = true;
            i = this.index + 1;
            this.index = i;
            return i;
        }
    }

    public LeadingEdgeThrottle(long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.timeInMilliseconds = timeUnit.toMillis(j);
        this.scheduler = scheduler;
    }

    @Override // j0.k.Func1
    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        Scheduler.Worker workerA = this.scheduler.a();
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        SerialSubscription serialSubscription = new SerialSubscription();
        serializedSubscriber.add(workerA);
        serializedSubscriber.add(serialSubscription);
        return new AnonymousClass1(subscriber, serializedSubscriber, serialSubscription, workerA);
    }

    public LeadingEdgeThrottle(long j, TimeUnit timeUnit) {
        this(j, timeUnit, Schedulers2.a());
    }
}
