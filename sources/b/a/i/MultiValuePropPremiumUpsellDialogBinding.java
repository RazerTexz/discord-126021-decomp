package b.a.i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: renamed from: b.a.i.w0, reason: use source file name */
/* JADX INFO: compiled from: MultiValuePropPremiumUpsellDialogBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class MultiValuePropPremiumUpsellDialogBinding implements ViewBinding {

    @NonNull
    public final RelativeLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final MaterialButton f221b;

    @NonNull
    public final TabLayout c;

    @NonNull
    public final MaterialButton d;

    @NonNull
    public final MaterialButton e;

    @NonNull
    public final ViewPager2 f;

    public MultiValuePropPremiumUpsellDialogBinding(@NonNull RelativeLayout relativeLayout, @NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton, @NonNull View view, @NonNull TabLayout tabLayout, @NonNull MaterialButton materialButton2, @NonNull MaterialButton materialButton3, @NonNull ViewPager2 viewPager2) {
        this.a = relativeLayout;
        this.f221b = materialButton;
        this.c = tabLayout;
        this.d = materialButton2;
        this.e = materialButton3;
        this.f = viewPager2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
