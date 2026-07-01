package b.o.a.u;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import b.d.b.a.outline;
import b.o.a.CameraLogger;
import b.o.a.u.Overlay;
import com.otaliastudios.cameraview.R;

/* JADX INFO: renamed from: b.o.a.u.c, reason: use source file name */
/* JADX INFO: compiled from: OverlayLayout.java */
/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"CustomViewStyleable"})
public class OverlayLayout extends FrameLayout implements Overlay {
    public static final String j;
    public static final CameraLogger k;

    @VisibleForTesting
    public Overlay.a l;
    public boolean m;

    /* JADX INFO: renamed from: b.o.a.u.c$a */
    /* JADX INFO: compiled from: OverlayLayout.java */
    public static class a extends FrameLayout.LayoutParams {
        public boolean a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f1954b;
        public boolean c;

        public a(@NonNull Context context, @NonNull AttributeSet attributeSet) {
            super(context, attributeSet);
            this.a = false;
            this.f1954b = false;
            this.c = false;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.c.CameraView_Layout);
            try {
                this.a = typedArrayObtainStyledAttributes.getBoolean(R.c.CameraView_Layout_layout_drawOnPreview, false);
                this.f1954b = typedArrayObtainStyledAttributes.getBoolean(R.c.CameraView_Layout_layout_drawOnPictureSnapshot, false);
                this.c = typedArrayObtainStyledAttributes.getBoolean(R.c.CameraView_Layout_layout_drawOnVideoSnapshot, false);
            } finally {
                typedArrayObtainStyledAttributes.recycle();
            }
        }

        @VisibleForTesting
        public boolean a(@NonNull Overlay.a aVar) {
            return (aVar == Overlay.a.PREVIEW && this.a) || (aVar == Overlay.a.VIDEO_SNAPSHOT && this.c) || (aVar == Overlay.a.PICTURE_SNAPSHOT && this.f1954b);
        }

        @NonNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            outline.k0(a.class, sb, "[drawOnPreview:");
            sb.append(this.a);
            sb.append(",drawOnPictureSnapshot:");
            sb.append(this.f1954b);
            sb.append(",drawOnVideoSnapshot:");
            return outline.O(sb, this.c, "]");
        }
    }

    static {
        String simpleName = OverlayLayout.class.getSimpleName();
        j = simpleName;
        k = new CameraLogger(simpleName);
    }

    public OverlayLayout(@NonNull Context context) {
        super(context);
        this.l = Overlay.a.PREVIEW;
        setWillNotDraw(false);
    }

    public void a(@NonNull Overlay.a aVar, @NonNull Canvas canvas) {
        synchronized (this) {
            this.l = aVar;
            int iOrdinal = aVar.ordinal();
            if (iOrdinal == 0) {
                super.draw(canvas);
            } else if (iOrdinal == 1 || iOrdinal == 2) {
                canvas.save();
                float width = canvas.getWidth() / getWidth();
                float height = canvas.getHeight() / getHeight();
                k.a(0, "draw", "target:", aVar, "canvas:", canvas.getWidth() + "x" + canvas.getHeight(), "view:", getWidth() + "x" + getHeight(), "widthScale:", Float.valueOf(width), "heightScale:", Float.valueOf(height), "hardwareCanvasMode:", Boolean.valueOf(this.m));
                canvas.scale(width, height);
                dispatchDraw(canvas);
                canvas.restore();
            }
        }
    }

    public boolean b(@NonNull Overlay.a aVar) {
        for (int i = 0; i < getChildCount(); i++) {
            if (((a) getChildAt(i).getLayoutParams()).a(aVar)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
        k.a(1, "normal draw called.");
        Overlay.a aVar = Overlay.a.PREVIEW;
        if (b(aVar)) {
            a(aVar, canvas);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j2) {
        a aVar = (a) view.getLayoutParams();
        if (aVar.a(this.l)) {
            k.a(0, "Performing drawing for view:", view.getClass().getSimpleName(), "target:", this.l, "params:", aVar);
            return super.drawChild(canvas, view, j2);
        }
        k.a(0, "Skipping drawing for view:", view.getClass().getSimpleName(), "target:", this.l, "params:", aVar);
        return false;
    }

    public boolean getHardwareCanvasEnabled() {
        return this.m;
    }

    public void setHardwareCanvasEnabled(boolean z2) {
        this.m = z2;
    }
}
