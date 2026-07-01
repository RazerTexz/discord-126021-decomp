package b.i.c.m.d.o;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.i.c.m.d.m.x.CrashlyticsReportJsonTransform8;
import b.i.c.m.d.s.SettingsDataProvider;
import com.adjust.sdk.Constants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: renamed from: b.i.c.m.d.o.g, reason: use source file name */
/* JADX INFO: compiled from: CrashlyticsReportPersistence.java */
/* JADX INFO: loaded from: classes3.dex */
public class CrashlyticsReportPersistence7 {
    public static final Charset a = Charset.forName(Constants.ENCODING);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f1738b = 15;
    public static final CrashlyticsReportJsonTransform8 c = new CrashlyticsReportJsonTransform8();
    public static final Comparator<? super File> d = new Comparator() { // from class: b.i.c.m.d.o.e
        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            Charset charset = CrashlyticsReportPersistence7.a;
            return ((File) obj2).getName().compareTo(((File) obj).getName());
        }
    };
    public static final FilenameFilter e = new FilenameFilter() { // from class: b.i.c.m.d.o.f
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            Charset charset = CrashlyticsReportPersistence7.a;
            return str.startsWith("event");
        }
    };

    @NonNull
    public final AtomicInteger f = new AtomicInteger(0);

    @NonNull
    public final File g;

    @NonNull
    public final File h;

    @NonNull
    public final File i;

    @NonNull
    public final File j;

    @NonNull
    public final SettingsDataProvider k;

    public CrashlyticsReportPersistence7(@NonNull File file, @NonNull SettingsDataProvider settingsDataProvider) {
        File file2 = new File(file, "report-persistence");
        this.g = new File(file2, "sessions");
        this.h = new File(file2, "priority-reports");
        this.i = new File(file2, "reports");
        this.j = new File(file2, "native-reports");
        this.k = settingsDataProvider;
    }

    @NonNull
    public static List<File> a(@NonNull List<File>... listArr) {
        ArrayList arrayList = new ArrayList();
        int size = 0;
        for (List<File> list : listArr) {
            size += list.size();
        }
        arrayList.ensureCapacity(size);
        for (List<File> list2 : listArr) {
            arrayList.addAll(list2);
        }
        return arrayList;
    }

    @NonNull
    public static List<File> d(@NonNull File file) {
        return f(file, null);
    }

    @NonNull
    public static List<File> f(@NonNull File file, @Nullable FileFilter fileFilter) {
        if (!file.isDirectory()) {
            return Collections.emptyList();
        }
        File[] fileArrListFiles = fileFilter == null ? file.listFiles() : file.listFiles(fileFilter);
        return fileArrListFiles != null ? Arrays.asList(fileArrListFiles) : Collections.emptyList();
    }

    @NonNull
    public static List<File> g(@NonNull File file, @Nullable FilenameFilter filenameFilter) {
        if (!file.isDirectory()) {
            return Collections.emptyList();
        }
        File[] fileArrListFiles = filenameFilter == null ? file.listFiles() : file.listFiles(filenameFilter);
        return fileArrListFiles != null ? Arrays.asList(fileArrListFiles) : Collections.emptyList();
    }

    @NonNull
    public static File i(@NonNull File file) throws IOException {
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        throw new IOException("Could not create directory " + file);
    }

    @NonNull
    public static String j(@NonNull File file) throws IOException {
        byte[] bArr = new byte[8192];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        FileInputStream fileInputStream = new FileInputStream(file);
        while (true) {
            try {
                int i = fileInputStream.read(bArr);
                if (i <= 0) {
                    String str = new String(byteArrayOutputStream.toByteArray(), a);
                    fileInputStream.close();
                    return str;
                }
                byteArrayOutputStream.write(bArr, 0, i);
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (Throwable unused) {
                }
                throw th;
            }
        }
    }

    public static void k(@Nullable File file) {
        if (file == null) {
            return;
        }
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                k(file2);
            }
        }
        file.delete();
    }

    public static void l(File file, String str) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), a);
        try {
            outputStreamWriter.write(str);
            outputStreamWriter.close();
        } catch (Throwable th) {
            try {
                outputStreamWriter.close();
            } catch (Throwable unused) {
            }
            throw th;
        }
    }

    public void b() {
        Iterator it = ((ArrayList) e()).iterator();
        while (it.hasNext()) {
            ((File) it.next()).delete();
        }
    }

    public void c(final String str) {
        FilenameFilter filenameFilter = new FilenameFilter(str) { // from class: b.i.c.m.d.o.a
            public final String a;

            {
                this.a = str;
            }

            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str2) {
                String str3 = this.a;
                Charset charset = CrashlyticsReportPersistence7.a;
                return str2.startsWith(str3);
            }
        };
        Iterator it = ((ArrayList) a(g(this.h, filenameFilter), g(this.j, filenameFilter), g(this.i, filenameFilter))).iterator();
        while (it.hasNext()) {
            ((File) it.next()).delete();
        }
    }

    @NonNull
    public final List<File> e() {
        List[] listArr = {a(d(this.h), d(this.j)), d(this.i)};
        for (int i = 0; i < 2; i++) {
            Collections.sort(listArr[i], d);
        }
        return a(listArr);
    }

    @NonNull
    public final File h(@NonNull String str) {
        return new File(this.g, str);
    }
}
