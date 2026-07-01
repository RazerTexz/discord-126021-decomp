package b.a.q.m0.c;

import b.c.a.a0.AnimatableValueParser;
import com.discord.rtcconnection.mediaengine.MediaEngine;
import com.hammerandchisel.libdiscord.Discord;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: MediaEngineLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class m implements Discord.AecConfigCallback {
    public final /* synthetic */ k a;

    /* JADX INFO: compiled from: MediaEngineLegacy.kt */
    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ boolean $enabled;
        public final /* synthetic */ boolean $previouslyEnabled;
        public final /* synthetic */ boolean $previouslyMobileMode;
        public final /* synthetic */ boolean $requestEnable;
        public final /* synthetic */ boolean $requestMobileMode;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
            super(0);
            this.$requestEnable = z2;
            this.$enabled = z3;
            this.$requestMobileMode = z4;
            this.$previouslyEnabled = z5;
            this.$previouslyMobileMode = z6;
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            k kVar = m.this.a;
            MediaEngine.EchoCancellationInfo echoCancellationInfo = kVar.i;
            kVar.i = null;
            if (echoCancellationInfo != null) {
                MediaEngine.EchoCancellationInfo echoCancellationInfo2 = new MediaEngine.EchoCancellationInfo(echoCancellationInfo.builtinAecRequested, echoCancellationInfo.builtinAecSupportedNative, echoCancellationInfo.builtinAecSupportedJava, echoCancellationInfo.builtinAecEnabled, this.$requestEnable, this.$enabled, this.$requestMobileMode, this.$previouslyEnabled, this.$previouslyMobileMode);
                AnimatableValueParser.d1("MediaEngineLegacy", "onEchoCancellationUpdated: " + echoCancellationInfo2);
                m.this.a.p.onEchoCancellationUpdated(echoCancellationInfo2);
            }
            return Unit.a;
        }
    }

    public m(k kVar) {
        this.a = kVar;
    }

    @Override // com.hammerandchisel.libdiscord.Discord.AecConfigCallback
    public final void onConfigureAEC(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.a.o(new a(z2, z4, z3, z5, z6));
    }
}
