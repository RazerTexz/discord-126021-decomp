package d0.e0.p.d.m0.e.b;

import d0.e0.p.d.m0.e.a.i0.m.RawType2;
import d0.e0.p.d.m0.f.a0.JvmProtoBuf;
import d0.e0.p.d.m0.l.b.FlexibleTypeDeserializer;
import d0.e0.p.d.m0.n.ErrorUtils;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.KotlinType4;
import d0.e0.p.d.m0.n.KotlinTypeFactory;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.h, reason: use source file name */
/* JADX INFO: compiled from: JavaFlexibleTypeDeserializer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class JavaFlexibleTypeDeserializer implements FlexibleTypeDeserializer {
    public static final JavaFlexibleTypeDeserializer a = new JavaFlexibleTypeDeserializer();

    @Override // d0.e0.p.d.m0.l.b.FlexibleTypeDeserializer
    public KotlinType create(d0.e0.p.d.m0.f.q qVar, String str, KotlinType4 kotlinType4, KotlinType4 kotlinType5) {
        Intrinsics3.checkNotNullParameter(qVar, "proto");
        Intrinsics3.checkNotNullParameter(str, "flexibleId");
        Intrinsics3.checkNotNullParameter(kotlinType4, "lowerBound");
        Intrinsics3.checkNotNullParameter(kotlinType5, "upperBound");
        if (Intrinsics3.areEqual(str, "kotlin.jvm.PlatformType")) {
            if (qVar.hasExtension(JvmProtoBuf.g)) {
                return new RawType2(kotlinType4, kotlinType5);
            }
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.a;
            return KotlinTypeFactory.flexibleType(kotlinType4, kotlinType5);
        }
        KotlinType4 kotlinType4CreateErrorType = ErrorUtils.createErrorType("Error java flexible type with id: " + str + ". (" + kotlinType4 + ".." + kotlinType5 + ')');
        Intrinsics3.checkNotNullExpressionValue(kotlinType4CreateErrorType, "createErrorType(\"Error java flexible type with id: $flexibleId. ($lowerBound..$upperBound)\")");
        return kotlinType4CreateErrorType;
    }
}
