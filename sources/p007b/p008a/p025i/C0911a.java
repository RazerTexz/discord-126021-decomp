package p007b.p008a.p025i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: renamed from: b.a.i.a */
/* JADX INFO: compiled from: AllowAccessibilityDetectionDialogBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0911a implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f654a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f655b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final MaterialButton f656c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final MaterialButton f657d;

    public C0911a(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2, @NonNull TextView textView2) {
        this.f654a = linearLayout;
        this.f655b = textView;
        this.f656c = materialButton;
        this.f657d = materialButton2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f654a;
    }
}
