package b.i.c.m.d.l;

import android.content.Context;
import b.i.c.m.d.k.h;
import b.i.c.m.d.k.x$j;
import java.io.File;

/* JADX INFO: compiled from: LogFileManager.java */
/* JADX INFO: loaded from: classes3.dex */
public class b {
    public static final b$c a = new b$c(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f1707b;
    public final b$b c;
    public a d = a;

    public b(Context context, b$b b_b) {
        this.f1707b = context;
        this.c = b_b;
        a(null);
    }

    public final void a(String str) {
        this.d.a();
        this.d = a;
        if (str == null) {
            return;
        }
        if (!h.j(this.f1707b, "com.crashlytics.CollectCustomLogs", true)) {
            b.i.c.m.d.b.a.b("Preferences requested no custom logs. Aborting log file creation.");
        } else {
            this.d = new e(new File(((x$j) this.c).a(), b.d.b.a.a.y("crashlytics-userlog-", str, ".temp")), 65536);
        }
    }

    public b(Context context, b$b b_b, String str) {
        this.f1707b = context;
        this.c = b_b;
        a(str);
    }
}
