package com.discord.widgets.channels;

import android.content.Context;
import b.a.d.d0;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.domain.ModelNotificationSettings$ChannelOverride;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChannelSidebarActionsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSidebarActionsViewModel extends d0<WidgetChannelSidebarActionsViewModel$ViewState> {
    public static final WidgetChannelSidebarActionsViewModel$Companion Companion = new WidgetChannelSidebarActionsViewModel$Companion(null);

    public WidgetChannelSidebarActionsViewModel() {
        this(null, 1, null);
    }

    public /* synthetic */ WidgetChannelSidebarActionsViewModel(Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? WidgetChannelSidebarActionsViewModel$Companion.observeStoreState$default(Companion, null, null, null, null, null, null, 63, null) : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetChannelSidebarActionsViewModel widgetChannelSidebarActionsViewModel, WidgetChannelSidebarActionsViewModel$StoreState widgetChannelSidebarActionsViewModel$StoreState) {
        widgetChannelSidebarActionsViewModel.handleStoreState(widgetChannelSidebarActionsViewModel$StoreState);
    }

    private final void handleStoreState(WidgetChannelSidebarActionsViewModel$StoreState storeState) {
        ModelNotificationSettings$ChannelOverride channelOverride;
        List<ModelNotificationSettings$ChannelOverride> channelOverrides;
        Object next;
        ModelNotificationSettings$ChannelOverride modelNotificationSettings$ChannelOverride;
        if (m.areEqual(storeState, WidgetChannelSidebarActionsViewModel$StoreState$ChannelNotFound.INSTANCE)) {
            updateViewState(WidgetChannelSidebarActionsViewModel$ViewState$Uninitialized.INSTANCE);
            return;
        }
        if (!(storeState instanceof WidgetChannelSidebarActionsViewModel$StoreState$ChannelFound)) {
            throw new NoWhenBranchMatchedException();
        }
        WidgetChannelSidebarActionsViewModel$StoreState$ChannelFound widgetChannelSidebarActionsViewModel$StoreState$ChannelFound = (WidgetChannelSidebarActionsViewModel$StoreState$ChannelFound) storeState;
        boolean z2 = false;
        if (!ChannelUtils.B(widgetChannelSidebarActionsViewModel$StoreState$ChannelFound.getChannel())) {
            long id2 = widgetChannelSidebarActionsViewModel$StoreState$ChannelFound.getChannel().getId();
            long guildId = widgetChannelSidebarActionsViewModel$StoreState$ChannelFound.getChannel().getGuildId();
            ModelNotificationSettings guildNotificationSettings = widgetChannelSidebarActionsViewModel$StoreState$ChannelFound.getGuildNotificationSettings();
            boolean z3 = (guildNotificationSettings == null || (channelOverride = guildNotificationSettings.getChannelOverride(id2)) == null || !channelOverride.isMuted()) ? false : true;
            boolean disablePins = widgetChannelSidebarActionsViewModel$StoreState$ChannelFound.getDisablePins();
            boolean zH = ChannelUtils.H(widgetChannelSidebarActionsViewModel$StoreState$ChannelFound.getChannel());
            Channel parentChannel = widgetChannelSidebarActionsViewModel$StoreState$ChannelFound.getParentChannel();
            updateViewState(new WidgetChannelSidebarActionsViewModel$ViewState$Guild(id2, guildId, z3, false, disablePins, zH, parentChannel != null && ChannelUtils.q(parentChannel), ChannelUtils.q(widgetChannelSidebarActionsViewModel$StoreState$ChannelFound.getChannel()), ChannelUtils.o(widgetChannelSidebarActionsViewModel$StoreState$ChannelFound.getChannel())));
            return;
        }
        ModelNotificationSettings guildNotificationSettings2 = widgetChannelSidebarActionsViewModel$StoreState$ChannelFound.getGuildNotificationSettings();
        long id3 = widgetChannelSidebarActionsViewModel$StoreState$ChannelFound.getChannel().getId();
        if (guildNotificationSettings2 != null && (channelOverrides = guildNotificationSettings2.getChannelOverrides()) != null) {
            Iterator<T> it = channelOverrides.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    modelNotificationSettings$ChannelOverride = (ModelNotificationSettings$ChannelOverride) next;
                    m.checkNotNullExpressionValue(modelNotificationSettings$ChannelOverride, "channelOverride");
                }
            } while (!(modelNotificationSettings$ChannelOverride.getChannelId() == id3));
            ModelNotificationSettings$ChannelOverride modelNotificationSettings$ChannelOverride2 = (ModelNotificationSettings$ChannelOverride) next;
            if (modelNotificationSettings$ChannelOverride2 != null && modelNotificationSettings$ChannelOverride2.isMuted()) {
                z2 = true;
            }
        }
        updateViewState(new WidgetChannelSidebarActionsViewModel$ViewState$Private(widgetChannelSidebarActionsViewModel$StoreState$ChannelFound.getChannel().getId(), z2));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelSidebarActionsViewModel(Observable<WidgetChannelSidebarActionsViewModel$StoreState> observable) {
        super(WidgetChannelSidebarActionsViewModel$ViewState$Uninitialized.INSTANCE);
        m.checkNotNullParameter(observable, "storeStateObservable");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), WidgetChannelSidebarActionsViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetChannelSidebarActionsViewModel$1(this), 62, (Object) null);
    }
}
