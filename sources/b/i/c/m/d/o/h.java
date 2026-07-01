package b.i.c.m.d.o;

import android.content.Context;
import java.io.File;

/* JADX INFO: compiled from: FileStoreImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class h {
    public final Context a;

    public h(Context context) {
        this.a = context;
    }

    public File a() {
        File file = new File(this.a.getFilesDir(), ".com.google.firebase.crashlytics");
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        b.i.c.m.d.b.a.g("Couldn't create file");
        return null;
    }
}
