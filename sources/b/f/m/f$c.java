package b.f.m;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: compiled from: ExtractFromZipSoSource.java */
/* JADX INFO: loaded from: classes3.dex */
public class f$c extends m$f {
    public f$b[] j;
    public final ZipFile k;
    public final m l;
    public final /* synthetic */ f m;

    public f$c(f fVar, m mVar) throws IOException {
        this.m = fVar;
        this.k = new ZipFile(fVar.f);
        this.l = mVar;
    }

    @Override // b.f.m.m$f
    public final m$c a() throws IOException {
        return new m$c(c());
    }

    @Override // b.f.m.m$f
    public final m$e b() throws IOException {
        return new f$c$a(this, null);
    }

    /* JADX WARN: Code duplicated, block: B:44:0x0120  */
    /* JADX WARN: Code duplicated, block: B:45:0x0123  */
    public final f$b[] c() {
        int i;
        String strY;
        boolean z2;
        if (this.j == null) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            HashMap map = new HashMap();
            Pattern patternCompile = Pattern.compile(this.m.g);
            String[] strArrC0 = b.c.a.a0.d.C0();
            Enumeration<? extends ZipEntry> enumerationEntries = this.k.entries();
            while (true) {
                i = 0;
                if (!enumerationEntries.hasMoreElements()) {
                    break;
                }
                ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                Matcher matcher = patternCompile.matcher(zipEntryNextElement.getName());
                if (matcher.matches()) {
                    String strGroup = matcher.group(1);
                    String strGroup2 = matcher.group(2);
                    while (true) {
                        if (i >= strArrC0.length) {
                            i = -1;
                            break;
                        }
                        if (strArrC0[i] != null && strGroup.equals(strArrC0[i])) {
                            break;
                        }
                        i++;
                    }
                    if (i >= 0) {
                        linkedHashSet.add(strGroup);
                        f$b f_b = (f$b) map.get(strGroup2);
                        if (f_b == null || i < f_b.m) {
                            map.put(strGroup2, new f$b(strGroup2, zipEntryNextElement, i));
                        }
                    }
                }
            }
            m mVar = this.l;
            Objects.requireNonNull(mVar);
            f$b[] f_bArr = (f$b[]) map.values().toArray(new f$b[map.size()]);
            Arrays.sort(f_bArr);
            int i2 = 0;
            for (int i3 = 0; i3 < f_bArr.length; i3++) {
                f$b f_b2 = f_bArr[i3];
                ZipEntry zipEntry = f_b2.l;
                String str = f_b2.j;
                a$a a_a = (a$a) this;
                String name = zipEntry.getName();
                if (str.equals(a_a.p.d)) {
                    a_a.p.d = null;
                    strY = String.format("allowing consideration of corrupted lib %s", str);
                } else if ((a_a.o & 1) == 0) {
                    strY = b.d.b.a.a.y("allowing consideration of ", name, ": self-extraction preferred");
                } else {
                    File file = new File(a_a.n, str);
                    if (file.isFile()) {
                        long length = file.length();
                        long size = zipEntry.getSize();
                        if (length != size) {
                            strY = String.format("allowing consideration of %s: sysdir file length is %s, but the file is %s bytes long in the APK", file, Long.valueOf(length), Long.valueOf(size));
                        } else {
                            strY = b.d.b.a.a.y("not allowing consideration of ", name, ": deferring to libdir");
                            z2 = false;
                        }
                        Log.d("ApkSoSource", strY);
                        if (z2) {
                            i2++;
                        } else {
                            f_bArr[i3] = null;
                        }
                    } else {
                        strY = String.format("allowing considering of %s: %s not in system lib dir", name, str);
                    }
                }
                z2 = true;
                Log.d("ApkSoSource", strY);
                if (z2) {
                    i2++;
                } else {
                    f_bArr[i3] = null;
                }
            }
            f$b[] f_bArr2 = new f$b[i2];
            int i4 = 0;
            while (i < f_bArr.length) {
                f$b f_b3 = f_bArr[i];
                if (f_b3 != null) {
                    f_bArr2[i4] = f_b3;
                    i4++;
                }
                i++;
            }
            this.j = f_bArr2;
        }
        return this.j;
    }

    @Override // b.f.m.m$f, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.k.close();
    }
}
