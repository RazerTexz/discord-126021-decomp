package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11359i;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11453n0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11465t0;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.C11478a;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.InterfaceC11480b;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.C11529g;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11588u;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11655p;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.C11765d;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.C11772k;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.C11904n;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11900j;
import p507d0.p513e0.p514p.p515d.p517m0.p573o.p575n.C12032a;
import p507d0.p580t.C12141k;
import p507d0.p580t.C12148n0;
import p507d0.p580t.C12160r;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p507d0.p592z.p594d.C12250y;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.d */
/* JADX INFO: compiled from: JvmPackageScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11537d implements InterfaceC11770i {

    /* JADX INFO: renamed from: b */
    public static final /* synthetic */ KProperty<Object>[] f23329b = {C12216a0.property1(new C12250y(C12216a0.getOrCreateKotlinClass(C11537d.class), "kotlinScopes", "getKotlinScopes()[Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;"))};

    /* JADX INFO: renamed from: c */
    public final C11529g f23330c;

    /* JADX INFO: renamed from: d */
    public final C11542i f23331d;

    /* JADX INFO: renamed from: e */
    public final C11543j f23332e;

    /* JADX INFO: renamed from: f */
    public final InterfaceC11900j f23333f;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.d$a */
    /* JADX INFO: compiled from: JvmPackageScope.kt */
    public static final class a extends AbstractC12240o implements Function0<InterfaceC11770i[]> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final InterfaceC11770i[] invoke() {
            Collection<InterfaceC11655p> collectionValues = C11537d.this.f23331d.getBinaryClasses$descriptors_jvm().values();
            C11537d c11537d = C11537d.this;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = collectionValues.iterator();
            while (it.hasNext()) {
                InterfaceC11770i interfaceC11770iCreateKotlinPackagePartScope = c11537d.f23330c.getComponents().getDeserializedDescriptorResolver().createKotlinPackagePartScope(c11537d.f23331d, (InterfaceC11655p) it.next());
                if (interfaceC11770iCreateKotlinPackagePartScope != null) {
                    arrayList.add(interfaceC11770iCreateKotlinPackagePartScope);
                }
            }
            Object[] array = C12032a.listOfNonEmptyScopes(arrayList).toArray(new InterfaceC11770i[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            return (InterfaceC11770i[]) array;
        }
    }

    public C11537d(C11529g c11529g, InterfaceC11588u interfaceC11588u, C11542i c11542i) {
        C12238m.checkNotNullParameter(c11529g, "c");
        C12238m.checkNotNullParameter(interfaceC11588u, "jPackage");
        C12238m.checkNotNullParameter(c11542i, "packageFragment");
        this.f23330c = c11529g;
        this.f23331d = c11542i;
        this.f23332e = new C11543j(c11529g, interfaceC11588u, c11542i);
        this.f23333f = c11529g.getStorageManager().createLazyValue(new a());
    }

    /* JADX INFO: renamed from: a */
    public final InterfaceC11770i[] m9462a() {
        return (InterfaceC11770i[]) C11904n.getValue(this.f23333f, this, (KProperty<?>) f23329b[0]);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i
    public Set<C11716e> getClassifierNames() {
        Set<C11716e> setFlatMapClassifierNamesOrNull = C11772k.flatMapClassifierNamesOrNull(C12141k.asIterable(m9462a()));
        if (setFlatMapClassifierNamesOrNull == null) {
            return null;
        }
        setFlatMapClassifierNamesOrNull.addAll(getJavaScope$descriptors_jvm().getClassifierNames());
        return setFlatMapClassifierNamesOrNull;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11773l
    public InterfaceC11352h getContributedClassifier(C11716e c11716e, InterfaceC11480b interfaceC11480b) {
        C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(interfaceC11480b, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        recordLookup(c11716e, interfaceC11480b);
        InterfaceC11330e contributedClassifier = this.f23332e.getContributedClassifier(c11716e, interfaceC11480b);
        if (contributedClassifier != null) {
            return contributedClassifier;
        }
        InterfaceC11770i[] interfaceC11770iArrM9462a = m9462a();
        InterfaceC11352h interfaceC11352h = null;
        int i = 0;
        int length = interfaceC11770iArrM9462a.length;
        while (i < length) {
            InterfaceC11770i interfaceC11770i = interfaceC11770iArrM9462a[i];
            i++;
            InterfaceC11352h contributedClassifier2 = interfaceC11770i.getContributedClassifier(c11716e, interfaceC11480b);
            if (contributedClassifier2 != null) {
                if (!(contributedClassifier2 instanceof InterfaceC11359i) || !((InterfaceC11359i) contributedClassifier2).isExpect()) {
                    return contributedClassifier2;
                }
                if (interfaceC11352h == null) {
                    interfaceC11352h = contributedClassifier2;
                }
            }
        }
        return interfaceC11352h;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11773l
    public Collection<InterfaceC11450m> getContributedDescriptors(C11765d c11765d, Function1<? super C11716e, Boolean> function1) {
        C12238m.checkNotNullParameter(c11765d, "kindFilter");
        C12238m.checkNotNullParameter(function1, "nameFilter");
        C11543j c11543j = this.f23332e;
        InterfaceC11770i[] interfaceC11770iArrM9462a = m9462a();
        Collection<InterfaceC11450m> contributedDescriptors = c11543j.getContributedDescriptors(c11765d, function1);
        int length = interfaceC11770iArrM9462a.length;
        int i = 0;
        while (i < length) {
            InterfaceC11770i interfaceC11770i = interfaceC11770iArrM9462a[i];
            i++;
            contributedDescriptors = C12032a.concat(contributedDescriptors, interfaceC11770i.getContributedDescriptors(c11765d, function1));
        }
        return contributedDescriptors == null ? C12148n0.emptySet() : contributedDescriptors;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i
    public Collection<InterfaceC11465t0> getContributedFunctions(C11716e c11716e, InterfaceC11480b interfaceC11480b) {
        C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(interfaceC11480b, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        recordLookup(c11716e, interfaceC11480b);
        C11543j c11543j = this.f23332e;
        InterfaceC11770i[] interfaceC11770iArrM9462a = m9462a();
        Collection<? extends InterfaceC11465t0> contributedFunctions = c11543j.getContributedFunctions(c11716e, interfaceC11480b);
        int length = interfaceC11770iArrM9462a.length;
        int i = 0;
        Collection collectionConcat = contributedFunctions;
        while (i < length) {
            InterfaceC11770i interfaceC11770i = interfaceC11770iArrM9462a[i];
            i++;
            collectionConcat = C12032a.concat(collectionConcat, interfaceC11770i.getContributedFunctions(c11716e, interfaceC11480b));
        }
        return collectionConcat == null ? C12148n0.emptySet() : collectionConcat;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i
    public Collection<InterfaceC11453n0> getContributedVariables(C11716e c11716e, InterfaceC11480b interfaceC11480b) {
        C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(interfaceC11480b, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        recordLookup(c11716e, interfaceC11480b);
        C11543j c11543j = this.f23332e;
        InterfaceC11770i[] interfaceC11770iArrM9462a = m9462a();
        Collection<? extends InterfaceC11453n0> contributedVariables = c11543j.getContributedVariables(c11716e, interfaceC11480b);
        int length = interfaceC11770iArrM9462a.length;
        int i = 0;
        Collection collectionConcat = contributedVariables;
        while (i < length) {
            InterfaceC11770i interfaceC11770i = interfaceC11770iArrM9462a[i];
            i++;
            collectionConcat = C12032a.concat(collectionConcat, interfaceC11770i.getContributedVariables(c11716e, interfaceC11480b));
        }
        return collectionConcat == null ? C12148n0.emptySet() : collectionConcat;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i
    public Set<C11716e> getFunctionNames() {
        InterfaceC11770i[] interfaceC11770iArrM9462a = m9462a();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (InterfaceC11770i interfaceC11770i : interfaceC11770iArrM9462a) {
            C12160r.addAll(linkedHashSet, interfaceC11770i.getFunctionNames());
        }
        linkedHashSet.addAll(getJavaScope$descriptors_jvm().getFunctionNames());
        return linkedHashSet;
    }

    public final C11543j getJavaScope$descriptors_jvm() {
        return this.f23332e;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i
    public Set<C11716e> getVariableNames() {
        InterfaceC11770i[] interfaceC11770iArrM9462a = m9462a();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (InterfaceC11770i interfaceC11770i : interfaceC11770iArrM9462a) {
            C12160r.addAll(linkedHashSet, interfaceC11770i.getVariableNames());
        }
        linkedHashSet.addAll(getJavaScope$descriptors_jvm().getVariableNames());
        return linkedHashSet;
    }

    public void recordLookup(C11716e c11716e, InterfaceC11480b interfaceC11480b) {
        C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(interfaceC11480b, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        C11478a.record(this.f23330c.getComponents().getLookupTracker(), interfaceC11480b, this.f23331d, c11716e);
    }
}
