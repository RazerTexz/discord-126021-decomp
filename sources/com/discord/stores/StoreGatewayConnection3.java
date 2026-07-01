package com.discord.stores;

import b.d.b.a.outline;
import com.discord.widgets.chat.input.MentionUtils;
import d0.g0.Strings4;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.stores.StoreGatewayConnection$buildGatewaySocket$gatewayUrlTransform$1, reason: use source file name */
/* JADX INFO: compiled from: StoreGatewayConnection.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGatewayConnection3 extends Lambda implements Function1<String, String> {
    public static final StoreGatewayConnection3 INSTANCE = new StoreGatewayConnection3();

    public StoreGatewayConnection3() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final String invoke(String str) {
        Intrinsics3.checkNotNullParameter(str, "gatewayUrl");
        return outline.w("ws://:", Strings4.substringAfterLast$default(str, MentionUtils.EMOJIS_AND_STICKERS_CHAR, null, 2, null));
    }
}
