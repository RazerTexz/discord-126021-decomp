package com.discord.widgets.user;

import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppDialog;
import com.discord.databinding.WidgetKickUserBinding;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.z.d.m;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetKickUser.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetKickUser extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetKickUser.class, "binding", "getBinding()Lcom/discord/databinding/WidgetKickUserBinding;", 0)};
    public static final WidgetKickUser$Companion Companion = new WidgetKickUser$Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    public WidgetKickUser() {
        super(R$layout.widget_kick_user);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetKickUser$binding$2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ WidgetKickUserBinding access$getBinding$p(WidgetKickUser widgetKickUser) {
        return widgetKickUser.getBinding();
    }

    private final WidgetKickUserBinding getBinding() {
        return (WidgetKickUserBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public static final void launch(String str, long j, long j2, FragmentManager fragmentManager) {
        Companion.launch(str, j, j2, fragmentManager);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        String string = getArgumentsOrDefault().getString("com.discord.intent.extra.EXTRA_USER_NAME", "");
        long j = getArgumentsOrDefault().getLong("com.discord.intent.extra.EXTRA_GUILD_ID", -1L);
        long j2 = getArgumentsOrDefault().getLong("com.discord.intent.extra.EXTRA_USER_ID", -1L);
        TextView textView = getBinding().f;
        m.checkNotNullExpressionValue(textView, "binding.kickUserTitle");
        b.m(textView, 2131892504, new Object[0], new WidgetKickUser$onViewBoundOrOnResume$1(string));
        TextView textView2 = getBinding().f2481b;
        m.checkNotNullExpressionValue(textView2, "binding.kickUserBody");
        b.m(textView2, 2131892500, new Object[0], new WidgetKickUser$onViewBoundOrOnResume$2(string));
        getBinding().c.setOnClickListener(new WidgetKickUser$onViewBoundOrOnResume$3(this));
        getBinding().d.setOnClickListener(new WidgetKickUser$onViewBoundOrOnResume$4(this, j, j2, string));
    }
}
