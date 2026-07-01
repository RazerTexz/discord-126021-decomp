package com.discord.utilities.fcm;

import com.discord.app.AppLog;
import com.discord.utilities.logging.Logger;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: NotificationClient.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NotificationClient$tokenCallback$1 extends o implements Function1<String, Unit> {
    public static final NotificationClient$tokenCallback$1 INSTANCE = new NotificationClient$tokenCallback$1();

    public NotificationClient$tokenCallback$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        AppLog appLog = AppLog.g;
        String simpleName = NotificationClient.INSTANCE.getClass().getSimpleName();
        m.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
        Logger.w$default(appLog, simpleName, "FCM token was not sent to server", null, 4, null);
    }
}
