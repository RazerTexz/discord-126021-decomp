package d0.e0.p.d.m0.i;

import d0.e0.p.d.m0.i.GeneratedMessageLite;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: d0.e0.p.d.m0.i.e, reason: use source file name */
/* JADX INFO: compiled from: ExtensionRegistryLite.java */
/* JADX INFO: loaded from: classes3.dex */
public class ExtensionRegistryLite {
    public static final ExtensionRegistryLite a = new ExtensionRegistryLite(true);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<a, GeneratedMessageLite.f<?, ?>> f3427b;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.i.e$a */
    /* JADX INFO: compiled from: ExtensionRegistryLite.java */
    public static final class a {
        public final Object a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f3428b;

        public a(Object obj, int i) {
            this.a = obj;
            this.f3428b = i;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.f3428b == aVar.f3428b;
        }

        public int hashCode() {
            return (System.identityHashCode(this.a) * 65535) + this.f3428b;
        }
    }

    public ExtensionRegistryLite() {
        this.f3427b = new HashMap();
    }

    public static ExtensionRegistryLite getEmptyRegistry() {
        return a;
    }

    public static ExtensionRegistryLite newInstance() {
        return new ExtensionRegistryLite();
    }

    public final void add(GeneratedMessageLite.f<?, ?> fVar) {
        this.f3427b.put(new a(fVar.getContainingTypeDefaultInstance(), fVar.getNumber()), fVar);
    }

    public <ContainingType extends MessageLite> GeneratedMessageLite.f<ContainingType, ?> findLiteExtensionByNumber(ContainingType containingtype, int i) {
        return (GeneratedMessageLite.f) this.f3427b.get(new a(containingtype, i));
    }

    public ExtensionRegistryLite(boolean z2) {
        this.f3427b = Collections.emptyMap();
    }
}
