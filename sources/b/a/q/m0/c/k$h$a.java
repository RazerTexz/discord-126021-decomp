package b.a.q.m0.c;

import com.discord.rtcconnection.mediaengine.MediaEngine$EchoCancellationInfo;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.webrtc.voiceengine.WebRtcAudioUtils;

/* JADX INFO: compiled from: MediaEngineLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class k$h$a extends d0.z.d.o implements Function0<Unit> {
    public final /* synthetic */ boolean $available;
    public final /* synthetic */ boolean $enabled;
    public final /* synthetic */ boolean $requestEnabled;
    public final /* synthetic */ k$h this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k$h$a(k$h k_h, boolean z2, boolean z3, boolean z4) {
        super(0);
        this.this$0 = k_h;
        this.$enabled = z2;
        this.$requestEnabled = z3;
        this.$available = z4;
    }

    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        this.this$0.a.d = this.$enabled;
        k kVar = this.this$0.f272b;
        boolean z2 = this.$requestEnabled;
        boolean z3 = this.$available;
        Objects.requireNonNull(kVar.o);
        kVar.i = new MediaEngine$EchoCancellationInfo(z2, z3, WebRtcAudioUtils.isAcousticEchoCancelerSupported(), this.$enabled, false, false, false, false, false, 496);
        return Unit.a;
    }
}
