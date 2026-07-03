package p007b.p109f.p190m;

import android.os.StrictMode;
import android.os.Trace;
import android.util.Log;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import com.facebook.soloader.Api18TraceUtils;
import com.facebook.soloader.SoLoader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.ClosedByInterruptException;
import java.util.Arrays;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.f.m.c */
/* JADX INFO: compiled from: DirectorySoSource.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2050c extends AbstractC2059l {

    /* JADX INFO: renamed from: a */
    public final File f4319a;

    /* JADX INFO: renamed from: b */
    public final int f4320b;

    public C2050c(File file, int i) {
        this.f4319a = file;
        this.f4320b = i;
    }

    @Override // p007b.p109f.p190m.AbstractC2059l
    /* JADX INFO: renamed from: a */
    public int mo1568a(String str, int i, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        return m1572c(str, i, this.f4319a, threadPolicy);
    }

    /* JADX INFO: renamed from: c */
    public int m1572c(String str, int i, File file, StrictMode.ThreadPolicy threadPolicy) throws Throwable {
        File file2 = new File(file, str);
        if (!file2.exists()) {
            StringBuilder sbM836X = C1643a.m836X(str, " not found on ");
            sbM836X.append(file.getCanonicalPath());
            Log.d("SoLoader", sbM836X.toString());
            return 0;
        }
        StringBuilder sbM836X2 = C1643a.m836X(str, " found on ");
        sbM836X2.append(file.getCanonicalPath());
        Log.d("SoLoader", sbM836X2.toString());
        if ((i & 1) != 0 && (this.f4320b & 2) != 0) {
            Log.d("SoLoader", str + " loaded implicitly");
            return 2;
        }
        if ((this.f4320b & 1) != 0) {
            if (SoLoader.f19641a) {
                Api18TraceUtils.m8727a("SoLoader.getElfDependencies[", file2.getName(), "]");
            }
            int i2 = 0;
            while (true) {
                try {
                    FileInputStream fileInputStream = new FileInputStream(file2);
                    try {
                        try {
                            String[] strArrM532j0 = C1460d.m532j0(fileInputStream.getChannel());
                            fileInputStream.close();
                            if (SoLoader.f19641a) {
                                Trace.endSection();
                            }
                            StringBuilder sbM833U = C1643a.m833U("Loading lib dependencies: ");
                            sbM833U.append(Arrays.toString(strArrM532j0));
                            Log.d("SoLoader", sbM833U.toString());
                            for (String str2 : strArrM532j0) {
                                if (!str2.startsWith(AutocompleteViewModel.COMMAND_DISCOVER_TOKEN)) {
                                    SoLoader.m8731d(str2, null, null, i | 1, threadPolicy);
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
                    if (SoLoader.f19641a) {
                        Trace.endSection();
                    }
                    throw th2;
                }
            }
        } else {
            Log.d("SoLoader", "Not resolving dependencies for " + str);
        }
        try {
            ((SoLoader.C10674a) SoLoader.f19642b).m8734b(file2.getAbsolutePath(), i);
            return 1;
        } catch (UnsatisfiedLinkError e2) {
            if (!e2.getMessage().contains("bad ELF magic")) {
                throw e2;
            }
            Log.d("SoLoader", "Corrupted lib file detected");
            return 3;
        }
    }

    @Override // p007b.p109f.p190m.AbstractC2059l
    public String toString() {
        String name;
        try {
            name = String.valueOf(this.f4319a.getCanonicalPath());
        } catch (IOException unused) {
            name = this.f4319a.getName();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getName());
        sb.append("[root = ");
        sb.append(name);
        sb.append(" flags = ");
        return C1643a.m813A(sb, this.f4320b, ']');
    }
}
