package p007b.p225i.p226a.p242c.p245b3.p254v;

import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: renamed from: b.i.a.c.b3.v.f */
/* JADX INFO: compiled from: WebvttCssStyle.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2625f {

    /* JADX INFO: renamed from: f */
    @ColorInt
    public int f6119f;

    /* JADX INFO: renamed from: h */
    public int f6121h;

    /* JADX INFO: renamed from: o */
    public float f6128o;

    /* JADX INFO: renamed from: a */
    public String f6114a = "";

    /* JADX INFO: renamed from: b */
    public String f6115b = "";

    /* JADX INFO: renamed from: c */
    public Set<String> f6116c = Collections.emptySet();

    /* JADX INFO: renamed from: d */
    public String f6117d = "";

    /* JADX INFO: renamed from: e */
    @Nullable
    public String f6118e = null;

    /* JADX INFO: renamed from: g */
    public boolean f6120g = false;

    /* JADX INFO: renamed from: i */
    public boolean f6122i = false;

    /* JADX INFO: renamed from: j */
    public int f6123j = -1;

    /* JADX INFO: renamed from: k */
    public int f6124k = -1;

    /* JADX INFO: renamed from: l */
    public int f6125l = -1;

    /* JADX INFO: renamed from: m */
    public int f6126m = -1;

    /* JADX INFO: renamed from: n */
    public int f6127n = -1;

    /* JADX INFO: renamed from: p */
    public int f6129p = -1;

    /* JADX INFO: renamed from: q */
    public boolean f6130q = false;

    /* JADX INFO: renamed from: b */
    public static int m2708b(int i, String str, @Nullable String str2, int i2) {
        if (str.isEmpty() || i == -1) {
            return i;
        }
        if (str.equals(str2)) {
            return i + i2;
        }
        return -1;
    }

    /* JADX INFO: renamed from: a */
    public int m2709a() {
        int i = this.f6125l;
        if (i == -1 && this.f6126m == -1) {
            return -1;
        }
        return (i == 1 ? 1 : 0) | (this.f6126m == 1 ? 2 : 0);
    }
}
