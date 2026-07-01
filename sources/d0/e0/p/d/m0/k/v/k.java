package d0.e0.p.d.m0.k.v;

import d0.e0.p.d.m0.c.ModuleDescriptor2;
import d0.e0.p.d.m0.n.ErrorUtils;
import d0.e0.p.d.m0.n.KotlinType4;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: constantValues.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class k extends g<Unit> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f3474b = new a(null);

    /* JADX INFO: compiled from: constantValues.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final k create(String str) {
            Intrinsics3.checkNotNullParameter(str, "message");
            return new b(str);
        }
    }

    /* JADX INFO: compiled from: constantValues.kt */
    public static final class b extends k {
        public final String c;

        public b(String str) {
            Intrinsics3.checkNotNullParameter(str, "message");
            this.c = str;
        }

        @Override // d0.e0.p.d.m0.k.v.g
        public String toString() {
            return this.c;
        }

        @Override // d0.e0.p.d.m0.k.v.g
        public KotlinType4 getType(ModuleDescriptor2 moduleDescriptor2) {
            Intrinsics3.checkNotNullParameter(moduleDescriptor2, "module");
            KotlinType4 kotlinType4CreateErrorType = ErrorUtils.createErrorType(this.c);
            Intrinsics3.checkNotNullExpressionValue(kotlinType4CreateErrorType, "createErrorType(message)");
            return kotlinType4CreateErrorType;
        }
    }

    public k() {
        super(Unit.a);
    }

    @Override // d0.e0.p.d.m0.k.v.g
    public Unit getValue() {
        throw new UnsupportedOperationException();
    }
}
