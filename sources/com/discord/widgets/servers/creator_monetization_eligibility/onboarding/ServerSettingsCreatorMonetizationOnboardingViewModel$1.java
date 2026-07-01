package com.discord.widgets.servers.creator_monetization_eligibility.onboarding;

import androidx.core.app.NotificationCompat;
import d0.o;
import kotlin.Pair;
import rx.functions.Func2;

/* JADX INFO: compiled from: ServerSettingsCreatorMonetizationOnboardingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ServerSettingsCreatorMonetizationOnboardingViewModel$1<T1, T2, R> implements Func2<ServerSettingsCreatorMonetizationOnboardingViewModel$StoreState, ServerSettingsCreatorMonetizationOnboardingViewModel$RequirementsState, Pair<? extends ServerSettingsCreatorMonetizationOnboardingViewModel$StoreState, ? extends ServerSettingsCreatorMonetizationOnboardingViewModel$RequirementsState>> {
    public static final ServerSettingsCreatorMonetizationOnboardingViewModel$1 INSTANCE = new ServerSettingsCreatorMonetizationOnboardingViewModel$1();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ Pair<? extends ServerSettingsCreatorMonetizationOnboardingViewModel$StoreState, ? extends ServerSettingsCreatorMonetizationOnboardingViewModel$RequirementsState> call(ServerSettingsCreatorMonetizationOnboardingViewModel$StoreState serverSettingsCreatorMonetizationOnboardingViewModel$StoreState, ServerSettingsCreatorMonetizationOnboardingViewModel$RequirementsState serverSettingsCreatorMonetizationOnboardingViewModel$RequirementsState) {
        return call2(serverSettingsCreatorMonetizationOnboardingViewModel$StoreState, serverSettingsCreatorMonetizationOnboardingViewModel$RequirementsState);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Pair<ServerSettingsCreatorMonetizationOnboardingViewModel$StoreState, ServerSettingsCreatorMonetizationOnboardingViewModel$RequirementsState> call2(ServerSettingsCreatorMonetizationOnboardingViewModel$StoreState serverSettingsCreatorMonetizationOnboardingViewModel$StoreState, ServerSettingsCreatorMonetizationOnboardingViewModel$RequirementsState serverSettingsCreatorMonetizationOnboardingViewModel$RequirementsState) {
        return o.to(serverSettingsCreatorMonetizationOnboardingViewModel$StoreState, serverSettingsCreatorMonetizationOnboardingViewModel$RequirementsState);
    }
}
