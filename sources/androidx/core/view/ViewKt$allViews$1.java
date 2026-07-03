package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;
import p507d0.C12113l;
import p507d0.p578f0.AbstractC12072k;
import p507d0.p584w.p585h.C12183c;
import p507d0.p584w.p586i.p587a.AbstractC12193j;
import p507d0.p584w.p586i.p587a.InterfaceC12188e;

/* JADX INFO: compiled from: View.kt */
/* JADX INFO: loaded from: classes.dex */
@InterfaceC12188e(m10084c = "androidx.core.view.ViewKt$allViews$1", m10085f = "View.kt", m10086l = {406, 408}, m10087m = "invokeSuspend")
public final class ViewKt$allViews$1 extends AbstractC12193j implements Function2<AbstractC12072k<? super View>, Continuation<? super Unit>, Object> {
    public final /* synthetic */ View $this_allViews;
    private /* synthetic */ Object L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewKt$allViews$1(View view, Continuation<? super ViewKt$allViews$1> continuation) {
        super(2, continuation);
        this.$this_allViews = view;
    }

    @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ViewKt$allViews$1 viewKt$allViews$1 = new ViewKt$allViews$1(this.$this_allViews, continuation);
        viewKt$allViews$1.L$0 = obj;
        return viewKt$allViews$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(AbstractC12072k<? super View> abstractC12072k, Continuation<? super Unit> continuation) {
        return ((ViewKt$allViews$1) create(abstractC12072k, continuation)).invokeSuspend(Unit.f27425a);
    }

    @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
    public final Object invokeSuspend(Object obj) {
        AbstractC12072k abstractC12072k;
        Object coroutine_suspended = C12183c.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                abstractC12072k = (AbstractC12072k) this.L$0;
                C12113l.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C12113l.throwOnFailure(obj);
            }
            return Unit.f27425a;
        }
        C12113l.throwOnFailure(obj);
        abstractC12072k = (AbstractC12072k) this.L$0;
        View view = this.$this_allViews;
        this.L$0 = abstractC12072k;
        this.label = 1;
        if (abstractC12072k.yield(view, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        View view2 = this.$this_allViews;
        if (view2 instanceof ViewGroup) {
            Sequence<View> descendants = ViewGroupKt.getDescendants((ViewGroup) view2);
            this.L$0 = null;
            this.label = 2;
            if (abstractC12072k.yieldAll(descendants, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.f27425a;
    }
}
