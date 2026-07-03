package androidx.view;

import androidx.annotation.MainThread;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.objectweb.asm.Opcodes;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.C12113l;
import p507d0.p584w.p585h.C12183c;
import p507d0.p584w.p586i.p587a.AbstractC12194k;
import p507d0.p584w.p586i.p587a.InterfaceC12188e;
import p507d0.p592z.p594d.C12238m;
import p659s.p660a.C13124k0;
import p659s.p660a.p661a.C13031n;

/* JADX INFO: compiled from: CoroutineLiveData.kt */
/* JADX INFO: loaded from: classes.dex */
public final class BlockRunner<T> {
    private final Function2<LiveDataScope<T>, Continuation<? super Unit>, Object> block;
    private Job cancellationJob;
    private final CoroutineLiveData<T> liveData;
    private final Function0<Unit> onDone;
    private Job runningJob;
    private final CoroutineScope scope;
    private final long timeoutInMs;

    /* JADX INFO: renamed from: androidx.lifecycle.BlockRunner$cancel$1 */
    /* JADX INFO: compiled from: CoroutineLiveData.kt */
    @InterfaceC12188e(m10084c = "androidx.lifecycle.BlockRunner$cancel$1", m10085f = "CoroutineLiveData.kt", m10086l = {Opcodes.NEW}, m10087m = "invokeSuspend")
    public static final class C04241 extends AbstractC12194k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int label;

        public C04241(Continuation continuation) {
            super(2, continuation);
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C12238m.checkNotNullParameter(continuation, "completion");
            return new C04241(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04241) create(coroutineScope, continuation)).invokeSuspend(Unit.f27425a);
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = C12183c.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                C12113l.throwOnFailure(obj);
                long j = BlockRunner.this.timeoutInMs;
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
            if (!BlockRunner.this.liveData.hasActiveObservers()) {
                Job job = BlockRunner.this.runningJob;
                if (job != null) {
                    C3404f.m4343t(job, null, 1, null);
                }
                BlockRunner.this.runningJob = null;
            }
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.BlockRunner$maybeRun$1 */
    /* JADX INFO: compiled from: CoroutineLiveData.kt */
    @InterfaceC12188e(m10084c = "androidx.lifecycle.BlockRunner$maybeRun$1", m10085f = "CoroutineLiveData.kt", m10086l = {Opcodes.ARETURN}, m10087m = "invokeSuspend")
    public static final class C04251 extends AbstractC12194k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        public int label;

        public C04251(Continuation continuation) {
            super(2, continuation);
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C12238m.checkNotNullParameter(continuation, "completion");
            C04251 c04251 = new C04251(continuation);
            c04251.L$0 = obj;
            return c04251;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04251) create(coroutineScope, continuation)).invokeSuspend(Unit.f27425a);
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = C12183c.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                C12113l.throwOnFailure(obj);
                LiveDataScopeImpl liveDataScopeImpl = new LiveDataScopeImpl(BlockRunner.this.liveData, ((CoroutineScope) this.L$0).getCoroutineContext());
                Function2 function2 = BlockRunner.this.block;
                this.label = 1;
                if (function2.invoke(liveDataScopeImpl, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C12113l.throwOnFailure(obj);
            }
            BlockRunner.this.onDone.invoke();
            return Unit.f27425a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BlockRunner(CoroutineLiveData<T> coroutineLiveData, Function2<? super LiveDataScope<T>, ? super Continuation<? super Unit>, ? extends Object> function2, long j, CoroutineScope coroutineScope, Function0<Unit> function0) {
        C12238m.checkNotNullParameter(coroutineLiveData, "liveData");
        C12238m.checkNotNullParameter(function2, "block");
        C12238m.checkNotNullParameter(coroutineScope, "scope");
        C12238m.checkNotNullParameter(function0, "onDone");
        this.liveData = coroutineLiveData;
        this.block = function2;
        this.timeoutInMs = j;
        this.scope = coroutineScope;
        this.onDone = function0;
    }

    @MainThread
    public final void cancel() {
        if (this.cancellationJob != null) {
            throw new IllegalStateException("Cancel call cannot happen without a maybeRun".toString());
        }
        CoroutineScope coroutineScope = this.scope;
        CoroutineDispatcher coroutineDispatcher = C13124k0.f27866a;
        this.cancellationJob = C3404f.m4211H0(coroutineScope, C13031n.f27700b.mo11194H(), null, new C04241(null), 2, null);
    }

    @MainThread
    public final void maybeRun() {
        Job job = this.cancellationJob;
        if (job != null) {
            C3404f.m4343t(job, null, 1, null);
        }
        this.cancellationJob = null;
        if (this.runningJob != null) {
            return;
        }
        this.runningJob = C3404f.m4211H0(this.scope, null, null, new C04251(null), 3, null);
    }
}
