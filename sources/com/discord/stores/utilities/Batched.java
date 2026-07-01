package com.discord.stores.utilities;

import androidx.exifinterface.media.ExifInterface;
import b.i.a.f.e.o.f;
import com.discord.app.AppLog;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import rx.Observable;
import rx.subjects.BehaviorSubject;
import rx.subjects.SerializedSubject;

/* JADX INFO: compiled from: Batched.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Batched<T> {
    public static final Batched$Companion Companion = new Batched$Companion(null);
    public static final long DEFAULT_DEBOUNCE_DELAY_MS = 100;
    public static final long DEFAULT_MAX_DEBOUNCE_DELAY_MS = 300;
    private static final long QUEUE_NOT_STARTED = -1;
    private final Clock clock;
    private final long debounceDelayMs;
    private Job debounceJob;
    private final long maxDebounceDelayMs;
    private List<T> queue;
    private long queueStartTime;
    private final CoroutineScope scope;
    private final SerializedSubject<List<T>, List<T>> subject;
    private final String type;

    public Batched(String str, long j, long j2, CoroutineScope coroutineScope, Clock clock) {
        m.checkNotNullParameter(str, "type");
        m.checkNotNullParameter(coroutineScope, "scope");
        m.checkNotNullParameter(clock, "clock");
        this.type = str;
        this.debounceDelayMs = j;
        this.maxDebounceDelayMs = j2;
        this.scope = coroutineScope;
        this.clock = clock;
        this.subject = new SerializedSubject<>(BehaviorSubject.k0());
        this.queue = new ArrayList();
        this.queueStartTime = -1L;
    }

    public static final /* synthetic */ long access$getDebounceDelayMs$p(Batched batched) {
        return batched.debounceDelayMs;
    }

    public final synchronized void flush() {
        Job job = this.debounceJob;
        if (job != null) {
            f.t(job, null, 1, null);
        }
        this.debounceJob = null;
        this.queueStartTime = -1L;
        List<T> list = this.queue;
        this.queue = new ArrayList();
        this.subject.k.onNext(list);
    }

    public final String getType() {
        return this.type;
    }

    public final Observable<List<T>> observe() {
        return this.subject;
    }

    public final synchronized void onNext(T value) {
        if (value == null) {
            AppLog.i("onNext received a NULL value for Batched[" + this.type + ']');
        }
        this.queue.add(value);
        long jCurrentTimeMillis = this.clock.currentTimeMillis();
        if (this.queueStartTime == -1) {
            this.queueStartTime = jCurrentTimeMillis;
        }
        if (jCurrentTimeMillis - this.queueStartTime >= this.maxDebounceDelayMs) {
            flush();
        } else {
            Job job = this.debounceJob;
            if (job != null) {
                f.t(job, null, 1, null);
            }
            this.debounceJob = f.H0(this.scope, null, null, new Batched$onNext$1(this, null), 3, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onNextAny(Object value) {
        m.checkNotNullParameter(value, "value");
        onNext(value);
    }

    public /* synthetic */ Batched(String str, long j, long j2, CoroutineScope coroutineScope, Clock clock, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? 100L : j, (i & 4) != 0 ? 300L : j2, coroutineScope, (i & 16) != 0 ? ClockFactory.get() : clock);
    }
}
