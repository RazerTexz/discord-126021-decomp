package b.i.c.m.d.k;

import android.util.Log;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: CrashlyticsController.java */
/* JADX INFO: loaded from: classes3.dex */
public class p implements Callable<Void> {
    public final /* synthetic */ f1 j;
    public final /* synthetic */ x k;

    public p(x xVar, f1 f1Var) {
        this.k = xVar;
        this.j = f1Var;
    }

    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        BufferedWriter bufferedWriter;
        String strI = this.k.i();
        BufferedWriter bufferedWriter2 = null;
        if (strI == null) {
            b.i.c.m.d.b.a.b("Tried to cache user data while no session was open.");
        } else {
            d1 d1Var = this.k.A;
            String strReplaceAll = strI.replaceAll("-", "");
            String str = d1Var.e.a;
            if (str == null) {
                b.i.c.m.d.b.a.b("Could not persist user ID; no user ID available");
            } else {
                try {
                    b.i.c.m.d.o.g.l(new File(d1Var.f1680b.h(strReplaceAll), "user"), str);
                } catch (IOException e) {
                    b.i.c.m.d.b.a.c("Could not persist user ID for session " + strReplaceAll, e);
                }
            }
            z0 z0Var = new z0(this.k.l());
            f1 f1Var = this.j;
            File fileB = z0Var.b(strI);
            try {
                String string = new y0(f1Var).toString();
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileB), z0.a));
                try {
                    bufferedWriter.write(string);
                    bufferedWriter.flush();
                } catch (Exception e2) {
                    e = e2;
                    try {
                        if (b.i.c.m.d.b.a.a(6)) {
                            Log.e("FirebaseCrashlytics", "Error serializing user metadata.", e);
                        }
                    } catch (Throwable th) {
                        th = th;
                        bufferedWriter2 = bufferedWriter;
                        bufferedWriter = bufferedWriter2;
                        h.c(bufferedWriter, "Failed to close user metadata file.");
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    h.c(bufferedWriter, "Failed to close user metadata file.");
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                bufferedWriter = null;
            } catch (Throwable th3) {
                th = th3;
                bufferedWriter = bufferedWriter2;
                h.c(bufferedWriter, "Failed to close user metadata file.");
                throw th;
            }
            h.c(bufferedWriter, "Failed to close user metadata file.");
        }
        return null;
    }
}
