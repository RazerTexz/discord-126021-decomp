package d0.e0.p.d.m0.b;

import d0.e0.p.d.m0.c.i1.y;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: KotlinBuiltIns.java */
/* JADX INFO: loaded from: classes3.dex */
public class h$d implements Function0<Void> {
    public final /* synthetic */ y j;
    public final /* synthetic */ h k;

    public h$d(h hVar, y yVar) {
        this.k = hVar;
        this.j = yVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Void invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public Void invoke2() {
        h hVar = this.k;
        if (hVar.f3211b == null) {
            hVar.f3211b = this.j;
            return null;
        }
        StringBuilder sbU = b.d.b.a.a.U("Built-ins module is already set: ");
        sbU.append(this.k.f3211b);
        sbU.append(" (attempting to reset to ");
        sbU.append(this.j);
        sbU.append(")");
        throw new AssertionError(sbU.toString());
    }
}
