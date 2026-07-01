package com.discord.widgets.contact_sync;

import com.discord.analytics.generated.events.network_action.TrackNetworkActionUserBulkRelationshipsUpdate;
import com.discord.analytics.generated.traits.TrackNetworkMetadataReceiver;
import com.discord.api.friendsuggestions.BulkAddFriendsResponse;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetContactSyncViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetContactSyncViewModel$onBulkAddFriends$1 extends o implements Function1<BulkAddFriendsResponse, TrackNetworkMetadataReceiver> {
    public static final WidgetContactSyncViewModel$onBulkAddFriends$1 INSTANCE = new WidgetContactSyncViewModel$onBulkAddFriends$1();

    public WidgetContactSyncViewModel$onBulkAddFriends$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ TrackNetworkMetadataReceiver invoke(BulkAddFriendsResponse bulkAddFriendsResponse) {
        return invoke2(bulkAddFriendsResponse);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final TrackNetworkMetadataReceiver invoke2(BulkAddFriendsResponse bulkAddFriendsResponse) {
        return new TrackNetworkActionUserBulkRelationshipsUpdate();
    }
}
