package b.i.a.c.b3.t;

import b.i.b.b.ImmutableSet2;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: b.i.a.c.b3.t.b, reason: use source file name */
/* JADX INFO: compiled from: TextEmphasis.java */
/* JADX INFO: loaded from: classes3.dex */
public final class TextEmphasis {
    public static final Pattern a = Pattern.compile("\\s+");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ImmutableSet2<String> f879b;
    public static final ImmutableSet2<String> c;
    public static final ImmutableSet2<String> d;
    public static final ImmutableSet2<String> e;
    public final int f;
    public final int g;
    public final int h;

    static {
        int i = ImmutableSet2.k;
        f879b = ImmutableSet2.l(2, "auto", "none");
        c = ImmutableSet2.r("dot", "sesame", "circle");
        d = ImmutableSet2.l(2, "filled", "open");
        e = ImmutableSet2.r("after", "before", "outside");
    }

    public TextEmphasis(int i, int i2, int i3) {
        this.f = i;
        this.g = i2;
        this.h = i3;
    }
}
