package com.discord.stores;

import b.d.b.a.a;
import com.discord.widgets.chat.input.MentionUtilsKt;
import d0.g0.w;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreGatewayConnection.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGatewayConnection$buildGatewaySocket$gatewayUrlTransform$1 extends o implements Function1<String, String> {
    public static final StoreGatewayConnection$buildGatewaySocket$gatewayUrlTransform$1 INSTANCE = new StoreGatewayConnection$buildGatewaySocket$gatewayUrlTransform$1();

    public StoreGatewayConnection$buildGatewaySocket$gatewayUrlTransform$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(String str) {
        return invoke2(str);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(String str) {
        m.checkNotNullParameter(str, "gatewayUrl");
        return a.w("ws://:", w.substringAfterLast$default(str, MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR, null, 2, null));
    }
}
