package com.discord.stores;

import android.content.Context;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.persister.Persister;
import java.util.HashSet;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p580t.C12148n0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;

/* JADX INFO: compiled from: StoreExpandedGuildFolders.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreExpandedGuildFolders extends StoreV2 {
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private final Set<Long> openFolderIds;
    private final Persister<Set<Long>> openFolderIdsCache;
    private Set<Long> openFolderIdsSnapshot;

    /* JADX INFO: renamed from: com.discord.stores.StoreExpandedGuildFolders$closeFolder$1 */
    /* JADX INFO: compiled from: StoreExpandedGuildFolders.kt */
    public static final class C59121 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ long $folderId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C59121(long j) {
            super(0);
            this.$folderId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreExpandedGuildFolders.this.handleFolderClosed(this.$folderId);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreExpandedGuildFolders$observeOpenFolderIds$1 */
    /* JADX INFO: compiled from: StoreExpandedGuildFolders.kt */
    public static final class C59131 extends AbstractC12240o implements Function0<Set<? extends Long>> {
        public C59131() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Set<? extends Long> invoke() {
            return StoreExpandedGuildFolders.this.getOpenFolderIds();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreExpandedGuildFolders$openFolder$1 */
    /* JADX INFO: compiled from: StoreExpandedGuildFolders.kt */
    public static final class C59141 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ long $folderId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C59141(long j) {
            super(0);
            this.$folderId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreExpandedGuildFolders.this.handleFolderOpened(this.$folderId);
        }
    }

    public /* synthetic */ StoreExpandedGuildFolders(Dispatcher dispatcher, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    public final void closeFolder(long folderId) {
        this.dispatcher.schedule(new C59121(folderId));
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
        C12238m.checkNotNullParameter(context, "context");
        this.openFolderIds.addAll(this.openFolderIdsCache.get());
        markChanged();
    }

    public final Observable<Set<Long>> observeOpenFolderIds() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C59131(), 14, null);
    }

    public final void openFolder(long folderId) {
        this.dispatcher.schedule(new C59141(folderId));
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
        C12238m.checkNotNullParameter(dispatcher, "dispatcher");
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.openFolderIdsSnapshot = C12148n0.emptySet();
        this.openFolderIds = new HashSet();
        this.openFolderIdsCache = new Persister<>("CACHE_KEY_OPEN_FOLDERS", new HashSet());
    }
}
