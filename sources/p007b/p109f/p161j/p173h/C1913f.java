package p007b.p109f.p161j.p173h;

import java.util.Collections;
import java.util.List;
import p007b.p109f.p161j.p175j.C1922h;
import p007b.p109f.p161j.p175j.InterfaceC1923i;

/* JADX INFO: renamed from: b.f.j.h.f */
/* JADX INFO: compiled from: SimpleProgressiveJpegConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class C1913f implements InterfaceC1911d {

    /* JADX INFO: renamed from: a */
    public final c f3881a = new b(null);

    /* JADX INFO: renamed from: b.f.j.h.f$b */
    /* JADX INFO: compiled from: SimpleProgressiveJpegConfig.java */
    public static class b implements c {
        public b(a aVar) {
        }

        @Override // p007b.p109f.p161j.p173h.C1913f.c
        /* JADX INFO: renamed from: a */
        public List<Integer> mo1328a() {
            return Collections.EMPTY_LIST;
        }

        @Override // p007b.p109f.p161j.p173h.C1913f.c
        /* JADX INFO: renamed from: b */
        public int mo1329b() {
            return 0;
        }
    }

    /* JADX INFO: renamed from: b.f.j.h.f$c */
    /* JADX INFO: compiled from: SimpleProgressiveJpegConfig.java */
    public interface c {
        /* JADX INFO: renamed from: a */
        List<Integer> mo1328a();

        /* JADX INFO: renamed from: b */
        int mo1329b();
    }

    @Override // p007b.p109f.p161j.p173h.InterfaceC1911d
    /* JADX INFO: renamed from: a */
    public InterfaceC1923i mo1324a(int i) {
        return new C1922h(i, i >= this.f3881a.mo1329b(), false);
    }

    @Override // p007b.p109f.p161j.p173h.InterfaceC1911d
    /* JADX INFO: renamed from: b */
    public int mo1325b(int i) {
        List<Integer> listMo1328a = this.f3881a.mo1328a();
        if (listMo1328a == null || listMo1328a.isEmpty()) {
            return i + 1;
        }
        for (int i2 = 0; i2 < listMo1328a.size(); i2++) {
            if (listMo1328a.get(i2).intValue() > i) {
                return listMo1328a.get(i2).intValue();
            }
        }
        return Integer.MAX_VALUE;
    }
}
