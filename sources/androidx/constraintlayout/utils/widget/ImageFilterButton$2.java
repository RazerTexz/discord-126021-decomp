package androidx.constraintlayout.utils.widget;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

/* JADX INFO: loaded from: classes.dex */
public class ImageFilterButton$2 extends ViewOutlineProvider {
    public final /* synthetic */ ImageFilterButton this$0;

    public ImageFilterButton$2(ImageFilterButton imageFilterButton) {
        this.this$0 = imageFilterButton;
    }

    @Override // android.view.ViewOutlineProvider
    public void getOutline(View view, Outline outline) {
        outline.setRoundRect(0, 0, this.this$0.getWidth(), this.this$0.getHeight(), ImageFilterButton.access$100(this.this$0));
    }
}
