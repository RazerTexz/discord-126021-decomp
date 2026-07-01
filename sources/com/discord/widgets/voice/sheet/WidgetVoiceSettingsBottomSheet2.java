package com.discord.widgets.voice.sheet;

import android.view.View;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.discord.R;
import com.discord.databinding.WidgetVoiceSettingsBottomSheetBinding;
import com.google.android.material.switchmaterial.SwitchMaterial;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheet$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetVoiceSettingsBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetVoiceSettingsBottomSheet2 extends FunctionReferenceImpl implements Function1<View, WidgetVoiceSettingsBottomSheetBinding> {
    public static final WidgetVoiceSettingsBottomSheet2 INSTANCE = new WidgetVoiceSettingsBottomSheet2();

    public WidgetVoiceSettingsBottomSheet2() {
        super(1, WidgetVoiceSettingsBottomSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetVoiceSettingsBottomSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetVoiceSettingsBottomSheetBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.voice_settings_events;
        TextView textView = (TextView) view.findViewById(R.id.voice_settings_events);
        if (textView != null) {
            i = R.id.voice_settings_invite;
            TextView textView2 = (TextView) view.findViewById(R.id.voice_settings_invite);
            if (textView2 != null) {
                i = R.id.voice_settings_noise_suppression;
                SwitchMaterial switchMaterial = (SwitchMaterial) view.findViewById(R.id.voice_settings_noise_suppression);
                if (switchMaterial != null) {
                    i = R.id.voice_settings_notifications;
                    TextView textView3 = (TextView) view.findViewById(R.id.voice_settings_notifications);
                    if (textView3 != null) {
                        i = R.id.voice_settings_report;
                        TextView textView4 = (TextView) view.findViewById(R.id.voice_settings_report);
                        if (textView4 != null) {
                            NestedScrollView nestedScrollView = (NestedScrollView) view;
                            i = R.id.voice_settings_stage_settings;
                            TextView textView5 = (TextView) view.findViewById(R.id.voice_settings_stage_settings);
                            if (textView5 != null) {
                                i = R.id.voice_settings_toggle_video_participants;
                                SwitchMaterial switchMaterial2 = (SwitchMaterial) view.findViewById(R.id.voice_settings_toggle_video_participants);
                                if (switchMaterial2 != null) {
                                    i = R.id.voice_settings_voice_settings;
                                    TextView textView6 = (TextView) view.findViewById(R.id.voice_settings_voice_settings);
                                    if (textView6 != null) {
                                        return new WidgetVoiceSettingsBottomSheetBinding(nestedScrollView, textView, textView2, switchMaterial, textView3, textView4, nestedScrollView, textView5, switchMaterial2, textView6);
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
