package com.discord.widgets.servers.member_verification;

import com.discord.widgets.user.account.WidgetUserAccountVerifyBase$Mode;
import com.discord.widgets.user.phone.WidgetUserPhoneManage;
import com.discord.widgets.user.phone.WidgetUserPhoneManage$Companion$Source;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetMemberVerification.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetMemberVerification$configureVerificationBanner$2 extends o implements Function0<Unit> {
    public final /* synthetic */ WidgetMemberVerification this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetMemberVerification$configureVerificationBanner$2(WidgetMemberVerification widgetMemberVerification) {
        super(0);
        this.this$0 = widgetMemberVerification;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WidgetUserPhoneManage.Companion.launch(this.this$0.requireContext(), WidgetUserAccountVerifyBase$Mode.UNFORCED, WidgetUserPhoneManage$Companion$Source.GUILD_PHONE_REQUIRED);
    }
}
