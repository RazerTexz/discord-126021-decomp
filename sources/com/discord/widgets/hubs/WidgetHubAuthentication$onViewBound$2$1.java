package com.discord.widgets.hubs;

import android.view.View;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetHubAuthentication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubAuthentication$onViewBound$2$1 extends o implements Function1<View, Unit> {
    public final /* synthetic */ WidgetHubAuthentication$onViewBound$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubAuthentication$onViewBound$2$1(WidgetHubAuthentication$onViewBound$2 widgetHubAuthentication$onViewBound$2) {
        super(1);
        this.this$0 = widgetHubAuthentication$onViewBound$2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "it");
        WidgetHubAuthentication.access$getViewModel$p(this.this$0.this$0).resendEmail();
    }
}
