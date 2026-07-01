package d0.e0.p.d.m0.n;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.p, reason: use source file name */
/* JADX INFO: compiled from: DisjointKeysUnionTypeSubstitution.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class DisjointKeysUnionTypeSubstitution extends TypeSubstitution5 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f3533b = new a(null);
    public final TypeSubstitution5 c;
    public final TypeSubstitution5 d;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.p$a */
    /* JADX INFO: compiled from: DisjointKeysUnionTypeSubstitution.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final TypeSubstitution5 create(TypeSubstitution5 typeSubstitution5, TypeSubstitution5 typeSubstitution6) {
            Intrinsics3.checkNotNullParameter(typeSubstitution5, "first");
            Intrinsics3.checkNotNullParameter(typeSubstitution6, "second");
            if (typeSubstitution5.isEmpty()) {
                return typeSubstitution6;
            }
            return typeSubstitution6.isEmpty() ? typeSubstitution5 : new DisjointKeysUnionTypeSubstitution(typeSubstitution5, typeSubstitution6, null);
        }
    }

    public DisjointKeysUnionTypeSubstitution(TypeSubstitution5 typeSubstitution5, TypeSubstitution5 typeSubstitution6, DefaultConstructorMarker defaultConstructorMarker) {
        this.c = typeSubstitution5;
        this.d = typeSubstitution6;
    }

    public static final TypeSubstitution5 create(TypeSubstitution5 typeSubstitution5, TypeSubstitution5 typeSubstitution6) {
        return f3533b.create(typeSubstitution5, typeSubstitution6);
    }

    @Override // d0.e0.p.d.m0.n.TypeSubstitution5
    public boolean approximateCapturedTypes() {
        return this.c.approximateCapturedTypes() || this.d.approximateCapturedTypes();
    }

    @Override // d0.e0.p.d.m0.n.TypeSubstitution5
    public boolean approximateContravariantCapturedTypes() {
        return this.c.approximateContravariantCapturedTypes() || this.d.approximateContravariantCapturedTypes();
    }

    @Override // d0.e0.p.d.m0.n.TypeSubstitution5
    public Annotations4 filterAnnotations(Annotations4 annotations4) {
        Intrinsics3.checkNotNullParameter(annotations4, "annotations");
        return this.d.filterAnnotations(this.c.filterAnnotations(annotations4));
    }

    @Override // d0.e0.p.d.m0.n.TypeSubstitution5
    public TypeProjection get(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "key");
        TypeProjection typeProjection = this.c.get(kotlinType);
        return typeProjection == null ? this.d.get(kotlinType) : typeProjection;
    }

    @Override // d0.e0.p.d.m0.n.TypeSubstitution5
    public boolean isEmpty() {
        return false;
    }

    @Override // d0.e0.p.d.m0.n.TypeSubstitution5
    public KotlinType prepareTopLevelType(KotlinType kotlinType, Variance variance) {
        Intrinsics3.checkNotNullParameter(kotlinType, "topLevelType");
        Intrinsics3.checkNotNullParameter(variance, ModelAuditLogEntry.CHANGE_KEY_POSITION);
        return this.d.prepareTopLevelType(this.c.prepareTopLevelType(kotlinType, variance), variance);
    }
}
