package p007b.p008a.p062y;

import com.discord.stores.StoreVoiceParticipants;
import java.util.Iterator;
import java.util.Map;
import p637j0.p641k.InterfaceC12589b;

/* JADX INFO: renamed from: b.a.y.v */
/* JADX INFO: compiled from: OverlayVoiceBubble.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C1386v<T, R> implements InterfaceC12589b<Map<Long, ? extends StoreVoiceParticipants.VoiceUser>, StoreVoiceParticipants.VoiceUser> {

    /* JADX INFO: renamed from: j */
    public static final C1386v f2072j = new C1386v();

    @Override // p637j0.p641k.InterfaceC12589b
    public StoreVoiceParticipants.VoiceUser call(Map<Long, ? extends StoreVoiceParticipants.VoiceUser> map) {
        T next;
        Iterator<T> it = map.values().iterator();
        while (it.hasNext()) {
            next = it.next();
            if (((StoreVoiceParticipants.VoiceUser) next).getIsSpeaking()) {
                return next;
            }
        }
        next = (T) null;
        return next;
    }
}
