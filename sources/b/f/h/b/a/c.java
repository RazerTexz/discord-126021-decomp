package b.f.h.b.a;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ForwardingControllerListener2.java */
/* JADX INFO: loaded from: classes.dex */
public class c<I> extends a<I> {
    public final List<b<I>> j = new ArrayList(2);

    @Override // b.f.h.b.a.b
    public void a(String str, Object obj, b$a b_a) {
        int size = this.j.size();
        for (int i = 0; i < size; i++) {
            try {
                b<I> bVar = this.j.get(i);
                if (bVar != null) {
                    bVar.a(str, obj, b_a);
                }
            } catch (Exception e) {
                e("ForwardingControllerListener2 exception in onSubmit", e);
            }
        }
    }

    @Override // b.f.h.b.a.b
    public void b(String str, Throwable th, b$a b_a) {
        int size = this.j.size();
        for (int i = 0; i < size; i++) {
            try {
                b<I> bVar = this.j.get(i);
                if (bVar != null) {
                    bVar.b(str, th, b_a);
                }
            } catch (Exception e) {
                e("ForwardingControllerListener2 exception in onFailure", e);
            }
        }
    }

    @Override // b.f.h.b.a.b
    public void c(String str, b$a b_a) {
        int size = this.j.size();
        for (int i = 0; i < size; i++) {
            try {
                b<I> bVar = this.j.get(i);
                if (bVar != null) {
                    bVar.c(str, b_a);
                }
            } catch (Exception e) {
                e("ForwardingControllerListener2 exception in onRelease", e);
            }
        }
    }

    @Override // b.f.h.b.a.b
    public void d(String str, I i, b$a b_a) {
        int size = this.j.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                b<I> bVar = this.j.get(i2);
                if (bVar != null) {
                    bVar.d(str, i, b_a);
                }
            } catch (Exception e) {
                e("ForwardingControllerListener2 exception in onFinalImageSet", e);
            }
        }
    }

    public final synchronized void e(String str, Throwable th) {
        Log.e("FwdControllerListener2", str, th);
    }
}
