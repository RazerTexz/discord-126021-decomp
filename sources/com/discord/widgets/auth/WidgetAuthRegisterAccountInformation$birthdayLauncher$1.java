package com.discord.widgets.auth;

import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.auth.RegistrationFlowRepo;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetAuthRegisterAccountInformation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthRegisterAccountInformation$birthdayLauncher$1 extends AbstractC12240o implements Function1<Long, Unit> {
    public final /* synthetic */ WidgetAuthRegisterAccountInformation this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAuthRegisterAccountInformation$birthdayLauncher$1(WidgetAuthRegisterAccountInformation widgetAuthRegisterAccountInformation) {
        super(1);
        this.this$0 = widgetAuthRegisterAccountInformation;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
        invoke(l.longValue());
        return Unit.f27425a;
    }

    public final void invoke(long j) {
        RegistrationFlowRepo.Companion companion = RegistrationFlowRepo.INSTANCE;
        RegistrationFlowRepo.trackTransition$default(companion.getINSTANCE(), "Age Gate", "success", null, 4, null);
        companion.getINSTANCE().setBirthday(Long.valueOf(j));
        AnalyticsTracker.INSTANCE.ageGateSubmitted(j, "Register");
        WidgetAuthRegisterAccountInformation.register$default(this.this$0, null, 1, null);
    }
}
