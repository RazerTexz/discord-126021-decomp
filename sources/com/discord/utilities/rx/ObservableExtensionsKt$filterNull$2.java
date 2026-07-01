package com.discord.utilities.rx;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import d0.z.d.m;
import j0.k.b;

/* JADX INFO: compiled from: ObservableExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ObservableExtensionsKt$filterNull$2<T, R> implements b<T, T> {
    public static final ObservableExtensionsKt$filterNull$2 INSTANCE = new ObservableExtensionsKt$filterNull$2();

    @Override // j0.k.b
    public final T call(T t) {
        m.checkNotNull(t);
        return t;
    }
}
