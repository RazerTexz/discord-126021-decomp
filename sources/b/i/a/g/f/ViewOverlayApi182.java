package b.i.a.g.f;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.google.android.material.internal.ViewOverlayImpl;

/* JADX INFO: renamed from: b.i.a.g.f.b, reason: use source file name */
/* JADX INFO: compiled from: ViewOverlayApi18.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(18)
public class ViewOverlayApi182 implements ViewOverlayImpl {
    public final ViewOverlay a;

    public ViewOverlayApi182(@NonNull View view) {
        this.a = view.getOverlay();
    }

    @Override // com.google.android.material.internal.ViewOverlayImpl
    public void add(@NonNull Drawable drawable) {
        this.a.add(drawable);
    }

    @Override // com.google.android.material.internal.ViewOverlayImpl
    public void remove(@NonNull Drawable drawable) {
        this.a.remove(drawable);
    }
}
