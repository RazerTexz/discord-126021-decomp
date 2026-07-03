package p007b.p225i.p226a.p288f.p299e.p300h.p301j;

import androidx.annotation.Nullable;
import java.util.Arrays;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p299e.p300h.C3266a;
import p007b.p225i.p226a.p288f.p299e.p300h.C3266a.d;

/* JADX INFO: renamed from: b.i.a.f.e.h.j.b */
/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3278b<O extends C3266a.d> {

    /* JADX INFO: renamed from: a */
    public final int f9345a;

    /* JADX INFO: renamed from: b */
    public final C3266a<O> f9346b;

    /* JADX INFO: renamed from: c */
    @Nullable
    public final O f9347c;

    public C3278b(C3266a<O> c3266a, @Nullable O o) {
        this.f9346b = c3266a;
        this.f9347c = o;
        this.f9345a = Arrays.hashCode(new Object[]{c3266a, o});
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C3278b)) {
            return false;
        }
        C3278b c3278b = (C3278b) obj;
        return C1460d.m524h0(this.f9346b, c3278b.f9346b) && C1460d.m524h0(this.f9347c, c3278b.f9347c);
    }

    public final int hashCode() {
        return this.f9345a;
    }
}
