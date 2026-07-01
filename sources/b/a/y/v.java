package b.a.y;

import com.discord.stores.StoreVoiceParticipants$VoiceUser;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: OverlayVoiceBubble.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class v<T, R> implements j0.k.b<Map<Long, ? extends StoreVoiceParticipants$VoiceUser>, StoreVoiceParticipants$VoiceUser> {
    public static final v j = new v();

    @Override // j0.k.b
    public StoreVoiceParticipants$VoiceUser call(Map<Long, ? extends StoreVoiceParticipants$VoiceUser> map) {
        T next;
        Iterator<T> it = map.values().iterator();
        while (it.hasNext()) {
            next = it.next();
            if (((StoreVoiceParticipants$VoiceUser) next).getIsSpeaking()) {
                return next;
            }
        }
        next = (T) null;
        return next;
    }
}
