package b.a.q.m0.c;

import com.discord.rtcconnection.mediaengine.MediaEngine$EchoCancellationInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: MediaEngineLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class m$a extends d0.z.d.o implements Function0<Unit> {
    public final /* synthetic */ boolean $enabled;
    public final /* synthetic */ boolean $previouslyEnabled;
    public final /* synthetic */ boolean $previouslyMobileMode;
    public final /* synthetic */ boolean $requestEnable;
    public final /* synthetic */ boolean $requestMobileMode;
    public final /* synthetic */ m this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m$a(m mVar, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        super(0);
        this.this$0 = mVar;
        this.$requestEnable = z2;
        this.$enabled = z3;
        this.$requestMobileMode = z4;
        this.$previouslyEnabled = z5;
        this.$previouslyMobileMode = z6;
    }

    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        k kVar = this.this$0.a;
        MediaEngine$EchoCancellationInfo mediaEngine$EchoCancellationInfo = kVar.i;
        kVar.i = null;
        if (mediaEngine$EchoCancellationInfo != null) {
            MediaEngine$EchoCancellationInfo mediaEngine$EchoCancellationInfo2 = new MediaEngine$EchoCancellationInfo(mediaEngine$EchoCancellationInfo.builtinAecRequested, mediaEngine$EchoCancellationInfo.builtinAecSupportedNative, mediaEngine$EchoCancellationInfo.builtinAecSupportedJava, mediaEngine$EchoCancellationInfo.builtinAecEnabled, this.$requestEnable, this.$enabled, this.$requestMobileMode, this.$previouslyEnabled, this.$previouslyMobileMode);
            b.c.a.a0.d.d1("MediaEngineLegacy", "onEchoCancellationUpdated: " + mediaEngine$EchoCancellationInfo2);
            this.this$0.a.p.onEchoCancellationUpdated(mediaEngine$EchoCancellationInfo2);
        }
        return Unit.a;
    }
}
