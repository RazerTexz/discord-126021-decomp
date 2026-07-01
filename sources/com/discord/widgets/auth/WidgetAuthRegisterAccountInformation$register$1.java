package com.discord.widgets.auth;

import com.discord.api.auth.RegisterResponse;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.auth.RegistrationFlowRepo;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetAuthRegisterAccountInformation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthRegisterAccountInformation$register$1 extends o implements Function1<RegisterResponse, Unit> {
    public static final WidgetAuthRegisterAccountInformation$register$1 INSTANCE = new WidgetAuthRegisterAccountInformation$register$1();

    public WidgetAuthRegisterAccountInformation$register$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RegisterResponse registerResponse) {
        invoke2(registerResponse);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RegisterResponse registerResponse) {
        m.checkNotNullParameter(registerResponse, "it");
        AnalyticsTracker.INSTANCE.registered(true);
        RegistrationFlowRepo.trackTransition$default(RegistrationFlowRepo.Companion.getINSTANCE(), "Account Information", "success", null, 4, null);
    }
}
