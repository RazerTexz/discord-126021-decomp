package com.discord.widgets.channels.settings;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import com.discord.R;
import com.discord.databinding.WidgetTextChannelSettingsBinding;
import com.discord.databinding.WidgetThreadArchiveActionsSheetBinding;
import com.discord.views.CheckedSetting;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.channels.settings.WidgetTextChannelSettings$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetTextChannelSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetTextChannelSettings3 extends FunctionReferenceImpl implements Function1<View, WidgetTextChannelSettingsBinding> {
    public static final WidgetTextChannelSettings3 INSTANCE = new WidgetTextChannelSettings3();

    public WidgetTextChannelSettings3() {
        super(1, WidgetTextChannelSettingsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetTextChannelSettingsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetTextChannelSettingsBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.channel_settings_announcement;
        CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(R.id.channel_settings_announcement);
        if (checkedSetting != null) {
            i = R.id.channel_settings_edit_name;
            TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.channel_settings_edit_name);
            if (textInputLayout != null) {
                i = R.id.channel_settings_edit_topic;
                TextInputLayout textInputLayout2 = (TextInputLayout) view.findViewById(R.id.channel_settings_edit_topic);
                if (textInputLayout2 != null) {
                    i = R.id.channel_settings_edit_wrap;
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.channel_settings_edit_wrap);
                    if (linearLayout != null) {
                        i = R.id.channel_settings_nsfw;
                        CheckedSetting checkedSetting2 = (CheckedSetting) view.findViewById(R.id.channel_settings_nsfw);
                        if (checkedSetting2 != null) {
                            i = R.id.channel_settings_permissions;
                            TextView textView = (TextView) view.findViewById(R.id.channel_settings_permissions);
                            if (textView != null) {
                                i = R.id.channel_settings_pinned_messages;
                                TextView textView2 = (TextView) view.findViewById(R.id.channel_settings_pinned_messages);
                                if (textView2 != null) {
                                    i = R.id.channel_settings_pinned_messages_container;
                                    LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.channel_settings_pinned_messages_container);
                                    if (linearLayout2 != null) {
                                        i = R.id.channel_settings_pinned_messages_disabled_overlay;
                                        View viewFindViewById = view.findViewById(R.id.channel_settings_pinned_messages_disabled_overlay);
                                        if (viewFindViewById != null) {
                                            i = R.id.channel_settings_save;
                                            FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R.id.channel_settings_save);
                                            if (floatingActionButton != null) {
                                                i = R.id.channel_settings_section_default_auto_archive_duration;
                                                LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.channel_settings_section_default_auto_archive_duration);
                                                if (linearLayout3 != null) {
                                                    i = R.id.channel_settings_section_privacy_safety;
                                                    LinearLayout linearLayout4 = (LinearLayout) view.findViewById(R.id.channel_settings_section_privacy_safety);
                                                    if (linearLayout4 != null) {
                                                        i = R.id.channel_settings_section_slow_mode;
                                                        LinearLayout linearLayout5 = (LinearLayout) view.findViewById(R.id.channel_settings_section_slow_mode);
                                                        if (linearLayout5 != null) {
                                                            i = R.id.channel_settings_section_user_management;
                                                            LinearLayout linearLayout6 = (LinearLayout) view.findViewById(R.id.channel_settings_section_user_management);
                                                            if (linearLayout6 != null) {
                                                                i = R.id.channel_settings_slow_mode_cooldown_label;
                                                                TextView textView3 = (TextView) view.findViewById(R.id.channel_settings_slow_mode_cooldown_label);
                                                                if (textView3 != null) {
                                                                    i = R.id.channel_settings_slow_mode_cooldown_slider;
                                                                    SeekBar seekBar = (SeekBar) view.findViewById(R.id.channel_settings_slow_mode_cooldown_slider);
                                                                    if (seekBar != null) {
                                                                        i = R.id.channel_settings_slowmode_label;
                                                                        TextView textView4 = (TextView) view.findViewById(R.id.channel_settings_slowmode_label);
                                                                        if (textView4 != null) {
                                                                            i = R.id.duration_selector;
                                                                            View viewFindViewById2 = view.findViewById(R.id.duration_selector);
                                                                            if (viewFindViewById2 != null) {
                                                                                WidgetThreadArchiveActionsSheetBinding widgetThreadArchiveActionsSheetBindingA = WidgetThreadArchiveActionsSheetBinding.a(viewFindViewById2);
                                                                                i = R.id.scroll_view;
                                                                                NestedScrollView nestedScrollView = (NestedScrollView) view.findViewById(R.id.scroll_view);
                                                                                if (nestedScrollView != null) {
                                                                                    return new WidgetTextChannelSettingsBinding((CoordinatorLayout) view, checkedSetting, textInputLayout, textInputLayout2, linearLayout, checkedSetting2, textView, textView2, linearLayout2, viewFindViewById, floatingActionButton, linearLayout3, linearLayout4, linearLayout5, linearLayout6, textView3, seekBar, textView4, widgetThreadArchiveActionsSheetBindingA, nestedScrollView);
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
