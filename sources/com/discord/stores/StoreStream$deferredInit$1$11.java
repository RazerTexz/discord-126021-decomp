package com.discord.stores;

import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import rx.functions.Func4;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreStream$deferredInit$1$11<T1, T2, T3, T4, R> implements Func4<Boolean, Boolean, Boolean, Boolean, Boolean> {
    public static final StoreStream$deferredInit$1$11 INSTANCE = new StoreStream$deferredInit$1$11();

    @Override // rx.functions.Func4
    public /* bridge */ /* synthetic */ Boolean call(Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4) {
        return call2(bool, bool2, bool3, bool4);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0029  */
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4) {
        boolean z2;
        m.checkNotNullExpressionValue(bool, "experimentsInitialized");
        if (bool.booleanValue()) {
            m.checkNotNullExpressionValue(bool4, "cachesInitialized");
            if (bool4.booleanValue()) {
                if (bool2.booleanValue()) {
                    m.checkNotNullExpressionValue(bool3, "channelsSelectedInitialized");
                    if (!bool3.booleanValue()) {
                        z2 = false;
                    }
                }
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            z2 = false;
        }
        return Boolean.valueOf(z2);
    }
}
