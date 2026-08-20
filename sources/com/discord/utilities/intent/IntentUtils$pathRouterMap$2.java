package com.discord.utilities.intent;

import android.content.Context;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import kotlin.jvm.functions.Function3;
import kotlin.text.MatchResult;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: IntentUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class IntentUtils$pathRouterMap$2 extends AbstractC12240o implements Function3<Uri, MatchResult, Context, RouteHandlers.AnalyticsMetadata> {
    public static final IntentUtils$pathRouterMap$2 INSTANCE = new IntentUtils$pathRouterMap$2();

    public IntentUtils$pathRouterMap$2() {
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public final RouteHandlers.AnalyticsMetadata invoke(Uri uri, MatchResult matchResult, Context context) {
        C12238m.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        C12238m.checkNotNullParameter(context, "context");
        return RouteHandlers.INSTANCE.selectStaticChannel(context, uri, matchResult);
    }
}
