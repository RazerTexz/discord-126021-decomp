package p007b.p008a.p025i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: renamed from: b.a.i.r4 */
/* JADX INFO: compiled from: WidgetChannelSettingsCannotDeleteBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1042r4 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f1186a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f1187b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final MaterialButton f1188c;

    public C1042r4(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull MaterialButton materialButton, @NonNull TextView textView2) {
        this.f1186a = linearLayout;
        this.f1187b = textView;
        this.f1188c = materialButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1186a;
    }
}
