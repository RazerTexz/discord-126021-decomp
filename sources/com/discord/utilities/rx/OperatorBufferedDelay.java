package com.discord.utilities.rx;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import d0.z.d.m;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable$b;
import rx.Scheduler;
import rx.Scheduler$Worker;
import rx.Subscriber;
import rx.observers.SerializedSubscriber;

/* JADX INFO: compiled from: OperatorBufferedDelay.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class OperatorBufferedDelay<T> implements Observable$b<List<? extends T>, T> {
    public static final OperatorBufferedDelay$Companion Companion = new OperatorBufferedDelay$Companion(null);
    private final Scheduler scheduler;
    private final int size;
    private final long timeSpan;
    private final TimeUnit timeUnit;

    public OperatorBufferedDelay(long j, TimeUnit timeUnit, int i, Scheduler scheduler) {
        m.checkNotNullParameter(timeUnit, "timeUnit");
        m.checkNotNullParameter(scheduler, "scheduler");
        this.timeSpan = j;
        this.timeUnit = timeUnit;
        this.size = i;
        this.scheduler = scheduler;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) obj);
    }

    public final Scheduler getScheduler() {
        return this.scheduler;
    }

    public final int getSize() {
        return this.size;
    }

    public final long getTimeSpan() {
        return this.timeSpan;
    }

    public final TimeUnit getTimeUnit() {
        return this.timeUnit;
    }

    public /* synthetic */ OperatorBufferedDelay(long j, TimeUnit timeUnit, int i, Scheduler scheduler, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i2 & 2) != 0 ? TimeUnit.MILLISECONDS : timeUnit, i, scheduler);
    }

    public Subscriber<? super T> call(Subscriber<? super List<? extends T>> childSubscriber) {
        m.checkNotNullParameter(childSubscriber, "childSubscriber");
        Scheduler$Worker scheduler$WorkerA = this.scheduler.a();
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(childSubscriber);
        m.checkNotNullExpressionValue(scheduler$WorkerA, "inner");
        OperatorBufferedDelay$ExactSubscriber operatorBufferedDelay$ExactSubscriber = new OperatorBufferedDelay$ExactSubscriber(this, serializedSubscriber, scheduler$WorkerA);
        operatorBufferedDelay$ExactSubscriber.add(scheduler$WorkerA);
        childSubscriber.add(operatorBufferedDelay$ExactSubscriber);
        return operatorBufferedDelay$ExactSubscriber;
    }
}
