package com.discord.widgets.settings.account.mfa;

import android.content.Context;
import android.view.View;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetEnableMFAInput.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEnableMFAInput$onViewBound$1 extends o implements Function1<String, Unit> {
    public final /* synthetic */ View $view;
    public final /* synthetic */ WidgetEnableMFAInput this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetEnableMFAInput$onViewBound$1(WidgetEnableMFAInput widgetEnableMFAInput, View view) {
        super(1);
        this.this$0 = widgetEnableMFAInput;
        this.$view = view;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        m.checkNotNullParameter(str, "verificationCode");
        WidgetEnableMFAViewModel widgetEnableMFAViewModelAccess$getViewModel$p = WidgetEnableMFAInput.access$getViewModel$p(this.this$0);
        Context context = this.$view.getContext();
        m.checkNotNullExpressionValue(context, "view.context");
        widgetEnableMFAViewModelAccess$getViewModel$p.enableMFA(context, str);
    }
}
