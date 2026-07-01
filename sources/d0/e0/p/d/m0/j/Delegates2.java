package d0.e0.p.d.m0.j;

import d0.b0.ObservableProperty;
import d0.z.d.Intrinsics3;
import kotlin.reflect.KProperty;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: d0.e0.p.d.m0.j.j, reason: use source file name */
/* JADX INFO: compiled from: Delegates.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Delegates2<T> extends ObservableProperty<T> {
    public final /* synthetic */ Object a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DescriptorRendererOptionsImpl f3449b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Delegates2(Object obj, Object obj2, DescriptorRendererOptionsImpl descriptorRendererOptionsImpl) {
        super(obj2);
        this.a = obj;
        this.f3449b = descriptorRendererOptionsImpl;
    }

    @Override // d0.b0.ObservableProperty
    public boolean beforeChange(KProperty<?> kProperty, T t, T t2) {
        Intrinsics3.checkNotNullParameter(kProperty, "property");
        if (this.f3449b.isLocked()) {
            throw new IllegalStateException("Cannot modify readonly DescriptorRendererOptions");
        }
        return true;
    }
}
