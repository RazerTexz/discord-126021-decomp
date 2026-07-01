package b.f.j.h;

import android.graphics.Bitmap;
import b.f.j.j.h;
import b.f.j.j.i;
import com.facebook.common.references.CloseableReference;
import java.io.InputStream;
import java.util.Objects;

/* JADX INFO: compiled from: DefaultImageDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements b {
    public final b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f588b;
    public final b.f.j.n.d c;
    public final b d = new a$a(this);

    public a(b bVar, b bVar2, b.f.j.n.d dVar) {
        this.a = bVar;
        this.f588b = bVar2;
        this.c = dVar;
    }

    @Override // b.f.j.h.b
    public b.f.j.j.c a(b.f.j.j.e eVar, int i, i iVar, b.f.j.d.b bVar) {
        InputStream inputStreamE;
        Objects.requireNonNull(bVar);
        eVar.x();
        b.f.i.c cVar = eVar.l;
        if ((cVar == null || cVar == b.f.i.c.a) && (inputStreamE = eVar.e()) != null) {
            eVar.l = b.f.i.d.b(inputStreamE);
        }
        return this.d.a(eVar, i, iVar, bVar);
    }

    public b.f.j.j.d b(b.f.j.j.e eVar, b.f.j.d.b bVar) {
        CloseableReference<Bitmap> closeableReferenceA = this.c.a(eVar, bVar.d, null, null);
        try {
            b.c.a.a0.d.g1(null, closeableReferenceA);
            i iVar = h.a;
            eVar.x();
            int i = eVar.m;
            eVar.x();
            b.f.j.j.d dVar = new b.f.j.j.d(closeableReferenceA, iVar, i, eVar.n);
            Boolean bool = Boolean.FALSE;
            if (b.f.j.j.c.j.contains("is_rounded")) {
                dVar.k.put("is_rounded", bool);
            }
            return dVar;
        } finally {
            closeableReferenceA.close();
        }
    }
}
