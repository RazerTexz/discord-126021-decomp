package com.discord.utilities;

import androidx.core.app.NotificationCompat;
import com.discord.utilities.images.MGImagesBitmap$CloseableBitmaps;
import d0.f0.q;
import d0.t.u;
import d0.z.d.m;
import j0.k.b;
import java.util.List;
import kotlin.Pair;
import rx.Observable;

/* JADX INFO: compiled from: ShareUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ShareUtils$updateDirectShareTargets$1<T, R> implements b<List<? extends Pair<? extends ChannelShortcutInfo, ? extends String>>, Observable<? extends Pair<? extends List<? extends Pair<? extends ChannelShortcutInfo, ? extends String>>, ? extends MGImagesBitmap$CloseableBitmaps>>> {
    public static final ShareUtils$updateDirectShareTargets$1 INSTANCE = new ShareUtils$updateDirectShareTargets$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends Pair<? extends List<? extends Pair<? extends ChannelShortcutInfo, ? extends String>>, ? extends MGImagesBitmap$CloseableBitmaps>> call(List<? extends Pair<? extends ChannelShortcutInfo, ? extends String>> list) {
        return call2((List<Pair<ChannelShortcutInfo, String>>) list);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Pair<List<Pair<ChannelShortcutInfo, String>>, MGImagesBitmap$CloseableBitmaps>> call2(List<Pair<ChannelShortcutInfo, String>> list) {
        m.checkNotNullExpressionValue(list, "channelAndIconUriPairs");
        return ShareUtils.INSTANCE.loadAdaptiveBitmaps(q.map(u.asSequence(list), ShareUtils$updateDirectShareTargets$1$uris$1.INSTANCE)).G(new ShareUtils$updateDirectShareTargets$1$1(list));
    }
}
