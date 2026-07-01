package d0.e0.p.d.m0.e.b.b0;

import d0.e0.p.d.m0.c.u0;
import d0.e0.p.d.m0.e.a.a0;
import d0.e0.p.d.m0.e.b.p$a;
import d0.e0.p.d.m0.e.b.p$c;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: ReadKotlinClassHeaderAnnotationVisitor.java */
/* JADX INFO: loaded from: classes3.dex */
public class b implements p$c {
    public static final boolean a = "true".equals(System.getProperty("kotlin.ignore.old.metadata"));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<d0.e0.p.d.m0.g.a, a$a> f3368b;
    public int[] c = null;
    public d0.e0.p.d.m0.f.a0.b.c d = null;
    public String e = null;
    public int f = 0;
    public String g = null;
    public String[] h = null;
    public String[] i = null;
    public String[] j = null;
    public a$a k = null;

    static {
        HashMap map = new HashMap();
        f3368b = map;
        map.put(d0.e0.p.d.m0.g.a.topLevel(new d0.e0.p.d.m0.g.b("kotlin.jvm.internal.KotlinClass")), a$a.CLASS);
        map.put(d0.e0.p.d.m0.g.a.topLevel(new d0.e0.p.d.m0.g.b("kotlin.jvm.internal.KotlinFileFacade")), a$a.FILE_FACADE);
        map.put(d0.e0.p.d.m0.g.a.topLevel(new d0.e0.p.d.m0.g.b("kotlin.jvm.internal.KotlinMultifileClass")), a$a.MULTIFILE_CLASS);
        map.put(d0.e0.p.d.m0.g.a.topLevel(new d0.e0.p.d.m0.g.b("kotlin.jvm.internal.KotlinMultifileClassPart")), a$a.MULTIFILE_CLASS_PART);
        map.put(d0.e0.p.d.m0.g.a.topLevel(new d0.e0.p.d.m0.g.b("kotlin.jvm.internal.KotlinSyntheticClass")), a$a.SYNTHETIC_CLASS);
    }

    public static /* synthetic */ void a(int i) {
        Object[] objArr = new Object[3];
        if (i != 1) {
            objArr[0] = "classId";
        } else {
            objArr[0] = "source";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor";
        objArr[2] = "visitAnnotation";
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public a createHeader() {
        if (this.k == null || this.c == null) {
            return null;
        }
        boolean z2 = true;
        d0.e0.p.d.m0.f.a0.b.f fVar = new d0.e0.p.d.m0.f.a0.b.f(this.c, (this.f & 8) != 0);
        if (fVar.isCompatible()) {
            a$a a_a = this.k;
            if (a_a != a$a.CLASS && a_a != a$a.FILE_FACADE && a_a != a$a.MULTIFILE_CLASS_PART) {
                z2 = false;
            }
            if (z2 && this.h == null) {
                return null;
            }
        } else {
            this.j = this.h;
            this.h = null;
        }
        a$a a_a2 = this.k;
        d0.e0.p.d.m0.f.a0.b.c cVar = this.d;
        if (cVar == null) {
            cVar = d0.e0.p.d.m0.f.a0.b.c.f;
        }
        return new a(a_a2, fVar, cVar, this.h, this.j, this.i, this.e, this.f, this.g);
    }

    @Override // d0.e0.p.d.m0.e.b.p$c
    public p$a visitAnnotation(d0.e0.p.d.m0.g.a aVar, u0 u0Var) {
        a$a a_a;
        if (aVar == null) {
            a(0);
            throw null;
        }
        if (u0Var == null) {
            a(1);
            throw null;
        }
        if (aVar.asSingleFqName().equals(a0.a)) {
            return new b$c(this, null);
        }
        if (a || this.k != null || (a_a = f3368b.get(aVar)) == null) {
            return null;
        }
        this.k = a_a;
        return new b$d(this, null);
    }

    @Override // d0.e0.p.d.m0.e.b.p$c
    public void visitEnd() {
    }
}
