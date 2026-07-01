package com.discord.stores;

import com.discord.analytics.generated.events.network_action.TrackNetworkActionUserContactsSync;
import com.discord.analytics.generated.traits.TrackNetworkMetadataReceiver;
import com.discord.api.friendsuggestions.BulkFriendSuggestions;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreContactSync.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreContactSync$backgroundUploadContacts$1 extends o implements Function1<BulkFriendSuggestions, TrackNetworkMetadataReceiver> {
    public static final StoreContactSync$backgroundUploadContacts$1 INSTANCE = new StoreContactSync$backgroundUploadContacts$1();

    public StoreContactSync$backgroundUploadContacts$1() {
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
