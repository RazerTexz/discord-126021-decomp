package p007b.p008a.p025i;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.CheckableImageView;

/* JADX INFO: renamed from: b.a.i.a4 */
/* JADX INFO: compiled from: ViewTernaryCheckboxBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0916a4 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f670a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final FrameLayout f671b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final View f672c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final View f673d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f674e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final LinkifiedTextView f675f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final CheckableImageView f676g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final CheckableImageView f677h;

    /* JADX INFO: renamed from: i */
    @NonNull
    public final CheckableImageView f678i;

    public C0916a4(@NonNull LinearLayout linearLayout, @NonNull FrameLayout frameLayout, @NonNull LinearLayout linearLayout2, @NonNull View view, @NonNull View view2, @NonNull TextView textView, @NonNull LinkifiedTextView linkifiedTextView, @NonNull CheckableImageView checkableImageView, @NonNull CheckableImageView checkableImageView2, @NonNull CheckableImageView checkableImageView3) {
        this.f670a = linearLayout;
        this.f671b = frameLayout;
        this.f672c = view;
        this.f673d = view2;
        this.f674e = textView;
        this.f675f = linkifiedTextView;
        this.f676g = checkableImageView;
        this.f677h = checkableImageView2;
        this.f678i = checkableImageView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f670a;
    }
}
