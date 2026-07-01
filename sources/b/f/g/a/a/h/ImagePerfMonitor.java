package b.f.g.a.a.h;

import android.graphics.Rect;
import b.f.d.d.Suppliers2;
import b.f.d.k.MonotonicClock;
import b.f.g.a.a.PipelineDraweeController;
import b.f.g.a.a.h.i.ImagePerfControllerListener2;
import b.f.g.a.a.h.i.ImagePerfImageOriginListener;
import b.f.g.a.a.h.i.ImagePerfRequestListener;
import b.f.g.h.SettableDraweeHierarchy;
import b.f.h.b.a.ForwardingControllerListener2;
import b.f.j.k.ForwardingRequestListener;
import com.facebook.common.internal.Supplier;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: b.f.g.a.a.h.f, reason: use source file name */
/* JADX INFO: compiled from: ImagePerfMonitor.java */
/* JADX INFO: loaded from: classes.dex */
public class ImagePerfMonitor implements ImagePerfNotifier {
    public final PipelineDraweeController a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MonotonicClock f485b;
    public final ImagePerfState c = new ImagePerfState();
    public final Supplier<Boolean> d;
    public ImageOriginRequestListener e;
    public ImageOriginListener f;
    public ImagePerfRequestListener g;
    public ImagePerfControllerListener2 h;
    public ForwardingRequestListener i;
    public List<ImagePerfDataListener> j;
    public boolean k;

    public ImagePerfMonitor(MonotonicClock monotonicClock, PipelineDraweeController pipelineDraweeController, Supplier<Boolean> supplier) {
        this.f485b = monotonicClock;
        this.a = pipelineDraweeController;
        this.d = supplier;
    }

    public void a(ImagePerfState imagePerfState, int i) {
        List<ImagePerfDataListener> list;
        if (!this.k || (list = this.j) == null || list.isEmpty()) {
            return;
        }
        ImagePerfData imagePerfDataC = imagePerfState.c();
        Iterator<ImagePerfDataListener> it = this.j.iterator();
        while (it.hasNext()) {
            it.next().b(imagePerfDataC, i);
        }
    }

    public void b(ImagePerfState imagePerfState, int i) {
        List<ImagePerfDataListener> list;
        SettableDraweeHierarchy settableDraweeHierarchy;
        imagePerfState.v = i;
        if (!this.k || (list = this.j) == null || list.isEmpty()) {
            return;
        }
        if (i == 3 && (settableDraweeHierarchy = this.a.k) != null && settableDraweeHierarchy.e() != null) {
            Rect bounds = settableDraweeHierarchy.e().getBounds();
            this.c.f487s = bounds.width();
            this.c.t = bounds.height();
        }
        ImagePerfData imagePerfDataC = imagePerfState.c();
        Iterator<ImagePerfDataListener> it = this.j.iterator();
        while (it.hasNext()) {
            it.next().a(imagePerfDataC, i);
        }
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public void c(boolean z2) {
        this.k = z2;
        if (!z2) {
            ImageOriginListener imageOriginListener = this.f;
            if (imageOriginListener != null) {
                PipelineDraweeController pipelineDraweeController = this.a;
                synchronized (pipelineDraweeController) {
                    ImageOriginListener imageOriginListener2 = pipelineDraweeController.G;
                    if (imageOriginListener2 instanceof ForwardingImageOriginListener) {
                        ForwardingImageOriginListener forwardingImageOriginListener = (ForwardingImageOriginListener) imageOriginListener2;
                        synchronized (forwardingImageOriginListener) {
                            forwardingImageOriginListener.a.remove(imageOriginListener);
                        }
                    } else if (imageOriginListener2 == imageOriginListener) {
                        pipelineDraweeController.G = null;
                    }
                }
            }
            ImagePerfControllerListener2 imagePerfControllerListener2 = this.h;
            if (imagePerfControllerListener2 != null) {
                ForwardingControllerListener2<INFO> forwardingControllerListener2 = this.a.j;
                synchronized (forwardingControllerListener2) {
                    int iIndexOf = forwardingControllerListener2.j.indexOf(imagePerfControllerListener2);
                    if (iIndexOf != -1) {
                        forwardingControllerListener2.j.remove(iIndexOf);
                    }
                }
            }
            ForwardingRequestListener forwardingRequestListener = this.i;
            if (forwardingRequestListener != null) {
                this.a.L(forwardingRequestListener);
                return;
            }
            return;
        }
        if (this.h == null) {
            this.h = new ImagePerfControllerListener2(this.f485b, this.c, this, this.d, Suppliers2.a);
        }
        if (this.g == null) {
            this.g = new ImagePerfRequestListener(this.f485b, this.c);
        }
        if (this.f == null) {
            this.f = new ImagePerfImageOriginListener(this.c, this);
        }
        ImageOriginRequestListener imageOriginRequestListener = this.e;
        if (imageOriginRequestListener == null) {
            this.e = new ImageOriginRequestListener(this.a.m, this.f);
        } else {
            imageOriginRequestListener.a = this.a.m;
        }
        if (this.i == null) {
            this.i = new ForwardingRequestListener(this.g, this.e);
        }
        ImageOriginListener imageOriginListener3 = this.f;
        if (imageOriginListener3 != null) {
            this.a.F(imageOriginListener3);
        }
        ImagePerfControllerListener2 imagePerfControllerListener3 = this.h;
        if (imagePerfControllerListener3 != null) {
            ForwardingControllerListener2<INFO> forwardingControllerListener3 = this.a.j;
            synchronized (forwardingControllerListener3) {
                forwardingControllerListener3.j.add(imagePerfControllerListener3);
            }
        }
        ForwardingRequestListener forwardingRequestListener2 = this.i;
        if (forwardingRequestListener2 != null) {
            this.a.G(forwardingRequestListener2);
        }
    }
}
