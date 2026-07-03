package p007b.p008a.p025i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: renamed from: b.a.i.x3 */
/* JADX INFO: compiled from: ViewStageChannelVisitCommunityBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1083x3 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f1377a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final SimpleDraweeView f1378b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f1379c;

    public C1083x3(@NonNull ConstraintLayout constraintLayout, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f1377a = constraintLayout;
        this.f1378b = simpleDraweeView;
        this.f1379c = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1377a;
    }
}
