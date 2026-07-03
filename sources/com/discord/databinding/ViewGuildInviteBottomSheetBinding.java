package com.discord.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.C5419R;
import com.discord.views.CheckedSetting;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class ViewGuildInviteBottomSheetBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final View f15452a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final Spinner f15453b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final RadioGroup f15454c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final MaterialButton f15455d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final RadioGroup f15456e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final CheckedSetting f15457f;

    public ViewGuildInviteBottomSheetBinding(@NonNull View view, @NonNull Spinner spinner, @NonNull RadioGroup radioGroup, @NonNull MaterialButton materialButton, @NonNull RadioGroup radioGroup2, @NonNull CheckedSetting checkedSetting) {
        this.f15452a = view;
        this.f15453b = spinner;
        this.f15454c = radioGroup;
        this.f15455d = materialButton;
        this.f15456e = radioGroup2;
        this.f15457f = checkedSetting;
    }

    @NonNull
    /* JADX INFO: renamed from: a */
    public static ViewGuildInviteBottomSheetBinding m8395a(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        layoutInflater.inflate(C5419R.layout.view_guild_invite_bottom_sheet, viewGroup);
        int i = C5419R.id.guild_invite_channel_spinner;
        Spinner spinner = (Spinner) viewGroup.findViewById(C5419R.id.guild_invite_channel_spinner);
        if (spinner != null) {
            i = C5419R.id.guild_invite_expires_after_radiogroup;
            RadioGroup radioGroup = (RadioGroup) viewGroup.findViewById(C5419R.id.guild_invite_expires_after_radiogroup);
            if (radioGroup != null) {
                i = C5419R.id.guild_invite_generate_link;
                MaterialButton materialButton = (MaterialButton) viewGroup.findViewById(C5419R.id.guild_invite_generate_link);
                if (materialButton != null) {
                    i = C5419R.id.guild_invite_max_uses_radiogroup;
                    RadioGroup radioGroup2 = (RadioGroup) viewGroup.findViewById(C5419R.id.guild_invite_max_uses_radiogroup);
                    if (radioGroup2 != null) {
                        i = C5419R.id.guild_invite_temporary_membership;
                        CheckedSetting checkedSetting = (CheckedSetting) viewGroup.findViewById(C5419R.id.guild_invite_temporary_membership);
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
        return this.f15452a;
    }
}
