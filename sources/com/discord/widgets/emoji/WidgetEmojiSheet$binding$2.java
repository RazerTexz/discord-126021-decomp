package com.discord.widgets.emoji;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetEmojiSheetBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetEmojiSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetEmojiSheet$binding$2 extends C12236k implements Function1<View, WidgetEmojiSheetBinding> {
    public static final WidgetEmojiSheet$binding$2 INSTANCE = new WidgetEmojiSheet$binding$2();

    public WidgetEmojiSheet$binding$2() {
        super(1, WidgetEmojiSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetEmojiSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetEmojiSheetBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.bottom_header_tv;
        TextView textView = (TextView) view.findViewById(C5419R.id.bottom_header_tv);
        if (textView != null) {
            i = C5419R.id.button_container;
            FrameLayout frameLayout = (FrameLayout) view.findViewById(C5419R.id.button_container);
            if (frameLayout != null) {
                i = C5419R.id.divider;
                View viewFindViewById = view.findViewById(C5419R.id.divider);
                if (viewFindViewById != null) {
                    i = C5419R.id.emoji_info_tv;
                    TextView textView2 = (TextView) view.findViewById(C5419R.id.emoji_info_tv);
                    if (textView2 != null) {
                        i = C5419R.id.emoji_iv;
                        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(C5419R.id.emoji_iv);
                        if (simpleDraweeView != null) {
                            AppViewFlipper appViewFlipper = (AppViewFlipper) view;
                            i = C5419R.id.favorite_add_button;
                            MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.favorite_add_button);
                            if (materialButton != null) {
                                i = C5419R.id.favorite_container;
                                FrameLayout frameLayout2 = (FrameLayout) view.findViewById(C5419R.id.favorite_container);
                                if (frameLayout2 != null) {
                                    i = C5419R.id.favorite_remove_button;
                                    MaterialButton materialButton2 = (MaterialButton) view.findViewById(C5419R.id.favorite_remove_button);
                                    if (materialButton2 != null) {
                                        i = C5419R.id.guildAvatarText;
                                        TextView textView3 = (TextView) view.findViewById(C5419R.id.guildAvatarText);
                                        if (textView3 != null) {
                                            i = C5419R.id.guildAvatarWrap;
                                            FrameLayout frameLayout3 = (FrameLayout) view.findViewById(C5419R.id.guildAvatarWrap);
                                            if (frameLayout3 != null) {
                                                i = C5419R.id.guild_container;
                                                LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.guild_container);
                                                if (linearLayout != null) {
                                                    i = C5419R.id.guild_info_tv;
                                                    TextView textView4 = (TextView) view.findViewById(C5419R.id.guild_info_tv);
                                                    if (textView4 != null) {
                                                        i = C5419R.id.guild_iv;
                                                        SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) view.findViewById(C5419R.id.guild_iv);
                                                        if (simpleDraweeView2 != null) {
                                                            i = C5419R.id.guild_name_tv;
                                                            TextView textView5 = (TextView) view.findViewById(C5419R.id.guild_name_tv);
                                                            if (textView5 != null) {
                                                                i = C5419R.id.join_btn;
                                                                MaterialButton materialButton3 = (MaterialButton) view.findViewById(C5419R.id.join_btn);
                                                                if (materialButton3 != null) {
                                                                    i = C5419R.id.name_tv;
                                                                    TextView textView6 = (TextView) view.findViewById(C5419R.id.name_tv);
                                                                    if (textView6 != null) {
                                                                        i = C5419R.id.premium_btn;
                                                                        MaterialButton materialButton4 = (MaterialButton) view.findViewById(C5419R.id.premium_btn);
                                                                        if (materialButton4 != null) {
                                                                            return new WidgetEmojiSheetBinding(appViewFlipper, textView, frameLayout, viewFindViewById, textView2, simpleDraweeView, appViewFlipper, materialButton, frameLayout2, materialButton2, textView3, frameLayout3, linearLayout, textView4, simpleDraweeView2, textView5, materialButton3, textView6, materialButton4);
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
