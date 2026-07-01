package d0.e0.p.d.m0.l.b;

import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.KotlinType4;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.q, reason: use source file name */
/* JADX INFO: compiled from: FlexibleTypeDeserializer.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface FlexibleTypeDeserializer {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.q$a */
    /* JADX INFO: compiled from: FlexibleTypeDeserializer.kt */
    public static final class a implements FlexibleTypeDeserializer {
        public static final a a = new a();

        @Override // d0.e0.p.d.m0.l.b.FlexibleTypeDeserializer
        public KotlinType create(d0.e0.p.d.m0.f.q qVar, String str, KotlinType4 kotlinType4, KotlinType4 kotlinType5) {
            Intrinsics3.checkNotNullParameter(qVar, "proto");
            Intrinsics3.checkNotNullParameter(str, "flexibleId");
            Intrinsics3.checkNotNullParameter(kotlinType4, "lowerBound");
            Intrinsics3.checkNotNullParameter(kotlinType5, "upperBound");
            throw new IllegalArgumentException("This method should not be used.");
        }
    }

    KotlinType create(d0.e0.p.d.m0.f.q qVar, String str, KotlinType4 kotlinType4, KotlinType4 kotlinType5);
}
