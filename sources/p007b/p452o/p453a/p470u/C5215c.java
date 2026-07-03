package p007b.p452o.p453a.p470u;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.otaliastudios.cameraview.C11196R;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p452o.p453a.C5103b;
import p007b.p452o.p453a.p470u.InterfaceC5213a;

/* JADX INFO: renamed from: b.o.a.u.c */
/* JADX INFO: compiled from: OverlayLayout.java */
/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"CustomViewStyleable"})
public class C5215c extends FrameLayout implements InterfaceC5213a {

    /* JADX INFO: renamed from: j */
    public static final String f14154j;

    /* JADX INFO: renamed from: k */
    public static final C5103b f14155k;

    /* JADX INFO: renamed from: l */
    @VisibleForTesting
    public InterfaceC5213a.a f14156l;

    /* JADX INFO: renamed from: m */
    public boolean f14157m;

    /* JADX INFO: renamed from: b.o.a.u.c$a */
    /* JADX INFO: compiled from: OverlayLayout.java */
    public static class a extends FrameLayout.LayoutParams {

        /* JADX INFO: renamed from: a */
        public boolean f14158a;

        /* JADX INFO: renamed from: b */
        public boolean f14159b;

        /* JADX INFO: renamed from: c */
        public boolean f14160c;

        public a(@NonNull Context context, @NonNull AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f14158a = false;
            this.f14159b = false;
            this.f14160c = false;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11196R.c.CameraView_Layout);
            try {
                this.f14158a = typedArrayObtainStyledAttributes.getBoolean(C11196R.c.CameraView_Layout_layout_drawOnPreview, false);
                this.f14159b = typedArrayObtainStyledAttributes.getBoolean(C11196R.c.CameraView_Layout_layout_drawOnPictureSnapshot, false);
                this.f14160c = typedArrayObtainStyledAttributes.getBoolean(C11196R.c.CameraView_Layout_layout_drawOnVideoSnapshot, false);
            } finally {
                typedArrayObtainStyledAttributes.recycle();
            }
        }

        @VisibleForTesting
        /* JADX INFO: renamed from: a */
        public boolean m7415a(@NonNull InterfaceC5213a.a aVar) {
            return (aVar == InterfaceC5213a.a.PREVIEW && this.f14158a) || (aVar == InterfaceC5213a.a.VIDEO_SNAPSHOT && this.f14160c) || (aVar == InterfaceC5213a.a.PICTURE_SNAPSHOT && this.f14159b);
        }

        @NonNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            C1643a.m860k0(a.class, sb, "[drawOnPreview:");
            sb.append(this.f14158a);
            sb.append(",drawOnPictureSnapshot:");
            sb.append(this.f14159b);
            sb.append(",drawOnVideoSnapshot:");
            return C1643a.m827O(sb, this.f14160c, "]");
        }
    }

    static {
        String simpleName = C5215c.class.getSimpleName();
        f14154j = simpleName;
        f14155k = new C5103b(simpleName);
    }

    public C5215c(@NonNull Context context) {
        super(context);
        this.f14156l = InterfaceC5213a.a.PREVIEW;
        setWillNotDraw(false);
    }

    /* JADX INFO: renamed from: a */
    public void m7412a(@NonNull InterfaceC5213a.a aVar, @NonNull Canvas canvas) {
        synchronized (this) {
            this.f14156l = aVar;
            int iOrdinal = aVar.ordinal();
            if (iOrdinal == 0) {
                super.draw(canvas);
            } else if (iOrdinal == 1 || iOrdinal == 2) {
                canvas.save();
                float width = canvas.getWidth() / getWidth();
                float height = canvas.getHeight() / getHeight();
                f14155k.m7159a(0, "draw", "target:", aVar, "canvas:", canvas.getWidth() + "x" + canvas.getHeight(), "view:", getWidth() + "x" + getHeight(), "widthScale:", Float.valueOf(width), "heightScale:", Float.valueOf(height), "hardwareCanvasMode:", Boolean.valueOf(this.f14157m));
                canvas.scale(width, height);
                dispatchDraw(canvas);
                canvas.restore();
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public boolean m7413b(@NonNull InterfaceC5213a.a aVar) {
        for (int i = 0; i < getChildCount(); i++) {
            if (((a) getChildAt(i).getLayoutParams()).m7415a(aVar)) {
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
        f14155k.m7159a(1, "normal draw called.");
        InterfaceC5213a.a aVar = InterfaceC5213a.a.PREVIEW;
        if (m7413b(aVar)) {
            m7412a(aVar, canvas);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        a aVar = (a) view.getLayoutParams();
        if (aVar.m7415a(this.f14156l)) {
            f14155k.m7159a(0, "Performing drawing for view:", view.getClass().getSimpleName(), "target:", this.f14156l, "params:", aVar);
            return super.drawChild(canvas, view, j);
        }
        f14155k.m7159a(0, "Skipping drawing for view:", view.getClass().getSimpleName(), "target:", this.f14156l, "params:", aVar);
        return false;
    }

    public boolean getHardwareCanvasEnabled() {
        return this.f14157m;
    }

    public void setHardwareCanvasEnabled(boolean z2) {
        this.f14157m = z2;
    }
}
