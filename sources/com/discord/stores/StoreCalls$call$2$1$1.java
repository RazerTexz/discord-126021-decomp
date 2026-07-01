package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelCall$Ringable;
import d0.z.d.m;
import j0.k.b;

/* JADX INFO: compiled from: StoreCalls.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreCalls$call$2$1$1<T, R> implements b<ModelCall$Ringable, Boolean> {
    public static final StoreCalls$call$2$1$1 INSTANCE = new StoreCalls$call$2$1$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Boolean call(ModelCall$Ringable modelCall$Ringable) {
        return call2(modelCall$Ringable);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(ModelCall$Ringable modelCall$Ringable) {
        m.checkNotNullExpressionValue(modelCall$Ringable, "it");
        return Boolean.valueOf(modelCall$Ringable.isRingable());
    }
}
