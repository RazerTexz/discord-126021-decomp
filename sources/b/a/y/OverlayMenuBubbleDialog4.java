package b.a.y;

import com.discord.api.channel.Channel;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreVoiceParticipants;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.List;
import rx.Observable;

/* JADX INFO: renamed from: b.a.y.p, reason: use source file name */
/* JADX INFO: compiled from: OverlayMenuBubbleDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class OverlayMenuBubbleDialog4<T, R> implements Func1<Channel, Observable<? extends List<? extends StoreVoiceParticipants.VoiceUser>>> {
    public final /* synthetic */ Long j;

    public OverlayMenuBubbleDialog4(Long l) {
        this.j = l;
    }

    @Override // j0.k.Func1
    public Observable<? extends List<? extends StoreVoiceParticipants.VoiceUser>> call(Channel channel) {
        Channel channel2 = channel;
        if (channel2 == null) {
            return new ScalarSynchronousObservable(Collections2.emptyList());
        }
        StoreVoiceParticipants voiceParticipants = StoreStream.INSTANCE.getVoiceParticipants();
        Long l = this.j;
        Intrinsics3.checkNotNullExpressionValue(l, "channelId");
        return voiceParticipants.get(l.longValue()).G(new OverlayMenuBubbleDialog3(channel2)).r();
    }
}
