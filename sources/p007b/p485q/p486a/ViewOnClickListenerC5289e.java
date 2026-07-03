package p007b.p485q.p486a;

import android.view.View;
import com.yalantis.ucrop.UCropActivity;

/* JADX INFO: renamed from: b.q.a.e */
/* JADX INFO: compiled from: UCropActivity.java */
/* JADX INFO: loaded from: classes3.dex */
public class ViewOnClickListenerC5289e implements View.OnClickListener {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ UCropActivity f14392j;

    public ViewOnClickListenerC5289e(UCropActivity uCropActivity) {
        this.f14392j = uCropActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        UCropActivity uCropActivity = this.f14392j;
        uCropActivity.f22194w.m7482k(90);
        uCropActivity.f22194w.setImageToWrapCropBounds(true);
    }
}
