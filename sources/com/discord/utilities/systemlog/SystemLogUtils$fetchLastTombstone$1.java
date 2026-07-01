package com.discord.utilities.systemlog;

import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import j0.k.b;
import j0.l.a.c;
import j0.l.e.k;
import java.util.LinkedList;
import rx.Observable;

/* JADX INFO: compiled from: SystemLogUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SystemLogUtils$fetchLastTombstone$1<T, R> implements b<LinkedList<String>, Observable<? extends SystemLogUtils$Tombstone>> {
    public static final SystemLogUtils$fetchLastTombstone$1 INSTANCE = new SystemLogUtils$fetchLastTombstone$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends SystemLogUtils$Tombstone> call(LinkedList<String> linkedList) {
        return call2(linkedList);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends SystemLogUtils$Tombstone> call2(LinkedList<String> linkedList) {
        SystemLogUtils systemLogUtils = SystemLogUtils.INSTANCE;
        m.checkNotNullExpressionValue(linkedList, "crashes");
        SystemLogUtils$Tombstone systemLogUtils$TombstoneFetchLastTombstone$app_productionGoogleRelease = systemLogUtils.fetchLastTombstone$app_productionGoogleRelease(linkedList);
        return systemLogUtils$TombstoneFetchLastTombstone$app_productionGoogleRelease == null ? c.k : new k(systemLogUtils$TombstoneFetchLastTombstone$app_productionGoogleRelease);
    }
}
