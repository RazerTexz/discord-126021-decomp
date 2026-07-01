package com.discord.utilities.view.text;

import android.view.View;
import com.discord.utilities.spans.ClickableSpan;
import d0.l;
import d0.w.h.c;
import d0.w.i.a.e;
import d0.w.i.a.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: LinkifiedTextView.kt */
/* JADX INFO: loaded from: classes2.dex */
@e(c = "com.discord.utilities.view.text.LinkifiedTextView$ClickableSpanOnTouchListener$onTouch$newJob$1$1$1", f = "LinkifiedTextView.kt", l = {}, m = "invokeSuspend")
public final class LinkifiedTextView$ClickableSpanOnTouchListener$onTouch$newJob$1$invokeSuspend$$inlined$also$lambda$1 extends k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ View $it;
    public final /* synthetic */ CoroutineScope $this_launch$inlined;
    public int label;
    public final /* synthetic */ LinkifiedTextView$ClickableSpanOnTouchListener$onTouch$newJob$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LinkifiedTextView$ClickableSpanOnTouchListener$onTouch$newJob$1$invokeSuspend$$inlined$also$lambda$1(View view, Continuation continuation, LinkifiedTextView$ClickableSpanOnTouchListener$onTouch$newJob$1 linkifiedTextView$ClickableSpanOnTouchListener$onTouch$newJob$1, CoroutineScope coroutineScope) {
        super(2, continuation);
        this.$it = view;
        this.this$0 = linkifiedTextView$ClickableSpanOnTouchListener$onTouch$newJob$1;
        this.$this_launch$inlined = coroutineScope;
    }

    @Override // d0.w.i.a.a
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        m.checkNotNullParameter(continuation, "completion");
        return new LinkifiedTextView$ClickableSpanOnTouchListener$onTouch$newJob$1$invokeSuspend$$inlined$also$lambda$1(this.$it, continuation, this.this$0, this.$this_launch$inlined);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LinkifiedTextView$ClickableSpanOnTouchListener$onTouch$newJob$1$invokeSuspend$$inlined$also$lambda$1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // d0.w.i.a.a
    public final Object invokeSuspend(Object obj) {
        c.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        l.throwOnFailure(obj);
        ClickableSpan clickableSpan = (ClickableSpan) ((android.text.style.ClickableSpan) this.this$0.$clickableSpan.element);
        View view = this.$it;
        m.checkNotNullExpressionValue(view, "it");
        clickableSpan.onLongPress(view);
        return Unit.a;
    }
}
