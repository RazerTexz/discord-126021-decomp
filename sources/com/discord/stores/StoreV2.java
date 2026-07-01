package com.discord.stores;

import androidx.exifinterface.media.ExifInterface;
import com.discord.app.AppLog;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.logging.Logger;
import d0.t.MutableCollections;
import d0.z.d.Intrinsics3;
import java.util.HashSet;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: StoreV2.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class StoreV2 extends Store implements Store2, ObservationDeck.UpdateSource {
    private final Set<ObservationDeck.UpdateSource> updateSources = new HashSet();

    /* JADX INFO: compiled from: StoreV2.kt */
    public static final class MarkChangedDelegate<T> {
        private final ObservationDeck.UpdateSource overrideUpdateSource;
        private T value;

        public MarkChangedDelegate(T t, ObservationDeck.UpdateSource updateSource) {
            this.value = t;
            this.overrideUpdateSource = updateSource;
        }

        public final T getValue(StoreV2 thisRef, KProperty<?> property) {
            Intrinsics3.checkNotNullParameter(property, "property");
            return this.value;
        }

        public final void setValue(StoreV2 thisRef, KProperty<?> property, T value) {
            Intrinsics3.checkNotNullParameter(property, "property");
            if (!Intrinsics3.areEqual(this.value, value)) {
                this.value = value;
                ObservationDeck.UpdateSource updateSource = this.overrideUpdateSource;
                if (updateSource != null) {
                    if (thisRef != null) {
                        thisRef.markChanged(updateSource);
                    }
                } else if (thisRef != null) {
                    thisRef.markChanged();
                }
            }
        }

        public /* synthetic */ MarkChangedDelegate(Object obj, ObservationDeck.UpdateSource updateSource, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(obj, (i & 2) != 0 ? null : updateSource);
        }
    }

    private final void assertStoreThread() {
        Thread threadCurrentThread = Thread.currentThread();
        Intrinsics3.checkNotNullExpressionValue(threadCurrentThread, "Thread.currentThread()");
        if (threadCurrentThread.getId() != StoreStream.INSTANCE.getSTORE_THREAD_ID()) {
            Logger.e$default(AppLog.g, "markChanged() should be run from the Store Dispatcher", new IllegalStateException("Dispatch not run on store thread"), null, 4, null);
        }
    }

    public final Set<ObservationDeck.UpdateSource> getUpdateSources() {
        return this.updateSources;
    }

    public final void markChanged() {
        assertStoreThread();
        this.updateSources.add(this);
    }

    public final void markUnchanged(ObservationDeck.UpdateSource updateSource) {
        Intrinsics3.checkNotNullParameter(updateSource, "updateSource");
        assertStoreThread();
        this.updateSources.remove(updateSource);
    }

    @Override // com.discord.stores.Store2
    public void onDispatchEnded() {
        this.updateSources.clear();
    }

    public void snapshotData() {
    }

    public final void markChanged(ObservationDeck.UpdateSource... updates) {
        Intrinsics3.checkNotNullParameter(updates, "updates");
        assertStoreThread();
        markChanged();
        MutableCollections.addAll(this.updateSources, updates);
    }
}
