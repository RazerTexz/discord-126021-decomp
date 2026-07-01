package b.f.j.p;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.memory.MemoryPooledByteBufferOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;

/* JADX INFO: compiled from: PartialDiskCacheProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class r0$a extends p<b.f.j.j.e, b.f.j.j.e> {
    public final b.f.j.c.f c;
    public final CacheKey d;
    public final b.f.d.g.g e;
    public final b.f.d.g.a f;
    public final b.f.j.j.e g;
    public final boolean h;

    public r0$a(l lVar, b.f.j.c.f fVar, CacheKey cacheKey, b.f.d.g.g gVar, b.f.d.g.a aVar, b.f.j.j.e eVar, boolean z2, p0 p0Var) {
        super(lVar);
        this.c = fVar;
        this.d = cacheKey;
        this.e = gVar;
        this.f = aVar;
        this.g = eVar;
        this.h = z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [b.f.j.c.f] */
    /* JADX WARN: Type inference failed for: r3v0, types: [b.f.j.p.p, b.f.j.p.r0$a] */
    /* JADX WARN: Type inference failed for: r4v1, types: [b.f.j.j.e, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v2, types: [b.f.j.j.e] */
    /* JADX WARN: Type inference failed for: r4v5, types: [b.f.j.c.f, java.lang.Object] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // b.f.j.p.b
    public void i(Object obj, int i) {
        ?? r4 = (b.f.j.j.e) obj;
        if (b.f(i)) {
            return;
        }
        b.f.j.j.e eVar = this.g;
        if (eVar != null && r4 != 0) {
            try {
                if (r4.f590s != null) {
                    try {
                        p(o(eVar, r4));
                    } catch (IOException e) {
                        b.f.d.e.a.f("PartialDiskCacheProducer", "Error while merging image data", e);
                        this.f632b.c(e);
                    }
                    r4.close();
                    this.g.close();
                    r4 = this.c;
                    CacheKey cacheKey = this.d;
                    Objects.requireNonNull(r4);
                    Objects.requireNonNull(cacheKey);
                    r4.f.c(cacheKey);
                    try {
                        z.g.a(new b.f.j.c.g(r4, null, cacheKey), r4.e);
                        return;
                    } catch (Exception e2) {
                        b.f.d.e.a.n(b.f.j.c.f.class, e2, "Failed to schedule disk-cache remove for %s", cacheKey.b());
                        z.g.c(e2);
                        return;
                    }
                }
            } catch (Throwable th) {
                r4.close();
                this.g.close();
                throw th;
            }
        }
        if (this.h && b.m(i, 8) && b.e(i) && r4 != 0) {
            r4.x();
            if (r4.l != b.f.i.c.a) {
                this.c.f(this.d, r4);
                this.f632b.b(r4, i);
                return;
            }
        }
        this.f632b.b(r4, i);
    }

    public final void n(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
        byte[] bArr = this.f.get(16384);
        int i2 = i;
        while (i2 > 0) {
            try {
                int i3 = inputStream.read(bArr, 0, Math.min(16384, i2));
                if (i3 < 0) {
                    break;
                } else if (i3 > 0) {
                    outputStream.write(bArr, 0, i3);
                    i2 -= i3;
                }
            } catch (Throwable th) {
                this.f.release(bArr);
                throw th;
            }
        }
        this.f.release(bArr);
        if (i2 > 0) {
            throw new IOException(String.format(null, "Failed to read %d bytes - finished %d short", Integer.valueOf(i), Integer.valueOf(i2)));
        }
    }

    public final b.f.d.g.i o(b.f.j.j.e eVar, b.f.j.j.e eVar2) throws IOException {
        b.f.j.d.a aVar = eVar2.f590s;
        Objects.requireNonNull(aVar);
        int i = aVar.a;
        b.f.d.g.i iVarE = this.e.e(eVar2.n() + i);
        n(eVar.f(), iVarE, i);
        n(eVar2.f(), iVarE, eVar2.n());
        return iVarE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [b.f.j.j.e] */
    /* JADX WARN: Type inference failed for: r1v3, types: [b.f.j.j.e, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void p(b.f.d.g.i iVar) throws Throwable {
        ?? eVar;
        Throwable th;
        CloseableReference closeableReferenceA = CloseableReference.A(((MemoryPooledByteBufferOutputStream) iVar).b());
        try {
            eVar = new b.f.j.j.e(closeableReferenceA);
            try {
                eVar.q();
                this.f632b.b((O) eVar, 1);
                eVar.close();
                if (closeableReferenceA != null) {
                    closeableReferenceA.close();
                }
            } catch (Throwable th2) {
                th = th2;
                if (eVar != null) {
                    eVar.close();
                }
                if (closeableReferenceA != null) {
                    closeableReferenceA.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            eVar = null;
            th = th3;
        }
    }
}
