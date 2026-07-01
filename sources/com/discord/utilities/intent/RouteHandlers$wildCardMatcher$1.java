package com.discord.utilities.intent;

import d0.z.d.o;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KFunction;

/* JADX INFO: compiled from: RouteHandlers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RouteHandlers$wildCardMatcher$1 extends o implements Function1<String, KFunction<? extends RouteHandlers$AnalyticsMetadata>> {
    public static final RouteHandlers$wildCardMatcher$1 INSTANCE = new RouteHandlers$wildCardMatcher$1();

    public RouteHandlers$wildCardMatcher$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ KFunction<? extends RouteHandlers$AnalyticsMetadata> invoke(String str) {
        return invoke2(str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x001a, code lost:
    
        if (r2.equals("discord.gg") != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0023, code lost:
    
        if (r2.equals("gift") != false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0033, code lost:
    
        if (r2.equals("discord.new") != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003c, code lost:
    
        if (r2.equals("invite") != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004d, code lost:
    
        if (r2.equals("template") != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:?, code lost:
    
        return new com.discord.utilities.intent.RouteHandlers$wildCardMatcher$1$1(com.discord.utilities.intent.RouteHandlers.INSTANCE);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:?, code lost:
    
        return new com.discord.utilities.intent.RouteHandlers$wildCardMatcher$1$2(com.discord.utilities.intent.RouteHandlers.INSTANCE);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:?, code lost:
    
        return new com.discord.utilities.intent.RouteHandlers$wildCardMatcher$1$3(com.discord.utilities.intent.RouteHandlers.INSTANCE);
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0011, code lost:
    
        if (r2.equals("discord.gift") != false) goto L15;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final KFunction<RouteHandlers$AnalyticsMetadata> invoke2(String str) {
        if (str != null) {
            switch (str.hashCode()) {
                case -1321546630:
                    break;
                case -1183699191:
                    break;
                case -633644578:
                    break;
                case 3172656:
                    break;
                case 533748962:
                    break;
                case 1831649458:
                    break;
            }
        }
        return null;
    }
}
