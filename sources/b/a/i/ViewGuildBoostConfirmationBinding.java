package b.a.i;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.chip.Chip;

/* JADX INFO: renamed from: b.a.i.l2, reason: use source file name */
/* JADX INFO: compiled from: ViewGuildBoostConfirmationBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class ViewGuildBoostConfirmationBinding implements ViewBinding {

    @NonNull
    public final View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final SimpleDraweeView f152b;

    @NonNull
    public final TextView c;

    @NonNull
    public final Chip d;

    @NonNull
    public final Chip e;

    @NonNull
    public final ImageView f;

    public ViewGuildBoostConfirmationBinding(@NonNull View view, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView, @NonNull Chip chip, @NonNull Chip chip2, @NonNull ImageView imageView) {
        this.a = view;
        this.f152b = simpleDraweeView;
        this.c = textView;
        this.d = chip;
        this.e = chip2;
        this.f = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
