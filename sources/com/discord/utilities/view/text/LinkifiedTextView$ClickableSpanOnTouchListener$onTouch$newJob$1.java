package com.discord.utilities.view.text;

import android.view.View;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.objectweb.asm.Opcodes;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.C12113l;
import p507d0.p584w.p585h.C12183c;
import p507d0.p584w.p586i.p587a.AbstractC12194k;
import p507d0.p584w.p586i.p587a.InterfaceC12188e;
import p507d0.p592z.p594d.C12238m;
import p659s.p660a.C13124k0;
import p659s.p660a.p661a.C13031n;

/* JADX INFO: compiled from: LinkifiedTextView.kt */
/* JADX INFO: loaded from: classes2.dex */
@InterfaceC12188e(m10084c = "com.discord.utilities.view.text.LinkifiedTextView$ClickableSpanOnTouchListener$onTouch$newJob$1", m10085f = "LinkifiedTextView.kt", m10086l = {Opcodes.D2I}, m10087m = "invokeSuspend")
public final class LinkifiedTextView$ClickableSpanOnTouchListener$onTouch$newJob$1 extends AbstractC12194k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Ref$ObjectRef $clickableSpan;
    public final /* synthetic */ WeakReference $weakView;
    private /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ LinkifiedTextView.ClickableSpanOnTouchListener this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LinkifiedTextView$ClickableSpanOnTouchListener$onTouch$newJob$1(LinkifiedTextView.ClickableSpanOnTouchListener clickableSpanOnTouchListener, WeakReference weakReference, Ref$ObjectRef ref$ObjectRef, Continuation continuation) {
        super(2, continuation);
        this.this$0 = clickableSpanOnTouchListener;
        this.$weakView = weakReference;
        this.$clickableSpan = ref$ObjectRef;
    }

    @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        C12238m.checkNotNullParameter(continuation, "completion");
        LinkifiedTextView$ClickableSpanOnTouchListener$onTouch$newJob$1 linkifiedTextView$ClickableSpanOnTouchListener$onTouch$newJob$1 = new LinkifiedTextView$ClickableSpanOnTouchListener$onTouch$newJob$1(this.this$0, this.$weakView, this.$clickableSpan, continuation);
        linkifiedTextView$ClickableSpanOnTouchListener$onTouch$newJob$1.L$0 = obj;
        return linkifiedTextView$ClickableSpanOnTouchListener$onTouch$newJob$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LinkifiedTextView$ClickableSpanOnTouchListener$onTouch$newJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f27425a);
    }

    @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        View view;
        Object coroutine_suspended = C12183c.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            C12113l.throwOnFailure(obj);
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            long j = this.this$0.longPressDelayInMs;
            this.L$0 = coroutineScope2;
            this.label = 1;
            if (C3404f.m4234P(j, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            coroutineScope = coroutineScope2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            CoroutineScope coroutineScope3 = (CoroutineScope) this.L$0;
            C12113l.throwOnFailure(obj);
            coroutineScope = coroutineScope3;
        }
        if (!this.this$0.isClickHandled.getAndSet(true) && C3404f.m4364y0(coroutineScope) && (view = (View) this.$weakView.get()) != null) {
            CoroutineDispatcher coroutineDispatcher = C13124k0.f27866a;
            C3404f.m4211H0(coroutineScope, C13031n.f27700b, null, new C7012xd6bb854f(view, null, this, coroutineScope), 2, null);
        }
        return Unit.f27425a;
    }
}
