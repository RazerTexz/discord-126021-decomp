package com.discord.widgets.settings.account;

import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
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

/* JADX INFO: compiled from: WidgetSettingsAccount.kt */
/* JADX INFO: loaded from: classes2.dex */
@e(c = "com.discord.widgets.settings.account.WidgetSettingsAccount$onViewBound$1", f = "WidgetSettingsAccount.kt", l = {65}, m = "invokeSuspend")
public final class WidgetSettingsAccount$onViewBound$1 extends k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public int label;
    public final /* synthetic */ WidgetSettingsAccount this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsAccount$onViewBound$1(WidgetSettingsAccount widgetSettingsAccount, Continuation continuation) {
        super(2, continuation);
        this.this$0 = widgetSettingsAccount;
    }

    @Override // d0.w.i.a.a
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        m.checkNotNullParameter(continuation, "completion");
        return new WidgetSettingsAccount$onViewBound$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WidgetSettingsAccount$onViewBound$1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
    }

    @Override // d0.w.i.a.a
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = c.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            l.throwOnFailure(obj);
            this.label = 1;
            if (f.P(500L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            l.throwOnFailure(obj);
        }
        NestedScrollView nestedScrollView = WidgetSettingsAccount.access$getBinding$p(this.this$0).f2593x;
        LinearLayout linearLayout = WidgetSettingsAccount.access$getBinding$p(this.this$0).v;
        m.checkNotNullExpressionValue(linearLayout, "binding.settingsAccountPrivateDataWrap");
        nestedScrollView.smoothScrollTo(0, linearLayout.getBottom());
        TextView textView = WidgetSettingsAccount.access$getBinding$p(this.this$0).u;
        m.checkNotNullExpressionValue(textView, "binding.settingsAccountPrivateDataDisable");
        ViewExtensions.hintWithRipple$default(textView, 0L, 1, null);
        return Unit.a;
    }
}
