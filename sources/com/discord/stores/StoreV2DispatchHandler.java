package com.discord.stores;

import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import d0.z.d.Intrinsics3;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StoreV2DispatchHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreV2DispatchHandler implements Store2 {
    private final ObservationDeck observationDeck;
    private final List<StoreV2> storesV2;

    /* JADX WARN: Multi-variable type inference failed */
    public StoreV2DispatchHandler(List<? extends StoreV2> list, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(list, "storesV2");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.storesV2 = list;
        this.observationDeck = observationDeck;
    }

    @Override // com.discord.stores.Store2
    @Store3
    public void onDispatchEnded() {
        HashSet hashSet = new HashSet();
        for (StoreV2 storeV2 : this.storesV2) {
            Set<ObservationDeck.UpdateSource> updateSources = storeV2.getUpdateSources();
            if (!updateSources.isEmpty()) {
                hashSet.addAll(updateSources);
                storeV2.snapshotData();
                storeV2.onDispatchEnded();
            }
        }
        if (!hashSet.isEmpty()) {
            this.observationDeck.notify(hashSet);
        }
    }

    public /* synthetic */ StoreV2DispatchHandler(List list, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? ObservationDeck4.get() : observationDeck);
    }
}
