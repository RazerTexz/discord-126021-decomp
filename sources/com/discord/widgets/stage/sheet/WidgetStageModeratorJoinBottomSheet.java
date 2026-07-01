package com.discord.widgets.stage.sheet;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.api.channel.Channel;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetStageModeratorJoinBottomSheetBinding;
import com.discord.stores.StoreStream;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.g;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetStageModeratorJoinBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageModeratorJoinBottomSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetStageModeratorJoinBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetStageModeratorJoinBottomSheetBinding;", 0)};
    public static final WidgetStageModeratorJoinBottomSheet$Companion Companion = new WidgetStageModeratorJoinBottomSheet$Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: channelId$delegate, reason: from kotlin metadata */
    private final Lazy channelId;

    public WidgetStageModeratorJoinBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetStageModeratorJoinBottomSheet$binding$2.INSTANCE, null, 2, null);
        this.channelId = g.lazy(new WidgetStageModeratorJoinBottomSheet$channelId$2(this));
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetStageModeratorJoinBottomSheet widgetStageModeratorJoinBottomSheet) {
        return widgetStageModeratorJoinBottomSheet.getArgumentsOrDefault();
    }

    public static final /* synthetic */ void access$setSelfSpeaker(WidgetStageModeratorJoinBottomSheet widgetStageModeratorJoinBottomSheet) {
        widgetStageModeratorJoinBottomSheet.setSelfSpeaker();
    }

    private final WidgetStageModeratorJoinBottomSheetBinding getBinding() {
        return (WidgetStageModeratorJoinBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getChannelId() {
        return ((Number) this.channelId.getValue()).longValue();
    }

    private final void setSelfSpeaker() {
        Channel channel = StoreStream.Companion.getChannels().getChannel(getChannelId());
        if (channel != null) {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApiSerializeNulls().setMeSuppressed(channel, false), false, 1, null), this, null, 2, null), WidgetStageModeratorJoinBottomSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetStageModeratorJoinBottomSheet$setSelfSpeaker$1(this), 62, (Object) null);
        }
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R$layout.widget_stage_moderator_join_bottom_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getBinding().c.setOnClickListener(new WidgetStageModeratorJoinBottomSheet$onViewCreated$1(this));
        getBinding().f2656b.setOnClickListener(new WidgetStageModeratorJoinBottomSheet$onViewCreated$2(this));
    }
}
