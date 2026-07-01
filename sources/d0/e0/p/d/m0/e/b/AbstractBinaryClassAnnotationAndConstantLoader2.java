package d0.e0.p.d.m0.e.b;

import androidx.exifinterface.media.ExifInterface;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.SourceElement;
import d0.e0.p.d.m0.e.b.KotlinJvmBinaryClass;
import d0.e0.p.d.m0.e.b.MemberSignature;
import d0.e0.p.d.m0.g.ClassId;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.k.v.ConstantValueFactory;
import d0.g0.Strings4;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.b, reason: use source file name */
/* JADX INFO: compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AbstractBinaryClassAnnotationAndConstantLoader2 implements KotlinJvmBinaryClass.d {
    public final /* synthetic */ AbstractBinaryClassAnnotationAndConstantLoader<A, C> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ HashMap<MemberSignature, List<A>> f3364b;
    public final /* synthetic */ HashMap<MemberSignature, C> c;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.b$a */
    /* JADX INFO: compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
    public final class a extends b implements KotlinJvmBinaryClass.e {
        public final /* synthetic */ AbstractBinaryClassAnnotationAndConstantLoader2 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AbstractBinaryClassAnnotationAndConstantLoader2 abstractBinaryClassAnnotationAndConstantLoader2, MemberSignature memberSignature) {
            super(abstractBinaryClassAnnotationAndConstantLoader2, memberSignature);
            Intrinsics3.checkNotNullParameter(abstractBinaryClassAnnotationAndConstantLoader2, "this$0");
            Intrinsics3.checkNotNullParameter(memberSignature, "signature");
            this.d = abstractBinaryClassAnnotationAndConstantLoader2;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // d0.e0.p.d.m0.e.b.KotlinJvmBinaryClass.e
        public KotlinJvmBinaryClass.a visitParameterAnnotation(int i, ClassId classId, SourceElement sourceElement) {
            Intrinsics3.checkNotNullParameter(classId, "classId");
            Intrinsics3.checkNotNullParameter(sourceElement, "source");
            MemberSignature memberSignatureFromMethodSignatureAndParameterIndex = MemberSignature.a.fromMethodSignatureAndParameterIndex(this.a, i);
            List arrayList = (List) this.d.f3364b.get(memberSignatureFromMethodSignatureAndParameterIndex);
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.d.f3364b.put(memberSignatureFromMethodSignatureAndParameterIndex, (List<A>) arrayList);
            }
            return AbstractBinaryClassAnnotationAndConstantLoader.access$loadAnnotationIfNotSpecial(this.d.a, classId, sourceElement, arrayList);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.b$b */
    /* JADX INFO: compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
    public class b implements KotlinJvmBinaryClass.c {
        public final MemberSignature a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ArrayList<A> f3365b;
        public final /* synthetic */ AbstractBinaryClassAnnotationAndConstantLoader2 c;

        public b(AbstractBinaryClassAnnotationAndConstantLoader2 abstractBinaryClassAnnotationAndConstantLoader2, MemberSignature memberSignature) {
            Intrinsics3.checkNotNullParameter(abstractBinaryClassAnnotationAndConstantLoader2, "this$0");
            Intrinsics3.checkNotNullParameter(memberSignature, "signature");
            this.c = abstractBinaryClassAnnotationAndConstantLoader2;
            this.a = memberSignature;
            this.f3365b = new ArrayList<>();
        }

        @Override // d0.e0.p.d.m0.e.b.KotlinJvmBinaryClass.c
        public KotlinJvmBinaryClass.a visitAnnotation(ClassId classId, SourceElement sourceElement) {
            Intrinsics3.checkNotNullParameter(classId, "classId");
            Intrinsics3.checkNotNullParameter(sourceElement, "source");
            return AbstractBinaryClassAnnotationAndConstantLoader.access$loadAnnotationIfNotSpecial(this.c.a, classId, sourceElement, this.f3365b);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // d0.e0.p.d.m0.e.b.KotlinJvmBinaryClass.c
        public void visitEnd() {
            if (!this.f3365b.isEmpty()) {
                this.c.f3364b.put(this.a, (List<A>) this.f3365b);
            }
        }
    }

    public AbstractBinaryClassAnnotationAndConstantLoader2(AbstractBinaryClassAnnotationAndConstantLoader<A, C> abstractBinaryClassAnnotationAndConstantLoader, HashMap<MemberSignature, List<A>> map, HashMap<MemberSignature, C> map2) {
        this.a = abstractBinaryClassAnnotationAndConstantLoader;
        this.f3364b = map;
        this.c = map2;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // d0.e0.p.d.m0.e.b.KotlinJvmBinaryClass.d
    public KotlinJvmBinaryClass.c visitField(Name name, String str, Object obj) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(str, "desc");
        MemberSignature.a aVar = MemberSignature.a;
        String strAsString = name.asString();
        Intrinsics3.checkNotNullExpressionValue(strAsString, "name.asString()");
        MemberSignature memberSignatureFromFieldNameAndDesc = aVar.fromFieldNameAndDesc(strAsString, str);
        if (obj != null) {
            Objects.requireNonNull((BinaryClassAnnotationAndConstantLoaderImpl) this.a);
            Intrinsics3.checkNotNullParameter(str, "desc");
            Intrinsics3.checkNotNullParameter(obj, "initializer");
            if (Strings4.contains$default((CharSequence) "ZBCS", (CharSequence) str, false, 2, (Object) null)) {
                int iIntValue = ((Integer) obj).intValue();
                int iHashCode = str.hashCode();
                if (iHashCode == 66) {
                    if (str.equals("B")) {
                        obj = Byte.valueOf((byte) iIntValue);
                    }
                    throw new AssertionError(str);
                }
                if (iHashCode == 67) {
                    if (str.equals("C")) {
                        obj = Character.valueOf((char) iIntValue);
                    }
                    throw new AssertionError(str);
                }
                if (iHashCode == 83) {
                    if (str.equals(ExifInterface.LATITUDE_SOUTH)) {
                        obj = Short.valueOf((short) iIntValue);
                    }
                    throw new AssertionError(str);
                }
                if (iHashCode == 90 && str.equals("Z")) {
                    obj = Boolean.valueOf(iIntValue != 0);
                }
                throw new AssertionError(str);
            }
            Object objCreateConstantValue = ConstantValueFactory.a.createConstantValue(obj);
            if (objCreateConstantValue != null) {
                this.c.put(memberSignatureFromFieldNameAndDesc, (C) objCreateConstantValue);
            }
        }
        return new b(this, memberSignatureFromFieldNameAndDesc);
    }

    @Override // d0.e0.p.d.m0.e.b.KotlinJvmBinaryClass.d
    public KotlinJvmBinaryClass.e visitMethod(Name name, String str) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(str, "desc");
        MemberSignature.a aVar = MemberSignature.a;
        String strAsString = name.asString();
        Intrinsics3.checkNotNullExpressionValue(strAsString, "name.asString()");
        return new a(this, aVar.fromMethodNameAndDesc(strAsString, str));
    }
}
