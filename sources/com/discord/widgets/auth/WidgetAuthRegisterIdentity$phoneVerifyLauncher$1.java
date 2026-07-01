package com.discord.widgets.auth;

import b.a.d.j;
import com.discord.utilities.auth.RegistrationFlowRepo;
import com.discord.utilities.auth.RegistrationFlowRepo$Companion;
import com.discord.views.phone.PhoneOrEmailInputView$Mode;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetAuthRegisterIdentity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthRegisterIdentity$phoneVerifyLauncher$1 extends o implements Function1<WidgetAuthPhoneVerify$Result, Unit> {
    public final /* synthetic */ WidgetAuthRegisterIdentity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAuthRegisterIdentity$phoneVerifyLauncher$1(WidgetAuthRegisterIdentity widgetAuthRegisterIdentity) {
        super(1);
        this.this$0 = widgetAuthRegisterIdentity;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetAuthPhoneVerify$Result widgetAuthPhoneVerify$Result) {
        invoke2(widgetAuthPhoneVerify$Result);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetAuthPhoneVerify$Result widgetAuthPhoneVerify$Result) {
        m.checkNotNullParameter(widgetAuthPhoneVerify$Result, "result");
        if (!(widgetAuthPhoneVerify$Result instanceof WidgetAuthPhoneVerify$Result$Token)) {
            if (widgetAuthPhoneVerify$Result instanceof WidgetAuthPhoneVerify$Result$Cancelled) {
                WidgetAuthRegisterIdentity.access$setInputMode(this.this$0, PhoneOrEmailInputView$Mode.EMAIL);
            }
        } else {
            RegistrationFlowRepo$Companion registrationFlowRepo$Companion = RegistrationFlowRepo.Companion;
            RegistrationFlowRepo.trackTransition$default(registrationFlowRepo$Companion.getINSTANCE(), "Phone Verification", "success", null, 4, null);
            registrationFlowRepo$Companion.getINSTANCE().setPhoneToken(((WidgetAuthPhoneVerify$Result$Token) widgetAuthPhoneVerify$Result).getToken());
            j.e(this.this$0.requireContext(), WidgetAuthRegisterAccountInformation.class, null, 4);
        }
    }
}
