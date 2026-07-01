package b.i.c.m.e;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.d.b.a.outline;
import b.i.c.m.d.Logger3;
import b.i.c.m.d.k.CommonUtils;
import b.i.c.m.e.SessionFiles;
import com.adjust.sdk.Constants;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

/* JADX INFO: renamed from: b.i.c.m.e.a, reason: use source file name */
/* JADX INFO: compiled from: BreakpadController.java */
/* JADX INFO: loaded from: classes3.dex */
public class BreakpadController implements NativeComponentController {
    public static final Charset a = Charset.forName(Constants.ENCODING);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f1755b;
    public final NativeApi c;
    public final NdkCrashFilesManager d;

    public BreakpadController(Context context, NativeApi nativeApi, NdkCrashFilesManager ndkCrashFilesManager) {
        this.f1755b = context;
        this.c = nativeApi;
        this.d = ndkCrashFilesManager;
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
    public SessionFiles a(String str) {
        File fileA = this.d.a(str);
        File file = new File(fileA, "pending");
        Logger3 logger3 = Logger3.a;
        StringBuilder sbU = outline.U("Minidump directory: ");
        sbU.append(file.getAbsolutePath());
        logger3.b(sbU.toString());
        File fileB = b(file, ".dmp");
        StringBuilder sbU2 = outline.U("Minidump ");
        sbU2.append((fileB == null || !fileB.exists()) ? "does not exist" : "exists");
        logger3.b(sbU2.toString());
        SessionFiles.b bVar = new SessionFiles.b();
        if (fileA != null && fileA.exists() && file.exists()) {
            bVar.a = b(file, ".dmp");
            bVar.f1757b = b(fileA, ".device_info");
            bVar.c = new File(fileA, "session.json");
            bVar.d = new File(fileA, "app.json");
            bVar.e = new File(fileA, "device.json");
            bVar.f = new File(fileA, "os.json");
        }
        return new SessionFiles(bVar, null);
    }

    public final void c(String str, String str2, String str3) throws Throwable {
        File file = new File(this.d.a(str), str3);
        BufferedWriter bufferedWriter = null;
        try {
            BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), a));
            try {
                bufferedWriter2.write(str2);
                CommonUtils.c(bufferedWriter2, "Failed to close " + file);
            } catch (IOException unused) {
                bufferedWriter = bufferedWriter2;
                CommonUtils.c(bufferedWriter, "Failed to close " + file);
            } catch (Throwable th) {
                th = th;
                bufferedWriter = bufferedWriter2;
                CommonUtils.c(bufferedWriter, "Failed to close " + file);
                throw th;
            }
        } catch (IOException unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
