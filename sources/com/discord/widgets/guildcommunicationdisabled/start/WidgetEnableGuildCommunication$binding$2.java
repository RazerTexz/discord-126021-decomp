package com.discord.widgets.guildcommunicationdisabled.start;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.databinding.WidgetEnableGuildCommunicationBinding;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetEnableGuildCommunication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetEnableGuildCommunication$binding$2 extends C12236k implements Function1<View, WidgetEnableGuildCommunicationBinding> {
    public static final WidgetEnableGuildCommunication$binding$2 INSTANCE = new WidgetEnableGuildCommunication$binding$2();

    public WidgetEnableGuildCommunication$binding$2() {
        super(1, WidgetEnableGuildCommunicationBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetEnableGuildCommunicationBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetEnableGuildCommunicationBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.enable_communication_cancel;
        MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.enable_communication_cancel);
        if (materialButton != null) {
            i = C5419R.id.enable_communication_confirm;
            MaterialButton materialButton2 = (MaterialButton) view.findViewById(C5419R.id.enable_communication_confirm);
            if (materialButton2 != null) {
                i = C5419R.id.enable_guild_communication_body;
                TextView textView = (TextView) view.findViewById(C5419R.id.enable_guild_communication_body);
                if (textView != null) {
                    i = C5419R.id.enable_guild_communication_body_help_text;
                    TextView textView2 = (TextView) view.findViewById(C5419R.id.enable_guild_communication_body_help_text);
                    if (textView2 != null) {
                        i = C5419R.id.end_time_out;
                        TextView textView3 = (TextView) view.findViewById(C5419R.id.end_time_out);
                        if (textView3 != null) {
                            return new WidgetEnableGuildCommunicationBinding((LinearLayout) view, materialButton, materialButton2, textView, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
