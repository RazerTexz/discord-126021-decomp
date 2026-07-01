package com.discord.widgets.chat.input.gifpicker;

import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetGifPickerBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.chat.input.gifpicker.WidgetGifPicker$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetGifPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGifPicker2 extends FunctionReferenceImpl implements Function1<View, WidgetGifPickerBinding> {
    public static final WidgetGifPicker2 INSTANCE = new WidgetGifPicker2();

    public WidgetGifPicker2() {
        super(1, WidgetGifPickerBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGifPickerBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetGifPickerBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.gif_picker_category_recycler;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.gif_picker_category_recycler);
        if (recyclerView != null) {
            FrameLayout frameLayout = (FrameLayout) view;
            GifLoadingView gifLoadingView = (GifLoadingView) view.findViewById(R.id.gif_picker_loading_view);
            if (gifLoadingView != null) {
                return new WidgetGifPickerBinding(frameLayout, recyclerView, frameLayout, gifLoadingView);
            }
            i = R.id.gif_picker_loading_view;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
