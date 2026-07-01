package com.discord.stores.utilities;

import androidx.exifinterface.media.ExifInterface;
import b.i.a.f.e.o.f;
import com.discord.app.AppLog;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import d0.Result3;
import d0.w.h.Intrinsics2;
import d0.w.i.a.ContinuationImpl6;
import d0.w.i.a.DebugMetadata;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import rx.Observable;
import rx.subjects.BehaviorSubject;
import rx.subjects.SerializedSubject;

/* JADX INFO: compiled from: Batched.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Batched<T> {
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

    /* JADX INFO: renamed from: com.discord.stores.utilities.Batched$onNext$1, reason: invalid class name */
    /* JADX INFO: compiled from: Batched.kt */
    @DebugMetadata(c = "com.discord.stores.utilities.Batched$onNext$1", f = "Batched.kt", l = {82}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int label;

        public AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                Result3.throwOnFailure(obj);
                long j = Batched.this.debounceDelayMs;
                this.label = 1;
                if (f.P(j, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Result3.throwOnFailure(obj);
            }
            Batched.this.flush();
            return Unit.a;
        }
    }

    public Batched(String str, long j, long j2, CoroutineScope coroutineScope, Clock clock) {
        Intrinsics3.checkNotNullParameter(str, "type");
        Intrinsics3.checkNotNullParameter(coroutineScope, "scope");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        this.type = str;
        this.debounceDelayMs = j;
        this.maxDebounceDelayMs = j2;
        this.scope = coroutineScope;
        this.clock = clock;
        this.subject = new SerializedSubject<>(BehaviorSubject.k0());
        this.queue = new ArrayList();
        this.queueStartTime = -1L;
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
            this.debounceJob = f.H0(this.scope, null, null, new AnonymousClass1(null), 3, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onNextAny(Object value) {
        Intrinsics3.checkNotNullParameter(value, "value");
        onNext(value);
    }

    public /* synthetic */ Batched(String str, long j, long j2, CoroutineScope coroutineScope, Clock clock, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? 100L : j, (i & 4) != 0 ? 300L : j2, coroutineScope, (i & 16) != 0 ? ClockFactory.get() : clock);
    }
}
