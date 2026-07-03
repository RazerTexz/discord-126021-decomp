package p007b.p225i.p226a.p242c.p243a3;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.UnrecognizedInputFormatException;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p242c.p257e3.InterfaceC2706h;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p267x2.C3011e;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3041i;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3058j;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3106l;

/* JADX INFO: renamed from: b.i.a.c.a3.m */
/* JADX INFO: compiled from: BundledExtractorsAdapter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2553m implements InterfaceC2536d0 {

    /* JADX INFO: renamed from: a */
    public final InterfaceC3106l f5645a;

    /* JADX INFO: renamed from: b */
    @Nullable
    public InterfaceC3031h f5646b;

    /* JADX INFO: renamed from: c */
    @Nullable
    public InterfaceC3041i f5647c;

    public C2553m(InterfaceC3106l interfaceC3106l) {
        this.f5645a = interfaceC3106l;
    }

    /* JADX INFO: renamed from: a */
    public long m2558a() {
        InterfaceC3041i interfaceC3041i = this.f5647c;
        if (interfaceC3041i != null) {
            return interfaceC3041i.getPosition();
        }
        return -1L;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0061  */
    /* JADX INFO: renamed from: b */
    public void m2559b(InterfaceC2706h interfaceC2706h, Uri uri, Map<String, List<String>> map, long j, long j2, InterfaceC3058j interfaceC3058j) throws IOException {
        C3011e c3011e = new C3011e(interfaceC2706h, j, j2);
        this.f5647c = c3011e;
        if (this.f5646b != null) {
            return;
        }
        InterfaceC3031h[] interfaceC3031hArrMo3631b = this.f5645a.mo3631b(uri, map);
        boolean z2 = true;
        if (interfaceC3031hArrMo3631b.length == 1) {
            this.f5646b = interfaceC3031hArrMo3631b[0];
        } else {
            for (InterfaceC3031h interfaceC3031h : interfaceC3031hArrMo3631b) {
                try {
                    if (interfaceC3031h.mo3633b(c3011e)) {
                        this.f5646b = interfaceC3031h;
                        C1460d.m426D(true);
                        c3011e.f8119f = 0;
                        break;
                    } else {
                        boolean z3 = this.f5646b != null || c3011e.f8117d == j;
                        C1460d.m426D(z3);
                        c3011e.f8119f = 0;
                    }
                } catch (EOFException unused) {
                    if (this.f5646b != null || c3011e.f8117d == j) {
                    }
                } catch (Throwable th) {
                    if (this.f5646b == null && c3011e.f8117d != j) {
                        z2 = false;
                    }
                    C1460d.m426D(z2);
                    c3011e.f8119f = 0;
                    throw th;
                }
                C1460d.m426D(z3);
                c3011e.f8119f = 0;
            }
            if (this.f5646b == null) {
                int i = C2738e0.f6708a;
                StringBuilder sb = new StringBuilder();
                for (int i2 = 0; i2 < interfaceC3031hArrMo3631b.length; i2++) {
                    sb.append(interfaceC3031hArrMo3631b[i2].getClass().getSimpleName());
                    if (i2 < interfaceC3031hArrMo3631b.length - 1) {
                        sb.append(", ");
                    }
                }
                String string = sb.toString();
                StringBuilder sb2 = new StringBuilder(C1643a.m841b(string, 58));
                sb2.append("None of the available extractors (");
                sb2.append(string);
                sb2.append(") could read the stream.");
                String string2 = sb2.toString();
                Objects.requireNonNull(uri);
                throw new UnrecognizedInputFormatException(string2, uri);
            }
        }
        this.f5646b.mo3636f(interfaceC3058j);
    }
}
