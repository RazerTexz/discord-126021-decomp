package d0.e0.p.d.m0.n;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.Collection;
import java.util.Set;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ErrorUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class t$e implements d0.e0.p.d.m0.k.a0.i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3541b;

    public t$e(String str, t$a t_a) {
        if (str != null) {
            this.f3541b = str;
        } else {
            a(0);
            throw null;
        }
    }

    public static /* synthetic */ void a(int i) {
        Object[] objArr = new Object[3];
        switch (i) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 11:
            case 13:
                objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                break;
            case 2:
            case 4:
            case 6:
            case 8:
            case 12:
                objArr[0] = ModelAuditLogEntry.CHANGE_KEY_LOCATION;
                break;
            case 9:
                objArr[0] = "kindFilter";
                break;
            case 10:
                objArr[0] = "nameFilter";
                break;
            case 14:
                objArr[0] = "p";
                break;
            default:
                objArr[0] = "message";
                break;
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ThrowingScope";
        switch (i) {
            case 1:
            case 2:
                objArr[2] = "getContributedClassifier";
                break;
            case 3:
            case 4:
                objArr[2] = "getContributedClassifierIncludeDeprecated";
                break;
            case 5:
            case 6:
                objArr[2] = "getContributedVariables";
                break;
            case 7:
            case 8:
                objArr[2] = "getContributedFunctions";
                break;
            case 9:
            case 10:
                objArr[2] = "getContributedDescriptors";
                break;
            case 11:
            case 12:
                objArr[2] = "recordLookup";
                break;
            case 13:
                objArr[2] = "definitelyDoesNotContainName";
                break;
            case 14:
                objArr[2] = "printScopeStructure";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    @Override // d0.e0.p.d.m0.k.a0.i
    public Set<d0.e0.p.d.m0.g.e> getClassifierNames() {
        throw new IllegalStateException();
    }

    @Override // d0.e0.p.d.m0.k.a0.l
    public d0.e0.p.d.m0.c.h getContributedClassifier(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
        if (eVar == null) {
            a(1);
            throw null;
        }
        if (bVar == null) {
            a(2);
            throw null;
        }
        throw new IllegalStateException(this.f3541b + ", required name: " + eVar);
    }

    @Override // d0.e0.p.d.m0.k.a0.l
    public Collection<d0.e0.p.d.m0.c.m> getContributedDescriptors(d0.e0.p.d.m0.k.a0.d dVar, Function1<? super d0.e0.p.d.m0.g.e, Boolean> function1) {
        if (dVar == null) {
            a(9);
            throw null;
        }
        if (function1 != null) {
            throw new IllegalStateException(this.f3541b);
        }
        a(10);
        throw null;
    }

    @Override // d0.e0.p.d.m0.k.a0.i
    public Collection<? extends d0.e0.p.d.m0.c.t0> getContributedFunctions(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
        if (eVar == null) {
            a(7);
            throw null;
        }
        if (bVar == null) {
            a(8);
            throw null;
        }
        throw new IllegalStateException(this.f3541b + ", required name: " + eVar);
    }

    @Override // d0.e0.p.d.m0.k.a0.i
    public Collection<? extends d0.e0.p.d.m0.c.n0> getContributedVariables(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
        if (eVar == null) {
            a(5);
            throw null;
        }
        if (bVar == null) {
            a(6);
            throw null;
        }
        throw new IllegalStateException(this.f3541b + ", required name: " + eVar);
    }

    @Override // d0.e0.p.d.m0.k.a0.i
    public Set<d0.e0.p.d.m0.g.e> getFunctionNames() {
        throw new IllegalStateException();
    }

    @Override // d0.e0.p.d.m0.k.a0.i
    public Set<d0.e0.p.d.m0.g.e> getVariableNames() {
        throw new IllegalStateException();
    }

    public String toString() {
        return b.d.b.a.a.H(b.d.b.a.a.U("ThrowingScope{"), this.f3541b, '}');
    }
}
