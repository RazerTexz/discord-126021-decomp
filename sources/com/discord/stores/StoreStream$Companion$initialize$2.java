package com.discord.stores;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreStream$Companion$initialize$2 extends Lambda implements Function0<String> {
    public static final StoreStream$Companion$initialize$2 INSTANCE = new StoreStream$Companion$initialize$2();

    public StoreStream$Companion$initialize$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        return StoreStream.INSTANCE.getCollector().getAuthentication().getFingerprint();
    }
}
