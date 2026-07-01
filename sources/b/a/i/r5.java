package b.a.i;

import android.view.View;
import android.widget.RadioButton;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: compiled from: WidgetMemberVerificationMultipleChoiceRadioItemBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class r5 implements ViewBinding {

    @NonNull
    public final RadioButton a;

    public r5(@NonNull RadioButton radioButton) {
        this.a = radioButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
