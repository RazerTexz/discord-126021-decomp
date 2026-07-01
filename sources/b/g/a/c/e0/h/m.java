package b.g.a.c.e0.h;

import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: TypeSerializerBase.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class m extends b.g.a.c.e0.g {
    public final b.g.a.c.e0.e a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.g.a.c.d f699b;

    public m(b.g.a.c.e0.e eVar, b.g.a.c.d dVar) {
        this.a = eVar;
        this.f699b = dVar;
    }

    @Override // b.g.a.c.e0.g
    public String b() {
        return null;
    }

    @Override // b.g.a.c.e0.g
    public b.g.a.b.s.b e(b.g.a.b.d dVar, b.g.a.b.s.b bVar) throws IOException {
        if (bVar.c == null) {
            Object obj = bVar.a;
            Class<?> cls = bVar.f675b;
            bVar.c = cls == null ? this.a.a(obj) : this.a.c(obj, cls);
        }
        Objects.requireNonNull(dVar);
        Object obj2 = bVar.c;
        b.g.a.b.h hVar = bVar.f;
        String strValueOf = obj2 instanceof String ? (String) obj2 : String.valueOf(obj2);
        bVar.g = true;
        int i = bVar.e;
        b.g.a.b.h hVar2 = b.g.a.b.h.START_OBJECT;
        if (hVar != hVar2) {
            b.c.a.y.b.j(i);
            if (i == 3 || i == 4) {
                bVar.e = 1;
                i = 1;
            }
        }
        int iH = b.c.a.y.b.h(i);
        if (iH != 1) {
            if (iH == 2) {
                dVar.d0(bVar.a);
                dVar.y(bVar.d);
                dVar.j0(strValueOf);
            } else if (iH != 3 && iH != 4) {
                dVar.W();
                dVar.j0(strValueOf);
            }
            return bVar;
        }
        dVar.c0();
        dVar.y(strValueOf);
        if (hVar == hVar2) {
            dVar.d0(bVar.a);
        } else if (hVar == b.g.a.b.h.START_ARRAY) {
            dVar.W();
        }
        return bVar;
    }

    @Override // b.g.a.c.e0.g
    public b.g.a.b.s.b f(b.g.a.b.d dVar, b.g.a.b.s.b bVar) throws IOException {
        Objects.requireNonNull(dVar);
        b.g.a.b.h hVar = bVar.f;
        if (hVar == b.g.a.b.h.START_OBJECT) {
            dVar.u();
        } else if (hVar == b.g.a.b.h.START_ARRAY) {
            dVar.t();
        }
        if (bVar.g) {
            int iH = b.c.a.y.b.h(bVar.e);
            if (iH == 0) {
                dVar.t();
            } else if (iH != 2 && iH != 3) {
                if (iH != 4) {
                    dVar.u();
                } else {
                    Object obj = bVar.c;
                    String strValueOf = obj instanceof String ? (String) obj : String.valueOf(obj);
                    dVar.y(bVar.d);
                    dVar.j0(strValueOf);
                }
            }
        }
        return bVar;
    }
}
