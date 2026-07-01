package com.discord.widgets.contact_sync;

import com.discord.analytics.generated.events.network_action.TrackNetworkActionUserContactsSync;
import com.discord.analytics.generated.traits.TrackNetworkMetadataReceiver;
import com.discord.api.friendsuggestions.BulkFriendSuggestions;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetContactSyncViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetContactSyncViewModel$onContactsFetched$1 extends o implements Function1<BulkFriendSuggestions, TrackNetworkMetadataReceiver> {
    public static final WidgetContactSyncViewModel$onContactsFetched$1 INSTANCE = new WidgetContactSyncViewModel$onContactsFetched$1();

    public WidgetContactSyncViewModel$onContactsFetched$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ TrackNetworkMetadataReceiver invoke(BulkFriendSuggestions bulkFriendSuggestions) {
        return invoke2(bulkFriendSuggestions);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final TrackNetworkMetadataReceiver invoke2(BulkFriendSuggestions bulkFriendSuggestions) {
        return new TrackNetworkActionUserContactsSync();
    }
}
