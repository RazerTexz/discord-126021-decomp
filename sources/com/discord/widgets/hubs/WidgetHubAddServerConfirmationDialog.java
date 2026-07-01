package com.discord.widgets.hubs;

import android.content.Context;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppDialog;
import com.discord.databinding.HubAddServerConfirmationDialogBinding;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreStream;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.g;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetHubAddServerConfirmationDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubAddServerConfirmationDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetHubAddServerConfirmationDialog.class, "binding", "getBinding()Lcom/discord/databinding/HubAddServerConfirmationDialogBinding;", 0)};
    public static final WidgetHubAddServerConfirmationDialog$Companion Companion = new WidgetHubAddServerConfirmationDialog$Companion(null);

    /* JADX INFO: renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    public WidgetHubAddServerConfirmationDialog() {
        super(R$layout.hub_add_server_confirmation_dialog);
        this.args = g.lazy(new WidgetHubAddServerConfirmationDialog$$special$$inlined$args$1(this, "intent_args_key"));
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetHubAddServerConfirmationDialog$binding$2.INSTANCE, null, 2, null);
    }

    private final AddServerConfirmationArgs getArgs() {
        return (AddServerConfirmationArgs) this.args.getValue();
    }

    private final HubAddServerConfirmationDialogBinding getBinding() {
        return (HubAddServerConfirmationDialogBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        requireDialog().setCanceledOnTouchOutside(true);
        getBinding().d.setOnClickListener(new WidgetHubAddServerConfirmationDialog$onViewBoundOrOnResume$1(this));
        TextView textView = getBinding().f2125b;
        m.checkNotNullExpressionValue(textView, "binding.addServerConfirmationDialogDescription");
        Context contextRequireContext = requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        b.a(textView, b.h(contextRequireContext, 2131891742, new Object[]{getArgs().getHubName()}, null, 4));
        getBinding().c.b();
        Guild guild = StoreStream.Companion.getGuilds().getGuild(getArgs().getGuildId());
        if (guild != null) {
            getBinding().c.a(IconUtils.getForGuild$default(Long.valueOf(guild.getId()), guild.getIcon(), null, false, null, 28, null), guild.getShortName());
        }
    }
}
