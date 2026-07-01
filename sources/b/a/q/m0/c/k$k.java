package b.a.q.m0.c;

import com.discord.rtcconnection.mediaengine.MediaEngine$VoiceConfig;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection$Type;
import com.hammerandchisel.libdiscord.Discord;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: MediaEngineLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class k$k extends d0.z.d.o implements Function0<Unit> {
    public final /* synthetic */ MediaEngine$VoiceConfig $voiceConfig;
    public final /* synthetic */ k this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k$k(k kVar, MediaEngine$VoiceConfig mediaEngine$VoiceConfig) {
        super(0);
        this.this$0 = kVar;
        this.$voiceConfig = mediaEngine$VoiceConfig;
    }

    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        boolean z2;
        StringBuilder sbU = b.d.b.a.a.U("updateVoiceConfig: ");
        sbU.append(this.$voiceConfig);
        b.c.a.a0.d.b1("MediaEngineLegacy", sbU.toString());
        MediaEngine$VoiceConfig mediaEngine$VoiceConfig = this.$voiceConfig;
        k kVar = this.this$0;
        float f = mediaEngine$VoiceConfig.outputVolume;
        Discord discord = kVar.f;
        if (discord != null) {
            discord.setSpeakerVolume(Math.min(300.0f, Math.max(0.0f, f)) / 100.0f);
        }
        k kVar2 = this.this$0;
        boolean z3 = mediaEngine$VoiceConfig.echoCancellation;
        kVar2.l.a();
        b.a.q.k0.g gVar = kVar2.o;
        if (gVar.g && gVar.d) {
            z2 = false;
        } else {
            b.a.q.k0.g gVar2 = kVar2.o;
            z2 = gVar2.f && !gVar2.d ? true : z3;
        }
        if (z2 != z3) {
            b.c.a.a0.d.b1("MediaEngineLegacy", "ignoring call to setEchoCancellation(" + z3 + "), config=" + kVar2.o);
        }
        Discord discord2 = kVar2.f;
        if (discord2 != null) {
            discord2.setEchoCancellation(z2, false, new m(kVar2));
        }
        k kVar3 = this.this$0;
        boolean z4 = mediaEngine$VoiceConfig.noiseSuppression;
        Discord discord3 = kVar3.f;
        if (discord3 != null) {
            discord3.setNoiseSuppression(z4);
        }
        k kVar4 = this.this$0;
        boolean z5 = mediaEngine$VoiceConfig.noiseCancellation;
        kVar4.c.a = z5;
        Discord discord4 = kVar4.f;
        if (discord4 != null) {
            discord4.setNoiseCancellation(z5);
        }
        k kVar5 = this.this$0;
        boolean z6 = mediaEngine$VoiceConfig.automaticGainControl;
        Discord discord5 = kVar5.f;
        if (discord5 != null) {
            discord5.setAutomaticGainControl(z6);
        }
        for (MediaEngineConnection mediaEngineConnection : this.this$0.getConnections()) {
            mediaEngineConnection.k(mediaEngine$VoiceConfig.inputMode, mediaEngine$VoiceConfig.inputModeOptions);
            mediaEngineConnection.v(mediaEngine$VoiceConfig.isSelfDeafened);
            mediaEngineConnection.c(mediaEngine$VoiceConfig.isSelfMuted || mediaEngineConnection.getType() == MediaEngineConnection$Type.STREAM);
        }
        return Unit.a;
    }
}
