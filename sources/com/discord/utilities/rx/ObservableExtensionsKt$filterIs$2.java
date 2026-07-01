package com.discord.utilities.rx;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import d0.z.d.m;
import j0.k.b;

/* JADX INFO: compiled from: ObservableExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ObservableExtensionsKt$filterIs$2<T, R> implements b<Object, T> {
    public static final ObservableExtensionsKt$filterIs$2 INSTANCE = new ObservableExtensionsKt$filterIs$2();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // j0.k.b
    public final T call(Object obj) {
        m.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
        return obj;
    }
}
