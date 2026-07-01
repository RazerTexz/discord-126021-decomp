package com.discord.widgets.channels;

import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetChannelPickerSheetBinding;
import com.discord.views.SearchInputView;
import com.google.android.material.appbar.AppBarLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.channels.WidgetChannelPickerBottomSheet$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetChannelPickerBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChannelPickerBottomSheet3 extends FunctionReferenceImpl implements Function1<View, WidgetChannelPickerSheetBinding> {
    public static final WidgetChannelPickerBottomSheet3 INSTANCE = new WidgetChannelPickerBottomSheet3();

    public WidgetChannelPickerBottomSheet3() {
        super(1, WidgetChannelPickerSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetChannelPickerSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetChannelPickerSheetBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.channel_picker_app_bar;
        AppBarLayout appBarLayout = (AppBarLayout) view.findViewById(R.id.channel_picker_app_bar);
        if (appBarLayout != null) {
            i = R.id.channel_picker_app_flipper;
            AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(R.id.channel_picker_app_flipper);
            if (appViewFlipper != null) {
                i = R.id.channel_picker_recycler;
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.channel_picker_recycler);
                if (recyclerView != null) {
                    i = R.id.channel_picker_search_input;
                    SearchInputView searchInputView = (SearchInputView) view.findViewById(R.id.channel_picker_search_input);
                    if (searchInputView != null) {
                        i = R.id.channel_picker_toolbar;
                        Toolbar toolbar = (Toolbar) view.findViewById(R.id.channel_picker_toolbar);
                        if (toolbar != null) {
                            return new WidgetChannelPickerSheetBinding((CoordinatorLayout) view, appBarLayout, appViewFlipper, recyclerView, searchInputView, toolbar);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
