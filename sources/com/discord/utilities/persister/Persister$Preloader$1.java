package com.discord.utilities.persister;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import j0.k.b;

/* JADX INFO: compiled from: Persister.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Persister$Preloader$1<T, R> implements b<Persister<?>, Boolean> {
    public static final Persister$Preloader$1 INSTANCE = new Persister$Preloader$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Boolean call(Persister<?> persister) {
        return call2(persister);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(Persister<?> persister) {
        return Boolean.valueOf(persister == null);
    }
}
