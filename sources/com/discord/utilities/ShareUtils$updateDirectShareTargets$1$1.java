package com.discord.utilities;

import androidx.core.app.NotificationCompat;
import com.discord.utilities.images.MGImagesBitmap$CloseableBitmaps;
import d0.o;
import j0.k.b;
import java.util.List;
import kotlin.Pair;

/* JADX INFO: compiled from: ShareUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ShareUtils$updateDirectShareTargets$1$1<T, R> implements b<MGImagesBitmap$CloseableBitmaps, Pair<? extends List<? extends Pair<? extends ChannelShortcutInfo, ? extends String>>, ? extends MGImagesBitmap$CloseableBitmaps>> {
    public final /* synthetic */ List $channelAndIconUriPairs;

    public ShareUtils$updateDirectShareTargets$1$1(List list) {
        this.$channelAndIconUriPairs = list;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Pair<? extends List<? extends Pair<? extends ChannelShortcutInfo, ? extends String>>, ? extends MGImagesBitmap$CloseableBitmaps> call(MGImagesBitmap$CloseableBitmaps mGImagesBitmap$CloseableBitmaps) {
        return call2(mGImagesBitmap$CloseableBitmaps);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Pair<List<Pair<ChannelShortcutInfo, String>>, MGImagesBitmap$CloseableBitmaps> call2(MGImagesBitmap$CloseableBitmaps mGImagesBitmap$CloseableBitmaps) {
        return o.to(this.$channelAndIconUriPairs, mGImagesBitmap$CloseableBitmaps);
    }
}
