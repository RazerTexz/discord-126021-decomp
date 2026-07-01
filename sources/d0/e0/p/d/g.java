package d0.e0.p.d;

import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: kClassCache.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g {
    public static d0.e0.p.d.n0.b<String, Object> a;

    static {
        d0.e0.p.d.n0.b<String, Object> bVarEmpty = d0.e0.p.d.n0.b.empty();
        d0.z.d.m.checkNotNullExpressionValue(bVarEmpty, "HashPMap.empty<String, Any>()");
        a = bVarEmpty;
    }

    public static final <T> h<T> getOrCreateKotlinClass(Class<T> cls) {
        d0.z.d.m.checkNotNullParameter(cls, "jClass");
        String name = cls.getName();
        Object obj = a.get(name);
        if (obj instanceof WeakReference) {
            h<T> hVar = (h) ((WeakReference) obj).get();
            if (d0.z.d.m.areEqual(hVar != null ? hVar.getJClass() : null, cls)) {
                return hVar;
            }
        } else if (obj != null) {
            for (WeakReference weakReference : (WeakReference[]) obj) {
                h<T> hVar2 = (h) weakReference.get();
                if (d0.z.d.m.areEqual(hVar2 != null ? hVar2.getJClass() : null, cls)) {
                    return hVar2;
                }
            }
            int length = ((Object[]) obj).length;
            WeakReference[] weakReferenceArr = new WeakReference[length + 1];
            System.arraycopy(obj, 0, weakReferenceArr, 0, length);
            h<T> hVar3 = new h<>(cls);
            weakReferenceArr[length] = new WeakReference(hVar3);
            d0.e0.p.d.n0.b<String, Object> bVarPlus = a.plus(name, weakReferenceArr);
            d0.z.d.m.checkNotNullExpressionValue(bVarPlus, "K_CLASS_CACHE.plus(name, newArray)");
            a = bVarPlus;
            return hVar3;
        }
        h<T> hVar4 = new h<>(cls);
        d0.e0.p.d.n0.b<String, Object> bVarPlus2 = a.plus(name, new WeakReference(hVar4));
        d0.z.d.m.checkNotNullExpressionValue(bVarPlus2, "K_CLASS_CACHE.plus(name, WeakReference(newKClass))");
        a = bVarPlus2;
        return hVar4;
    }
}
