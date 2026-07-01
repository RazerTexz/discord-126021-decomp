package com.discord.utilities.persister;

import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import rx.functions.Func2;

/* JADX INFO: compiled from: PersisterConfig.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PersisterConfig$isNotActive$1<T1, T2, R> implements Func2<Boolean, Boolean, Boolean> {
    public static final PersisterConfig$isNotActive$1 INSTANCE = new PersisterConfig$isNotActive$1();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ Boolean call(Boolean bool, Boolean bool2) {
        return call2(bool, bool2);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(Boolean bool, Boolean bool2) {
        m.checkNotNullExpressionValue(bool, "isBackgrounded");
        return Boolean.valueOf(bool.booleanValue() && !bool2.booleanValue());
    }
}
