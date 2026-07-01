package b.i.c.m.d.k;

import android.util.Log;
import b.i.c.m.d.Logger3;
import b.i.c.m.d.o.CrashlyticsReportPersistence7;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: CrashlyticsController.java */
/* JADX INFO: loaded from: classes3.dex */
public class p implements Callable<Void> {
    public final /* synthetic */ UserMetadata j;
    public final /* synthetic */ x k;

    public p(x xVar, UserMetadata userMetadata) {
        this.k = xVar;
        this.j = userMetadata;
    }

    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        BufferedWriter bufferedWriter;
        String strI = this.k.i();
        BufferedWriter bufferedWriter2 = null;
        if (strI == null) {
            Logger3.a.b("Tried to cache user data while no session was open.");
        } else {
            SessionReportingCoordinator3 sessionReportingCoordinator3 = this.k.A;
            String strReplaceAll = strI.replaceAll("-", "");
            String str = sessionReportingCoordinator3.e.a;
            if (str == null) {
                Logger3.a.b("Could not persist user ID; no user ID available");
            } else {
                try {
                    CrashlyticsReportPersistence7.l(new File(sessionReportingCoordinator3.f1680b.h(strReplaceAll), "user"), str);
                } catch (IOException e) {
                    Logger3.a.c("Could not persist user ID for session " + strReplaceAll, e);
                }
            }
            MetaDataStore2 metaDataStore2 = new MetaDataStore2(this.k.l());
            UserMetadata userMetadata = this.j;
            File fileB = metaDataStore2.b(strI);
            try {
                String string = new MetaDataStore(userMetadata).toString();
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileB), MetaDataStore2.a));
                try {
                    bufferedWriter.write(string);
                    bufferedWriter.flush();
                } catch (Exception e2) {
                    e = e2;
                    try {
                        if (Logger3.a.a(6)) {
                            Log.e("FirebaseCrashlytics", "Error serializing user metadata.", e);
                        }
                    } catch (Throwable th) {
                        th = th;
                        bufferedWriter2 = bufferedWriter;
                        bufferedWriter = bufferedWriter2;
                        CommonUtils.c(bufferedWriter, "Failed to close user metadata file.");
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    CommonUtils.c(bufferedWriter, "Failed to close user metadata file.");
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                bufferedWriter = null;
            } catch (Throwable th3) {
                th = th3;
                bufferedWriter = bufferedWriter2;
                CommonUtils.c(bufferedWriter, "Failed to close user metadata file.");
                throw th;
            }
            CommonUtils.c(bufferedWriter, "Failed to close user metadata file.");
        }
        return null;
    }
}
