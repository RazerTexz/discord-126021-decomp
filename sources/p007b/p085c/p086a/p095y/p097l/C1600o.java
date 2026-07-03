package p007b.p085c.p086a.p095y.p097l;

import androidx.annotation.Nullable;
import java.util.List;
import p007b.p085c.p086a.C1511j;
import p007b.p085c.p086a.p091w.p092b.C1542r;
import p007b.p085c.p086a.p091w.p092b.InterfaceC1527c;
import p007b.p085c.p086a.p095y.p096k.C1572a;
import p007b.p085c.p086a.p095y.p096k.C1573b;
import p007b.p085c.p086a.p095y.p096k.C1575d;
import p007b.p085c.p086a.p095y.p098m.AbstractC1603b;

/* JADX INFO: renamed from: b.c.a.y.l.o */
/* JADX INFO: compiled from: ShapeStroke.java */
/* JADX INFO: loaded from: classes.dex */
public class C1600o implements InterfaceC1587b {

    /* JADX INFO: renamed from: a */
    public final String f2819a;

    /* JADX INFO: renamed from: b */
    @Nullable
    public final C1573b f2820b;

    /* JADX INFO: renamed from: c */
    public final List<C1573b> f2821c;

    /* JADX INFO: renamed from: d */
    public final C1572a f2822d;

    /* JADX INFO: renamed from: e */
    public final C1575d f2823e;

    /* JADX INFO: renamed from: f */
    public final C1573b f2824f;

    /* JADX INFO: renamed from: g */
    public final int f2825g;

    /* JADX INFO: renamed from: h */
    public final int f2826h;

    /* JADX INFO: renamed from: i */
    public final float f2827i;

    /* JADX INFO: renamed from: j */
    public final boolean f2828j;

    /* JADX WARN: Incorrect types in method signature: (Ljava/lang/String;Lb/c/a/y/k/b;Ljava/util/List<Lb/c/a/y/k/b;>;Lb/c/a/y/k/a;Lb/c/a/y/k/d;Lb/c/a/y/k/b;Ljava/lang/Object;Ljava/lang/Object;FZ)V */
    public C1600o(String str, @Nullable C1573b c1573b, List list, C1572a c1572a, C1575d c1575d, C1573b c1573b2, int i, int i2, float f, boolean z2) {
        this.f2819a = str;
        this.f2820b = c1573b;
        this.f2821c = list;
        this.f2822d = c1572a;
        this.f2823e = c1575d;
        this.f2824f = c1573b2;
        this.f2825g = i;
        this.f2826h = i2;
        this.f2827i = f;
        this.f2828j = z2;
    }

    @Override // p007b.p085c.p086a.p095y.p097l.InterfaceC1587b
    /* JADX INFO: renamed from: a */
    public InterfaceC1527c mo775a(C1511j c1511j, AbstractC1603b abstractC1603b) {
        return new C1542r(c1511j, abstractC1603b, this);
    }
}
