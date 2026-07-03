package com.discord.widgets.channels.permissions;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetChannelSettingsAddMemberSheetBinding;
import com.discord.stores.StoreStream;
import com.discord.utilities.channel.permissions.ChannelPermissionsAddMemberUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
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
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.C12116o;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;
import p658rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: WidgetChannelSettingsAddMemberSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSettingsAddMemberSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetChannelSettingsAddMemberSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChannelSettingsAddMemberSheetBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: channelId$delegate, reason: from kotlin metadata */
    private final Lazy channelId;
    private WidgetChannelSettingsAddMemberFragment fragment;

    /* JADX INFO: compiled from: WidgetChannelSettingsAddMemberSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, long channelId) {
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetChannelSettingsAddMemberSheet widgetChannelSettingsAddMemberSheet = new WidgetChannelSettingsAddMemberSheet();
            widgetChannelSettingsAddMemberSheet.setArguments(BundleKt.bundleOf(C12116o.m10073to("com.discord.intent.extra.EXTRA_CHANNEL_ID", Long.valueOf(channelId))));
            widgetChannelSettingsAddMemberSheet.show(fragmentManager, WidgetChannelSettingsAddMemberSheet.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsAddMemberSheet$addPermissionOverwrites$1 */
    /* JADX INFO: compiled from: WidgetChannelSettingsAddMemberSheet.kt */
    public static final class C75311 extends AbstractC12240o implements Function1<List<? extends Void>, Unit> {
        public C75311() {
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
            WidgetChannelSettingsAddMemberSheet.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsAddMemberSheet$onResume$1 */
    /* JADX INFO: compiled from: WidgetChannelSettingsAddMemberSheet.kt */
    public static final class C75331 extends AbstractC12240o implements Function1<Channel, Unit> {
        public C75331() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            if (channel == null) {
                WidgetChannelSettingsAddMemberSheet.this.dismiss();
            } else {
                WidgetChannelSettingsAddMemberSheet.this.configureUI(channel);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsAddMemberSheet$onResume$2 */
    /* JADX INFO: compiled from: WidgetChannelSettingsAddMemberSheet.kt */
    public static final class C75342 extends AbstractC12240o implements Function1<Map<Long, ? extends PermissionOverwrite.Type>, Unit> {
        public C75342() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Map<Long, ? extends PermissionOverwrite.Type> map) {
            invoke2(map);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Map<Long, ? extends PermissionOverwrite.Type> map) {
            TextView textView = WidgetChannelSettingsAddMemberSheet.this.getBinding().f15905b;
            C12238m.checkNotNullExpressionValue(textView, "binding.addButton");
            C12238m.checkNotNullExpressionValue(map, "selected");
            ViewExtensions.setEnabledAndAlpha$default(textView, !map.isEmpty(), 0.0f, 2, null);
        }
    }

    public WidgetChannelSettingsAddMemberSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetChannelSettingsAddMemberSheet$binding$2.INSTANCE, null, 2, null);
        this.channelId = C12083g.lazy(new WidgetChannelSettingsAddMemberSheet$channelId$2(this));
    }

    private final void addPermissionOverwrites() {
        ChannelPermissionsAddMemberUtils channelPermissionsAddMemberUtils = ChannelPermissionsAddMemberUtils.INSTANCE;
        long channelId = getChannelId();
        WidgetChannelSettingsAddMemberFragment widgetChannelSettingsAddMemberFragment = this.fragment;
        if (widgetChannelSettingsAddMemberFragment == null) {
            C12238m.throwUninitializedPropertyAccessException("fragment");
        }
        BehaviorSubject<Map<Long, PermissionOverwrite.Type>> selectedItemsSubject = widgetChannelSettingsAddMemberFragment.getSelectedItemsSubject();
        C12238m.checkNotNullExpressionValue(selectedItemsSubject, "fragment.getSelectedItemsSubject()");
        Map<Long, PermissionOverwrite.Type> mapM11132n0 = selectedItemsSubject.m11132n0();
        C12238m.checkNotNullExpressionValue(mapM11132n0, "fragment.getSelectedItemsSubject().value");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(channelPermissionsAddMemberUtils.addPermissionOverwrites(channelId, mapM11132n0, 20971536L), this, null, 2, null), (Class<?>) WidgetChannelSettingsAddMemberSheet.class, (58 & 2) != 0 ? null : getContext(), (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C75311());
    }

    @SuppressLint({"SetTextI18n"})
    private final void configureUI(Channel channel) {
        TextView textView = getBinding().f15907d;
        C12238m.checkNotNullExpressionValue(textView, "binding.subtitle");
        Context contextRequireContext = requireContext();
        C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        textView.setText(ChannelUtils.m7681e(channel, contextRequireContext, false, 2));
        getBinding().f15905b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.permissions.WidgetChannelSettingsAddMemberSheet.configureUI.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChannelSettingsAddMemberSheet.this.addPermissionOverwrites();
            }
        });
    }

    private final WidgetChannelSettingsAddMemberSheetBinding getBinding() {
        return (WidgetChannelSettingsAddMemberSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getChannelId() {
        return ((Number) this.channelId.getValue()).longValue();
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return C5419R.layout.widget_channel_settings_add_member_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(StoreStream.INSTANCE.getChannels().observeChannel(getChannelId()), this, null, 2, null), (Class<?>) WidgetChannelSettingsAddMemberSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C75331());
        WidgetChannelSettingsAddMemberFragment widgetChannelSettingsAddMemberFragment = this.fragment;
        if (widgetChannelSettingsAddMemberFragment == null) {
            C12238m.throwUninitializedPropertyAccessException("fragment");
        }
        BehaviorSubject<Map<Long, PermissionOverwrite.Type>> selectedItemsSubject = widgetChannelSettingsAddMemberFragment.getSelectedItemsSubject();
        C12238m.checkNotNullExpressionValue(selectedItemsSubject, "fragment.getSelectedItemsSubject()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(selectedItemsSubject, this, null, 2, null), (Class<?>) WidgetChannelSettingsAddMemberSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C75342());
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.fragment = WidgetChannelSettingsAddMemberFragment.INSTANCE.create(getChannelId(), false);
        FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
        FragmentContainerView fragmentContainerView = getBinding().f15906c;
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
        fragmentTransactionBeginTransaction.replace(id2, widgetChannelSettingsAddMemberFragment, widgetChannelSettingsAddMemberFragment2.getClass().getSimpleName()).runOnCommit(new Runnable() { // from class: com.discord.widgets.channels.permissions.WidgetChannelSettingsAddMemberSheet.onViewCreated.1
            @Override // java.lang.Runnable
            public final void run() {
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams != null) {
                    Resources resources = WidgetChannelSettingsAddMemberSheet.this.getResources();
                    C12238m.checkNotNullExpressionValue(resources, "resources");
                    layoutParams.height = (int) (((double) resources.getDisplayMetrics().heightPixels) * 0.9d);
                }
            }
        }).commit();
    }
}
