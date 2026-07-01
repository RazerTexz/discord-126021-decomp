package com.discord.widgets.servers.creator_monetization_eligibility.onboarding;

import com.discord.api.creatormonetization.CreatorMonetizationEnableRequest;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.servers.creator_monetization_eligibility.onboarding.ServerSettingsCreatorMonetizationOnboardingViewModel$submitTermsAcceptance$1$2, reason: use source file name */
/* JADX INFO: compiled from: ServerSettingsCreatorMonetizationOnboardingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ServerSettingsCreatorMonetizationOnboardingViewModel6 extends Lambda implements Function1<CreatorMonetizationEnableRequest, Unit> {
    public static final ServerSettingsCreatorMonetizationOnboardingViewModel6 INSTANCE = new ServerSettingsCreatorMonetizationOnboardingViewModel6();

    public ServerSettingsCreatorMonetizationOnboardingViewModel6() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(CreatorMonetizationEnableRequest creatorMonetizationEnableRequest) {
        invoke2(creatorMonetizationEnableRequest);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(CreatorMonetizationEnableRequest creatorMonetizationEnableRequest) {
    }
}
