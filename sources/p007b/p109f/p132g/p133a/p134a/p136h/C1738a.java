package p007b.p109f.p132g.p133a.p134a.p136h;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p007b.p109f.p115d.p120e.C1691a;

/* JADX INFO: renamed from: b.f.g.a.a.h.a */
/* JADX INFO: compiled from: ForwardingImageOriginListener.java */
/* JADX INFO: loaded from: classes.dex */
public class C1738a implements InterfaceC1739b {

    /* JADX INFO: renamed from: a */
    public final List<InterfaceC1739b> f3199a;

    public C1738a(InterfaceC1739b... interfaceC1739bArr) {
        ArrayList arrayList = new ArrayList(interfaceC1739bArr.length);
        this.f3199a = arrayList;
        Collections.addAll(arrayList, interfaceC1739bArr);
    }

    @Override // p007b.p109f.p132g.p133a.p134a.p136h.InterfaceC1739b
    /* JADX INFO: renamed from: a */
    public synchronized void mo1061a(String str, int i, boolean z2, String str2) {
        int size = this.f3199a.size();
        for (int i2 = 0; i2 < size; i2++) {
            InterfaceC1739b interfaceC1739b = this.f3199a.get(i2);
            if (interfaceC1739b != null) {
                try {
                    interfaceC1739b.mo1061a(str, i, z2, str2);
                } catch (Exception e) {
                    C1691a.m978f("ForwardingImageOriginListener", "InternalListener exception in onImageLoaded", e);
                }
            }
        }
    }
}
