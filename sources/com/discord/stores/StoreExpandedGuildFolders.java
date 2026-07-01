package com.discord.stores;

import android.content.Context;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.persister.Persister;
import d0.t.n0;
import d0.z.d.m;
import java.util.HashSet;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: StoreExpandedGuildFolders.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreExpandedGuildFolders extends StoreV2 {
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private final Set<Long> openFolderIds;
    private final Persister<Set<Long>> openFolderIdsCache;
    private Set<Long> openFolderIdsSnapshot;

    public /* synthetic */ StoreExpandedGuildFolders(Dispatcher dispatcher, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    public final void closeFolder(long folderId) {
        this.dispatcher.schedule(new StoreExpandedGuildFolders$closeFolder$1(this, folderId));
    }

    public final Set<Long> getOpenFolderIds() {
        return this.openFolderIdsSnapshot;
    }

    @StoreThread
    public final void handleFolderClosed(long folderId) {
        this.openFolderIds.remove(Long.valueOf(folderId));
        markChanged();
    }

    @StoreThread
    public final void handleFolderOpened(long folderId) {
        this.openFolderIds.add(Long.valueOf(folderId));
        markChanged();
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        m.checkNotNullParameter(context, "context");
        this.openFolderIds.addAll(this.openFolderIdsCache.get());
        markChanged();
    }

    public final Observable<Set<Long>> observeOpenFolderIds() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreExpandedGuildFolders$observeOpenFolderIds$1(this), 14, null);
    }

    public final void openFolder(long folderId) {
        this.dispatcher.schedule(new StoreExpandedGuildFolders$openFolder$1(this, folderId));
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        super.snapshotData();
        HashSet hashSet = new HashSet(this.openFolderIds);
        this.openFolderIdsSnapshot = hashSet;
        Persister.set$default(this.openFolderIdsCache, hashSet, false, 2, null);
    }

    public StoreExpandedGuildFolders(Dispatcher dispatcher, ObservationDeck observationDeck) {
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.openFolderIdsSnapshot = n0.emptySet();
        this.openFolderIds = new HashSet();
        this.openFolderIdsCache = new Persister<>("CACHE_KEY_OPEN_FOLDERS", new HashSet());
    }
}
