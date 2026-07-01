package b.a.i;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.R;

/* JADX INFO: renamed from: b.a.i.e4, reason: use source file name */
/* JADX INFO: compiled from: ViewUserStatusPresenceBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class ViewUserStatusPresenceBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f106b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    public ViewUserStatusPresenceBinding(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull LinearLayout linearLayout2) {
        this.a = linearLayout;
        this.f106b = imageView;
        this.c = textView;
        this.d = textView2;
    }

    @NonNull
    public static ViewUserStatusPresenceBinding a(@NonNull View view) {
        int i = R.id.user_status_presence_dot;
        ImageView imageView = (ImageView) view.findViewById(R.id.user_status_presence_dot);
        if (imageView != null) {
            i = R.id.user_status_presence_subtitle;
            TextView textView = (TextView) view.findViewById(R.id.user_status_presence_subtitle);
            if (textView != null) {
                i = R.id.user_status_presence_title;
                TextView textView2 = (TextView) view.findViewById(R.id.user_status_presence_title);
                if (textView2 != null) {
                    LinearLayout linearLayout = (LinearLayout) view;
                    return new ViewUserStatusPresenceBinding(linearLayout, imageView, textView, textView2, linearLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
