package b.a.i;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: compiled from: ViewChatActionItemBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class b2 implements ViewBinding {

    @NonNull
    public final View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f83b;

    @NonNull
    public final TextView c;

    public b2(@NonNull View view, @NonNull ImageView imageView, @NonNull TextView textView) {
        this.a = view;
        this.f83b = imageView;
        this.c = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
