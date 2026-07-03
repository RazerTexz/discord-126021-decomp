package com.discord.widgets.user.phone;

import androidx.fragment.app.FragmentActivity;
import com.discord.widgets.settings.account.WidgetSettingsAccount;
import com.discord.widgets.user.account.WidgetUserAccountVerifyBase;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p007b.p008a.p018d.C0870j;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetUserPhoneVerify.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserPhoneVerify$passwordVerifyLauncher$1 extends AbstractC12240o implements Function0<Unit> {
    public final /* synthetic */ WidgetUserPhoneVerify this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserPhoneVerify$passwordVerifyLauncher$1(WidgetUserPhoneVerify widgetUserPhoneVerify) {
        super(0);
        this.this$0 = widgetUserPhoneVerify;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        FragmentActivity fragmentActivityRequireActivity = this.this$0.requireActivity();
        C12238m.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
        if (fragmentActivityRequireActivity.getCallingActivity() != null) {
            this.this$0.requireActivity().setResult(-1);
            this.this$0.requireActivity().finish();
        } else if (this.this$0.getMode() == WidgetUserAccountVerifyBase.Mode.NO_HISTORY_FROM_USER_SETTINGS) {
            WidgetSettingsAccount.INSTANCE.launch(this.this$0.requireContext(), false, WidgetSettingsAccount.Redirect.SMS_BACKUP);
        } else {
            if (this.this$0.isForced()) {
                return;
            }
            C0870j.m155c(this.this$0.requireContext(), false, null, 6);
        }
    }
}
