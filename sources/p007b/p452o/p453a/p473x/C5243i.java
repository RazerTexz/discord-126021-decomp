package p007b.p452o.p453a.p473x;

import androidx.annotation.NonNull;
import java.util.List;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* JADX INFO: renamed from: b.o.a.x.i */
/* JADX INFO: compiled from: SizeSelectors.java */
/* JADX INFO: loaded from: classes3.dex */
public class C5243i implements InterfaceC5237c {

    /* JADX INFO: renamed from: a */
    public InterfaceC5237c[] f14257a;

    public C5243i(InterfaceC5237c[] interfaceC5237cArr, C3404f.a aVar) {
        this.f14257a = interfaceC5237cArr;
    }

    @Override // p007b.p452o.p453a.p473x.InterfaceC5237c
    @NonNull
    /* JADX INFO: renamed from: a */
    public List<C5236b> mo7452a(@NonNull List<C5236b> list) {
        for (InterfaceC5237c interfaceC5237c : this.f14257a) {
            list = interfaceC5237c.mo7452a(list);
        }
        return list;
    }
}
