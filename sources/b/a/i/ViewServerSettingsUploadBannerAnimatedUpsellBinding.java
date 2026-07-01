package b.a.i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: renamed from: b.a.i.m3, reason: use source file name */
/* JADX INFO: compiled from: ViewServerSettingsUploadBannerAnimatedUpsellBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class ViewServerSettingsUploadBannerAnimatedUpsellBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final MaterialButton f160b;

    @NonNull
    public final LinearLayout c;

    @NonNull
    public final TextView d;

    public ViewServerSettingsUploadBannerAnimatedUpsellBinding(@NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton, @NonNull LinearLayout linearLayout2, @NonNull TextView textView) {
        this.a = linearLayout;
        this.f160b = materialButton;
        this.c = linearLayout2;
        this.d = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
