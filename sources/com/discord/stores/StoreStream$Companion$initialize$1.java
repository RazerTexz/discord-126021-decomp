package com.discord.stores;

import com.discord.models.authentication.AuthState;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreStream$Companion$initialize$1 extends Lambda implements Function0<String> {
    public static final StoreStream$Companion$initialize$1 INSTANCE = new StoreStream$Companion$initialize$1();

    public StoreStream$Companion$initialize$1() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        AuthState authState = StoreStream.INSTANCE.getCollector().getAuthentication().getAuthState();
        if (authState != null) {
            return authState.getToken();
        }
        return null;
    }
}
