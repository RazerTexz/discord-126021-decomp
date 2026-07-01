package d0.e0.p.d.m0.c.k1.a;

import b.d.b.a.outline;
import com.discord.widgets.chat.input.MentionUtils;
import d0.e0.p.d.m0.c.k1.b.reflectClassUtil;
import d0.e0.p.d.m0.e.b.KotlinJvmBinaryClass;
import d0.e0.p.d.m0.e.b.b0.KotlinClassHeader;
import d0.e0.p.d.m0.e.b.b0.ReadKotlinClassHeaderAnnotationVisitor;
import d0.e0.p.d.m0.g.ClassId;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.a.f, reason: use source file name */
/* JADX INFO: compiled from: ReflectKotlinClass.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ReflectKotlinClass2 implements KotlinJvmBinaryClass {
    public static final a a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<?> f3284b;
    public final KotlinClassHeader c;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.a.f$a */
    /* JADX INFO: compiled from: ReflectKotlinClass.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final ReflectKotlinClass2 create(Class<?> cls) {
            Intrinsics3.checkNotNullParameter(cls, "klass");
            ReadKotlinClassHeaderAnnotationVisitor readKotlinClassHeaderAnnotationVisitor = new ReadKotlinClassHeaderAnnotationVisitor();
            ReflectKotlinClass.a.loadClassAnnotations(cls, readKotlinClassHeaderAnnotationVisitor);
            KotlinClassHeader kotlinClassHeaderCreateHeader = readKotlinClassHeaderAnnotationVisitor.createHeader();
            if (kotlinClassHeaderCreateHeader == null) {
                return null;
            }
            return new ReflectKotlinClass2(cls, kotlinClassHeaderCreateHeader, null);
        }
    }

    public ReflectKotlinClass2(Class cls, KotlinClassHeader kotlinClassHeader, DefaultConstructorMarker defaultConstructorMarker) {
        this.f3284b = cls;
        this.c = kotlinClassHeader;
    }

    public boolean equals(Object obj) {
        return (obj instanceof ReflectKotlinClass2) && Intrinsics3.areEqual(this.f3284b, ((ReflectKotlinClass2) obj).f3284b);
    }

    @Override // d0.e0.p.d.m0.e.b.KotlinJvmBinaryClass
    public KotlinClassHeader getClassHeader() {
        return this.c;
    }

    @Override // d0.e0.p.d.m0.e.b.KotlinJvmBinaryClass
    public ClassId getClassId() {
        return reflectClassUtil.getClassId(this.f3284b);
    }

    public final Class<?> getKlass() {
        return this.f3284b;
    }

    @Override // d0.e0.p.d.m0.e.b.KotlinJvmBinaryClass
    public String getLocation() {
        String name = this.f3284b.getName();
        Intrinsics3.checkNotNullExpressionValue(name, "klass.name");
        return Intrinsics3.stringPlus(StringsJVM.replace$default(name, '.', MentionUtils.SLASH_CHAR, false, 4, (Object) null), ".class");
    }

    public int hashCode() {
        return this.f3284b.hashCode();
    }

    @Override // d0.e0.p.d.m0.e.b.KotlinJvmBinaryClass
    public void loadClassAnnotations(KotlinJvmBinaryClass.c cVar, byte[] bArr) {
        Intrinsics3.checkNotNullParameter(cVar, "visitor");
        ReflectKotlinClass.a.loadClassAnnotations(this.f3284b, cVar);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        outline.k0(ReflectKotlinClass2.class, sb, ": ");
        sb.append(this.f3284b);
        return sb.toString();
    }

    @Override // d0.e0.p.d.m0.e.b.KotlinJvmBinaryClass
    public void visitMembers(KotlinJvmBinaryClass.d dVar, byte[] bArr) {
        Intrinsics3.checkNotNullParameter(dVar, "visitor");
        ReflectKotlinClass.a.visitMembers(this.f3284b, dVar);
    }
}
