package com.discord.widgets.servers;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetServerSettingsOverviewAfkTimeoutBinding;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.t.n;
import d0.z.d.m;
import java.util.List;
import java.util.Objects;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetServerSettingsOverview.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsOverview$AfkBottomSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetServerSettingsOverview$AfkBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsOverviewAfkTimeoutBinding;", 0)};

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    public WidgetServerSettingsOverview$AfkBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerSettingsOverview$AfkBottomSheet$binding$2.INSTANCE, null, 2, null);
    }

    private final WidgetServerSettingsOverviewAfkTimeoutBinding getBinding() {
        return (WidgetServerSettingsOverviewAfkTimeoutBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final List<TextView> getTimeouts() {
        TextView textView = getBinding().f2581b;
        m.checkNotNullExpressionValue(textView, "binding.serverSettingsOverviewAfkTimeout01");
        TextView textView2 = getBinding().c;
        m.checkNotNullExpressionValue(textView2, "binding.serverSettingsOverviewAfkTimeout05");
        TextView textView3 = getBinding().d;
        m.checkNotNullExpressionValue(textView3, "binding.serverSettingsOverviewAfkTimeout15");
        TextView textView4 = getBinding().e;
        m.checkNotNullExpressionValue(textView4, "binding.serverSettingsOverviewAfkTimeout30");
        TextView textView5 = getBinding().f;
        m.checkNotNullExpressionValue(textView5, "binding.serverSettingsOverviewAfkTimeout60");
        return n.listOf((Object[]) new TextView[]{textView, textView2, textView3, textView4, textView5});
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R$layout.widget_server_settings_overview_afk_timeout;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Fragment parentFragment = getParentFragment();
        if (!(parentFragment instanceof WidgetServerSettingsOverview)) {
            parentFragment = null;
        }
        WidgetServerSettingsOverview widgetServerSettingsOverview = (WidgetServerSettingsOverview) parentFragment;
        if (widgetServerSettingsOverview == null) {
            dismiss();
            return;
        }
        for (TextView textView : getTimeouts()) {
            Object tag = textView.getTag();
            Objects.requireNonNull(tag, "null cannot be cast to non-null type kotlin.String");
            int i = Integer.parseInt((String) tag);
            WidgetServerSettingsOverview$Model$Companion widgetServerSettingsOverview$Model$Companion = WidgetServerSettingsOverview$Model.Companion;
            Context context = textView.getContext();
            m.checkNotNullExpressionValue(context, "it.context");
            CharSequence afkTimeout = widgetServerSettingsOverview$Model$Companion.getAfkTimeout(context, i);
            textView.setText(afkTimeout);
            textView.setOnClickListener(new WidgetServerSettingsOverview$AfkBottomSheet$onViewCreated$$inlined$forEach$lambda$1(afkTimeout, i, this, widgetServerSettingsOverview));
        }
    }
}
