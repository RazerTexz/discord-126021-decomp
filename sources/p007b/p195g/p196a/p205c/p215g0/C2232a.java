package p007b.p195g.p196a.p205c.p215g0;

import java.util.Map;
import p007b.p195g.p196a.p198b.AbstractC2108d;
import p007b.p195g.p196a.p205c.AbstractC2364n;
import p007b.p195g.p196a.p205c.AbstractC2374x;
import p007b.p195g.p196a.p205c.InterfaceC2206d;
import p007b.p195g.p196a.p205c.p210c0.AbstractC2188i;
import p007b.p195g.p196a.p205c.p215g0.p217u.C2310t;

/* JADX INFO: renamed from: b.g.a.c.g0.a */
/* JADX INFO: compiled from: AnyGetterWriter.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2232a {

    /* JADX INFO: renamed from: a */
    public final InterfaceC2206d f4784a;

    /* JADX INFO: renamed from: b */
    public final AbstractC2188i f4785b;

    /* JADX INFO: renamed from: c */
    public AbstractC2364n<Object> f4786c;

    /* JADX INFO: renamed from: d */
    public C2310t f4787d;

    public C2232a(InterfaceC2206d interfaceC2206d, AbstractC2188i abstractC2188i, AbstractC2364n<?> abstractC2364n) {
        this.f4785b = abstractC2188i;
        this.f4784a = interfaceC2206d;
        this.f4786c = abstractC2364n;
        if (abstractC2364n instanceof C2310t) {
            this.f4787d = (C2310t) abstractC2364n;
        }
    }

    /* JADX INFO: renamed from: a */
    public void m1970a(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws Exception {
        Object objMo1889j = this.f4785b.mo1889j(obj);
        if (objMo1889j == null) {
            return;
        }
        if (!(objMo1889j instanceof Map)) {
            abstractC2374x.mo1942f(this.f4784a.getType(), String.format("Value returned by 'any-getter' %s() not java.util.Map but %s", this.f4785b.mo1819c(), objMo1889j.getClass().getName()));
            throw null;
        }
        C2310t c2310t = this.f4787d;
        if (c2310t != null) {
            c2310t.m2085u((Map) objMo1889j, abstractC2108d, abstractC2374x);
        } else {
            this.f4786c.mo1807f(objMo1889j, abstractC2108d, abstractC2374x);
        }
    }
}
