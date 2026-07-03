package com.discord.widgets.settings;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.discord.C5419R;
import com.discord.databinding.WidgetSettingsVoiceInputModeBinding;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetSettingsVoice.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsVoice$InputModeSelector$binding$2 extends C12236k implements Function1<View, WidgetSettingsVoiceInputModeBinding> {
    public static final WidgetSettingsVoice$InputModeSelector$binding$2 INSTANCE = new WidgetSettingsVoice$InputModeSelector$binding$2();

    public WidgetSettingsVoice$InputModeSelector$binding$2() {
        super(1, WidgetSettingsVoiceInputModeBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsVoiceInputModeBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetSettingsVoiceInputModeBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.guild_actions_overview_header_tv;
        TextView textView = (TextView) view.findViewById(C5419R.id.guild_actions_overview_header_tv);
        if (textView != null) {
            i = C5419R.id.settings_voice_input_mode_ptt;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.settings_voice_input_mode_ptt);
            if (linearLayout != null) {
                i = C5419R.id.settings_voice_input_mode_vad;
                LinearLayout linearLayout2 = (LinearLayout) view.findViewById(C5419R.id.settings_voice_input_mode_vad);
                if (linearLayout2 != null) {
                    return new WidgetSettingsVoiceInputModeBinding((NestedScrollView) view, textView, linearLayout, linearLayout2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
