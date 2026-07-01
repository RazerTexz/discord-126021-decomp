package com.discord.utilities.intent;

import android.content.Context;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import com.discord.utilities.intent.RouteHandlers;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function3;
import kotlin.text.MatchResult;

/* JADX INFO: compiled from: IntentUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class IntentUtils$pathRouterMap$2 extends Lambda implements Function3<Uri, MatchResult, Context, RouteHandlers.AnalyticsMetadata> {
    public static final IntentUtils$pathRouterMap$2 INSTANCE = new IntentUtils$pathRouterMap$2();

    public IntentUtils$pathRouterMap$2() {
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public final RouteHandlers.AnalyticsMetadata invoke(Uri uri, MatchResult matchResult, Context context) {
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(context, "context");
        return RouteHandlers.INSTANCE.selectStaticChannel(context, uri, matchResult);
    }
}
