package com.discord.widgets.user.phone;

import androidx.fragment.app.FragmentActivity;
import b.a.d.j;
import com.discord.widgets.settings.account.WidgetSettingsAccount;
import com.discord.widgets.settings.account.WidgetSettingsAccount$Redirect;
import com.discord.widgets.user.account.WidgetUserAccountVerifyBase$Mode;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetUserPhoneVerify.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserPhoneVerify$passwordVerifyLauncher$1 extends o implements Function0<Unit> {
    public final /* synthetic */ WidgetUserPhoneVerify this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserPhoneVerify$passwordVerifyLauncher$1(WidgetUserPhoneVerify widgetUserPhoneVerify) {
        super(0);
        this.this$0 = widgetUserPhoneVerify;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        FragmentActivity fragmentActivityRequireActivity = this.this$0.requireActivity();
        m.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
        if (fragmentActivityRequireActivity.getCallingActivity() != null) {
            this.this$0.requireActivity().setResult(-1);
            this.this$0.requireActivity().finish();
        } else if (WidgetUserPhoneVerify.access$getMode$p(this.this$0) == WidgetUserAccountVerifyBase$Mode.NO_HISTORY_FROM_USER_SETTINGS) {
            WidgetSettingsAccount.Companion.launch(this.this$0.requireContext(), false, WidgetSettingsAccount$Redirect.SMS_BACKUP);
        } else {
            if (this.this$0.isForced()) {
                return;
            }
            j.c(this.this$0.requireContext(), false, null, 6);
        }
    }
}
