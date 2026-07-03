package p007b.p109f.p148h.p158b.p159a;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import p007b.p109f.p148h.p158b.p159a.InterfaceC1827b;

/* JADX INFO: renamed from: b.f.h.b.a.c */
/* JADX INFO: compiled from: ForwardingControllerListener2.java */
/* JADX INFO: loaded from: classes.dex */
public class C1828c<I> extends C1826a<I> {

    /* JADX INFO: renamed from: j */
    public final List<InterfaceC1827b<I>> f3568j = new ArrayList(2);

    @Override // p007b.p109f.p148h.p158b.p159a.InterfaceC1827b
    /* JADX INFO: renamed from: a */
    public void mo1071a(String str, Object obj, InterfaceC1827b.a aVar) {
        int size = this.f3568j.size();
        for (int i = 0; i < size; i++) {
            try {
                InterfaceC1827b<I> interfaceC1827b = this.f3568j.get(i);
                if (interfaceC1827b != null) {
                    interfaceC1827b.mo1071a(str, obj, aVar);
                }
            } catch (Exception e) {
                m1168e("ForwardingControllerListener2 exception in onSubmit", e);
            }
        }
    }

    @Override // p007b.p109f.p148h.p158b.p159a.InterfaceC1827b
    /* JADX INFO: renamed from: b */
    public void mo1072b(String str, Throwable th, InterfaceC1827b.a aVar) {
        int size = this.f3568j.size();
        for (int i = 0; i < size; i++) {
            try {
                InterfaceC1827b<I> interfaceC1827b = this.f3568j.get(i);
                if (interfaceC1827b != null) {
                    interfaceC1827b.mo1072b(str, th, aVar);
                }
            } catch (Exception e) {
                m1168e("ForwardingControllerListener2 exception in onFailure", e);
            }
        }
    }

    @Override // p007b.p109f.p148h.p158b.p159a.InterfaceC1827b
    /* JADX INFO: renamed from: c */
    public void mo1073c(String str, InterfaceC1827b.a aVar) {
        int size = this.f3568j.size();
        for (int i = 0; i < size; i++) {
            try {
                InterfaceC1827b<I> interfaceC1827b = this.f3568j.get(i);
                if (interfaceC1827b != null) {
                    interfaceC1827b.mo1073c(str, aVar);
                }
            } catch (Exception e) {
                m1168e("ForwardingControllerListener2 exception in onRelease", e);
            }
        }
    }

    @Override // p007b.p109f.p148h.p158b.p159a.InterfaceC1827b
    /* JADX INFO: renamed from: d */
    public void mo1074d(String str, I i, InterfaceC1827b.a aVar) {
        int size = this.f3568j.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                InterfaceC1827b<I> interfaceC1827b = this.f3568j.get(i2);
                if (interfaceC1827b != null) {
                    interfaceC1827b.mo1074d(str, i, aVar);
                }
            } catch (Exception e) {
                m1168e("ForwardingControllerListener2 exception in onFinalImageSet", e);
            }
        }
    }

    /* JADX INFO: renamed from: e */
    public final synchronized void m1168e(String str, Throwable th) {
        Log.e("FwdControllerListener2", str, th);
    }
}
