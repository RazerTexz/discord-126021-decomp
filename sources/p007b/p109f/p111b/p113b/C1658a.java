package p007b.p109f.p111b.p113b;

import android.os.Environment;
import androidx.annotation.VisibleForTesting;
import com.facebook.common.file.FileUtils$CreateDirectoryException;
import com.facebook.common.file.FileUtils$ParentDirNotFoundException;
import com.facebook.common.file.FileUtils$RenameException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p109f.p110a.C1650a;
import p007b.p109f.p111b.p112a.C1654d;
import p007b.p109f.p111b.p112a.InterfaceC1651a;
import p007b.p109f.p111b.p112a.InterfaceC1657g;
import p007b.p109f.p111b.p113b.InterfaceC1660c;
import p007b.p109f.p115d.p118c.InterfaceC1677a;
import p007b.p109f.p115d.p119d.C1679b;
import p007b.p109f.p115d.p126k.C1715c;
import p007b.p109f.p115d.p126k.InterfaceC1713a;
import p007b.p109f.p161j.p168c.C1861h;

/* JADX INFO: renamed from: b.f.b.b.a */
/* JADX INFO: compiled from: DefaultDiskStorage.java */
/* JADX INFO: loaded from: classes.dex */
public class C1658a implements InterfaceC1660c {

    /* JADX INFO: renamed from: a */
    public static final long f3021a = TimeUnit.MINUTES.toMillis(30);

    /* JADX INFO: renamed from: b */
    public static final /* synthetic */ int f3022b = 0;

    /* JADX INFO: renamed from: c */
    public final File f3023c;

    /* JADX INFO: renamed from: d */
    public final boolean f3024d;

    /* JADX INFO: renamed from: e */
    public final File f3025e;

    /* JADX INFO: renamed from: f */
    public final InterfaceC1651a f3026f;

    /* JADX INFO: renamed from: g */
    public final InterfaceC1713a f3027g;

    /* JADX INFO: renamed from: b.f.b.b.a$b */
    /* JADX INFO: compiled from: DefaultDiskStorage.java */
    public class b implements InterfaceC1677a {

        /* JADX INFO: renamed from: a */
        public final List<InterfaceC1660c.a> f3028a = new ArrayList();

        public b(a aVar) {
        }

        @Override // p007b.p109f.p115d.p118c.InterfaceC1677a
        /* JADX INFO: renamed from: a */
        public void mo942a(File file) {
            d dVarM931h = C1658a.m931h(C1658a.this, file);
            if (dVarM931h == null || dVarM931h.f3034a != ".cnt") {
                return;
            }
            this.f3028a.add(new c(dVarM931h.f3035b, file, null));
        }

        @Override // p007b.p109f.p115d.p118c.InterfaceC1677a
        /* JADX INFO: renamed from: b */
        public void mo943b(File file) {
        }

        @Override // p007b.p109f.p115d.p118c.InterfaceC1677a
        /* JADX INFO: renamed from: c */
        public void mo944c(File file) {
        }
    }

    /* JADX INFO: renamed from: b.f.b.b.a$c */
    /* JADX INFO: compiled from: DefaultDiskStorage.java */
    @VisibleForTesting
    public static class c implements InterfaceC1660c.a {

        /* JADX INFO: renamed from: a */
        public final String f3030a;

        /* JADX INFO: renamed from: b */
        public final C1650a f3031b;

        /* JADX INFO: renamed from: c */
        public long f3032c;

        /* JADX INFO: renamed from: d */
        public long f3033d;

        public c(String str, File file, a aVar) {
            Objects.requireNonNull(str);
            this.f3030a = str;
            this.f3031b = new C1650a(file);
            this.f3032c = -1L;
            this.f3033d = -1L;
        }

        @Override // p007b.p109f.p111b.p113b.InterfaceC1660c.a
        /* JADX INFO: renamed from: a */
        public long mo945a() {
            if (this.f3033d < 0) {
                this.f3033d = this.f3031b.f3016a.lastModified();
            }
            return this.f3033d;
        }

        @Override // p007b.p109f.p111b.p113b.InterfaceC1660c.a
        public String getId() {
            return this.f3030a;
        }

        @Override // p007b.p109f.p111b.p113b.InterfaceC1660c.a
        public long getSize() {
            if (this.f3032c < 0) {
                this.f3032c = this.f3031b.m928a();
            }
            return this.f3032c;
        }
    }

    /* JADX INFO: renamed from: b.f.b.b.a$d */
    /* JADX INFO: compiled from: DefaultDiskStorage.java */
    public static class d {

        /* JADX INFO: renamed from: a */
        public final String f3034a;

        /* JADX INFO: renamed from: b */
        public final String f3035b;

        public d(String str, String str2) {
            this.f3034a = str;
            this.f3035b = str2;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f3034a);
            sb.append("(");
            return C1643a.m822J(sb, this.f3035b, ")");
        }
    }

    /* JADX INFO: renamed from: b.f.b.b.a$e */
    /* JADX INFO: compiled from: DefaultDiskStorage.java */
    public static class e extends IOException {
        public e(long j, long j2) {
            super("File was not written completely. Expected: " + j + ", found: " + j2);
        }
    }

    /* JADX INFO: renamed from: b.f.b.b.a$f */
    /* JADX INFO: compiled from: DefaultDiskStorage.java */
    @VisibleForTesting
    public class f implements InterfaceC1660c.b {

        /* JADX INFO: renamed from: a */
        public final String f3036a;

        /* JADX INFO: renamed from: b */
        @VisibleForTesting
        public final File f3037b;

        public f(String str, File file) {
            this.f3036a = str;
            this.f3037b = file;
        }

        /* JADX INFO: renamed from: a */
        public boolean m946a() {
            return !this.f3037b.exists() || this.f3037b.delete();
        }

        /* JADX INFO: renamed from: b */
        public C1650a m947b(Object obj) throws IOException {
            Objects.requireNonNull((C1715c) C1658a.this.f3027g);
            long jCurrentTimeMillis = System.currentTimeMillis();
            File fileM940j = C1658a.this.m940j(this.f3036a);
            try {
                C1460d.m467Q1(this.f3037b, fileM940j);
                if (fileM940j.exists()) {
                    fileM940j.setLastModified(jCurrentTimeMillis);
                }
                return new C1650a(fileM940j);
            } catch (FileUtils$RenameException e) {
                Throwable cause = e.getCause();
                if (cause != null && !(cause instanceof FileUtils$ParentDirNotFoundException)) {
                    boolean z2 = cause instanceof FileNotFoundException;
                }
                InterfaceC1651a interfaceC1651a = C1658a.this.f3026f;
                int i = C1658a.f3022b;
                Objects.requireNonNull((C1654d) interfaceC1651a);
                throw e;
            }
        }

        /* JADX INFO: renamed from: c */
        public void m948c(InterfaceC1657g interfaceC1657g, Object obj) throws IOException {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.f3037b);
                try {
                    C1679b c1679b = new C1679b(fileOutputStream);
                    C1861h c1861h = (C1861h) interfaceC1657g;
                    InputStream inputStreamM1342e = c1861h.f3673a.m1342e();
                    Objects.requireNonNull(inputStreamM1342e);
                    c1861h.f3674b.f3663c.m998a(inputStreamM1342e, c1679b);
                    c1679b.flush();
                    long j = c1679b.f3092j;
                    fileOutputStream.close();
                    if (this.f3037b.length() != j) {
                        throw new e(j, this.f3037b.length());
                    }
                } catch (Throwable th) {
                    fileOutputStream.close();
                    throw th;
                }
            } catch (FileNotFoundException e) {
                InterfaceC1651a interfaceC1651a = C1658a.this.f3026f;
                int i = C1658a.f3022b;
                Objects.requireNonNull((C1654d) interfaceC1651a);
                throw e;
            }
        }
    }

    /* JADX INFO: renamed from: b.f.b.b.a$g */
    /* JADX INFO: compiled from: DefaultDiskStorage.java */
    public class g implements InterfaceC1677a {

        /* JADX INFO: renamed from: a */
        public boolean f3039a;

        public g(a aVar) {
        }

        @Override // p007b.p109f.p115d.p118c.InterfaceC1677a
        /* JADX INFO: renamed from: a */
        public void mo942a(File file) {
            if (this.f3039a) {
                d dVarM931h = C1658a.m931h(C1658a.this, file);
                boolean z2 = false;
                if (dVarM931h != null) {
                    String str = dVarM931h.f3034a;
                    if (str == ".tmp") {
                        long jLastModified = file.lastModified();
                        Objects.requireNonNull((C1715c) C1658a.this.f3027g);
                        if (jLastModified > System.currentTimeMillis() - C1658a.f3021a) {
                        }
                    } else {
                        C1460d.m419B(str == ".cnt");
                    }
                    z2 = true;
                }
                if (z2) {
                    return;
                }
            }
            file.delete();
        }

        @Override // p007b.p109f.p115d.p118c.InterfaceC1677a
        /* JADX INFO: renamed from: b */
        public void mo943b(File file) {
            if (this.f3039a || !file.equals(C1658a.this.f3025e)) {
                return;
            }
            this.f3039a = true;
        }

        @Override // p007b.p109f.p115d.p118c.InterfaceC1677a
        /* JADX INFO: renamed from: c */
        public void mo944c(File file) {
            if (!C1658a.this.f3023c.equals(file) && !this.f3039a) {
                file.delete();
            }
            if (this.f3039a && file.equals(C1658a.this.f3025e)) {
                this.f3039a = false;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x005c  */
    /* JADX WARN: Code duplicated, block: B:17:0x0062  */
    /* JADX WARN: Code duplicated, block: B:18:0x0067  */
    /* JADX WARN: Code duplicated, block: B:29:0x006a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public C1658a(File file, int i, InterfaceC1651a interfaceC1651a) {
        boolean zContains;
        File file2;
        this.f3023c = file;
        boolean z2 = false;
        try {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            if (externalStorageDirectory != null) {
                try {
                    zContains = file.getCanonicalPath().contains(externalStorageDirectory.toString());
                } catch (IOException unused) {
                    Objects.requireNonNull((C1654d) interfaceC1651a);
                    zContains = false;
                    this.f3024d = zContains;
                    file2 = new File(this.f3023c, String.format(null, "%s.ols%d.%d", "v2", 100, Integer.valueOf(i)));
                    this.f3025e = file2;
                    this.f3026f = interfaceC1651a;
                    if (this.f3023c.exists()) {
                        z2 = true;
                    } else if (!file2.exists()) {
                        C1460d.m492Z(this.f3023c);
                        z2 = true;
                    }
                    if (z2) {
                        try {
                            C1460d.m541l1(file2);
                        } catch (FileUtils$CreateDirectoryException unused2) {
                            InterfaceC1651a interfaceC1651a2 = this.f3026f;
                            StringBuilder sbM833U = C1643a.m833U("version directory could not be created: ");
                            sbM833U.append(this.f3025e);
                            sbM833U.toString();
                            Objects.requireNonNull((C1654d) interfaceC1651a2);
                        }
                    }
                    this.f3027g = C1715c.f3133a;
                }
            } else {
                zContains = false;
            }
        } catch (Exception unused3) {
            Objects.requireNonNull((C1654d) interfaceC1651a);
            zContains = false;
        }
        this.f3024d = zContains;
        file2 = new File(this.f3023c, String.format(null, "%s.ols%d.%d", "v2", 100, Integer.valueOf(i)));
        this.f3025e = file2;
        this.f3026f = interfaceC1651a;
        if (this.f3023c.exists()) {
            z2 = true;
        } else if (!file2.exists()) {
            C1460d.m492Z(this.f3023c);
            z2 = true;
        }
        if (z2) {
            C1460d.m541l1(file2);
        }
        this.f3027g = C1715c.f3133a;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x003d  */
    /* JADX INFO: renamed from: h */
    public static d m931h(C1658a c1658a, File file) {
        d dVar;
        Objects.requireNonNull(c1658a);
        String name = file.getName();
        int iLastIndexOf = name.lastIndexOf(46);
        if (iLastIndexOf <= 0) {
            dVar = null;
        } else {
            String strSubstring = name.substring(iLastIndexOf);
            String str = ".cnt";
            if (!".cnt".equals(strSubstring)) {
                str = ".tmp".equals(strSubstring) ? ".tmp" : null;
            }
            if (str == null) {
                dVar = null;
            } else {
                String strSubstring2 = name.substring(0, iLastIndexOf);
                if (str.equals(".tmp")) {
                    int iLastIndexOf2 = strSubstring2.lastIndexOf(46);
                    if (iLastIndexOf2 <= 0) {
                        dVar = null;
                    } else {
                        strSubstring2 = strSubstring2.substring(0, iLastIndexOf2);
                    }
                }
                dVar = new d(str, strSubstring2);
            }
        }
        if (dVar != null && new File(c1658a.m941k(dVar.f3035b)).equals(file.getParentFile())) {
            return dVar;
        }
        return null;
    }

    @Override // p007b.p109f.p111b.p113b.InterfaceC1660c
    /* JADX INFO: renamed from: a */
    public void mo932a() {
        C1460d.m554o2(this.f3023c, new g(null));
    }

    @Override // p007b.p109f.p111b.p113b.InterfaceC1660c
    /* JADX INFO: renamed from: b */
    public InterfaceC1660c.b mo933b(String str, Object obj) throws IOException {
        File file = new File(m941k(str));
        if (!file.exists()) {
            try {
                C1460d.m541l1(file);
            } catch (FileUtils$CreateDirectoryException e2) {
                Objects.requireNonNull((C1654d) this.f3026f);
                throw e2;
            }
        }
        try {
            return new f(str, File.createTempFile(str + ".", ".tmp", file));
        } catch (IOException e3) {
            Objects.requireNonNull((C1654d) this.f3026f);
            throw e3;
        }
    }

    @Override // p007b.p109f.p111b.p113b.InterfaceC1660c
    /* JADX INFO: renamed from: c */
    public boolean mo934c(String str, Object obj) {
        File fileM940j = m940j(str);
        boolean zExists = fileM940j.exists();
        if (zExists) {
            Objects.requireNonNull((C1715c) this.f3027g);
            fileM940j.setLastModified(System.currentTimeMillis());
        }
        return zExists;
    }

    @Override // p007b.p109f.p111b.p113b.InterfaceC1660c
    /* JADX INFO: renamed from: d */
    public C1650a mo935d(String str, Object obj) {
        File fileM940j = m940j(str);
        if (!fileM940j.exists()) {
            return null;
        }
        Objects.requireNonNull((C1715c) this.f3027g);
        fileM940j.setLastModified(System.currentTimeMillis());
        return new C1650a(fileM940j);
    }

    @Override // p007b.p109f.p111b.p113b.InterfaceC1660c
    /* JADX INFO: renamed from: e */
    public Collection mo936e() throws IOException {
        b bVar = new b(null);
        C1460d.m554o2(this.f3025e, bVar);
        return Collections.unmodifiableList(bVar.f3028a);
    }

    @Override // p007b.p109f.p111b.p113b.InterfaceC1660c
    /* JADX INFO: renamed from: f */
    public long mo937f(String str) {
        return m939i(m940j(str));
    }

    @Override // p007b.p109f.p111b.p113b.InterfaceC1660c
    /* JADX INFO: renamed from: g */
    public long mo938g(InterfaceC1660c.a aVar) {
        return m939i(((c) aVar).f3031b.f3016a);
    }

    /* JADX INFO: renamed from: i */
    public final long m939i(File file) {
        if (!file.exists()) {
            return 0L;
        }
        long length = file.length();
        if (file.delete()) {
            return length;
        }
        return -1L;
    }

    @Override // p007b.p109f.p111b.p113b.InterfaceC1660c
    public boolean isExternal() {
        return this.f3024d;
    }

    @VisibleForTesting
    /* JADX INFO: renamed from: j */
    public File m940j(String str) {
        return new File(C1643a.m823K(C1643a.m833U(m941k(str)), File.separator, str, ".cnt"));
    }

    /* JADX INFO: renamed from: k */
    public final String m941k(String str) {
        String strValueOf = String.valueOf(Math.abs(str.hashCode() % 100));
        StringBuilder sb = new StringBuilder();
        sb.append(this.f3025e);
        return C1643a.m822J(sb, File.separator, strValueOf);
    }
}
