package p507d0.p513e0.p514p.p515d.p517m0.p550i;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: d0.e0.p.d.m0.i.e */
/* JADX INFO: compiled from: ExtensionRegistryLite.java */
/* JADX INFO: loaded from: classes3.dex */
public class C11725e {

    /* JADX INFO: renamed from: a */
    public static final C11725e f24117a = new C11725e(true);

    /* JADX INFO: renamed from: b */
    public final Map<a, AbstractC11727g.f<?, ?>> f24118b;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.i.e$a */
    /* JADX INFO: compiled from: ExtensionRegistryLite.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public final Object f24119a;

        /* JADX INFO: renamed from: b */
        public final int f24120b;

        public a(Object obj, int i) {
            this.f24119a = obj;
            this.f24120b = i;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f24119a == aVar.f24119a && this.f24120b == aVar.f24120b;
        }

        public int hashCode() {
            return (System.identityHashCode(this.f24119a) * 65535) + this.f24120b;
        }
    }

    public C11725e() {
        this.f24118b = new HashMap();
    }

    public static C11725e getEmptyRegistry() {
        return f24117a;
    }

    public static C11725e newInstance() {
        return new C11725e();
    }

    public final void add(AbstractC11727g.f<?, ?> fVar) {
        this.f24118b.put(new a(fVar.getContainingTypeDefaultInstance(), fVar.getNumber()), fVar);
    }

    public <ContainingType extends InterfaceC11734n> AbstractC11727g.f<ContainingType, ?> findLiteExtensionByNumber(ContainingType containingtype, int i) {
        return (AbstractC11727g.f) this.f24118b.get(new a(containingtype, i));
    }

    public C11725e(boolean z2) {
        this.f24118b = Collections.emptyMap();
    }
}
