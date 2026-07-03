package p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11359i;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11453n0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11465t0;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.InterfaceC11480b;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i;
import p507d0.p513e0.p514p.p515d.p517m0.p573o.p575n.C12032a;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.C12041i;
import p507d0.p580t.C12141k;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12148n0;
import p507d0.p580t.C12160r;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.a0.b */
/* JADX INFO: compiled from: ChainedMemberScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11763b implements InterfaceC11770i {

    /* JADX INFO: renamed from: b */
    public static final a f24333b = new a(null);

    /* JADX INFO: renamed from: c */
    public final String f24334c;

    /* JADX INFO: renamed from: d */
    public final InterfaceC11770i[] f24335d;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.a0.b$a */
    /* JADX INFO: compiled from: ChainedMemberScope.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final InterfaceC11770i create(String str, Iterable<? extends InterfaceC11770i> iterable) {
            C12238m.checkNotNullParameter(str, "debugName");
            C12238m.checkNotNullParameter(iterable, "scopes");
            C12041i c12041i = new C12041i();
            for (InterfaceC11770i interfaceC11770i : iterable) {
                if (interfaceC11770i != InterfaceC11770i.b.f24373b) {
                    if (interfaceC11770i instanceof C11763b) {
                        C12160r.addAll(c12041i, ((C11763b) interfaceC11770i).f24335d);
                    } else {
                        c12041i.add(interfaceC11770i);
                    }
                }
            }
            return createOrSingle$descriptors(str, c12041i);
        }

        public final InterfaceC11770i createOrSingle$descriptors(String str, List<? extends InterfaceC11770i> list) {
            C12238m.checkNotNullParameter(str, "debugName");
            C12238m.checkNotNullParameter(list, "scopes");
            int size = list.size();
            if (size == 0) {
                return InterfaceC11770i.b.f24373b;
            }
            if (size == 1) {
                return list.get(0);
            }
            Object[] array = list.toArray(new InterfaceC11770i[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            return new C11763b(str, (InterfaceC11770i[]) array, null);
        }
    }

    public C11763b(String str, InterfaceC11770i[] interfaceC11770iArr, DefaultConstructorMarker defaultConstructorMarker) {
        this.f24334c = str;
        this.f24335d = interfaceC11770iArr;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i
    public Set<C11716e> getClassifierNames() {
        return C11772k.flatMapClassifierNamesOrNull(C12141k.asIterable(this.f24335d));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11773l
    public InterfaceC11352h getContributedClassifier(C11716e c11716e, InterfaceC11480b interfaceC11480b) {
        C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(interfaceC11480b, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        InterfaceC11770i[] interfaceC11770iArr = this.f24335d;
        int length = interfaceC11770iArr.length;
        InterfaceC11352h interfaceC11352h = null;
        int i = 0;
        while (i < length) {
            InterfaceC11770i interfaceC11770i = interfaceC11770iArr[i];
            i++;
            InterfaceC11352h contributedClassifier = interfaceC11770i.getContributedClassifier(c11716e, interfaceC11480b);
            if (contributedClassifier != null) {
                if (!(contributedClassifier instanceof InterfaceC11359i) || !((InterfaceC11359i) contributedClassifier).isExpect()) {
                    return contributedClassifier;
                }
                if (interfaceC11352h == null) {
                    interfaceC11352h = contributedClassifier;
                }
            }
        }
        return interfaceC11352h;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11773l
    public Collection<InterfaceC11450m> getContributedDescriptors(C11765d c11765d, Function1<? super C11716e, Boolean> function1) {
        C12238m.checkNotNullParameter(c11765d, "kindFilter");
        C12238m.checkNotNullParameter(function1, "nameFilter");
        InterfaceC11770i[] interfaceC11770iArr = this.f24335d;
        int length = interfaceC11770iArr.length;
        if (length == 0) {
            return C12147n.emptyList();
        }
        int i = 0;
        if (length == 1) {
            return interfaceC11770iArr[0].getContributedDescriptors(c11765d, function1);
        }
        Collection<InterfaceC11450m> collectionConcat = null;
        int length2 = interfaceC11770iArr.length;
        while (i < length2) {
            InterfaceC11770i interfaceC11770i = interfaceC11770iArr[i];
            i++;
            collectionConcat = C12032a.concat(collectionConcat, interfaceC11770i.getContributedDescriptors(c11765d, function1));
        }
        return collectionConcat == null ? C12148n0.emptySet() : collectionConcat;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i
    public Collection<InterfaceC11465t0> getContributedFunctions(C11716e c11716e, InterfaceC11480b interfaceC11480b) {
        C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(interfaceC11480b, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        InterfaceC11770i[] interfaceC11770iArr = this.f24335d;
        int length = interfaceC11770iArr.length;
        if (length == 0) {
            return C12147n.emptyList();
        }
        int i = 0;
        if (length == 1) {
            return interfaceC11770iArr[0].getContributedFunctions(c11716e, interfaceC11480b);
        }
        Collection<InterfaceC11465t0> collectionConcat = null;
        int length2 = interfaceC11770iArr.length;
        while (i < length2) {
            InterfaceC11770i interfaceC11770i = interfaceC11770iArr[i];
            i++;
            collectionConcat = C12032a.concat(collectionConcat, interfaceC11770i.getContributedFunctions(c11716e, interfaceC11480b));
        }
        return collectionConcat == null ? C12148n0.emptySet() : collectionConcat;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i
    public Collection<InterfaceC11453n0> getContributedVariables(C11716e c11716e, InterfaceC11480b interfaceC11480b) {
        C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(interfaceC11480b, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        InterfaceC11770i[] interfaceC11770iArr = this.f24335d;
        int length = interfaceC11770iArr.length;
        if (length == 0) {
            return C12147n.emptyList();
        }
        int i = 0;
        if (length == 1) {
            return interfaceC11770iArr[0].getContributedVariables(c11716e, interfaceC11480b);
        }
        Collection<InterfaceC11453n0> collectionConcat = null;
        int length2 = interfaceC11770iArr.length;
        while (i < length2) {
            InterfaceC11770i interfaceC11770i = interfaceC11770iArr[i];
            i++;
            collectionConcat = C12032a.concat(collectionConcat, interfaceC11770i.getContributedVariables(c11716e, interfaceC11480b));
        }
        return collectionConcat == null ? C12148n0.emptySet() : collectionConcat;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i
    public Set<C11716e> getFunctionNames() {
        InterfaceC11770i[] interfaceC11770iArr = this.f24335d;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (InterfaceC11770i interfaceC11770i : interfaceC11770iArr) {
            C12160r.addAll(linkedHashSet, interfaceC11770i.getFunctionNames());
        }
        return linkedHashSet;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i
    public Set<C11716e> getVariableNames() {
        InterfaceC11770i[] interfaceC11770iArr = this.f24335d;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (InterfaceC11770i interfaceC11770i : interfaceC11770iArr) {
            C12160r.addAll(linkedHashSet, interfaceC11770i.getVariableNames());
        }
        return linkedHashSet;
    }

    public String toString() {
        return this.f24334c;
    }
}
