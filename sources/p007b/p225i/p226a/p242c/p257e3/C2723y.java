package p007b.p225i.p226a.p242c.p257e3;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.c.e3.y */
/* JADX INFO: compiled from: StatsDataSource.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2723y implements InterfaceC2710l {

    /* JADX INFO: renamed from: a */
    public final InterfaceC2710l f6641a;

    /* JADX INFO: renamed from: b */
    public long f6642b;

    /* JADX INFO: renamed from: c */
    public Uri f6643c;

    /* JADX INFO: renamed from: d */
    public Map<String, List<String>> f6644d;

    public C2723y(InterfaceC2710l interfaceC2710l) {
        Objects.requireNonNull(interfaceC2710l);
        this.f6641a = interfaceC2710l;
        this.f6643c = Uri.EMPTY;
        this.f6644d = Collections.emptyMap();
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.InterfaceC2710l
    /* JADX INFO: renamed from: a */
    public long mo2586a(C2712n c2712n) throws IOException {
        this.f6643c = c2712n.f6542a;
        this.f6644d = Collections.emptyMap();
        long jMo2586a = this.f6641a.mo2586a(c2712n);
        Uri uriMo2589n = mo2589n();
        Objects.requireNonNull(uriMo2589n);
        this.f6643c = uriMo2589n;
        this.f6644d = mo2588j();
        return jMo2586a;
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.InterfaceC2710l
    public void close() throws IOException {
        this.f6641a.close();
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.InterfaceC2710l
    /* JADX INFO: renamed from: d */
    public void mo2587d(InterfaceC2680a0 interfaceC2680a0) {
        Objects.requireNonNull(interfaceC2680a0);
        this.f6641a.mo2587d(interfaceC2680a0);
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.InterfaceC2710l
    /* JADX INFO: renamed from: j */
    public Map<String, List<String>> mo2588j() {
        return this.f6641a.mo2588j();
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.InterfaceC2710l
    @Nullable
    /* JADX INFO: renamed from: n */
    public Uri mo2589n() {
        return this.f6641a.mo2589n();
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.InterfaceC2706h
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.f6641a.read(bArr, i, i2);
        if (i3 != -1) {
            this.f6642b += (long) i3;
        }
        return i3;
    }
}
