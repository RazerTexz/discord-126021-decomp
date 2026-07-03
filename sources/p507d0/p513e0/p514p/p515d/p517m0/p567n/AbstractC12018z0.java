package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import com.discord.models.domain.ModelAuditLogEntry;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.z0 */
/* JADX INFO: compiled from: TypeSubstitution.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC12018z0 {

    /* JADX INFO: renamed from: a */
    public static final AbstractC12018z0 f24899a;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.z0$a */
    /* JADX INFO: compiled from: TypeSubstitution.kt */
    public static final class a extends AbstractC12018z0 {
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC12018z0
        public /* bridge */ /* synthetic */ InterfaceC12012w0 get(AbstractC11913c0 abstractC11913c0) {
            return (InterfaceC12012w0) m11473get(abstractC11913c0);
        }

        /* JADX INFO: renamed from: get, reason: collision with other method in class */
        public Void m11473get(AbstractC11913c0 abstractC11913c0) {
            C12238m.checkNotNullParameter(abstractC11913c0, "key");
            return null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC12018z0
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
        f24899a = new a();
    }

    public boolean approximateCapturedTypes() {
        return false;
    }

    public boolean approximateContravariantCapturedTypes() {
        return false;
    }

    public final C11914c1 buildSubstitutor() {
        C11914c1 c11914c1Create = C11914c1.create(this);
        C12238m.checkNotNullExpressionValue(c11914c1Create, "create(this)");
        return c11914c1Create;
    }

    public InterfaceC11344g filterAnnotations(InterfaceC11344g interfaceC11344g) {
        C12238m.checkNotNullParameter(interfaceC11344g, "annotations");
        return interfaceC11344g;
    }

    public abstract InterfaceC12012w0 get(AbstractC11913c0 abstractC11913c0);

    public boolean isEmpty() {
        return false;
    }

    public AbstractC11913c0 prepareTopLevelType(AbstractC11913c0 abstractC11913c0, EnumC11935j1 enumC11935j1) {
        C12238m.checkNotNullParameter(abstractC11913c0, "topLevelType");
        C12238m.checkNotNullParameter(enumC11935j1, ModelAuditLogEntry.CHANGE_KEY_POSITION);
        return abstractC11913c0;
    }
}
