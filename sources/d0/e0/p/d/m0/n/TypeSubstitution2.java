package d0.e0.p.d.m0.n;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.l, reason: use source file name */
/* JADX INFO: compiled from: TypeSubstitution.kt */
/* JADX INFO: loaded from: classes3.dex */
public class TypeSubstitution2 extends TypeSubstitution5 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TypeSubstitution5 f3526b;

    public TypeSubstitution2(TypeSubstitution5 typeSubstitution5) {
        Intrinsics3.checkNotNullParameter(typeSubstitution5, "substitution");
        this.f3526b = typeSubstitution5;
    }

    @Override // d0.e0.p.d.m0.n.TypeSubstitution5
    public boolean approximateCapturedTypes() {
        return this.f3526b.approximateCapturedTypes();
    }

    @Override // d0.e0.p.d.m0.n.TypeSubstitution5
    public Annotations4 filterAnnotations(Annotations4 annotations4) {
        Intrinsics3.checkNotNullParameter(annotations4, "annotations");
        return this.f3526b.filterAnnotations(annotations4);
    }

    @Override // d0.e0.p.d.m0.n.TypeSubstitution5
    public TypeProjection get(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "key");
        return this.f3526b.get(kotlinType);
    }

    @Override // d0.e0.p.d.m0.n.TypeSubstitution5
    public boolean isEmpty() {
        return this.f3526b.isEmpty();
    }

    @Override // d0.e0.p.d.m0.n.TypeSubstitution5
    public KotlinType prepareTopLevelType(KotlinType kotlinType, Variance variance) {
        Intrinsics3.checkNotNullParameter(kotlinType, "topLevelType");
        Intrinsics3.checkNotNullParameter(variance, ModelAuditLogEntry.CHANGE_KEY_POSITION);
        return this.f3526b.prepareTopLevelType(kotlinType, variance);
    }
}
