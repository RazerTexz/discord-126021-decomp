package d0.e0.p.d.m0.e.b.b0;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.SourceElement;
import d0.e0.p.d.m0.e.a.JvmAnnotationNames;
import d0.e0.p.d.m0.e.b.KotlinJvmBinaryClass;
import d0.e0.p.d.m0.e.b.b0.KotlinClassHeader;
import d0.e0.p.d.m0.f.a0.b.JvmBytecodeBinaryVersion;
import d0.e0.p.d.m0.f.a0.b.JvmMetadataVersion;
import d0.e0.p.d.m0.g.ClassId;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.k.v.ClassLiteralValue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.b0.b, reason: use source file name */
/* JADX INFO: compiled from: ReadKotlinClassHeaderAnnotationVisitor.java */
/* JADX INFO: loaded from: classes3.dex */
public class ReadKotlinClassHeaderAnnotationVisitor implements KotlinJvmBinaryClass.c {
    public static final boolean a = "true".equals(System.getProperty("kotlin.ignore.old.metadata"));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<ClassId, KotlinClassHeader.a> f3368b;
    public int[] c = null;
    public JvmBytecodeBinaryVersion d = null;
    public String e = null;
    public int f = 0;
    public String g = null;
    public String[] h = null;
    public String[] i = null;
    public String[] j = null;
    public KotlinClassHeader.a k = null;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.b0.b$b */
    /* JADX INFO: compiled from: ReadKotlinClassHeaderAnnotationVisitor.java */
    public static abstract class b implements KotlinJvmBinaryClass.b {
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

        @Override // d0.e0.p.d.m0.e.b.KotlinJvmBinaryClass.b
        public void visit(Object obj) {
            if (obj instanceof String) {
                this.a.add((String) obj);
            }
        }

        @Override // d0.e0.p.d.m0.e.b.KotlinJvmBinaryClass.b
        public void visitClassLiteral(ClassLiteralValue classLiteralValue) {
            if (classLiteralValue != null) {
                return;
            }
            a(2);
            throw null;
        }

        @Override // d0.e0.p.d.m0.e.b.KotlinJvmBinaryClass.b
        public void visitEnd() {
            b((String[]) this.a.toArray(new String[0]));
        }

        @Override // d0.e0.p.d.m0.e.b.KotlinJvmBinaryClass.b
        public void visitEnum(ClassId classId, Name name) {
            if (classId == null) {
                a(0);
                throw null;
            }
            if (name != null) {
                return;
            }
            a(1);
            throw null;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.b0.b$c */
    /* JADX INFO: compiled from: ReadKotlinClassHeaderAnnotationVisitor.java */
    public class c implements KotlinJvmBinaryClass.a {
        public c(a aVar) {
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

        @Override // d0.e0.p.d.m0.e.b.KotlinJvmBinaryClass.a
        public void visit(Name name, Object obj) {
            if (name == null) {
                return;
            }
            String strAsString = name.asString();
            if ("k".equals(strAsString)) {
                if (obj instanceof Integer) {
                    ReadKotlinClassHeaderAnnotationVisitor.this.k = KotlinClassHeader.a.getById(((Integer) obj).intValue());
                    return;
                }
                return;
            }
            if ("mv".equals(strAsString)) {
                if (obj instanceof int[]) {
                    ReadKotlinClassHeaderAnnotationVisitor.this.c = (int[]) obj;
                    return;
                }
                return;
            }
            if ("bv".equals(strAsString)) {
                if (obj instanceof int[]) {
                    ReadKotlinClassHeaderAnnotationVisitor.this.d = new JvmBytecodeBinaryVersion((int[]) obj);
                    return;
                }
                return;
            }
            if ("xs".equals(strAsString)) {
                if (obj instanceof String) {
                    ReadKotlinClassHeaderAnnotationVisitor.this.e = (String) obj;
                    return;
                }
                return;
            }
            if ("xi".equals(strAsString)) {
                if (obj instanceof Integer) {
                    ReadKotlinClassHeaderAnnotationVisitor.this.f = ((Integer) obj).intValue();
                    return;
                }
                return;
            }
            if ("pn".equals(strAsString) && (obj instanceof String)) {
                ReadKotlinClassHeaderAnnotationVisitor.this.g = (String) obj;
            }
        }

        @Override // d0.e0.p.d.m0.e.b.KotlinJvmBinaryClass.a
        public KotlinJvmBinaryClass.a visitAnnotation(Name name, ClassId classId) {
            if (name == null) {
                a(6);
                throw null;
            }
            if (classId != null) {
                return null;
            }
            a(7);
            throw null;
        }

        @Override // d0.e0.p.d.m0.e.b.KotlinJvmBinaryClass.a
        public KotlinJvmBinaryClass.b visitArray(Name name) {
            if (name == null) {
                a(2);
                throw null;
            }
            String strAsString = name.asString();
            if ("d1".equals(strAsString)) {
                return new ReadKotlinClassHeaderAnnotationVisitor2(this);
            }
            if ("d2".equals(strAsString)) {
                return new ReadKotlinClassHeaderAnnotationVisitor3(this);
            }
            return null;
        }

        @Override // d0.e0.p.d.m0.e.b.KotlinJvmBinaryClass.a
        public void visitClassLiteral(Name name, ClassLiteralValue classLiteralValue) {
            if (name == null) {
                a(0);
                throw null;
            }
            if (classLiteralValue != null) {
                return;
            }
            a(1);
            throw null;
        }

        @Override // d0.e0.p.d.m0.e.b.KotlinJvmBinaryClass.a
        public void visitEnd() {
        }

        @Override // d0.e0.p.d.m0.e.b.KotlinJvmBinaryClass.a
        public void visitEnum(Name name, ClassId classId, Name name2) {
            if (name == null) {
                a(3);
                throw null;
            }
            if (classId == null) {
                a(4);
                throw null;
            }
            if (name2 != null) {
                return;
            }
            a(5);
            throw null;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.b0.b$d */
    /* JADX INFO: compiled from: ReadKotlinClassHeaderAnnotationVisitor.java */
    public class d implements KotlinJvmBinaryClass.a {
        public d(a aVar) {
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

        @Override // d0.e0.p.d.m0.e.b.KotlinJvmBinaryClass.a
        public void visit(Name name, Object obj) {
            if (name == null) {
                return;
            }
            String strAsString = name.asString();
            if (!"version".equals(strAsString)) {
                if ("multifileClassName".equals(strAsString)) {
                    ReadKotlinClassHeaderAnnotationVisitor.this.e = obj instanceof String ? (String) obj : null;
                    return;
                }
                return;
            }
            if (obj instanceof int[]) {
                ReadKotlinClassHeaderAnnotationVisitor readKotlinClassHeaderAnnotationVisitor = ReadKotlinClassHeaderAnnotationVisitor.this;
                int[] iArr = (int[]) obj;
                readKotlinClassHeaderAnnotationVisitor.c = iArr;
                if (readKotlinClassHeaderAnnotationVisitor.d == null) {
                    readKotlinClassHeaderAnnotationVisitor.d = new JvmBytecodeBinaryVersion(iArr);
                }
            }
        }

        @Override // d0.e0.p.d.m0.e.b.KotlinJvmBinaryClass.a
        public KotlinJvmBinaryClass.a visitAnnotation(Name name, ClassId classId) {
            if (name == null) {
                a(6);
                throw null;
            }
            if (classId != null) {
                return null;
            }
            a(7);
            throw null;
        }

        @Override // d0.e0.p.d.m0.e.b.KotlinJvmBinaryClass.a
        public KotlinJvmBinaryClass.b visitArray(Name name) {
            if (name == null) {
                a(2);
                throw null;
            }
            String strAsString = name.asString();
            if ("data".equals(strAsString) || "filePartClassNames".equals(strAsString)) {
                return new ReadKotlinClassHeaderAnnotationVisitor4(this);
            }
            if ("strings".equals(strAsString)) {
                return new ReadKotlinClassHeaderAnnotationVisitor5(this);
            }
            return null;
        }

        @Override // d0.e0.p.d.m0.e.b.KotlinJvmBinaryClass.a
        public void visitClassLiteral(Name name, ClassLiteralValue classLiteralValue) {
            if (name == null) {
                a(0);
                throw null;
            }
            if (classLiteralValue != null) {
                return;
            }
            a(1);
            throw null;
        }

        @Override // d0.e0.p.d.m0.e.b.KotlinJvmBinaryClass.a
        public void visitEnd() {
        }

        @Override // d0.e0.p.d.m0.e.b.KotlinJvmBinaryClass.a
        public void visitEnum(Name name, ClassId classId, Name name2) {
            if (name == null) {
                a(3);
                throw null;
            }
            if (classId == null) {
                a(4);
                throw null;
            }
            if (name2 != null) {
                return;
            }
            a(5);
            throw null;
        }
    }

    static {
        HashMap map = new HashMap();
        f3368b = map;
        map.put(ClassId.topLevel(new FqName("kotlin.jvm.internal.KotlinClass")), KotlinClassHeader.a.CLASS);
        map.put(ClassId.topLevel(new FqName("kotlin.jvm.internal.KotlinFileFacade")), KotlinClassHeader.a.FILE_FACADE);
        map.put(ClassId.topLevel(new FqName("kotlin.jvm.internal.KotlinMultifileClass")), KotlinClassHeader.a.MULTIFILE_CLASS);
        map.put(ClassId.topLevel(new FqName("kotlin.jvm.internal.KotlinMultifileClassPart")), KotlinClassHeader.a.MULTIFILE_CLASS_PART);
        map.put(ClassId.topLevel(new FqName("kotlin.jvm.internal.KotlinSyntheticClass")), KotlinClassHeader.a.SYNTHETIC_CLASS);
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

    public KotlinClassHeader createHeader() {
        if (this.k == null || this.c == null) {
            return null;
        }
        boolean z2 = true;
        JvmMetadataVersion jvmMetadataVersion = new JvmMetadataVersion(this.c, (this.f & 8) != 0);
        if (jvmMetadataVersion.isCompatible()) {
            KotlinClassHeader.a aVar = this.k;
            if (aVar != KotlinClassHeader.a.CLASS && aVar != KotlinClassHeader.a.FILE_FACADE && aVar != KotlinClassHeader.a.MULTIFILE_CLASS_PART) {
                z2 = false;
            }
            if (z2 && this.h == null) {
                return null;
            }
        } else {
            this.j = this.h;
            this.h = null;
        }
        KotlinClassHeader.a aVar2 = this.k;
        JvmBytecodeBinaryVersion jvmBytecodeBinaryVersion = this.d;
        if (jvmBytecodeBinaryVersion == null) {
            jvmBytecodeBinaryVersion = JvmBytecodeBinaryVersion.f;
        }
        return new KotlinClassHeader(aVar2, jvmMetadataVersion, jvmBytecodeBinaryVersion, this.h, this.j, this.i, this.e, this.f, this.g);
    }

    @Override // d0.e0.p.d.m0.e.b.KotlinJvmBinaryClass.c
    public KotlinJvmBinaryClass.a visitAnnotation(ClassId classId, SourceElement sourceElement) {
        KotlinClassHeader.a aVar;
        if (classId == null) {
            a(0);
            throw null;
        }
        if (sourceElement == null) {
            a(1);
            throw null;
        }
        if (classId.asSingleFqName().equals(JvmAnnotationNames.a)) {
            return new c(null);
        }
        if (a || this.k != null || (aVar = f3368b.get(classId)) == null) {
            return null;
        }
        this.k = aVar;
        return new d(null);
    }

    @Override // d0.e0.p.d.m0.e.b.KotlinJvmBinaryClass.c
    public void visitEnd() {
    }
}
