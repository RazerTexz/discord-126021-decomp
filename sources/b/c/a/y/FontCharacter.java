package b.c.a.y;

import androidx.annotation.RestrictTo;
import b.c.a.y.l.ShapeGroup;
import b.d.b.a.outline;
import java.util.List;

/* JADX INFO: renamed from: b.c.a.y.e, reason: use source file name */
/* JADX INFO: compiled from: FontCharacter.java */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class FontCharacter {
    public final List<ShapeGroup> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final char f407b;
    public final double c;
    public final String d;
    public final String e;

    public FontCharacter(List<ShapeGroup> list, char c, double d, double d2, String str, String str2) {
        this.a = list;
        this.f407b = c;
        this.c = d2;
        this.d = str;
        this.e = str2;
    }

    public static int a(char c, String str, String str2) {
        return str2.hashCode() + outline.m(str, (c + 0) * 31, 31);
    }

    public int hashCode() {
        return a(this.f407b, this.e, this.d);
    }
}
