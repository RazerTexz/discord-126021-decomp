package com.discord.widgets.chat.list;

import android.view.View;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import s.a.d2.e;

/* JADX INFO: compiled from: Collect.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InlineMediaView$onViewAttachedToWindow$1$invokeSuspend$$inlined$collect$1 implements e<Boolean> {
    public final /* synthetic */ InlineMediaView$onViewAttachedToWindow$1 this$0;

    public InlineMediaView$onViewAttachedToWindow$1$invokeSuspend$$inlined$collect$1(InlineMediaView$onViewAttachedToWindow$1 inlineMediaView$onViewAttachedToWindow$1) {
        this.this$0 = inlineMediaView$onViewAttachedToWindow$1;
    }

    @Override // s.a.d2.e
    public Object emit(Boolean bool, Continuation continuation) {
        Boolean bool2 = bool;
        View view = InlineMediaView.access$getBinding$p(this.this$0.this$0).h;
        m.checkNotNullExpressionValue(view, "binding.opacityShim");
        m.checkNotNullExpressionValue(bool2, "isAnyPanelOpen");
        view.setVisibility(bool2.booleanValue() ? 0 : 8);
        return Unit.a;
    }
}
