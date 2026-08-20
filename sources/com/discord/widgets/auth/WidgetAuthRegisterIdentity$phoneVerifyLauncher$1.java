package com.discord.widgets.auth;

import com.discord.utilities.auth.RegistrationFlowRepo;
import com.discord.views.phone.PhoneOrEmailInputView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p018d.C0870j;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetAuthRegisterIdentity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthRegisterIdentity$phoneVerifyLauncher$1 extends AbstractC12240o implements Function1<WidgetAuthPhoneVerify.Result, Unit> {
    public final /* synthetic */ WidgetAuthRegisterIdentity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAuthRegisterIdentity$phoneVerifyLauncher$1(WidgetAuthRegisterIdentity widgetAuthRegisterIdentity) {
        super(1);
        this.this$0 = widgetAuthRegisterIdentity;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetAuthPhoneVerify.Result result) {
        invoke2(result);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetAuthPhoneVerify.Result result) {
        C12238m.checkNotNullParameter(result, "result");
        if (!(result instanceof WidgetAuthPhoneVerify.Result.Token)) {
            if (result instanceof WidgetAuthPhoneVerify.Result.Cancelled) {
                this.this$0.setInputMode(PhoneOrEmailInputView.Mode.EMAIL);
            }
        } else {
            RegistrationFlowRepo.Companion companion = RegistrationFlowRepo.INSTANCE;
            RegistrationFlowRepo.trackTransition$default(companion.getINSTANCE(), "Phone Verification", "success", null, 4, null);
            companion.getINSTANCE().setPhoneToken(((WidgetAuthPhoneVerify.Result.Token) result).getToken());
            C0870j.m157e(this.this$0.requireContext(), WidgetAuthRegisterAccountInformation.class, null, 4);
        }
    }
}
