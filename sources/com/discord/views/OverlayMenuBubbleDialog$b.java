package com.discord.views;

import b.a.y.p;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreVoiceParticipants$VoiceUser;
import d0.z.d.m;
import j0.k.b;
import java.util.List;
import rx.Observable;

/* JADX INFO: compiled from: OverlayMenuBubbleDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class OverlayMenuBubbleDialog$b<T, R> implements b<Long, Observable<? extends List<? extends StoreVoiceParticipants$VoiceUser>>> {
    public static final OverlayMenuBubbleDialog$b j = new OverlayMenuBubbleDialog$b();

    @Override // j0.k.b
    public Observable<? extends List<? extends StoreVoiceParticipants$VoiceUser>> call(Long l) {
        Long l2 = l;
        StoreChannels channels = StoreStream.Companion.getChannels();
        m.checkNotNullExpressionValue(l2, "channelId");
        return channels.observeChannel(l2.longValue()).Y(new p(l2));
    }
}
