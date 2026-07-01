package b.a.i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: compiled from: GifSearchEmptyStateTextBoxViewBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class q implements ViewBinding {

    @NonNull
    public final TextView a;

    public q(@NonNull TextView textView) {
        this.a = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
