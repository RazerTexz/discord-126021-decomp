package com.discord.widgets.settings.account;

import androidx.fragment.app.FragmentActivity;
import com.discord.utilities.stateful.StatefulViews;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetSettingsAccountUsernameEdit.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccountUsernameEdit$passwordVerifyLauncher$1 extends AbstractC12240o implements Function0<Unit> {
    public final /* synthetic */ WidgetSettingsAccountUsernameEdit this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsAccountUsernameEdit$passwordVerifyLauncher$1(WidgetSettingsAccountUsernameEdit widgetSettingsAccountUsernameEdit) {
        super(0);
        this.this$0 = widgetSettingsAccountUsernameEdit;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StatefulViews.clear$default(this.this$0.state, false, 1, null);
        FragmentActivity fragmentActivityM95e = this.this$0.m95e();
        if (fragmentActivityM95e != null) {
            fragmentActivityM95e.onBackPressed();
        }
    }
}
