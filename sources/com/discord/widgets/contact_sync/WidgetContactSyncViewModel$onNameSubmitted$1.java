package com.discord.widgets.contact_sync;

import com.discord.analytics.generated.events.network_action.TrackNetworkActionUserConnectionsUpdate;
import com.discord.analytics.generated.traits.TrackNetworkMetadataReceiver;
import com.discord.api.connectedaccounts.ConnectedAccount;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetContactSyncViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetContactSyncViewModel$onNameSubmitted$1 extends o implements Function1<ConnectedAccount, TrackNetworkMetadataReceiver> {
    public final /* synthetic */ String $submittingName;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetContactSyncViewModel$onNameSubmitted$1(String str) {
        super(1);
        this.$submittingName = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ TrackNetworkMetadataReceiver invoke(ConnectedAccount connectedAccount) {
        return invoke2(connectedAccount);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final TrackNetworkMetadataReceiver invoke2(ConnectedAccount connectedAccount) {
        return new TrackNetworkActionUserConnectionsUpdate(this.$submittingName, Boolean.TRUE, null, null, 12);
    }
}
