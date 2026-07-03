package p007b.p485q.p486a;

import android.view.View;
import android.view.ViewGroup;
import com.yalantis.ucrop.UCropActivity;
import com.yalantis.ucrop.view.GestureCropImageView;
import com.yalantis.ucrop.view.widget.AspectRatioTextView;
import java.util.Iterator;

/* JADX INFO: renamed from: b.q.a.b */
/* JADX INFO: compiled from: UCropActivity.java */
/* JADX INFO: loaded from: classes3.dex */
public class ViewOnClickListenerC5286b implements View.OnClickListener {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ UCropActivity f14389j;

    public ViewOnClickListenerC5286b(UCropActivity uCropActivity) {
        this.f14389j = uCropActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        GestureCropImageView gestureCropImageView = this.f14389j.f22194w;
        AspectRatioTextView aspectRatioTextView = (AspectRatioTextView) ((ViewGroup) view).getChildAt(0);
        if (view.isSelected()) {
            if (aspectRatioTextView.f22246m != 0.0f) {
                float f = aspectRatioTextView.f22248o;
                float f2 = aspectRatioTextView.f22249p;
                aspectRatioTextView.f22248o = f2;
                aspectRatioTextView.f22249p = f;
                aspectRatioTextView.f22246m = f2 / f;
            }
            aspectRatioTextView.m9326b();
        }
        gestureCropImageView.setTargetAspectRatio(aspectRatioTextView.f22246m);
        this.f14389j.f22194w.setImageToWrapCropBounds(true);
        if (view.isSelected()) {
            return;
        }
        Iterator<ViewGroup> it = this.f14389j.f22172E.iterator();
        while (it.hasNext()) {
            ViewGroup next = it.next();
            next.setSelected(next == view);
        }
    }
}
