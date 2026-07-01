package com.discord.widgets.hubs;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.k.FormatUtils;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.databinding.HubAddServerConfirmationDialogBinding;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreStream;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetHubAddServerConfirmationDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubAddServerConfirmationDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetHubAddServerConfirmationDialog.class, "binding", "getBinding()Lcom/discord/databinding/HubAddServerConfirmationDialogBinding;", 0)};

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

        public final WidgetHubAddServerConfirmationDialog show(FragmentManager fragmentManager, WidgetHubAddServerConfirmationDialog2 args) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(args, "args");
            WidgetHubAddServerConfirmationDialog widgetHubAddServerConfirmationDialog = new WidgetHubAddServerConfirmationDialog();
            widgetHubAddServerConfirmationDialog.setArguments(AnimatableValueParser.e2(args));
            widgetHubAddServerConfirmationDialog.show(fragmentManager, Reflection2.getOrCreateKotlinClass(WidgetHubAddServerConfirmationDialog.class).toString());
            return widgetHubAddServerConfirmationDialog;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WidgetHubAddServerConfirmationDialog() {
        super(R.layout.hub_add_server_confirmation_dialog);
        this.args = LazyJVM.lazy(new WidgetHubAddServerConfirmationDialog$$special$$inlined$args$1(this, "intent_args_key"));
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetHubAddServerConfirmationDialog3.INSTANCE, null, 2, null);
    }

    private final WidgetHubAddServerConfirmationDialog2 getArgs() {
        return (WidgetHubAddServerConfirmationDialog2) this.args.getValue();
    }

    private final HubAddServerConfirmationDialogBinding getBinding() {
        return (HubAddServerConfirmationDialogBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        requireDialog().setCanceledOnTouchOutside(true);
        getBinding().d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.hubs.WidgetHubAddServerConfirmationDialog.onViewBoundOrOnResume.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetHubAddServerConfirmationDialog.this.dismiss();
            }
        });
        TextView textView = getBinding().f2125b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.addServerConfirmationDialogDescription");
        Context contextRequireContext = requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        FormatUtils.a(textView, FormatUtils.b(contextRequireContext, R.string.hub_add_server_confirmation_subtitle, new Object[]{getArgs().getHubName()}, (4 & 4) != 0 ? FormatUtils.b.j : null));
        getBinding().c.b();
        Guild guild = StoreStream.INSTANCE.getGuilds().getGuild(getArgs().getGuildId());
        if (guild != null) {
            getBinding().c.a(IconUtils.getForGuild$default(Long.valueOf(guild.getId()), guild.getIcon(), null, false, null, 28, null), guild.getShortName());
        }
    }
}
