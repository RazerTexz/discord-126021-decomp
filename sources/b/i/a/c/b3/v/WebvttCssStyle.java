package b.i.a.c.b3.v;

import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: renamed from: b.i.a.c.b3.v.f, reason: use source file name */
/* JADX INFO: compiled from: WebvttCssStyle.java */
/* JADX INFO: loaded from: classes3.dex */
public final class WebvttCssStyle {

    @ColorInt
    public int f;
    public int h;
    public float o;
    public String a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f889b = "";
    public Set<String> c = Collections.emptySet();
    public String d = "";

    @Nullable
    public String e = null;
    public boolean g = false;
    public boolean i = false;
    public int j = -1;
    public int k = -1;
    public int l = -1;
    public int m = -1;
    public int n = -1;
    public int p = -1;
    public boolean q = false;

    public static int b(int i, String str, @Nullable String str2, int i2) {
        if (str.isEmpty() || i == -1) {
            return i;
        }
        if (str.equals(str2)) {
            return i + i2;
        }
        return -1;
    }

    public int a() {
        int i = this.l;
        if (i == -1 && this.m == -1) {
            return -1;
        }
        return (i == 1 ? 1 : 0) | (this.m == 1 ? 2 : 0);
    }
}
