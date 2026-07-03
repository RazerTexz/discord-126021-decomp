package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.StatusView;

/* JADX INFO: renamed from: b.a.i.b4 */
/* JADX INFO: compiled from: ViewToolbarTitleBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0924b4 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final View f707a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ImageView f708b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final StatusView f709c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f710d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f711e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final ImageView f712f;

    public C0924b4(@NonNull View view, @NonNull ImageView imageView, @NonNull StatusView statusView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ImageView imageView2) {
        this.f707a = view;
        this.f708b = imageView;
        this.f709c = statusView;
        this.f710d = textView;
        this.f711e = textView2;
        this.f712f = imageView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f707a;
    }
}
