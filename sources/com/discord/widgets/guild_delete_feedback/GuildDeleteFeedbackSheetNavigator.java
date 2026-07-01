package com.discord.widgets.guild_delete_feedback;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.outline;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.widgets.feedback.WidgetFeedbackSheet;
import d0.z.d.Intrinsics3;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: GuildDeleteFeedbackSheetNavigator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildDeleteFeedbackSheetNavigator {
    public static final GuildDeleteFeedbackSheetNavigator INSTANCE = new GuildDeleteFeedbackSheetNavigator();
    private static final Clock clock = ClockFactory.get();

    private GuildDeleteFeedbackSheetNavigator() {
    }

    private final void show(FragmentManager fragmentManager, long guildId) {
        WidgetFeedbackSheet widgetFeedbackSheetNewInstance = WidgetFeedbackSheet.INSTANCE.newInstance(WidgetFeedbackSheet.FeedbackType.GUILD_DELETE);
        Bundle arguments = widgetFeedbackSheetNewInstance.getArguments();
        Intrinsics3.checkNotNull(arguments);
        arguments.putLong(WidgetFeedbackSheet.ARG_GUILD_DELETE_FEEDBACK_GUILD_ID, guildId);
        widgetFeedbackSheetNewInstance.show(fragmentManager, WidgetFeedbackSheet.class.getName());
    }

    public final void enqueueNotice(long guildId) {
        StoreNotices notices = StoreStream.INSTANCE.getNotices();
        String strT = outline.t("Delete Guild Feedback for ", guildId);
        long jCurrentTimeMillis = clock.currentTimeMillis();
        notices.requestToShow(new StoreNotices.Notice(strT, null, jCurrentTimeMillis, 0, false, null, 0L, false, 0L, new GuildDeleteFeedbackSheetNavigator2(jCurrentTimeMillis, guildId, notices, strT), Opcodes.GETSTATIC, null));
    }
}
