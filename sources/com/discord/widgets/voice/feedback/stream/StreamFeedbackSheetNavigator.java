package com.discord.widgets.voice.feedback.stream;

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
import java.util.Random;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: StreamFeedbackSheetNavigator.kt */
/* JADX INFO: loaded from: classes.dex */
public final class StreamFeedbackSheetNavigator {
    public static final StreamFeedbackSheetNavigator INSTANCE = new StreamFeedbackSheetNavigator();
    private static final Random random = new Random();
    private static final Clock clock = ClockFactory.get();

    private StreamFeedbackSheetNavigator() {
    }

    public static final /* synthetic */ Clock access$getClock$p(StreamFeedbackSheetNavigator streamFeedbackSheetNavigator) {
        return clock;
    }

    public static final /* synthetic */ void access$show(StreamFeedbackSheetNavigator streamFeedbackSheetNavigator, FragmentManager fragmentManager, String str, String str2) {
        streamFeedbackSheetNavigator.show(fragmentManager, str, str2);
    }

    private final String getNoticeName(String streamKey) {
        return a.w("Stream feedback notice for streamKey: ", streamKey);
    }

    private final void show(FragmentManager fragmentManager, String streamKey, String mediaSessionId) {
        WidgetFeedbackSheet widgetFeedbackSheetNewInstance = WidgetFeedbackSheet.Companion.newInstance(WidgetFeedbackSheet$FeedbackType.STREAM);
        Bundle arguments = widgetFeedbackSheetNewInstance.getArguments();
        m.checkNotNull(arguments);
        arguments.putString(WidgetFeedbackSheet.ARG_STREAM_FEEDBACK_STREAM_KEY, streamKey);
        arguments.putString(WidgetFeedbackSheet.ARG_STREAM_FEEDBACK_MEDIA_SESSION_ID, mediaSessionId);
        widgetFeedbackSheetNewInstance.show(fragmentManager, WidgetFeedbackSheet.class.getName());
    }

    public final void enqueueNotice(String streamKey, String mediaSessionId, int triggerRateDenominator) {
        m.checkNotNullParameter(streamKey, "streamKey");
        if (triggerRateDenominator < 1 || random.nextInt(triggerRateDenominator) != 0) {
            return;
        }
        StoreNotices notices = StoreStream.Companion.getNotices();
        String noticeName = getNoticeName(streamKey);
        long jCurrentTimeMillis = clock.currentTimeMillis();
        notices.requestToShow(new StoreNotices$Notice(noticeName, null, jCurrentTimeMillis, 0, false, null, 0L, false, 0L, new StreamFeedbackSheetNavigator$enqueueNotice$showStreamFeedbackSheetNotice$1(jCurrentTimeMillis, streamKey, mediaSessionId, notices, noticeName), Opcodes.GETSTATIC, null));
    }
}
