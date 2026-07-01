package com.discord.utilities.rx;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import d0.z.d.m;
import j0.k.b;

/* JADX INFO: compiled from: ObservableExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ObservableExtensionsKt$filterIs$1<T, R> implements b<Object, Boolean> {
    public static final ObservableExtensionsKt$filterIs$1 INSTANCE = new ObservableExtensionsKt$filterIs$1();

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // j0.k.b
    public final Boolean call(Object obj) {
        m.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
        return Boolean.valueOf(obj instanceof Object);
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Boolean call(Object obj) {
        return call(obj);
    }
}
