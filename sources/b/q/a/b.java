package b.q.a;

import android.view.View;
import android.view.View$OnClickListener;
import android.view.ViewGroup;
import com.yalantis.ucrop.UCropActivity;
import com.yalantis.ucrop.view.GestureCropImageView;
import com.yalantis.ucrop.view.widget.AspectRatioTextView;
import java.util.Iterator;

/* JADX INFO: compiled from: UCropActivity.java */
/* JADX INFO: loaded from: classes3.dex */
public class b implements View$OnClickListener {
    public final /* synthetic */ UCropActivity j;

    public b(UCropActivity uCropActivity) {
        this.j = uCropActivity;
    }

    @Override // android.view.View$OnClickListener
    public void onClick(View view) {
        GestureCropImageView gestureCropImageView = this.j.w;
        AspectRatioTextView aspectRatioTextView = (AspectRatioTextView) ((ViewGroup) view).getChildAt(0);
        if (view.isSelected()) {
            if (aspectRatioTextView.m != 0.0f) {
                float f = aspectRatioTextView.o;
                float f2 = aspectRatioTextView.p;
                aspectRatioTextView.o = f2;
                aspectRatioTextView.p = f;
                aspectRatioTextView.m = f2 / f;
            }
            aspectRatioTextView.b();
        }
        gestureCropImageView.setTargetAspectRatio(aspectRatioTextView.m);
        this.j.w.setImageToWrapCropBounds(true);
        if (view.isSelected()) {
            return;
        }
        Iterator<ViewGroup> it = this.j.E.iterator();
        while (it.hasNext()) {
            ViewGroup next = it.next();
            next.setSelected(next == view);
        }
    }
}
