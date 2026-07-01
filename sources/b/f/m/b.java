package b.f.m;

import android.content.Context;
import android.content.pm.PackageManager$NameNotFoundException;
import android.os.StrictMode$ThreadPolicy;
import android.util.Log;
import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: ApplicationSoSource.java */
/* JADX INFO: loaded from: classes3.dex */
public class b extends l {
    public Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f652b;
    public c c;

    public b(Context context, int i) {
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        if (applicationContext == null) {
            Log.w("SoLoader", "context.getApplicationContext returned null, holding reference to original context.");
            this.a = context;
        }
        this.f652b = i;
        this.c = new c(new File(this.a.getApplicationInfo().nativeLibraryDir), i);
    }

    public static File d(Context context) {
        return new File(context.getApplicationInfo().nativeLibraryDir);
    }

    @Override // b.f.m.l
    public int a(String str, int i, StrictMode$ThreadPolicy strictMode$ThreadPolicy) throws IOException {
        return this.c.a(str, i, strictMode$ThreadPolicy);
    }

    @Override // b.f.m.l
    public void b(int i) throws IOException {
        this.c.b(i);
    }

    public boolean c() throws IOException {
        File file = this.c.a;
        Context contextE = e();
        File fileD = d(contextE);
        if (file.equals(fileD)) {
            return false;
        }
        Log.d("SoLoader", "Native library directory updated from " + file + " to " + fileD);
        int i = this.f652b | 1;
        this.f652b = i;
        this.c = new c(fileD, i);
        this.a = contextE;
        return true;
    }

    public Context e() {
        try {
            Context context = this.a;
            return context.createPackageContext(context.getPackageName(), 0);
        } catch (PackageManager$NameNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // b.f.m.l
    public String toString() {
        return this.c.toString();
    }
}
