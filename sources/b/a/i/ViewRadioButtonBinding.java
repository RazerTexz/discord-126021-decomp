package b.a.i;

import android.view.View;
import android.widget.RadioButton;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: renamed from: b.a.i.d3, reason: use source file name */
/* JADX INFO: compiled from: ViewRadioButtonBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class ViewRadioButtonBinding implements ViewBinding {

    @NonNull
    public final RadioButton a;

    public ViewRadioButtonBinding(@NonNull RadioButton radioButton) {
        this.a = radioButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
