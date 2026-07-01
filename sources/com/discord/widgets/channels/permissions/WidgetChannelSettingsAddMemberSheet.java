package com.discord.widgets.channels.permissions;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentTransaction;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.permission.PermissionOverwrite$Type;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetChannelSettingsAddMemberSheetBinding;
import com.discord.stores.StoreStream;
import com.discord.utilities.channel.permissions.ChannelPermissionsAddMemberUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.g;
import d0.z.d.m;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: WidgetChannelSettingsAddMemberSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSettingsAddMemberSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetChannelSettingsAddMemberSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChannelSettingsAddMemberSheetBinding;", 0)};
    public static final WidgetChannelSettingsAddMemberSheet$Companion Companion = new WidgetChannelSettingsAddMemberSheet$Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: channelId$delegate, reason: from kotlin metadata */
    private final Lazy channelId;
    private WidgetChannelSettingsAddMemberFragment fragment;

    public WidgetChannelSettingsAddMemberSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetChannelSettingsAddMemberSheet$binding$2.INSTANCE, null, 2, null);
        this.channelId = g.lazy(new WidgetChannelSettingsAddMemberSheet$channelId$2(this));
    }

    public static final /* synthetic */ void access$addPermissionOverwrites(WidgetChannelSettingsAddMemberSheet widgetChannelSettingsAddMemberSheet) {
        widgetChannelSettingsAddMemberSheet.addPermissionOverwrites();
    }

    public static final /* synthetic */ void access$configureUI(WidgetChannelSettingsAddMemberSheet widgetChannelSettingsAddMemberSheet, Channel channel) {
        widgetChannelSettingsAddMemberSheet.configureUI(channel);
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetChannelSettingsAddMemberSheet widgetChannelSettingsAddMemberSheet) {
        return widgetChannelSettingsAddMemberSheet.getArgumentsOrDefault();
    }

    public static final /* synthetic */ WidgetChannelSettingsAddMemberSheetBinding access$getBinding$p(WidgetChannelSettingsAddMemberSheet widgetChannelSettingsAddMemberSheet) {
        return widgetChannelSettingsAddMemberSheet.getBinding();
    }

    private final void addPermissionOverwrites() {
        ChannelPermissionsAddMemberUtils channelPermissionsAddMemberUtils = ChannelPermissionsAddMemberUtils.INSTANCE;
        long channelId = getChannelId();
        WidgetChannelSettingsAddMemberFragment widgetChannelSettingsAddMemberFragment = this.fragment;
        if (widgetChannelSettingsAddMemberFragment == null) {
            m.throwUninitializedPropertyAccessException("fragment");
        }
        BehaviorSubject<Map<Long, PermissionOverwrite$Type>> selectedItemsSubject = widgetChannelSettingsAddMemberFragment.getSelectedItemsSubject();
        m.checkNotNullExpressionValue(selectedItemsSubject, "fragment.getSelectedItemsSubject()");
        Map<Long, PermissionOverwrite$Type> mapN0 = selectedItemsSubject.n0();
        m.checkNotNullExpressionValue(mapN0, "fragment.getSelectedItemsSubject().value");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(channelPermissionsAddMemberUtils.addPermissionOverwrites(channelId, mapN0, 20971536L), this, null, 2, null), WidgetChannelSettingsAddMemberSheet.class, getContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetChannelSettingsAddMemberSheet$addPermissionOverwrites$1(this), 60, (Object) null);
    }

    @SuppressLint({"SetTextI18n"})
    private final void configureUI(Channel channel) {
        TextView textView = getBinding().d;
        m.checkNotNullExpressionValue(textView, "binding.subtitle");
        Context contextRequireContext = requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        textView.setText(ChannelUtils.e(channel, contextRequireContext, false, 2));
        getBinding().f2272b.setOnClickListener(new WidgetChannelSettingsAddMemberSheet$configureUI$1(this));
    }

    private final WidgetChannelSettingsAddMemberSheetBinding getBinding() {
        return (WidgetChannelSettingsAddMemberSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getChannelId() {
        return ((Number) this.channelId.getValue()).longValue();
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R$layout.widget_channel_settings_add_member_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(StoreStream.Companion.getChannels().observeChannel(getChannelId()), this, null, 2, null), WidgetChannelSettingsAddMemberSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetChannelSettingsAddMemberSheet$onResume$1(this), 62, (Object) null);
        WidgetChannelSettingsAddMemberFragment widgetChannelSettingsAddMemberFragment = this.fragment;
        if (widgetChannelSettingsAddMemberFragment == null) {
            m.throwUninitializedPropertyAccessException("fragment");
        }
        BehaviorSubject<Map<Long, PermissionOverwrite$Type>> selectedItemsSubject = widgetChannelSettingsAddMemberFragment.getSelectedItemsSubject();
        m.checkNotNullExpressionValue(selectedItemsSubject, "fragment.getSelectedItemsSubject()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(selectedItemsSubject, this, null, 2, null), WidgetChannelSettingsAddMemberSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetChannelSettingsAddMemberSheet$onResume$2(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.fragment = WidgetChannelSettingsAddMemberFragment.Companion.create(getChannelId(), false);
        FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
        FragmentContainerView fragmentContainerView = getBinding().c;
        m.checkNotNullExpressionValue(fragmentContainerView, "binding.content");
        int id2 = fragmentContainerView.getId();
        WidgetChannelSettingsAddMemberFragment widgetChannelSettingsAddMemberFragment = this.fragment;
        if (widgetChannelSettingsAddMemberFragment == null) {
            m.throwUninitializedPropertyAccessException("fragment");
        }
        WidgetChannelSettingsAddMemberFragment widgetChannelSettingsAddMemberFragment2 = this.fragment;
        if (widgetChannelSettingsAddMemberFragment2 == null) {
            m.throwUninitializedPropertyAccessException("fragment");
        }
        fragmentTransactionBeginTransaction.replace(id2, widgetChannelSettingsAddMemberFragment, widgetChannelSettingsAddMemberFragment2.getClass().getSimpleName()).runOnCommit(new WidgetChannelSettingsAddMemberSheet$onViewCreated$1(this, view)).commit();
    }
}
