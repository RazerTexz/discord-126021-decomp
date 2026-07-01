package b.q.a;

import android.view.View;
import android.view.View$OnClickListener;
import com.yalantis.ucrop.UCropActivity;

/* JADX INFO: compiled from: UCropActivity.java */
/* JADX INFO: loaded from: classes3.dex */
public class e implements View$OnClickListener {
    public final /* synthetic */ UCropActivity j;

    public e(UCropActivity uCropActivity) {
        this.j = uCropActivity;
    }

    @Override // android.view.View$OnClickListener
    public void onClick(View view) {
        UCropActivity uCropActivity = this.j;
        uCropActivity.w.k(90);
        uCropActivity.w.setImageToWrapCropBounds(true);
    }
}
