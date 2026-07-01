package d0.e0.p.d.m0.b.q;

import d0.e0.p.d.m0.e.b.t;
import d0.e0.p.d.m0.e.b.w;
import d0.e0.p.d.m0.p.b$b;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: JvmBuiltInsCustomizer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l extends b$b<d0.e0.p.d.m0.c.e, g$a> {
    public final /* synthetic */ String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref$ObjectRef<g$a> f3241b;

    public l(String str, Ref$ObjectRef<g$a> ref$ObjectRef) {
        this.a = str;
        this.f3241b = ref$ObjectRef;
    }

    @Override // d0.e0.p.d.m0.p.b$d
    public /* bridge */ /* synthetic */ boolean beforeChildren(Object obj) {
        return beforeChildren((d0.e0.p.d.m0.c.e) obj);
    }

    @Override // d0.e0.p.d.m0.p.b$d
    public /* bridge */ /* synthetic */ Object result() {
        return result();
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [T, d0.e0.p.d.m0.b.q.g$a] */
    /* JADX WARN: Type inference failed for: r0v5, types: [T, d0.e0.p.d.m0.b.q.g$a] */
    /* JADX WARN: Type inference failed for: r0v6, types: [T, d0.e0.p.d.m0.b.q.g$a] */
    public boolean beforeChildren(d0.e0.p.d.m0.c.e eVar) {
        d0.z.d.m.checkNotNullParameter(eVar, "javaClassDescriptor");
        String strSignature = t.signature(w.a, eVar, this.a);
        p pVar = p.a;
        if (pVar.getHIDDEN_METHOD_SIGNATURES().contains(strSignature)) {
            this.f3241b.element = g$a.HIDDEN;
        } else if (pVar.getVISIBLE_METHOD_SIGNATURES().contains(strSignature)) {
            this.f3241b.element = g$a.VISIBLE;
        } else if (pVar.getDROP_LIST_METHOD_SIGNATURES().contains(strSignature)) {
            this.f3241b.element = g$a.DROP;
        }
        return this.f3241b.element == null;
    }

    @Override // d0.e0.p.d.m0.p.b$d
    public g$a result() {
        g$a g_a = this.f3241b.element;
        return g_a == null ? g$a.NOT_CONSIDERED : g_a;
    }
}
