package com.discord.widgets.servers;

import android.view.View;
import android.widget.LinearLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetGuildTransferOwnershipBinding;
import com.discord.views.CheckedSetting;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetServerSettingsTransferOwnership.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsTransferOwnership$binding$2 extends C12236k implements Function1<View, WidgetGuildTransferOwnershipBinding> {
    public static final WidgetServerSettingsTransferOwnership$binding$2 INSTANCE = new WidgetServerSettingsTransferOwnership$binding$2();

    public WidgetServerSettingsTransferOwnership$binding$2() {
        super(1, WidgetGuildTransferOwnershipBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildTransferOwnershipBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetGuildTransferOwnershipBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.guild_transfer_ownership_acknowledge_check;
        CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(C5419R.id.guild_transfer_ownership_acknowledge_check);
        if (checkedSetting != null) {
            i = C5419R.id.guild_transfer_ownership_cancel;
            MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.guild_transfer_ownership_cancel);
            if (materialButton != null) {
                i = C5419R.id.guild_transfer_ownership_confirm;
                MaterialButton materialButton2 = (MaterialButton) view.findViewById(C5419R.id.guild_transfer_ownership_confirm);
                if (materialButton2 != null) {
                    i = C5419R.id.guild_transfer_ownership_mfa_code;
                    TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(C5419R.id.guild_transfer_ownership_mfa_code);
                    if (textInputLayout != null) {
                        i = C5419R.id.guild_transfer_ownership_mfa_wrap;
                        LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.guild_transfer_ownership_mfa_wrap);
                        if (linearLayout != null) {
                            return new WidgetGuildTransferOwnershipBinding((LinearLayout) view, checkedSetting, materialButton, materialButton2, textInputLayout, linearLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
