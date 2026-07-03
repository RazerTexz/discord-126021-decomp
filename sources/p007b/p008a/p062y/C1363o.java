package p007b.p008a.p062y;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.voice.state.StageRequestToSpeakState;
import com.discord.api.voice.state.VoiceState;
import com.discord.stores.StoreVoiceParticipants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import p007b.p085c.p086a.p087a0.C1460d;
import p637j0.p641k.InterfaceC12589b;

/* JADX INFO: renamed from: b.a.y.o */
/* JADX INFO: compiled from: OverlayMenuBubbleDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C1363o<T, R> implements InterfaceC12589b<Map<Long, ? extends StoreVoiceParticipants.VoiceUser>, List<? extends StoreVoiceParticipants.VoiceUser>> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ Channel f2051j;

    public C1363o(Channel channel) {
        this.f2051j = channel;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x003c  */
    @Override // p637j0.p641k.InterfaceC12589b
    public List<? extends StoreVoiceParticipants.VoiceUser> call(Map<Long, ? extends StoreVoiceParticipants.VoiceUser> map) {
        boolean z2;
        Collection<? extends StoreVoiceParticipants.VoiceUser> collectionValues = map.values();
        ArrayList arrayList = new ArrayList();
        for (T t : collectionValues) {
            StoreVoiceParticipants.VoiceUser voiceUser = (StoreVoiceParticipants.VoiceUser) t;
            if (voiceUser.isConnected()) {
                if (ChannelUtils.m7669D(this.f2051j)) {
                    VoiceState voiceState = voiceUser.getVoiceState();
                    if ((voiceState != null ? C1460d.m592y0(voiceState) : null) != StageRequestToSpeakState.ON_STAGE) {
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
