package b.a.q.m0.c;

import com.hammerandchisel.libdiscord.Discord;
import com.hammerandchisel.libdiscord.Discord$BuiltinAECCallback;

/* JADX INFO: compiled from: MediaEngineLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class k$h implements Discord$BuiltinAECCallback {
    public final /* synthetic */ b.a.q.k0.g a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k f272b;

    public k$h(b.a.q.k0.g gVar, Discord discord, k kVar) {
        this.a = gVar;
        this.f272b = kVar;
    }

    @Override // com.hammerandchisel.libdiscord.Discord$BuiltinAECCallback
    public final void onConfigureBuiltinAEC(boolean z2, boolean z3, boolean z4) {
        this.f272b.o(new k$h$a(this, z4, z2, z3));
    }
}
