package com.discord.widgets.channels.permissions;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentTransaction;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.app.AppFragment;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetCreateChannelAddMemberBinding;
import com.discord.stores.StoreStream;
import com.discord.utilities.channel.permissions.ChannelPermissionsAddMemberUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0870j;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;
import p658rx.functions.Action2;
import p658rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: WidgetCreateChannelAddMember.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetCreateChannelAddMember extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetCreateChannelAddMember.class, "binding", "getBinding()Lcom/discord/databinding/WidgetCreateChannelAddMemberBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: channelId$delegate, reason: from kotlin metadata */
    private final Lazy channelId;
    private WidgetChannelSettingsAddMemberFragment fragment;
    private final LoggingConfig loggingConfig;

    /* JADX INFO: compiled from: WidgetCreateChannelAddMember.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void create(Context context, long channelId) {
            C12238m.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
            C0870j.m156d(context, WidgetCreateChannelAddMember.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetCreateChannelAddMember$addPermissionOverwrites$1 */
    /* JADX INFO: compiled from: WidgetCreateChannelAddMember.kt */
    public static final class C75571 extends AbstractC12240o implements Function1<List<? extends Void>, Unit> {
        public C75571() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends Void> list) {
            invoke2((List<Void>) list);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<Void> list) {
            C12238m.checkNotNullParameter(list, "it");
            FragmentActivity fragmentActivityM95e = WidgetCreateChannelAddMember.this.m95e();
            if (fragmentActivityM95e != null) {
                fragmentActivityM95e.finish();
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetCreateChannelAddMember$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetCreateChannelAddMember.kt */
    public static final class C75581 extends AbstractC12240o implements Function1<Channel, Unit> {
        public C75581() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            WidgetCreateChannelAddMember.this.configureUI(channel);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetCreateChannelAddMember$onViewBound$2 */
    /* JADX INFO: compiled from: WidgetCreateChannelAddMember.kt */
    public static final class C75592 extends AbstractC12240o implements Function1<Map<Long, ? extends PermissionOverwrite.Type>, Unit> {
        public C75592() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Map<Long, ? extends PermissionOverwrite.Type> map) {
            invoke2(map);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(final Map<Long, ? extends PermissionOverwrite.Type> map) {
            AppFragment.setActionBarOptionsMenu$default(WidgetCreateChannelAddMember.this, C5419R.menu.menu_add_member_continue, new Action2<MenuItem, Context>() { // from class: com.discord.widgets.channels.permissions.WidgetCreateChannelAddMember.onViewBound.2.1
                @Override // p658rx.functions.Action2
                public final void call(MenuItem menuItem, Context context) {
                    C12238m.checkNotNullExpressionValue(menuItem, "menuItem");
                    if (menuItem.getItemId() != C5419R.id.menu_continue) {
                        return;
                    }
                    WidgetCreateChannelAddMember widgetCreateChannelAddMember = WidgetCreateChannelAddMember.this;
                    Map map2 = map;
                    C12238m.checkNotNullExpressionValue(map2, "selected");
                    widgetCreateChannelAddMember.addPermissionOverwrites(map2);
                }
            }, null, 4, null);
        }
    }

    public WidgetCreateChannelAddMember() {
        super(C5419R.layout.widget_create_channel_add_member);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetCreateChannelAddMember$binding$2.INSTANCE, null, 2, null);
        this.channelId = C12083g.lazy(new WidgetCreateChannelAddMember$channelId$2(this));
        this.loggingConfig = new LoggingConfig(false, null, WidgetCreateChannelAddMember$loggingConfig$1.INSTANCE, 3);
    }

    private final void addPermissionOverwrites(Map<Long, ? extends PermissionOverwrite.Type> selected) {
        if (!selected.isEmpty()) {
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ChannelPermissionsAddMemberUtils.INSTANCE.addPermissionOverwrites(getChannelId(), selected, 20971536L), this, null, 2, null), (Class<?>) WidgetCreateChannelAddMember.class, (58 & 2) != 0 ? null : getContext(), (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C75571());
        } else {
            FragmentActivity fragmentActivityM95e = m95e();
            if (fragmentActivityM95e != null) {
                fragmentActivityM95e.finish();
            }
        }
    }

    private final void configureUI(Channel channel) {
        if (channel != null) {
            setActionBarSubtitle(channel.getName());
            return;
        }
        FragmentActivity fragmentActivityM95e = m95e();
        if (fragmentActivityM95e != null) {
            fragmentActivityM95e.finish();
        }
    }

    private final WidgetCreateChannelAddMemberBinding getBinding() {
        return (WidgetCreateChannelAddMemberBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getChannelId() {
        return ((Number) this.channelId.getValue()).longValue();
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.InterfaceC5455a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        this.fragment = WidgetChannelSettingsAddMemberFragment.INSTANCE.create(getChannelId(), true);
        FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
        FragmentContainerView fragmentContainerView = getBinding().f16418b;
        C12238m.checkNotNullExpressionValue(fragmentContainerView, "binding.content");
        int id2 = fragmentContainerView.getId();
        WidgetChannelSettingsAddMemberFragment widgetChannelSettingsAddMemberFragment = this.fragment;
        if (widgetChannelSettingsAddMemberFragment == null) {
            C12238m.throwUninitializedPropertyAccessException("fragment");
        }
        WidgetChannelSettingsAddMemberFragment widgetChannelSettingsAddMemberFragment2 = this.fragment;
        if (widgetChannelSettingsAddMemberFragment2 == null) {
            C12238m.throwUninitializedPropertyAccessException("fragment");
        }
        fragmentTransactionBeginTransaction.replace(id2, widgetChannelSettingsAddMemberFragment, widgetChannelSettingsAddMemberFragment2.getClass().getSimpleName()).commit();
        setActionBarDisplayHomeAsUpEnabled(true);
        setActionBarTitle(C5419R.string.channel_permissions_add_moderator_title);
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(StoreStream.INSTANCE.getChannels().observeChannel(getChannelId()), this, null, 2, null), (Class<?>) WidgetCreateChannelAddMember.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C75581());
        WidgetChannelSettingsAddMemberFragment widgetChannelSettingsAddMemberFragment3 = this.fragment;
        if (widgetChannelSettingsAddMemberFragment3 == null) {
            C12238m.throwUninitializedPropertyAccessException("fragment");
        }
        BehaviorSubject<Map<Long, PermissionOverwrite.Type>> selectedItemsSubject = widgetChannelSettingsAddMemberFragment3.getSelectedItemsSubject();
        C12238m.checkNotNullExpressionValue(selectedItemsSubject, "fragment.getSelectedItemsSubject()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(selectedItemsSubject, this, null, 2, null), (Class<?>) WidgetCreateChannelAddMember.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C75592());
    }
}
