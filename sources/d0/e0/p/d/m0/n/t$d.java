package d0.e0.p.d.m0.n;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ErrorUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class t$d implements d0.e0.p.d.m0.k.a0.i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3540b;

    public t$d(String str, t$a t_a) {
        if (str != null) {
            this.f3540b = str;
        } else {
            a(0);
            throw null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0019  */
    /* JADX WARN: Code duplicated, block: B:7:0x000d  */
    public static /* synthetic */ void a(int i) {
        String str;
        int i2;
        if (i != 7 && i != 18) {
            switch (i) {
                case 10:
                case 11:
                case 12:
                case 13:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
        } else {
            str = "@NotNull method %s.%s must not return null";
        }
        if (i != 7 && i != 18) {
            switch (i) {
                case 10:
                case 11:
                case 12:
                case 13:
                    i2 = 2;
                    break;
                default:
                    i2 = 3;
                    break;
            }
        } else {
            i2 = 2;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
            case 3:
            case 5:
            case 8:
            case 14:
            case 19:
                objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                break;
            case 2:
            case 4:
            case 6:
            case 9:
            case 15:
                objArr[0] = ModelAuditLogEntry.CHANGE_KEY_LOCATION;
                break;
            case 7:
            case 10:
            case 11:
            case 12:
            case 13:
            case 18:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorScope";
                break;
            case 16:
                objArr[0] = "kindFilter";
                break;
            case 17:
                objArr[0] = "nameFilter";
                break;
            case 20:
                objArr[0] = "p";
                break;
            default:
                objArr[0] = "debugMessage";
                break;
        }
        if (i == 7) {
            objArr[1] = "getContributedVariables";
        } else if (i != 18) {
            switch (i) {
                case 10:
                    objArr[1] = "getContributedFunctions";
                    break;
                case 11:
                    objArr[1] = "getFunctionNames";
                    break;
                case 12:
                    objArr[1] = "getVariableNames";
                    break;
                case 13:
                    objArr[1] = "getClassifierNames";
                    break;
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorScope";
                    break;
            }
        } else {
            objArr[1] = "getContributedDescriptors";
        }
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
            case 10:
            case 11:
            case 12:
            case 13:
            case 18:
                break;
            case 8:
            case 9:
                objArr[2] = "getContributedFunctions";
                break;
            case 14:
            case 15:
                objArr[2] = "recordLookup";
                break;
            case 16:
            case 17:
                objArr[2] = "getContributedDescriptors";
                break;
            case 19:
                objArr[2] = "definitelyDoesNotContainName";
                break;
            case 20:
                objArr[2] = "printScopeStructure";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 7 && i != 18) {
            switch (i) {
                case 10:
                case 11:
                case 12:
                case 13:
                    break;
                default:
                    throw new IllegalArgumentException(str2);
            }
        }
        throw new IllegalStateException(str2);
    }

    @Override // d0.e0.p.d.m0.k.a0.i
    public Set<d0.e0.p.d.m0.g.e> getClassifierNames() {
        Set<d0.e0.p.d.m0.g.e> setEmptySet = Collections.emptySet();
        if (setEmptySet != null) {
            return setEmptySet;
        }
        a(13);
        throw null;
    }

    @Override // d0.e0.p.d.m0.k.a0.l
    public d0.e0.p.d.m0.c.h getContributedClassifier(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
        if (eVar == null) {
            a(1);
            throw null;
        }
        if (bVar != null) {
            return t.createErrorClass(eVar.asString());
        }
        a(2);
        throw null;
    }

    @Override // d0.e0.p.d.m0.k.a0.l
    public Collection<d0.e0.p.d.m0.c.m> getContributedDescriptors(d0.e0.p.d.m0.k.a0.d dVar, Function1<? super d0.e0.p.d.m0.g.e, Boolean> function1) {
        if (dVar == null) {
            a(16);
            throw null;
        }
        if (function1 == null) {
            a(17);
            throw null;
        }
        List listEmptyList = Collections.emptyList();
        if (listEmptyList != null) {
            return listEmptyList;
        }
        a(18);
        throw null;
    }

    @Override // d0.e0.p.d.m0.k.a0.i
    public /* bridge */ /* synthetic */ Collection getContributedFunctions(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
        return getContributedFunctions(eVar, bVar);
    }

    @Override // d0.e0.p.d.m0.k.a0.i
    public Set<? extends d0.e0.p.d.m0.c.n0> getContributedVariables(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
        if (eVar == null) {
            a(5);
            throw null;
        }
        if (bVar == null) {
            a(6);
            throw null;
        }
        Set<d0.e0.p.d.m0.c.n0> set = t.f;
        if (set != null) {
            return set;
        }
        a(7);
        throw null;
    }

    @Override // d0.e0.p.d.m0.k.a0.i
    public Set<d0.e0.p.d.m0.g.e> getFunctionNames() {
        Set<d0.e0.p.d.m0.g.e> setEmptySet = Collections.emptySet();
        if (setEmptySet != null) {
            return setEmptySet;
        }
        a(11);
        throw null;
    }

    @Override // d0.e0.p.d.m0.k.a0.i
    public Set<d0.e0.p.d.m0.g.e> getVariableNames() {
        Set<d0.e0.p.d.m0.g.e> setEmptySet = Collections.emptySet();
        if (setEmptySet != null) {
            return setEmptySet;
        }
        a(12);
        throw null;
    }

    public String toString() {
        return b.d.b.a.a.H(b.d.b.a.a.U("ErrorScope{"), this.f3540b, '}');
    }

    @Override // d0.e0.p.d.m0.k.a0.i
    public Set<? extends d0.e0.p.d.m0.c.t0> getContributedFunctions(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
        if (eVar == null) {
            a(8);
            throw null;
        }
        if (bVar == null) {
            a(9);
            throw null;
        }
        d0.e0.p.d.m0.n.m1.a aVar = new d0.e0.p.d.m0.n.m1.a(t.f3538b, this);
        aVar.initialize((d0.e0.p.d.m0.c.q0) null, (d0.e0.p.d.m0.c.q0) null, Collections.emptyList(), Collections.emptyList(), (c0) t.createErrorType("<ERROR FUNCTION RETURN TYPE>"), d0.e0.p.d.m0.c.z.OPEN, d0.e0.p.d.m0.c.t.e);
        Set<? extends d0.e0.p.d.m0.c.t0> setSingleton = Collections.singleton(aVar);
        if (setSingleton != null) {
            return setSingleton;
        }
        a(10);
        throw null;
    }

    @Override // d0.e0.p.d.m0.k.a0.i
    public /* bridge */ /* synthetic */ Collection getContributedVariables(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
        return getContributedVariables(eVar, bVar);
    }
}
