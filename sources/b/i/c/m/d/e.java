package b.i.c.m.d;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: Onboarding.java */
/* JADX INFO: loaded from: classes3.dex */
public class e implements b.i.a.f.n.f<b.i.c.m.d.s.h.b, Void> {
    public final /* synthetic */ String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b.i.c.m.d.s.c f1673b;
    public final /* synthetic */ Executor c;
    public final /* synthetic */ h d;

    public e(h hVar, String str, b.i.c.m.d.s.c cVar, Executor executor) {
        this.d = hVar;
        this.a = str;
        this.f1673b = cVar;
        this.c = executor;
    }

    @Override // b.i.a.f.n.f
    @NonNull
    public Task<Void> a(@Nullable b.i.c.m.d.s.h.b bVar) throws Exception {
        try {
            h.a(this.d, bVar, this.a, this.f1673b, this.c, true);
            return null;
        } catch (Exception e) {
            if (b.a.a(6)) {
                Log.e("FirebaseCrashlytics", "Error performing auto configuration.", e);
            }
            throw e;
        }
    }
}
