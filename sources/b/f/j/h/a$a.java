package b.f.j.h;

import android.graphics.Bitmap;
import b.f.j.j.i;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.decoder.DecodeException;
import java.util.Objects;

/* JADX INFO: compiled from: DefaultImageDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public class a$a implements b {
    public final /* synthetic */ a a;

    public a$a(a aVar) {
        this.a = aVar;
    }

    @Override // b.f.j.h.b
    public b.f.j.j.c a(b.f.j.j.e eVar, int i, i iVar, b.f.j.d.b bVar) {
        eVar.x();
        b.f.i.c cVar = eVar.l;
        if (cVar == b.f.i.b.a) {
            CloseableReference<Bitmap> closeableReferenceB = this.a.c.b(eVar, bVar.d, null, i, null);
            try {
                b.c.a.a0.d.g1(null, closeableReferenceB);
                eVar.x();
                int i2 = eVar.m;
                eVar.x();
                b.f.j.j.d dVar = new b.f.j.j.d(closeableReferenceB, iVar, i2, eVar.n);
                Boolean bool = Boolean.FALSE;
                if (b.f.j.j.c.j.contains("is_rounded")) {
                    dVar.k.put("is_rounded", bool);
                }
                return dVar;
            } finally {
                closeableReferenceB.close();
            }
        }
        if (cVar != b.f.i.b.c) {
            if (cVar != b.f.i.b.j) {
                if (cVar != b.f.i.c.a) {
                    return this.a.b(eVar, bVar);
                }
                throw new DecodeException("unknown image format", eVar);
            }
            b bVar2 = this.a.f588b;
            if (bVar2 != null) {
                return bVar2.a(eVar, i, iVar, bVar);
            }
            throw new DecodeException("Animated WebP support not set up!", eVar);
        }
        a aVar = this.a;
        Objects.requireNonNull(aVar);
        eVar.x();
        if (eVar.o != -1) {
            eVar.x();
            if (eVar.p != -1) {
                Objects.requireNonNull(bVar);
                b bVar3 = aVar.a;
                return bVar3 != null ? bVar3.a(eVar, i, iVar, bVar) : aVar.b(eVar, bVar);
            }
        }
        throw new DecodeException("image width or height is incorrect", eVar);
    }
}
