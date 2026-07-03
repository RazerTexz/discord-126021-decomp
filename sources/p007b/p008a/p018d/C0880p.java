package p007b.p008a.p018d;

import java.util.Map;
import p637j0.p641k.InterfaceC12589b;

/* JADX INFO: Add missing generic type declarations: [K] */
/* JADX INFO: renamed from: b.a.d.p */
/* JADX INFO: compiled from: AppTransformers.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0880p<T, R, K> implements InterfaceC12589b<K, Boolean> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ Map f575j;

    public C0880p(Map map) {
        this.f575j = map;
    }

    @Override // p637j0.p641k.InterfaceC12589b
    public Boolean call(Object obj) {
        return Boolean.valueOf(this.f575j.containsKey(obj));
    }
}
