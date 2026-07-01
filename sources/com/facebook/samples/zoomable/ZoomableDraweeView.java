package com.facebook.samples.zoomable;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector$SimpleOnGestureListener;
import android.view.MotionEvent;
import androidx.annotation.Nullable;
import androidx.core.view.ScrollingView;
import b.f.g.e.g;
import b.f.g.e.v;
import b.f.g.f.a;
import b.f.l.b.b;
import b.f.l.b.c;
import b.f.l.b.d;
import b.f.l.b.e;
import b.f.l.b.e$a;
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
    public e o;
    public GestureDetector p;
    public boolean q;
    public final ControllerListener r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final e$a f2905s;
    public final d t;

    public ZoomableDraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.k = false;
        this.l = new RectF();
        this.m = new RectF();
        this.q = true;
        this.r = new ZoomableDraweeView$a(this);
        ZoomableDraweeView$b zoomableDraweeView$b = new ZoomableDraweeView$b(this);
        this.f2905s = zoomableDraweeView$b;
        d dVar = new d();
        this.t = dVar;
        a aVar = new a(context.getResources());
        ScalingUtils$ScaleType scalingUtils$ScaleType = ScalingUtils$ScaleType.a;
        aVar.n = v.l;
        b.c.a.a0.d.l2(aVar, context, attributeSet);
        setAspectRatio(aVar.e);
        setHierarchy(aVar.a());
        b bVar = new b(new b.f.l.a.b(new b.f.l.a.a()));
        this.o = bVar;
        bVar.f651b = zoomableDraweeView$b;
        this.p = new GestureDetector(getContext(), dVar);
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
        g gVar = getHierarchy().f;
        Matrix matrix = g.j;
        gVar.n(matrix);
        rectF.set(gVar.getBounds());
        matrix.mapRect(rectF);
        this.m.set(0.0f, 0.0f, getWidth(), getHeight());
        e eVar = this.o;
        RectF rectF2 = this.l;
        c cVar = (c) eVar;
        if (!rectF2.equals(cVar.e)) {
            cVar.e.set(rectF2);
            cVar.i();
        }
        ((c) this.o).d.set(this.m);
        b.f.d.e.a.j(getLogTag(), "updateZoomableControllerBounds: view %x, view bounds: %s, image bounds: %s", Integer.valueOf(hashCode()), this.m, this.l);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollExtent() {
        return (int) ((c) this.o).d.width();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollOffset() {
        c cVar = (c) this.o;
        return (int) (cVar.d.left - cVar.f.left);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollRange() {
        return (int) ((c) this.o).f.width();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollExtent() {
        return (int) ((c) this.o).d.height();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollOffset() {
        c cVar = (c) this.o;
        return (int) (cVar.d.top - cVar.f.top);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollRange() {
        return (int) ((c) this.o).f.height();
    }

    public Class<?> getLogTag() {
        return j;
    }

    public e getZoomableController() {
        return this.o;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int iSave = canvas.save();
        canvas.concat(((c) this.o).h);
        super.onDraw(canvas);
        canvas.restoreToCount(iSave);
    }

    @Override // android.view.View
    public void onLayout(boolean z2, int i, int i2, int i3, int i4) {
        getLogTag();
        hashCode();
        int i5 = b.f.d.e.a.a;
        super.onLayout(z2, i, i2, i3, i4);
        b();
    }

    @Override // com.facebook.drawee.view.DraweeView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        motionEvent.getActionMasked();
        getLogTag();
        hashCode();
        int i = b.f.d.e.a.a;
        if (this.p.onTouchEvent(motionEvent)) {
            getLogTag();
            hashCode();
            return true;
        }
        if (this.k) {
            if (((c) this.o).h(motionEvent)) {
                return true;
            }
        } else if (((c) this.o).h(motionEvent)) {
            if ((!this.q && !this.o.a()) || (this.q && !((c) this.o).l)) {
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
        ((c) this.o).h(motionEventObtain);
        motionEventObtain.recycle();
        return false;
    }

    public void setAllowTouchInterceptionWhileZoomed(boolean z2) {
        this.q = z2;
    }

    @Override // com.facebook.drawee.view.DraweeView
    public void setController(@Nullable DraweeController draweeController) {
        a(null, null);
        ((c) this.o).k(false);
        a(draweeController, null);
    }

    public void setExperimentalSimpleTouchHandlingEnabled(boolean z2) {
        this.k = z2;
    }

    public void setIsLongpressEnabled(boolean z2) {
        this.p.setIsLongpressEnabled(z2);
    }

    public void setTapListener(@Nullable GestureDetector$SimpleOnGestureListener gestureDetector$SimpleOnGestureListener) {
        if (gestureDetector$SimpleOnGestureListener != null) {
            this.t.j = gestureDetector$SimpleOnGestureListener;
        } else {
            this.t.j = new GestureDetector$SimpleOnGestureListener();
        }
    }

    public void setZoomableController(e eVar) {
        Objects.requireNonNull(eVar);
        ((c) this.o).f651b = null;
        this.o = eVar;
        ((c) eVar).f651b = this.f2905s;
    }
}
