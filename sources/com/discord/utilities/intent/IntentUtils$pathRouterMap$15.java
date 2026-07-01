package com.discord.utilities.intent;

import android.content.Context;
import android.net.Uri;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function3;
import kotlin.text.MatchResult;

/* JADX INFO: compiled from: IntentUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class IntentUtils$pathRouterMap$15 extends k implements Function3<Uri, MatchResult, Context, RouteHandlers$AnalyticsMetadata> {
    public IntentUtils$pathRouterMap$15(RouteHandlers routeHandlers) {
        super(3, routeHandlers, RouteHandlers.class, "wildCardMatcher", "wildCardMatcher(Landroid/net/Uri;Lkotlin/text/MatchResult;Landroid/content/Context;)Lcom/discord/utilities/intent/RouteHandlers$AnalyticsMetadata;", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ RouteHandlers$AnalyticsMetadata invoke(Uri uri, MatchResult matchResult, Context context) {
        return invoke2(uri, matchResult, context);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final RouteHandlers$AnalyticsMetadata invoke2(Uri uri, MatchResult matchResult, Context context) {
        m.checkNotNullParameter(uri, "p1");
        m.checkNotNullParameter(context, "p3");
        return ((RouteHandlers) this.receiver).wildCardMatcher(uri, matchResult, context);
    }
}
