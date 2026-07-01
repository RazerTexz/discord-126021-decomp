package com.discord.widgets.servers;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.databinding.WidgetServerSettingsChannelsSortFabMenuBinding;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.utilities.views.FloatingButtonMenuInitializer;
import com.discord.widgets.channels.WidgetCreateChannel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import d0.Tuples;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.functions.Action0;

/* JADX INFO: compiled from: WidgetServerSettingsChannelsFabMenuFragment.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsChannelsFabMenuFragment extends Fragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetServerSettingsChannelsFabMenuFragment.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsChannelsSortFabMenuBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";
    private static final String TAG = "channels fab menu";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private Action0 dismissHandler;

    /* JADX INFO: compiled from: WidgetServerSettingsChannelsFabMenuFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(long guildId, FragmentManager fragmentManager, Action0 dismissHandler) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(dismissHandler, "dismissHandler");
            WidgetServerSettingsChannelsFabMenuFragment widgetServerSettingsChannelsFabMenuFragment = new WidgetServerSettingsChannelsFabMenuFragment();
            Bundle bundle = new Bundle();
            bundle.putLong("INTENT_EXTRA_GUILD_ID", guildId);
            widgetServerSettingsChannelsFabMenuFragment.setArguments(bundle);
            widgetServerSettingsChannelsFabMenuFragment.dismissHandler = dismissHandler;
            fragmentManager.beginTransaction().setCustomAnimations(R.anim.anim_fade_in, R.anim.anim_fade_out).add(R.id.widget_server_settings_channels_container, widgetServerSettingsChannelsFabMenuFragment, WidgetServerSettingsChannelsFabMenuFragment.TAG).addToBackStack(WidgetServerSettingsChannelsFabMenuFragment.TAG).commit();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WidgetServerSettingsChannelsFabMenuFragment() {
        super(R.layout.widget_server_settings_channels_sort_fab_menu);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsChannelsFabMenuFragment2.INSTANCE, null, 2, null);
    }

    private final View.OnClickListener createListener(final View.OnClickListener onClickListener) {
        return new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsChannelsFabMenuFragment.createListener.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                View.OnClickListener onClickListener2 = onClickListener;
                if (onClickListener2 != null) {
                    onClickListener2.onClick(view);
                }
                WidgetServerSettingsChannelsFabMenuFragment.this.dismiss();
            }
        };
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
        INSTANCE.show(j, fragmentManager, action0);
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
        Intrinsics3.checkNotNullExpressionValue(binding, "binding");
        binding.a.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsChannelsFabMenuFragment.onResume.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetServerSettingsChannelsFabMenuFragment.this.dismiss();
            }
        });
        Bundle arguments = getArguments();
        final long j = arguments != null ? arguments.getLong("INTENT_EXTRA_GUILD_ID", 0L) : 0L;
        Context contextRequireContext = requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        FloatingButtonMenuInitializer floatingButtonMenuInitializer = new FloatingButtonMenuInitializer(contextRequireContext, Maps6.mapOf(Tuples.to(Integer.valueOf(R.id.fab_menu_add_category), createListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsChannelsFabMenuFragment.onResume.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetCreateChannel.Companion companion = WidgetCreateChannel.INSTANCE;
                Context contextRequireContext2 = WidgetServerSettingsChannelsFabMenuFragment.this.requireContext();
                Intrinsics3.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
                WidgetCreateChannel.Companion.show$default(companion, contextRequireContext2, j, 4, null, 8, null);
            }
        })), Tuples.to(Integer.valueOf(R.id.fab_menu_add_voice), createListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsChannelsFabMenuFragment.onResume.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetCreateChannel.Companion companion = WidgetCreateChannel.INSTANCE;
                Context contextRequireContext2 = WidgetServerSettingsChannelsFabMenuFragment.this.requireContext();
                Intrinsics3.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
                WidgetCreateChannel.Companion.show$default(companion, contextRequireContext2, j, 2, null, 8, null);
            }
        })), Tuples.to(Integer.valueOf(R.id.fab_menu_add_text), createListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsChannelsFabMenuFragment.onResume.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetCreateChannel.Companion companion = WidgetCreateChannel.INSTANCE;
                Context contextRequireContext2 = WidgetServerSettingsChannelsFabMenuFragment.this.requireContext();
                Intrinsics3.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
                WidgetCreateChannel.Companion.show$default(companion, contextRequireContext2, j, 0, null, 8, null);
            }
        })), Tuples.to(Integer.valueOf(R.id.fab_menu_main), createListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsChannelsFabMenuFragment.onResume.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
            }
        }))));
        TableLayout tableLayout = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(tableLayout, "binding.fabMenuTable");
        FloatingActionButton floatingActionButton = getBinding().f2552b;
        Intrinsics3.checkNotNullExpressionValue(floatingActionButton, "binding.fabMenuMainFab");
        floatingButtonMenuInitializer.initialize(tableLayout, floatingActionButton, new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsChannelsFabMenuFragment.onResume.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetServerSettingsChannelsFabMenuFragment.this.dismiss();
            }
        });
    }
}
