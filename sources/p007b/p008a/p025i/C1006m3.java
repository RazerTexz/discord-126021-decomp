package p007b.p008a.p025i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: renamed from: b.a.i.m3 */
/* JADX INFO: compiled from: ViewServerSettingsUploadBannerAnimatedUpsellBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1006m3 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f1049a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaterialButton f1050b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final LinearLayout f1051c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f1052d;

    public C1006m3(@NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton, @NonNull LinearLayout linearLayout2, @NonNull TextView textView) {
        this.f1049a = linearLayout;
        this.f1050b = materialButton;
        this.f1051c = linearLayout2;
        this.f1052d = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1049a;
    }
}
