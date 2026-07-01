package com.discord.widgets.settings;

import android.view.View;
import b.i.a.f.e.o.f;
import com.discord.utilities.view.extensions.ViewExtensions;
import d0.l;
import d0.w.h.c;
import d0.w.i.a.e;
import d0.w.i.a.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: WidgetSettingsVoice.kt */
/* JADX INFO: loaded from: classes2.dex */
@e(c = "com.discord.widgets.settings.WidgetSettingsVoice$onViewBound$3$1", f = "WidgetSettingsVoice.kt", l = {112}, m = "invokeSuspend")
public final class WidgetSettingsVoice$onViewBound$3$1 extends k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ View $target;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsVoice$onViewBound$3$1(View view, Continuation continuation) {
        super(2, continuation);
        this.$target = view;
    }

    @Override // d0.w.i.a.a
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        m.checkNotNullParameter(continuation, "completion");
        return new WidgetSettingsVoice$onViewBound$3$1(this.$target, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WidgetSettingsVoice$onViewBound$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
    }

    @Override // d0.w.i.a.a
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = c.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            l.throwOnFailure(obj);
            this.label = 1;
            if (f.P(1000L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            l.throwOnFailure(obj);
        }
        View view = this.$target;
        m.checkNotNullExpressionValue(view, "target");
        ViewExtensions.hintWithRipple$default(view, 0L, 1, null);
        return Unit.a;
    }
}
