package b.i.a.f.e.p;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public class b {
    public static b a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public a f1400b = null;

    @RecentlyNonNull
    public static a a(@RecentlyNonNull Context context) {
        a aVar;
        b bVar = a;
        synchronized (bVar) {
            if (bVar.f1400b == null) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                bVar.f1400b = new a(context);
            }
            aVar = bVar.f1400b;
        }
        return aVar;
    }
}
