package p007b.p225i.p361c.p369m.p370d.p378o;

import android.content.Context;
import java.io.File;
import p007b.p225i.p361c.p369m.p370d.C4592b;

/* JADX INFO: renamed from: b.i.c.m.d.o.h */
/* JADX INFO: compiled from: FileStoreImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4715h {

    /* JADX INFO: renamed from: a */
    public final Context f12683a;

    public C4715h(Context context) {
        this.f12683a = context;
    }

    /* JADX INFO: renamed from: a */
    public File m6636a() {
        File file = new File(this.f12683a.getFilesDir(), ".com.google.firebase.crashlytics");
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        C4592b.f12227a.m6376g("Couldn't create file");
        return null;
    }
}
