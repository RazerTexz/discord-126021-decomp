package b.a.i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: renamed from: b.a.i.k5, reason: use source file name */
/* JADX INFO: compiled from: WidgetHomePanelCenterContentUnreadBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetHomePanelCenterContentUnreadBinding implements ViewBinding {

    @NonNull
    public final TextView a;

    public WidgetHomePanelCenterContentUnreadBinding(@NonNull TextView textView, @NonNull TextView textView2) {
        this.a = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
