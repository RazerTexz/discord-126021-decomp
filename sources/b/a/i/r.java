package b.a.i;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: compiled from: GiftPurchasedDialogBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class r implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f189b;

    @NonNull
    public final RelativeLayout c;

    @NonNull
    public final MaterialButton d;

    @NonNull
    public final LinkifiedTextView e;

    @NonNull
    public final MaterialButton f;

    @NonNull
    public final TextView g;

    @NonNull
    public final ImageView h;

    public r(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull RelativeLayout relativeLayout, @NonNull MaterialButton materialButton, @NonNull LinkifiedTextView linkifiedTextView, @NonNull MaterialButton materialButton2, @NonNull TextView textView2, @NonNull ImageView imageView) {
        this.a = linearLayout;
        this.f189b = textView;
        this.c = relativeLayout;
        this.d = materialButton;
        this.e = linkifiedTextView;
        this.f = materialButton2;
        this.g = textView2;
        this.h = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
