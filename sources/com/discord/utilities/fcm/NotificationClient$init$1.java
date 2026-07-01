package com.discord.utilities.fcm;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: NotificationClient.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NotificationClient$init$1 extends o implements Function0<String> {
    public static final NotificationClient$init$1 INSTANCE = new NotificationClient$init$1();

    public NotificationClient$init$1() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2() {
        return NotificationClient.INSTANCE.getSettings$app_productionGoogleRelease().getToken();
    }
}
