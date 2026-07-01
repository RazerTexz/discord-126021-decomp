package b.o.a.u;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout$LayoutParams;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;

/* JADX INFO: compiled from: OverlayLayout.java */
/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"CustomViewStyleable"})
public class c extends FrameLayout implements a {
    public static final String j;
    public static final b.o.a.b k;

    @VisibleForTesting
    public a$a l;
    public boolean m;

    static {
        String simpleName = c.class.getSimpleName();
        j = simpleName;
        k = new b.o.a.b(simpleName);
    }

    public c(@NonNull Context context) {
        super(context);
        this.l = a$a.PREVIEW;
        setWillNotDraw(false);
    }

    public void a(@NonNull a$a a_a, @NonNull Canvas canvas) {
        synchronized (this) {
            this.l = a_a;
            int iOrdinal = a_a.ordinal();
            if (iOrdinal == 0) {
                super.draw(canvas);
            } else if (iOrdinal == 1 || iOrdinal == 2) {
                canvas.save();
                float width = canvas.getWidth() / getWidth();
                float height = canvas.getHeight() / getHeight();
                k.a(0, "draw", "target:", a_a, "canvas:", canvas.getWidth() + "x" + canvas.getHeight(), "view:", getWidth() + "x" + getHeight(), "widthScale:", Float.valueOf(width), "heightScale:", Float.valueOf(height), "hardwareCanvasMode:", Boolean.valueOf(this.m));
                canvas.scale(width, height);
                dispatchDraw(canvas);
                canvas.restore();
            }
        }
    }

    public boolean b(@NonNull a$a a_a) {
        for (int i = 0; i < getChildCount(); i++) {
            if (((c$a) getChildAt(i).getLayoutParams()).a(a_a)) {
                return true;
            }
        }
        return false;
    }

    public c$a c(AttributeSet attributeSet) {
        return new c$a(getContext(), attributeSet);
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
        k.a(1, "normal draw called.");
        a$a a_a = a$a.PREVIEW;
        if (b(a_a)) {
            a(a_a, canvas);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j2) {
        c$a c_a = (c$a) view.getLayoutParams();
        if (c_a.a(this.l)) {
            k.a(0, "Performing drawing for view:", view.getClass().getSimpleName(), "target:", this.l, "params:", c_a);
            return super.drawChild(canvas, view, j2);
        }
        k.a(0, "Skipping drawing for view:", view.getClass().getSimpleName(), "target:", this.l, "params:", c_a);
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup$LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return c(attributeSet);
    }

    public boolean getHardwareCanvasEnabled() {
        return this.m;
    }

    public void setHardwareCanvasEnabled(boolean z2) {
        this.m = z2;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ FrameLayout$LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return c(attributeSet);
    }
}
