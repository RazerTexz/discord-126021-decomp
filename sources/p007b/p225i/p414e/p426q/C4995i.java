package p007b.p225i.p414e.p426q;

import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import p007b.p225i.p414e.EnumC4946a;
import p007b.p225i.p414e.EnumC4949d;
import p007b.p225i.p414e.p418n.C4962a;
import p007b.p225i.p414e.p426q.p427r.C5008e;
import p007b.p225i.p414e.p426q.p427r.p428f.C5011c;

/* JADX INFO: renamed from: b.i.e.q.i */
/* JADX INFO: compiled from: MultiFormatOneDReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4995i extends AbstractC4997k {

    /* JADX INFO: renamed from: a */
    public final AbstractC4997k[] f13378a;

    public C4995i(Map<EnumC4949d, ?> map) {
        Collection collection = map == null ? null : (Collection) map.get(EnumC4949d.POSSIBLE_FORMATS);
        boolean z2 = (map == null || map.get(EnumC4949d.ASSUME_CODE_39_CHECK_DIGIT) == null) ? false : true;
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(EnumC4946a.EAN_13) || collection.contains(EnumC4946a.UPC_A) || collection.contains(EnumC4946a.EAN_8) || collection.contains(EnumC4946a.UPC_E)) {
                arrayList.add(new C4996j(map));
            }
            if (collection.contains(EnumC4946a.CODE_39)) {
                arrayList.add(new C4989c(z2));
            }
            if (collection.contains(EnumC4946a.CODE_93)) {
                arrayList.add(new C4990d());
            }
            if (collection.contains(EnumC4946a.CODE_128)) {
                arrayList.add(new C4988b());
            }
            if (collection.contains(EnumC4946a.ITF)) {
                arrayList.add(new C4994h());
            }
            if (collection.contains(EnumC4946a.CODABAR)) {
                arrayList.add(new C4987a());
            }
            if (collection.contains(EnumC4946a.RSS_14)) {
                arrayList.add(new C5008e());
            }
            if (collection.contains(EnumC4946a.RSS_EXPANDED)) {
                arrayList.add(new C5011c());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new C4996j(map));
            arrayList.add(new C4989c(false));
            arrayList.add(new C4987a());
            arrayList.add(new C4990d());
            arrayList.add(new C4988b());
            arrayList.add(new C4994h());
            arrayList.add(new C5008e());
            arrayList.add(new C5011c());
        }
        this.f13378a = (AbstractC4997k[]) arrayList.toArray(new AbstractC4997k[arrayList.size()]);
    }

    @Override // p007b.p225i.p414e.p426q.AbstractC4997k
    /* JADX INFO: renamed from: b */
    public Result mo6983b(int i, C4962a c4962a, Map<EnumC4949d, ?> map) throws NotFoundException {
        for (AbstractC4997k abstractC4997k : this.f13378a) {
            try {
                return abstractC4997k.mo6983b(i, c4962a, map);
            } catch (ReaderException unused) {
            }
        }
        throw NotFoundException.f21665l;
    }

    @Override // p007b.p225i.p414e.p426q.AbstractC4997k, p007b.p225i.p414e.InterfaceC4954i
    public void reset() {
        for (AbstractC4997k abstractC4997k : this.f13378a) {
            abstractC4997k.reset();
        }
    }
}
