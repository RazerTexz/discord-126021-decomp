package com.discord.utilities.view.text;

import android.view.View;
import com.discord.utilities.spans.ClickableSpan;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import p507d0.C12113l;
import p507d0.p584w.p585h.C12183c;
import p507d0.p584w.p586i.p587a.AbstractC12194k;
import p507d0.p584w.p586i.p587a.InterfaceC12188e;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.utilities.view.text.LinkifiedTextView$ClickableSpanOnTouchListener$onTouch$newJob$1$invokeSuspend$$inlined$also$lambda$1 */
/* JADX INFO: compiled from: LinkifiedTextView.kt */
/* JADX INFO: loaded from: classes2.dex */
@InterfaceC12188e(m10084c = "com.discord.utilities.view.text.LinkifiedTextView$ClickableSpanOnTouchListener$onTouch$newJob$1$1$1", m10085f = "LinkifiedTextView.kt", m10086l = {}, m10087m = "invokeSuspend")
public final class C7012xd6bb854f extends AbstractC12194k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ View $it;
    public final /* synthetic */ CoroutineScope $this_launch$inlined;
    public int label;
    public final /* synthetic */ LinkifiedTextView$ClickableSpanOnTouchListener$onTouch$newJob$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C7012xd6bb854f(View view, Continuation continuation, LinkifiedTextView$ClickableSpanOnTouchListener$onTouch$newJob$1 linkifiedTextView$ClickableSpanOnTouchListener$onTouch$newJob$1, CoroutineScope coroutineScope) {
        super(2, continuation);
        this.$it = view;
        this.this$0 = linkifiedTextView$ClickableSpanOnTouchListener$onTouch$newJob$1;
        this.$this_launch$inlined = coroutineScope;
    }

    @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        C12238m.checkNotNullParameter(continuation, "completion");
        return new C7012xd6bb854f(this.$it, continuation, this.this$0, this.$this_launch$inlined);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((C7012xd6bb854f) create(coroutineScope, continuation)).invokeSuspend(Unit.f27425a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
    public final Object invokeSuspend(Object obj) {
        C12183c.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C12113l.throwOnFailure(obj);
        ClickableSpan clickableSpan = (ClickableSpan) ((android.text.style.ClickableSpan) this.this$0.$clickableSpan.element);
        View view = this.$it;
        C12238m.checkNotNullExpressionValue(view, "it");
        clickableSpan.onLongPress(view);
        return Unit.f27425a;
    }
}
