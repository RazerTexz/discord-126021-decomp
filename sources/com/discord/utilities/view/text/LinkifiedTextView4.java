package com.discord.utilities.view.text;

import android.view.View;
import com.discord.utilities.spans.ClickableSpan;
import d0.Result3;
import d0.w.h.Intrinsics2;
import d0.w.i.a.ContinuationImpl6;
import d0.w.i.a.DebugMetadata;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: renamed from: com.discord.utilities.view.text.LinkifiedTextView$ClickableSpanOnTouchListener$onTouch$newJob$1$invokeSuspend$$inlined$also$lambda$1, reason: use source file name */
/* JADX INFO: compiled from: LinkifiedTextView.kt */
/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.discord.utilities.view.text.LinkifiedTextView$ClickableSpanOnTouchListener$onTouch$newJob$1$1$1", f = "LinkifiedTextView.kt", l = {}, m = "invokeSuspend")
public final class LinkifiedTextView4 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ View $it;
    public final /* synthetic */ CoroutineScope $this_launch$inlined;
    public int label;
    public final /* synthetic */ LinkifiedTextView3 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LinkifiedTextView4(View view, Continuation continuation, LinkifiedTextView3 linkifiedTextView3, CoroutineScope coroutineScope) {
        super(2, continuation);
        this.$it = view;
        this.this$0 = linkifiedTextView3;
        this.$this_launch$inlined = coroutineScope;
    }

    @Override // d0.w.i.a.ContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics3.checkNotNullParameter(continuation, "completion");
        return new LinkifiedTextView4(this.$it, continuation, this.this$0, this.$this_launch$inlined);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LinkifiedTextView4) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // d0.w.i.a.ContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Intrinsics2.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Result3.throwOnFailure(obj);
        ClickableSpan clickableSpan = (ClickableSpan) ((android.text.style.ClickableSpan) this.this$0.$clickableSpan.element);
        View view = this.$it;
        Intrinsics3.checkNotNullExpressionValue(view, "it");
        clickableSpan.onLongPress(view);
        return Unit.a;
    }
}
