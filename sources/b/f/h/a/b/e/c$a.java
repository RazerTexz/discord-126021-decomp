package b.f.h.a.b.e;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;

/* JADX INFO: compiled from: DefaultBitmapFramePreparer.java */
/* JADX INFO: loaded from: classes.dex */
public class c$a implements Runnable {
    public final b.f.h.a.b.b j;
    public final b.f.h.a.a.a k;
    public final int l;
    public final int m;
    public final /* synthetic */ c n;

    public c$a(c cVar, b.f.h.a.a.a aVar, b.f.h.a.b.b bVar, int i, int i2) {
        this.n = cVar;
        this.k = aVar;
        this.j = bVar;
        this.l = i;
        this.m = i2;
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
    public final boolean a(int i, int i2) {
        CloseableReference closeableReferenceA;
        int i3 = 2;
        CloseableReference closeableReference = null;
        try {
            if (i2 == 1) {
                closeableReferenceA = this.j.a(i, this.k.i(), this.k.g());
            } else {
                if (i2 != 2) {
                    Class<CloseableReference> cls = CloseableReference.j;
                    return false;
                }
                try {
                    closeableReferenceA = this.n.a.a(this.k.i(), this.k.g(), this.n.c);
                    i3 = -1;
                } catch (RuntimeException e) {
                    b.f.d.e.a.l(c.class, "Failed to create frame bitmap", e);
                    Class<CloseableReference> cls2 = CloseableReference.j;
                    return false;
                }
            }
            boolean zB = b(i, closeableReferenceA, i2);
            if (closeableReferenceA != null) {
                closeableReferenceA.close();
            }
            return (zB || i3 == -1) ? zB : a(i, i3);
        } catch (Throwable th) {
            Class<CloseableReference> cls3 = CloseableReference.j;
            if (0 != 0) {
                closeableReference.close();
            }
            throw th;
        }
    }

    public final boolean b(int i, CloseableReference<Bitmap> closeableReference, int i2) {
        if (!CloseableReference.y(closeableReference)) {
            return false;
        }
        if (!((b.f.h.a.b.f.b) this.n.f530b).a(i, closeableReference.u())) {
            return false;
        }
        int i3 = b.f.d.e.a.a;
        synchronized (this.n.e) {
            this.j.b(this.l, closeableReference, i2);
        }
        return true;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.j.c(this.l)) {
                int i = b.f.d.e.a.a;
                synchronized (this.n.e) {
                    this.n.e.remove(this.m);
                }
                return;
            }
            if (a(this.l, 1)) {
                int i2 = b.f.d.e.a.a;
            } else {
                b.f.d.e.a.c(c.class, "Could not prepare frame %d.", Integer.valueOf(this.l));
            }
            synchronized (this.n.e) {
                this.n.e.remove(this.m);
            }
        } catch (Throwable th) {
            synchronized (this.n.e) {
                this.n.e.remove(this.m);
                throw th;
            }
        }
    }
}
