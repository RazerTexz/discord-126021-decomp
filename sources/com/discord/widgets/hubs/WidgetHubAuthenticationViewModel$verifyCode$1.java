package com.discord.widgets.hubs;

import com.discord.analytics.generated.events.network_action.TrackNetworkActionHubEmailVerify;
import com.discord.analytics.generated.traits.TrackNetworkMetadataReceiver;
import com.discord.api.hubs.EmailVerificationCode;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetHubAuthenticationlViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubAuthenticationViewModel$verifyCode$1 extends o implements Function1<EmailVerificationCode, TrackNetworkMetadataReceiver> {
    public static final WidgetHubAuthenticationViewModel$verifyCode$1 INSTANCE = new WidgetHubAuthenticationViewModel$verifyCode$1();

    public WidgetHubAuthenticationViewModel$verifyCode$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ TrackNetworkMetadataReceiver invoke(EmailVerificationCode emailVerificationCode) {
        return invoke2(emailVerificationCode);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final TrackNetworkMetadataReceiver invoke2(EmailVerificationCode emailVerificationCode) {
        return new TrackNetworkActionHubEmailVerify();
    }
}
