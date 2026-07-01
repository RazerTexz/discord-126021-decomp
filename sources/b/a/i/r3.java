package b.a.i;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;

/* JADX INFO: compiled from: ViewSettingSharedBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class r3 implements ViewBinding {

    @NonNull
    public final View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f192b;

    @NonNull
    public final TextView c;

    @NonNull
    public final LinkifiedTextView d;

    @NonNull
    public final TextView e;

    public r3(@NonNull View view, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull LinkifiedTextView linkifiedTextView, @NonNull TextView textView2) {
        this.a = view;
        this.f192b = imageView;
        this.c = textView;
        this.d = linkifiedTextView;
        this.e = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
