package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: renamed from: b.a.i.v4 */
/* JADX INFO: compiled from: WidgetChatInputMemberVerificationGuardBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1070v4 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final RelativeLayout f1320a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final CardView f1321b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final ImageView f1322c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final MaterialButton f1323d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final ImageView f1324e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final TextView f1325f;

    public C1070v4(@NonNull RelativeLayout relativeLayout, @NonNull CardView cardView, @NonNull ImageView imageView, @NonNull MaterialButton materialButton, @NonNull ImageView imageView2, @NonNull TextView textView) {
        this.f1320a = relativeLayout;
        this.f1321b = cardView;
        this.f1322c = imageView;
        this.f1323d = materialButton;
        this.f1324e = imageView2;
        this.f1325f = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1320a;
    }
}
