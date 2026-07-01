package com.discord.widgets.chat.input.gifpicker;

import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetGifPickerSearchBinding;
import com.discord.views.SearchInputView;
import com.google.android.material.appbar.AppBarLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.chat.input.gifpicker.WidgetGifPickerSearch$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetGifPickerSearch.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGifPickerSearch2 extends FunctionReferenceImpl implements Function1<View, WidgetGifPickerSearchBinding> {
    public static final WidgetGifPickerSearch2 INSTANCE = new WidgetGifPickerSearch2();

    public WidgetGifPickerSearch2() {
        super(1, WidgetGifPickerSearchBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGifPickerSearchBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetGifPickerSearchBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.gif_search_app_bar;
        AppBarLayout appBarLayout = (AppBarLayout) view.findViewById(R.id.gif_search_app_bar);
        if (appBarLayout != null) {
            i = R.id.gif_search_gif_recycler;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.gif_search_gif_recycler);
            if (recyclerView != null) {
                i = R.id.gif_search_loading_view;
                GifLoadingView gifLoadingView = (GifLoadingView) view.findViewById(R.id.gif_search_loading_view);
                if (gifLoadingView != null) {
                    i = R.id.gif_search_toolbar;
                    Toolbar toolbar = (Toolbar) view.findViewById(R.id.gif_search_toolbar);
                    if (toolbar != null) {
                        i = R.id.gif_search_view_flipper;
                        AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(R.id.gif_search_view_flipper);
                        if (appViewFlipper != null) {
                            i = R.id.search_input;
                            SearchInputView searchInputView = (SearchInputView) view.findViewById(R.id.search_input);
                            if (searchInputView != null) {
                                return new WidgetGifPickerSearchBinding((CoordinatorLayout) view, appBarLayout, recyclerView, gifLoadingView, toolbar, appViewFlipper, searchInputView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
