package com.discord.widgets.chat.input.gifpicker;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetGifCategoryBinding;
import com.discord.utilities.views.ContentResizingCoordinatorLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.chat.input.gifpicker.WidgetGifCategory$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetGifCategory.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGifCategory2 extends FunctionReferenceImpl implements Function1<View, WidgetGifCategoryBinding> {
    public static final WidgetGifCategory2 INSTANCE = new WidgetGifCategory2();

    public WidgetGifCategory2() {
        super(1, WidgetGifCategoryBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGifCategoryBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetGifCategoryBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        ContentResizingCoordinatorLayout contentResizingCoordinatorLayout = (ContentResizingCoordinatorLayout) view;
        int i = R.id.gif_category_gif_recycler;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.gif_category_gif_recycler);
        if (recyclerView != null) {
            i = R.id.gif_category_loading_view;
            GifLoadingView gifLoadingView = (GifLoadingView) view.findViewById(R.id.gif_category_loading_view);
            if (gifLoadingView != null) {
                i = R.id.gif_category_title;
                TextView textView = (TextView) view.findViewById(R.id.gif_category_title);
                if (textView != null) {
                    return new WidgetGifCategoryBinding((ContentResizingCoordinatorLayout) view, contentResizingCoordinatorLayout, recyclerView, gifLoadingView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
