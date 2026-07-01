package com.discord.widgets.settings.account;

import androidx.fragment.app.FragmentActivity;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetSettingsAccountEmailEditConfirm.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccountEmailEditConfirm$passwordVerifyLauncher$1 extends o implements Function0<Unit> {
    public final /* synthetic */ WidgetSettingsAccountEmailEditConfirm this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsAccountEmailEditConfirm$passwordVerifyLauncher$1(WidgetSettingsAccountEmailEditConfirm widgetSettingsAccountEmailEditConfirm) {
        super(0);
        this.this$0 = widgetSettingsAccountEmailEditConfirm;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            activity.setResult(-1);
        }
        FragmentActivity activity2 = this.this$0.getActivity();
        if (activity2 != null) {
            activity2.onBackPressed();
        }
    }
}
