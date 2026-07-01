package com.discord.utilities;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import androidx.core.content.pm.ShortcutInfoCompat;
import androidx.core.content.pm.ShortcutManagerCompat;
import com.discord.api.channel.Channel;
import com.discord.utilities.icon.IconUtils;
import d0.f0.q;
import d0.t.o;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import rx.functions.Func2;

/* JADX INFO: compiled from: ShareUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ShareUtils$observeChannelAndIconPairs$3<T1, T2, R> implements Func2<List<? extends ChannelShortcutInfo>, Map<Long, ? extends Channel>, List<? extends Pair<? extends ChannelShortcutInfo, ? extends String>>> {
    public final /* synthetic */ Context $context;

    public ShareUtils$observeChannelAndIconPairs$3(Context context) {
        this.$context = context;
    }

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ List<? extends Pair<? extends ChannelShortcutInfo, ? extends String>> call(List<? extends ChannelShortcutInfo> list, Map<Long, ? extends Channel> map) {
        return call2((List<ChannelShortcutInfo>) list, (Map<Long, Channel>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final List<Pair<ChannelShortcutInfo, String>> call2(List<ChannelShortcutInfo> list, Map<Long, Channel> map) {
        m.checkNotNullExpressionValue(list, "directShareChannels");
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((ChannelShortcutInfo) it.next()).getChannel().getId()));
        }
        Set set = u.toSet(arrayList);
        List<ShortcutInfoCompat> dynamicShortcuts = ShortcutManagerCompat.getDynamicShortcuts(this.$context);
        m.checkNotNullExpressionValue(dynamicShortcuts, "ShortcutManagerCompat.getDynamicShortcuts(context)");
        List<ChannelShortcutInfo> listPlus = u.plus((Collection) list, q.map(q.mapNotNull(q.filter(q.map(q.filter(u.asSequence(dynamicShortcuts), ShareUtils$observeChannelAndIconPairs$3$pinnedOnlyShortcutChannels$1.INSTANCE), ShareUtils$observeChannelAndIconPairs$3$pinnedOnlyShortcutChannels$2.INSTANCE), new ShareUtils$observeChannelAndIconPairs$3$pinnedOnlyShortcutChannels$3(set)), new ShareUtils$observeChannelAndIconPairs$3$pinnedOnlyShortcutChannels$4(map)), ShareUtils$observeChannelAndIconPairs$3$pinnedOnlyShortcutChannels$5.INSTANCE));
        ArrayList arrayList2 = new ArrayList();
        for (ChannelShortcutInfo channelShortcutInfo : listPlus) {
            String forChannel$default = IconUtils.getForChannel$default(channelShortcutInfo.getChannel(), null, 2, null);
            Pair pair = forChannel$default != null ? d0.o.to(channelShortcutInfo, forChannel$default) : null;
            if (pair != null) {
                arrayList2.add(pair);
            }
        }
        return arrayList2;
    }
}
