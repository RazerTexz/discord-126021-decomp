package b.i.c.m.d.k;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Set;

/* JADX INFO: compiled from: CrashlyticsController.java */
/* JADX INFO: loaded from: classes3.dex */
public class t implements FilenameFilter {
    public final /* synthetic */ Set a;

    public t(x xVar, Set set) {
        this.a = set;
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        if (str.length() < 35) {
            return false;
        }
        return this.a.contains(str.substring(0, 35));
    }
}
