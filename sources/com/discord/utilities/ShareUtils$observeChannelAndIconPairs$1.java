package com.discord.utilities;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import d0.t.n;
import d0.t.o;
import d0.z.d.m;
import j0.k.b;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ShareUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ShareUtils$observeChannelAndIconPairs$1<T, R> implements b<List<? extends Channel>, List<? extends ChannelShortcutInfo>> {
    public static final ShareUtils$observeChannelAndIconPairs$1 INSTANCE = new ShareUtils$observeChannelAndIconPairs$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ List<? extends ChannelShortcutInfo> call(List<? extends Channel> list) {
        return call2((List<Channel>) list);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final List<ChannelShortcutInfo> call2(List<Channel> list) {
        m.checkNotNullExpressionValue(list, "it");
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(list, 10));
        int i = 0;
        for (T t : list) {
            int i2 = i + 1;
            if (i < 0) {
                n.throwIndexOverflow();
            }
            arrayList.add(new ChannelShortcutInfo((Channel) t, i, false));
            i = i2;
        }
        return arrayList;
    }
}
