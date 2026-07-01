package com.discord.widgets.auth;

import b.a.d.AppScreen2;
import com.discord.utilities.auth.RegistrationFlowRepo;
import com.discord.views.phone.PhoneOrEmailInputView;
import com.discord.widgets.auth.WidgetAuthPhoneVerify;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthRegisterIdentity$phoneVerifyLauncher$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetAuthRegisterIdentity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthRegisterIdentity7 extends Lambda implements Function1<WidgetAuthPhoneVerify.Result, Unit> {
    public final /* synthetic */ WidgetAuthRegisterIdentity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAuthRegisterIdentity7(WidgetAuthRegisterIdentity widgetAuthRegisterIdentity) {
        super(1);
        this.this$0 = widgetAuthRegisterIdentity;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetAuthPhoneVerify.Result result) {
        invoke2(result);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetAuthPhoneVerify.Result result) {
        Intrinsics3.checkNotNullParameter(result, "result");
        if (!(result instanceof WidgetAuthPhoneVerify.Result.Token)) {
            if (result instanceof WidgetAuthPhoneVerify.Result.Cancelled) {
                this.this$0.setInputMode(PhoneOrEmailInputView.Mode.EMAIL);
            }
        } else {
            RegistrationFlowRepo.Companion companion = RegistrationFlowRepo.INSTANCE;
            RegistrationFlowRepo.trackTransition$default(companion.getINSTANCE(), "Phone Verification", "success", null, 4, null);
            companion.getINSTANCE().setPhoneToken(((WidgetAuthPhoneVerify.Result.Token) result).getToken());
            AppScreen2.e(this.this$0.requireContext(), WidgetAuthRegisterAccountInformation.class, null, 4);
        }
    }
}
