package p007b.p452o.p453a.p473x;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* JADX INFO: renamed from: b.o.a.x.k */
/* JADX INFO: compiled from: SizeSelectors.java */
/* JADX INFO: loaded from: classes3.dex */
public class C5245k implements InterfaceC5237c {

    /* JADX INFO: renamed from: a */
    public InterfaceC5244j f14258a;

    public C5245k(InterfaceC5244j interfaceC5244j, C3404f.a aVar) {
        this.f14258a = interfaceC5244j;
    }

    @Override // p007b.p452o.p453a.p473x.InterfaceC5237c
    @NonNull
    /* JADX INFO: renamed from: a */
    public List<C5236b> mo7452a(@NonNull List<C5236b> list) {
        ArrayList arrayList = new ArrayList();
        for (C5236b c5236b : list) {
            if (this.f14258a.mo4369a(c5236b)) {
                arrayList.add(c5236b);
            }
        }
        return arrayList;
    }
}
