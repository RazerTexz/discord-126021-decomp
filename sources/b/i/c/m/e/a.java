package b.i.c.m.e;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adjust.sdk.Constants;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: BreakpadController.java */
/* JADX INFO: loaded from: classes3.dex */
public class a implements e {
    public static final Charset a = Charset.forName(Constants.ENCODING);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f1755b;
    public final d c;
    public final f d;

    public a(Context context, d dVar, f fVar) {
        this.f1755b = context;
        this.c = dVar;
        this.d = fVar;
    }

    @Nullable
    public static File b(File file, String str) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return null;
        }
        for (File file2 : fileArrListFiles) {
            if (file2.getName().endsWith(str)) {
                return file2;
            }
        }
        return null;
    }

    @NonNull
    public g a(String str) {
        File fileA = this.d.a(str);
        File file = new File(fileA, "pending");
        b.i.c.m.d.b bVar = b.i.c.m.d.b.a;
        StringBuilder sbU = b.d.b.a.a.U("Minidump directory: ");
        sbU.append(file.getAbsolutePath());
        bVar.b(sbU.toString());
        File fileB = b(file, ".dmp");
        StringBuilder sbU2 = b.d.b.a.a.U("Minidump ");
        sbU2.append((fileB == null || !fileB.exists()) ? "does not exist" : "exists");
        bVar.b(sbU2.toString());
        g$b g_b = new g$b();
        if (fileA != null && fileA.exists() && file.exists()) {
            g_b.a = b(file, ".dmp");
            g_b.f1757b = b(fileA, ".device_info");
            g_b.c = new File(fileA, "session.json");
            g_b.d = new File(fileA, "app.json");
            g_b.e = new File(fileA, "device.json");
            g_b.f = new File(fileA, "os.json");
        }
        return new g(g_b, null);
    }

    public final void c(String str, String str2, String str3) throws Throwable {
        File file = new File(this.d.a(str), str3);
        BufferedWriter bufferedWriter = null;
        try {
            BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), a));
            try {
                bufferedWriter2.write(str2);
                b.i.c.m.d.k.h.c(bufferedWriter2, "Failed to close " + file);
            } catch (IOException unused) {
                bufferedWriter = bufferedWriter2;
                b.i.c.m.d.k.h.c(bufferedWriter, "Failed to close " + file);
            } catch (Throwable th) {
                th = th;
                bufferedWriter = bufferedWriter2;
                b.i.c.m.d.k.h.c(bufferedWriter, "Failed to close " + file);
                throw th;
            }
        } catch (IOException unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
