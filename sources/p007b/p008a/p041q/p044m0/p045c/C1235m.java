package p007b.p008a.p041q.p044m0.p045c;

import com.discord.rtcconnection.mediaengine.MediaEngine;
import com.hammerandchisel.libdiscord.Discord;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p007b.p085c.p086a.p087a0.C1460d;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: b.a.q.m0.c.m */
/* JADX INFO: compiled from: MediaEngineLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1235m implements Discord.AecConfigCallback {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C1233k f1749a;

    /* JADX INFO: renamed from: b.a.q.m0.c.m$a */
    /* JADX INFO: compiled from: MediaEngineLegacy.kt */
    public static final class a extends AbstractC12240o implements Function0<Unit> {
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
            C1233k c1233k = C1235m.this.f1749a;
            MediaEngine.EchoCancellationInfo echoCancellationInfo = c1233k.f1729i;
            c1233k.f1729i = null;
            if (echoCancellationInfo != null) {
                MediaEngine.EchoCancellationInfo echoCancellationInfo2 = new MediaEngine.EchoCancellationInfo(echoCancellationInfo.builtinAecRequested, echoCancellationInfo.builtinAecSupportedNative, echoCancellationInfo.builtinAecSupportedJava, echoCancellationInfo.builtinAecEnabled, this.$requestEnable, this.$enabled, this.$requestMobileMode, this.$previouslyEnabled, this.$previouslyMobileMode);
                C1460d.m509d1("MediaEngineLegacy", "onEchoCancellationUpdated: " + echoCancellationInfo2);
                C1235m.this.f1749a.f1736p.onEchoCancellationUpdated(echoCancellationInfo2);
            }
            return Unit.f27425a;
        }
    }

    public C1235m(C1233k c1233k) {
        this.f1749a = c1233k;
    }

    @Override // com.hammerandchisel.libdiscord.Discord.AecConfigCallback
    public final void onConfigureAEC(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.f1749a.m334o(new a(z2, z4, z3, z5, z6));
    }
}
