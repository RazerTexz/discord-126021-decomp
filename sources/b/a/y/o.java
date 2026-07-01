package b.a.y;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.voice.state.StageRequestToSpeakState;
import com.discord.api.voice.state.VoiceState;
import com.discord.stores.StoreVoiceParticipants$VoiceUser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: OverlayMenuBubbleDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class o<T, R> implements j0.k.b<Map<Long, ? extends StoreVoiceParticipants$VoiceUser>, List<? extends StoreVoiceParticipants$VoiceUser>> {
    public final /* synthetic */ Channel j;

    public o(Channel channel) {
        this.j = channel;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x003c  */
    @Override // j0.k.b
    public List<? extends StoreVoiceParticipants$VoiceUser> call(Map<Long, ? extends StoreVoiceParticipants$VoiceUser> map) {
        boolean z2;
        Collection<? extends StoreVoiceParticipants$VoiceUser> collectionValues = map.values();
        ArrayList arrayList = new ArrayList();
        for (T t : collectionValues) {
            StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser = (StoreVoiceParticipants$VoiceUser) t;
            if (storeVoiceParticipants$VoiceUser.isConnected()) {
                if (ChannelUtils.D(this.j)) {
                    VoiceState voiceState = storeVoiceParticipants$VoiceUser.getVoiceState();
                    if ((voiceState != null ? b.c.a.a0.d.y0(voiceState) : null) != StageRequestToSpeakState.ON_STAGE) {
                        z2 = false;
                    }
                }
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }
}
