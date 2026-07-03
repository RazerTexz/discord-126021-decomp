package p007b.p008a.p025i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: renamed from: b.a.i.j4 */
/* JADX INFO: compiled from: ViewVoiceUserBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0986j4 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final View f979a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final SimpleDraweeView f980b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f981c;

    public C0986j4(@NonNull View view, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView) {
        this.f979a = view;
        this.f980b = simpleDraweeView;
        this.f981c = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f979a;
    }
}
