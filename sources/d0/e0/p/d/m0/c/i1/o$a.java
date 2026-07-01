package d0.e0.p.d.m0.c.i1;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.t0;
import d0.e0.p.d.m0.m.f$m;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: EnumEntrySyntheticClassDescriptor.java */
/* JADX INFO: loaded from: classes3.dex */
public class o$a extends d0.e0.p.d.m0.k.a0.j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d0.e0.p.d.m0.m.h<d0.e0.p.d.m0.g.e, Collection<? extends t0>> f3270b;
    public final d0.e0.p.d.m0.m.h<d0.e0.p.d.m0.g.e, Collection<? extends d0.e0.p.d.m0.c.n0>> c;
    public final d0.e0.p.d.m0.m.j<Collection<d0.e0.p.d.m0.c.m>> d;
    public final /* synthetic */ o e;

    public o$a(o oVar, d0.e0.p.d.m0.m.o oVar2) {
        if (oVar2 == null) {
            a(0);
            throw null;
        }
        this.e = oVar;
        this.f3270b = oVar2.createMemoizedFunction(new o$a$a(this, oVar));
        this.c = oVar2.createMemoizedFunction(new o$a$b(this, oVar));
        this.d = oVar2.createLazyValue(new o$a$c(this, oVar));
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0024  */
    /* JADX WARN: Code duplicated, block: B:9:0x0014  */
    public static /* synthetic */ void a(int i) {
        String str;
        int i2;
        if (i != 3 && i != 7 && i != 9 && i != 12) {
            switch (i) {
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
        } else {
            str = "@NotNull method %s.%s must not return null";
        }
        if (i != 3 && i != 7 && i != 9 && i != 12) {
            switch (i) {
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
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
            case 4:
            case 5:
            case 8:
            case 10:
                objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                break;
            case 2:
            case 6:
                objArr[0] = ModelAuditLogEntry.CHANGE_KEY_LOCATION;
                break;
            case 3:
            case 7:
            case 9:
            case 12:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope";
                break;
            case 11:
                objArr[0] = "fromSupertypes";
                break;
            case 13:
                objArr[0] = "kindFilter";
                break;
            case 14:
                objArr[0] = "nameFilter";
                break;
            case 20:
                objArr[0] = "p";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        if (i == 3) {
            objArr[1] = "getContributedVariables";
        } else if (i == 7) {
            objArr[1] = "getContributedFunctions";
        } else if (i == 9) {
            objArr[1] = "getSupertypeScope";
        } else if (i != 12) {
            switch (i) {
                case 15:
                    objArr[1] = "getContributedDescriptors";
                    break;
                case 16:
                    objArr[1] = "computeAllDeclarations";
                    break;
                case 17:
                    objArr[1] = "getFunctionNames";
                    break;
                case 18:
                    objArr[1] = "getClassifierNames";
                    break;
                case 19:
                    objArr[1] = "getVariableNames";
                    break;
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope";
                    break;
            }
        } else {
            objArr[1] = "resolveFakeOverrides";
        }
        switch (i) {
            case 1:
            case 2:
                objArr[2] = "getContributedVariables";
                break;
            case 3:
            case 7:
            case 9:
            case 12:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                break;
            case 4:
                objArr[2] = "computeProperties";
                break;
            case 5:
            case 6:
                objArr[2] = "getContributedFunctions";
                break;
            case 8:
                objArr[2] = "computeFunctions";
                break;
            case 10:
            case 11:
                objArr[2] = "resolveFakeOverrides";
                break;
            case 13:
            case 14:
                objArr[2] = "getContributedDescriptors";
                break;
            case 20:
                objArr[2] = "printScopeStructure";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 3 && i != 7 && i != 9 && i != 12) {
            switch (i) {
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                    break;
                default:
                    throw new IllegalArgumentException(str2);
            }
        }
        throw new IllegalStateException(str2);
    }

    public final d0.e0.p.d.m0.k.a0.i b() {
        d0.e0.p.d.m0.k.a0.i memberScope = this.e.getTypeConstructor().getSupertypes().iterator().next().getMemberScope();
        if (memberScope != null) {
            return memberScope;
        }
        a(9);
        throw null;
    }

    public final <D extends d0.e0.p.d.m0.c.b> Collection<? extends D> c(d0.e0.p.d.m0.g.e eVar, Collection<? extends D> collection) {
        if (eVar == null) {
            a(10);
            throw null;
        }
        if (collection == null) {
            a(11);
            throw null;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        d0.e0.p.d.m0.k.k.f3468b.generateOverridesInFunctionGroup(eVar, collection, Collections.emptySet(), this.e, new o$a$d(this, linkedHashSet));
        return linkedHashSet;
    }

    @Override // d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.i
    public Set<d0.e0.p.d.m0.g.e> getClassifierNames() {
        Set<d0.e0.p.d.m0.g.e> setEmptySet = Collections.emptySet();
        if (setEmptySet != null) {
            return setEmptySet;
        }
        a(18);
        throw null;
    }

    @Override // d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.l
    public Collection<d0.e0.p.d.m0.c.m> getContributedDescriptors(d0.e0.p.d.m0.k.a0.d dVar, Function1<? super d0.e0.p.d.m0.g.e, Boolean> function1) {
        if (dVar == null) {
            a(13);
            throw null;
        }
        if (function1 == null) {
            a(14);
            throw null;
        }
        Collection<d0.e0.p.d.m0.c.m> collectionInvoke = this.d.invoke();
        if (collectionInvoke != null) {
            return collectionInvoke;
        }
        a(15);
        throw null;
    }

    @Override // d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.i
    public Collection<? extends t0> getContributedFunctions(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
        if (eVar == null) {
            a(5);
            throw null;
        }
        if (bVar == null) {
            a(6);
            throw null;
        }
        Collection<? extends t0> collection = (Collection) ((f$m) this.f3270b).invoke(eVar);
        if (collection != null) {
            return collection;
        }
        a(7);
        throw null;
    }

    @Override // d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.i
    public Collection<? extends d0.e0.p.d.m0.c.n0> getContributedVariables(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
        if (eVar == null) {
            a(1);
            throw null;
        }
        if (bVar == null) {
            a(2);
            throw null;
        }
        Collection<? extends d0.e0.p.d.m0.c.n0> collection = (Collection) ((f$m) this.c).invoke(eVar);
        if (collection != null) {
            return collection;
        }
        a(3);
        throw null;
    }

    @Override // d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.i
    public Set<d0.e0.p.d.m0.g.e> getFunctionNames() {
        Set<d0.e0.p.d.m0.g.e> setInvoke = this.e.t.invoke();
        if (setInvoke != null) {
            return setInvoke;
        }
        a(17);
        throw null;
    }

    @Override // d0.e0.p.d.m0.k.a0.j, d0.e0.p.d.m0.k.a0.i
    public Set<d0.e0.p.d.m0.g.e> getVariableNames() {
        Set<d0.e0.p.d.m0.g.e> setInvoke = this.e.t.invoke();
        if (setInvoke != null) {
            return setInvoke;
        }
        a(19);
        throw null;
    }
}
