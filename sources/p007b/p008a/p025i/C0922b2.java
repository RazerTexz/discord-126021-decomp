package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: renamed from: b.a.i.b2 */
/* JADX INFO: compiled from: ViewChatActionItemBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0922b2 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final View f702a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ImageView f703b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f704c;

    public C0922b2(@NonNull View view, @NonNull ImageView imageView, @NonNull TextView textView) {
        this.f702a = view;
        this.f703b = imageView;
        this.f704c = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f702a;
    }
}
