package com.discord.widgets.settings.account;

import androidx.fragment.app.FragmentActivity;
import com.discord.utilities.stateful.StatefulViews;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountUsernameEdit$passwordVerifyLauncher$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetSettingsAccountUsernameEdit.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccountUsernameEdit3 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ WidgetSettingsAccountUsernameEdit this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsAccountUsernameEdit3(WidgetSettingsAccountUsernameEdit widgetSettingsAccountUsernameEdit) {
        super(0);
        this.this$0 = widgetSettingsAccountUsernameEdit;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StatefulViews.clear$default(this.this$0.state, false, 1, null);
        FragmentActivity fragmentActivityE = this.this$0.e();
        if (fragmentActivityE != null) {
            fragmentActivityE.onBackPressed();
        }
    }
}
