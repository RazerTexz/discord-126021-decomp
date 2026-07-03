package com.discord.utilities;

import androidx.core.content.p004pm.ShortcutInfoCompat;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.utilities.ShareUtils$observeChannelAndIconPairs$3$pinnedOnlyShortcutChannels$2 */
/* JADX INFO: compiled from: ShareUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C6654x626dc25b extends AbstractC12240o implements Function1<ShortcutInfoCompat, Long> {
    public static final C6654x626dc25b INSTANCE = new C6654x626dc25b();

    public C6654x626dc25b() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Long invoke(ShortcutInfoCompat shortcutInfoCompat) {
        return Long.valueOf(invoke2(shortcutInfoCompat));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2(ShortcutInfoCompat shortcutInfoCompat) {
        C12238m.checkNotNullExpressionValue(shortcutInfoCompat, "shortcutInfoCompat");
        String id2 = shortcutInfoCompat.getId();
        C12238m.checkNotNullExpressionValue(id2, "shortcutInfoCompat.id");
        return Long.parseLong(id2);
    }
}
