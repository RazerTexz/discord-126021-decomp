package h0.a.a;

import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: FieldWriter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class l extends k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v f3710b;
    public final int c;
    public final int d;
    public final int e;
    public int f;
    public int g;
    public a h;
    public a i;
    public a j;
    public a k;
    public b l;

    public l(v vVar, int i, String str, String str2, String str3, Object obj) {
        super(Opcodes.ASM7);
        this.f3710b = vVar;
        this.c = i;
        this.d = vVar.l(str);
        this.e = vVar.l(str2);
        if (str3 != null) {
            this.f = vVar.l(str3);
        }
        if (obj != null) {
            this.g = vVar.b(obj).a;
        }
    }

    public a a(String str, boolean z2) {
        c cVar = new c();
        cVar.j(this.f3710b.l(str));
        cVar.j(0);
        if (z2) {
            a aVar = new a(this.f3710b, true, cVar, this.h);
            this.h = aVar;
            return aVar;
        }
        a aVar2 = new a(this.f3710b, true, cVar, this.i);
        this.i = aVar2;
        return aVar2;
    }

    public a b(int i, x xVar, String str, boolean z2) {
        c cVar = new c();
        b.i.a.f.e.o.f.W0(i, cVar);
        x.a(xVar, cVar);
        cVar.j(this.f3710b.l(str));
        cVar.j(0);
        if (z2) {
            a aVar = new a(this.f3710b, true, cVar, this.j);
            this.j = aVar;
            return aVar;
        }
        a aVar2 = new a(this.f3710b, true, cVar, this.k);
        this.k = aVar2;
        return aVar2;
    }
}
