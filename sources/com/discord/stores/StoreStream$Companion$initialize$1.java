package com.discord.stores;

import com.discord.models.authentication.AuthState;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreStream$Companion$initialize$1 extends o implements Function0<String> {
    public static final StoreStream$Companion$initialize$1 INSTANCE = new StoreStream$Companion$initialize$1();

    public StoreStream$Companion$initialize$1() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2() {
        AuthState authState = StoreStream$Companion.access$getCollector$p(StoreStream.Companion).getAuthentication().getAuthState();
        if (authState != null) {
            return authState.getToken();
        }
        return null;
    }
}
