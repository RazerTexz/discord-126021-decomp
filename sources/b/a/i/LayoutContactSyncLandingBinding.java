package b.a.i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.views.LoadingButton;

/* JADX INFO: renamed from: b.a.i.k0, reason: use source file name */
/* JADX INFO: compiled from: LayoutContactSyncLandingBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class LayoutContactSyncLandingBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f144b;

    @NonNull
    public final LoadingButton c;

    @NonNull
    public final View d;

    @NonNull
    public final LayoutContactSyncToggleInfoBinding e;

    public LayoutContactSyncLandingBinding(@NonNull ConstraintLayout constraintLayout, @NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull LoadingButton loadingButton, @NonNull View view, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull LayoutContactSyncToggleInfoBinding layoutContactSyncToggleInfoBinding) {
        this.a = constraintLayout;
        this.f144b = textView;
        this.c = loadingButton;
        this.d = view;
        this.e = layoutContactSyncToggleInfoBinding;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
