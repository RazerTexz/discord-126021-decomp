package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import d0.Result3;
import d0.f0.SequenceBuilder2;
import d0.w.h.Intrinsics2;
import d0.w.i.a.ContinuationImpl5;
import d0.w.i.a.DebugMetadata;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;

/* JADX INFO: renamed from: androidx.core.view.ViewGroupKt$descendants$1, reason: use source file name */
/* JADX INFO: compiled from: ViewGroup.kt */
/* JADX INFO: loaded from: classes.dex */
@DebugMetadata(c = "androidx.core.view.ViewGroupKt$descendants$1", f = "ViewGroup.kt", l = {97, 99}, m = "invokeSuspend")
public final class ViewGroup3 extends ContinuationImpl5 implements Function2<SequenceBuilder2<? super View>, Continuation<? super Unit>, Object> {
    public final /* synthetic */ ViewGroup $this_descendants;
    public int I$0;
    public int I$1;
    private /* synthetic */ Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewGroup3(ViewGroup viewGroup, Continuation<? super ViewGroup3> continuation) {
        super(2, continuation);
        this.$this_descendants = viewGroup;
    }

    @Override // d0.w.i.a.ContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ViewGroup3 viewGroup3 = new ViewGroup3(this.$this_descendants, continuation);
        viewGroup3.L$0 = obj;
        return viewGroup3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SequenceBuilder2<? super View> sequenceBuilder2, Continuation<? super Unit> continuation) {
        return ((ViewGroup3) create(sequenceBuilder2, continuation)).invokeSuspend(Unit.a);
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
    @Override // d0.w.i.a.ContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        SequenceBuilder2 sequenceBuilder2;
        ViewGroup viewGroup;
        int i;
        int childCount;
        ViewGroup3 viewGroup3;
        ViewGroup3 viewGroup4;
        ViewGroup viewGroup2;
        View view;
        int i2;
        Sequence<View> descendants;
        ViewGroup viewGroup5;
        SequenceBuilder2 sequenceBuilder3;
        Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                i2 = this.I$1;
                i = this.I$0;
                view = (View) this.L$2;
                viewGroup2 = (ViewGroup) this.L$1;
                SequenceBuilder2 sequenceBuilder4 = (SequenceBuilder2) this.L$0;
                Result3.throwOnFailure(obj);
                sequenceBuilder2 = sequenceBuilder4;
                viewGroup4 = this;
                if (view instanceof ViewGroup) {
                    descendants = ViewGroup.getDescendants((ViewGroup) view);
                    viewGroup4.L$0 = sequenceBuilder2;
                    viewGroup4.L$1 = viewGroup2;
                    viewGroup4.L$2 = null;
                    viewGroup4.I$0 = i;
                    viewGroup4.I$1 = i2;
                    viewGroup4.label = 2;
                    if (sequenceBuilder2.yieldAll(descendants, viewGroup4) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    viewGroup5 = viewGroup2;
                    sequenceBuilder3 = sequenceBuilder2;
                } else {
                    childCount = i2;
                    viewGroup = viewGroup2;
                    viewGroup3 = viewGroup4;
                }
            } else {
                if (i3 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i2 = this.I$1;
                i = this.I$0;
                viewGroup5 = (ViewGroup) this.L$1;
                sequenceBuilder3 = (SequenceBuilder2) this.L$0;
                Result3.throwOnFailure(obj);
                viewGroup4 = this;
            }
            sequenceBuilder2 = sequenceBuilder3;
            viewGroup3 = viewGroup4;
            ViewGroup viewGroup6 = viewGroup5;
            childCount = i2;
            viewGroup = viewGroup6;
        } else {
            Result3.throwOnFailure(obj);
            sequenceBuilder2 = (SequenceBuilder2) this.L$0;
            viewGroup = this.$this_descendants;
            i = 0;
            childCount = viewGroup.getChildCount();
            if (childCount > 0) {
                viewGroup3 = this;
                int i4 = i + 1;
                View childAt = viewGroup.getChildAt(i);
                Intrinsics3.checkNotNullExpressionValue(childAt, "getChildAt(index)");
                viewGroup3.L$0 = sequenceBuilder2;
                viewGroup3.L$1 = viewGroup;
                viewGroup3.L$2 = childAt;
                viewGroup3.I$0 = i4;
                viewGroup3.I$1 = childCount;
                viewGroup3.label = 1;
                if (sequenceBuilder2.yield(childAt, viewGroup3) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                ViewGroup3 viewGroup7 = viewGroup3;
                viewGroup2 = viewGroup;
                i2 = childCount;
                view = childAt;
                i = i4;
                viewGroup4 = viewGroup7;
                if (view instanceof ViewGroup) {
                    descendants = ViewGroup.getDescendants((ViewGroup) view);
                    viewGroup4.L$0 = sequenceBuilder2;
                    viewGroup4.L$1 = viewGroup2;
                    viewGroup4.L$2 = null;
                    viewGroup4.I$0 = i;
                    viewGroup4.I$1 = i2;
                    viewGroup4.label = 2;
                    if (sequenceBuilder2.yieldAll(descendants, viewGroup4) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    viewGroup5 = viewGroup2;
                    sequenceBuilder3 = sequenceBuilder2;
                    sequenceBuilder2 = sequenceBuilder3;
                    viewGroup3 = viewGroup4;
                    ViewGroup viewGroup8 = viewGroup5;
                    childCount = i2;
                    viewGroup = viewGroup8;
                } else {
                    childCount = i2;
                    viewGroup = viewGroup2;
                    viewGroup3 = viewGroup4;
                }
            }
        }
        return Unit.a;
    }
}
