package com.discord.utilities;

import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ShareUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ShareUtils$updateDirectShareTargets$1$uris$1 extends AbstractC12240o implements Function1<Pair<? extends ChannelShortcutInfo, ? extends String>, String> {
    public static final ShareUtils$updateDirectShareTargets$1$uris$1 INSTANCE = new ShareUtils$updateDirectShareTargets$1$uris$1();

    public ShareUtils$updateDirectShareTargets$1$uris$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(Pair<? extends ChannelShortcutInfo, ? extends String> pair) {
        return invoke2((Pair<ChannelShortcutInfo, String>) pair);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(Pair<ChannelShortcutInfo, String> pair) {
        C12238m.checkNotNullParameter(pair, "<name for destructuring parameter 0>");
        return pair.component2();
    }
}
