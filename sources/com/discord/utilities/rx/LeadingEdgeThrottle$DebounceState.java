package com.discord.utilities.rx;

import b.i.a.f.e.o.f;
import rx.Subscriber;

/* JADX INFO: loaded from: classes2.dex */
public final class LeadingEdgeThrottle$DebounceState<T> {
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
