package com.google.android.datatransport.cct;

import androidx.annotation.Keep;
import p007b.p225i.p226a.p228b.p229i.C2417d;
import p007b.p225i.p226a.p228b.p231j.p232q.AbstractC2457h;
import p007b.p225i.p226a.p228b.p231j.p232q.InterfaceC2453d;
import p007b.p225i.p226a.p228b.p231j.p232q.InterfaceC2462m;

/* JADX INFO: loaded from: classes3.dex */
@Keep
public class CctBackendFactory implements InterfaceC2453d {
    @Override // p007b.p225i.p226a.p228b.p231j.p232q.InterfaceC2453d
    public InterfaceC2462m create(AbstractC2457h abstractC2457h) {
        return new C2417d(abstractC2457h.mo2366a(), abstractC2457h.mo2369d(), abstractC2457h.mo2368c());
    }
}
