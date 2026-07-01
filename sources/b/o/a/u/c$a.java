package b.o.a.u;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout$LayoutParams;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.otaliastudios.cameraview.R$c;

/* JADX INFO: compiled from: OverlayLayout.java */
/* JADX INFO: loaded from: classes3.dex */
public class c$a extends FrameLayout$LayoutParams {
    public boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1954b;
    public boolean c;

    public c$a(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = false;
        this.f1954b = false;
        this.c = false;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$c.CameraView_Layout);
        try {
            this.a = typedArrayObtainStyledAttributes.getBoolean(R$c.CameraView_Layout_layout_drawOnPreview, false);
            this.f1954b = typedArrayObtainStyledAttributes.getBoolean(R$c.CameraView_Layout_layout_drawOnPictureSnapshot, false);
            this.c = typedArrayObtainStyledAttributes.getBoolean(R$c.CameraView_Layout_layout_drawOnVideoSnapshot, false);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @VisibleForTesting
    public boolean a(@NonNull a$a a_a) {
        return (a_a == a$a.PREVIEW && this.a) || (a_a == a$a.VIDEO_SNAPSHOT && this.c) || (a_a == a$a.PICTURE_SNAPSHOT && this.f1954b);
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        b.d.b.a.a.k0(c$a.class, sb, "[drawOnPreview:");
        sb.append(this.a);
        sb.append(",drawOnPictureSnapshot:");
        sb.append(this.f1954b);
        sb.append(",drawOnVideoSnapshot:");
        return b.d.b.a.a.O(sb, this.c, "]");
    }
}
