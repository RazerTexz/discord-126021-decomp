package b.i.a.c.v2;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import b.i.a.c.j1;
import java.util.Objects;

/* JADX INFO: compiled from: DecoderReuseEvaluation.java */
/* JADX INFO: loaded from: classes3.dex */
public final class g {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j1 f1144b;
    public final j1 c;
    public final int d;
    public final int e;

    public g(String str, j1 j1Var, j1 j1Var2, int i, int i2) {
        b.c.a.a0.d.j(i == 0 || i2 == 0);
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException();
        }
        this.a = str;
        Objects.requireNonNull(j1Var);
        this.f1144b = j1Var;
        this.c = j1Var2;
        this.d = i;
        this.e = i2;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g.class != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        return this.d == gVar.d && this.e == gVar.e && this.a.equals(gVar.a) && this.f1144b.equals(gVar.f1144b) && this.c.equals(gVar.c);
    }

    public int hashCode() {
        return this.c.hashCode() + ((this.f1144b.hashCode() + b.d.b.a.a.m(this.a, (((this.d + 527) * 31) + this.e) * 31, 31)) * 31);
    }
}
