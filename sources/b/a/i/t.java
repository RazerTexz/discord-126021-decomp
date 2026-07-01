package b.a.i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.app.AppViewFlipper;
import com.discord.views.LoadingButton;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: compiled from: GuildBoostCancelDialogBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class t implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f201b;

    @NonNull
    public final LoadingButton c;

    @NonNull
    public final TextView d;

    @NonNull
    public final AppViewFlipper e;

    @NonNull
    public final TextView f;

    @NonNull
    public final MaterialButton g;

    public t(@NonNull LinearLayout linearLayout, @NonNull ProgressBar progressBar, @NonNull TextView textView, @NonNull LoadingButton loadingButton, @NonNull TextView textView2, @NonNull AppViewFlipper appViewFlipper, @NonNull TextView textView3, @NonNull MaterialButton materialButton, @NonNull LinearLayout linearLayout2) {
        this.a = linearLayout;
        this.f201b = textView;
        this.c = loadingButton;
        this.d = textView2;
        this.e = appViewFlipper;
        this.f = textView3;
        this.g = materialButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
