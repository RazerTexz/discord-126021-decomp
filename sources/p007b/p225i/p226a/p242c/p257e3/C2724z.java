package p007b.p225i.p226a.p242c.p257e3;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.c.e3.z */
/* JADX INFO: compiled from: TeeDataSource.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2724z implements InterfaceC2710l {

    /* JADX INFO: renamed from: a */
    public final InterfaceC2710l f6645a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC2708j f6646b;

    /* JADX INFO: renamed from: c */
    public boolean f6647c;

    /* JADX INFO: renamed from: d */
    public long f6648d;

    public C2724z(InterfaceC2710l interfaceC2710l, InterfaceC2708j interfaceC2708j) {
        this.f6645a = interfaceC2710l;
        this.f6646b = interfaceC2708j;
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.InterfaceC2710l
    /* JADX INFO: renamed from: a */
    public long mo2586a(C2712n c2712n) throws IOException {
        C2712n c2712n2 = c2712n;
        long jMo2586a = this.f6645a.mo2586a(c2712n2);
        this.f6648d = jMo2586a;
        if (jMo2586a == 0) {
            return 0L;
        }
        long j = c2712n2.f6548g;
        if (j == -1 && jMo2586a != -1) {
            c2712n2 = j == jMo2586a ? c2712n2 : new C2712n(c2712n2.f6542a, c2712n2.f6543b, c2712n2.f6544c, c2712n2.f6545d, c2712n2.f6546e, c2712n2.f6547f + 0, jMo2586a, c2712n2.f6549h, c2712n2.f6550i, c2712n2.f6551j);
        }
        this.f6647c = true;
        this.f6646b.mo2852a(c2712n2);
        return this.f6648d;
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.InterfaceC2710l
    public void close() throws IOException {
        try {
            this.f6645a.close();
        } finally {
            if (this.f6647c) {
                this.f6647c = false;
                this.f6646b.close();
            }
        }
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.InterfaceC2710l
    /* JADX INFO: renamed from: d */
    public void mo2587d(InterfaceC2680a0 interfaceC2680a0) {
        Objects.requireNonNull(interfaceC2680a0);
        this.f6645a.mo2587d(interfaceC2680a0);
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.InterfaceC2710l
    /* JADX INFO: renamed from: j */
    public Map<String, List<String>> mo2588j() {
        return this.f6645a.mo2588j();
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.InterfaceC2710l
    @Nullable
    /* JADX INFO: renamed from: n */
    public Uri mo2589n() {
        return this.f6645a.mo2589n();
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.InterfaceC2706h
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.f6648d == 0) {
            return -1;
        }
        int i3 = this.f6645a.read(bArr, i, i2);
        if (i3 > 0) {
            this.f6646b.write(bArr, i, i3);
            long j = this.f6648d;
            if (j != -1) {
                this.f6648d = j - ((long) i3);
            }
        }
        return i3;
    }
}
