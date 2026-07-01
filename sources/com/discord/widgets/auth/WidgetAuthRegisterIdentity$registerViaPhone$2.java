package com.discord.widgets.auth;

import b.a.k.b;
import com.discord.utilities.auth.RegistrationFlowRepo;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetAuthRegisterIdentity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthRegisterIdentity$registerViaPhone$2 extends o implements Function1<Void, Unit> {
    public final /* synthetic */ String $phone;
    public final /* synthetic */ WidgetAuthRegisterIdentity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAuthRegisterIdentity$registerViaPhone$2(WidgetAuthRegisterIdentity widgetAuthRegisterIdentity, String str) {
        super(1);
        this.this$0 = widgetAuthRegisterIdentity;
        this.$phone = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
        invoke2(r1);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Void r13) {
        RegistrationFlowRepo.trackTransition$default(RegistrationFlowRepo.Companion.getINSTANCE(), "Account Identity", "success", null, 4, null);
        WidgetAuthPhoneVerify.Companion.launch(this.this$0.requireContext(), WidgetAuthRegisterIdentity.access$getPhoneVerifyLauncher$p(this.this$0), WidgetAuthRegisterIdentity.access$getBinding$p(this.this$0).d.getTextOrEmpty(), b.h(this.this$0.requireContext(), 2131895678, new Object[0], null, 4), b.h(this.this$0.requireContext(), 2131895677, new Object[]{this.$phone}, null, 4));
    }
}
