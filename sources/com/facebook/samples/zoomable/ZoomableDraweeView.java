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
import b.c.a.a0.AnimatableValueParser;
import b.f.d.e.FLog;
import b.f.g.c.BaseControllerListener;
import b.f.g.e.ForwardingDrawable;
import b.f.g.e.v;
import b.f.g.f.GenericDraweeHierarchyBuilder;
import b.f.l.a.MultiPointerGestureDetector;
import b.f.l.a.TransformGestureDetector;
import b.f.l.b.AnimatedZoomableController;
import b.f.l.b.DefaultZoomableController;
import b.f.l.b.GestureListenerWrapper;
import b.f.l.b.ZoomableController;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.DraweeView;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class ZoomableDraweeView extends DraweeView<GenericDraweeHierarchy> implements ScrollingView {
    public static final Class<?> j = ZoomableDraweeView.class;
    public boolean k;
    public final RectF l;
    public final RectF m;
    public DraweeController n;
    public ZoomableController o;
    public GestureDetector p;
    public boolean q;
    public final ControllerListener r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final ZoomableController.a f2905s;
    public final GestureListenerWrapper t;

    public class a extends BaseControllerListener<Object> {
        public a() {
        }

        @Override // b.f.g.c.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public void onFinalImageSet(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            ZoomableDraweeView zoomableDraweeView = ZoomableDraweeView.this;
            Class<?> cls = ZoomableDraweeView.j;
            zoomableDraweeView.getLogTag();
            zoomableDraweeView.hashCode();
            int i = FLog.a;
            if (((DefaultZoomableController) zoomableDraweeView.o).c) {
                return;
            }
            zoomableDraweeView.b();
            ((DefaultZoomableController) zoomableDraweeView.o).k(true);
        }

        @Override // b.f.g.c.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public void onRelease(String str) {
            ZoomableDraweeView zoomableDraweeView = ZoomableDraweeView.this;
            Class<?> cls = ZoomableDraweeView.j;
            zoomableDraweeView.getLogTag();
            zoomableDraweeView.hashCode();
            int i = FLog.a;
            ((DefaultZoomableController) zoomableDraweeView.o).k(false);
        }
    }

    public class b implements ZoomableController.a {
        public b() {
        }
    }

    public ZoomableDraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.k = false;
        this.l = new RectF();
        this.m = new RectF();
        this.q = true;
        this.r = new a();
        b bVar = new b();
        this.f2905s = bVar;
        GestureListenerWrapper gestureListenerWrapper = new GestureListenerWrapper();
        this.t = gestureListenerWrapper;
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(context.getResources());
        ScalingUtils$ScaleType scalingUtils$ScaleType = ScalingUtils$ScaleType.a;
        genericDraweeHierarchyBuilder.n = v.l;
        AnimatableValueParser.l2(genericDraweeHierarchyBuilder, context, attributeSet);
        setAspectRatio(genericDraweeHierarchyBuilder.e);
        setHierarchy(genericDraweeHierarchyBuilder.a());
        AnimatedZoomableController animatedZoomableController = new AnimatedZoomableController(new TransformGestureDetector(new MultiPointerGestureDetector()));
        this.o = animatedZoomableController;
        animatedZoomableController.f651b = bVar;
        this.p = new GestureDetector(getContext(), gestureListenerWrapper);
    }

    public final void a(@Nullable DraweeController draweeController, @Nullable DraweeController draweeController2) {
        DraweeController controller = getController();
        if (controller instanceof AbstractDraweeController) {
            ((AbstractDraweeController) controller).A(this.r);
        }
        if (draweeController instanceof AbstractDraweeController) {
            ((AbstractDraweeController) draweeController).f(this.r);
        }
        this.n = draweeController2;
        super.setController(draweeController);
    }

    public void b() {
        RectF rectF = this.l;
        ForwardingDrawable forwardingDrawable = getHierarchy().f;
        Matrix matrix = ForwardingDrawable.j;
        forwardingDrawable.n(matrix);
        rectF.set(forwardingDrawable.getBounds());
        matrix.mapRect(rectF);
        this.m.set(0.0f, 0.0f, getWidth(), getHeight());
        ZoomableController zoomableController = this.o;
        RectF rectF2 = this.l;
        DefaultZoomableController defaultZoomableController = (DefaultZoomableController) zoomableController;
        if (!rectF2.equals(defaultZoomableController.e)) {
            defaultZoomableController.e.set(rectF2);
            defaultZoomableController.i();
        }
        ((DefaultZoomableController) this.o).d.set(this.m);
        FLog.j(getLogTag(), "updateZoomableControllerBounds: view %x, view bounds: %s, image bounds: %s", Integer.valueOf(hashCode()), this.m, this.l);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollExtent() {
        return (int) ((DefaultZoomableController) this.o).d.width();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollOffset() {
        DefaultZoomableController defaultZoomableController = (DefaultZoomableController) this.o;
        return (int) (defaultZoomableController.d.left - defaultZoomableController.f.left);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollRange() {
        return (int) ((DefaultZoomableController) this.o).f.width();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollExtent() {
        return (int) ((DefaultZoomableController) this.o).d.height();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollOffset() {
        DefaultZoomableController defaultZoomableController = (DefaultZoomableController) this.o;
        return (int) (defaultZoomableController.d.top - defaultZoomableController.f.top);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollRange() {
        return (int) ((DefaultZoomableController) this.o).f.height();
    }

    public Class<?> getLogTag() {
        return j;
    }

    public ZoomableController getZoomableController() {
        return this.o;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int iSave = canvas.save();
        canvas.concat(((DefaultZoomableController) this.o).h);
        super.onDraw(canvas);
        canvas.restoreToCount(iSave);
    }

    @Override // android.view.View
    public void onLayout(boolean z2, int i, int i2, int i3, int i4) {
        getLogTag();
        hashCode();
        int i5 = FLog.a;
        super.onLayout(z2, i, i2, i3, i4);
        b();
    }

    @Override // com.facebook.drawee.view.DraweeView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        motionEvent.getActionMasked();
        getLogTag();
        hashCode();
        int i = FLog.a;
        if (this.p.onTouchEvent(motionEvent)) {
            getLogTag();
            hashCode();
            return true;
        }
        if (this.k) {
            if (((DefaultZoomableController) this.o).h(motionEvent)) {
                return true;
            }
        } else if (((DefaultZoomableController) this.o).h(motionEvent)) {
            if ((!this.q && !this.o.a()) || (this.q && !((DefaultZoomableController) this.o).l)) {
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
        this.p.onTouchEvent(motionEventObtain);
        ((DefaultZoomableController) this.o).h(motionEventObtain);
        motionEventObtain.recycle();
        return false;
    }

    public void setAllowTouchInterceptionWhileZoomed(boolean z2) {
        this.q = z2;
    }

    @Override // com.facebook.drawee.view.DraweeView
    public void setController(@Nullable DraweeController draweeController) {
        a(null, null);
        ((DefaultZoomableController) this.o).k(false);
        a(draweeController, null);
    }

    public void setExperimentalSimpleTouchHandlingEnabled(boolean z2) {
        this.k = z2;
    }

    public void setIsLongpressEnabled(boolean z2) {
        this.p.setIsLongpressEnabled(z2);
    }

    public void setTapListener(@Nullable GestureDetector.SimpleOnGestureListener simpleOnGestureListener) {
        if (simpleOnGestureListener != null) {
            this.t.j = simpleOnGestureListener;
        } else {
            this.t.j = new GestureDetector.SimpleOnGestureListener();
        }
    }

    public void setZoomableController(ZoomableController zoomableController) {
        Objects.requireNonNull(zoomableController);
        ((DefaultZoomableController) this.o).f651b = null;
        this.o = zoomableController;
        ((DefaultZoomableController) zoomableController).f651b = this.f2905s;
    }
}
