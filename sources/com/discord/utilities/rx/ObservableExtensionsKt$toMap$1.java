package com.discord.utilities.rx;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import j0.k.b;
import kotlin.Pair;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: compiled from: ObservableExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ObservableExtensionsKt$toMap$1<T, R, K, V> implements b<Pair<? extends K, ? extends V>, K> {
    public static final ObservableExtensionsKt$toMap$1 INSTANCE = new ObservableExtensionsKt$toMap$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Pair) obj);
    }

    public final K call(Pair<? extends K, ? extends V> pair) {
        return pair.getFirst();
    }
}
