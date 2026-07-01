package b.i.a.f.i.b;

import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class t3 implements Runnable {
    public final /* synthetic */ int j;
    public final /* synthetic */ String k;
    public final /* synthetic */ Object l;
    public final /* synthetic */ Object m;
    public final /* synthetic */ Object n;
    public final /* synthetic */ q3 o;

    public t3(q3 q3Var, int i, String str, Object obj, Object obj2, Object obj3) {
        this.o = q3Var;
        this.j = i;
        this.k = str;
        this.l = obj;
        this.m = obj2;
        this.n = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d4 d4VarO = this.o.a.o();
        if (!d4VarO.n()) {
            this.o.v(6, "Persisted config not initialized. Not logging error/warn");
            return;
        }
        q3 q3Var = this.o;
        if (q3Var.c == 0) {
            c cVar = q3Var.a.h;
            if (cVar.d == null) {
                synchronized (cVar) {
                    if (cVar.d == null) {
                        ApplicationInfo applicationInfo = cVar.a.f1570b.getApplicationInfo();
                        String strA = b.i.a.f.e.o.g.a();
                        if (applicationInfo != null) {
                            String str = applicationInfo.processName;
                            cVar.d = Boolean.valueOf(str != null && str.equals(strA));
                        }
                        if (cVar.d == null) {
                            cVar.d = Boolean.TRUE;
                            cVar.g().f.a("My process not in the list of running processes");
                        }
                    }
                }
            }
            if (cVar.d.booleanValue()) {
                this.o.c = 'C';
            } else {
                this.o.c = 'c';
            }
        }
        q3 q3Var2 = this.o;
        if (q3Var2.d < 0) {
            q3Var2.d = 33025L;
        }
        char cCharAt = "01VDIWEA?".charAt(this.j);
        q3 q3Var3 = this.o;
        char c = q3Var3.c;
        long j = q3Var3.d;
        String strU = q3.u(true, this.k, this.l, this.m, this.n);
        StringBuilder sb = new StringBuilder(String.valueOf(strU).length() + 24);
        sb.append(ExifInterface.GPS_MEASUREMENT_2D);
        sb.append(cCharAt);
        sb.append(c);
        sb.append(j);
        sb.append(":");
        sb.append(strU);
        String string = sb.toString();
        if (string.length() > 1024) {
            string = this.k.substring(0, 1024);
        }
        k4 k4Var = d4VarO.e;
        k4Var.e.b();
        if (k4Var.e.w().getLong(k4Var.a, 0L) == 0) {
            k4Var.a();
        }
        if (string == null) {
            string = "";
        }
        long j2 = k4Var.e.w().getLong(k4Var.f1541b, 0L);
        if (j2 <= 0) {
            SharedPreferences.Editor editorEdit = k4Var.e.w().edit();
            editorEdit.putString(k4Var.c, string);
            editorEdit.putLong(k4Var.f1541b, 1L);
            editorEdit.apply();
            return;
        }
        long j3 = j2 + 1;
        boolean z2 = (k4Var.e.e().v0().nextLong() & RecyclerView.FOREVER_NS) < RecyclerView.FOREVER_NS / j3;
        SharedPreferences.Editor editorEdit2 = k4Var.e.w().edit();
        if (z2) {
            editorEdit2.putString(k4Var.c, string);
        }
        editorEdit2.putLong(k4Var.f1541b, j3);
        editorEdit2.apply();
    }
}
