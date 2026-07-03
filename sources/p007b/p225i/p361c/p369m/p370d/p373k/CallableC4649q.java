package p007b.p225i.p361c.p369m.p370d.p373k;

import android.util.Log;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.concurrent.Callable;
import org.json.JSONObject;
import p007b.p225i.p361c.p369m.p370d.C4592b;

/* JADX INFO: renamed from: b.i.c.m.d.k.q */
/* JADX INFO: compiled from: CrashlyticsController.java */
/* JADX INFO: loaded from: classes3.dex */
public class CallableC4649q implements Callable<Void> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ Map f12369j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ C4663x f12370k;

    public CallableC4649q(C4663x c4663x, Map map) {
        this.f12370k = c4663x;
        this.f12369j = map;
    }

    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        BufferedWriter bufferedWriter;
        String strM6474i = this.f12370k.m6474i();
        C4668z0 c4668z0 = new C4668z0(this.f12370k.m6476l());
        Map map = this.f12369j;
        File fileM6489a = c4668z0.m6489a(strM6474i);
        BufferedWriter bufferedWriter2 = null;
        try {
            String string = new JSONObject(map).toString();
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileM6489a), C4668z0.f12468a));
            try {
                bufferedWriter.write(string);
                bufferedWriter.flush();
            } catch (Exception e) {
                e = e;
                try {
                    if (C4592b.f12227a.m6370a(6)) {
                        Log.e("FirebaseCrashlytics", "Error serializing key/value metadata.", e);
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedWriter2 = bufferedWriter;
                    bufferedWriter = bufferedWriter2;
                    C4628h.m6409c(bufferedWriter, "Failed to close key/value metadata file.");
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                C4628h.m6409c(bufferedWriter, "Failed to close key/value metadata file.");
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            bufferedWriter = null;
        } catch (Throwable th3) {
            th = th3;
            bufferedWriter = bufferedWriter2;
            C4628h.m6409c(bufferedWriter, "Failed to close key/value metadata file.");
            throw th;
        }
        C4628h.m6409c(bufferedWriter, "Failed to close key/value metadata file.");
        return null;
    }
}
