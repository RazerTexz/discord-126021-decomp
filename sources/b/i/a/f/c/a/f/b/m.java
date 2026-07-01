package b.i.a.f.c.a.f.b;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class m {

    @Nullable
    public static m a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f1337b;

    public m(Context context) {
        a aVarA = a.a(context);
        this.f1337b = aVarA;
        aVarA.b();
        this.f1337b.c();
    }

    public static synchronized m b(@NonNull Context context) {
        m mVar;
        Context applicationContext = context.getApplicationContext();
        synchronized (m.class) {
            mVar = a;
            if (mVar == null) {
                mVar = new m(applicationContext);
                a = mVar;
            }
        }
        return mVar;
        return mVar;
    }

    public final synchronized void a() {
        a aVar = this.f1337b;
        aVar.c.lock();
        try {
            aVar.d.edit().clear().apply();
            aVar.c.unlock();
        } catch (Throwable th) {
            aVar.c.unlock();
            throw th;
        }
    }
}
