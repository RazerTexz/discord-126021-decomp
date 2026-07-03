package p007b.p085c.p086a.p099z;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.c.a.z.b */
/* JADX INFO: compiled from: NetworkCache.java */
/* JADX INFO: loaded from: classes.dex */
public class C1612b {

    /* JADX INFO: renamed from: a */
    public final Context f2927a;

    public C1612b(Context context) {
        this.f2927a = context.getApplicationContext();
    }

    /* JADX INFO: renamed from: a */
    public static String m793a(String str, EnumC1611a enumC1611a, boolean z2) {
        String str2;
        StringBuilder sbM833U = C1643a.m833U("lottie_cache_");
        sbM833U.append(str.replaceAll("\\W+", ""));
        if (z2) {
            Objects.requireNonNull(enumC1611a);
            str2 = ".temp" + enumC1611a.extension;
        } else {
            str2 = enumC1611a.extension;
        }
        sbM833U.append(str2);
        return sbM833U.toString();
    }

    /* JADX INFO: renamed from: b */
    public final File m794b() {
        File file = new File(this.f2927a.getCacheDir(), "lottie_network_cache");
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    /* JADX INFO: renamed from: c */
    public File m795c(String str, InputStream inputStream, EnumC1611a enumC1611a) throws IOException {
        File file = new File(m794b(), m793a(str, enumC1611a, true));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i == -1) {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        inputStream.close();
                        return file;
                    }
                    fileOutputStream.write(bArr, 0, i);
                }
            } catch (Throwable th) {
                fileOutputStream.close();
                throw th;
            }
        } catch (Throwable th2) {
            inputStream.close();
            throw th2;
        }
    }
}
