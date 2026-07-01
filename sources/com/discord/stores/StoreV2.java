package com.discord.stores;

import com.discord.app.AppLog;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.utilities.logging.Logger;
import d0.t.r;
import d0.z.d.m;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: StoreV2.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class StoreV2 extends Store implements DispatchHandler, ObservationDeck$UpdateSource {
    private final Set<ObservationDeck$UpdateSource> updateSources = new HashSet();

    private final void assertStoreThread() {
        Thread threadCurrentThread = Thread.currentThread();
        m.checkNotNullExpressionValue(threadCurrentThread, "Thread.currentThread()");
        if (threadCurrentThread.getId() != StoreStream.Companion.getSTORE_THREAD_ID()) {
            Logger.e$default(AppLog.g, "markChanged() should be run from the Store Dispatcher", new IllegalStateException("Dispatch not run on store thread"), null, 4, null);
        }
    }

    public final Set<ObservationDeck$UpdateSource> getUpdateSources() {
        return this.updateSources;
    }

    public final void markChanged() {
        assertStoreThread();
        this.updateSources.add(this);
    }

    public final void markUnchanged(ObservationDeck$UpdateSource updateSource) {
        m.checkNotNullParameter(updateSource, "updateSource");
        assertStoreThread();
        this.updateSources.remove(updateSource);
    }

    @Override // com.discord.stores.DispatchHandler
    public void onDispatchEnded() {
        this.updateSources.clear();
    }

    public void snapshotData() {
    }

    public final void markChanged(ObservationDeck$UpdateSource... updates) {
        m.checkNotNullParameter(updates, "updates");
        assertStoreThread();
        markChanged();
        r.addAll(this.updateSources, updates);
    }
}
