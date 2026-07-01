package com.discord.widgets.guilds.invite;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;
import com.discord.R$id;
import com.discord.databinding.WidgetGuildInviteSettingsBinding;
import com.discord.views.CheckedSetting;
import com.google.android.material.button.MaterialButton;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildInviteSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildInviteSettings$binding$2 extends k implements Function1<View, WidgetGuildInviteSettingsBinding> {
    public static final WidgetGuildInviteSettings$binding$2 INSTANCE = new WidgetGuildInviteSettings$binding$2();

    public WidgetGuildInviteSettings$binding$2() {
        super(1, WidgetGuildInviteSettingsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildInviteSettingsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetGuildInviteSettingsBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGuildInviteSettingsBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.guild_invite_channel_spinner;
        Spinner spinner = (Spinner) view.findViewById(R$id.guild_invite_channel_spinner);
        if (spinner != null) {
            i = R$id.guild_invite_expires_after_radiogroup;
            RadioGroup radioGroup = (RadioGroup) view.findViewById(R$id.guild_invite_expires_after_radiogroup);
            if (radioGroup != null) {
                i = R$id.guild_invite_generate_link;
                MaterialButton materialButton = (MaterialButton) view.findViewById(R$id.guild_invite_generate_link);
                if (materialButton != null) {
                    i = R$id.guild_invite_max_uses_radiogroup;
                    RadioGroup radioGroup2 = (RadioGroup) view.findViewById(R$id.guild_invite_max_uses_radiogroup);
                    if (radioGroup2 != null) {
                        i = R$id.guild_invite_temporary_membership;
                        CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(R$id.guild_invite_temporary_membership);
                        if (checkedSetting != null) {
                            return new WidgetGuildInviteSettingsBinding((LinearLayout) view, spinner, radioGroup, materialButton, radioGroup2, checkedSetting);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
