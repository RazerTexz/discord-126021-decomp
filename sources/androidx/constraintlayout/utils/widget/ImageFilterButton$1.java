package androidx.constraintlayout.utils.widget;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

/* JADX INFO: loaded from: classes.dex */
public class ImageFilterButton$1 extends ViewOutlineProvider {
    public final /* synthetic */ ImageFilterButton this$0;

    public ImageFilterButton$1(ImageFilterButton imageFilterButton) {
        this.this$0 = imageFilterButton;
    }

    @Override // android.view.ViewOutlineProvider
    public void getOutline(View view, Outline outline) {
        int width = this.this$0.getWidth();
        int height = this.this$0.getHeight();
        outline.setRoundRect(0, 0, width, height, (ImageFilterButton.access$000(this.this$0) * Math.min(width, height)) / 2.0f);
    }
}
