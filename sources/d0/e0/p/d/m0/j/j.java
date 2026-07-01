package d0.e0.p.d.m0.j;

import kotlin.reflect.KProperty;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: Delegates.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j<T> extends d0.b0.a<T> {
    public final /* synthetic */ Object a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i f3449b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(Object obj, Object obj2, i iVar) {
        super(obj2);
        this.a = obj;
        this.f3449b = iVar;
    }

    @Override // d0.b0.a
    public boolean beforeChange(KProperty<?> kProperty, T t, T t2) {
        d0.z.d.m.checkNotNullParameter(kProperty, "property");
        if (this.f3449b.isLocked()) {
            throw new IllegalStateException("Cannot modify readonly DescriptorRendererOptions");
        }
        return true;
    }
}
