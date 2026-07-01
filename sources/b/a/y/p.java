package b.a.y;

import com.discord.api.channel.Channel;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.stores.StoreVoiceParticipants$VoiceUser;
import java.util.List;
import rx.Observable;

/* JADX INFO: compiled from: OverlayMenuBubbleDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class p<T, R> implements j0.k.b<Channel, Observable<? extends List<? extends StoreVoiceParticipants$VoiceUser>>> {
    public final /* synthetic */ Long j;

    public p(Long l) {
        this.j = l;
    }

    @Override // j0.k.b
    public Observable<? extends List<? extends StoreVoiceParticipants$VoiceUser>> call(Channel channel) {
        Channel channel2 = channel;
        if (channel2 == null) {
            return new j0.l.e.k(d0.t.n.emptyList());
        }
        StoreVoiceParticipants voiceParticipants = StoreStream.Companion.getVoiceParticipants();
        Long l = this.j;
        d0.z.d.m.checkNotNullExpressionValue(l, "channelId");
        return voiceParticipants.get(l.longValue()).G(new o(channel2)).r();
    }
}
