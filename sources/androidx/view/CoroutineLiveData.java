package androidx.view;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Job;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.C12113l;
import p507d0.p584w.C12179f;
import p507d0.p584w.p585h.C12183c;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p659s.p660a.C13124k0;
import p659s.p660a.C13155u1;
import p659s.p660a.InterfaceC13130m0;
import p659s.p660a.p661a.C13031n;

/* JADX INFO: compiled from: CoroutineLiveData.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CoroutineLiveData<T> extends MediatorLiveData<T> {
    private BlockRunner<T> blockRunner;
    private EmittedSource emittedSource;

    /* JADX INFO: renamed from: androidx.lifecycle.CoroutineLiveData$1 */
    /* JADX INFO: compiled from: CoroutineLiveData.kt */
    public static final class C04291 extends AbstractC12240o implements Function0<Unit> {
        public C04291() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            CoroutineLiveData.this.blockRunner = null;
        }
    }

    public /* synthetic */ CoroutineLiveData(CoroutineContext coroutineContext, long j, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? C12179f.f25237j : coroutineContext, (i & 2) != 0 ? 5000L : j, function2);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object clearSource$lifecycle_livedata_ktx_release(Continuation<? super Unit> continuation) {
        CoroutineLiveData$clearSource$1 coroutineLiveData$clearSource$1;
        CoroutineLiveData<T> coroutineLiveData;
        if (continuation instanceof CoroutineLiveData$clearSource$1) {
            coroutineLiveData$clearSource$1 = (CoroutineLiveData$clearSource$1) continuation;
            int i = coroutineLiveData$clearSource$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                coroutineLiveData$clearSource$1.label = i - Integer.MIN_VALUE;
            } else {
                coroutineLiveData$clearSource$1 = new CoroutineLiveData$clearSource$1(this, continuation);
            }
        } else {
            coroutineLiveData$clearSource$1 = new CoroutineLiveData$clearSource$1(this, continuation);
        }
        Object obj = coroutineLiveData$clearSource$1.result;
        Object coroutine_suspended = C12183c.getCOROUTINE_SUSPENDED();
        int i2 = coroutineLiveData$clearSource$1.label;
        if (i2 == 0) {
            C12113l.throwOnFailure(obj);
            EmittedSource emittedSource = this.emittedSource;
            if (emittedSource != null) {
                coroutineLiveData$clearSource$1.L$0 = this;
                coroutineLiveData$clearSource$1.label = 1;
                if (emittedSource.disposeNow(coroutineLiveData$clearSource$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            coroutineLiveData = this;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            coroutineLiveData = (CoroutineLiveData) coroutineLiveData$clearSource$1.L$0;
            C12113l.throwOnFailure(obj);
        }
        coroutineLiveData.emittedSource = null;
        return Unit.f27425a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object emitSource$lifecycle_livedata_ktx_release(LiveData<T> liveData, Continuation<? super InterfaceC13130m0> continuation) {
        CoroutineLiveData$emitSource$1 coroutineLiveData$emitSource$1;
        LiveData<T> liveData2;
        CoroutineLiveData coroutineLiveData;
        CoroutineLiveData coroutineLiveData2;
        if (continuation instanceof CoroutineLiveData$emitSource$1) {
            coroutineLiveData$emitSource$1 = (CoroutineLiveData$emitSource$1) continuation;
            int i = coroutineLiveData$emitSource$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                coroutineLiveData$emitSource$1.label = i - Integer.MIN_VALUE;
            } else {
                coroutineLiveData$emitSource$1 = new CoroutineLiveData$emitSource$1(this, continuation);
            }
        } else {
            coroutineLiveData$emitSource$1 = new CoroutineLiveData$emitSource$1(this, continuation);
        }
        Object objAddDisposableSource = coroutineLiveData$emitSource$1.result;
        Object coroutine_suspended = C12183c.getCOROUTINE_SUSPENDED();
        int i2 = coroutineLiveData$emitSource$1.label;
        if (i2 != 0) {
            if (i2 == 1) {
                LiveData<T> liveData3 = (LiveData) coroutineLiveData$emitSource$1.L$1;
                CoroutineLiveData coroutineLiveData3 = (CoroutineLiveData) coroutineLiveData$emitSource$1.L$0;
                C12113l.throwOnFailure(objAddDisposableSource);
                liveData2 = liveData3;
                coroutineLiveData = coroutineLiveData3;
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                CoroutineLiveData coroutineLiveData4 = (CoroutineLiveData) coroutineLiveData$emitSource$1.L$0;
                C12113l.throwOnFailure(objAddDisposableSource);
                coroutineLiveData2 = coroutineLiveData4;
            }
            EmittedSource emittedSource = (EmittedSource) objAddDisposableSource;
            coroutineLiveData2.emittedSource = emittedSource;
            return emittedSource;
        }
        C12113l.throwOnFailure(objAddDisposableSource);
        coroutineLiveData$emitSource$1.L$0 = this;
        coroutineLiveData$emitSource$1.L$1 = liveData;
        coroutineLiveData$emitSource$1.label = 1;
        if (clearSource$lifecycle_livedata_ktx_release(coroutineLiveData$emitSource$1) == coroutine_suspended) {
            return coroutine_suspended;
        }
        liveData2 = liveData;
        coroutineLiveData = this;
        coroutineLiveData$emitSource$1.L$0 = coroutineLiveData;
        coroutineLiveData$emitSource$1.L$1 = null;
        coroutineLiveData$emitSource$1.label = 2;
        objAddDisposableSource = CoroutineLiveDataKt.addDisposableSource(coroutineLiveData, liveData2, coroutineLiveData$emitSource$1);
        coroutineLiveData2 = coroutineLiveData;
        if (objAddDisposableSource == coroutine_suspended) {
            return coroutine_suspended;
        }
        EmittedSource emittedSource2 = (EmittedSource) objAddDisposableSource;
        coroutineLiveData2.emittedSource = emittedSource2;
        return emittedSource2;
    }

    @Override // androidx.view.MediatorLiveData, androidx.view.LiveData
    public void onActive() {
        super.onActive();
        BlockRunner<T> blockRunner = this.blockRunner;
        if (blockRunner != null) {
            blockRunner.maybeRun();
        }
    }

    @Override // androidx.view.MediatorLiveData, androidx.view.LiveData
    public void onInactive() {
        super.onInactive();
        BlockRunner<T> blockRunner = this.blockRunner;
        if (blockRunner != null) {
            blockRunner.cancel();
        }
    }

    public CoroutineLiveData(CoroutineContext coroutineContext, long j, Function2<? super LiveDataScope<T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        C12238m.checkNotNullParameter(coroutineContext, "context");
        C12238m.checkNotNullParameter(function2, "block");
        C13155u1 c13155u1 = new C13155u1((Job) coroutineContext.get(Job.INSTANCE));
        CoroutineDispatcher coroutineDispatcher = C13124k0.f27866a;
        this.blockRunner = new BlockRunner<>(this, function2, j, C3404f.m4275c(C13031n.f27700b.mo11194H().plus(coroutineContext).plus(c13155u1)), new C04291());
    }
}
