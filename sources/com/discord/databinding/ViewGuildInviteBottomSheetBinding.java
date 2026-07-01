package com.discord.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.views.CheckedSetting;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class ViewGuildInviteBottomSheetBinding implements ViewBinding {

    @NonNull
    public final View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final Spinner f2190b;

    @NonNull
    public final RadioGroup c;

    @NonNull
    public final MaterialButton d;

    @NonNull
    public final RadioGroup e;

    @NonNull
    public final CheckedSetting f;

    public ViewGuildInviteBottomSheetBinding(@NonNull View view, @NonNull Spinner spinner, @NonNull RadioGroup radioGroup, @NonNull MaterialButton materialButton, @NonNull RadioGroup radioGroup2, @NonNull CheckedSetting checkedSetting) {
        this.a = view;
        this.f2190b = spinner;
        this.c = radioGroup;
        this.d = materialButton;
        this.e = radioGroup2;
        this.f = checkedSetting;
    }

    @NonNull
    public static ViewGuildInviteBottomSheetBinding a(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        layoutInflater.inflate(R$layout.view_guild_invite_bottom_sheet, viewGroup);
        int i = R$id.guild_invite_channel_spinner;
        Spinner spinner = (Spinner) viewGroup.findViewById(R$id.guild_invite_channel_spinner);
        if (spinner != null) {
            i = R$id.guild_invite_expires_after_radiogroup;
            RadioGroup radioGroup = (RadioGroup) viewGroup.findViewById(R$id.guild_invite_expires_after_radiogroup);
            if (radioGroup != null) {
                i = R$id.guild_invite_generate_link;
                MaterialButton materialButton = (MaterialButton) viewGroup.findViewById(R$id.guild_invite_generate_link);
                if (materialButton != null) {
                    i = R$id.guild_invite_max_uses_radiogroup;
                    RadioGroup radioGroup2 = (RadioGroup) viewGroup.findViewById(R$id.guild_invite_max_uses_radiogroup);
                    if (radioGroup2 != null) {
                        i = R$id.guild_invite_temporary_membership;
                        CheckedSetting checkedSetting = (CheckedSetting) viewGroup.findViewById(R$id.guild_invite_temporary_membership);
                        if (checkedSetting != null) {
                            return new ViewGuildInviteBottomSheetBinding(viewGroup, spinner, radioGroup, materialButton, radioGroup2, checkedSetting);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewGroup.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
