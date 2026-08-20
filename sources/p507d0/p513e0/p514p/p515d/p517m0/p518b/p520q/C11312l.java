package p507d0.p513e0.p514p.p515d.p517m0.p518b.p520q;

import kotlin.jvm.internal.Ref$ObjectRef;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.C11659t;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.C11662w;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.C12034b;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.b.q.l */
/* JADX INFO: compiled from: JvmBuiltInsCustomizer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11312l extends C12034b.b<InterfaceC11330e, C11307g.a> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ String f22663a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Ref$ObjectRef<C11307g.a> f22664b;

    public C11312l(String str, Ref$ObjectRef<C11307g.a> ref$ObjectRef) {
        this.f22663a = str;
        this.f22664b = ref$ObjectRef;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [T, d0.e0.p.d.m0.b.q.g$a] */
    /* JADX WARN: Type inference failed for: r0v5, types: [T, d0.e0.p.d.m0.b.q.g$a] */
    /* JADX WARN: Type inference failed for: r0v6, types: [T, d0.e0.p.d.m0.b.q.g$a] */
    @Override // p507d0.p513e0.p514p.p515d.p517m0.p576p.C12034b.d
    public boolean beforeChildren(InterfaceC11330e interfaceC11330e) {
        C12238m.checkNotNullParameter(interfaceC11330e, "javaClassDescriptor");
        String strSignature = C11659t.signature(C11662w.f23636a, interfaceC11330e, this.f22663a);
        C11316p c11316p = C11316p.f22666a;
        if (c11316p.getHIDDEN_METHOD_SIGNATURES().contains(strSignature)) {
            this.f22664b.element = C11307g.a.HIDDEN;
        } else if (c11316p.getVISIBLE_METHOD_SIGNATURES().contains(strSignature)) {
            this.f22664b.element = C11307g.a.VISIBLE;
        } else if (c11316p.getDROP_LIST_METHOD_SIGNATURES().contains(strSignature)) {
            this.f22664b.element = C11307g.a.DROP;
        }
        return this.f22664b.element == null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p576p.C12034b.d
    public C11307g.a result() {
        C11307g.a aVar = this.f22664b.element;
        return aVar == null ? C11307g.a.NOT_CONSIDERED : aVar;
    }
}
