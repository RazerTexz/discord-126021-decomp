package p007b.p008a.p025i;

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

/* JADX INFO: renamed from: b.a.i.y3 */
/* JADX INFO: compiled from: ViewStepsBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1090y3 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final RelativeLayout f1417a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final LinearLayout f1418b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f1419c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final ImageView f1420d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final LoadingButton f1421e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final MaterialButton f1422f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final StepsProgressIndicatorView f1423g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final TextView f1424h;

    /* JADX INFO: renamed from: i */
    @NonNull
    public final ViewPager2 f1425i;

    public C1090y3(@NonNull RelativeLayout relativeLayout, @NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull LoadingButton loadingButton, @NonNull MaterialButton materialButton, @NonNull StepsProgressIndicatorView stepsProgressIndicatorView, @NonNull TextView textView2, @NonNull ViewPager2 viewPager2) {
        this.f1417a = relativeLayout;
        this.f1418b = linearLayout;
        this.f1419c = textView;
        this.f1420d = imageView;
        this.f1421e = loadingButton;
        this.f1422f = materialButton;
        this.f1423g = stepsProgressIndicatorView;
        this.f1424h = textView2;
        this.f1425i = viewPager2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1417a;
    }
}
