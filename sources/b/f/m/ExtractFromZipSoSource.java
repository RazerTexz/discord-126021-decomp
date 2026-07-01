package b.f.m;

import android.content.Context;
import android.util.Log;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.f.m.ApkSoSource;
import b.f.m.UnpackingSoSource;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: renamed from: b.f.m.f, reason: use source file name */
/* JADX INFO: compiled from: ExtractFromZipSoSource.java */
/* JADX INFO: loaded from: classes3.dex */
public class ExtractFromZipSoSource extends UnpackingSoSource {
    public final File f;
    public final String g;

    /* JADX INFO: renamed from: b.f.m.f$b */
    /* JADX INFO: compiled from: ExtractFromZipSoSource.java */
    public static final class b extends UnpackingSoSource.b implements Comparable {
        public final ZipEntry l;
        public final int m;

        public b(String str, ZipEntry zipEntry, int i) {
            super(str, String.format("pseudo-zip-hash-1-%s-%s-%s-%s", zipEntry.getName(), Long.valueOf(zipEntry.getSize()), Long.valueOf(zipEntry.getCompressedSize()), Long.valueOf(zipEntry.getCrc())));
            this.l = zipEntry;
            this.m = i;
        }

        @Override // java.lang.Comparable
        public int compareTo(Object obj) {
            return this.j.compareTo(((b) obj).j);
        }
    }

    /* JADX INFO: renamed from: b.f.m.f$c */
    /* JADX INFO: compiled from: ExtractFromZipSoSource.java */
    public class c extends UnpackingSoSource.f {
        public b[] j;
        public final ZipFile k;
        public final UnpackingSoSource l;

        /* JADX INFO: renamed from: b.f.m.f$c$a */
        /* JADX INFO: compiled from: ExtractFromZipSoSource.java */
        public final class a extends UnpackingSoSource.e {
            public int j;

            public a(a aVar) {
            }

            @Override // b.f.m.UnpackingSoSource.e
            public boolean a() {
                c.this.c();
                return this.j < c.this.j.length;
            }

            @Override // b.f.m.UnpackingSoSource.e
            public UnpackingSoSource.d b() throws IOException {
                c.this.c();
                c cVar = c.this;
                b[] bVarArr = cVar.j;
                int i = this.j;
                this.j = i + 1;
                b bVar = bVarArr[i];
                InputStream inputStream = cVar.k.getInputStream(bVar.l);
                try {
                    return new UnpackingSoSource.d(bVar, inputStream);
                } catch (Throwable th) {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    throw th;
                }
            }
        }

        public c(UnpackingSoSource unpackingSoSource) throws IOException {
            this.k = new ZipFile(ExtractFromZipSoSource.this.f);
            this.l = unpackingSoSource;
        }

        @Override // b.f.m.UnpackingSoSource.f
        public final UnpackingSoSource.c a() throws IOException {
            return new UnpackingSoSource.c(c());
        }

        @Override // b.f.m.UnpackingSoSource.f
        public final UnpackingSoSource.e b() throws IOException {
            return new a(null);
        }

        /* JADX WARN: Code duplicated, block: B:44:0x0120  */
        /* JADX WARN: Code duplicated, block: B:45:0x0123  */
        public final b[] c() {
            int i;
            String strY;
            boolean z2;
            if (this.j == null) {
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                HashMap map = new HashMap();
                Pattern patternCompile = Pattern.compile(ExtractFromZipSoSource.this.g);
                String[] strArrC0 = AnimatableValueParser.C0();
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
                            b bVar = (b) map.get(strGroup2);
                            if (bVar == null || i < bVar.m) {
                                map.put(strGroup2, new b(strGroup2, zipEntryNextElement, i));
                            }
                        }
                    }
                }
                UnpackingSoSource unpackingSoSource = this.l;
                Objects.requireNonNull(unpackingSoSource);
                b[] bVarArr = (b[]) map.values().toArray(new b[map.size()]);
                Arrays.sort(bVarArr);
                int i2 = 0;
                for (int i3 = 0; i3 < bVarArr.length; i3++) {
                    b bVar2 = bVarArr[i3];
                    ZipEntry zipEntry = bVar2.l;
                    String str = bVar2.j;
                    ApkSoSource.a aVar = (ApkSoSource.a) this;
                    String name = zipEntry.getName();
                    if (str.equals(ApkSoSource.this.d)) {
                        ApkSoSource.this.d = null;
                        strY = String.format("allowing consideration of corrupted lib %s", str);
                    } else if ((aVar.o & 1) == 0) {
                        strY = outline.y("allowing consideration of ", name, ": self-extraction preferred");
                    } else {
                        File file = new File(aVar.n, str);
                        if (file.isFile()) {
                            long length = file.length();
                            long size = zipEntry.getSize();
                            if (length != size) {
                                strY = String.format("allowing consideration of %s: sysdir file length is %s, but the file is %s bytes long in the APK", file, Long.valueOf(length), Long.valueOf(size));
                            } else {
                                strY = outline.y("not allowing consideration of ", name, ": deferring to libdir");
                                z2 = false;
                            }
                            Log.d("ApkSoSource", strY);
                            if (z2) {
                                i2++;
                            } else {
                                bVarArr[i3] = null;
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
                        bVarArr[i3] = null;
                    }
                }
                b[] bVarArr2 = new b[i2];
                int i4 = 0;
                while (i < bVarArr.length) {
                    b bVar3 = bVarArr[i];
                    if (bVar3 != null) {
                        bVarArr2[i4] = bVar3;
                        i4++;
                    }
                    i++;
                }
                this.j = bVarArr2;
            }
            return this.j;
        }

        @Override // b.f.m.UnpackingSoSource.f, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.k.close();
        }
    }

    public ExtractFromZipSoSource(Context context, String str, File file, String str2) {
        super(context, str);
        this.f = file;
        this.g = str2;
    }
}
