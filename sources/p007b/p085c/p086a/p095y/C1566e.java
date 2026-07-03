package p007b.p085c.p086a.p095y;

import androidx.annotation.RestrictTo;
import java.util.List;
import p007b.p085c.p086a.p095y.p097l.C1598m;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.c.a.y.e */
/* JADX INFO: compiled from: FontCharacter.java */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class C1566e {

    /* JADX INFO: renamed from: a */
    public final List<C1598m> f2707a;

    /* JADX INFO: renamed from: b */
    public final char f2708b;

    /* JADX INFO: renamed from: c */
    public final double f2709c;

    /* JADX INFO: renamed from: d */
    public final String f2710d;

    /* JADX INFO: renamed from: e */
    public final String f2711e;

    public C1566e(List<C1598m> list, char c, double d, double d2, String str, String str2) {
        this.f2707a = list;
        this.f2708b = c;
        this.f2709c = d2;
        this.f2710d = str;
        this.f2711e = str2;
    }

    /* JADX INFO: renamed from: a */
    public static int m765a(char c, String str, String str2) {
        return str2.hashCode() + C1643a.m863m(str, (c + 0) * 31, 31);
    }

    public int hashCode() {
        return m765a(this.f2708b, this.f2711e, this.f2710d);
    }
}
