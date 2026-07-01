package com.discord.widgets.servers.guild_role_subscription.edit_tier;

import android.app.Dialog;
import android.content.res.ColorStateList;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.core.os.Bundle2;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.databinding.DialogGuiildRoleSubscriptionConfirmationBinding;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.google.android.material.button.MaterialButton;
import d0.Tuples;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: GuildRoleSubscriptionConfirmationDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildRoleSubscriptionConfirmationDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(GuildRoleSubscriptionConfirmationDialog.class, "binding", "getBinding()Lcom/discord/databinding/DialogGuiildRoleSubscriptionConfirmationBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_CONFIRMATION_BUTTON_TEXT = "INTENT_EXTRA_CONFIRMATION_BUTTON_TEXT";
    private static final String INTENT_EXTRA_IS_DESTRUCTIVE_OPERATION = "INTENT_EXTRA_IS_DESTRUCTIVE_OPERATION";
    private static final String INTENT_EXTRA_SUBTITLE = "INTENT_EXTRA_SUBTITLE";
    private static final String INTENT_EXTRA_TITLE = "INTENT_EXTRA_TITLE";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private Function0<Unit> confirmCallback;

    /* JADX INFO: compiled from: GuildRoleSubscriptionConfirmationDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, String title, String subtitle, String confirmationButtonText, boolean isDestructiveOperation, Function0<Unit> confirmCallback) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(title, "title");
            Intrinsics3.checkNotNullParameter(subtitle, "subtitle");
            Intrinsics3.checkNotNullParameter(confirmationButtonText, "confirmationButtonText");
            Intrinsics3.checkNotNullParameter(confirmCallback, "confirmCallback");
            GuildRoleSubscriptionConfirmationDialog guildRoleSubscriptionConfirmationDialog = new GuildRoleSubscriptionConfirmationDialog();
            guildRoleSubscriptionConfirmationDialog.setConfirmCallback(confirmCallback);
            guildRoleSubscriptionConfirmationDialog.setArguments(Bundle2.bundleOf(Tuples.to(GuildRoleSubscriptionConfirmationDialog.INTENT_EXTRA_TITLE, title), Tuples.to(GuildRoleSubscriptionConfirmationDialog.INTENT_EXTRA_SUBTITLE, subtitle), Tuples.to(GuildRoleSubscriptionConfirmationDialog.INTENT_EXTRA_CONFIRMATION_BUTTON_TEXT, confirmationButtonText), Tuples.to(GuildRoleSubscriptionConfirmationDialog.INTENT_EXTRA_IS_DESTRUCTIVE_OPERATION, Boolean.valueOf(isDestructiveOperation))));
            guildRoleSubscriptionConfirmationDialog.show(fragmentManager, GuildRoleSubscriptionConfirmationDialog.class.getSimpleName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public GuildRoleSubscriptionConfirmationDialog() {
        super(R.layout.dialog_guiild_role_subscription_confirmation);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, GuildRoleSubscriptionConfirmationDialog2.INSTANCE, null, 2, null);
    }

    private final DialogGuiildRoleSubscriptionConfirmationBinding getBinding() {
        return (DialogGuiildRoleSubscriptionConfirmationBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final String getConfirmationButtonText() {
        String string = requireArguments().getString(INTENT_EXTRA_CONFIRMATION_BUTTON_TEXT, "");
        Intrinsics3.checkNotNullExpressionValue(string, "requireArguments().getSt…IRMATION_BUTTON_TEXT, \"\")");
        return string;
    }

    private final String getSubtitle() {
        String string = requireArguments().getString(INTENT_EXTRA_SUBTITLE, "");
        Intrinsics3.checkNotNullExpressionValue(string, "requireArguments().getSt…NTENT_EXTRA_SUBTITLE, \"\")");
        return string;
    }

    private final String getTitle() {
        String string = requireArguments().getString(INTENT_EXTRA_TITLE, "");
        Intrinsics3.checkNotNullExpressionValue(string, "requireArguments().getSt…g(INTENT_EXTRA_TITLE, \"\")");
        return string;
    }

    private final boolean isDestructiveOperation() {
        return requireArguments().getBoolean(INTENT_EXTRA_IS_DESTRUCTIVE_OPERATION);
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialogRequireDialog = requireDialog();
        Intrinsics3.checkNotNullExpressionValue(dialogRequireDialog, "requireDialog()");
        Window window = dialogRequireDialog.getWindow();
        if (window != null) {
            window.setLayout(-1, -2);
        }
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        if (this.confirmCallback == null) {
            dismiss();
            return;
        }
        requireDialog().setCanceledOnTouchOutside(true);
        getBinding().c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.guild_role_subscription.edit_tier.GuildRoleSubscriptionConfirmationDialog.onViewBound.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Function0 function0 = GuildRoleSubscriptionConfirmationDialog.this.confirmCallback;
                if (function0 != null) {
                }
                GuildRoleSubscriptionConfirmationDialog.this.dismiss();
            }
        });
        getBinding().f2094b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.guild_role_subscription.edit_tier.GuildRoleSubscriptionConfirmationDialog.onViewBound.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                GuildRoleSubscriptionConfirmationDialog.this.dismiss();
            }
        });
        TextView textView = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildRoleSubscriptionConfirmationTitle");
        textView.setText(getTitle());
        TextView textView2 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildRoleSubscriptionConfirmationSubtitle");
        textView2.setText(getSubtitle());
        if (isDestructiveOperation()) {
            MaterialButton materialButton = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(materialButton, "this");
            materialButton.setBackgroundTintList(ColorStateList.valueOf(ColorCompat.getColor(materialButton, R.color.uikit_btn_bg_color_selector_red)));
            materialButton.setTextColor(ColorCompat.getColor(materialButton, R.color.primary_100));
        }
        MaterialButton materialButton2 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.confirm");
        materialButton2.setText(getConfirmationButtonText());
    }

    public final void setConfirmCallback(Function0<Unit> callback) {
        Intrinsics3.checkNotNullParameter(callback, "callback");
        this.confirmCallback = callback;
    }
}
