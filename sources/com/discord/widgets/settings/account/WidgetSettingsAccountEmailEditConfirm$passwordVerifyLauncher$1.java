package com.discord.widgets.settings.account;

import androidx.fragment.app.FragmentActivity;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetSettingsAccountEmailEditConfirm.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccountEmailEditConfirm$passwordVerifyLauncher$1 extends AbstractC12240o implements Function0<Unit> {
    public final /* synthetic */ WidgetSettingsAccountEmailEditConfirm this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsAccountEmailEditConfirm$passwordVerifyLauncher$1(WidgetSettingsAccountEmailEditConfirm widgetSettingsAccountEmailEditConfirm) {
        super(0);
        this.this$0 = widgetSettingsAccountEmailEditConfirm;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        FragmentActivity fragmentActivityM95e = this.this$0.m95e();
        if (fragmentActivityM95e != null) {
            fragmentActivityM95e.setResult(-1);
        }
        FragmentActivity fragmentActivityM95e2 = this.this$0.m95e();
        if (fragmentActivityM95e2 != null) {
            fragmentActivityM95e2.onBackPressed();
        }
    }
}
