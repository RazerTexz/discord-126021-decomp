package b.b.a.a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import b.b.a.d.d$a;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout$OnTabSelectedListener;
import com.google.android.material.tabs.TabLayout$Tab;
import com.lytefast.flexinput.R$c;
import com.lytefast.flexinput.fragment.FlexInputFragment;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: AddContentDialogFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a$e extends d0.z.d.o implements Function0<Unit> {
    public final /* synthetic */ Fragment $flexInputFragment;
    public final /* synthetic */ a this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a$e(a aVar, Fragment fragment) {
        super(0);
        this.this$0 = aVar;
        this.$flexInputFragment = fragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        TabLayout tabLayout;
        TabLayout$Tab tabAt;
        FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
        d0.z.d.m.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        d$a[] d_aArrK = ((FlexInputFragment) this.$flexInputFragment).k();
        b.b.a.d.d dVar = new b.b.a.d.d(childFragmentManager, (d$a[]) Arrays.copyOf(d_aArrK, d_aArrK.length));
        a aVar = this.this$0;
        Objects.requireNonNull(aVar);
        d0.z.d.m.checkNotNullParameter(dVar, "pagerAdapter");
        Context context = aVar.getContext();
        if (context != null && (tabLayout = aVar.contentTabs) != null) {
            d0.z.d.m.checkNotNullExpressionValue(context, "context");
            d0.z.d.m.checkNotNullParameter(context, "context");
            d0.z.d.m.checkNotNullParameter(tabLayout, "tabLayout");
            ColorStateList colorStateList = AppCompatResources.getColorStateList(context, R$c.tab_color_selector);
            int tabCount = tabLayout.getTabCount();
            for (int i = 0; i < tabCount; i++) {
                TabLayout$Tab tabAt2 = tabLayout.getTabAt(i);
                if (tabAt2 != null) {
                    d0.z.d.m.checkNotNullExpressionValue(colorStateList, "iconColors");
                    Drawable icon = tabAt2.getIcon();
                    if (icon != null) {
                        Drawable drawableWrap = DrawableCompat.wrap(icon);
                        DrawableCompat.setTintList(drawableWrap, colorStateList);
                        tabAt2.setIcon(drawableWrap);
                    }
                }
            }
            d$a[] d_aArr = dVar.a;
            ArrayList arrayList = new ArrayList(d_aArr.length);
            for (d$a d_a : d_aArr) {
                TabLayout$Tab icon2 = tabLayout.newTab().setIcon(d_a.getIcon());
                d0.z.d.m.checkNotNullExpressionValue(icon2, "tabLayout.newTab()\n              .setIcon(it.icon)");
                d0.z.d.m.checkNotNullExpressionValue(colorStateList, "iconColors");
                Drawable icon3 = icon2.getIcon();
                if (icon3 != null) {
                    Drawable drawableWrap2 = DrawableCompat.wrap(icon3);
                    DrawableCompat.setTintList(drawableWrap2, colorStateList);
                    icon2.setIcon(drawableWrap2);
                }
                arrayList.add(icon2.setContentDescription(d_a.getContentDesc()));
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                tabLayout.addTab((TabLayout$Tab) it.next());
            }
            ViewPager viewPager = aVar.contentPager;
            if (viewPager != null) {
                viewPager.setAdapter(dVar);
            }
            TabLayout tabLayout2 = aVar.contentTabs;
            if (tabLayout2 != null) {
                tabLayout2.addOnTabSelectedListener((TabLayout$OnTabSelectedListener) new b(aVar));
            }
            ViewPager viewPager2 = aVar.contentPager;
            if (viewPager2 != null) {
                viewPager2.addOnPageChangeListener(new c(aVar));
            }
            TabLayout tabLayout3 = aVar.contentTabs;
            if (tabLayout3 != null && (tabAt = tabLayout3.getTabAt(0)) != null) {
                tabAt.select();
            }
        }
        return Unit.a;
    }
}
