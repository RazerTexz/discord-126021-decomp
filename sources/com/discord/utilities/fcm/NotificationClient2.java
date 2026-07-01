package com.discord.utilities.fcm;

import com.discord.app.AppLog;
import com.discord.utilities.logging.Logger;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.utilities.fcm.NotificationClient$tokenCallback$1, reason: use source file name */
/* JADX INFO: compiled from: NotificationClient.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NotificationClient2 extends Lambda implements Function1<String, Unit> {
    public static final NotificationClient2 INSTANCE = new NotificationClient2();

    public NotificationClient2() {
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
        Intrinsics3.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
        Logger.w$default(appLog, simpleName, "FCM token was not sent to server", null, 4, null);
    }
}
