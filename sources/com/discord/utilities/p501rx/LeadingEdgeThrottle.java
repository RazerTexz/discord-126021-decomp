package com.discord.utilities.p501rx;

import androidx.recyclerview.widget.RecyclerView;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p637j0.p653p.C12781a;
import p658rx.Observable;
import p658rx.Scheduler;
import p658rx.Subscriber;
import p658rx.functions.Action0;
import p658rx.observers.SerializedSubscriber;
import p658rx.subscriptions.SerialSubscription;

/* JADX INFO: loaded from: classes2.dex */
public class LeadingEdgeThrottle<T> implements Observable.InterfaceC13006b<T, T> {
    public final Scheduler scheduler;
    public final long timeInMilliseconds;

    /* JADX INFO: renamed from: com.discord.utilities.rx.LeadingEdgeThrottle$1 */
    public class C68681 extends Subscriber<T> {
        public long lastOnNext;
        public final Subscriber<?> self;
        public final DebounceState<T> state;
        public final /* synthetic */ SerializedSubscriber val$s;
        public final /* synthetic */ SerialSubscription val$serial;
        public final /* synthetic */ Scheduler.Worker val$worker;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C68681(Subscriber subscriber, SerializedSubscriber serializedSubscriber, SerialSubscription serialSubscription, Scheduler.Worker worker) {
            super(subscriber);
            this.val$s = serializedSubscriber;
            this.val$serial = serialSubscription;
            this.val$worker = worker;
            this.lastOnNext = -1L;
            this.state = new DebounceState<>();
            this.self = this;
        }

        @Override // p637j0.InterfaceC12581g
        public void onCompleted() {
            this.state.emitAndComplete(this.val$s, this);
        }

        @Override // p637j0.InterfaceC12581g
        public void onError(Throwable th) {
            this.val$s.f27646j.onError(th);
            unsubscribe();
            this.state.clear();
        }

        @Override // p637j0.InterfaceC12581g
        public void onNext(T t) {
            Objects.requireNonNull(LeadingEdgeThrottle.this.scheduler);
            long jCurrentTimeMillis = System.currentTimeMillis();
            final int next = this.state.next(t);
            long j = this.lastOnNext;
            if (j != -1 && jCurrentTimeMillis - j < LeadingEdgeThrottle.this.timeInMilliseconds) {
                this.val$serial.m11139a(this.val$worker.mo10741b(new Action0() { // from class: com.discord.utilities.rx.LeadingEdgeThrottle.1.1
                    @Override // p658rx.functions.Action0
                    public void call() {
                        C68681 c68681 = C68681.this;
                        c68681.state.emit(next, c68681.val$s, c68681.self);
                    }
                }, LeadingEdgeThrottle.this.timeInMilliseconds, TimeUnit.MILLISECONDS));
            } else {
                this.lastOnNext = jCurrentTimeMillis;
                this.state.emit(next, this.val$s, this.self);
            }
        }

        @Override // p658rx.Subscriber
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
                        C3404f.m4329p1(th, subscriber2, t);
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
                        C3404f.m4329p1(th, subscriber2, t);
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

    @Override // p637j0.p641k.InterfaceC12589b
    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        Scheduler.Worker workerMo10739a = this.scheduler.mo10739a();
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        SerialSubscription serialSubscription = new SerialSubscription();
        serializedSubscriber.add(workerMo10739a);
        serializedSubscriber.add(serialSubscription);
        return new C68681(subscriber, serializedSubscriber, serialSubscription, workerMo10739a);
    }

    public LeadingEdgeThrottle(long j, TimeUnit timeUnit) {
        this(j, timeUnit, C12781a.m10873a());
    }
}
