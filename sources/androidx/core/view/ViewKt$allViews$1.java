package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import d0.f0.k;
import d0.l;
import d0.w.h.c;
import d0.w.i.a.e;
import d0.w.i.a.j;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;

/* JADX INFO: compiled from: View.kt */
/* JADX INFO: loaded from: classes.dex */
@e(c = "androidx.core.view.ViewKt$allViews$1", f = "View.kt", l = {406, 408}, m = "invokeSuspend")
public final class ViewKt$allViews$1 extends j implements Function2<k<? super View>, Continuation<? super Unit>, Object> {
    public final /* synthetic */ View $this_allViews;
    private /* synthetic */ Object L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewKt$allViews$1(View view, Continuation<? super ViewKt$allViews$1> continuation) {
        super(2, continuation);
        this.$this_allViews = view;
    }

    @Override // d0.w.i.a.a
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ViewKt$allViews$1 viewKt$allViews$1 = new ViewKt$allViews$1(this.$this_allViews, continuation);
        viewKt$allViews$1.L$0 = obj;
        return viewKt$allViews$1;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(k<? super View> kVar, Continuation<? super Unit> continuation) {
        return ((ViewKt$allViews$1) create(kVar, continuation)).invokeSuspend(Unit.a);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(k<? super View> kVar, Continuation<? super Unit> continuation) {
        return invoke2(kVar, continuation);
    }

    @Override // d0.w.i.a.a
    public final Object invokeSuspend(Object obj) {
        k kVar;
        Object coroutine_suspended = c.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                kVar = (k) this.L$0;
                l.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                l.throwOnFailure(obj);
            }
            return Unit.a;
        }
        l.throwOnFailure(obj);
        kVar = (k) this.L$0;
        View view = this.$this_allViews;
        this.L$0 = kVar;
        this.label = 1;
        if (kVar.yield(view, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        View view2 = this.$this_allViews;
        if (view2 instanceof ViewGroup) {
            Sequence<View> descendants = ViewGroupKt.getDescendants((ViewGroup) view2);
            this.L$0 = null;
            this.label = 2;
            if (kVar.yieldAll(descendants, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.a;
    }
}
