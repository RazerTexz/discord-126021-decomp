package p007b.p452o.p453a.p455n.p459r;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p452o.p453a.C5103b;
import p007b.p452o.p453a.p455n.AbstractC5135i;
import p007b.p452o.p453a.p455n.C5130d;
import p007b.p452o.p453a.p455n.p456o.AbstractC5144d;
import p007b.p452o.p453a.p455n.p456o.AbstractC5145e;
import p007b.p452o.p453a.p455n.p456o.InterfaceC5143c;
import p007b.p452o.p453a.p455n.p460s.C5169b;
import p007b.p452o.p453a.p455n.p461t.EnumC5171b;
import p007b.p452o.p453a.p469t.C5211b;

/* JADX INFO: renamed from: b.o.a.n.r.g */
/* JADX INFO: compiled from: MeterAction.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public class C5164g extends AbstractC5144d {

    /* JADX INFO: renamed from: e */
    public static final C5103b f13976e = new C5103b(C5164g.class.getSimpleName());

    /* JADX INFO: renamed from: f */
    public List<AbstractC5158a> f13977f;

    /* JADX INFO: renamed from: g */
    public AbstractC5145e f13978g;

    /* JADX INFO: renamed from: h */
    public final C5211b f13979h;

    /* JADX INFO: renamed from: i */
    public final AbstractC5135i f13980i;

    /* JADX INFO: renamed from: j */
    public final boolean f13981j;

    public C5164g(@NonNull AbstractC5135i abstractC5135i, @Nullable C5211b c5211b, boolean z2) {
        this.f13979h = c5211b;
        this.f13980i = abstractC5135i;
        this.f13981j = z2;
    }

    @Override // p007b.p452o.p453a.p455n.p456o.AbstractC5144d, p007b.p452o.p453a.p455n.p456o.AbstractC5145e
    /* JADX INFO: renamed from: j */
    public void mo7249j(@NonNull InterfaceC5143c interfaceC5143c) {
        C5103b c5103b = f13976e;
        c5103b.m7159a(2, "onStart:", "initializing.");
        m7353n(interfaceC5143c);
        c5103b.m7159a(2, "onStart:", "initialized.");
        super.mo7249j(interfaceC5143c);
    }

    @Override // p007b.p452o.p453a.p455n.p456o.AbstractC5144d
    @NonNull
    /* JADX INFO: renamed from: m */
    public AbstractC5145e mo7336m() {
        return this.f13978g;
    }

    /* JADX INFO: renamed from: n */
    public final void m7353n(@NonNull InterfaceC5143c interfaceC5143c) {
        List arrayList = new ArrayList();
        if (this.f13979h != null) {
            C5130d c5130d = (C5130d) interfaceC5143c;
            C5169b c5169b = new C5169b(this.f13980i.mo7281e(), this.f13980i.mo7315z().m7432l(), this.f13980i.mo7254C(EnumC5171b.VIEW), this.f13980i.mo7315z().f14209d, c5130d.f13805g0, c5130d.f13807i0);
            arrayList = this.f13979h.m7411c(c5169b).m7410b(Integer.MAX_VALUE, c5169b);
        }
        C5160c c5160c = new C5160c(arrayList, this.f13981j);
        C5162e c5162e = new C5162e(arrayList, this.f13981j);
        C5166i c5166i = new C5166i(arrayList, this.f13981j);
        this.f13977f = Arrays.asList(c5160c, c5162e, c5166i);
        this.f13978g = C3404f.m4361x1(c5160c, c5162e, c5166i);
    }
}
