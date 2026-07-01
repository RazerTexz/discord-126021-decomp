package b.a.y;

import com.discord.stores.StoreStream;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.stores.StoreVoiceParticipants$VoiceUser;
import rx.Observable;

/* JADX INFO: compiled from: OverlayVoiceBubble.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class w$a<T, R> implements j0.k.b<Long, Observable<? extends StoreVoiceParticipants$VoiceUser>> {
    public static final w$a j = new w$a();

    @Override // j0.k.b
    public Observable<? extends StoreVoiceParticipants$VoiceUser> call(Long l) {
        Long l2 = l;
        if (l2 != null && l2.longValue() == 0) {
            return new j0.l.e.k(null);
        }
        StoreVoiceParticipants voiceParticipants = StoreStream.Companion.getVoiceParticipants();
        d0.z.d.m.checkNotNullExpressionValue(l2, "channelId");
        return voiceParticipants.get(l2.longValue()).G(v.j).r();
    }
}
