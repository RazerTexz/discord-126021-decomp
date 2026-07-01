package com.discord.widgets.servers;

import android.view.View;
import android.widget.LinearLayout;
import com.discord.R;
import com.discord.databinding.WidgetGuildTransferOwnershipBinding;
import com.discord.views.CheckedSetting;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsTransferOwnership$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetServerSettingsTransferOwnership.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsTransferOwnership3 extends FunctionReferenceImpl implements Function1<View, WidgetGuildTransferOwnershipBinding> {
    public static final WidgetServerSettingsTransferOwnership3 INSTANCE = new WidgetServerSettingsTransferOwnership3();

    public WidgetServerSettingsTransferOwnership3() {
        super(1, WidgetGuildTransferOwnershipBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildTransferOwnershipBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetGuildTransferOwnershipBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.guild_transfer_ownership_acknowledge_check;
        CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(R.id.guild_transfer_ownership_acknowledge_check);
        if (checkedSetting != null) {
            i = R.id.guild_transfer_ownership_cancel;
            MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.guild_transfer_ownership_cancel);
            if (materialButton != null) {
                i = R.id.guild_transfer_ownership_confirm;
                MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.guild_transfer_ownership_confirm);
                if (materialButton2 != null) {
                    i = R.id.guild_transfer_ownership_mfa_code;
                    TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.guild_transfer_ownership_mfa_code);
                    if (textInputLayout != null) {
                        i = R.id.guild_transfer_ownership_mfa_wrap;
                        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.guild_transfer_ownership_mfa_wrap);
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
