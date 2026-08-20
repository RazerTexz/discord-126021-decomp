package p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p507d0.C12083g;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11453n0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11465t0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11471w0;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.InterfaceC11480b;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p555u.p556a.C11806d;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC12018z0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11914c1;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.C12033a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.a0.n */
/* JADX INFO: compiled from: SubstitutingScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11775n implements InterfaceC11770i {

    /* JADX INFO: renamed from: b */
    public final InterfaceC11770i f24377b;

    /* JADX INFO: renamed from: c */
    public final C11914c1 f24378c;

    /* JADX INFO: renamed from: d */
    public Map<InterfaceC11450m, InterfaceC11450m> f24379d;

    /* JADX INFO: renamed from: e */
    public final Lazy f24380e;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.a0.n$a */
    /* JADX INFO: compiled from: SubstitutingScope.kt */
    public static final class a extends AbstractC12240o implements Function0<Collection<? extends InterfaceC11450m>> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Collection<? extends InterfaceC11450m> invoke() {
            C11775n c11775n = C11775n.this;
            return c11775n.m9912a(InterfaceC11773l.a.getContributedDescriptors$default(c11775n.f24377b, null, null, 3, null));
        }
    }

    public C11775n(InterfaceC11770i interfaceC11770i, C11914c1 c11914c1) {
        C12238m.checkNotNullParameter(interfaceC11770i, "workerScope");
        C12238m.checkNotNullParameter(c11914c1, "givenSubstitutor");
        this.f24377b = interfaceC11770i;
        AbstractC12018z0 substitution = c11914c1.getSubstitution();
        C12238m.checkNotNullExpressionValue(substitution, "givenSubstitutor.substitution");
        this.f24378c = C11806d.wrapWithCapturingSubstitution$default(substitution, false, 1, null).buildSubstitutor();
        this.f24380e = C12083g.lazy(new a());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    public final <D extends InterfaceC11450m> Collection<D> m9912a(Collection<? extends D> collection) {
        if (this.f24378c.isEmpty() || collection.isEmpty()) {
            return collection;
        }
        LinkedHashSet linkedHashSetNewLinkedHashSetWithExpectedSize = C12033a.newLinkedHashSetWithExpectedSize(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            linkedHashSetNewLinkedHashSetWithExpectedSize.add(m9913b((InterfaceC11450m) it.next()));
        }
        return linkedHashSetNewLinkedHashSetWithExpectedSize;
    }

    /* JADX INFO: renamed from: b */
    public final <D extends InterfaceC11450m> D m9913b(D d) {
        if (this.f24378c.isEmpty()) {
            return d;
        }
        if (this.f24379d == null) {
            this.f24379d = new HashMap();
        }
        Map<InterfaceC11450m, InterfaceC11450m> map = this.f24379d;
        C12238m.checkNotNull(map);
        InterfaceC11450m interfaceC11450mSubstitute = map.get(d);
        if (interfaceC11450mSubstitute == null) {
            if (!(d instanceof InterfaceC11471w0)) {
                throw new IllegalStateException(C12238m.stringPlus("Unknown descriptor in scope: ", d).toString());
            }
            interfaceC11450mSubstitute = ((InterfaceC11471w0) d).substitute(this.f24378c);
            if (interfaceC11450mSubstitute == null) {
                throw new AssertionError("We expect that no conflict should happen while substitution is guaranteed to generate invariant projection, but " + d + " substitution fails");
            }
            map.put(d, interfaceC11450mSubstitute);
        }
        return (D) interfaceC11450mSubstitute;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i
    public Set<C11716e> getClassifierNames() {
        return this.f24377b.getClassifierNames();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11773l
    public InterfaceC11352h getContributedClassifier(C11716e c11716e, InterfaceC11480b interfaceC11480b) {
        C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(interfaceC11480b, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        InterfaceC11352h contributedClassifier = this.f24377b.getContributedClassifier(c11716e, interfaceC11480b);
        if (contributedClassifier == null) {
            return null;
        }
        return (InterfaceC11352h) m9913b(contributedClassifier);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11773l
    public Collection<InterfaceC11450m> getContributedDescriptors(C11765d c11765d, Function1<? super C11716e, Boolean> function1) {
        C12238m.checkNotNullParameter(c11765d, "kindFilter");
        C12238m.checkNotNullParameter(function1, "nameFilter");
        return (Collection) this.f24380e.getValue();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i
    public Collection<? extends InterfaceC11465t0> getContributedFunctions(C11716e c11716e, InterfaceC11480b interfaceC11480b) {
        C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(interfaceC11480b, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return m9912a(this.f24377b.getContributedFunctions(c11716e, interfaceC11480b));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i
    public Collection<? extends InterfaceC11453n0> getContributedVariables(C11716e c11716e, InterfaceC11480b interfaceC11480b) {
        C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(interfaceC11480b, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return m9912a(this.f24377b.getContributedVariables(c11716e, interfaceC11480b));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i
    public Set<C11716e> getFunctionNames() {
        return this.f24377b.getFunctionNames();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i
    public Set<C11716e> getVariableNames() {
        return this.f24377b.getVariableNames();
    }
}
