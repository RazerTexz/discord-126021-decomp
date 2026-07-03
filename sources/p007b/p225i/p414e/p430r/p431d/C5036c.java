package p007b.p225i.p414e.p430r.p431d;

import com.google.zxing.NotFoundException;
import p007b.p225i.p414e.C4956k;
import p007b.p225i.p414e.p418n.C4963b;

/* JADX INFO: renamed from: b.i.e.r.d.c */
/* JADX INFO: compiled from: BoundingBox.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C5036c {

    /* JADX INFO: renamed from: a */
    public final C4963b f13470a;

    /* JADX INFO: renamed from: b */
    public final C4956k f13471b;

    /* JADX INFO: renamed from: c */
    public final C4956k f13472c;

    /* JADX INFO: renamed from: d */
    public final C4956k f13473d;

    /* JADX INFO: renamed from: e */
    public final C4956k f13474e;

    /* JADX INFO: renamed from: f */
    public final int f13475f;

    /* JADX INFO: renamed from: g */
    public final int f13476g;

    /* JADX INFO: renamed from: h */
    public final int f13477h;

    /* JADX INFO: renamed from: i */
    public final int f13478i;

    public C5036c(C4963b c4963b, C4956k c4956k, C4956k c4956k2, C4956k c4956k3, C4956k c4956k4) throws NotFoundException {
        boolean z2 = c4956k == null || c4956k2 == null;
        boolean z3 = c4956k3 == null || c4956k4 == null;
        if (z2 && z3) {
            throw NotFoundException.f21665l;
        }
        if (z2) {
            c4956k = new C4956k(0.0f, c4956k3.f13208b);
            c4956k2 = new C4956k(0.0f, c4956k4.f13208b);
        } else if (z3) {
            int i = c4963b.f13229j;
            c4956k3 = new C4956k(i - 1, c4956k.f13208b);
            c4956k4 = new C4956k(i - 1, c4956k2.f13208b);
        }
        this.f13470a = c4963b;
        this.f13471b = c4956k;
        this.f13472c = c4956k2;
        this.f13473d = c4956k3;
        this.f13474e = c4956k4;
        this.f13475f = (int) Math.min(c4956k.f13207a, c4956k2.f13207a);
        this.f13476g = (int) Math.max(c4956k3.f13207a, c4956k4.f13207a);
        this.f13477h = (int) Math.min(c4956k.f13208b, c4956k3.f13208b);
        this.f13478i = (int) Math.max(c4956k2.f13208b, c4956k4.f13208b);
    }

    public C5036c(C5036c c5036c) {
        this.f13470a = c5036c.f13470a;
        this.f13471b = c5036c.f13471b;
        this.f13472c = c5036c.f13472c;
        this.f13473d = c5036c.f13473d;
        this.f13474e = c5036c.f13474e;
        this.f13475f = c5036c.f13475f;
        this.f13476g = c5036c.f13476g;
        this.f13477h = c5036c.f13477h;
        this.f13478i = c5036c.f13478i;
    }
}
