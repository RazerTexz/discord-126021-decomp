package p007b.p225i.p361c.p369m.p389e;

import androidx.annotation.NonNull;
import java.io.File;

/* JADX INFO: renamed from: b.i.c.m.e.f */
/* JADX INFO: compiled from: NdkCrashFilesManager.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4763f {

    /* JADX INFO: renamed from: a */
    public final File f12790a;

    public C4763f(File file) {
        this.f12790a = file;
    }

    /* JADX INFO: renamed from: b */
    public static void m6701b(@NonNull File file) {
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                m6701b(file2);
            }
        }
        file.delete();
    }

    /* JADX INFO: renamed from: a */
    public File m6702a(String str) {
        File file = new File(this.f12790a, str);
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        return null;
    }
}
