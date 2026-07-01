package com.discord.widgets.voice.settings;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R;
import com.discord.databinding.WidgetVoiceChannelSettingsBinding;
import com.discord.views.CheckedSetting;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.voice.settings.WidgetVoiceChannelSettings$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetVoiceChannelSettings.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetVoiceChannelSettings3 extends FunctionReferenceImpl implements Function1<View, WidgetVoiceChannelSettingsBinding> {
    public static final WidgetVoiceChannelSettings3 INSTANCE = new WidgetVoiceChannelSettings3();

    public WidgetVoiceChannelSettings3() {
        super(1, WidgetVoiceChannelSettingsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetVoiceChannelSettingsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetVoiceChannelSettingsBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.bitrate_divider;
        View viewFindViewById = view.findViewById(R.id.bitrate_divider);
        if (viewFindViewById != null) {
            i = R.id.bitrate_seekbar;
            SeekBar seekBar = (SeekBar) view.findViewById(R.id.bitrate_seekbar);
            if (seekBar != null) {
                i = R.id.bitrate_title;
                TextView textView = (TextView) view.findViewById(R.id.bitrate_title);
                if (textView != null) {
                    i = R.id.channel_settings_edit_name;
                    TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.channel_settings_edit_name);
                    if (textInputLayout != null) {
                        i = R.id.channel_settings_edit_topic;
                        TextInputLayout textInputLayout2 = (TextInputLayout) view.findViewById(R.id.channel_settings_edit_topic);
                        if (textInputLayout2 != null) {
                            i = R.id.channel_settings_nsfw;
                            CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(R.id.channel_settings_nsfw);
                            if (checkedSetting != null) {
                                i = R.id.channel_settings_permissions;
                                TextView textView2 = (TextView) view.findViewById(R.id.channel_settings_permissions);
                                if (textView2 != null) {
                                    i = R.id.channel_settings_region_override;
                                    TextView textView3 = (TextView) view.findViewById(R.id.channel_settings_region_override);
                                    if (textView3 != null) {
                                        i = R.id.channel_settings_region_override_container;
                                        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.channel_settings_region_override_container);
                                        if (linearLayout != null) {
                                            i = R.id.channel_settings_region_override_help;
                                            TextView textView4 = (TextView) view.findViewById(R.id.channel_settings_region_override_help);
                                            if (textView4 != null) {
                                                i = R.id.channel_settings_save;
                                                FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R.id.channel_settings_save);
                                                if (floatingActionButton != null) {
                                                    i = R.id.channel_settings_section_privacy_safety;
                                                    LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.channel_settings_section_privacy_safety);
                                                    if (linearLayout2 != null) {
                                                        i = R.id.channel_settings_section_user_management;
                                                        LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.channel_settings_section_user_management);
                                                        if (linearLayout3 != null) {
                                                            i = R.id.current_bitrate_display;
                                                            TextView textView5 = (TextView) view.findViewById(R.id.current_bitrate_display);
                                                            if (textView5 != null) {
                                                                i = R.id.current_user_limit_display;
                                                                TextView textView6 = (TextView) view.findViewById(R.id.current_user_limit_display);
                                                                if (textView6 != null) {
                                                                    i = R.id.region_override_divider;
                                                                    View viewFindViewById2 = view.findViewById(R.id.region_override_divider);
                                                                    if (viewFindViewById2 != null) {
                                                                        i = R.id.settings_bitrate;
                                                                        LinearLayout linearLayout4 = (LinearLayout) view.findViewById(R.id.settings_bitrate);
                                                                        if (linearLayout4 != null) {
                                                                            i = R.id.settings_bitrate_help;
                                                                            TextView textView7 = (TextView) view.findViewById(R.id.settings_bitrate_help);
                                                                            if (textView7 != null) {
                                                                                i = R.id.settings_user_limit;
                                                                                LinearLayout linearLayout5 = (LinearLayout) view.findViewById(R.id.settings_user_limit);
                                                                                if (linearLayout5 != null) {
                                                                                    i = R.id.settings_user_limit_help;
                                                                                    TextView textView8 = (TextView) view.findViewById(R.id.settings_user_limit_help);
                                                                                    if (textView8 != null) {
                                                                                        i = R.id.user_limit_divider;
                                                                                        View viewFindViewById3 = view.findViewById(R.id.user_limit_divider);
                                                                                        if (viewFindViewById3 != null) {
                                                                                            i = R.id.user_limit_seekbar;
                                                                                            SeekBar seekBar2 = (SeekBar) view.findViewById(R.id.user_limit_seekbar);
                                                                                            if (seekBar2 != null) {
                                                                                                i = R.id.user_limit_title;
                                                                                                TextView textView9 = (TextView) view.findViewById(R.id.user_limit_title);
                                                                                                if (textView9 != null) {
                                                                                                    return new WidgetVoiceChannelSettingsBinding((CoordinatorLayout) view, viewFindViewById, seekBar, textView, textInputLayout, textInputLayout2, checkedSetting, textView2, textView3, linearLayout, textView4, floatingActionButton, linearLayout2, linearLayout3, textView5, textView6, viewFindViewById2, linearLayout4, textView7, linearLayout5, textView8, viewFindViewById3, seekBar2, textView9);
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
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
