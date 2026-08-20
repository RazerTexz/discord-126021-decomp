package com.discord.widgets.hubs;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.databinding.HubAddServerConfirmationDialogBinding;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreStream;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p027k.C1107b;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetHubAddServerConfirmationDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubAddServerConfirmationDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetHubAddServerConfirmationDialog.class, "binding", "getBinding()Lcom/discord/databinding/HubAddServerConfirmationDialogBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: compiled from: WidgetHubAddServerConfirmationDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public final WidgetHubAddServerConfirmationDialog show(FragmentManager fragmentManager, AddServerConfirmationArgs args) {
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            C12238m.checkNotNullParameter(args, "args");
            WidgetHubAddServerConfirmationDialog widgetHubAddServerConfirmationDialog = new WidgetHubAddServerConfirmationDialog();
            widgetHubAddServerConfirmationDialog.setArguments(C1460d.m514e2(args));
            widgetHubAddServerConfirmationDialog.show(fragmentManager, C12216a0.getOrCreateKotlinClass(WidgetHubAddServerConfirmationDialog.class).toString());
            return widgetHubAddServerConfirmationDialog;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WidgetHubAddServerConfirmationDialog() {
        super(C5419R.layout.hub_add_server_confirmation_dialog);
        this.args = C12083g.lazy(new WidgetHubAddServerConfirmationDialog$$special$$inlined$args$1(this, "intent_args_key"));
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
        getBinding().f15164d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.hubs.WidgetHubAddServerConfirmationDialog.onViewBoundOrOnResume.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetHubAddServerConfirmationDialog.this.dismiss();
            }
        });
        TextView textView = getBinding().f15162b;
        C12238m.checkNotNullExpressionValue(textView, "binding.addServerConfirmationDialogDescription");
        Context contextRequireContext = requireContext();
        C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        C1107b.m209a(textView, C1107b.m216h(contextRequireContext, C5419R.string.hub_add_server_confirmation_subtitle, new Object[]{getArgs().getHubName()}, null, 4));
        getBinding().f15163c.m8546b();
        Guild guild = StoreStream.INSTANCE.getGuilds().getGuild(getArgs().getGuildId());
        if (guild != null) {
            getBinding().f15163c.m8545a(IconUtils.getForGuild$default(Long.valueOf(guild.getId()), guild.getIcon(), null, false, null, 28, null), guild.getShortName());
        }
    }
}
