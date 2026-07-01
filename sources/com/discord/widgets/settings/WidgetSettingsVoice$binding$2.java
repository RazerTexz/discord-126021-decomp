package com.discord.widgets.settings;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R;
import com.discord.databinding.WidgetSettingsVoiceBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.CheckedSetting;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsVoice.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsVoice$binding$2 extends FunctionReferenceImpl implements Function1<View, WidgetSettingsVoiceBinding> {
    public static final WidgetSettingsVoice$binding$2 INSTANCE = new WidgetSettingsVoice$binding$2();

    public WidgetSettingsVoice$binding$2() {
        super(1, WidgetSettingsVoiceBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsVoiceBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetSettingsVoiceBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.settings_voice_auto_vad_toggle;
        CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(R.id.settings_voice_auto_vad_toggle);
        if (checkedSetting != null) {
            i = R.id.settings_voice_echo_cancellation_toggle;
            CheckedSetting checkedSetting2 = (CheckedSetting) view.findViewById(R.id.settings_voice_echo_cancellation_toggle);
            if (checkedSetting2 != null) {
                i = R.id.settings_voice_enable_hardware_scaling_toggle;
                CheckedSetting checkedSetting3 = (CheckedSetting) view.findViewById(R.id.settings_voice_enable_hardware_scaling_toggle);
                if (checkedSetting3 != null) {
                    i = R.id.settings_voice_gain_control_toggle;
                    CheckedSetting checkedSetting4 = (CheckedSetting) view.findViewById(R.id.settings_voice_gain_control_toggle);
                    if (checkedSetting4 != null) {
                        i = R.id.settings_voice_input_header;
                        TextView textView = (TextView) view.findViewById(R.id.settings_voice_input_header);
                        if (textView != null) {
                            i = R.id.settings_voice_krisp_info;
                            TextView textView2 = (TextView) view.findViewById(R.id.settings_voice_krisp_info);
                            if (textView2 != null) {
                                i = R.id.settings_voice_krisp_vad_toggle;
                                CheckedSetting checkedSetting5 = (CheckedSetting) view.findViewById(R.id.settings_voice_krisp_vad_toggle);
                                if (checkedSetting5 != null) {
                                    i = R.id.settings_voice_mode;
                                    RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.settings_voice_mode);
                                    if (relativeLayout != null) {
                                        i = R.id.settings_voice_mode_header;
                                        TextView textView3 = (TextView) view.findViewById(R.id.settings_voice_mode_header);
                                        if (textView3 != null) {
                                            i = R.id.settings_voice_mode_value;
                                            TextView textView4 = (TextView) view.findViewById(R.id.settings_voice_mode_value);
                                            if (textView4 != null) {
                                                i = R.id.settings_voice_noise_cancellation_toggle;
                                                CheckedSetting checkedSetting6 = (CheckedSetting) view.findViewById(R.id.settings_voice_noise_cancellation_toggle);
                                                if (checkedSetting6 != null) {
                                                    i = R.id.settings_voice_noise_suppression_toggle;
                                                    CheckedSetting checkedSetting7 = (CheckedSetting) view.findViewById(R.id.settings_voice_noise_suppression_toggle);
                                                    if (checkedSetting7 != null) {
                                                        i = R.id.settings_voice_opensl_header;
                                                        TextView textView5 = (TextView) view.findViewById(R.id.settings_voice_opensl_header);
                                                        if (textView5 != null) {
                                                            i = R.id.settings_voice_opensles_default;
                                                            CheckedSetting checkedSetting8 = (CheckedSetting) view.findViewById(R.id.settings_voice_opensles_default);
                                                            if (checkedSetting8 != null) {
                                                                i = R.id.settings_voice_opensles_force_disabled;
                                                                CheckedSetting checkedSetting9 = (CheckedSetting) view.findViewById(R.id.settings_voice_opensles_force_disabled);
                                                                if (checkedSetting9 != null) {
                                                                    i = R.id.settings_voice_opensles_force_enabled;
                                                                    CheckedSetting checkedSetting10 = (CheckedSetting) view.findViewById(R.id.settings_voice_opensles_force_enabled);
                                                                    if (checkedSetting10 != null) {
                                                                        i = R.id.settings_voice_opensles_help;
                                                                        TextView textView6 = (TextView) view.findViewById(R.id.settings_voice_opensles_help);
                                                                        if (textView6 != null) {
                                                                            i = R.id.settings_voice_output_header;
                                                                            TextView textView7 = (TextView) view.findViewById(R.id.settings_voice_output_header);
                                                                            if (textView7 != null) {
                                                                                i = R.id.settings_voice_output_volume;
                                                                                SeekBar seekBar = (SeekBar) view.findViewById(R.id.settings_voice_output_volume);
                                                                                if (seekBar != null) {
                                                                                    i = R.id.settings_voice_output_volume_wrap;
                                                                                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.settings_voice_output_volume_wrap);
                                                                                    if (linearLayout != null) {
                                                                                        i = R.id.settings_voice_overlay_header;
                                                                                        TextView textView8 = (TextView) view.findViewById(R.id.settings_voice_overlay_header);
                                                                                        if (textView8 != null) {
                                                                                            i = R.id.settings_voice_overlay_toggle;
                                                                                            CheckedSetting checkedSetting11 = (CheckedSetting) view.findViewById(R.id.settings_voice_overlay_toggle);
                                                                                            if (checkedSetting11 != null) {
                                                                                                i = R.id.settings_voice_processing_header;
                                                                                                TextView textView9 = (TextView) view.findViewById(R.id.settings_voice_processing_header);
                                                                                                if (textView9 != null) {
                                                                                                    i = R.id.settings_voice_sensitivity_automatic;
                                                                                                    View viewFindViewById = view.findViewById(R.id.settings_voice_sensitivity_automatic);
                                                                                                    if (viewFindViewById != null) {
                                                                                                        i = R.id.settings_voice_sensitivity_header;
                                                                                                        TextView textView10 = (TextView) view.findViewById(R.id.settings_voice_sensitivity_header);
                                                                                                        if (textView10 != null) {
                                                                                                            i = R.id.settings_voice_sensitivity_label;
                                                                                                            TextView textView11 = (TextView) view.findViewById(R.id.settings_voice_sensitivity_label);
                                                                                                            if (textView11 != null) {
                                                                                                                i = R.id.settings_voice_sensitivity_manual;
                                                                                                                SeekBar seekBar2 = (SeekBar) view.findViewById(R.id.settings_voice_sensitivity_manual);
                                                                                                                if (seekBar2 != null) {
                                                                                                                    i = R.id.settings_voice_sensitivity_test_button;
                                                                                                                    MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.settings_voice_sensitivity_test_button);
                                                                                                                    if (materialButton != null) {
                                                                                                                        i = R.id.settings_voice_sensitivity_testing_container;
                                                                                                                        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.settings_voice_sensitivity_testing_container);
                                                                                                                        if (linearLayout2 != null) {
                                                                                                                            i = R.id.settings_voice_sensitivity_wrap;
                                                                                                                            RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.settings_voice_sensitivity_wrap);
                                                                                                                            if (relativeLayout2 != null) {
                                                                                                                                i = R.id.settings_voice_video_container;
                                                                                                                                LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.settings_voice_video_container);
                                                                                                                                if (linearLayout3 != null) {
                                                                                                                                    i = R.id.settings_voice_video_header;
                                                                                                                                    TextView textView12 = (TextView) view.findViewById(R.id.settings_voice_video_header);
                                                                                                                                    if (textView12 != null) {
                                                                                                                                        i = R.id.settings_voice_video_troubleshooting_guide;
                                                                                                                                        LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R.id.settings_voice_video_troubleshooting_guide);
                                                                                                                                        if (linkifiedTextView != null) {
                                                                                                                                            return new WidgetSettingsVoiceBinding((CoordinatorLayout) view, checkedSetting, checkedSetting2, checkedSetting3, checkedSetting4, textView, textView2, checkedSetting5, relativeLayout, textView3, textView4, checkedSetting6, checkedSetting7, textView5, checkedSetting8, checkedSetting9, checkedSetting10, textView6, textView7, seekBar, linearLayout, textView8, checkedSetting11, textView9, viewFindViewById, textView10, textView11, seekBar2, materialButton, linearLayout2, relativeLayout2, linearLayout3, textView12, linkifiedTextView);
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
