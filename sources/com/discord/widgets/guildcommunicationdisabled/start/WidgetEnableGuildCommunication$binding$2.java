package com.discord.widgets.guildcommunicationdisabled.start;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.R$id;
import com.discord.databinding.WidgetEnableGuildCommunicationBinding;
import com.google.android.material.button.MaterialButton;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetEnableGuildCommunication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetEnableGuildCommunication$binding$2 extends k implements Function1<View, WidgetEnableGuildCommunicationBinding> {
    public static final WidgetEnableGuildCommunication$binding$2 INSTANCE = new WidgetEnableGuildCommunication$binding$2();

    public WidgetEnableGuildCommunication$binding$2() {
        super(1, WidgetEnableGuildCommunicationBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetEnableGuildCommunicationBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetEnableGuildCommunicationBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetEnableGuildCommunicationBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.enable_communication_cancel;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R$id.enable_communication_cancel);
        if (materialButton != null) {
            i = R$id.enable_communication_confirm;
            MaterialButton materialButton2 = (MaterialButton) view.findViewById(R$id.enable_communication_confirm);
            if (materialButton2 != null) {
                i = R$id.enable_guild_communication_body;
                TextView textView = (TextView) view.findViewById(R$id.enable_guild_communication_body);
                if (textView != null) {
                    i = R$id.enable_guild_communication_body_help_text;
                    TextView textView2 = (TextView) view.findViewById(R$id.enable_guild_communication_body_help_text);
                    if (textView2 != null) {
                        i = R$id.end_time_out;
                        TextView textView3 = (TextView) view.findViewById(R$id.end_time_out);
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
