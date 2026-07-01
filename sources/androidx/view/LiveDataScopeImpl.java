package androidx.view;

import androidx.exifinterface.media.ExifInterface;
import b.i.a.f.e.o.f;
import d0.w.h.c;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import s.a.a.n;
import s.a.k0;
import s.a.m0;

/* JADX INFO: compiled from: CoroutineLiveData.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LiveDataScopeImpl<T> implements LiveDataScope<T> {
    private final CoroutineContext coroutineContext;
    private CoroutineLiveData<T> target;

    public LiveDataScopeImpl(CoroutineLiveData<T> coroutineLiveData, CoroutineContext coroutineContext) {
        m.checkNotNullParameter(coroutineLiveData, "target");
        m.checkNotNullParameter(coroutineContext, "context");
        this.target = coroutineLiveData;
        CoroutineDispatcher coroutineDispatcher = k0.a;
        this.coroutineContext = coroutineContext.plus(n.f3830b.H());
    }

    @Override // androidx.view.LiveDataScope
    public Object emit(T t, Continuation<? super Unit> continuation) throws Throwable {
        Object objC1 = f.C1(this.coroutineContext, new LiveDataScopeImpl$emit$2(this, t, null), continuation);
        return objC1 == c.getCOROUTINE_SUSPENDED() ? objC1 : Unit.a;
    }

    @Override // androidx.view.LiveDataScope
    public Object emitSource(LiveData<T> liveData, Continuation<? super m0> continuation) {
        return f.C1(this.coroutineContext, new LiveDataScopeImpl$emitSource$2(this, liveData, null), continuation);
    }

    @Override // androidx.view.LiveDataScope
    public T getLatestValue() {
        return this.target.getValue();
    }

    public final CoroutineLiveData<T> getTarget$lifecycle_livedata_ktx_release() {
        return this.target;
    }

    public final void setTarget$lifecycle_livedata_ktx_release(CoroutineLiveData<T> coroutineLiveData) {
        m.checkNotNullParameter(coroutineLiveData, "<set-?>");
        this.target = coroutineLiveData;
    }
}
