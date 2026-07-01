package b.i.c.m.d;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;

/* JADX INFO: compiled from: Onboarding.java */
/* JADX INFO: loaded from: classes3.dex */
public class g implements b.i.a.f.n.a<Void, Object> {
    public g(h hVar) {
    }

    @Override // b.i.a.f.n.a
    public Object a(@NonNull Task<Void> task) throws Exception {
        if (task.p()) {
            return null;
        }
        b bVar = b.a;
        Exception excK = task.k();
        if (!bVar.a(6)) {
            return null;
        }
        Log.e("FirebaseCrashlytics", "Error fetching settings.", excK);
        return null;
    }
}
