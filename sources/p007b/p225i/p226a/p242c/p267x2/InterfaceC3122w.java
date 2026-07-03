package p007b.p225i.p226a.p242c.p267x2;

import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.Arrays;
import p007b.p225i.p226a.p242c.C2811j1;
import p007b.p225i.p226a.p242c.p257e3.InterfaceC2706h;
import p007b.p225i.p226a.p242c.p259f3.C2757x;

/* JADX INFO: renamed from: b.i.a.c.x2.w */
/* JADX INFO: compiled from: TrackOutput.java */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC3122w {

    /* JADX INFO: renamed from: b.i.a.c.x2.w$a */
    /* JADX INFO: compiled from: TrackOutput.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public final int f9000a;

        /* JADX INFO: renamed from: b */
        public final byte[] f9001b;

        /* JADX INFO: renamed from: c */
        public final int f9002c;

        /* JADX INFO: renamed from: d */
        public final int f9003d;

        public a(int i, byte[] bArr, int i2, int i3) {
            this.f9000a = i;
            this.f9001b = bArr;
            this.f9002c = i2;
            this.f9003d = i3;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f9000a == aVar.f9000a && this.f9002c == aVar.f9002c && this.f9003d == aVar.f9003d && Arrays.equals(this.f9001b, aVar.f9001b);
        }

        public int hashCode() {
            return ((((Arrays.hashCode(this.f9001b) + (this.f9000a * 31)) * 31) + this.f9002c) * 31) + this.f9003d;
        }
    }

    /* JADX INFO: renamed from: a */
    int mo2522a(InterfaceC2706h interfaceC2706h, int i, boolean z2, int i2) throws IOException;

    /* JADX INFO: renamed from: b */
    int mo2523b(InterfaceC2706h interfaceC2706h, int i, boolean z2) throws IOException;

    /* JADX INFO: renamed from: c */
    void mo2524c(C2757x c2757x, int i);

    /* JADX INFO: renamed from: d */
    void mo2525d(long j, int i, int i2, int i3, @Nullable a aVar);

    /* JADX INFO: renamed from: e */
    void mo2526e(C2811j1 c2811j1);

    /* JADX INFO: renamed from: f */
    void mo2527f(C2757x c2757x, int i, int i2);
}
