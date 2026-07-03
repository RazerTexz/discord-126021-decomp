package p007b.p109f.p161j.p181p;

import android.util.Pair;
import java.util.List;
import p007b.p109f.p161j.p169d.EnumC1883d;
import p007b.p109f.p161j.p181p.AbstractC1996l0;

/* JADX INFO: renamed from: b.f.j.p.m0 */
/* JADX INFO: compiled from: MultiplexProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class C1998m0 extends C1974e {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Pair f4141a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ AbstractC1996l0.b f4142b;

    public C1998m0(AbstractC1996l0.b bVar, Pair pair) {
        this.f4142b = bVar;
        this.f4141a = pair;
    }

    @Override // p007b.p109f.p161j.p181p.InterfaceC2022y0
    /* JADX INFO: renamed from: a */
    public void mo1438a() {
        boolean zRemove;
        List<InterfaceC2022y0> list;
        C1971d c1971d;
        List<InterfaceC2022y0> listM1492j;
        List<InterfaceC2022y0> listM1494l;
        synchronized (this.f4142b) {
            zRemove = this.f4142b.f4133b.remove(this.f4141a);
            list = null;
            if (!zRemove) {
                c1971d = null;
            } else if (this.f4142b.f4133b.isEmpty()) {
                c1971d = this.f4142b.f4137f;
            } else {
                List<InterfaceC2022y0> listM1493k = this.f4142b.m1493k();
                listM1494l = this.f4142b.m1494l();
                listM1492j = this.f4142b.m1492j();
                c1971d = null;
                list = listM1493k;
            }
            listM1494l = null;
            listM1492j = null;
        }
        C1971d.m1441s(list);
        C1971d.m1442t(listM1494l);
        C1971d.m1440r(listM1492j);
        if (c1971d != null) {
            if (!AbstractC1996l0.this.f4129c || c1971d.mo1453k()) {
                c1971d.m1460u();
            } else {
                C1971d.m1442t(c1971d.m1461v(EnumC1883d.LOW));
            }
        }
        if (zRemove) {
            ((InterfaceC1995l) this.f4141a.first).mo1426d();
        }
    }

    @Override // p007b.p109f.p161j.p181p.C1974e, p007b.p109f.p161j.p181p.InterfaceC2022y0
    /* JADX INFO: renamed from: b */
    public void mo1439b() {
        C1971d.m1440r(this.f4142b.m1492j());
    }

    @Override // p007b.p109f.p161j.p181p.C1974e, p007b.p109f.p161j.p181p.InterfaceC2022y0
    /* JADX INFO: renamed from: c */
    public void mo1462c() {
        C1971d.m1442t(this.f4142b.m1494l());
    }

    @Override // p007b.p109f.p161j.p181p.C1974e, p007b.p109f.p161j.p181p.InterfaceC2022y0
    /* JADX INFO: renamed from: d */
    public void mo1463d() {
        C1971d.m1441s(this.f4142b.m1493k());
    }
}
