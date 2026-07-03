package p007b.p008a.p062y;

import com.discord.api.channel.Channel;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreVoiceParticipants;
import java.util.List;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;

/* JADX INFO: renamed from: b.a.y.p */
/* JADX INFO: compiled from: OverlayMenuBubbleDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C1368p<T, R> implements InterfaceC12589b<Channel, Observable<? extends List<? extends StoreVoiceParticipants.VoiceUser>>> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ Long f2063j;

    public C1368p(Long l) {
        this.f2063j = l;
    }

    @Override // p637j0.p641k.InterfaceC12589b
    public Observable<? extends List<? extends StoreVoiceParticipants.VoiceUser>> call(Channel channel) {
        Channel channel2 = channel;
        if (channel2 == null) {
            return new C12721k(C12147n.emptyList());
        }
        StoreVoiceParticipants voiceParticipants = StoreStream.INSTANCE.getVoiceParticipants();
        Long l = this.f2063j;
        C12238m.checkNotNullExpressionValue(l, "channelId");
        return voiceParticipants.get(l.longValue()).m11083G(new C1363o(channel2)).m11112r();
    }
}
