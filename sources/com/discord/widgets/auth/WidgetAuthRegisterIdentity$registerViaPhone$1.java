package com.discord.widgets.auth;

import com.discord.analytics.generated.events.network_action.TrackNetworkActionUserRegisterPhone;
import com.discord.analytics.generated.traits.TrackNetworkMetadataReceiver;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetAuthRegisterIdentity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthRegisterIdentity$registerViaPhone$1 extends o implements Function1<Void, TrackNetworkMetadataReceiver> {
    public static final WidgetAuthRegisterIdentity$registerViaPhone$1 INSTANCE = new WidgetAuthRegisterIdentity$registerViaPhone$1();

    public WidgetAuthRegisterIdentity$registerViaPhone$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ TrackNetworkMetadataReceiver invoke(Void r1) {
        return invoke2(r1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final TrackNetworkMetadataReceiver invoke2(Void r1) {
        return new TrackNetworkActionUserRegisterPhone();
    }
}
