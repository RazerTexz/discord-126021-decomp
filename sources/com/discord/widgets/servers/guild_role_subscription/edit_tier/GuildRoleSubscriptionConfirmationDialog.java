package com.discord.widgets.servers.guild_role_subscription.edit_tier;

import android.app.Dialog;
import android.content.res.ColorStateList;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.databinding.DialogGuiildRoleSubscriptionConfirmationBinding;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.button.MaterialButton;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12116o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GuildRoleSubscriptionConfirmationDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildRoleSubscriptionConfirmationDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(GuildRoleSubscriptionConfirmationDialog.class, "binding", "getBinding()Lcom/discord/databinding/DialogGuiildRoleSubscriptionConfirmationBinding;", 0)};

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
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            C12238m.checkNotNullParameter(title, "title");
            C12238m.checkNotNullParameter(subtitle, "subtitle");
            C12238m.checkNotNullParameter(confirmationButtonText, "confirmationButtonText");
            C12238m.checkNotNullParameter(confirmCallback, "confirmCallback");
            GuildRoleSubscriptionConfirmationDialog guildRoleSubscriptionConfirmationDialog = new GuildRoleSubscriptionConfirmationDialog();
            guildRoleSubscriptionConfirmationDialog.setConfirmCallback(confirmCallback);
            guildRoleSubscriptionConfirmationDialog.setArguments(BundleKt.bundleOf(C12116o.m10073to(GuildRoleSubscriptionConfirmationDialog.INTENT_EXTRA_TITLE, title), C12116o.m10073to(GuildRoleSubscriptionConfirmationDialog.INTENT_EXTRA_SUBTITLE, subtitle), C12116o.m10073to(GuildRoleSubscriptionConfirmationDialog.INTENT_EXTRA_CONFIRMATION_BUTTON_TEXT, confirmationButtonText), C12116o.m10073to(GuildRoleSubscriptionConfirmationDialog.INTENT_EXTRA_IS_DESTRUCTIVE_OPERATION, Boolean.valueOf(isDestructiveOperation))));
            guildRoleSubscriptionConfirmationDialog.show(fragmentManager, GuildRoleSubscriptionConfirmationDialog.class.getSimpleName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public GuildRoleSubscriptionConfirmationDialog() {
        super(C5419R.layout.dialog_guiild_role_subscription_confirmation);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, GuildRoleSubscriptionConfirmationDialog$binding$2.INSTANCE, null, 2, null);
    }

    private final DialogGuiildRoleSubscriptionConfirmationBinding getBinding() {
        return (DialogGuiildRoleSubscriptionConfirmationBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final String getConfirmationButtonText() {
        String string = requireArguments().getString(INTENT_EXTRA_CONFIRMATION_BUTTON_TEXT, "");
        C12238m.checkNotNullExpressionValue(string, "requireArguments().getSt…IRMATION_BUTTON_TEXT, \"\")");
        return string;
    }

    private final String getSubtitle() {
        String string = requireArguments().getString(INTENT_EXTRA_SUBTITLE, "");
        C12238m.checkNotNullExpressionValue(string, "requireArguments().getSt…NTENT_EXTRA_SUBTITLE, \"\")");
        return string;
    }

    private final String getTitle() {
        String string = requireArguments().getString(INTENT_EXTRA_TITLE, "");
        C12238m.checkNotNullExpressionValue(string, "requireArguments().getSt…g(INTENT_EXTRA_TITLE, \"\")");
        return string;
    }

    private final boolean isDestructiveOperation() {
        return requireArguments().getBoolean(INTENT_EXTRA_IS_DESTRUCTIVE_OPERATION);
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialogRequireDialog = requireDialog();
        C12238m.checkNotNullExpressionValue(dialogRequireDialog, "requireDialog()");
        Window window = dialogRequireDialog.getWindow();
        if (window != null) {
            window.setLayout(-1, -2);
        }
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        if (this.confirmCallback == null) {
            dismiss();
            return;
        }
        requireDialog().setCanceledOnTouchOutside(true);
        getBinding().f15036c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.guild_role_subscription.edit_tier.GuildRoleSubscriptionConfirmationDialog.onViewBound.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Function0 function0 = GuildRoleSubscriptionConfirmationDialog.this.confirmCallback;
                if (function0 != null) {
                }
                GuildRoleSubscriptionConfirmationDialog.this.dismiss();
            }
        });
        getBinding().f15035b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.guild_role_subscription.edit_tier.GuildRoleSubscriptionConfirmationDialog.onViewBound.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                GuildRoleSubscriptionConfirmationDialog.this.dismiss();
            }
        });
        TextView textView = getBinding().f15038e;
        C12238m.checkNotNullExpressionValue(textView, "binding.guildRoleSubscriptionConfirmationTitle");
        textView.setText(getTitle());
        TextView textView2 = getBinding().f15037d;
        C12238m.checkNotNullExpressionValue(textView2, "binding.guildRoleSubscriptionConfirmationSubtitle");
        textView2.setText(getSubtitle());
        if (isDestructiveOperation()) {
            MaterialButton materialButton = getBinding().f15036c;
            C12238m.checkNotNullExpressionValue(materialButton, "this");
            materialButton.setBackgroundTintList(ColorStateList.valueOf(ColorCompat.getColor(materialButton, C5419R.color.uikit_btn_bg_color_selector_red)));
            materialButton.setTextColor(ColorCompat.getColor(materialButton, C5419R.color.primary_100));
        }
        MaterialButton materialButton2 = getBinding().f15036c;
        C12238m.checkNotNullExpressionValue(materialButton2, "binding.confirm");
        materialButton2.setText(getConfirmationButtonText());
    }

    public final void setConfirmCallback(Function0<Unit> callback) {
        C12238m.checkNotNullParameter(callback, "callback");
        this.confirmCallback = callback;
    }
}
