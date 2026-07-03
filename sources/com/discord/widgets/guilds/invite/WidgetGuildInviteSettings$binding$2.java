package com.discord.widgets.guilds.invite;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;
import com.discord.C5419R;
import com.discord.databinding.WidgetGuildInviteSettingsBinding;
import com.discord.views.CheckedSetting;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetGuildInviteSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildInviteSettings$binding$2 extends C12236k implements Function1<View, WidgetGuildInviteSettingsBinding> {
    public static final WidgetGuildInviteSettings$binding$2 INSTANCE = new WidgetGuildInviteSettings$binding$2();

    public WidgetGuildInviteSettings$binding$2() {
        super(1, WidgetGuildInviteSettingsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildInviteSettingsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetGuildInviteSettingsBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.guild_invite_channel_spinner;
        Spinner spinner = (Spinner) view.findViewById(C5419R.id.guild_invite_channel_spinner);
        if (spinner != null) {
            i = C5419R.id.guild_invite_expires_after_radiogroup;
            RadioGroup radioGroup = (RadioGroup) view.findViewById(C5419R.id.guild_invite_expires_after_radiogroup);
            if (radioGroup != null) {
                i = C5419R.id.guild_invite_generate_link;
                MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.guild_invite_generate_link);
                if (materialButton != null) {
                    i = C5419R.id.guild_invite_max_uses_radiogroup;
                    RadioGroup radioGroup2 = (RadioGroup) view.findViewById(C5419R.id.guild_invite_max_uses_radiogroup);
                    if (radioGroup2 != null) {
                        i = C5419R.id.guild_invite_temporary_membership;
                        CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(C5419R.id.guild_invite_temporary_membership);
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
