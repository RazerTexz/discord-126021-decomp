package com.discord.widgets.channels.settings;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import com.discord.R;
import com.discord.databinding.WidgetThreadSettingsBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.channels.settings.WidgetThreadSettings$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetThreadSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetThreadSettings2 extends FunctionReferenceImpl implements Function1<View, WidgetThreadSettingsBinding> {
    public static final WidgetThreadSettings2 INSTANCE = new WidgetThreadSettings2();

    public WidgetThreadSettings2() {
        super(1, WidgetThreadSettingsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetThreadSettingsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetThreadSettingsBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.channel_settings_pinned_messages;
        TextView textView = (TextView) view.findViewById(R.id.channel_settings_pinned_messages);
        if (textView != null) {
            i = R.id.channel_settings_pinned_messages_container;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.channel_settings_pinned_messages_container);
            if (linearLayout != null) {
                i = R.id.channel_settings_pinned_messages_disabled_overlay;
                View viewFindViewById = view.findViewById(R.id.channel_settings_pinned_messages_disabled_overlay);
                if (viewFindViewById != null) {
                    i = R.id.scroll_view;
                    NestedScrollView nestedScrollView = (NestedScrollView) view.findViewById(R.id.scroll_view);
                    if (nestedScrollView != null) {
                        i = R.id.thread_settings_edit_name;
                        TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.thread_settings_edit_name);
                        if (textInputLayout != null) {
                            i = R.id.thread_settings_edit_wrap;
                            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.thread_settings_edit_wrap);
                            if (linearLayout2 != null) {
                                i = R.id.thread_settings_save;
                                FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R.id.thread_settings_save);
                                if (floatingActionButton != null) {
                                    i = R.id.thread_settings_section_slow_mode;
                                    LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.thread_settings_section_slow_mode);
                                    if (linearLayout3 != null) {
                                        i = R.id.thread_settings_slow_mode_cooldown_label;
                                        TextView textView2 = (TextView) view.findViewById(R.id.thread_settings_slow_mode_cooldown_label);
                                        if (textView2 != null) {
                                            i = R.id.thread_settings_slow_mode_cooldown_slider;
                                            SeekBar seekBar = (SeekBar) view.findViewById(R.id.thread_settings_slow_mode_cooldown_slider);
                                            if (seekBar != null) {
                                                i = R.id.thread_settings_slowmode_label;
                                                TextView textView3 = (TextView) view.findViewById(R.id.thread_settings_slowmode_label);
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
