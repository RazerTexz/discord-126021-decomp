package com.discord.widgets.stickers;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetGuildStickerSheetBinding;
import com.discord.views.sticker.StickerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.stickers.WidgetGuildStickerSheet$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetGuildStickerSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetGuildStickerSheet2 extends FunctionReferenceImpl implements Function1<View, WidgetGuildStickerSheetBinding> {
    public static final WidgetGuildStickerSheet2 INSTANCE = new WidgetGuildStickerSheet2();

    public WidgetGuildStickerSheet2() {
        super(1, WidgetGuildStickerSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildStickerSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetGuildStickerSheetBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.divider;
        View viewFindViewById = view.findViewById(R.id.divider);
        if (viewFindViewById != null) {
            i = R.id.guild_sticker_sheet_button_container;
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.guild_sticker_sheet_button_container);
            if (frameLayout != null) {
                i = R.id.guild_sticker_sheet_description;
                TextView textView = (TextView) view.findViewById(R.id.guild_sticker_sheet_description);
                if (textView != null) {
                    AppViewFlipper appViewFlipper = (AppViewFlipper) view;
                    i = R.id.guild_sticker_sheet_guild_container;
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.guild_sticker_sheet_guild_container);
                    if (linearLayout != null) {
                        i = R.id.guild_sticker_sheet_guild_header;
                        TextView textView2 = (TextView) view.findViewById(R.id.guild_sticker_sheet_guild_header);
                        if (textView2 != null) {
                            i = R.id.guild_sticker_sheet_guild_icon;
                            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.guild_sticker_sheet_guild_icon);
                            if (simpleDraweeView != null) {
                                i = R.id.guild_sticker_sheet_guild_icon_text;
                                TextView textView3 = (TextView) view.findViewById(R.id.guild_sticker_sheet_guild_icon_text);
                                if (textView3 != null) {
                                    i = R.id.guild_sticker_sheet_guild_icon_wrapper;
                                    FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.guild_sticker_sheet_guild_icon_wrapper);
                                    if (frameLayout2 != null) {
                                        i = R.id.guild_sticker_sheet_guild_info;
                                        TextView textView4 = (TextView) view.findViewById(R.id.guild_sticker_sheet_guild_info);
                                        if (textView4 != null) {
                                            i = R.id.guild_sticker_sheet_guild_name;
                                            TextView textView5 = (TextView) view.findViewById(R.id.guild_sticker_sheet_guild_name);
                                            if (textView5 != null) {
                                                i = R.id.guild_sticker_sheet_join_btn;
                                                MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.guild_sticker_sheet_join_btn);
                                                if (materialButton != null) {
                                                    i = R.id.guild_sticker_sheet_premium_btn;
                                                    MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.guild_sticker_sheet_premium_btn);
                                                    if (materialButton2 != null) {
                                                        i = R.id.guild_sticker_sheet_sticker;
                                                        StickerView stickerView = (StickerView) view.findViewById(R.id.guild_sticker_sheet_sticker);
                                                        if (stickerView != null) {
                                                            i = R.id.guild_sticker_sheet_sticker_name;
                                                            TextView textView6 = (TextView) view.findViewById(R.id.guild_sticker_sheet_sticker_name);
                                                            if (textView6 != null) {
                                                                return new WidgetGuildStickerSheetBinding(appViewFlipper, viewFindViewById, frameLayout, textView, appViewFlipper, linearLayout, textView2, simpleDraweeView, textView3, frameLayout2, textView4, textView5, materialButton, materialButton2, stickerView, textView6);
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
