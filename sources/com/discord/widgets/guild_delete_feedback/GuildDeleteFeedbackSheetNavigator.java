package com.discord.widgets.guild_delete_feedback;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.widgets.feedback.WidgetFeedbackSheet;
import org.objectweb.asm.Opcodes;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        C12238m.checkNotNull(arguments);
        arguments.putLong(WidgetFeedbackSheet.ARG_GUILD_DELETE_FEEDBACK_GUILD_ID, guildId);
        widgetFeedbackSheetNewInstance.show(fragmentManager, WidgetFeedbackSheet.class.getName());
    }

    public final void enqueueNotice(long guildId) {
        StoreNotices notices = StoreStream.INSTANCE.getNotices();
        String strM877t = C1643a.m877t("Delete Guild Feedback for ", guildId);
        long jCurrentTimeMillis = clock.currentTimeMillis();
        notices.requestToShow(new StoreNotices.Notice(strM877t, null, jCurrentTimeMillis, 0, false, null, 0L, false, 0L, new C8419x14d241f4(jCurrentTimeMillis, guildId, notices, strM877t), Opcodes.GETSTATIC, null));
    }
}
