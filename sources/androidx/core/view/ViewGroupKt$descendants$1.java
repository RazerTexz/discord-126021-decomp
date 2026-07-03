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
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ViewGroup.kt */
/* JADX INFO: loaded from: classes.dex */
@InterfaceC12188e(m10084c = "androidx.core.view.ViewGroupKt$descendants$1", m10085f = "ViewGroup.kt", m10086l = {97, 99}, m10087m = "invokeSuspend")
public final class ViewGroupKt$descendants$1 extends AbstractC12193j implements Function2<AbstractC12072k<? super View>, Continuation<? super Unit>, Object> {
    public final /* synthetic */ ViewGroup $this_descendants;
    public int I$0;
    public int I$1;
    private /* synthetic */ Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewGroupKt$descendants$1(ViewGroup viewGroup, Continuation<? super ViewGroupKt$descendants$1> continuation) {
        super(2, continuation);
        this.$this_descendants = viewGroup;
    }

    @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ViewGroupKt$descendants$1 viewGroupKt$descendants$1 = new ViewGroupKt$descendants$1(this.$this_descendants, continuation);
        viewGroupKt$descendants$1.L$0 = obj;
        return viewGroupKt$descendants$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(AbstractC12072k<? super View> abstractC12072k, Continuation<? super Unit> continuation) {
        return ((ViewGroupKt$descendants$1) create(abstractC12072k, continuation)).invokeSuspend(Unit.f27425a);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0077  */
    /* JADX WARN: Code duplicated, block: B:21:0x0090 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:22:0x0091  */
    /* JADX WARN: Code duplicated, block: B:24:0x0099  */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x009c, code lost:
    
        if (r4 >= r5) goto L26;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0091 -> B:23:0x0093). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0099 -> B:25:0x009c). Please report as a decompilation issue!!! */
    @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        AbstractC12072k abstractC12072k;
        ViewGroup viewGroup;
        int i;
        int childCount;
        ViewGroupKt$descendants$1 viewGroupKt$descendants$1;
        ViewGroupKt$descendants$1 viewGroupKt$descendants$2;
        ViewGroup viewGroup2;
        View view;
        int i2;
        Sequence<View> descendants;
        ViewGroup viewGroup3;
        AbstractC12072k abstractC12072k2;
        Object coroutine_suspended = C12183c.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                i2 = this.I$1;
                i = this.I$0;
                view = (View) this.L$2;
                viewGroup2 = (ViewGroup) this.L$1;
                AbstractC12072k abstractC12072k3 = (AbstractC12072k) this.L$0;
                C12113l.throwOnFailure(obj);
                abstractC12072k = abstractC12072k3;
                viewGroupKt$descendants$2 = this;
                if (view instanceof ViewGroup) {
                    descendants = ViewGroupKt.getDescendants((ViewGroup) view);
                    viewGroupKt$descendants$2.L$0 = abstractC12072k;
                    viewGroupKt$descendants$2.L$1 = viewGroup2;
                    viewGroupKt$descendants$2.L$2 = null;
                    viewGroupKt$descendants$2.I$0 = i;
                    viewGroupKt$descendants$2.I$1 = i2;
                    viewGroupKt$descendants$2.label = 2;
                    if (abstractC12072k.yieldAll(descendants, viewGroupKt$descendants$2) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    viewGroup3 = viewGroup2;
                    abstractC12072k2 = abstractC12072k;
                } else {
                    childCount = i2;
                    viewGroup = viewGroup2;
                    viewGroupKt$descendants$1 = viewGroupKt$descendants$2;
                }
            } else {
                if (i3 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i2 = this.I$1;
                i = this.I$0;
                viewGroup3 = (ViewGroup) this.L$1;
                abstractC12072k2 = (AbstractC12072k) this.L$0;
                C12113l.throwOnFailure(obj);
                viewGroupKt$descendants$2 = this;
            }
            abstractC12072k = abstractC12072k2;
            viewGroupKt$descendants$1 = viewGroupKt$descendants$2;
            ViewGroup viewGroup4 = viewGroup3;
            childCount = i2;
            viewGroup = viewGroup4;
        } else {
            C12113l.throwOnFailure(obj);
            abstractC12072k = (AbstractC12072k) this.L$0;
            viewGroup = this.$this_descendants;
            i = 0;
            childCount = viewGroup.getChildCount();
            if (childCount > 0) {
                viewGroupKt$descendants$1 = this;
                int i4 = i + 1;
                View childAt = viewGroup.getChildAt(i);
                C12238m.checkNotNullExpressionValue(childAt, "getChildAt(index)");
                viewGroupKt$descendants$1.L$0 = abstractC12072k;
                viewGroupKt$descendants$1.L$1 = viewGroup;
                viewGroupKt$descendants$1.L$2 = childAt;
                viewGroupKt$descendants$1.I$0 = i4;
                viewGroupKt$descendants$1.I$1 = childCount;
                viewGroupKt$descendants$1.label = 1;
                if (abstractC12072k.yield(childAt, viewGroupKt$descendants$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                ViewGroupKt$descendants$1 viewGroupKt$descendants$3 = viewGroupKt$descendants$1;
                viewGroup2 = viewGroup;
                i2 = childCount;
                view = childAt;
                i = i4;
                viewGroupKt$descendants$2 = viewGroupKt$descendants$3;
                if (view instanceof ViewGroup) {
                    descendants = ViewGroupKt.getDescendants((ViewGroup) view);
                    viewGroupKt$descendants$2.L$0 = abstractC12072k;
                    viewGroupKt$descendants$2.L$1 = viewGroup2;
                    viewGroupKt$descendants$2.L$2 = null;
                    viewGroupKt$descendants$2.I$0 = i;
                    viewGroupKt$descendants$2.I$1 = i2;
                    viewGroupKt$descendants$2.label = 2;
                    if (abstractC12072k.yieldAll(descendants, viewGroupKt$descendants$2) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    viewGroup3 = viewGroup2;
                    abstractC12072k2 = abstractC12072k;
                    abstractC12072k = abstractC12072k2;
                    viewGroupKt$descendants$1 = viewGroupKt$descendants$2;
                    ViewGroup viewGroup5 = viewGroup3;
                    childCount = i2;
                    viewGroup = viewGroup5;
                } else {
                    childCount = i2;
                    viewGroup = viewGroup2;
                    viewGroupKt$descendants$1 = viewGroupKt$descendants$2;
                }
            }
        }
        return Unit.f27425a;
    }
}
