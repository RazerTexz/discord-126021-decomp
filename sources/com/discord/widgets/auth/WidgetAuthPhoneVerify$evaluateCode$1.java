package com.discord.widgets.auth;

import com.discord.analytics.generated.events.network_action.TrackNetworkActionUserVerifyPhone;
import com.discord.analytics.generated.traits.TrackNetworkMetadataReceiver;
import com.discord.models.domain.ModelPhoneVerificationToken;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetAuthPhoneVerify.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthPhoneVerify$evaluateCode$1 extends o implements Function1<ModelPhoneVerificationToken, TrackNetworkMetadataReceiver> {
    public static final WidgetAuthPhoneVerify$evaluateCode$1 INSTANCE = new WidgetAuthPhoneVerify$evaluateCode$1();

    public WidgetAuthPhoneVerify$evaluateCode$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ TrackNetworkMetadataReceiver invoke(ModelPhoneVerificationToken modelPhoneVerificationToken) {
        return invoke2(modelPhoneVerificationToken);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final TrackNetworkMetadataReceiver invoke2(ModelPhoneVerificationToken modelPhoneVerificationToken) {
        return new TrackNetworkActionUserVerifyPhone();
    }
}
