package p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.p542b0;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11467u0;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.C11486a0;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11655p;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.p542b0.C11636a;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b.C11670c;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b.C11673f;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11712a;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11814f;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.b0.b */
/* JADX INFO: compiled from: ReadKotlinClassHeaderAnnotationVisitor.java */
/* JADX INFO: loaded from: classes3.dex */
public class C11637b implements InterfaceC11655p.c {

    /* JADX INFO: renamed from: a */
    public static final boolean f23567a = "true".equals(System.getProperty("kotlin.ignore.old.metadata"));

    /* JADX INFO: renamed from: b */
    public static final Map<C11712a, C11636a.a> f23568b;

    /* JADX INFO: renamed from: c */
    public int[] f23569c = null;

    /* JADX INFO: renamed from: d */
    public C11670c f23570d = null;

    /* JADX INFO: renamed from: e */
    public String f23571e = null;

    /* JADX INFO: renamed from: f */
    public int f23572f = 0;

    /* JADX INFO: renamed from: g */
    public String f23573g = null;

    /* JADX INFO: renamed from: h */
    public String[] f23574h = null;

    /* JADX INFO: renamed from: i */
    public String[] f23575i = null;

    /* JADX INFO: renamed from: j */
    public String[] f23576j = null;

    /* JADX INFO: renamed from: k */
    public C11636a.a f23577k = null;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.b0.b$b */
    /* JADX INFO: compiled from: ReadKotlinClassHeaderAnnotationVisitor.java */
    public static abstract class b implements InterfaceC11655p.b {

        /* JADX INFO: renamed from: a */
        public final List<String> f23578a = new ArrayList();

        /* JADX INFO: renamed from: a */
        public static /* synthetic */ void m9540a(int i) {
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

        /* JADX INFO: renamed from: b */
        public abstract void mo9541b(String[] strArr);

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11655p.b
        public void visit(Object obj) {
            if (obj instanceof String) {
                this.f23578a.add((String) obj);
            }
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11655p.b
        public void visitClassLiteral(C11814f c11814f) {
            if (c11814f != null) {
                return;
            }
            m9540a(2);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11655p.b
        public void visitEnd() {
            mo9541b((String[]) this.f23578a.toArray(new String[0]));
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11655p.b
        public void visitEnum(C11712a c11712a, C11716e c11716e) {
            if (c11712a == null) {
                m9540a(0);
                throw null;
            }
            if (c11716e != null) {
                return;
            }
            m9540a(1);
            throw null;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.b0.b$c */
    /* JADX INFO: compiled from: ReadKotlinClassHeaderAnnotationVisitor.java */
    public class c implements InterfaceC11655p.a {
        public c(a aVar) {
        }

        /* JADX INFO: renamed from: a */
        public static /* synthetic */ void m9542a(int i) {
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

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11655p.a
        public void visit(C11716e c11716e, Object obj) {
            if (c11716e == null) {
                return;
            }
            String strAsString = c11716e.asString();
            if ("k".equals(strAsString)) {
                if (obj instanceof Integer) {
                    C11637b.this.f23577k = C11636a.a.getById(((Integer) obj).intValue());
                    return;
                }
                return;
            }
            if ("mv".equals(strAsString)) {
                if (obj instanceof int[]) {
                    C11637b.this.f23569c = (int[]) obj;
                    return;
                }
                return;
            }
            if ("bv".equals(strAsString)) {
                if (obj instanceof int[]) {
                    C11637b.this.f23570d = new C11670c((int[]) obj);
                    return;
                }
                return;
            }
            if ("xs".equals(strAsString)) {
                if (obj instanceof String) {
                    C11637b.this.f23571e = (String) obj;
                    return;
                }
                return;
            }
            if ("xi".equals(strAsString)) {
                if (obj instanceof Integer) {
                    C11637b.this.f23572f = ((Integer) obj).intValue();
                    return;
                }
                return;
            }
            if ("pn".equals(strAsString) && (obj instanceof String)) {
                C11637b.this.f23573g = (String) obj;
            }
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11655p.a
        public InterfaceC11655p.a visitAnnotation(C11716e c11716e, C11712a c11712a) {
            if (c11716e == null) {
                m9542a(6);
                throw null;
            }
            if (c11712a != null) {
                return null;
            }
            m9542a(7);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11655p.a
        public InterfaceC11655p.b visitArray(C11716e c11716e) {
            if (c11716e == null) {
                m9542a(2);
                throw null;
            }
            String strAsString = c11716e.asString();
            if ("d1".equals(strAsString)) {
                return new C11638c(this);
            }
            if ("d2".equals(strAsString)) {
                return new C11639d(this);
            }
            return null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11655p.a
        public void visitClassLiteral(C11716e c11716e, C11814f c11814f) {
            if (c11716e == null) {
                m9542a(0);
                throw null;
            }
            if (c11814f != null) {
                return;
            }
            m9542a(1);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11655p.a
        public void visitEnd() {
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11655p.a
        public void visitEnum(C11716e c11716e, C11712a c11712a, C11716e c11716e2) {
            if (c11716e == null) {
                m9542a(3);
                throw null;
            }
            if (c11712a == null) {
                m9542a(4);
                throw null;
            }
            if (c11716e2 != null) {
                return;
            }
            m9542a(5);
            throw null;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.b0.b$d */
    /* JADX INFO: compiled from: ReadKotlinClassHeaderAnnotationVisitor.java */
    public class d implements InterfaceC11655p.a {
        public d(a aVar) {
        }

        /* JADX INFO: renamed from: a */
        public static /* synthetic */ void m9543a(int i) {
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
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor";
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

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11655p.a
        public void visit(C11716e c11716e, Object obj) {
            if (c11716e == null) {
                return;
            }
            String strAsString = c11716e.asString();
            if (!"version".equals(strAsString)) {
                if ("multifileClassName".equals(strAsString)) {
                    C11637b.this.f23571e = obj instanceof String ? (String) obj : null;
                    return;
                }
                return;
            }
            if (obj instanceof int[]) {
                C11637b c11637b = C11637b.this;
                int[] iArr = (int[]) obj;
                c11637b.f23569c = iArr;
                if (c11637b.f23570d == null) {
                    c11637b.f23570d = new C11670c(iArr);
                }
            }
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11655p.a
        public InterfaceC11655p.a visitAnnotation(C11716e c11716e, C11712a c11712a) {
            if (c11716e == null) {
                m9543a(6);
                throw null;
            }
            if (c11712a != null) {
                return null;
            }
            m9543a(7);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11655p.a
        public InterfaceC11655p.b visitArray(C11716e c11716e) {
            if (c11716e == null) {
                m9543a(2);
                throw null;
            }
            String strAsString = c11716e.asString();
            if ("data".equals(strAsString) || "filePartClassNames".equals(strAsString)) {
                return new C11640e(this);
            }
            if ("strings".equals(strAsString)) {
                return new C11641f(this);
            }
            return null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11655p.a
        public void visitClassLiteral(C11716e c11716e, C11814f c11814f) {
            if (c11716e == null) {
                m9543a(0);
                throw null;
            }
            if (c11814f != null) {
                return;
            }
            m9543a(1);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11655p.a
        public void visitEnd() {
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11655p.a
        public void visitEnum(C11716e c11716e, C11712a c11712a, C11716e c11716e2) {
            if (c11716e == null) {
                m9543a(3);
                throw null;
            }
            if (c11712a == null) {
                m9543a(4);
                throw null;
            }
            if (c11716e2 != null) {
                return;
            }
            m9543a(5);
            throw null;
        }
    }

    static {
        HashMap map = new HashMap();
        f23568b = map;
        map.put(C11712a.topLevel(new C11713b("kotlin.jvm.internal.KotlinClass")), C11636a.a.CLASS);
        map.put(C11712a.topLevel(new C11713b("kotlin.jvm.internal.KotlinFileFacade")), C11636a.a.FILE_FACADE);
        map.put(C11712a.topLevel(new C11713b("kotlin.jvm.internal.KotlinMultifileClass")), C11636a.a.MULTIFILE_CLASS);
        map.put(C11712a.topLevel(new C11713b("kotlin.jvm.internal.KotlinMultifileClassPart")), C11636a.a.MULTIFILE_CLASS_PART);
        map.put(C11712a.topLevel(new C11713b("kotlin.jvm.internal.KotlinSyntheticClass")), C11636a.a.SYNTHETIC_CLASS);
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m9539a(int i) {
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

    public C11636a createHeader() {
        if (this.f23577k == null || this.f23569c == null) {
            return null;
        }
        boolean z2 = true;
        C11673f c11673f = new C11673f(this.f23569c, (this.f23572f & 8) != 0);
        if (c11673f.isCompatible()) {
            C11636a.a aVar = this.f23577k;
            if (aVar != C11636a.a.CLASS && aVar != C11636a.a.FILE_FACADE && aVar != C11636a.a.MULTIFILE_CLASS_PART) {
                z2 = false;
            }
            if (z2 && this.f23574h == null) {
                return null;
            }
        } else {
            this.f23576j = this.f23574h;
            this.f23574h = null;
        }
        C11636a.a aVar2 = this.f23577k;
        C11670c c11670c = this.f23570d;
        if (c11670c == null) {
            c11670c = C11670c.f23703f;
        }
        return new C11636a(aVar2, c11673f, c11670c, this.f23574h, this.f23576j, this.f23575i, this.f23571e, this.f23572f, this.f23573g);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11655p.c
    public InterfaceC11655p.a visitAnnotation(C11712a c11712a, InterfaceC11467u0 interfaceC11467u0) {
        C11636a.a aVar;
        if (c11712a == null) {
            m9539a(0);
            throw null;
        }
        if (interfaceC11467u0 == null) {
            m9539a(1);
            throw null;
        }
        if (c11712a.asSingleFqName().equals(C11486a0.f23147a)) {
            return new c(null);
        }
        if (f23567a || this.f23577k != null || (aVar = f23568b.get(c11712a)) == null) {
            return null;
        }
        this.f23577k = aVar;
        return new d(null);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11655p.c
    public void visitEnd() {
    }
}
