package i0;

import android.os.Build$VERSION;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: Platform.java */
/* JADX INFO: loaded from: classes3.dex */
public final class u$a extends u {
    public u$a() {
        super(Build$VERSION.SDK_INT >= 24);
    }

    @Override // i0.u
    public Executor a() {
        return new u$a$a();
    }

    @Override // i0.u
    public Object b(Method method, Class<?> cls, Object obj, Object... objArr) throws Throwable {
        if (Build$VERSION.SDK_INT >= 26) {
            return super.b(method, cls, obj, objArr);
        }
        throw new UnsupportedOperationException("Calling default methods on API 24 and 25 is not supported");
    }
}
