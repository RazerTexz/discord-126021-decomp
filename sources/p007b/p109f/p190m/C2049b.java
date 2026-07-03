package p007b.p109f.p190m;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.StrictMode;
import android.util.Log;
import java.io.File;
import java.io.IOException;

/* JADX INFO: renamed from: b.f.m.b */
/* JADX INFO: compiled from: ApplicationSoSource.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2049b extends AbstractC2059l {

    /* JADX INFO: renamed from: a */
    public Context f4316a;

    /* JADX INFO: renamed from: b */
    public int f4317b;

    /* JADX INFO: renamed from: c */
    public C2050c f4318c;

    public C2049b(Context context, int i) {
        Context applicationContext = context.getApplicationContext();
        this.f4316a = applicationContext;
        if (applicationContext == null) {
            Log.w("SoLoader", "context.getApplicationContext returned null, holding reference to original context.");
            this.f4316a = context;
        }
        this.f4317b = i;
        this.f4318c = new C2050c(new File(this.f4316a.getApplicationInfo().nativeLibraryDir), i);
    }

    /* JADX INFO: renamed from: d */
    public static File m1567d(Context context) {
        return new File(context.getApplicationInfo().nativeLibraryDir);
    }

    @Override // p007b.p109f.p190m.AbstractC2059l
    /* JADX INFO: renamed from: a */
    public int mo1568a(String str, int i, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        return this.f4318c.mo1568a(str, i, threadPolicy);
    }

    @Override // p007b.p109f.p190m.AbstractC2059l
    /* JADX INFO: renamed from: b */
    public void mo1569b(int i) throws IOException {
        this.f4318c.mo1569b(i);
    }

    /* JADX INFO: renamed from: c */
    public boolean m1570c() throws IOException {
        File file = this.f4318c.f4319a;
        Context contextM1571e = m1571e();
        File fileM1567d = m1567d(contextM1571e);
        if (file.equals(fileM1567d)) {
            return false;
        }
        Log.d("SoLoader", "Native library directory updated from " + file + " to " + fileM1567d);
        int i = this.f4317b | 1;
        this.f4317b = i;
        this.f4318c = new C2050c(fileM1567d, i);
        this.f4316a = contextM1571e;
        return true;
    }

    /* JADX INFO: renamed from: e */
    public Context m1571e() {
        try {
            Context context = this.f4316a;
            return context.createPackageContext(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // p007b.p109f.p190m.AbstractC2059l
    public String toString() {
        return this.f4318c.toString();
    }
}
