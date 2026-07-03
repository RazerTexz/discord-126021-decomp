package com.discord.utilities.intent;

import android.content.Context;
import android.net.Uri;
import com.discord.utilities.intent.RouteHandlers;
import kotlin.jvm.functions.Function3;
import kotlin.text.MatchResult;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: IntentUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class IntentUtils$pathRouterMap$10 extends C12236k implements Function3<Uri, MatchResult, Context, RouteHandlers.AnalyticsMetadata> {
    public IntentUtils$pathRouterMap$10(RouteHandlers routeHandlers) {
        super(3, routeHandlers, RouteHandlers.class, "selectLurk", "selectLurk(Landroid/net/Uri;Lkotlin/text/MatchResult;Landroid/content/Context;)Lcom/discord/utilities/intent/RouteHandlers$AnalyticsMetadata;", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public final RouteHandlers.AnalyticsMetadata invoke(Uri uri, MatchResult matchResult, Context context) {
        C12238m.checkNotNullParameter(uri, "p1");
        C12238m.checkNotNullParameter(context, "p3");
        return ((RouteHandlers) this.receiver).selectLurk(uri, matchResult, context);
    }
}
