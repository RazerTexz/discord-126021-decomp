package com.discord.widgets.chat.input.gifpicker;

import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.WidgetGifPickerBinding;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetGifPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGifPicker$binding$2 extends C12236k implements Function1<View, WidgetGifPickerBinding> {
    public static final WidgetGifPicker$binding$2 INSTANCE = new WidgetGifPicker$binding$2();

    public WidgetGifPicker$binding$2() {
        super(1, WidgetGifPickerBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGifPickerBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetGifPickerBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.gif_picker_category_recycler;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(C5419R.id.gif_picker_category_recycler);
        if (recyclerView != null) {
            FrameLayout frameLayout = (FrameLayout) view;
            GifLoadingView gifLoadingView = (GifLoadingView) view.findViewById(C5419R.id.gif_picker_loading_view);
            if (gifLoadingView != null) {
                return new WidgetGifPickerBinding(frameLayout, recyclerView, frameLayout, gifLoadingView);
            }
            i = C5419R.id.gif_picker_loading_view;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
