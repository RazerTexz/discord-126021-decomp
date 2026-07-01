package androidx.view;

import androidx.exifinterface.media.ExifInterface;
import b.i.a.f.e.o.f;
import d0.Result3;
import d0.w.CoroutineContextImpl4;
import d0.w.h.Intrinsics2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Job;
import s.a.Dispatchers;
import s.a.Job2;
import s.a.Supervisor;
import s.a.a.MainDispatchers;

/* JADX INFO: compiled from: CoroutineLiveData.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CoroutineLiveData<T> extends MediatorLiveData<T> {
    private CoroutineLiveData2<T> blockRunner;
    private CoroutineLiveData6 emittedSource;

    /* JADX INFO: renamed from: androidx.lifecycle.CoroutineLiveData$1, reason: invalid class name */
    /* JADX INFO: compiled from: CoroutineLiveData.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            CoroutineLiveData.this.blockRunner = null;
        }
    }

    public /* synthetic */ CoroutineLiveData(CoroutineContext coroutineContext, long j, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CoroutineContextImpl4.j : coroutineContext, (i & 2) != 0 ? 5000L : j, function2);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object clearSource$lifecycle_livedata_ktx_release(Continuation<? super Unit> continuation) {
        CoroutineLiveData3 coroutineLiveData3;
        CoroutineLiveData<T> coroutineLiveData;
        if (continuation instanceof CoroutineLiveData3) {
            coroutineLiveData3 = (CoroutineLiveData3) continuation;
            int i = coroutineLiveData3.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                coroutineLiveData3.label = i - Integer.MIN_VALUE;
            } else {
                coroutineLiveData3 = new CoroutineLiveData3(this, continuation);
            }
        } else {
            coroutineLiveData3 = new CoroutineLiveData3(this, continuation);
        }
        Object obj = coroutineLiveData3.result;
        Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
        int i2 = coroutineLiveData3.label;
        if (i2 == 0) {
            Result3.throwOnFailure(obj);
            CoroutineLiveData6 coroutineLiveData6 = this.emittedSource;
            if (coroutineLiveData6 != null) {
                coroutineLiveData3.L$0 = this;
                coroutineLiveData3.label = 1;
                if (coroutineLiveData6.disposeNow(coroutineLiveData3) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            coroutineLiveData = this;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            coroutineLiveData = (CoroutineLiveData) coroutineLiveData3.L$0;
            Result3.throwOnFailure(obj);
        }
        coroutineLiveData.emittedSource = null;
        return Unit.a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object emitSource$lifecycle_livedata_ktx_release(LiveData<T> liveData, Continuation<? super Job2> continuation) {
        CoroutineLiveData4 coroutineLiveData4;
        LiveData<T> liveData2;
        CoroutineLiveData coroutineLiveData;
        CoroutineLiveData coroutineLiveData2;
        if (continuation instanceof CoroutineLiveData4) {
            coroutineLiveData4 = (CoroutineLiveData4) continuation;
            int i = coroutineLiveData4.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                coroutineLiveData4.label = i - Integer.MIN_VALUE;
            } else {
                coroutineLiveData4 = new CoroutineLiveData4(this, continuation);
            }
        } else {
            coroutineLiveData4 = new CoroutineLiveData4(this, continuation);
        }
        Object objAddDisposableSource = coroutineLiveData4.result;
        Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
        int i2 = coroutineLiveData4.label;
        if (i2 != 0) {
            if (i2 == 1) {
                LiveData<T> liveData3 = (LiveData) coroutineLiveData4.L$1;
                CoroutineLiveData coroutineLiveData3 = (CoroutineLiveData) coroutineLiveData4.L$0;
                Result3.throwOnFailure(objAddDisposableSource);
                liveData2 = liveData3;
                coroutineLiveData = coroutineLiveData3;
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                CoroutineLiveData coroutineLiveData5 = (CoroutineLiveData) coroutineLiveData4.L$0;
                Result3.throwOnFailure(objAddDisposableSource);
                coroutineLiveData2 = coroutineLiveData5;
            }
            CoroutineLiveData6 coroutineLiveData6 = (CoroutineLiveData6) objAddDisposableSource;
            coroutineLiveData2.emittedSource = coroutineLiveData6;
            return coroutineLiveData6;
        }
        Result3.throwOnFailure(objAddDisposableSource);
        coroutineLiveData4.L$0 = this;
        coroutineLiveData4.L$1 = liveData;
        coroutineLiveData4.label = 1;
        if (clearSource$lifecycle_livedata_ktx_release(coroutineLiveData4) == coroutine_suspended) {
            return coroutine_suspended;
        }
        liveData2 = liveData;
        coroutineLiveData = this;
        coroutineLiveData4.L$0 = coroutineLiveData;
        coroutineLiveData4.L$1 = null;
        coroutineLiveData4.label = 2;
        objAddDisposableSource = CoroutineLiveData5.addDisposableSource(coroutineLiveData, liveData2, coroutineLiveData4);
        coroutineLiveData2 = coroutineLiveData;
        if (objAddDisposableSource == coroutine_suspended) {
            return coroutine_suspended;
        }
        CoroutineLiveData6 coroutineLiveData7 = (CoroutineLiveData6) objAddDisposableSource;
        coroutineLiveData2.emittedSource = coroutineLiveData7;
        return coroutineLiveData7;
    }

    @Override // androidx.view.MediatorLiveData, androidx.view.LiveData
    public void onActive() {
        super.onActive();
        CoroutineLiveData2<T> coroutineLiveData2 = this.blockRunner;
        if (coroutineLiveData2 != null) {
            coroutineLiveData2.maybeRun();
        }
    }

    @Override // androidx.view.MediatorLiveData, androidx.view.LiveData
    public void onInactive() {
        super.onInactive();
        CoroutineLiveData2<T> coroutineLiveData2 = this.blockRunner;
        if (coroutineLiveData2 != null) {
            coroutineLiveData2.cancel();
        }
    }

    public CoroutineLiveData(CoroutineContext coroutineContext, long j, Function2<? super CoroutineLiveData7<T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics3.checkNotNullParameter(coroutineContext, "context");
        Intrinsics3.checkNotNullParameter(function2, "block");
        Supervisor supervisor = new Supervisor((Job) coroutineContext.get(Job.INSTANCE));
        CoroutineDispatcher coroutineDispatcher = Dispatchers.a;
        this.blockRunner = new CoroutineLiveData2<>(this, function2, j, f.c(MainDispatchers.f3830b.H().plus(coroutineContext).plus(supervisor)), new AnonymousClass1());
    }
}
