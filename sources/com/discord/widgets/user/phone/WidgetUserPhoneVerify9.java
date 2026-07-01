package com.discord.widgets.user.phone;

import androidx.fragment.app.FragmentActivity;
import b.a.d.AppScreen2;
import com.discord.widgets.settings.account.WidgetSettingsAccount;
import com.discord.widgets.user.account.WidgetUserAccountVerifyBase;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.user.phone.WidgetUserPhoneVerify$passwordVerifyLauncher$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetUserPhoneVerify.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserPhoneVerify9 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ WidgetUserPhoneVerify this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserPhoneVerify9(WidgetUserPhoneVerify widgetUserPhoneVerify) {
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
        Intrinsics3.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
        if (fragmentActivityRequireActivity.getCallingActivity() != null) {
            this.this$0.requireActivity().setResult(-1);
            this.this$0.requireActivity().finish();
        } else if (this.this$0.getMode() == WidgetUserAccountVerifyBase.Mode.NO_HISTORY_FROM_USER_SETTINGS) {
            WidgetSettingsAccount.INSTANCE.launch(this.this$0.requireContext(), false, WidgetSettingsAccount.Redirect.SMS_BACKUP);
        } else {
            if (this.this$0.isForced()) {
                return;
            }
            AppScreen2.c(this.this$0.requireContext(), false, null, 6);
        }
    }
}
