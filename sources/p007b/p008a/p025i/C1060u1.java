package p007b.p008a.p025i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: renamed from: b.a.i.u1 */
/* JADX INFO: compiled from: UserActionsDialogBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1060u1 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f1280a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final SimpleDraweeView f1281b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f1282c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f1283d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f1284e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final TextView f1285f;

    public C1060u1(@NonNull LinearLayout linearLayout, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4) {
        this.f1280a = linearLayout;
        this.f1281b = simpleDraweeView;
        this.f1282c = textView;
        this.f1283d = textView2;
        this.f1284e = textView3;
        this.f1285f = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1280a;
    }
}
