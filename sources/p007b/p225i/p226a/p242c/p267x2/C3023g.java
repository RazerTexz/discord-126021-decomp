package p007b.p225i.p226a.p242c.p267x2;

import androidx.annotation.Nullable;
import java.io.EOFException;
import java.io.IOException;
import p007b.p225i.p226a.p242c.C2811j1;
import p007b.p225i.p226a.p242c.p257e3.InterfaceC2706h;
import p007b.p225i.p226a.p242c.p259f3.C2757x;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3122w;

/* JADX INFO: renamed from: b.i.a.c.x2.g */
/* JADX INFO: compiled from: DummyTrackOutput.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3023g implements InterfaceC3122w {

    /* JADX INFO: renamed from: a */
    public final byte[] f8179a = new byte[4096];

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3122w
    /* JADX INFO: renamed from: a */
    public int mo2522a(InterfaceC2706h interfaceC2706h, int i, boolean z2, int i2) throws IOException {
        int i3 = interfaceC2706h.read(this.f8179a, 0, Math.min(this.f8179a.length, i));
        if (i3 != -1) {
            return i3;
        }
        if (z2) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3122w
    /* JADX INFO: renamed from: b */
    public /* synthetic */ int mo2523b(InterfaceC2706h interfaceC2706h, int i, boolean z2) {
        return C3121v.m3817a(this, interfaceC2706h, i, z2);
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3122w
    /* JADX INFO: renamed from: c */
    public /* synthetic */ void mo2524c(C2757x c2757x, int i) {
        C3121v.m3818b(this, c2757x, i);
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3122w
    /* JADX INFO: renamed from: d */
    public void mo2525d(long j, int i, int i2, int i3, @Nullable InterfaceC3122w.a aVar) {
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3122w
    /* JADX INFO: renamed from: e */
    public void mo2526e(C2811j1 c2811j1) {
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3122w
    /* JADX INFO: renamed from: f */
    public void mo2527f(C2757x c2757x, int i, int i2) {
        c2757x.m3079E(c2757x.f6794b + i);
    }
}
