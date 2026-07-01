package com.discord.widgets.guild_role_subscriptions;

import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetPriceTierPickerBottomSheetBinding;
import com.google.android.material.appbar.AppBarLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.WidgetPriceTierPickerBottomSheet$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetPriceTierPickerBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetPriceTierPickerBottomSheet5 extends FunctionReferenceImpl implements Function1<View, WidgetPriceTierPickerBottomSheetBinding> {
    public static final WidgetPriceTierPickerBottomSheet5 INSTANCE = new WidgetPriceTierPickerBottomSheet5();

    public WidgetPriceTierPickerBottomSheet5() {
        super(1, WidgetPriceTierPickerBottomSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetPriceTierPickerBottomSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetPriceTierPickerBottomSheetBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.price_tier_picker_app_bar;
        AppBarLayout appBarLayout = (AppBarLayout) view.findViewById(R.id.price_tier_picker_app_bar);
        if (appBarLayout != null) {
            i = R.id.price_tier_picker_app_flipper;
            AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(R.id.price_tier_picker_app_flipper);
            if (appViewFlipper != null) {
                i = R.id.price_tier_picker_recycler;
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.price_tier_picker_recycler);
                if (recyclerView != null) {
                    i = R.id.price_tier_picker_toolbar;
                    Toolbar toolbar = (Toolbar) view.findViewById(R.id.price_tier_picker_toolbar);
                    if (toolbar != null) {
                        return new WidgetPriceTierPickerBottomSheetBinding((CoordinatorLayout) view, appBarLayout, appViewFlipper, recyclerView, toolbar);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
