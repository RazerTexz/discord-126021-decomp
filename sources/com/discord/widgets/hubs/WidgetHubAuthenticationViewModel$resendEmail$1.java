package com.discord.widgets.hubs;

import com.discord.analytics.generated.events.network_action.TrackNetworkActionHubEmailVerifySend;
import com.discord.analytics.generated.traits.TrackNetworkMetadataReceiver;
import com.discord.api.hubs.EmailVerification;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetHubAuthenticationlViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubAuthenticationViewModel$resendEmail$1 extends o implements Function1<EmailVerification, TrackNetworkMetadataReceiver> {
    public static final WidgetHubAuthenticationViewModel$resendEmail$1 INSTANCE = new WidgetHubAuthenticationViewModel$resendEmail$1();

    public WidgetHubAuthenticationViewModel$resendEmail$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ TrackNetworkMetadataReceiver invoke(EmailVerification emailVerification) {
        return invoke2(emailVerification);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final TrackNetworkMetadataReceiver invoke2(EmailVerification emailVerification) {
        return new TrackNetworkActionHubEmailVerifySend(emailVerification != null ? Boolean.valueOf(emailVerification.getHasMatchingGuild()) : null);
    }
}
