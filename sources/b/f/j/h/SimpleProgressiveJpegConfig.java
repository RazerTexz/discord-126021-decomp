package b.f.j.h;

import b.f.j.j.ImmutableQualityInfo;
import b.f.j.j.QualityInfo;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: b.f.j.h.f, reason: use source file name */
/* JADX INFO: compiled from: SimpleProgressiveJpegConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class SimpleProgressiveJpegConfig implements ProgressiveJpegConfig {
    public final c a = new b(null);

    /* JADX INFO: renamed from: b.f.j.h.f$b */
    /* JADX INFO: compiled from: SimpleProgressiveJpegConfig.java */
    public static class b implements c {
        public b(a aVar) {
        }

        @Override // b.f.j.h.SimpleProgressiveJpegConfig.c
        public List<Integer> a() {
            return Collections.EMPTY_LIST;
        }

        @Override // b.f.j.h.SimpleProgressiveJpegConfig.c
        public int b() {
            return 0;
        }
    }

    /* JADX INFO: renamed from: b.f.j.h.f$c */
    /* JADX INFO: compiled from: SimpleProgressiveJpegConfig.java */
    public interface c {
        List<Integer> a();

        int b();
    }

    @Override // b.f.j.h.ProgressiveJpegConfig
    public QualityInfo a(int i) {
        return new ImmutableQualityInfo(i, i >= this.a.b(), false);
    }

    @Override // b.f.j.h.ProgressiveJpegConfig
    public int b(int i) {
        List<Integer> listA = this.a.a();
        if (listA == null || listA.isEmpty()) {
            return i + 1;
        }
        for (int i2 = 0; i2 < listA.size(); i2++) {
            if (listA.get(i2).intValue() > i) {
                return listA.get(i2).intValue();
            }
        }
        return Integer.MAX_VALUE;
    }
}
