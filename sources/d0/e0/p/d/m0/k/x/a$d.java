package d0.e0.p.d.m0.k.x;

import d0.e0.p.d.m0.c.b;
import d0.e0.p.d.m0.p.b$b;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: DescriptorUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a$d extends b$b<b, b> {
    public final /* synthetic */ Ref$ObjectRef<b> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1<b, Boolean> f3477b;

    /* JADX WARN: Multi-variable type inference failed */
    public a$d(Ref$ObjectRef<b> ref$ObjectRef, Function1<? super b, Boolean> function1) {
        this.a = ref$ObjectRef;
        this.f3477b = function1;
    }

    @Override // d0.e0.p.d.m0.p.b$b, d0.e0.p.d.m0.p.b$d
    public /* bridge */ /* synthetic */ void afterChildren(Object obj) {
        afterChildren((b) obj);
    }

    @Override // d0.e0.p.d.m0.p.b$d
    public /* bridge */ /* synthetic */ boolean beforeChildren(Object obj) {
        return beforeChildren((b) obj);
    }

    @Override // d0.e0.p.d.m0.p.b$d
    public /* bridge */ /* synthetic */ Object result() {
        return result();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void afterChildren(b bVar) {
        m.checkNotNullParameter(bVar, "current");
        if (this.a.element == null && this.f3477b.invoke(bVar).booleanValue()) {
            this.a.element = bVar;
        }
    }

    public boolean beforeChildren(b bVar) {
        m.checkNotNullParameter(bVar, "current");
        return this.a.element == null;
    }

    @Override // d0.e0.p.d.m0.p.b$d
    public b result() {
        return this.a.element;
    }
}
