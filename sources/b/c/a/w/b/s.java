package b.c.a.w.b;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: TrimPathContent.java */
/* JADX INFO: loaded from: classes.dex */
public class s implements c, b.c.a.w.c.a$b {
    public final boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<b.c.a.w.c.a$b> f391b = new ArrayList();
    public final int c;
    public final b.c.a.w.c.a<?, Float> d;
    public final b.c.a.w.c.a<?, Float> e;
    public final b.c.a.w.c.a<?, Float> f;

    public s(b.c.a.y.m.b bVar, b.c.a.y.l.p pVar) {
        this.a = pVar.f;
        this.c = pVar.f429b;
        b.c.a.w.c.a<Float, Float> aVarA = pVar.c.a();
        this.d = aVarA;
        b.c.a.w.c.a<Float, Float> aVarA2 = pVar.d.a();
        this.e = aVarA2;
        b.c.a.w.c.a<Float, Float> aVarA3 = pVar.e.a();
        this.f = aVarA3;
        bVar.e(aVarA);
        bVar.e(aVarA2);
        bVar.e(aVarA3);
        aVarA.a.add(this);
        aVarA2.a.add(this);
        aVarA3.a.add(this);
    }

    @Override // b.c.a.w.c.a$b
    public void a() {
        for (int i = 0; i < this.f391b.size(); i++) {
            this.f391b.get(i).a();
        }
    }

    @Override // b.c.a.w.b.c
    public void b(List<c> list, List<c> list2) {
    }
}
