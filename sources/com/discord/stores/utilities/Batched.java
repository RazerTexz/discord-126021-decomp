package com.discord.stores.utilities;

import androidx.exifinterface.media.ExifInterface;
import com.discord.app.AppLog;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.C12113l;
import p507d0.p584w.p585h.C12183c;
import p507d0.p584w.p586i.p587a.AbstractC12194k;
import p507d0.p584w.p586i.p587a.InterfaceC12188e;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.subjects.BehaviorSubject;
import p658rx.subjects.SerializedSubject;

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

    /* JADX INFO: renamed from: com.discord.stores.utilities.Batched$onNext$1 */
    /* JADX INFO: compiled from: Batched.kt */
    @InterfaceC12188e(m10084c = "com.discord.stores.utilities.Batched$onNext$1", m10085f = "Batched.kt", m10086l = {82}, m10087m = "invokeSuspend")
    public static final class C66361 extends AbstractC12194k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int label;

        public C66361(Continuation continuation) {
            super(2, continuation);
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C12238m.checkNotNullParameter(continuation, "completion");
            return new C66361(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C66361) create(coroutineScope, continuation)).invokeSuspend(Unit.f27425a);
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = C12183c.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                C12113l.throwOnFailure(obj);
                long j = Batched.this.debounceDelayMs;
                this.label = 1;
                if (C3404f.m4234P(j, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C12113l.throwOnFailure(obj);
            }
            Batched.this.flush();
            return Unit.f27425a;
        }
    }

    public Batched(String str, long j, long j2, CoroutineScope coroutineScope, Clock clock) {
        C12238m.checkNotNullParameter(str, "type");
        C12238m.checkNotNullParameter(coroutineScope, "scope");
        C12238m.checkNotNullParameter(clock, "clock");
        this.type = str;
        this.debounceDelayMs = j;
        this.maxDebounceDelayMs = j2;
        this.scope = coroutineScope;
        this.clock = clock;
        this.subject = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.queue = new ArrayList();
        this.queueStartTime = -1L;
    }

    public final synchronized void flush() {
        Job job = this.debounceJob;
        if (job != null) {
            C3404f.m4343t(job, null, 1, null);
        }
        this.debounceJob = null;
        this.queueStartTime = -1L;
        List<T> list = this.queue;
        this.queue = new ArrayList();
        this.subject.f27653k.onNext(list);
    }

    public final String getType() {
        return this.type;
    }

    public final Observable<List<T>> observe() {
        return this.subject;
    }

    public final synchronized void onNext(T value) {
        if (value == null) {
            AppLog.m8358i("onNext received a NULL value for Batched[" + this.type + ']');
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
                C3404f.m4343t(job, null, 1, null);
            }
            this.debounceJob = C3404f.m4211H0(this.scope, null, null, new C66361(null), 3, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onNextAny(Object value) {
        C12238m.checkNotNullParameter(value, "value");
        onNext(value);
    }

    public /* synthetic */ Batched(String str, long j, long j2, CoroutineScope coroutineScope, Clock clock, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? 100L : j, (i & 4) != 0 ? 300L : j2, coroutineScope, (i & 16) != 0 ? ClockFactory.get() : clock);
    }
}
