package com.discord.app;

import android.content.Context;
import android.content.Intent;
import android.os.Build$VERSION;
import com.discord.utilities.intent.IntentUtils$RouteBuilders;
import com.discord.utilities.logging.Logger;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: DiscordConnectService.kt */
/* JADX INFO: loaded from: classes.dex */
public final class DiscordConnectService$a {
    public DiscordConnectService$a(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public static final void a(DiscordConnectService$a discordConnectService$a, String str) {
        AppLog appLog = AppLog.g;
        String simpleName = DiscordConnectService.class.getSimpleName();
        m.checkNotNullExpressionValue(simpleName, "DiscordConnectService::class.java.simpleName");
        Logger.i$default(appLog, simpleName, str, null, 4, null);
    }

    public final void b(Context context, long j) {
        m.checkNotNullParameter(context, "context");
        Intent intent = IntentUtils$RouteBuilders.INSTANCE.connectVoice(j).setPackage(context.getPackageName());
        m.checkNotNullExpressionValue(intent, "IntentUtils.RouteBuilder…kage(context.packageName)");
        if (Build$VERSION.SDK_INT >= 26) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
    }
}
