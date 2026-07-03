package p007b.p485q.p486a;

import android.view.View;
import com.yalantis.ucrop.UCropActivity;
import com.yalantis.ucrop.view.GestureCropImageView;

/* JADX INFO: renamed from: b.q.a.d */
/* JADX INFO: compiled from: UCropActivity.java */
/* JADX INFO: loaded from: classes3.dex */
public class ViewOnClickListenerC5288d implements View.OnClickListener {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ UCropActivity f14391j;

    public ViewOnClickListenerC5288d(UCropActivity uCropActivity) {
        this.f14391j = uCropActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        UCropActivity uCropActivity = this.f14391j;
        GestureCropImageView gestureCropImageView = uCropActivity.f22194w;
        gestureCropImageView.m7482k(-gestureCropImageView.getCurrentAngle());
        uCropActivity.f22194w.setImageToWrapCropBounds(true);
    }
}
