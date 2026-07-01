package com.discord.widgets.settings.account;

import android.widget.TextView;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsAccountEmailEditConfirm.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccountEmailEditConfirm$onViewBound$1 extends o implements Function1<TextView, Unit> {
    public final /* synthetic */ WidgetSettingsAccountEmailEditConfirm this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsAccountEmailEditConfirm$onViewBound$1(WidgetSettingsAccountEmailEditConfirm widgetSettingsAccountEmailEditConfirm) {
        super(1);
        this.this$0 = widgetSettingsAccountEmailEditConfirm;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
        invoke2(textView);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(TextView textView) {
        m.checkNotNullParameter(textView, "it");
        WidgetSettingsAccountEmailEditConfirm.access$submitVerificationCode(this.this$0);
    }
}
