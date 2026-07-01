package b.f.h.b.a;

import android.util.Log;
import b.f.h.b.a.ControllerListener2;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: b.f.h.b.a.c, reason: use source file name */
/* JADX INFO: compiled from: ForwardingControllerListener2.java */
/* JADX INFO: loaded from: classes.dex */
public class ForwardingControllerListener2<I> extends BaseControllerListener2<I> {
    public final List<ControllerListener2<I>> j = new ArrayList(2);

    @Override // b.f.h.b.a.ControllerListener2
    public void a(String str, Object obj, ControllerListener2.a aVar) {
        int size = this.j.size();
        for (int i = 0; i < size; i++) {
            try {
                ControllerListener2<I> controllerListener2 = this.j.get(i);
                if (controllerListener2 != null) {
                    controllerListener2.a(str, obj, aVar);
                }
            } catch (Exception e) {
                e("ForwardingControllerListener2 exception in onSubmit", e);
            }
        }
    }

    @Override // b.f.h.b.a.ControllerListener2
    public void b(String str, Throwable th, ControllerListener2.a aVar) {
        int size = this.j.size();
        for (int i = 0; i < size; i++) {
            try {
                ControllerListener2<I> controllerListener2 = this.j.get(i);
                if (controllerListener2 != null) {
                    controllerListener2.b(str, th, aVar);
                }
            } catch (Exception e) {
                e("ForwardingControllerListener2 exception in onFailure", e);
            }
        }
    }

    @Override // b.f.h.b.a.ControllerListener2
    public void c(String str, ControllerListener2.a aVar) {
        int size = this.j.size();
        for (int i = 0; i < size; i++) {
            try {
                ControllerListener2<I> controllerListener2 = this.j.get(i);
                if (controllerListener2 != null) {
                    controllerListener2.c(str, aVar);
                }
            } catch (Exception e) {
                e("ForwardingControllerListener2 exception in onRelease", e);
            }
        }
    }

    @Override // b.f.h.b.a.ControllerListener2
    public void d(String str, I i, ControllerListener2.a aVar) {
        int size = this.j.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                ControllerListener2<I> controllerListener2 = this.j.get(i2);
                if (controllerListener2 != null) {
                    controllerListener2.d(str, i, aVar);
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
