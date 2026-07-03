package p007b.p225i.p226a.p288f.p313h.p325l;

import java.lang.reflect.Field;
import java.security.PrivilegedExceptionAction;
import sun.misc.Unsafe;

/* JADX INFO: renamed from: b.i.a.f.h.l.i7 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3697i7 implements PrivilegedExceptionAction<Unsafe> {
    @Override // java.security.PrivilegedExceptionAction
    public final /* synthetic */ Unsafe run() throws Exception {
        for (Field field : Unsafe.class.getDeclaredFields()) {
            field.setAccessible(true);
            Object obj = field.get(null);
            if (Unsafe.class.isInstance(obj)) {
                return (Unsafe) Unsafe.class.cast(obj);
            }
        }
        return null;
    }
}
