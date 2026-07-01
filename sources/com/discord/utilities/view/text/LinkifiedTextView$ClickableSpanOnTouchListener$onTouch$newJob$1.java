package com.discord.utilities.view.text;

import android.view.View;
import b.i.a.f.e.o.f;
import d0.l;
import d0.w.h.c;
import d0.w.i.a.e;
import d0.w.i.a.k;
import d0.z.d.m;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.objectweb.asm.Opcodes;
import s.a.a.n;
import s.a.k0;

/* JADX INFO: compiled from: LinkifiedTextView.kt */
/* JADX INFO: loaded from: classes2.dex */
@e(c = "com.discord.utilities.view.text.LinkifiedTextView$ClickableSpanOnTouchListener$onTouch$newJob$1", f = "LinkifiedTextView.kt", l = {Opcodes.D2I}, m = "invokeSuspend")
public final class LinkifiedTextView$ClickableSpanOnTouchListener$onTouch$newJob$1 extends k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Ref$ObjectRef $clickableSpan;
    public final /* synthetic */ WeakReference $weakView;
    private /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ LinkifiedTextView$ClickableSpanOnTouchListener this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LinkifiedTextView$ClickableSpanOnTouchListener$onTouch$newJob$1(LinkifiedTextView$ClickableSpanOnTouchListener linkifiedTextView$ClickableSpanOnTouchListener, WeakReference weakReference, Ref$ObjectRef ref$ObjectRef, Continuation continuation) {
        super(2, continuation);
        this.this$0 = linkifiedTextView$ClickableSpanOnTouchListener;
        this.$weakView = weakReference;
        this.$clickableSpan = ref$ObjectRef;
    }

    @Override // d0.w.i.a.a
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        m.checkNotNullParameter(continuation, "completion");
        LinkifiedTextView$ClickableSpanOnTouchListener$onTouch$newJob$1 linkifiedTextView$ClickableSpanOnTouchListener$onTouch$newJob$1 = new LinkifiedTextView$ClickableSpanOnTouchListener$onTouch$newJob$1(this.this$0, this.$weakView, this.$clickableSpan, continuation);
        linkifiedTextView$ClickableSpanOnTouchListener$onTouch$newJob$1.L$0 = obj;
        return linkifiedTextView$ClickableSpanOnTouchListener$onTouch$newJob$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LinkifiedTextView$ClickableSpanOnTouchListener$onTouch$newJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
    }

    @Override // d0.w.i.a.a
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        View view;
        Object coroutine_suspended = c.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            l.throwOnFailure(obj);
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            long jAccess$getLongPressDelayInMs$p = LinkifiedTextView$ClickableSpanOnTouchListener.access$getLongPressDelayInMs$p(this.this$0);
            this.L$0 = coroutineScope2;
            this.label = 1;
            if (f.P(jAccess$getLongPressDelayInMs$p, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            coroutineScope = coroutineScope2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            CoroutineScope coroutineScope3 = (CoroutineScope) this.L$0;
            l.throwOnFailure(obj);
            coroutineScope = coroutineScope3;
        }
        if (!LinkifiedTextView$ClickableSpanOnTouchListener.access$isClickHandled$p(this.this$0).getAndSet(true) && f.y0(coroutineScope) && (view = (View) this.$weakView.get()) != null) {
            CoroutineDispatcher coroutineDispatcher = k0.a;
            f.H0(coroutineScope, n.f3830b, null, new LinkifiedTextView$ClickableSpanOnTouchListener$onTouch$newJob$1$invokeSuspend$$inlined$also$lambda$1(view, null, this, coroutineScope), 2, null);
        }
        return Unit.a;
    }
}
