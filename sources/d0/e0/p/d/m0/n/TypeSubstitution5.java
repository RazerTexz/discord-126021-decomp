package d0.e0.p.d.m0.n;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.z0, reason: use source file name */
/* JADX INFO: compiled from: TypeSubstitution.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class TypeSubstitution5 {
    public static final TypeSubstitution5 a;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.z0$a */
    /* JADX INFO: compiled from: TypeSubstitution.kt */
    public static final class a extends TypeSubstitution5 {
        @Override // d0.e0.p.d.m0.n.TypeSubstitution5
        public /* bridge */ /* synthetic */ TypeProjection get(KotlinType kotlinType) {
            return (TypeProjection) m96get(kotlinType);
        }

        /* JADX INFO: renamed from: get, reason: collision with other method in class */
        public Void m96get(KotlinType kotlinType) {
            Intrinsics3.checkNotNullParameter(kotlinType, "key");
            return null;
        }

        @Override // d0.e0.p.d.m0.n.TypeSubstitution5
        public boolean isEmpty() {
            return true;
        }

        public String toString() {
            return "Empty TypeSubstitution";
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.z0$b */
    /* JADX INFO: compiled from: TypeSubstitution.kt */
    public static final class b {
        public b(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    static {
        new b(null);
        a = new a();
    }

    public boolean approximateCapturedTypes() {
        return false;
    }

    public boolean approximateContravariantCapturedTypes() {
        return false;
    }

    public final TypeSubstitutor2 buildSubstitutor() {
        TypeSubstitutor2 typeSubstitutor2Create = TypeSubstitutor2.create(this);
        Intrinsics3.checkNotNullExpressionValue(typeSubstitutor2Create, "create(this)");
        return typeSubstitutor2Create;
    }

    public Annotations4 filterAnnotations(Annotations4 annotations4) {
        Intrinsics3.checkNotNullParameter(annotations4, "annotations");
        return annotations4;
    }

    public abstract TypeProjection get(KotlinType kotlinType);

    public boolean isEmpty() {
        return false;
    }

    public KotlinType prepareTopLevelType(KotlinType kotlinType, Variance variance) {
        Intrinsics3.checkNotNullParameter(kotlinType, "topLevelType");
        Intrinsics3.checkNotNullParameter(variance, ModelAuditLogEntry.CHANGE_KEY_POSITION);
        return kotlinType;
    }
}
