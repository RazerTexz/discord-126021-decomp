package b.a.q.m0.c;

import com.hammerandchisel.libdiscord.Discord$AecConfigCallback;

/* JADX INFO: compiled from: MediaEngineLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class m implements Discord$AecConfigCallback {
    public final /* synthetic */ k a;

    public m(k kVar) {
        this.a = kVar;
    }

    @Override // com.hammerandchisel.libdiscord.Discord$AecConfigCallback
    public final void onConfigureAEC(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.a.o(new m$a(this, z2, z4, z3, z5, z6));
    }
}
