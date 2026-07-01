package b.a.i;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.R$id;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: compiled from: ThreadBrowserEmptyBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class s1 implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f196b;

    @NonNull
    public final MaterialButton c;

    @NonNull
    public final TextView d;

    public s1(@NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull MaterialButton materialButton, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ImageView imageView) {
        this.a = constraintLayout;
        this.f196b = constraintLayout2;
        this.c = materialButton;
        this.d = textView;
    }

    @NonNull
    public static s1 a(@NonNull View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R$id.thread_browser_empty_create_button;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R$id.thread_browser_empty_create_button);
        if (materialButton != null) {
            i = R$id.thread_browser_empty_heading;
            TextView textView = (TextView) view.findViewById(R$id.thread_browser_empty_heading);
            if (textView != null) {
                i = R$id.thread_browser_empty_subheading;
                TextView textView2 = (TextView) view.findViewById(R$id.thread_browser_empty_subheading);
                if (textView2 != null) {
                    i = R$id.thread_icon;
                    ImageView imageView = (ImageView) view.findViewById(R$id.thread_icon);
                    if (imageView != null) {
                        return new s1(constraintLayout, constraintLayout, materialButton, textView, textView2, imageView);
                    }
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
