package com.discord.widgets.channels.settings;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import com.discord.C5419R;
import com.discord.databinding.WidgetThreadSettingsBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetThreadSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetThreadSettings$binding$2 extends C12236k implements Function1<View, WidgetThreadSettingsBinding> {
    public static final WidgetThreadSettings$binding$2 INSTANCE = new WidgetThreadSettings$binding$2();

    public WidgetThreadSettings$binding$2() {
        super(1, WidgetThreadSettingsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetThreadSettingsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetThreadSettingsBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.channel_settings_pinned_messages;
        TextView textView = (TextView) view.findViewById(C5419R.id.channel_settings_pinned_messages);
        if (textView != null) {
            i = C5419R.id.channel_settings_pinned_messages_container;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.channel_settings_pinned_messages_container);
            if (linearLayout != null) {
                i = C5419R.id.channel_settings_pinned_messages_disabled_overlay;
                View viewFindViewById = view.findViewById(C5419R.id.channel_settings_pinned_messages_disabled_overlay);
                if (viewFindViewById != null) {
                    i = C5419R.id.scroll_view;
                    NestedScrollView nestedScrollView = (NestedScrollView) view.findViewById(C5419R.id.scroll_view);
                    if (nestedScrollView != null) {
                        i = C5419R.id.thread_settings_edit_name;
                        TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(C5419R.id.thread_settings_edit_name);
                        if (textInputLayout != null) {
                            i = C5419R.id.thread_settings_edit_wrap;
                            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(C5419R.id.thread_settings_edit_wrap);
                            if (linearLayout2 != null) {
                                i = C5419R.id.thread_settings_save;
                                FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(C5419R.id.thread_settings_save);
                                if (floatingActionButton != null) {
                                    i = C5419R.id.thread_settings_section_slow_mode;
                                    LinearLayout linearLayout3 = (LinearLayout) view.findViewById(C5419R.id.thread_settings_section_slow_mode);
                                    if (linearLayout3 != null) {
                                        i = C5419R.id.thread_settings_slow_mode_cooldown_label;
                                        TextView textView2 = (TextView) view.findViewById(C5419R.id.thread_settings_slow_mode_cooldown_label);
                                        if (textView2 != null) {
                                            i = C5419R.id.thread_settings_slow_mode_cooldown_slider;
                                            SeekBar seekBar = (SeekBar) view.findViewById(C5419R.id.thread_settings_slow_mode_cooldown_slider);
                                            if (seekBar != null) {
                                                i = C5419R.id.thread_settings_slowmode_label;
                                                TextView textView3 = (TextView) view.findViewById(C5419R.id.thread_settings_slowmode_label);
                                                if (textView3 != null) {
                                                    return new WidgetThreadSettingsBinding((CoordinatorLayout) view, textView, linearLayout, viewFindViewById, nestedScrollView, textInputLayout, linearLayout2, floatingActionButton, linearLayout3, textView2, seekBar, textView3);
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
