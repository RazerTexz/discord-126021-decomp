package com.discord.utilities;

import androidx.core.content.pm.ShortcutInfoCompat;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ShareUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ShareUtils$observeChannelAndIconPairs$3$pinnedOnlyShortcutChannels$1 extends o implements Function1<ShortcutInfoCompat, Boolean> {
    public static final ShareUtils$observeChannelAndIconPairs$3$pinnedOnlyShortcutChannels$1 INSTANCE = new ShareUtils$observeChannelAndIconPairs$3$pinnedOnlyShortcutChannels$1();

    public ShareUtils$observeChannelAndIconPairs$3$pinnedOnlyShortcutChannels$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(ShortcutInfoCompat shortcutInfoCompat) {
        return Boolean.valueOf(invoke2(shortcutInfoCompat));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(ShortcutInfoCompat shortcutInfoCompat) {
        m.checkNotNullExpressionValue(shortcutInfoCompat, "it");
        return shortcutInfoCompat.isPinned();
    }
}
