package b.i.c.m.d;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;

/* JADX INFO: renamed from: b.i.c.m.d.g, reason: use source file name */
/* JADX INFO: compiled from: Onboarding.java */
/* JADX INFO: loaded from: classes3.dex */
public class Onboarding3 implements b.i.a.f.n.a<Void, Object> {
    public Onboarding3(Onboarding4 onboarding4) {
    }

    @Override // b.i.a.f.n.a
    public Object a(@NonNull Task<Void> task) throws Exception {
        if (task.p()) {
            return null;
        }
        Logger3 logger3 = Logger3.a;
        Exception excK = task.k();
        if (!logger3.a(6)) {
            return null;
        }
        Log.e("FirebaseCrashlytics", "Error fetching settings.", excK);
        return null;
    }
}
