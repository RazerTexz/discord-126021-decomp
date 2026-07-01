package com.discord.widgets.channels;

import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R$id;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetChannelPickerSheetBinding;
import com.discord.views.SearchInputView;
import com.google.android.material.appbar.AppBarLayout;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelPickerBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChannelPickerBottomSheet$binding$2 extends k implements Function1<View, WidgetChannelPickerSheetBinding> {
    public static final WidgetChannelPickerBottomSheet$binding$2 INSTANCE = new WidgetChannelPickerBottomSheet$binding$2();

    public WidgetChannelPickerBottomSheet$binding$2() {
        super(1, WidgetChannelPickerSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetChannelPickerSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetChannelPickerSheetBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetChannelPickerSheetBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.channel_picker_app_bar;
        AppBarLayout appBarLayout = (AppBarLayout) view.findViewById(R$id.channel_picker_app_bar);
        if (appBarLayout != null) {
            i = R$id.channel_picker_app_flipper;
            AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(R$id.channel_picker_app_flipper);
            if (appViewFlipper != null) {
                i = R$id.channel_picker_recycler;
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R$id.channel_picker_recycler);
                if (recyclerView != null) {
                    i = R$id.channel_picker_search_input;
                    SearchInputView searchInputView = (SearchInputView) view.findViewById(R$id.channel_picker_search_input);
                    if (searchInputView != null) {
                        i = R$id.channel_picker_toolbar;
                        Toolbar toolbar = (Toolbar) view.findViewById(R$id.channel_picker_toolbar);
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
