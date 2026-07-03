package p507d0.p513e0.p514p.p515d;

import java.lang.ref.WeakReference;
import p507d0.p513e0.p514p.p515d.p577n0.C12045b;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.g */
/* JADX INFO: compiled from: kClassCache.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11258g {

    /* JADX INFO: renamed from: a */
    public static C12045b<String, Object> f22359a;

    static {
        C12045b<String, Object> c12045bEmpty = C12045b.empty();
        C12238m.checkNotNullExpressionValue(c12045bEmpty, "HashPMap.empty<String, Any>()");
        f22359a = c12045bEmpty;
    }

    public static final <T> C11260h<T> getOrCreateKotlinClass(Class<T> cls) {
        C12238m.checkNotNullParameter(cls, "jClass");
        String name = cls.getName();
        Object obj = f22359a.get(name);
        if (obj instanceof WeakReference) {
            C11260h<T> c11260h = (C11260h) ((WeakReference) obj).get();
            if (C12238m.areEqual(c11260h != null ? c11260h.getJClass() : null, cls)) {
                return c11260h;
            }
        } else if (obj != null) {
            for (WeakReference weakReference : (WeakReference[]) obj) {
                C11260h<T> c11260h2 = (C11260h) weakReference.get();
                if (C12238m.areEqual(c11260h2 != null ? c11260h2.getJClass() : null, cls)) {
                    return c11260h2;
                }
            }
            int length = ((Object[]) obj).length;
            WeakReference[] weakReferenceArr = new WeakReference[length + 1];
            System.arraycopy(obj, 0, weakReferenceArr, 0, length);
            C11260h<T> c11260h3 = new C11260h<>(cls);
            weakReferenceArr[length] = new WeakReference(c11260h3);
            C12045b<String, Object> c12045bPlus = f22359a.plus(name, weakReferenceArr);
            C12238m.checkNotNullExpressionValue(c12045bPlus, "K_CLASS_CACHE.plus(name, newArray)");
            f22359a = c12045bPlus;
            return c11260h3;
        }
        C11260h<T> c11260h4 = new C11260h<>(cls);
        C12045b<String, Object> c12045bPlus2 = f22359a.plus(name, new WeakReference(c11260h4));
        C12238m.checkNotNullExpressionValue(c12045bPlus2, "K_CLASS_CACHE.plus(name, WeakReference(newKClass))");
        f22359a = c12045bPlus2;
        return c11260h4;
    }
}
