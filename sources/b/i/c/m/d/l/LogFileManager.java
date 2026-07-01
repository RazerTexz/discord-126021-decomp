package b.i.c.m.d.l;

import android.content.Context;
import b.d.b.a.outline;
import b.i.c.m.d.Logger3;
import b.i.c.m.d.k.CommonUtils;
import b.i.c.m.d.k.x;
import java.io.File;

/* JADX INFO: renamed from: b.i.c.m.d.l.b, reason: use source file name */
/* JADX INFO: compiled from: LogFileManager.java */
/* JADX INFO: loaded from: classes3.dex */
public class LogFileManager {
    public static final c a = new c(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f1707b;
    public final b c;
    public FileLogStore d = a;

    /* JADX INFO: renamed from: b.i.c.m.d.l.b$b */
    /* JADX INFO: compiled from: LogFileManager.java */
    public interface b {
    }

    /* JADX INFO: renamed from: b.i.c.m.d.l.b$c */
    /* JADX INFO: compiled from: LogFileManager.java */
    public static final class c implements FileLogStore {
        public c(a aVar) {
        }

        @Override // b.i.c.m.d.l.FileLogStore
        public void a() {
        }

        @Override // b.i.c.m.d.l.FileLogStore
        public String b() {
            return null;
        }

        @Override // b.i.c.m.d.l.FileLogStore
        public byte[] c() {
            return null;
        }

        @Override // b.i.c.m.d.l.FileLogStore
        public void d() {
        }

        @Override // b.i.c.m.d.l.FileLogStore
        public void e(long j, String str) {
        }
    }

    public LogFileManager(Context context, b bVar) {
        this.f1707b = context;
        this.c = bVar;
        a(null);
    }

    public final void a(String str) {
        this.d.a();
        this.d = a;
        if (str == null) {
            return;
        }
        if (!CommonUtils.j(this.f1707b, "com.crashlytics.CollectCustomLogs", true)) {
            Logger3.a.b("Preferences requested no custom logs. Aborting log file creation.");
        } else {
            this.d = new QueueFileLogStore2(new File(((x.j) this.c).a(), outline.y("crashlytics-userlog-", str, ".temp")), 65536);
        }
    }

    public LogFileManager(Context context, b bVar, String str) {
        this.f1707b = context;
        this.c = bVar;
        a(str);
    }
}
