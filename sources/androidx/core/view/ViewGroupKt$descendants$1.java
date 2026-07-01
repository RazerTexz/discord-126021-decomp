package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import d0.f0.k;
import d0.l;
import d0.w.h.c;
import d0.w.i.a.e;
import d0.w.i.a.j;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;

/* JADX INFO: compiled from: ViewGroup.kt */
/* JADX INFO: loaded from: classes.dex */
@e(c = "androidx.core.view.ViewGroupKt$descendants$1", f = "ViewGroup.kt", l = {97, 99}, m = "invokeSuspend")
public final class ViewGroupKt$descendants$1 extends j implements Function2<k<? super View>, Continuation<? super Unit>, Object> {
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

    @Override // d0.w.i.a.a
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ViewGroupKt$descendants$1 viewGroupKt$descendants$1 = new ViewGroupKt$descendants$1(this.$this_descendants, continuation);
        viewGroupKt$descendants$1.L$0 = obj;
        return viewGroupKt$descendants$1;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(k<? super View> kVar, Continuation<? super Unit> continuation) {
        return ((ViewGroupKt$descendants$1) create(kVar, continuation)).invokeSuspend(Unit.a);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(k<? super View> kVar, Continuation<? super Unit> continuation) {
        return invoke2(kVar, continuation);
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
    @Override // d0.w.i.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        k kVar;
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
        k kVar2;
        Object coroutine_suspended = c.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                i2 = this.I$1;
                i = this.I$0;
                view = (View) this.L$2;
                viewGroup2 = (ViewGroup) this.L$1;
                k kVar3 = (k) this.L$0;
                l.throwOnFailure(obj);
                kVar = kVar3;
                viewGroupKt$descendants$2 = this;
                if (view instanceof ViewGroup) {
                    descendants = ViewGroupKt.getDescendants((ViewGroup) view);
                    viewGroupKt$descendants$2.L$0 = kVar;
                    viewGroupKt$descendants$2.L$1 = viewGroup2;
                    viewGroupKt$descendants$2.L$2 = null;
                    viewGroupKt$descendants$2.I$0 = i;
                    viewGroupKt$descendants$2.I$1 = i2;
                    viewGroupKt$descendants$2.label = 2;
                    if (kVar.yieldAll(descendants, viewGroupKt$descendants$2) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    viewGroup3 = viewGroup2;
                    kVar2 = kVar;
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
                kVar2 = (k) this.L$0;
                l.throwOnFailure(obj);
                viewGroupKt$descendants$2 = this;
            }
            kVar = kVar2;
            viewGroupKt$descendants$1 = viewGroupKt$descendants$2;
            ViewGroup viewGroup4 = viewGroup3;
            childCount = i2;
            viewGroup = viewGroup4;
        } else {
            l.throwOnFailure(obj);
            kVar = (k) this.L$0;
            viewGroup = this.$this_descendants;
            i = 0;
            childCount = viewGroup.getChildCount();
            if (childCount > 0) {
                viewGroupKt$descendants$1 = this;
                int i4 = i + 1;
                View childAt = viewGroup.getChildAt(i);
                m.checkNotNullExpressionValue(childAt, "getChildAt(index)");
                viewGroupKt$descendants$1.L$0 = kVar;
                viewGroupKt$descendants$1.L$1 = viewGroup;
                viewGroupKt$descendants$1.L$2 = childAt;
                viewGroupKt$descendants$1.I$0 = i4;
                viewGroupKt$descendants$1.I$1 = childCount;
                viewGroupKt$descendants$1.label = 1;
                if (kVar.yield(childAt, viewGroupKt$descendants$1) == coroutine_suspended) {
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
                    viewGroupKt$descendants$2.L$0 = kVar;
                    viewGroupKt$descendants$2.L$1 = viewGroup2;
                    viewGroupKt$descendants$2.L$2 = null;
                    viewGroupKt$descendants$2.I$0 = i;
                    viewGroupKt$descendants$2.I$1 = i2;
                    viewGroupKt$descendants$2.label = 2;
                    if (kVar.yieldAll(descendants, viewGroupKt$descendants$2) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    viewGroup3 = viewGroup2;
                    kVar2 = kVar;
                    kVar = kVar2;
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
        return Unit.a;
    }
}
