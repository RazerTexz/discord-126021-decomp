package b.a.i;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.StatusView;

/* JADX INFO: renamed from: b.a.i.b4, reason: use source file name */
/* JADX INFO: compiled from: ViewToolbarTitleBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class ViewToolbarTitleBinding implements ViewBinding {

    @NonNull
    public final View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f85b;

    @NonNull
    public final StatusView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final ImageView f;

    public ViewToolbarTitleBinding(@NonNull View view, @NonNull ImageView imageView, @NonNull StatusView statusView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ImageView imageView2) {
        this.a = view;
        this.f85b = imageView;
        this.c = statusView;
        this.d = textView;
        this.e = textView2;
        this.f = imageView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
