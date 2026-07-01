package b.i.c.m.d.o;

import android.content.Context;
import b.i.c.m.d.Logger3;
import java.io.File;

/* JADX INFO: renamed from: b.i.c.m.d.o.h, reason: use source file name */
/* JADX INFO: compiled from: FileStoreImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class FileStoreImpl {
    public final Context a;

    public FileStoreImpl(Context context) {
        this.a = context;
    }

    public File a() {
        File file = new File(this.a.getFilesDir(), ".com.google.firebase.crashlytics");
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        Logger3.a.g("Couldn't create file");
        return null;
    }
}
