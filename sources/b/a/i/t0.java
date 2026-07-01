package b.a.i;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: compiled from: LayoutVoiceBottomSheetEmptyBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class t0 implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    public t0(@NonNull LinearLayout linearLayout) {
        this.a = linearLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
