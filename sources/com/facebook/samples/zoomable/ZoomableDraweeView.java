package com.facebook.samples.zoomable;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.annotation.Nullable;
import androidx.core.view.ScrollingView;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.DraweeView;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p109f.p115d.p120e.C1691a;
import p007b.p109f.p132g.p139c.C1755c;
import p007b.p109f.p132g.p142e.C1772g;
import p007b.p109f.p132g.p142e.C1788v;
import p007b.p109f.p132g.p143f.C1793a;
import p007b.p109f.p187l.p188a.C2041a;
import p007b.p109f.p187l.p188a.C2042b;
import p007b.p109f.p187l.p189b.C2044b;
import p007b.p109f.p187l.p189b.C2045c;
import p007b.p109f.p187l.p189b.C2046d;
import p007b.p109f.p187l.p189b.InterfaceC2047e;

/* JADX INFO: loaded from: classes3.dex */
public class ZoomableDraweeView extends DraweeView<GenericDraweeHierarchy> implements ScrollingView {

    /* JADX INFO: renamed from: j */
    public static final Class<?> f19628j = ZoomableDraweeView.class;

    /* JADX INFO: renamed from: k */
    public boolean f19629k;

    /* JADX INFO: renamed from: l */
    public final RectF f19630l;

    /* JADX INFO: renamed from: m */
    public final RectF f19631m;

    /* JADX INFO: renamed from: n */
    public DraweeController f19632n;

    /* JADX INFO: renamed from: o */
    public InterfaceC2047e f19633o;

    /* JADX INFO: renamed from: p */
    public GestureDetector f19634p;

    /* JADX INFO: renamed from: q */
    public boolean f19635q;

    /* JADX INFO: renamed from: r */
    public final ControllerListener f19636r;

    /* JADX INFO: renamed from: s */
    public final InterfaceC2047e.a f19637s;

    /* JADX INFO: renamed from: t */
    public final C2046d f19638t;

    /* JADX INFO: renamed from: com.facebook.samples.zoomable.ZoomableDraweeView$a */
    public class C10671a extends C1755c<Object> {
        public C10671a() {
        }

        @Override // p007b.p109f.p132g.p139c.C1755c, com.facebook.drawee.controller.ControllerListener
        public void onFinalImageSet(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            ZoomableDraweeView zoomableDraweeView = ZoomableDraweeView.this;
            Class<?> cls = ZoomableDraweeView.f19628j;
            zoomableDraweeView.getLogTag();
            zoomableDraweeView.hashCode();
            int i = C1691a.f3102a;
            if (((C2045c) zoomableDraweeView.f19633o).f4301c) {
                return;
            }
            zoomableDraweeView.m8726b();
            ((C2045c) zoomableDraweeView.f19633o).m1564k(true);
        }

        @Override // p007b.p109f.p132g.p139c.C1755c, com.facebook.drawee.controller.ControllerListener
        public void onRelease(String str) {
            ZoomableDraweeView zoomableDraweeView = ZoomableDraweeView.this;
            Class<?> cls = ZoomableDraweeView.f19628j;
            zoomableDraweeView.getLogTag();
            zoomableDraweeView.hashCode();
            int i = C1691a.f3102a;
            ((C2045c) zoomableDraweeView.f19633o).m1564k(false);
        }
    }

    /* JADX INFO: renamed from: com.facebook.samples.zoomable.ZoomableDraweeView$b */
    public class C10672b implements InterfaceC2047e.a {
        public C10672b() {
        }
    }

    public ZoomableDraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19629k = false;
        this.f19630l = new RectF();
        this.f19631m = new RectF();
        this.f19635q = true;
        this.f19636r = new C10671a();
        C10672b c10672b = new C10672b();
        this.f19637s = c10672b;
        C2046d c2046d = new C2046d();
        this.f19638t = c2046d;
        C1793a c1793a = new C1793a(context.getResources());
        ScalingUtils$ScaleType scalingUtils$ScaleType = ScalingUtils$ScaleType.f19495a;
        c1793a.f3464n = C1788v.f3446l;
        C1460d.m542l2(c1793a, context, attributeSet);
        setAspectRatio(c1793a.f3455e);
        setHierarchy(c1793a.m1122a());
        C2044b c2044b = new C2044b(new C2042b(new C2041a()));
        this.f19633o = c2044b;
        c2044b.f4300b = c10672b;
        this.f19634p = new GestureDetector(getContext(), c2046d);
    }

    /* JADX INFO: renamed from: a */
    public final void m8725a(@Nullable DraweeController draweeController, @Nullable DraweeController draweeController2) {
        DraweeController controller = getController();
        if (controller instanceof AbstractDraweeController) {
            ((AbstractDraweeController) controller).m8647A(this.f19636r);
        }
        if (draweeController instanceof AbstractDraweeController) {
            ((AbstractDraweeController) draweeController).m8656f(this.f19636r);
        }
        this.f19632n = draweeController2;
        super.setController(draweeController);
    }

    /* JADX INFO: renamed from: b */
    public void m8726b() {
        RectF rectF = this.f19630l;
        C1772g c1772g = getHierarchy().f19511f;
        Matrix matrix = C1772g.f3359j;
        c1772g.m1103n(matrix);
        rectF.set(c1772g.getBounds());
        matrix.mapRect(rectF);
        this.f19631m.set(0.0f, 0.0f, getWidth(), getHeight());
        InterfaceC2047e interfaceC2047e = this.f19633o;
        RectF rectF2 = this.f19630l;
        C2045c c2045c = (C2045c) interfaceC2047e;
        if (!rectF2.equals(c2045c.f4303e)) {
            c2045c.f4303e.set(rectF2);
            c2045c.m1563i();
        }
        ((C2045c) this.f19633o).f4302d.set(this.f19631m);
        C1691a.m982j(getLogTag(), "updateZoomableControllerBounds: view %x, view bounds: %s, image bounds: %s", Integer.valueOf(hashCode()), this.f19631m, this.f19630l);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollExtent() {
        return (int) ((C2045c) this.f19633o).f4302d.width();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollOffset() {
        C2045c c2045c = (C2045c) this.f19633o;
        return (int) (c2045c.f4302d.left - c2045c.f4304f.left);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollRange() {
        return (int) ((C2045c) this.f19633o).f4304f.width();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollExtent() {
        return (int) ((C2045c) this.f19633o).f4302d.height();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollOffset() {
        C2045c c2045c = (C2045c) this.f19633o;
        return (int) (c2045c.f4302d.top - c2045c.f4304f.top);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollRange() {
        return (int) ((C2045c) this.f19633o).f4304f.height();
    }

    public Class<?> getLogTag() {
        return f19628j;
    }

    public InterfaceC2047e getZoomableController() {
        return this.f19633o;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int iSave = canvas.save();
        canvas.concat(((C2045c) this.f19633o).f4306h);
        super.onDraw(canvas);
        canvas.restoreToCount(iSave);
    }

    @Override // android.view.View
    public void onLayout(boolean z2, int i, int i2, int i3, int i4) {
        getLogTag();
        hashCode();
        int i5 = C1691a.f3102a;
        super.onLayout(z2, i, i2, i3, i4);
        m8726b();
    }

    @Override // com.facebook.drawee.view.DraweeView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        motionEvent.getActionMasked();
        getLogTag();
        hashCode();
        int i = C1691a.f3102a;
        if (this.f19634p.onTouchEvent(motionEvent)) {
            getLogTag();
            hashCode();
            return true;
        }
        if (this.f19629k) {
            if (((C2045c) this.f19633o).m1562h(motionEvent)) {
                return true;
            }
        } else if (((C2045c) this.f19633o).m1562h(motionEvent)) {
            if ((!this.f19635q && !this.f19633o.mo1551a()) || (this.f19635q && !((C2045c) this.f19633o).f4310l)) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            getLogTag();
            hashCode();
            return true;
        }
        if (super.onTouchEvent(motionEvent)) {
            getLogTag();
            hashCode();
            return true;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.setAction(3);
        this.f19634p.onTouchEvent(motionEventObtain);
        ((C2045c) this.f19633o).m1562h(motionEventObtain);
        motionEventObtain.recycle();
        return false;
    }

    public void setAllowTouchInterceptionWhileZoomed(boolean z2) {
        this.f19635q = z2;
    }

    @Override // com.facebook.drawee.view.DraweeView
    public void setController(@Nullable DraweeController draweeController) {
        m8725a(null, null);
        ((C2045c) this.f19633o).m1564k(false);
        m8725a(draweeController, null);
    }

    public void setExperimentalSimpleTouchHandlingEnabled(boolean z2) {
        this.f19629k = z2;
    }

    public void setIsLongpressEnabled(boolean z2) {
        this.f19634p.setIsLongpressEnabled(z2);
    }

    public void setTapListener(@Nullable GestureDetector.SimpleOnGestureListener simpleOnGestureListener) {
        if (simpleOnGestureListener != null) {
            this.f19638t.f4311j = simpleOnGestureListener;
        } else {
            this.f19638t.f4311j = new GestureDetector.SimpleOnGestureListener();
        }
    }

    public void setZoomableController(InterfaceC2047e interfaceC2047e) {
        Objects.requireNonNull(interfaceC2047e);
        ((C2045c) this.f19633o).f4300b = null;
        this.f19633o = interfaceC2047e;
        ((C2045c) interfaceC2047e).f4300b = this.f19637s;
    }
}
