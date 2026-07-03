package p507d0.p513e0.p514p.p515d.p517m0.p551j;

import kotlin.reflect.KProperty;
import p507d0.p509b0.AbstractC11212a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: d0.e0.p.d.m0.j.j */
/* JADX INFO: compiled from: Delegates.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11753j<T> extends AbstractC11212a<T> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Object f24312a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ C11752i f24313b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11753j(Object obj, Object obj2, C11752i c11752i) {
        super(obj2);
        this.f24312a = obj;
        this.f24313b = c11752i;
    }

    @Override // p507d0.p509b0.AbstractC11212a
    public boolean beforeChange(KProperty<?> kProperty, T t, T t2) {
        C12238m.checkNotNullParameter(kProperty, "property");
        if (this.f24313b.isLocked()) {
            throw new IllegalStateException("Cannot modify readonly DescriptorRendererOptions");
        }
        return true;
    }
}
