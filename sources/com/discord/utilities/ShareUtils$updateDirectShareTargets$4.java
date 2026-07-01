package com.discord.utilities;

import android.content.Context;
import androidx.core.content.pm.ShortcutInfoCompat;
import androidx.core.content.pm.ShortcutManagerCompat;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import d0.z.d.m;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ShareUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ShareUtils$updateDirectShareTargets$4 extends o implements Function1<Map<Long, ? extends Channel>, Unit> {
    public final /* synthetic */ Context $context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareUtils$updateDirectShareTargets$4(Context context) {
        super(1);
        this.$context = context;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Map<Long, ? extends Channel> map) {
        invoke2((Map<Long, Channel>) map);
        return Unit.a;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0041  */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Map<Long, Channel> map) {
        boolean z2;
        List<ShortcutInfoCompat> dynamicShortcuts = ShortcutManagerCompat.getDynamicShortcuts(this.$context);
        ArrayList<ShortcutInfoCompat> arrayListA0 = a.a0(dynamicShortcuts, "ShortcutManagerCompat.getDynamicShortcuts(context)");
        for (Object obj : dynamicShortcuts) {
            ShortcutInfoCompat shortcutInfoCompat = (ShortcutInfoCompat) obj;
            m.checkNotNullExpressionValue(shortcutInfoCompat, "it");
            if (shortcutInfoCompat.isPinned()) {
                String id2 = shortcutInfoCompat.getId();
                m.checkNotNullExpressionValue(id2, "it.id");
                if (map.containsKey(Long.valueOf(Long.parseLong(id2)))) {
                    z2 = false;
                } else {
                    z2 = true;
                }
            } else {
                z2 = false;
            }
            if (z2) {
                arrayListA0.add(obj);
            }
        }
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(arrayListA0, 10));
        for (ShortcutInfoCompat shortcutInfoCompat2 : arrayListA0) {
            m.checkNotNullExpressionValue(shortcutInfoCompat2, "it");
            arrayList.add(shortcutInfoCompat2.getId());
        }
        ShortcutManagerCompat.disableShortcuts(this.$context, arrayList, "The channels these shortcuts are for no longer exist.");
        ShortcutManagerCompat.removeLongLivedShortcuts(this.$context, arrayList);
    }
}
