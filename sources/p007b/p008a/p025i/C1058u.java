package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.app.AppViewFlipper;
import com.discord.views.LoadingButton;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: renamed from: b.a.i.u */
/* JADX INFO: compiled from: GuildBoostUncancelDialogBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1058u implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f1265a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f1266b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final LoadingButton f1267c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f1268d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final AppViewFlipper f1269e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final TextView f1270f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final ImageView f1271g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final MaterialButton f1272h;

    public C1058u(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull LoadingButton loadingButton, @NonNull TextView textView2, @NonNull AppViewFlipper appViewFlipper, @NonNull TextView textView3, @NonNull ImageView imageView, @NonNull MaterialButton materialButton, @NonNull LinearLayout linearLayout2) {
        this.f1265a = linearLayout;
        this.f1266b = textView;
        this.f1267c = loadingButton;
        this.f1268d = textView2;
        this.f1269e = appViewFlipper;
        this.f1270f = textView3;
        this.f1271g = imageView;
        this.f1272h = materialButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1265a;
    }
}
