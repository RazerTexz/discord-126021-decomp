package com.discord.stores;

import d0.z.d.k;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: StoreAuthentication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreAuthentication$register$1$1 extends k implements Function2<StoreInviteSettings$InviteCode, String, StoreAuthentication$AuthRequestParams> {
    public static final StoreAuthentication$register$1$1 INSTANCE = new StoreAuthentication$register$1$1();

    public StoreAuthentication$register$1$1() {
        super(2, StoreAuthentication$AuthRequestParams.class, "<init>", "<init>(Lcom/discord/stores/StoreInviteSettings$InviteCode;Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ StoreAuthentication$AuthRequestParams invoke(StoreInviteSettings$InviteCode storeInviteSettings$InviteCode, String str) {
        return invoke2(storeInviteSettings$InviteCode, str);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final StoreAuthentication$AuthRequestParams invoke2(StoreInviteSettings$InviteCode storeInviteSettings$InviteCode, String str) {
        return new StoreAuthentication$AuthRequestParams(storeInviteSettings$InviteCode, str);
    }
}
