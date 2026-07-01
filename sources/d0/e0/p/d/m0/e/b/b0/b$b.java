package d0.e0.p.d.m0.e.b.b0;

import d0.e0.p.d.m0.e.b.p$b;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ReadKotlinClassHeaderAnnotationVisitor.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b$b implements p$b {
    public final List<String> a = new ArrayList();

    public static /* synthetic */ void a(int i) {
        Object[] objArr = new Object[3];
        if (i == 1) {
            objArr[0] = "enumEntryName";
        } else if (i != 2) {
            objArr[0] = "enumClassId";
        } else {
            objArr[0] = "classLiteralValue";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$CollectStringArrayAnnotationVisitor";
        if (i != 2) {
            objArr[2] = "visitEnum";
        } else {
            objArr[2] = "visitClassLiteral";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public abstract void b(String[] strArr);

    @Override // d0.e0.p.d.m0.e.b.p$b
    public void visit(Object obj) {
        if (obj instanceof String) {
            this.a.add((String) obj);
        }
    }

    @Override // d0.e0.p.d.m0.e.b.p$b
    public void visitClassLiteral(d0.e0.p.d.m0.k.v.f fVar) {
        if (fVar != null) {
            return;
        }
        a(2);
        throw null;
    }

    @Override // d0.e0.p.d.m0.e.b.p$b
    public void visitEnd() {
        b((String[]) this.a.toArray(new String[0]));
    }

    @Override // d0.e0.p.d.m0.e.b.p$b
    public void visitEnum(d0.e0.p.d.m0.g.a aVar, d0.e0.p.d.m0.g.e eVar) {
        if (aVar == null) {
            a(0);
            throw null;
        }
        if (eVar != null) {
            return;
        }
        a(1);
        throw null;
    }
}
