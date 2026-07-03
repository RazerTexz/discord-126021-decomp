package androidx.view;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.C12113l;
import p507d0.p584w.p585h.C12183c;
import p507d0.p584w.p586i.p587a.AbstractC12194k;
import p507d0.p584w.p586i.p587a.InterfaceC12188e;
import p507d0.p592z.p594d.C12238m;
import p659s.p660a.C13124k0;
import p659s.p660a.InterfaceC13130m0;
import p659s.p660a.p661a.C13031n;

/* JADX INFO: compiled from: CoroutineLiveData.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LiveDataScopeImpl<T> implements LiveDataScope<T> {
    private final CoroutineContext coroutineContext;
    private CoroutineLiveData<T> target;

    /* JADX INFO: renamed from: androidx.lifecycle.LiveDataScopeImpl$emit$2 */
    /* JADX INFO: compiled from: CoroutineLiveData.kt */
    @InterfaceC12188e(m10084c = "androidx.lifecycle.LiveDataScopeImpl$emit$2", m10085f = "CoroutineLiveData.kt", m10086l = {98}, m10087m = "invokeSuspend")
    public static final class C04442 extends AbstractC12194k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ Object $value;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04442(Object obj, Continuation continuation) {
            super(2, continuation);
            this.$value = obj;
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C12238m.checkNotNullParameter(continuation, "completion");
            return new C04442(this.$value, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04442) create(coroutineScope, continuation)).invokeSuspend(Unit.f27425a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = C12183c.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                C12113l.throwOnFailure(obj);
                CoroutineLiveData<T> target$lifecycle_livedata_ktx_release = LiveDataScopeImpl.this.getTarget$lifecycle_livedata_ktx_release();
                this.label = 1;
                if (target$lifecycle_livedata_ktx_release.clearSource$lifecycle_livedata_ktx_release(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C12113l.throwOnFailure(obj);
            }
            LiveDataScopeImpl.this.getTarget$lifecycle_livedata_ktx_release().setValue(this.$value);
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.LiveDataScopeImpl$emitSource$2 */
    /* JADX INFO: compiled from: CoroutineLiveData.kt */
    @InterfaceC12188e(m10084c = "androidx.lifecycle.LiveDataScopeImpl$emitSource$2", m10085f = "CoroutineLiveData.kt", m10086l = {94}, m10087m = "invokeSuspend")
    public static final class C04452 extends AbstractC12194k implements Function2<CoroutineScope, Continuation<? super InterfaceC13130m0>, Object> {
        public final /* synthetic */ LiveData $source;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04452(LiveData liveData, Continuation continuation) {
            super(2, continuation);
            this.$source = liveData;
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C12238m.checkNotNullParameter(continuation, "completion");
            return new C04452(this.$source, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super InterfaceC13130m0> continuation) {
            return ((C04452) create(coroutineScope, continuation)).invokeSuspend(Unit.f27425a);
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = C12183c.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                C12113l.throwOnFailure(obj);
                CoroutineLiveData<T> target$lifecycle_livedata_ktx_release = LiveDataScopeImpl.this.getTarget$lifecycle_livedata_ktx_release();
                LiveData<T> liveData = this.$source;
                this.label = 1;
                obj = target$lifecycle_livedata_ktx_release.emitSource$lifecycle_livedata_ktx_release(liveData, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C12113l.throwOnFailure(obj);
            }
            return obj;
        }
    }

    public LiveDataScopeImpl(CoroutineLiveData<T> coroutineLiveData, CoroutineContext coroutineContext) {
        C12238m.checkNotNullParameter(coroutineLiveData, "target");
        C12238m.checkNotNullParameter(coroutineContext, "context");
        this.target = coroutineLiveData;
        CoroutineDispatcher coroutineDispatcher = C13124k0.f27866a;
        this.coroutineContext = coroutineContext.plus(C13031n.f27700b.mo11194H());
    }

    @Override // androidx.view.LiveDataScope
    public Object emit(T t, Continuation<? super Unit> continuation) throws Throwable {
        Object objM4197C1 = C3404f.m4197C1(this.coroutineContext, new C04442(t, null), continuation);
        return objM4197C1 == C12183c.getCOROUTINE_SUSPENDED() ? objM4197C1 : Unit.f27425a;
    }

    @Override // androidx.view.LiveDataScope
    public Object emitSource(LiveData<T> liveData, Continuation<? super InterfaceC13130m0> continuation) {
        return C3404f.m4197C1(this.coroutineContext, new C04452(liveData, null), continuation);
    }

    @Override // androidx.view.LiveDataScope
    public T getLatestValue() {
        return this.target.getValue();
    }

    public final CoroutineLiveData<T> getTarget$lifecycle_livedata_ktx_release() {
        return this.target;
    }

    public final void setTarget$lifecycle_livedata_ktx_release(CoroutineLiveData<T> coroutineLiveData) {
        C12238m.checkNotNullParameter(coroutineLiveData, "<set-?>");
        this.target = coroutineLiveData;
    }
}
