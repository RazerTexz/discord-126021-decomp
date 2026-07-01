package com.discord.stores.updates;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import j0.k.b;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ObservationDeck.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ObservationDeck$connectRx$3<T, R> implements b<Unit, T> {
    public final /* synthetic */ Function0 $generator;

    public ObservationDeck$connectRx$3(Function0 function0) {
        this.$generator = function0;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Object call(Unit unit) {
        return call2(unit);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final T call2(Unit unit) {
        return (T) this.$generator.invoke();
    }
}
