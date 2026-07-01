package com.discord.widgets.auth;

import com.discord.models.domain.ModelInvite;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.auth.RegistrationFlowRepo;
import com.discord.utilities.auth.RegistrationFlowRepo$Companion;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetAuthRegisterIdentity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthRegisterIdentity$onViewCreated$1 extends o implements Function1<ModelInvite, Unit> {
    public static final WidgetAuthRegisterIdentity$onViewCreated$1 INSTANCE = new WidgetAuthRegisterIdentity$onViewCreated$1();

    public WidgetAuthRegisterIdentity$onViewCreated$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ModelInvite modelInvite) {
        invoke2(modelInvite);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ModelInvite modelInvite) {
        AnalyticsTracker.INSTANCE.registerViewed(modelInvite);
        RegistrationFlowRepo$Companion registrationFlowRepo$Companion = RegistrationFlowRepo.Companion;
        registrationFlowRepo$Companion.getINSTANCE().setInvite(modelInvite);
        RegistrationFlowRepo.trackTransition$default(registrationFlowRepo$Companion.getINSTANCE(), "Account Identity", "viewed", null, 4, null);
    }
}
