package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.C5419R;

/* JADX INFO: renamed from: b.a.i.e4 */
/* JADX INFO: compiled from: ViewUserStatusPresenceBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0948e4 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f813a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ImageView f814b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f815c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f816d;

    public C0948e4(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull LinearLayout linearLayout2) {
        this.f813a = linearLayout;
        this.f814b = imageView;
        this.f815c = textView;
        this.f816d = textView2;
    }

    @NonNull
    /* JADX INFO: renamed from: a */
    public static C0948e4 m198a(@NonNull View view) {
        int i = C5419R.id.user_status_presence_dot;
        ImageView imageView = (ImageView) view.findViewById(C5419R.id.user_status_presence_dot);
        if (imageView != null) {
            i = C5419R.id.user_status_presence_subtitle;
            TextView textView = (TextView) view.findViewById(C5419R.id.user_status_presence_subtitle);
            if (textView != null) {
                i = C5419R.id.user_status_presence_title;
                TextView textView2 = (TextView) view.findViewById(C5419R.id.user_status_presence_title);
                if (textView2 != null) {
                    LinearLayout linearLayout = (LinearLayout) view;
                    return new C0948e4(linearLayout, imageView, textView, textView2, linearLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f813a;
    }
}
