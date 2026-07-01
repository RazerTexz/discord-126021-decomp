package b.i.c.m.d.k;

import android.util.Log;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* JADX INFO: compiled from: CrashlyticsController.java */
/* JADX INFO: loaded from: classes3.dex */
public class q implements Callable<Void> {
    public final /* synthetic */ Map j;
    public final /* synthetic */ x k;

    public q(x xVar, Map map) {
        this.k = xVar;
        this.j = map;
    }

    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        BufferedWriter bufferedWriter;
        String strI = this.k.i();
        z0 z0Var = new z0(this.k.l());
        Map map = this.j;
        File fileA = z0Var.a(strI);
        BufferedWriter bufferedWriter2 = null;
        try {
            String string = new JSONObject(map).toString();
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileA), z0.a));
            try {
                bufferedWriter.write(string);
                bufferedWriter.flush();
            } catch (Exception e) {
                e = e;
                try {
                    if (b.i.c.m.d.b.a.a(6)) {
                        Log.e("FirebaseCrashlytics", "Error serializing key/value metadata.", e);
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedWriter2 = bufferedWriter;
                    bufferedWriter = bufferedWriter2;
                    h.c(bufferedWriter, "Failed to close key/value metadata file.");
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                h.c(bufferedWriter, "Failed to close key/value metadata file.");
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            bufferedWriter = null;
        } catch (Throwable th3) {
            th = th3;
            bufferedWriter = bufferedWriter2;
            h.c(bufferedWriter, "Failed to close key/value metadata file.");
            throw th;
        }
        h.c(bufferedWriter, "Failed to close key/value metadata file.");
        return null;
    }
}
