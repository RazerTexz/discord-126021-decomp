package p007b.p225i.p226a.p288f.p330i.p332b;

import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import p007b.p225i.p226a.p288f.p299e.p308o.C3405g;

/* JADX INFO: renamed from: b.i.a.f.i.b.t3 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC4190t3 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ int f11219j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ String f11220k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ Object f11221l;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ Object f11222m;

    /* JADX INFO: renamed from: n */
    public final /* synthetic */ Object f11223n;

    /* JADX INFO: renamed from: o */
    public final /* synthetic */ C4157q3 f11224o;

    public RunnableC4190t3(C4157q3 c4157q3, int i, String str, Object obj, Object obj2, Object obj3) {
        this.f11224o = c4157q3;
        this.f11219j = i;
        this.f11220k = str;
        this.f11221l = obj;
        this.f11222m = obj2;
        this.f11223n = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C4009d4 c4009d4M5946o = this.f11224o.f11202a.m5946o();
        if (!c4009d4M5946o.m5856n()) {
            this.f11224o.m5798v(6, "Persisted config not initialized. Not logging error/warn");
            return;
        }
        C4157q3 c4157q3 = this.f11224o;
        if (c4157q3.f11138c == 0) {
            C3992c c3992c = c4157q3.f11202a.f11260h;
            if (c3992c.f10581d == null) {
                synchronized (c3992c) {
                    if (c3992c.f10581d == null) {
                        ApplicationInfo applicationInfo = c3992c.f11202a.f11254b.getApplicationInfo();
                        String strM4370a = C3405g.m4370a();
                        if (applicationInfo != null) {
                            String str = applicationInfo.processName;
                            c3992c.f10581d = Boolean.valueOf(str != null && str.equals(strM4370a));
                        }
                        if (c3992c.f10581d == null) {
                            c3992c.f10581d = Boolean.TRUE;
                            c3992c.mo5726g().f11141f.m5860a("My process not in the list of running processes");
                        }
                    }
                }
            }
            if (c3992c.f10581d.booleanValue()) {
                this.f11224o.f11138c = 'C';
            } else {
                this.f11224o.f11138c = 'c';
            }
        }
        C4157q3 c4157q4 = this.f11224o;
        if (c4157q4.f11139d < 0) {
            c4157q4.f11139d = 33025L;
        }
        char cCharAt = "01VDIWEA?".charAt(this.f11219j);
        C4157q3 c4157q5 = this.f11224o;
        char c = c4157q5.f11138c;
        long j = c4157q5.f11139d;
        String strM5790u = C4157q3.m5790u(true, this.f11220k, this.f11221l, this.f11222m, this.f11223n);
        StringBuilder sb = new StringBuilder(String.valueOf(strM5790u).length() + 24);
        sb.append(ExifInterface.GPS_MEASUREMENT_2D);
        sb.append(cCharAt);
        sb.append(c);
        sb.append(j);
        sb.append(":");
        sb.append(strM5790u);
        String string = sb.toString();
        if (string.length() > 1024) {
            string = this.f11220k.substring(0, 1024);
        }
        C4092k4 c4092k4 = c4009d4M5946o.f10635e;
        c4092k4.f10875e.mo5848b();
        if (c4092k4.f10875e.m5579w().getLong(c4092k4.f10871a, 0L) == 0) {
            c4092k4.m5696a();
        }
        if (string == null) {
            string = "";
        }
        long j2 = c4092k4.f10875e.m5579w().getLong(c4092k4.f10872b, 0L);
        if (j2 <= 0) {
            SharedPreferences.Editor editorEdit = c4092k4.f10875e.m5579w().edit();
            editorEdit.putString(c4092k4.f10873c, string);
            editorEdit.putLong(c4092k4.f10872b, 1L);
            editorEdit.apply();
            return;
        }
        long j3 = j2 + 1;
        boolean z2 = (c4092k4.f10875e.m5866e().m5924v0().nextLong() & RecyclerView.FOREVER_NS) < RecyclerView.FOREVER_NS / j3;
        SharedPreferences.Editor editorEdit2 = c4092k4.f10875e.m5579w().edit();
        if (z2) {
            editorEdit2.putString(c4092k4.f10873c, string);
        }
        editorEdit2.putLong(c4092k4.f10872b, j3);
        editorEdit2.apply();
    }
}
