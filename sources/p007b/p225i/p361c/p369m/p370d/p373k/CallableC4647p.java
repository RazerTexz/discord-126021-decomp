package p007b.p225i.p361c.p369m.p370d.p373k;

import android.util.Log;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.concurrent.Callable;
import p007b.p225i.p361c.p369m.p370d.C4592b;
import p007b.p225i.p361c.p369m.p370d.p378o.C4714g;

/* JADX INFO: renamed from: b.i.c.m.d.k.p */
/* JADX INFO: compiled from: CrashlyticsController.java */
/* JADX INFO: loaded from: classes3.dex */
public class CallableC4647p implements Callable<Void> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ C4624f1 f12363j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ C4663x f12364k;

    public CallableC4647p(C4663x c4663x, C4624f1 c4624f1) {
        this.f12364k = c4663x;
        this.f12363j = c4624f1;
    }

    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        BufferedWriter bufferedWriter;
        String strM6474i = this.f12364k.m6474i();
        BufferedWriter bufferedWriter2 = null;
        if (strM6474i == null) {
            C4592b.f12227a.m6371b("Tried to cache user data while no session was open.");
        } else {
            C4618d1 c4618d1 = this.f12364k.f12422A;
            String strReplaceAll = strM6474i.replaceAll("-", "");
            String str = c4618d1.f12282e.f12290a;
            if (str == null) {
                C4592b.f12227a.m6371b("Could not persist user ID; no user ID available");
            } else {
                try {
                    C4714g.m6631l(new File(c4618d1.f12279b.m6635h(strReplaceAll), "user"), str);
                } catch (IOException e) {
                    C4592b.f12227a.m6372c("Could not persist user ID for session " + strReplaceAll, e);
                }
            }
            C4668z0 c4668z0 = new C4668z0(this.f12364k.m6476l());
            C4624f1 c4624f1 = this.f12363j;
            File fileM6490b = c4668z0.m6490b(strM6474i);
            try {
                String string = new C4666y0(c4624f1).toString();
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileM6490b), C4668z0.f12468a));
                try {
                    bufferedWriter.write(string);
                    bufferedWriter.flush();
                } catch (Exception e2) {
                    e = e2;
                    try {
                        if (C4592b.f12227a.m6370a(6)) {
                            Log.e("FirebaseCrashlytics", "Error serializing user metadata.", e);
                        }
                    } catch (Throwable th) {
                        th = th;
                        bufferedWriter2 = bufferedWriter;
                        bufferedWriter = bufferedWriter2;
                        C4628h.m6409c(bufferedWriter, "Failed to close user metadata file.");
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    C4628h.m6409c(bufferedWriter, "Failed to close user metadata file.");
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                bufferedWriter = null;
            } catch (Throwable th3) {
                th = th3;
                bufferedWriter = bufferedWriter2;
                C4628h.m6409c(bufferedWriter, "Failed to close user metadata file.");
                throw th;
            }
            C4628h.m6409c(bufferedWriter, "Failed to close user metadata file.");
        }
        return null;
    }
}
