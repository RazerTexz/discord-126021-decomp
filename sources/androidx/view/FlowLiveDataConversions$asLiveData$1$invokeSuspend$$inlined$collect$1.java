package androidx.view;

import d0.w.h.c;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import s.a.d2.e;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: Collect.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FlowLiveDataConversions$asLiveData$1$invokeSuspend$$inlined$collect$1<T> implements e<T> {
    public final /* synthetic */ LiveDataScope $this_liveData$inlined;

    public FlowLiveDataConversions$asLiveData$1$invokeSuspend$$inlined$collect$1(LiveDataScope liveDataScope) {
        this.$this_liveData$inlined = liveDataScope;
    }

    @Override // s.a.d2.e
    public Object emit(Object obj, Continuation continuation) {
        Object objEmit = this.$this_liveData$inlined.emit(obj, continuation);
        return objEmit == c.getCOROUTINE_SUSPENDED() ? objEmit : Unit.a;
    }
}
