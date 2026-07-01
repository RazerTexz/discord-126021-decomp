package b.i.a.c.a3;

import b.i.a.c.j1;
import b.i.a.c.j1$b;
import b.i.a.c.k1;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: ClippingMediaPeriod.java */
/* JADX INFO: loaded from: classes3.dex */
public final class n$a implements i0 {
    public final i0 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f830b;
    public final /* synthetic */ n c;

    public n$a(n nVar, i0 i0Var) {
        this.c = nVar;
        this.a = i0Var;
    }

    @Override // b.i.a.c.a3.i0
    public int a(k1 k1Var, DecoderInputBuffer decoderInputBuffer, int i) {
        if (this.c.d()) {
            return -3;
        }
        if (this.f830b) {
            decoderInputBuffer.j = 4;
            return -4;
        }
        int iA = this.a.a(k1Var, decoderInputBuffer, i);
        if (iA != -5) {
            n nVar = this.c;
            long j = nVar.o;
            if (j == Long.MIN_VALUE || ((iA != -4 || decoderInputBuffer.n < j) && !(iA == -3 && nVar.q() == Long.MIN_VALUE && !decoderInputBuffer.m))) {
                return iA;
            }
            decoderInputBuffer.p();
            decoderInputBuffer.j = 4;
            this.f830b = true;
            return -4;
        }
        j1 j1Var = k1Var.f1027b;
        Objects.requireNonNull(j1Var);
        int i2 = j1Var.M;
        if (i2 != 0 || j1Var.N != 0) {
            n nVar2 = this.c;
            if (nVar2.n != 0) {
                i2 = 0;
            }
            int i3 = nVar2.o == Long.MIN_VALUE ? j1Var.N : 0;
            j1$b j1_bA = j1Var.a();
            j1_bA.A = i2;
            j1_bA.B = i3;
            k1Var.f1027b = j1_bA.a();
        }
        return -5;
    }

    @Override // b.i.a.c.a3.i0
    public void b() throws IOException {
        this.a.b();
    }

    @Override // b.i.a.c.a3.i0
    public int c(long j) {
        if (this.c.d()) {
            return -3;
        }
        return this.a.c(j);
    }

    @Override // b.i.a.c.a3.i0
    public boolean d() {
        return !this.c.d() && this.a.d();
    }
}
