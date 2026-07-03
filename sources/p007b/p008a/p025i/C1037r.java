package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: renamed from: b.a.i.r */
/* JADX INFO: compiled from: GiftPurchasedDialogBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1037r implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f1165a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f1166b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final RelativeLayout f1167c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final MaterialButton f1168d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final LinkifiedTextView f1169e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final MaterialButton f1170f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final TextView f1171g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final ImageView f1172h;

    public C1037r(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull RelativeLayout relativeLayout, @NonNull MaterialButton materialButton, @NonNull LinkifiedTextView linkifiedTextView, @NonNull MaterialButton materialButton2, @NonNull TextView textView2, @NonNull ImageView imageView) {
        this.f1165a = linearLayout;
        this.f1166b = textView;
        this.f1167c = relativeLayout;
        this.f1168d = materialButton;
        this.f1169e = linkifiedTextView;
        this.f1170f = materialButton2;
        this.f1171g = textView2;
        this.f1172h = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1165a;
    }
}
