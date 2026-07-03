package com.discord.stores;

import com.discord.models.authentication.AuthState;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreStream$Companion$initialize$1 extends AbstractC12240o implements Function0<String> {
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
