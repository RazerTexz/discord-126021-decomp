package com.discord.widgets.user.usersheet;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.a;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreNotices$Notice;
import com.discord.stores.StoreStream;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: WidgetUserSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserSheet$Companion {
    private WidgetUserSheet$Companion() {
    }

    public static /* synthetic */ void enqueueNotice$default(WidgetUserSheet$Companion widgetUserSheet$Companion, long j, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        widgetUserSheet$Companion.enqueueNotice(j, str);
    }

    private final String getNoticeName(long userId) {
        String str = "User Sheet Notice for user ID: " + userId;
        m.checkNotNullExpressionValue(str, "StringBuilder(\"User Shee…)\n            .toString()");
        return str;
    }

    public static /* synthetic */ void show$default(WidgetUserSheet$Companion widgetUserSheet$Companion, long j, Long l, FragmentManager fragmentManager, Long l2, Boolean bool, WidgetUserSheet$StreamPreviewClickBehavior widgetUserSheet$StreamPreviewClickBehavior, String str, int i, Object obj) {
        widgetUserSheet$Companion.show(j, (i & 2) != 0 ? null : l, fragmentManager, (i & 8) != 0 ? null : l2, (i & 16) != 0 ? null : bool, (i & 32) != 0 ? WidgetUserSheet$StreamPreviewClickBehavior.TARGET_AND_LAUNCH_SPECTATE : widgetUserSheet$StreamPreviewClickBehavior, (i & 64) != 0 ? null : str);
    }

    public final void enqueueNotice(long userId, String friendToken) {
        StoreNotices notices = StoreStream.Companion.getNotices();
        String noticeName = getNoticeName(userId);
        notices.requestToShow(new StoreNotices$Notice(noticeName, null, 0L, 0, false, null, 0L, false, 0L, new WidgetUserSheet$Companion$enqueueNotice$showUserSheetNotice$1(userId, friendToken, notices, noticeName), Opcodes.INVOKEVIRTUAL, null));
    }

    public final void show(long j, FragmentManager fragmentManager) {
        show$default(this, j, null, fragmentManager, null, null, null, null, 122, null);
    }

    public final void show(long j, Long l, FragmentManager fragmentManager) {
        show$default(this, j, l, fragmentManager, null, null, null, null, 120, null);
    }

    public final void show(long j, Long l, FragmentManager fragmentManager, Long l2) {
        show$default(this, j, l, fragmentManager, l2, null, null, null, 112, null);
    }

    public final void show(long j, Long l, FragmentManager fragmentManager, Long l2, Boolean bool) {
        show$default(this, j, l, fragmentManager, l2, bool, null, null, 96, null);
    }

    public final void show(long j, Long l, FragmentManager fragmentManager, Long l2, Boolean bool, WidgetUserSheet$StreamPreviewClickBehavior widgetUserSheet$StreamPreviewClickBehavior) {
        show$default(this, j, l, fragmentManager, l2, bool, widgetUserSheet$StreamPreviewClickBehavior, null, 64, null);
    }

    public final void show(long userId, Long channelId, FragmentManager fragmentManager, Long guildId, Boolean isVoiceContext, WidgetUserSheet$StreamPreviewClickBehavior streamPreviewClickBehavior, String friendToken) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        m.checkNotNullParameter(streamPreviewClickBehavior, "streamPreviewClickBehavior");
        WidgetUserSheet widgetUserSheet = new WidgetUserSheet();
        Bundle bundleT = a.T("ARG_USER_ID", userId);
        if (channelId != null) {
            bundleT.putLong("ARG_CHANNEL_ID", channelId.longValue());
        }
        if (friendToken != null) {
            bundleT.putString("ARG_FRIEND_TOKEN", friendToken);
        }
        if (guildId != null) {
            bundleT.putLong("ARG_GUILD_ID", guildId.longValue());
        }
        bundleT.putBoolean("ARG_IS_VOICE_CONTEXT", isVoiceContext != null ? isVoiceContext.booleanValue() : false);
        bundleT.putSerializable("ARG_STREAM_PREVIEW_CLICK_BEHAVIOR", streamPreviewClickBehavior);
        widgetUserSheet.setArguments(bundleT);
        widgetUserSheet.show(fragmentManager, WidgetUserSheet.class.getName());
    }

    public /* synthetic */ WidgetUserSheet$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
