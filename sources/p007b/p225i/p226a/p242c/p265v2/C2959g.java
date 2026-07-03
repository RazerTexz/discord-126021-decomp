package p007b.p225i.p226a.p242c.p265v2;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p242c.C2811j1;

/* JADX INFO: renamed from: b.i.a.c.v2.g */
/* JADX INFO: compiled from: DecoderReuseEvaluation.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2959g {

    /* JADX INFO: renamed from: a */
    public final String f7926a;

    /* JADX INFO: renamed from: b */
    public final C2811j1 f7927b;

    /* JADX INFO: renamed from: c */
    public final C2811j1 f7928c;

    /* JADX INFO: renamed from: d */
    public final int f7929d;

    /* JADX INFO: renamed from: e */
    public final int f7930e;

    public C2959g(String str, C2811j1 c2811j1, C2811j1 c2811j2, int i, int i2) {
        C1460d.m531j(i == 0 || i2 == 0);
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException();
        }
        this.f7926a = str;
        Objects.requireNonNull(c2811j1);
        this.f7927b = c2811j1;
        this.f7928c = c2811j2;
        this.f7929d = i;
        this.f7930e = i2;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C2959g.class != obj.getClass()) {
            return false;
        }
        C2959g c2959g = (C2959g) obj;
        return this.f7929d == c2959g.f7929d && this.f7930e == c2959g.f7930e && this.f7926a.equals(c2959g.f7926a) && this.f7927b.equals(c2959g.f7927b) && this.f7928c.equals(c2959g.f7928c);
    }

    public int hashCode() {
        return this.f7928c.hashCode() + ((this.f7927b.hashCode() + C1643a.m863m(this.f7926a, (((this.f7929d + 527) * 31) + this.f7930e) * 31, 31)) * 31);
    }
}
