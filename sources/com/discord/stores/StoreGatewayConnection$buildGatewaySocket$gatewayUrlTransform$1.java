package com.discord.stores;

import com.discord.widgets.chat.input.MentionUtilsKt;
import kotlin.jvm.functions.Function1;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p579g0.C12106w;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: StoreGatewayConnection.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGatewayConnection$buildGatewaySocket$gatewayUrlTransform$1 extends AbstractC12240o implements Function1<String, String> {
    public static final StoreGatewayConnection$buildGatewaySocket$gatewayUrlTransform$1 INSTANCE = new StoreGatewayConnection$buildGatewaySocket$gatewayUrlTransform$1();

    public StoreGatewayConnection$buildGatewaySocket$gatewayUrlTransform$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final String invoke(String str) {
        C12238m.checkNotNullParameter(str, "gatewayUrl");
        return C1643a.m883w("ws://:", C12106w.substringAfterLast$default(str, MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR, null, 2, null));
    }
}
