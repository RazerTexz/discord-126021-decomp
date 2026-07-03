package p007b.p225i.p414e;

import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import p007b.p225i.p414e.p415m.C4959b;
import p007b.p225i.p414e.p421o.C4976a;
import p007b.p225i.p414e.p424p.C4983a;
import p007b.p225i.p414e.p426q.C4995i;
import p007b.p225i.p414e.p430r.C5032b;
import p007b.p225i.p414e.p434s.C5048a;

/* JADX INFO: renamed from: b.i.e.g */
/* JADX INFO: compiled from: MultiFormatReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4952g implements InterfaceC4954i {

    /* JADX INFO: renamed from: a */
    public Map<EnumC4949d, ?> f13188a;

    /* JADX INFO: renamed from: b */
    public InterfaceC4954i[] f13189b;

    @Override // p007b.p225i.p414e.InterfaceC4954i
    /* JADX INFO: renamed from: a */
    public Result mo6919a(C4948c c4948c, Map<EnumC4949d, ?> map) throws NotFoundException {
        m6921c(map);
        return m6920b(c4948c);
    }

    /* JADX INFO: renamed from: b */
    public final Result m6920b(C4948c c4948c) throws NotFoundException {
        InterfaceC4954i[] interfaceC4954iArr = this.f13189b;
        if (interfaceC4954iArr != null) {
            for (InterfaceC4954i interfaceC4954i : interfaceC4954iArr) {
                try {
                    return interfaceC4954i.mo6919a(c4948c, this.f13188a);
                } catch (ReaderException unused) {
                }
            }
        }
        throw NotFoundException.f21665l;
    }

    /* JADX INFO: renamed from: c */
    public void m6921c(Map<EnumC4949d, ?> map) {
        this.f13188a = map;
        boolean z2 = map != null && map.containsKey(EnumC4949d.TRY_HARDER);
        Collection collection = map == null ? null : (Collection) map.get(EnumC4949d.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            boolean z3 = collection.contains(EnumC4946a.UPC_A) || collection.contains(EnumC4946a.UPC_E) || collection.contains(EnumC4946a.EAN_13) || collection.contains(EnumC4946a.EAN_8) || collection.contains(EnumC4946a.CODABAR) || collection.contains(EnumC4946a.CODE_39) || collection.contains(EnumC4946a.CODE_93) || collection.contains(EnumC4946a.CODE_128) || collection.contains(EnumC4946a.ITF) || collection.contains(EnumC4946a.RSS_14) || collection.contains(EnumC4946a.RSS_EXPANDED);
            if (z3 && !z2) {
                arrayList.add(new C4995i(map));
            }
            if (collection.contains(EnumC4946a.QR_CODE)) {
                arrayList.add(new C5048a());
            }
            if (collection.contains(EnumC4946a.DATA_MATRIX)) {
                arrayList.add(new C4976a());
            }
            if (collection.contains(EnumC4946a.AZTEC)) {
                arrayList.add(new C4959b());
            }
            if (collection.contains(EnumC4946a.PDF_417)) {
                arrayList.add(new C5032b());
            }
            if (collection.contains(EnumC4946a.MAXICODE)) {
                arrayList.add(new C4983a());
            }
            if (z3 && z2) {
                arrayList.add(new C4995i(map));
            }
        }
        if (arrayList.isEmpty()) {
            if (!z2) {
                arrayList.add(new C4995i(map));
            }
            arrayList.add(new C5048a());
            arrayList.add(new C4976a());
            arrayList.add(new C4959b());
            arrayList.add(new C5032b());
            arrayList.add(new C4983a());
            if (z2) {
                arrayList.add(new C4995i(map));
            }
        }
        this.f13189b = (InterfaceC4954i[]) arrayList.toArray(new InterfaceC4954i[arrayList.size()]);
    }

    @Override // p007b.p225i.p414e.InterfaceC4954i
    public void reset() {
        InterfaceC4954i[] interfaceC4954iArr = this.f13189b;
        if (interfaceC4954iArr != null) {
            for (InterfaceC4954i interfaceC4954i : interfaceC4954iArr) {
                interfaceC4954i.reset();
            }
        }
    }
}
