package b.a.i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: compiled from: ViewCodeVerificationTextBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class g2 implements ViewBinding {

    @NonNull
    public final TextView a;

    public g2(@NonNull TextView textView) {
        this.a = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
