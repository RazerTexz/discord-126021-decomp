package p507d0.p513e0.p514p.p515d.p517m0.p521c;

import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12012w0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.l0 */
/* JADX INFO: compiled from: typeParameterUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11449l0 {

    /* JADX INFO: renamed from: a */
    public final InterfaceC11359i f23073a;

    /* JADX INFO: renamed from: b */
    public final List<InterfaceC12012w0> f23074b;

    /* JADX INFO: renamed from: c */
    public final C11449l0 f23075c;

    /* JADX WARN: Multi-variable type inference failed */
    public C11449l0(InterfaceC11359i interfaceC11359i, List<? extends InterfaceC12012w0> list, C11449l0 c11449l0) {
        C12238m.checkNotNullParameter(interfaceC11359i, "classifierDescriptor");
        C12238m.checkNotNullParameter(list, "arguments");
        this.f23073a = interfaceC11359i;
        this.f23074b = list;
        this.f23075c = c11449l0;
    }

    public final List<InterfaceC12012w0> getArguments() {
        return this.f23074b;
    }

    public final InterfaceC11359i getClassifierDescriptor() {
        return this.f23073a;
    }

    public final C11449l0 getOuterType() {
        return this.f23075c;
    }
}
