package com.discord.utilities.intent;

import d0.g;
import kotlin.Lazy;

/* JADX INFO: compiled from: StaticChannelRoutes.kt */
/* JADX INFO: loaded from: classes2.dex */
public enum StaticChannelRoutes {
    ROLE_SUBSCRIPTIONS("role-subscriptions");

    private final String route;
    public static final StaticChannelRoutes$Companion Companion = new StaticChannelRoutes$Companion(null);
    private static final Lazy routeToName$delegate = g.lazy(StaticChannelRoutes$Companion$routeToName$2.INSTANCE);

    StaticChannelRoutes(String str) {
        this.route = str;
    }

    public static final /* synthetic */ Lazy access$getRouteToName$cp() {
        return routeToName$delegate;
    }

    public final String getRoute() {
        return this.route;
    }
}
