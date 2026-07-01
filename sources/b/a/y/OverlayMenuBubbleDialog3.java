package b.a.y;

import b.c.a.a0.AnimatableValueParser;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.voice.state.StageRequestToSpeakState;
import com.discord.api.voice.state.VoiceState;
import com.discord.stores.StoreVoiceParticipants;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: b.a.y.o, reason: use source file name */
/* JADX INFO: compiled from: OverlayMenuBubbleDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class OverlayMenuBubbleDialog3<T, R> implements Func1<Map<Long, ? extends StoreVoiceParticipants.VoiceUser>, List<? extends StoreVoiceParticipants.VoiceUser>> {
    public final /* synthetic */ Channel j;

    public OverlayMenuBubbleDialog3(Channel channel) {
        this.j = channel;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x003c  */
    @Override // j0.k.Func1
    public List<? extends StoreVoiceParticipants.VoiceUser> call(Map<Long, ? extends StoreVoiceParticipants.VoiceUser> map) {
        boolean z2;
        Collection<? extends StoreVoiceParticipants.VoiceUser> collectionValues = map.values();
        ArrayList arrayList = new ArrayList();
        for (T t : collectionValues) {
            StoreVoiceParticipants.VoiceUser voiceUser = (StoreVoiceParticipants.VoiceUser) t;
            if (voiceUser.isConnected()) {
                if (ChannelUtils.D(this.j)) {
                    VoiceState voiceState = voiceUser.getVoiceState();
                    if ((voiceState != null ? AnimatableValueParser.y0(voiceState) : null) != StageRequestToSpeakState.ON_STAGE) {
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
