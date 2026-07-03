package androidx.view;

import androidx.annotation.RequiresApi;
import androidx.exifinterface.media.ExifInterface;
import java.time.Duration;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.C12113l;
import p507d0.p584w.C12179f;
import p507d0.p584w.p585h.C12183c;
import p507d0.p584w.p586i.p587a.AbstractC12194k;
import p507d0.p584w.p586i.p587a.InterfaceC12188e;
import p507d0.p592z.p594d.C12238m;
import p659s.p660a.C13124k0;
import p659s.p660a.p661a.C13031n;

/* JADX INFO: compiled from: CoroutineLiveData.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CoroutineLiveDataKt {
    public static final long DEFAULT_TIMEOUT = 5000;

    /* JADX INFO: renamed from: androidx.lifecycle.CoroutineLiveDataKt$addDisposableSource$2 */
    /* JADX INFO: compiled from: CoroutineLiveData.kt */
    @InterfaceC12188e(m10084c = "androidx.lifecycle.CoroutineLiveDataKt$addDisposableSource$2", m10085f = "CoroutineLiveData.kt", m10086l = {}, m10087m = "invokeSuspend")
    public static final class C04302 extends AbstractC12194k implements Function2<CoroutineScope, Continuation<? super EmittedSource>, Object> {
        public final /* synthetic */ LiveData $source;
        public final /* synthetic */ MediatorLiveData $this_addDisposableSource;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04302(MediatorLiveData mediatorLiveData, LiveData liveData, Continuation continuation) {
            super(2, continuation);
            this.$this_addDisposableSource = mediatorLiveData;
            this.$source = liveData;
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C12238m.checkNotNullParameter(continuation, "completion");
            return new C04302(this.$this_addDisposableSource, this.$source, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super EmittedSource> continuation) {
            return ((C04302) create(coroutineScope, continuation)).invokeSuspend(Unit.f27425a);
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Object invokeSuspend(Object obj) {
            C12183c.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C12113l.throwOnFailure(obj);
            this.$this_addDisposableSource.addSource(this.$source, new Observer<T>() { // from class: androidx.lifecycle.CoroutineLiveDataKt.addDisposableSource.2.1
                @Override // androidx.view.Observer
                public final void onChanged(T t) {
                    C04302.this.$this_addDisposableSource.setValue(t);
                }
            });
            return new EmittedSource(this.$source, this.$this_addDisposableSource);
        }
    }

    public static final <T> Object addDisposableSource(MediatorLiveData<T> mediatorLiveData, LiveData<T> liveData, Continuation<? super EmittedSource> continuation) {
        CoroutineDispatcher coroutineDispatcher = C13124k0.f27866a;
        return C3404f.m4197C1(C13031n.f27700b.mo11194H(), new C04302(mediatorLiveData, liveData, null), continuation);
    }

    public static final <T> LiveData<T> liveData(CoroutineContext coroutineContext, long j, Function2<? super LiveDataScope<T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        C12238m.checkNotNullParameter(coroutineContext, "context");
        C12238m.checkNotNullParameter(function2, "block");
        return new CoroutineLiveData(coroutineContext, j, function2);
    }

    public static /* synthetic */ LiveData liveData$default(CoroutineContext coroutineContext, long j, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = C12179f.f25237j;
        }
        if ((i & 2) != 0) {
            j = 5000;
        }
        return liveData(coroutineContext, j, function2);
    }

    @RequiresApi(26)
    public static final <T> LiveData<T> liveData(CoroutineContext coroutineContext, Duration duration, Function2<? super LiveDataScope<T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        C12238m.checkNotNullParameter(coroutineContext, "context");
        C12238m.checkNotNullParameter(duration, "timeout");
        C12238m.checkNotNullParameter(function2, "block");
        return new CoroutineLiveData(coroutineContext, duration.toMillis(), function2);
    }

    public static /* synthetic */ LiveData liveData$default(CoroutineContext coroutineContext, Duration duration, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = C12179f.f25237j;
        }
        return liveData(coroutineContext, duration, function2);
    }
}
