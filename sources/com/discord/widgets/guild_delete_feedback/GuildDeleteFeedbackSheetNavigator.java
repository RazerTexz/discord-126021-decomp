package com.discord.widgets.guild_delete_feedback;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.a;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreNotices$Notice;
import com.discord.stores.StoreStream;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.widgets.feedback.WidgetFeedbackSheet;
import com.discord.widgets.feedback.WidgetFeedbackSheet$FeedbackType;
import d0.z.d.m;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: GuildDeleteFeedbackSheetNavigator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildDeleteFeedbackSheetNavigator {
    public static final GuildDeleteFeedbackSheetNavigator INSTANCE = new GuildDeleteFeedbackSheetNavigator();
    private static final Clock clock = ClockFactory.get();

    private GuildDeleteFeedbackSheetNavigator() {
    }

    public static final /* synthetic */ Clock access$getClock$p(GuildDeleteFeedbackSheetNavigator guildDeleteFeedbackSheetNavigator) {
        return clock;
    }

    public static final /* synthetic */ void access$show(GuildDeleteFeedbackSheetNavigator guildDeleteFeedbackSheetNavigator, FragmentManager fragmentManager, long j) {
        guildDeleteFeedbackSheetNavigator.show(fragmentManager, j);
    }

    private final void show(FragmentManager fragmentManager, long guildId) {
        WidgetFeedbackSheet widgetFeedbackSheetNewInstance = WidgetFeedbackSheet.Companion.newInstance(WidgetFeedbackSheet$FeedbackType.GUILD_DELETE);
        Bundle arguments = widgetFeedbackSheetNewInstance.getArguments();
        m.checkNotNull(arguments);
        arguments.putLong(WidgetFeedbackSheet.ARG_GUILD_DELETE_FEEDBACK_GUILD_ID, guildId);
        widgetFeedbackSheetNewInstance.show(fragmentManager, WidgetFeedbackSheet.class.getName());
    }

    public final void enqueueNotice(long guildId) {
        StoreNotices notices = StoreStream.Companion.getNotices();
        String strT = a.t("Delete Guild Feedback for ", guildId);
        long jCurrentTimeMillis = clock.currentTimeMillis();
        notices.requestToShow(new StoreNotices$Notice(strT, null, jCurrentTimeMillis, 0, false, null, 0L, false, 0L, new GuildDeleteFeedbackSheetNavigator$enqueueNotice$showFeedbackNotice$1(jCurrentTimeMillis, guildId, notices, strT), Opcodes.GETSTATIC, null));
    }
}
