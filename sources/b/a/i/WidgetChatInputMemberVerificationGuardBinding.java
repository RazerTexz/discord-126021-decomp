package b.a.i;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: renamed from: b.a.i.v4, reason: use source file name */
/* JADX INFO: compiled from: WidgetChatInputMemberVerificationGuardBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetChatInputMemberVerificationGuardBinding implements ViewBinding {

    @NonNull
    public final RelativeLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final CardView f218b;

    @NonNull
    public final ImageView c;

    @NonNull
    public final MaterialButton d;

    @NonNull
    public final ImageView e;

    @NonNull
    public final TextView f;

    public WidgetChatInputMemberVerificationGuardBinding(@NonNull RelativeLayout relativeLayout, @NonNull CardView cardView, @NonNull ImageView imageView, @NonNull MaterialButton materialButton, @NonNull ImageView imageView2, @NonNull TextView textView) {
        this.a = relativeLayout;
        this.f218b = cardView;
        this.c = imageView;
        this.d = materialButton;
        this.e = imageView2;
        this.f = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
