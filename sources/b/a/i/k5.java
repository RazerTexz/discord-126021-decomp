package b.a.i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: compiled from: WidgetHomePanelCenterContentUnreadBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class k5 implements ViewBinding {

    @NonNull
    public final TextView a;

    public k5(@NonNull TextView textView, @NonNull TextView textView2) {
        this.a = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
