package com.discord.widgets.guilds.join;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.LayoutRes;
import androidx.fragment.app.Fragment;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetGuildJoinBinding;
import com.discord.stores.StoreInviteSettings;
import com.discord.utilities.intent.IntentUtils;
import com.discord.utilities.intent.IntentUtils$RouteBuilders;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetGuildJoin.kt */
/* JADX INFO: loaded from: classes2.dex */
public class WidgetGuildJoin extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetGuildJoin.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildJoinBinding;", 0)};
    public static final WidgetGuildJoin$Companion Companion = new WidgetGuildJoin$Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final LoggingConfig loggingConfig;

    public WidgetGuildJoin() {
        this(0, 1, null);
    }

    public WidgetGuildJoin(@LayoutRes int i) {
        super(i);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildJoin$binding$2.INSTANCE, null, 2, null);
        this.loggingConfig = new LoggingConfig(false, null, WidgetGuildJoin$loggingConfig$1.INSTANCE, 3);
    }

    public final WidgetGuildJoinBinding getBinding() {
        return (WidgetGuildJoinBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger$a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    public final void handleGuildJoin() {
        TextInputLayout textInputLayout = getBinding().c;
        m.checkNotNullExpressionValue(textInputLayout, "binding.guildJoinInvite");
        String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout);
        if (textOrEmpty.length() > 0) {
            Intent intentSelectInvite = IntentUtils$RouteBuilders.INSTANCE.selectInvite(textOrEmpty, StoreInviteSettings.LOCATION_JOIN);
            IntentUtils intentUtils = IntentUtils.INSTANCE;
            TextInputLayout textInputLayout2 = getBinding().c;
            m.checkNotNullExpressionValue(textInputLayout2, "binding.guildJoinInvite");
            Context context = textInputLayout2.getContext();
            m.checkNotNullExpressionValue(context, "binding.guildJoinInvite.context");
            IntentUtils.consumeRoutingIntent$default(intentUtils, intentSelectInvite, context, null, 4, null);
        }
    }

    @Override // com.discord.app.AppFragment
    @CallSuper
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        TextInputLayout textInputLayout = getBinding().c;
        m.checkNotNullExpressionValue(textInputLayout, "binding.guildJoinInvite");
        ViewExtensions.setOnImeActionDone$default(textInputLayout, false, new WidgetGuildJoin$onViewBound$1(this), 1, null);
        getBinding().f2423b.setOnClickListener(new WidgetGuildJoin$onViewBound$2(this));
    }

    public /* synthetic */ WidgetGuildJoin(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? R$layout.widget_guild_join : i);
    }
}
