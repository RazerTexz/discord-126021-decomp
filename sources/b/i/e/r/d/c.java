package b.i.e.r.d;

import b.i.e.k;
import com.google.zxing.NotFoundException;

/* JADX INFO: compiled from: BoundingBox.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public final b.i.e.n.b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f1877b;
    public final k c;
    public final k d;
    public final k e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;

    public c(b.i.e.n.b bVar, k kVar, k kVar2, k kVar3, k kVar4) throws NotFoundException {
        boolean z2 = kVar == null || kVar2 == null;
        boolean z3 = kVar3 == null || kVar4 == null;
        if (z2 && z3) {
            throw NotFoundException.l;
        }
        if (z2) {
            kVar = new k(0.0f, kVar3.f1826b);
            kVar2 = new k(0.0f, kVar4.f1826b);
        } else if (z3) {
            int i = bVar.j;
            kVar3 = new k(i - 1, kVar.f1826b);
            kVar4 = new k(i - 1, kVar2.f1826b);
        }
        this.a = bVar;
        this.f1877b = kVar;
        this.c = kVar2;
        this.d = kVar3;
        this.e = kVar4;
        this.f = (int) Math.min(kVar.a, kVar2.a);
        this.g = (int) Math.max(kVar3.a, kVar4.a);
        this.h = (int) Math.min(kVar.f1826b, kVar3.f1826b);
        this.i = (int) Math.max(kVar2.f1826b, kVar4.f1826b);
    }

    public c(c cVar) {
        this.a = cVar.a;
        this.f1877b = cVar.f1877b;
        this.c = cVar.c;
        this.d = cVar.d;
        this.e = cVar.e;
        this.f = cVar.f;
        this.g = cVar.g;
        this.h = cVar.h;
        this.i = cVar.i;
    }
}
