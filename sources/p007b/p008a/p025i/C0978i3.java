package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: renamed from: b.a.i.i3 */
/* JADX INFO: compiled from: ViewServerMemberCountBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0978i3 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f952a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ImageView f953b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f954c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final ImageView f955d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f956e;

    public C0978i3(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull ImageView imageView2, @NonNull TextView textView2) {
        this.f952a = linearLayout;
        this.f953b = imageView;
        this.f954c = textView;
        this.f955d = imageView2;
        this.f956e = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f952a;
    }
}
