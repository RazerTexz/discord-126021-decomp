package androidx.constraintlayout.utils.widget;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

/* JADX INFO: loaded from: classes.dex */
public class ImageFilterView$2 extends ViewOutlineProvider {
    public final /* synthetic */ ImageFilterView this$0;

    public ImageFilterView$2(ImageFilterView imageFilterView) {
        this.this$0 = imageFilterView;
    }

    @Override // android.view.ViewOutlineProvider
    public void getOutline(View view, Outline outline) {
        outline.setRoundRect(0, 0, this.this$0.getWidth(), this.this$0.getHeight(), ImageFilterView.access$100(this.this$0));
    }
}
