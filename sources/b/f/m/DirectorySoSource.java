package b.f.m;

import android.os.StrictMode;
import android.os.Trace;
import android.util.Log;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import com.facebook.soloader.Api18TraceUtils;
import com.facebook.soloader.SoLoader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.ClosedByInterruptException;
import java.util.Arrays;

/* JADX INFO: renamed from: b.f.m.c, reason: use source file name */
/* JADX INFO: compiled from: DirectorySoSource.java */
/* JADX INFO: loaded from: classes3.dex */
public class DirectorySoSource extends SoSource {
    public final File a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f653b;

    public DirectorySoSource(File file, int i) {
        this.a = file;
        this.f653b = i;
    }

    @Override // b.f.m.SoSource
    public int a(String str, int i, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        return c(str, i, this.a, threadPolicy);
    }

    public int c(String str, int i, File file, StrictMode.ThreadPolicy threadPolicy) throws Throwable {
        File file2 = new File(file, str);
        if (!file2.exists()) {
            StringBuilder sbX = outline.X(str, " not found on ");
            sbX.append(file.getCanonicalPath());
            Log.d("SoLoader", sbX.toString());
            return 0;
        }
        StringBuilder sbX2 = outline.X(str, " found on ");
        sbX2.append(file.getCanonicalPath());
        Log.d("SoLoader", sbX2.toString());
        if ((i & 1) != 0 && (this.f653b & 2) != 0) {
            Log.d("SoLoader", str + " loaded implicitly");
            return 2;
        }
        if ((this.f653b & 1) != 0) {
            if (SoLoader.a) {
                Api18TraceUtils.a("SoLoader.getElfDependencies[", file2.getName(), "]");
            }
            int i2 = 0;
            while (true) {
                try {
                    FileInputStream fileInputStream = new FileInputStream(file2);
                    try {
                        try {
                            String[] strArrJ0 = AnimatableValueParser.j0(fileInputStream.getChannel());
                            fileInputStream.close();
                            if (SoLoader.a) {
                                Trace.endSection();
                            }
                            StringBuilder sbU = outline.U("Loading lib dependencies: ");
                            sbU.append(Arrays.toString(strArrJ0));
                            Log.d("SoLoader", sbU.toString());
                            for (String str2 : strArrJ0) {
                                if (!str2.startsWith(AutocompleteViewModel.COMMAND_DISCOVER_TOKEN)) {
                                    SoLoader.d(str2, null, null, i | 1, threadPolicy);
                                }
                            }
                        } catch (ClosedByInterruptException e) {
                            i2++;
                            if (i2 > 3) {
                                throw e;
                            }
                            Thread.interrupted();
                            Log.e("MinElf", "retrying extract_DT_NEEDED due to ClosedByInterruptException", e);
                            fileInputStream.close();
                        }
                    } catch (Throwable th) {
                        fileInputStream.close();
                        throw th;
                    }
                } catch (Throwable th2) {
                    if (SoLoader.a) {
                        Trace.endSection();
                    }
                    throw th2;
                }
            }
        } else {
            Log.d("SoLoader", "Not resolving dependencies for " + str);
        }
        try {
            ((SoLoader.a) SoLoader.f2906b).b(file2.getAbsolutePath(), i);
            return 1;
        } catch (UnsatisfiedLinkError e2) {
            if (!e2.getMessage().contains("bad ELF magic")) {
                throw e2;
            }
            Log.d("SoLoader", "Corrupted lib file detected");
            return 3;
        }
    }

    @Override // b.f.m.SoSource
    public String toString() {
        String name;
        try {
            name = String.valueOf(this.a.getCanonicalPath());
        } catch (IOException unused) {
            name = this.a.getName();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getName());
        sb.append("[root = ");
        sb.append(name);
        sb.append(" flags = ");
        return outline.A(sb, this.f653b, ']');
    }
}
