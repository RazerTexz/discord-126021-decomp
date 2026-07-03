package p007b.p225i.p414e.p426q;

import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import p007b.p225i.p414e.EnumC4946a;
import p007b.p225i.p414e.EnumC4949d;
import p007b.p225i.p414e.p418n.C4962a;

/* JADX INFO: renamed from: b.i.e.q.j */
/* JADX INFO: compiled from: MultiFormatUPCEANReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4996j extends AbstractC4997k {

    /* JADX INFO: renamed from: a */
    public final AbstractC5002p[] f13379a;

    public C4996j(Map<EnumC4949d, ?> map) {
        Collection collection = map == null ? null : (Collection) map.get(EnumC4949d.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(EnumC4946a.EAN_13)) {
                arrayList.add(new C4991e());
            } else if (collection.contains(EnumC4946a.UPC_A)) {
                arrayList.add(new C4998l());
            }
            if (collection.contains(EnumC4946a.EAN_8)) {
                arrayList.add(new C4992f());
            }
            if (collection.contains(EnumC4946a.UPC_E)) {
                arrayList.add(new C5003q());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new C4991e());
            arrayList.add(new C4992f());
            arrayList.add(new C5003q());
        }
        this.f13379a = (AbstractC5002p[]) arrayList.toArray(new AbstractC5002p[arrayList.size()]);
    }

    @Override // p007b.p225i.p414e.p426q.AbstractC4997k
    /* JADX INFO: renamed from: b */
    public Result mo6983b(int i, C4962a c4962a, Map<EnumC4949d, ?> map) throws NotFoundException {
        EnumC4946a enumC4946a = EnumC4946a.UPC_A;
        int[] iArrM7006m = AbstractC5002p.m7006m(c4962a);
        for (AbstractC5002p abstractC5002p : this.f13379a) {
            try {
                Result resultMo7001k = abstractC5002p.mo7001k(i, c4962a, iArrM7006m, map);
                boolean z2 = resultMo7001k.f21671d == EnumC4946a.EAN_13 && resultMo7001k.f21668a.charAt(0) == '0';
                Collection collection = map == null ? null : (Collection) map.get(EnumC4949d.POSSIBLE_FORMATS);
                boolean z3 = collection == null || collection.contains(enumC4946a);
                if (!z2 || !z3) {
                    return resultMo7001k;
                }
                Result result = new Result(resultMo7001k.f21668a.substring(1), resultMo7001k.f21669b, resultMo7001k.f21670c, enumC4946a);
                result.m9261a(resultMo7001k.f21672e);
                return result;
            } catch (ReaderException unused) {
            }
        }
        throw NotFoundException.f21665l;
    }

    @Override // p007b.p225i.p414e.p426q.AbstractC4997k, p007b.p225i.p414e.InterfaceC4954i
    public void reset() {
        for (AbstractC5002p abstractC5002p : this.f13379a) {
            Objects.requireNonNull(abstractC5002p);
        }
    }
}
