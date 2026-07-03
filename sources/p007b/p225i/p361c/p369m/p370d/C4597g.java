package p007b.p225i.p361c.p369m.p370d;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4353a;

/* JADX INFO: renamed from: b.i.c.m.d.g */
/* JADX INFO: compiled from: Onboarding.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4597g implements InterfaceC4353a<Void, Object> {
    public C4597g(C4598h c4598h) {
    }

    @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4353a
    /* JADX INFO: renamed from: a */
    public Object mo4012a(@NonNull Task<Void> task) throws Exception {
        if (task.mo6021p()) {
            return null;
        }
        C4592b c4592b = C4592b.f12227a;
        Exception excMo6016k = task.mo6016k();
        if (!c4592b.m6370a(6)) {
            return null;
        }
        Log.e("FirebaseCrashlytics", "Error fetching settings.", excMo6016k);
        return null;
    }
}
