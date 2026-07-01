package com.discord.widgets.forums;

import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentManager;
import d0.o;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetForumGuidelinesBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetForumGuidelinesBottomSheet$Companion {
    private WidgetForumGuidelinesBottomSheet$Companion() {
    }

    public final void registerForResult(Fragment fragment, String requestKey, Function2<? super Long, ? super Long, Unit> onActionTaken) {
        m.checkNotNullParameter(fragment, "fragment");
        m.checkNotNullParameter(requestKey, "requestKey");
        m.checkNotNullParameter(onActionTaken, "onActionTaken");
        FragmentKt.setFragmentResultListener(fragment, requestKey, new WidgetForumGuidelinesBottomSheet$Companion$registerForResult$1(requestKey, onActionTaken));
    }

    public final void show(FragmentManager fragmentManager, long guildId, long parentChannelId, String requestKey) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        m.checkNotNullParameter(requestKey, "requestKey");
        ForumGuidelinesManager.INSTANCE.markGuidelinesSeen(parentChannelId);
        WidgetForumGuidelinesBottomSheet widgetForumGuidelinesBottomSheet = new WidgetForumGuidelinesBottomSheet();
        widgetForumGuidelinesBottomSheet.setArguments(BundleKt.bundleOf(o.to("com.discord.intent.extra.EXTRA_GUILD_ID", Long.valueOf(guildId)), o.to("com.discord.intent.extra.EXTRA_CHANNEL_ID", Long.valueOf(parentChannelId)), o.to("INTENT_EXTRA_REQUEST_KEY", requestKey)));
        widgetForumGuidelinesBottomSheet.show(fragmentManager, WidgetForumGuidelinesBottomSheet.class.getSimpleName());
    }

    public /* synthetic */ WidgetForumGuidelinesBottomSheet$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
