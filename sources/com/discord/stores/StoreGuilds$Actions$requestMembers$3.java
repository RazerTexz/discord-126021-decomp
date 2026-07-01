package com.discord.stores;

import androidx.core.app.NotificationCompat;
import j0.k.b;
import rx.Observable;

/* JADX INFO: compiled from: StoreGuilds.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuilds$Actions$requestMembers$3<T, R> implements b<String, Observable<? extends Long>> {
    public static final StoreGuilds$Actions$requestMembers$3 INSTANCE = new StoreGuilds$Actions$requestMembers$3();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends Long> call(String str) {
        return call2(str);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Long> call2(String str) {
        return StoreStream.Companion.getGuildSelected().observeSelectedGuildId().u(new StoreGuilds$Actions$requestMembers$3$1(str));
    }
}
