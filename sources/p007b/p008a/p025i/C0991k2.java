package p007b.p008a.p025i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: renamed from: b.a.i.k2 */
/* JADX INFO: compiled from: ViewGuildBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0991k2 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final View f998a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final SimpleDraweeView f999b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f1000c;

    public C0991k2(@NonNull View view, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView) {
        this.f998a = view;
        this.f999b = simpleDraweeView;
        this.f1000c = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f998a;
    }
}
