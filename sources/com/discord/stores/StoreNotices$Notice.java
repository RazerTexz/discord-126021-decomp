package com.discord.stores;

import androidx.annotation.MainThread;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.fragment.app.FragmentActivity;
import b.d.b.a.a;
import com.discord.app.AppComponent;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.widgets.home.WidgetHome;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen;
import d0.e0.c;
import d0.g0.w;
import d0.t.n;
import d0.z.d.a0;
import d0.z.d.m;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StoreNotices.kt */
/* JADX INFO: loaded from: classes2.dex */
public class StoreNotices$Notice {
    private final boolean autoMarkSeen;
    private final Clock clock;
    private final long delayPeriodMs;
    private boolean hasShown;
    private final String name;
    private final boolean persist;
    private final int priority;
    private final long requestedShowTimestamp;
    private final Function1<FragmentActivity, Boolean> show;
    private final long sinceLastPeriodMs;
    private final List<c<? extends AppComponent>> validScreens;

    /* JADX WARN: Multi-variable type inference failed */
    public StoreNotices$Notice(String str, Clock clock, long j, int i, boolean z2, List<? extends c<? extends AppComponent>> list, long j2, boolean z3, long j3, Function1<? super FragmentActivity, Boolean> function1) {
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        m.checkNotNullParameter(clock, "clock");
        m.checkNotNullParameter(function1, "show");
        this.name = str;
        this.clock = clock;
        this.requestedShowTimestamp = j;
        this.priority = i;
        this.persist = z2;
        this.validScreens = list;
        this.delayPeriodMs = j2;
        this.autoMarkSeen = z3;
        this.sinceLastPeriodMs = j3;
        this.show = function1;
    }

    public static /* synthetic */ void getHasShown$annotations() {
    }

    public boolean canShow(Long lastSeenMs) {
        return lastSeenMs == null || this.clock.currentTimeMillis() - lastSeenMs.longValue() > this.sinceLastPeriodMs;
    }

    public final boolean getAutoMarkSeen() {
        return this.autoMarkSeen;
    }

    public final Clock getClock() {
        return this.clock;
    }

    public final long getDelayPeriodMs() {
        return this.delayPeriodMs;
    }

    public final boolean getHasShown() {
        return this.hasShown;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean getPersist() {
        return this.persist;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final long getRequestedShowTimestamp() {
        return this.requestedShowTimestamp;
    }

    public final Function1<FragmentActivity, Boolean> getShow() {
        return this.show;
    }

    public final long getSinceLastPeriodMs() {
        return this.sinceLastPeriodMs;
    }

    public final List<c<? extends AppComponent>> getValidScreens() {
        return this.validScreens;
    }

    public final boolean isInAppNotification() {
        return w.contains((CharSequence) this.name, (CharSequence) StoreNotices.IN_APP_NOTICE_TAG, true);
    }

    public final boolean isPopup() {
        return w.contains((CharSequence) this.name, (CharSequence) StoreNotices.NOTICE_POPUP_TAG, true);
    }

    public final void setHasShown(boolean z2) {
        this.hasShown = z2;
    }

    public boolean shouldShow(Map<Integer, Long> lastShownTimes) {
        m.checkNotNullParameter(lastShownTimes, "lastShownTimes");
        Long l = lastShownTimes.get(Integer.valueOf(this.priority));
        return this.delayPeriodMs < this.clock.currentTimeMillis() - (l != null ? l.longValue() : 0L);
    }

    @MainThread
    public final boolean show(FragmentActivity activity) {
        m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        if (this.hasShown || activity.isFinishing()) {
            return false;
        }
        Boolean boolInvoke = this.show.invoke(activity);
        this.hasShown = boolInvoke.booleanValue();
        return boolInvoke.booleanValue();
    }

    public String toString() {
        StringBuilder sbU = a.U("Notice<");
        sbU.append(this.name);
        sbU.append(">(pri=");
        sbU.append(this.priority);
        sbU.append(", ts=");
        sbU.append(this.requestedShowTimestamp);
        sbU.append(')');
        return sbU.toString();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ StoreNotices$Notice(String str, Clock clock, long j, int i, boolean z2, List list, long j2, boolean z3, long j3, Function1 function1, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        Clock clock2 = (i2 & 2) != 0 ? ClockFactory.get() : clock;
        this(str, clock2, (i2 & 4) != 0 ? clock2.currentTimeMillis() : j, (i2 & 8) != 0 ? 10 : i, (i2 & 16) != 0 ? false : z2, (i2 & 32) != 0 ? n.listOf((Object[]) new c[]{a0.getOrCreateKotlinClass(WidgetHome.class), a0.getOrCreateKotlinClass(WidgetCallFullscreen.class)}) : list, (i2 & 64) != 0 ? 15000L : j2, (i2 & 128) != 0 ? false : z3, (i2 & 256) != 0 ? 31536000000L : j3, function1);
    }
}
