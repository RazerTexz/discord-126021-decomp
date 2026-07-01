package com.discord.widgets.captcha;

import androidx.fragment.app.FragmentActivity;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetCaptcha.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetCaptcha$onViewBound$2$1 extends o implements Function0<Unit> {
    public final /* synthetic */ WidgetCaptcha$onViewBound$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCaptcha$onViewBound$2$1(WidgetCaptcha$onViewBound$2 widgetCaptcha$onViewBound$2) {
        super(0);
        this.this$0 = widgetCaptcha$onViewBound$2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        FragmentActivity activity = this.this$0.this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }
}
