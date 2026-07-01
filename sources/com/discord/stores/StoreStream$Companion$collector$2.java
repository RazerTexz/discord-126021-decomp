package com.discord.stores;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreStream$Companion$collector$2 extends Lambda implements Function0<StoreStream> {
    public static final StoreStream$Companion$collector$2 INSTANCE = new StoreStream$Companion$collector$2();

    public StoreStream$Companion$collector$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final StoreStream invoke() {
        return new StoreStream();
    }
}
