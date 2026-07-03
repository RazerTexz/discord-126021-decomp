package p007b.p008a.p025i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: renamed from: b.a.i.u4 */
/* JADX INFO: compiled from: WidgetChatInputGuardBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1063u4 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f1291a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaterialButton f1292b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final MaterialButton f1293c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f1294d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f1295e;

    public C1063u4(@NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f1291a = linearLayout;
        this.f1292b = materialButton;
        this.f1293c = materialButton2;
        this.f1294d = textView;
        this.f1295e = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1291a;
    }
}
