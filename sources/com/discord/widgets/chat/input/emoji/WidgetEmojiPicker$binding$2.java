package com.discord.widgets.chat.input.emoji;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R$id;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetEmojiPickerBinding;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.textfield.TextInputEditText;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetEmojiPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetEmojiPicker$binding$2 extends k implements Function1<View, WidgetEmojiPickerBinding> {
    public static final WidgetEmojiPicker$binding$2 INSTANCE = new WidgetEmojiPicker$binding$2();

    public WidgetEmojiPicker$binding$2() {
        super(1, WidgetEmojiPickerBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetEmojiPickerBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetEmojiPickerBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetEmojiPickerBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.chat_input_emoji_picker_recycler;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R$id.chat_input_emoji_picker_recycler);
        if (recyclerView != null) {
            i = R$id.chat_input_emoji_picker_view_flipper;
            AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(R$id.chat_input_emoji_picker_view_flipper);
            if (appViewFlipper != null) {
                i = R$id.emoji_app_bar;
                AppBarLayout appBarLayout = (AppBarLayout) view.findViewById(R$id.emoji_app_bar);
                if (appBarLayout != null) {
                    i = R$id.emoji_inline_search_button;
                    TextView textView = (TextView) view.findViewById(R$id.emoji_inline_search_button);
                    if (textView != null) {
                        i = R$id.emoji_picker_backspace_icon;
                        ImageView imageView = (ImageView) view.findViewById(R$id.emoji_picker_backspace_icon);
                        if (imageView != null) {
                            i = R$id.emoji_picker_bottom_bar;
                            ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R$id.emoji_picker_bottom_bar);
                            if (constraintLayout != null) {
                                i = R$id.emoji_picker_bottom_bar_divider;
                                View viewFindViewById = view.findViewById(R$id.emoji_picker_bottom_bar_divider);
                                if (viewFindViewById != null) {
                                    i = R$id.emoji_picker_category_barrier;
                                    Barrier barrier = (Barrier) view.findViewById(R$id.emoji_picker_category_barrier);
                                    if (barrier != null) {
                                        i = R$id.emoji_picker_category_recycler;
                                        RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R$id.emoji_picker_category_recycler);
                                        if (recyclerView2 != null) {
                                            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) view;
                                            i = R$id.emoji_picker_unicode_emoji_shortcut_button;
                                            ImageView imageView2 = (ImageView) view.findViewById(R$id.emoji_picker_unicode_emoji_shortcut_button);
                                            if (imageView2 != null) {
                                                i = R$id.emoji_search_bar;
                                                FrameLayout frameLayout = (FrameLayout) view.findViewById(R$id.emoji_search_bar);
                                                if (frameLayout != null) {
                                                    i = R$id.emoji_search_clear;
                                                    ImageView imageView3 = (ImageView) view.findViewById(R$id.emoji_search_clear);
                                                    if (imageView3 != null) {
                                                        i = R$id.emoji_search_input;
                                                        TextInputEditText textInputEditText = (TextInputEditText) view.findViewById(R$id.emoji_search_input);
                                                        if (textInputEditText != null) {
                                                            i = R$id.emoji_toolbar;
                                                            Toolbar toolbar = (Toolbar) view.findViewById(R$id.emoji_toolbar);
                                                            if (toolbar != null) {
                                                                return new WidgetEmojiPickerBinding(coordinatorLayout, recyclerView, appViewFlipper, appBarLayout, textView, imageView, constraintLayout, viewFindViewById, barrier, recyclerView2, coordinatorLayout, imageView2, frameLayout, imageView3, textInputEditText, toolbar);
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
