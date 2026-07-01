package b.f.m;

import android.content.Context;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: ExoSoSource.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e$b extends m$f {
    public final e$c[] j;

    public e$b(e eVar, m mVar) throws IOException {
        boolean z2;
        Context context = eVar.c;
        StringBuilder sbU = b.d.b.a.a.U("/data/local/tmp/exopackage/");
        sbU.append(context.getPackageName());
        sbU.append("/native-libs/");
        File file = new File(sbU.toString());
        ArrayList arrayList = new ArrayList();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (String str : b.c.a.a0.d.C0()) {
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
                                            if (((e$c) arrayList.get(i)).j.equals(str2)) {
                                                z2 = true;
                                                break;
                                            }
                                            i++;
                                        }
                                    }
                                    if (!z2) {
                                        String strSubstring = line.substring(iIndexOf + 1);
                                        arrayList.add(new e$c(str2, strSubstring, new File(file2, strSubstring)));
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
        this.j = (e$c[]) arrayList.toArray(new e$c[arrayList.size()]);
    }

    @Override // b.f.m.m$f
    public m$c a() throws IOException {
        return new m$c(this.j);
    }

    @Override // b.f.m.m$f
    public m$e b() throws IOException {
        return new e$b$a(this, null);
    }
}
