package p007b.p225i.p226a.p341g.p347f;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.google.android.material.internal.ViewOverlayImpl;

/* JADX INFO: renamed from: b.i.a.g.f.b */
/* JADX INFO: compiled from: ViewOverlayApi18.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(18)
public class C4414b implements ViewOverlayImpl {

    /* JADX INFO: renamed from: a */
    public final ViewOverlay f11712a;

    public C4414b(@NonNull View view) {
        this.f11712a = view.getOverlay();
    }

    @Override // com.google.android.material.internal.ViewOverlayImpl
    public void add(@NonNull Drawable drawable) {
        this.f11712a.add(drawable);
    }

    @Override // com.google.android.material.internal.ViewOverlayImpl
    public void remove(@NonNull Drawable drawable) {
        this.f11712a.remove(drawable);
    }
}
