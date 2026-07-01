package com.discord.stores;

import androidx.exifinterface.media.ExifInterface;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: StoreV2.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreV2$MarkChangedDelegate<T> {
    private final ObservationDeck$UpdateSource overrideUpdateSource;
    private T value;

    public StoreV2$MarkChangedDelegate(T t, ObservationDeck$UpdateSource observationDeck$UpdateSource) {
        this.value = t;
        this.overrideUpdateSource = observationDeck$UpdateSource;
    }

    public final T getValue(StoreV2 thisRef, KProperty<?> property) {
        m.checkNotNullParameter(property, "property");
        return this.value;
    }

    public final void setValue(StoreV2 thisRef, KProperty<?> property, T value) {
        m.checkNotNullParameter(property, "property");
        if (!m.areEqual(this.value, value)) {
            this.value = value;
            ObservationDeck$UpdateSource observationDeck$UpdateSource = this.overrideUpdateSource;
            if (observationDeck$UpdateSource != null) {
                if (thisRef != null) {
                    thisRef.markChanged(observationDeck$UpdateSource);
                }
            } else if (thisRef != null) {
                thisRef.markChanged();
            }
        }
    }

    public /* synthetic */ StoreV2$MarkChangedDelegate(Object obj, ObservationDeck$UpdateSource observationDeck$UpdateSource, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, (i & 2) != 0 ? null : observationDeck$UpdateSource);
    }
}
