package com.discord.widgets.nux;

import android.text.Editable;
import d0.g0.t;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetNuxPostRegistrationJoin.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetNuxPostRegistrationJoin$onViewBound$2 extends o implements Function1<Editable, Unit> {
    public final /* synthetic */ WidgetNuxPostRegistrationJoin this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetNuxPostRegistrationJoin$onViewBound$2(WidgetNuxPostRegistrationJoin widgetNuxPostRegistrationJoin) {
        super(1);
        this.this$0 = widgetNuxPostRegistrationJoin;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
        invoke2(editable);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Editable editable) {
        m.checkNotNullParameter(editable, "editable");
        this.this$0.getBinding().f2423b.setText(t.isBlank(editable) ? 2131893450 : 2131892378);
    }
}
