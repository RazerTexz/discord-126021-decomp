package com.discord.stores;

import d0.z.d.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreNotifications.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreNotifications$configureNotificationClient$1 extends k implements Function1<String, Unit> {
    public StoreNotifications$configureNotificationClient$1(StoreNotifications storeNotifications) {
        super(1, storeNotifications, StoreNotifications.class, "handleRegistrationToken", "handleRegistrationToken(Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        StoreNotifications.access$handleRegistrationToken((StoreNotifications) this.receiver, str);
    }
}
