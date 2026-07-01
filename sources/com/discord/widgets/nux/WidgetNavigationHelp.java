package com.discord.widgets.nux;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppDialog;
import com.discord.databinding.WidgetNavigationHelpBinding;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.view.recycler.ViewPager2ExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.tabs.TabLayout;
import d0.z.d.m;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetNavigationHelp.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetNavigationHelp extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetNavigationHelp.class, "binding", "getBinding()Lcom/discord/databinding/WidgetNavigationHelpBinding;", 0)};
    public static final WidgetNavigationHelp$Companion Companion = new WidgetNavigationHelp$Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    public WidgetNavigationHelp() {
        super(R$layout.widget_navigation_help);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetNavigationHelp$binding$2.INSTANCE, null, 2, null);
    }

    private final WidgetNavigationHelpBinding getBinding() {
        return (WidgetNavigationHelpBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setDimAmount(0.9f);
        window.setLayout(-1, -1);
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setSoftInputMode(53);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().d.setPageTransformer(new MarginPageTransformer(DimenUtils.dpToPixels(8)));
        ViewPager2 viewPager2 = getBinding().d;
        m.checkNotNullExpressionValue(viewPager2, "binding.navigationHelpNuxPager");
        viewPager2.setAdapter(new WidgetNavigationHelp$NuxPagerAdapter(this));
        TabLayout tabLayout = getBinding().c;
        m.checkNotNullExpressionValue(tabLayout, "binding.navigationHelpIndicators");
        ViewPager2 viewPager3 = getBinding().d;
        m.checkNotNullExpressionValue(viewPager3, "binding.navigationHelpNuxPager");
        ViewPager2ExtensionsKt.setUpWithViewPager2$default(tabLayout, viewPager3, null, 2, null);
        getBinding().f2499b.setOnClickListener(new WidgetNavigationHelp$onViewBound$1(this));
    }
}
