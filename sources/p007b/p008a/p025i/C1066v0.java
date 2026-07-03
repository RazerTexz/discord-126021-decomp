package p007b.p008a.p025i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: renamed from: b.a.i.v0 */
/* JADX INFO: compiled from: MemberVerificationAvatarViewBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1066v0 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final View f1306a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final SimpleDraweeView f1307b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f1308c;

    public C1066v0(@NonNull View view, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView) {
        this.f1306a = view;
        this.f1307b = simpleDraweeView;
        this.f1308c = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1306a;
    }
}
