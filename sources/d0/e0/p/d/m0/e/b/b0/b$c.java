package d0.e0.p.d.m0.e.b.b0;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.e.b.p$a;
import d0.e0.p.d.m0.e.b.p$b;

/* JADX INFO: compiled from: ReadKotlinClassHeaderAnnotationVisitor.java */
/* JADX INFO: loaded from: classes3.dex */
public class b$c implements p$a {
    public final /* synthetic */ b a;

    public b$c(b bVar, b$a b_a) {
        this.a = bVar;
    }

    public static /* synthetic */ void a(int i) {
        Object[] objArr = new Object[3];
        if (i == 1) {
            objArr[0] = "classLiteralValue";
        } else if (i == 7) {
            objArr[0] = "classId";
        } else if (i == 4) {
            objArr[0] = "enumClassId";
        } else if (i != 5) {
            objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
        } else {
            objArr[0] = "enumEntryName";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor";
        switch (i) {
            case 2:
                objArr[2] = "visitArray";
                break;
            case 3:
            case 4:
            case 5:
                objArr[2] = "visitEnum";
                break;
            case 6:
            case 7:
                objArr[2] = "visitAnnotation";
                break;
            default:
                objArr[2] = "visitClassLiteral";
                break;
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    @Override // d0.e0.p.d.m0.e.b.p$a
    public void visit(d0.e0.p.d.m0.g.e eVar, Object obj) {
        if (eVar == null) {
            return;
        }
        String strAsString = eVar.asString();
        if ("k".equals(strAsString)) {
            if (obj instanceof Integer) {
                this.a.k = a$a.getById(((Integer) obj).intValue());
                return;
            }
            return;
        }
        if ("mv".equals(strAsString)) {
            if (obj instanceof int[]) {
                this.a.c = (int[]) obj;
                return;
            }
            return;
        }
        if ("bv".equals(strAsString)) {
            if (obj instanceof int[]) {
                this.a.d = new d0.e0.p.d.m0.f.a0.b.c((int[]) obj);
                return;
            }
            return;
        }
        if ("xs".equals(strAsString)) {
            if (obj instanceof String) {
                this.a.e = (String) obj;
                return;
            }
            return;
        }
        if ("xi".equals(strAsString)) {
            if (obj instanceof Integer) {
                this.a.f = ((Integer) obj).intValue();
                return;
            }
            return;
        }
        if ("pn".equals(strAsString) && (obj instanceof String)) {
            this.a.g = (String) obj;
        }
    }

    @Override // d0.e0.p.d.m0.e.b.p$a
    public p$a visitAnnotation(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.g.a aVar) {
        if (eVar == null) {
            a(6);
            throw null;
        }
        if (aVar != null) {
            return null;
        }
        a(7);
        throw null;
    }

    @Override // d0.e0.p.d.m0.e.b.p$a
    public p$b visitArray(d0.e0.p.d.m0.g.e eVar) {
        if (eVar == null) {
            a(2);
            throw null;
        }
        String strAsString = eVar.asString();
        if ("d1".equals(strAsString)) {
            return new c(this);
        }
        if ("d2".equals(strAsString)) {
            return new d(this);
        }
        return null;
    }

    @Override // d0.e0.p.d.m0.e.b.p$a
    public void visitClassLiteral(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.k.v.f fVar) {
        if (eVar == null) {
            a(0);
            throw null;
        }
        if (fVar != null) {
            return;
        }
        a(1);
        throw null;
    }

    @Override // d0.e0.p.d.m0.e.b.p$a
    public void visitEnd() {
    }

    @Override // d0.e0.p.d.m0.e.b.p$a
    public void visitEnum(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.g.a aVar, d0.e0.p.d.m0.g.e eVar2) {
        if (eVar == null) {
            a(3);
            throw null;
        }
        if (aVar == null) {
            a(4);
            throw null;
        }
        if (eVar2 != null) {
            return;
        }
        a(5);
        throw null;
    }
}
