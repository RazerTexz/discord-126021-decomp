package com.discord.widgets.settings;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R$id;
import com.discord.databinding.WidgetChatListAdapterItemTextBinding;
import com.discord.databinding.WidgetSettingsAppearanceBinding;
import com.discord.views.CheckedSetting;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsAppearance.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsAppearance$binding$2 extends k implements Function1<View, WidgetSettingsAppearanceBinding> {
    public static final WidgetSettingsAppearance$binding$2 INSTANCE = new WidgetSettingsAppearance$binding$2();

    public WidgetSettingsAppearance$binding$2() {
        super(1, WidgetSettingsAppearanceBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsAppearanceBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetSettingsAppearanceBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetSettingsAppearanceBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.chat_item;
        View viewFindViewById = view.findViewById(R$id.chat_item);
        if (viewFindViewById != null) {
            WidgetChatListAdapterItemTextBinding widgetChatListAdapterItemTextBindingA = WidgetChatListAdapterItemTextBinding.a(viewFindViewById);
            i = R$id.settings_appearance_font_scale_header;
            TextView textView = (TextView) view.findViewById(R$id.settings_appearance_font_scale_header);
            if (textView != null) {
                i = R$id.settings_appearance_font_scale_platform;
                TextView textView2 = (TextView) view.findViewById(R$id.settings_appearance_font_scale_platform);
                if (textView2 != null) {
                    i = R$id.settings_appearance_font_scaling_container;
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.settings_appearance_font_scaling_container);
                    if (linearLayout != null) {
                        i = R$id.settings_appearance_font_scaling_reset;
                        TextView textView3 = (TextView) view.findViewById(R$id.settings_appearance_font_scaling_reset);
                        if (textView3 != null) {
                            i = R$id.settings_appearance_font_scaling_seekbar;
                            SeekBar seekBar = (SeekBar) view.findViewById(R$id.settings_appearance_font_scaling_seekbar);
                            if (seekBar != null) {
                                i = R$id.settings_appearance_font_scaling_seekbar_text_left;
                                TextView textView4 = (TextView) view.findViewById(R$id.settings_appearance_font_scaling_seekbar_text_left);
                                if (textView4 != null) {
                                    i = R$id.settings_appearance_font_scaling_seekbar_text_right;
                                    TextView textView5 = (TextView) view.findViewById(R$id.settings_appearance_font_scaling_seekbar_text_right);
                                    if (textView5 != null) {
                                        i = R$id.settings_appearance_holy_light;
                                        View viewFindViewById2 = view.findViewById(R$id.settings_appearance_holy_light);
                                        if (viewFindViewById2 != null) {
                                            i = R$id.settings_appearance_sync_header;
                                            TextView textView6 = (TextView) view.findViewById(R$id.settings_appearance_sync_header);
                                            if (textView6 != null) {
                                                i = R$id.settings_appearance_sync_switch;
                                                CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(R$id.settings_appearance_sync_switch);
                                                if (checkedSetting != null) {
                                                    i = R$id.settings_appearance_theme_dark_radio;
                                                    CheckedSetting checkedSetting2 = (CheckedSetting) view.findViewById(R$id.settings_appearance_theme_dark_radio);
                                                    if (checkedSetting2 != null) {
                                                        i = R$id.settings_appearance_theme_header;
                                                        TextView textView7 = (TextView) view.findViewById(R$id.settings_appearance_theme_header);
                                                        if (textView7 != null) {
                                                            i = R$id.settings_appearance_theme_light_radio;
                                                            CheckedSetting checkedSetting3 = (CheckedSetting) view.findViewById(R$id.settings_appearance_theme_light_radio);
                                                            if (checkedSetting3 != null) {
                                                                i = R$id.settings_appearance_theme_pure_evil_switch;
                                                                CheckedSetting checkedSetting4 = (CheckedSetting) view.findViewById(R$id.settings_appearance_theme_pure_evil_switch);
                                                                if (checkedSetting4 != null) {
                                                                    return new WidgetSettingsAppearanceBinding((CoordinatorLayout) view, widgetChatListAdapterItemTextBindingA, textView, textView2, linearLayout, textView3, seekBar, textView4, textView5, viewFindViewById2, textView6, checkedSetting, checkedSetting2, textView7, checkedSetting3, checkedSetting4);
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
