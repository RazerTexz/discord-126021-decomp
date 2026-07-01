package com.discord.widgets.settings.account;

import android.view.View;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsAccountEmailEditConfirm.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccountEmailEditConfirm$configureUI$1$1 extends o implements Function1<View, Unit> {
    public final /* synthetic */ WidgetSettingsAccountEmailEditConfirm$configureUI$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsAccountEmailEditConfirm$configureUI$1$1(WidgetSettingsAccountEmailEditConfirm$configureUI$1 widgetSettingsAccountEmailEditConfirm$configureUI$1) {
        super(1);
        this.this$0 = widgetSettingsAccountEmailEditConfirm$configureUI$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "it");
        WidgetSettingsAccountEmailEditConfirm.access$resendVerificationCode(this.this$0.this$0);
    }
}
