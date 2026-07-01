package com.discord.utilities.rx;

import androidx.exifinterface.media.ExifInterface;
import b.i.a.f.e.o.f;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.List;
import rx.Scheduler$Worker;
import rx.Subscriber;
import rx.Subscription;

/* JADX INFO: compiled from: OperatorBufferedDelay.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class OperatorBufferedDelay$ExactSubscriber<T> extends Subscriber<T> {
    private List<T> buffer;
    private final Subscriber<List<T>> child;
    private final Scheduler$Worker inner;
    private Subscription ongoingBufferTimer;
    public final /* synthetic */ OperatorBufferedDelay this$0;

    public OperatorBufferedDelay$ExactSubscriber(OperatorBufferedDelay operatorBufferedDelay, Subscriber<List<T>> subscriber, Scheduler$Worker scheduler$Worker) {
        m.checkNotNullParameter(subscriber, "child");
        m.checkNotNullParameter(scheduler$Worker, "inner");
        this.this$0 = operatorBufferedDelay;
        this.child = subscriber;
        this.inner = scheduler$Worker;
        this.buffer = new ArrayList();
    }

    private final void cancelBufferTimer() {
        Subscription subscription = this.ongoingBufferTimer;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.ongoingBufferTimer = null;
    }

    private final List<T> getAndSetBuffer(List<T> newValue) {
        List<T> list = this.buffer;
        this.buffer = newValue;
        return list;
    }

    private final void publish(List<? extends T> bufferedValues) {
        try {
            if (!bufferedValues.isEmpty()) {
                this.child.onNext(bufferedValues);
            }
        } catch (Throwable th) {
            f.o1(th);
            onError(th);
        }
    }

    private final void tryEmit(List<T> newBufferValue) {
        synchronized (this) {
            cancelBufferTimer();
            if (this.buffer == null) {
                return;
            }
            List<T> andSetBuffer = getAndSetBuffer(newBufferValue);
            if (andSetBuffer != null) {
                publish(andSetBuffer);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void tryEmit$default(OperatorBufferedDelay$ExactSubscriber operatorBufferedDelay$ExactSubscriber, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = new ArrayList();
        }
        operatorBufferedDelay$ExactSubscriber.tryEmit(list);
    }

    public final Subscriber<List<T>> getChild() {
        return this.child;
    }

    public final Scheduler$Worker getInner() {
        return this.inner;
    }

    @Override // j0.g
    public void onCompleted() {
        this.inner.unsubscribe();
        tryEmit(null);
        this.child.onCompleted();
        unsubscribe();
    }

    @Override // j0.g
    public void onError(Throwable e) {
        tryEmit(null);
        this.child.onError(e);
        unsubscribe();
    }

    @Override // j0.g
    public void onNext(T t) {
        synchronized (this) {
            List<T> list = this.buffer;
            if (list != null) {
                list.add(t);
                if (list.size() < this.this$0.getSize()) {
                    if (this.ongoingBufferTimer == null) {
                        this.ongoingBufferTimer = this.inner.b(new OperatorBufferedDelay$ExactSubscriber$onNext$$inlined$synchronized$lambda$1(this, t), this.this$0.getTimeSpan(), this.this$0.getTimeUnit());
                    }
                } else {
                    cancelBufferTimer();
                    List<T> andSetBuffer = getAndSetBuffer(new ArrayList());
                    if (andSetBuffer != null) {
                        publish(andSetBuffer);
                    }
                }
            }
        }
    }
}
