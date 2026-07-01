package com.discord.widgets.chat.input.sticker;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R$id;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetStickerPickerBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.LoadingButton;
import com.discord.views.SearchInputView;
import com.discord.views.sticker.StickerView;
import com.google.android.material.appbar.AppBarLayout;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetStickerPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetStickerPicker$binding$2 extends k implements Function1<View, WidgetStickerPickerBinding> {
    public static final WidgetStickerPicker$binding$2 INSTANCE = new WidgetStickerPicker$binding$2();

    public WidgetStickerPicker$binding$2() {
        super(1, WidgetStickerPickerBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetStickerPickerBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetStickerPickerBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetStickerPickerBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.chat_input_sticker_picker_empty_container;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.chat_input_sticker_picker_empty_container);
        if (linearLayout != null) {
            i = R$id.chat_input_sticker_picker_empty_container_phase_1;
            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R$id.chat_input_sticker_picker_empty_container_phase_1);
            if (linearLayout2 != null) {
                i = R$id.chat_input_sticker_picker_empty_image;
                ImageView imageView = (ImageView) view.findViewById(R$id.chat_input_sticker_picker_empty_image);
                if (imageView != null) {
                    i = R$id.chat_input_sticker_picker_empty_link;
                    LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R$id.chat_input_sticker_picker_empty_link);
                    if (linkifiedTextView != null) {
                        i = R$id.chat_input_sticker_picker_empty_sticker_1;
                        StickerView stickerView = (StickerView) view.findViewById(R$id.chat_input_sticker_picker_empty_sticker_1);
                        if (stickerView != null) {
                            i = R$id.chat_input_sticker_picker_empty_sticker_2;
                            StickerView stickerView2 = (StickerView) view.findViewById(R$id.chat_input_sticker_picker_empty_sticker_2);
                            if (stickerView2 != null) {
                                i = R$id.chat_input_sticker_picker_empty_sticker_3;
                                StickerView stickerView3 = (StickerView) view.findViewById(R$id.chat_input_sticker_picker_empty_sticker_3);
                                if (stickerView3 != null) {
                                    i = R$id.chat_input_sticker_picker_empty_sticker_4;
                                    StickerView stickerView4 = (StickerView) view.findViewById(R$id.chat_input_sticker_picker_empty_sticker_4);
                                    if (stickerView4 != null) {
                                        i = R$id.chat_input_sticker_picker_empty_subscribe;
                                        LoadingButton loadingButton = (LoadingButton) view.findViewById(R$id.chat_input_sticker_picker_empty_subscribe);
                                        if (loadingButton != null) {
                                            i = R$id.chat_input_sticker_picker_empty_subtitle;
                                            TextView textView = (TextView) view.findViewById(R$id.chat_input_sticker_picker_empty_subtitle);
                                            if (textView != null) {
                                                i = R$id.chat_input_sticker_picker_empty_subtitle_phase_1;
                                                TextView textView2 = (TextView) view.findViewById(R$id.chat_input_sticker_picker_empty_subtitle_phase_1);
                                                if (textView2 != null) {
                                                    i = R$id.chat_input_sticker_picker_empty_title;
                                                    TextView textView3 = (TextView) view.findViewById(R$id.chat_input_sticker_picker_empty_title);
                                                    if (textView3 != null) {
                                                        i = R$id.chat_input_sticker_picker_empty_title_phase_1;
                                                        TextView textView4 = (TextView) view.findViewById(R$id.chat_input_sticker_picker_empty_title_phase_1);
                                                        if (textView4 != null) {
                                                            i = R$id.chat_input_sticker_picker_recycler;
                                                            RecyclerView recyclerView = (RecyclerView) view.findViewById(R$id.chat_input_sticker_picker_recycler);
                                                            if (recyclerView != null) {
                                                                i = R$id.chat_input_sticker_picker_view_flipper;
                                                                AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(R$id.chat_input_sticker_picker_view_flipper);
                                                                if (appViewFlipper != null) {
                                                                    i = R$id.sticker_app_bar;
                                                                    AppBarLayout appBarLayout = (AppBarLayout) view.findViewById(R$id.sticker_app_bar);
                                                                    if (appBarLayout != null) {
                                                                        i = R$id.sticker_picker_bottom_bar;
                                                                        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R$id.sticker_picker_bottom_bar);
                                                                        if (constraintLayout != null) {
                                                                            i = R$id.sticker_picker_bottom_bar_divider;
                                                                            View viewFindViewById = view.findViewById(R$id.sticker_picker_bottom_bar_divider);
                                                                            if (viewFindViewById != null) {
                                                                                i = R$id.sticker_picker_category_recycler;
                                                                                RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R$id.sticker_picker_category_recycler);
                                                                                if (recyclerView2 != null) {
                                                                                    CoordinatorLayout coordinatorLayout = (CoordinatorLayout) view;
                                                                                    i = R$id.sticker_search_input;
                                                                                    SearchInputView searchInputView = (SearchInputView) view.findViewById(R$id.sticker_search_input);
                                                                                    if (searchInputView != null) {
                                                                                        i = R$id.sticker_toolbar;
                                                                                        Toolbar toolbar = (Toolbar) view.findViewById(R$id.sticker_toolbar);
                                                                                        if (toolbar != null) {
                                                                                            return new WidgetStickerPickerBinding(coordinatorLayout, linearLayout, linearLayout2, imageView, linkifiedTextView, stickerView, stickerView2, stickerView3, stickerView4, loadingButton, textView, textView2, textView3, textView4, recyclerView, appViewFlipper, appBarLayout, constraintLayout, viewFindViewById, recyclerView2, coordinatorLayout, searchInputView, toolbar);
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
