package b.a.i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: renamed from: b.a.i.q5, reason: use source file name */
/* JADX INFO: compiled from: WidgetMaskedLinksDialogBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetMaskedLinksDialogBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f188b;

    @NonNull
    public final MaterialButton c;

    @NonNull
    public final MaterialButton d;

    @NonNull
    public final TextView e;

    public WidgetMaskedLinksDialogBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.a = linearLayout;
        this.f188b = textView;
        this.c = materialButton;
        this.d = materialButton2;
        this.e = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
