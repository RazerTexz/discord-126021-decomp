package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.chip.Chip;

/* JADX INFO: renamed from: b.a.i.l2 */
/* JADX INFO: compiled from: ViewGuildBoostConfirmationBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0998l2 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final View f1019a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final SimpleDraweeView f1020b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f1021c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final Chip f1022d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final Chip f1023e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final ImageView f1024f;

    public C0998l2(@NonNull View view, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView, @NonNull Chip chip, @NonNull Chip chip2, @NonNull ImageView imageView) {
        this.f1019a = view;
        this.f1020b = simpleDraweeView;
        this.f1021c = textView;
        this.f1022d = chip;
        this.f1023e = chip2;
        this.f1024f = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1019a;
    }
}
