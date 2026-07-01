package com.discord.utilities.rx;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import j0.k.b;

/* JADX INFO: compiled from: ObservableExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ObservableExtensionsKt$filterNull$1<T, R> implements b<T, Boolean> {
    public static final ObservableExtensionsKt$filterNull$1 INSTANCE = new ObservableExtensionsKt$filterNull$1();

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // j0.k.b
    public final Boolean call(T t) {
        return Boolean.valueOf(t != null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Boolean call(Object obj) {
        return call(obj);
    }
}
