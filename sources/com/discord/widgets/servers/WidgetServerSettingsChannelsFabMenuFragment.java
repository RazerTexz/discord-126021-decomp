package com.discord.widgets.servers;

import android.content.Context;
import android.os.Bundle;
import android.view.View$OnClickListener;
import android.widget.TableLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.a;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.databinding.WidgetServerSettingsChannelsSortFabMenuBinding;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.utilities.views.FloatingButtonMenuInitializer;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import d0.o;
import d0.t.h0;
import d0.z.d.m;
import kotlin.reflect.KProperty;
import rx.functions.Action0;

/* JADX INFO: compiled from: WidgetServerSettingsChannelsFabMenuFragment.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsChannelsFabMenuFragment extends Fragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetServerSettingsChannelsFabMenuFragment.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsChannelsSortFabMenuBinding;", 0)};
    public static final WidgetServerSettingsChannelsFabMenuFragment$Companion Companion = new WidgetServerSettingsChannelsFabMenuFragment$Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";
    private static final String TAG = "channels fab menu";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private Action0 dismissHandler;

    public WidgetServerSettingsChannelsFabMenuFragment() {
        super(R$layout.widget_server_settings_channels_sort_fab_menu);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerSettingsChannelsFabMenuFragment$binding$2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$dismiss(WidgetServerSettingsChannelsFabMenuFragment widgetServerSettingsChannelsFabMenuFragment) {
        widgetServerSettingsChannelsFabMenuFragment.dismiss();
    }

    public static final /* synthetic */ Action0 access$getDismissHandler$p(WidgetServerSettingsChannelsFabMenuFragment widgetServerSettingsChannelsFabMenuFragment) {
        return widgetServerSettingsChannelsFabMenuFragment.dismissHandler;
    }

    public static final /* synthetic */ void access$setDismissHandler$p(WidgetServerSettingsChannelsFabMenuFragment widgetServerSettingsChannelsFabMenuFragment, Action0 action0) {
        widgetServerSettingsChannelsFabMenuFragment.dismissHandler = action0;
    }

    private final View$OnClickListener createListener(View$OnClickListener onClickListener) {
        return new WidgetServerSettingsChannelsFabMenuFragment$createListener$1(this, onClickListener);
    }

    private final void dismiss() {
        getParentFragmentManager().beginTransaction().remove(this).commit();
        Action0 action0 = this.dismissHandler;
        if (action0 != null) {
            action0.call();
        }
    }

    private final WidgetServerSettingsChannelsSortFabMenuBinding getBinding() {
        return (WidgetServerSettingsChannelsSortFabMenuBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public static final void show(long j, FragmentManager fragmentManager, Action0 action0) {
        Companion.show(j, fragmentManager, action0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        dismiss();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        WidgetServerSettingsChannelsSortFabMenuBinding binding = getBinding();
        m.checkNotNullExpressionValue(binding, "binding");
        binding.a.setOnClickListener(new WidgetServerSettingsChannelsFabMenuFragment$onResume$1(this));
        Bundle arguments = getArguments();
        long j = arguments != null ? arguments.getLong("INTENT_EXTRA_GUILD_ID", 0L) : 0L;
        Context contextRequireContext = requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        FloatingButtonMenuInitializer floatingButtonMenuInitializer = new FloatingButtonMenuInitializer(contextRequireContext, h0.mapOf(o.to(Integer.valueOf(R$id.fab_menu_add_category), createListener(new WidgetServerSettingsChannelsFabMenuFragment$onResume$2(this, j))), o.to(Integer.valueOf(R$id.fab_menu_add_voice), createListener(new WidgetServerSettingsChannelsFabMenuFragment$onResume$3(this, j))), o.to(Integer.valueOf(R$id.fab_menu_add_text), createListener(new WidgetServerSettingsChannelsFabMenuFragment$onResume$4(this, j))), o.to(Integer.valueOf(R$id.fab_menu_main), createListener(WidgetServerSettingsChannelsFabMenuFragment$onResume$5.INSTANCE))));
        TableLayout tableLayout = getBinding().c;
        m.checkNotNullExpressionValue(tableLayout, "binding.fabMenuTable");
        FloatingActionButton floatingActionButton = getBinding().f2552b;
        m.checkNotNullExpressionValue(floatingActionButton, "binding.fabMenuMainFab");
        floatingButtonMenuInitializer.initialize(tableLayout, floatingActionButton, new WidgetServerSettingsChannelsFabMenuFragment$onResume$6(this));
    }
}
