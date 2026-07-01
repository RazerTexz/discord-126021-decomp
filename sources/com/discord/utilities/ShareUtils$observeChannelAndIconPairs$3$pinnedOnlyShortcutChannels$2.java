package com.discord.utilities;

import androidx.core.content.pm.ShortcutInfoCompat;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ShareUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ShareUtils$observeChannelAndIconPairs$3$pinnedOnlyShortcutChannels$2 extends Lambda implements Function1<ShortcutInfoCompat, Long> {
    public static final ShareUtils$observeChannelAndIconPairs$3$pinnedOnlyShortcutChannels$2 INSTANCE = new ShareUtils$observeChannelAndIconPairs$3$pinnedOnlyShortcutChannels$2();

    public ShareUtils$observeChannelAndIconPairs$3$pinnedOnlyShortcutChannels$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Long invoke(ShortcutInfoCompat shortcutInfoCompat) {
        return Long.valueOf(invoke2(shortcutInfoCompat));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2(ShortcutInfoCompat shortcutInfoCompat) {
        Intrinsics3.checkNotNullExpressionValue(shortcutInfoCompat, "shortcutInfoCompat");
        String id2 = shortcutInfoCompat.getId();
        Intrinsics3.checkNotNullExpressionValue(id2, "shortcutInfoCompat.id");
        return Long.parseLong(id2);
    }
}
