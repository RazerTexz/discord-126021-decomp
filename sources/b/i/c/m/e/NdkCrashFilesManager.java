package b.i.c.m.e;

import androidx.annotation.NonNull;
import java.io.File;

/* JADX INFO: renamed from: b.i.c.m.e.f, reason: use source file name */
/* JADX INFO: compiled from: NdkCrashFilesManager.java */
/* JADX INFO: loaded from: classes3.dex */
public class NdkCrashFilesManager {
    public final File a;

    public NdkCrashFilesManager(File file) {
        this.a = file;
    }

    public static void b(@NonNull File file) {
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                b(file2);
            }
        }
        file.delete();
    }

    public File a(String str) {
        File file = new File(this.a, str);
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        return null;
    }
}
