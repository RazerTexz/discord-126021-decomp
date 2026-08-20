package p007b.p109f.p190m;

import android.content.Context;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.f.m.e */
/* JADX INFO: compiled from: ExoSoSource.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2052e extends AbstractC2060m {

    /* JADX INFO: renamed from: b.f.m.e$b */
    /* JADX INFO: compiled from: ExoSoSource.java */
    public final class b extends AbstractC2060m.f {

        /* JADX INFO: renamed from: j */
        public final c[] f4321j;

        /* JADX INFO: renamed from: b.f.m.e$b$a */
        /* JADX INFO: compiled from: ExoSoSource.java */
        public final class a extends AbstractC2060m.e {

            /* JADX INFO: renamed from: j */
            public int f4322j;

            public a(a aVar) {
            }

            @Override // p007b.p109f.p190m.AbstractC2060m.e
            /* JADX INFO: renamed from: a */
            public boolean mo1575a() {
                return this.f4322j < b.this.f4321j.length;
            }

            @Override // p007b.p109f.p190m.AbstractC2060m.e
            /* JADX INFO: renamed from: b */
            public AbstractC2060m.d mo1576b() throws IOException {
                c[] cVarArr = b.this.f4321j;
                int i = this.f4322j;
                this.f4322j = i + 1;
                c cVar = cVarArr[i];
                FileInputStream fileInputStream = new FileInputStream(cVar.f4324l);
                try {
                    return new AbstractC2060m.d(cVar, fileInputStream);
                } catch (Throwable th) {
                    fileInputStream.close();
                    throw th;
                }
            }
        }

        public b(C2052e c2052e, AbstractC2060m abstractC2060m) throws IOException {
            boolean z2;
            Context context = c2052e.f4344c;
            StringBuilder sbM833U = C1643a.m833U("/data/local/tmp/exopackage/");
            sbM833U.append(context.getPackageName());
            sbM833U.append("/native-libs/");
            File file = new File(sbM833U.toString());
            ArrayList arrayList = new ArrayList();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (String str : C1460d.m424C0()) {
                File file2 = new File(file, str);
                if (file2.isDirectory()) {
                    linkedHashSet.add(str);
                    File file3 = new File(file2, "metadata.txt");
                    if (file3.isFile()) {
                        FileReader fileReader = new FileReader(file3);
                        try {
                            BufferedReader bufferedReader = new BufferedReader(fileReader);
                            while (true) {
                                try {
                                    String line = bufferedReader.readLine();
                                    if (line == null) {
                                        bufferedReader.close();
                                        fileReader.close();
                                        break;
                                    }
                                    if (line.length() != 0) {
                                        int iIndexOf = line.indexOf(32);
                                        if (iIndexOf == -1) {
                                            throw new RuntimeException("illegal line in exopackage metadata: [" + line + "]");
                                        }
                                        String str2 = line.substring(0, iIndexOf) + ".so";
                                        int size = arrayList.size();
                                        int i = 0;
                                        while (true) {
                                            if (i >= size) {
                                                z2 = false;
                                                break;
                                            } else {
                                                if (((c) arrayList.get(i)).f4353j.equals(str2)) {
                                                    z2 = true;
                                                    break;
                                                }
                                                i++;
                                            }
                                        }
                                        if (!z2) {
                                            String strSubstring = line.substring(iIndexOf + 1);
                                            arrayList.add(new c(str2, strSubstring, new File(file2, strSubstring)));
                                        }
                                    }
                                } catch (Throwable th) {
                                    try {
                                        throw th;
                                    } catch (Throwable th2) {
                                        try {
                                            bufferedReader.close();
                                            throw th2;
                                        } catch (Throwable th3) {
                                            th.addSuppressed(th3);
                                            throw th2;
                                        }
                                    }
                                }
                                try {
                                    throw th;
                                } catch (Throwable th4) {
                                    try {
                                        fileReader.close();
                                        throw th4;
                                    } catch (Throwable th5) {
                                        th.addSuppressed(th5);
                                        throw th4;
                                    }
                                }
                            }
                        } catch (Throwable th6) {
                            throw th6;
                        }
                    }
                    continue;
                }
            }
            this.f4321j = (c[]) arrayList.toArray(new c[arrayList.size()]);
        }

        @Override // p007b.p109f.p190m.AbstractC2060m.f
        /* JADX INFO: renamed from: a */
        public AbstractC2060m.c mo1573a() throws IOException {
            return new AbstractC2060m.c(this.f4321j);
        }

        @Override // p007b.p109f.p190m.AbstractC2060m.f
        /* JADX INFO: renamed from: b */
        public AbstractC2060m.e mo1574b() throws IOException {
            return new a(null);
        }
    }

    /* JADX INFO: renamed from: b.f.m.e$c */
    /* JADX INFO: compiled from: ExoSoSource.java */
    public static final class c extends AbstractC2060m.b {

        /* JADX INFO: renamed from: l */
        public final File f4324l;

        public c(String str, String str2, File file) {
            super(str, str2);
            this.f4324l = file;
        }
    }

    public C2052e(Context context, String str) {
        super(context, str);
    }

    @Override // p007b.p109f.p190m.AbstractC2060m
    /* JADX INFO: renamed from: i */
    public AbstractC2060m.f mo1566i() throws IOException {
        return new b(this, this);
    }
}
