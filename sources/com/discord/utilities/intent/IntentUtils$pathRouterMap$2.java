package com.discord.utilities.intent;

import android.content.Context;
import android.net.Uri;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function3;
import kotlin.text.MatchResult;

/* JADX INFO: compiled from: IntentUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class IntentUtils$pathRouterMap$2 extends o implements Function3<Uri, MatchResult, Context, RouteHandlers$AnalyticsMetadata> {
    public static final IntentUtils$pathRouterMap$2 INSTANCE = new IntentUtils$pathRouterMap$2();

    public IntentUtils$pathRouterMap$2() {
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ RouteHandlers$AnalyticsMetadata invoke(Uri uri, MatchResult matchResult, Context context) {
        return invoke2(uri, matchResult, context);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final RouteHandlers$AnalyticsMetadata invoke2(Uri uri, MatchResult matchResult, Context context) {
        m.checkNotNullParameter(uri, NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
        m.checkNotNullParameter(context, "context");
        return RouteHandlers.INSTANCE.selectStaticChannel(context, uri, matchResult);
    }
}
