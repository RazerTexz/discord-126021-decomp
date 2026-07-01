package com.discord.widgets.channels.list;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserGuildSettings;
import com.discord.widgets.settings.WidgetMuteSettingsSheet;
import com.discord.widgets.settings.WidgetMuteSettingsSheet$Companion;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelsListItemThreadActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListItemThreadActions$configureUI$2 extends o implements Function1<View, Unit> {
    public final /* synthetic */ WidgetChannelsListItemThreadActions$Model $this_configureUI;
    public final /* synthetic */ WidgetChannelsListItemThreadActions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelsListItemThreadActions$configureUI$2(WidgetChannelsListItemThreadActions widgetChannelsListItemThreadActions, WidgetChannelsListItemThreadActions$Model widgetChannelsListItemThreadActions$Model) {
        super(1);
        this.this$0 = widgetChannelsListItemThreadActions;
        this.$this_configureUI = widgetChannelsListItemThreadActions$Model;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "it");
        if (this.$this_configureUI.isMuted()) {
            StoreUserGuildSettings userGuildSettings = StoreStream.Companion.getUserGuildSettings();
            Context contextRequireContext = this.this$0.requireContext();
            m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            StoreUserGuildSettings.setChannelMuted$default(userGuildSettings, contextRequireContext, this.$this_configureUI.getChannel().getId(), false, null, 8, null);
            return;
        }
        WidgetMuteSettingsSheet$Companion widgetMuteSettingsSheet$Companion = WidgetMuteSettingsSheet.Companion;
        long id2 = this.$this_configureUI.getChannel().getId();
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        widgetMuteSettingsSheet$Companion.showForChannel(id2, parentFragmentManager);
    }
}
