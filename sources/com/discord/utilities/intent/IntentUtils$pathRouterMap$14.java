package com.discord.utilities.intent;

import android.content.Context;
import android.net.Uri;
import com.discord.utilities.intent.RouteHandlers;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function3;
import kotlin.text.MatchResult;

/* JADX INFO: compiled from: IntentUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class IntentUtils$pathRouterMap$14 extends FunctionReferenceImpl implements Function3<Uri, MatchResult, Context, RouteHandlers.AnalyticsMetadata> {
    public IntentUtils$pathRouterMap$14(RouteHandlers routeHandlers) {
        super(3, routeHandlers, RouteHandlers.class, "handleQuery", "handleQuery(Landroid/net/Uri;Lkotlin/text/MatchResult;Landroid/content/Context;)Lcom/discord/utilities/intent/RouteHandlers$AnalyticsMetadata;", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public final RouteHandlers.AnalyticsMetadata invoke(Uri uri, MatchResult matchResult, Context context) {
        Intrinsics3.checkNotNullParameter(uri, "p1");
        Intrinsics3.checkNotNullParameter(context, "p3");
        return ((RouteHandlers) this.receiver).handleQuery(uri, matchResult, context);
    }
}
