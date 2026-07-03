package p007b.p109f.p132g.p139c;

import android.graphics.drawable.Animatable;
import android.util.Log;
import com.facebook.drawee.controller.ControllerListener;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: b.f.g.c.d */
/* JADX INFO: compiled from: ForwardingControllerListener.java */
/* JADX INFO: loaded from: classes.dex */
public class C1756d<INFO> implements ControllerListener<INFO> {

    /* JADX INFO: renamed from: a */
    public final List<ControllerListener<? super INFO>> f3298a = new ArrayList(2);

    /* JADX INFO: renamed from: a */
    public synchronized void m1085a(ControllerListener<? super INFO> controllerListener) {
        this.f3298a.add(controllerListener);
    }

    /* JADX INFO: renamed from: b */
    public final synchronized void m1086b(String str, Throwable th) {
        Log.e("FdingControllerListener", str, th);
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public synchronized void onFailure(String str, Throwable th) {
        int size = this.f3298a.size();
        for (int i = 0; i < size; i++) {
            try {
                ControllerListener<? super INFO> controllerListener = this.f3298a.get(i);
                if (controllerListener != null) {
                    controllerListener.onFailure(str, th);
                }
            } catch (Exception e) {
                m1086b("InternalListener exception in onFailure", e);
            }
        }
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public synchronized void onFinalImageSet(String str, INFO info, Animatable animatable) {
        int size = this.f3298a.size();
        for (int i = 0; i < size; i++) {
            try {
                ControllerListener<? super INFO> controllerListener = this.f3298a.get(i);
                if (controllerListener != null) {
                    controllerListener.onFinalImageSet(str, info, animatable);
                }
            } catch (Exception e) {
                m1086b("InternalListener exception in onFinalImageSet", e);
            }
        }
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public void onIntermediateImageFailed(String str, Throwable th) {
        int size = this.f3298a.size();
        for (int i = 0; i < size; i++) {
            try {
                ControllerListener<? super INFO> controllerListener = this.f3298a.get(i);
                if (controllerListener != null) {
                    controllerListener.onIntermediateImageFailed(str, th);
                }
            } catch (Exception e) {
                m1086b("InternalListener exception in onIntermediateImageFailed", e);
            }
        }
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public void onIntermediateImageSet(String str, INFO info) {
        int size = this.f3298a.size();
        for (int i = 0; i < size; i++) {
            try {
                ControllerListener<? super INFO> controllerListener = this.f3298a.get(i);
                if (controllerListener != null) {
                    controllerListener.onIntermediateImageSet(str, info);
                }
            } catch (Exception e) {
                m1086b("InternalListener exception in onIntermediateImageSet", e);
            }
        }
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public synchronized void onRelease(String str) {
        int size = this.f3298a.size();
        for (int i = 0; i < size; i++) {
            try {
                ControllerListener<? super INFO> controllerListener = this.f3298a.get(i);
                if (controllerListener != null) {
                    controllerListener.onRelease(str);
                }
            } catch (Exception e) {
                m1086b("InternalListener exception in onRelease", e);
            }
        }
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public synchronized void onSubmit(String str, Object obj) {
        int size = this.f3298a.size();
        for (int i = 0; i < size; i++) {
            try {
                ControllerListener<? super INFO> controllerListener = this.f3298a.get(i);
                if (controllerListener != null) {
                    controllerListener.onSubmit(str, obj);
                }
            } catch (Exception e) {
                m1086b("InternalListener exception in onSubmit", e);
            }
        }
    }
}
