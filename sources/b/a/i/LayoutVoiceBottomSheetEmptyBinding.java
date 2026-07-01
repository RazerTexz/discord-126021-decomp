package b.a.i;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: renamed from: b.a.i.t0, reason: use source file name */
/* JADX INFO: compiled from: LayoutVoiceBottomSheetEmptyBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class LayoutVoiceBottomSheetEmptyBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    public LayoutVoiceBottomSheetEmptyBinding(@NonNull LinearLayout linearLayout) {
        this.a = linearLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
