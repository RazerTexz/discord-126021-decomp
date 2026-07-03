package p007b.p225i.p361c.p369m.p370d.p373k;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Set;

/* JADX INFO: renamed from: b.i.c.m.d.k.t */
/* JADX INFO: compiled from: CrashlyticsController.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4655t implements FilenameFilter {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Set f12390a;

    public C4655t(C4663x c4663x, Set set) {
        this.f12390a = set;
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        if (str.length() < 35) {
            return false;
        }
        return this.f12390a.contains(str.substring(0, 35));
    }
}
