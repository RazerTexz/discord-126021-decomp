package b.f.j.p;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.CloseableReference$c;
import com.facebook.common.util.ExceptionWithNoStacktrace;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: DecodeProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class n$c extends p<b.f.j.j.e, CloseableReference<b.f.j.j.c>> {
    public final x0 c;
    public final z0 d;
    public final b.f.j.d.b e;
    public boolean f;
    public final c0 g;
    public final /* synthetic */ n h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n$c(n nVar, l<CloseableReference<b.f.j.j.c>> lVar, x0 x0Var, boolean z2, int i) {
        super(lVar);
        this.h = nVar;
        this.c = x0Var;
        this.d = x0Var.o();
        b.f.j.d.b bVar = x0Var.e().i;
        this.e = bVar;
        this.f = false;
        this.g = new c0(nVar.f626b, new n$c$a(this, nVar, x0Var, i), bVar.f564b);
        x0Var.f(new n$c$b(this, nVar, z2));
    }

    @Override // b.f.j.p.p, b.f.j.p.b
    public void g() {
        q();
    }

    @Override // b.f.j.p.p, b.f.j.p.b
    public void h(Throwable th) {
        r(th);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0034 A[Catch: all -> 0x0056, TRY_LEAVE, TryCatch #0 {all -> 0x0056, blocks: (B:3:0x0002, B:7:0x000e, B:8:0x001e, B:10:0x0024, B:11:0x0034, B:15:0x003f, B:18:0x0047, B:20:0x004f), top: B:26:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:14:0x003e  */
    /* JADX WARN: Code duplicated, block: B:20:0x004f A[Catch: all -> 0x0056, TRY_LEAVE, TryCatch #0 {all -> 0x0056, blocks: (B:3:0x0002, B:7:0x000e, B:8:0x001e, B:10:0x0024, B:11:0x0034, B:15:0x003f, B:18:0x0047, B:20:0x004f), top: B:26:0x0002 }] */
    @Override // b.f.j.p.b
    public void i(Object obj, int i) {
        b.f.j.j.e eVar = (b.f.j.j.e) obj;
        try {
            b.f.j.r.b.b();
            boolean zE = b.e(i);
            if (zE) {
                if (eVar == null) {
                    ExceptionWithNoStacktrace exceptionWithNoStacktrace = new ExceptionWithNoStacktrace("Encoded image is null.");
                    u(true);
                    this.f632b.c(exceptionWithNoStacktrace);
                } else if (!eVar.t()) {
                    ExceptionWithNoStacktrace exceptionWithNoStacktrace2 = new ExceptionWithNoStacktrace("Encoded image is not valid.");
                    u(true);
                    this.f632b.c(exceptionWithNoStacktrace2);
                } else if (w(eVar, i)) {
                    boolean zM = b.m(i, 4);
                    if (zE) {
                        this.g.d();
                    } else {
                        this.g.d();
                    }
                }
            } else if (w(eVar, i)) {
                boolean zM2 = b.m(i, 4);
                if (zE || zM2 || this.c.p()) {
                    this.g.d();
                }
            }
        } finally {
            b.f.j.r.b.b();
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // b.f.j.p.p, b.f.j.p.b
    public void j(float f) {
        this.f632b.a(f * 0.99f);
    }

    public final Map<String, String> n(b.f.j.j.c cVar, long j, b.f.j.j.i iVar, boolean z2, String str, String str2, String str3, String str4) {
        if (!this.d.g(this.c, "DecodeProducer")) {
            return null;
        }
        String strValueOf = String.valueOf(j);
        String strValueOf2 = String.valueOf(((b.f.j.j.h) iVar).c);
        String strValueOf3 = String.valueOf(z2);
        if (!(cVar instanceof b.f.j.j.d)) {
            HashMap map = new HashMap(7);
            map.put("queueTime", strValueOf);
            map.put("hasGoodQuality", strValueOf2);
            map.put("isFinal", strValueOf3);
            map.put("encodedImageSize", str2);
            map.put("imageFormat", str);
            map.put("requestedImageSize", str3);
            map.put("sampleSize", str4);
            return new b.f.d.d.f(map);
        }
        Bitmap bitmap = ((b.f.j.j.d) cVar).m;
        Objects.requireNonNull(bitmap);
        String str5 = bitmap.getWidth() + "x" + bitmap.getHeight();
        HashMap map2 = new HashMap(8);
        map2.put("bitmapSize", str5);
        map2.put("queueTime", strValueOf);
        map2.put("hasGoodQuality", strValueOf2);
        map2.put("isFinal", strValueOf3);
        map2.put("encodedImageSize", str2);
        map2.put("imageFormat", str);
        map2.put("requestedImageSize", str3);
        map2.put("sampleSize", str4);
        map2.put("byteCount", bitmap.getByteCount() + "");
        return new b.f.d.d.f(map2);
    }

    public abstract int o(b.f.j.j.e eVar);

    public abstract b.f.j.j.i p();

    public final void q() {
        u(true);
        this.f632b.d();
    }

    public final void r(Throwable th) {
        u(true);
        this.f632b.c(th);
    }

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
    public final void s(b.f.j.j.c cVar, int i) {
        CloseableReference$c closeableReference$c = this.h.j.a;
        Class<CloseableReference> cls = CloseableReference.j;
        CloseableReference closeableReferenceI = null;
        if (cVar != null) {
            closeableReferenceI = CloseableReference.I(cVar, CloseableReference.l, closeableReference$c, closeableReference$c.b() ? new Throwable() : null);
        }
        try {
            u(b.e(i));
            this.f632b.b(closeableReferenceI, i);
        } finally {
            if (closeableReferenceI != null) {
                closeableReferenceI.close();
            }
        }
    }

    public final b.f.j.j.c t(b.f.j.j.e eVar, int i, b.f.j.j.i iVar) {
        n nVar = this.h;
        boolean z2 = nVar.k != null && nVar.l.get().booleanValue();
        try {
            return this.h.c.a(eVar, i, iVar, this.e);
        } catch (OutOfMemoryError e) {
            if (!z2) {
                throw e;
            }
            this.h.k.run();
            System.gc();
            return this.h.c.a(eVar, i, iVar, this.e);
        }
    }

    public final void u(boolean z2) {
        synchronized (this) {
            if (z2) {
                if (!this.f) {
                    this.f632b.a(1.0f);
                    this.f = true;
                    this.g.a();
                }
            }
        }
    }

    public final void v(b.f.j.j.e eVar, b.f.j.j.c cVar) {
        x0 x0Var = this.c;
        eVar.x();
        x0Var.d("encoded_width", Integer.valueOf(eVar.o));
        x0 x0Var2 = this.c;
        eVar.x();
        x0Var2.d("encoded_height", Integer.valueOf(eVar.p));
        this.c.d("encoded_size", Integer.valueOf(eVar.n()));
        if (cVar instanceof b.f.j.j.b) {
            Bitmap bitmapF = ((b.f.j.j.b) cVar).f();
            this.c.d("bitmap_config", String.valueOf(bitmapF == null ? null : bitmapF.getConfig()));
        }
        if (cVar != null) {
            cVar.e(this.c.a());
        }
    }

    public abstract boolean w(b.f.j.j.e eVar, int i);
}
