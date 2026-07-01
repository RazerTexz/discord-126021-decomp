package b.a.i;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.discord.views.LoadingButton;
import com.discord.views.steps.StepsProgressIndicatorView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: renamed from: b.a.i.y3, reason: use source file name */
/* JADX INFO: compiled from: ViewStepsBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class ViewStepsBinding implements ViewBinding {

    @NonNull
    public final RelativeLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayout f236b;

    @NonNull
    public final TextView c;

    @NonNull
    public final ImageView d;

    @NonNull
    public final LoadingButton e;

    @NonNull
    public final MaterialButton f;

    @NonNull
    public final StepsProgressIndicatorView g;

    @NonNull
    public final TextView h;

    @NonNull
    public final ViewPager2 i;

    public ViewStepsBinding(@NonNull RelativeLayout relativeLayout, @NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull LoadingButton loadingButton, @NonNull MaterialButton materialButton, @NonNull StepsProgressIndicatorView stepsProgressIndicatorView, @NonNull TextView textView2, @NonNull ViewPager2 viewPager2) {
        this.a = relativeLayout;
        this.f236b = linearLayout;
        this.c = textView;
        this.d = imageView;
        this.e = loadingButton;
        this.f = materialButton;
        this.g = stepsProgressIndicatorView;
        this.h = textView2;
        this.i = viewPager2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
