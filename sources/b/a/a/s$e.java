package b.a.a;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: compiled from: WidgetEnableTwoFactorPasswordDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class s$e implements View$OnClickListener {
    public final /* synthetic */ s j;

    public s$e(s sVar) {
        this.j = sVar;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        FragmentActivity activity = this.j.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }
}
