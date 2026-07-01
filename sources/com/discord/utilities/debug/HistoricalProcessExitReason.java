package com.discord.utilities.debug;

import android.app.ActivityManager;
import android.app.ApplicationExitInfo;
import android.os.Build$VERSION;
import androidx.appcompat.widget.ActivityChooserModel;
import b.d.b.a.a;
import com.discord.utilities.lifecycle.ApplicationProvider;
import d0.g;
import d0.o;
import d0.t.h0;
import d0.t.u;
import d0.z.d.m;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;

/* JADX INFO: compiled from: HistoricalProcessExitReason.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class HistoricalProcessExitReason {
    public static final HistoricalProcessExitReason INSTANCE = new HistoricalProcessExitReason();

    /* JADX INFO: renamed from: lastReason$delegate, reason: from kotlin metadata */
    private static final Lazy lastReason = g.lazy(HistoricalProcessExitReason$lastReason$2.INSTANCE);

    private HistoricalProcessExitReason() {
    }

    public static final /* synthetic */ HistoricalProcessExitReason$Reason access$createLastReason(HistoricalProcessExitReason historicalProcessExitReason) {
        return historicalProcessExitReason.createLastReason();
    }

    private final HistoricalProcessExitReason$Reason createLastReason() {
        HistoricalProcessExitReason$Reason historicalProcessExitReason$Reason = null;
        if (Build$VERSION.SDK_INT < 30) {
            return null;
        }
        Map mapMapOf = h0.mapOf(o.to(6, "ANR"), o.to(4, "CRASH"), o.to(5, "CRASH_NATIVE"), o.to(12, "DEPENDENCY_DIED"), o.to(9, "EXCESSIVE_RESOURCE_USAGE"), o.to(1, "EXIT_SELF"), o.to(7, "INITIALIZATION_FAILURE"), o.to(3, "LOW_MEMORY"), o.to(13, "OTHER"), o.to(8, "PERMISSION_CHANGE"), o.to(2, "SIGNALED"), o.to(0, "UNKNOWN"), o.to(10, "USER_REQUESTED"), o.to(11, "USER_STOPPED"));
        Object systemService = ApplicationProvider.INSTANCE.get().getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        if (!(systemService instanceof ActivityManager)) {
            systemService = null;
        }
        ActivityManager activityManager = (ActivityManager) systemService;
        if (activityManager != null) {
            List<ApplicationExitInfo> historicalProcessExitReasons = activityManager.getHistoricalProcessExitReasons(null, 0, 1);
            m.checkNotNullExpressionValue(historicalProcessExitReasons, "activityManager.getHisto…ssExitReasons(null, 0, 1)");
            ApplicationExitInfo applicationExitInfo = (ApplicationExitInfo) u.firstOrNull((List) historicalProcessExitReasons);
            if (applicationExitInfo != null) {
                String string = (String) mapMapOf.get(Integer.valueOf(applicationExitInfo.getReason()));
                if (string == null) {
                    StringBuilder sbU = a.U("Unknown ");
                    sbU.append(applicationExitInfo.getReason());
                    string = sbU.toString();
                }
                historicalProcessExitReason$Reason = new HistoricalProcessExitReason$Reason(string, applicationExitInfo.getDescription());
            }
        }
        return historicalProcessExitReason$Reason;
    }

    public final HistoricalProcessExitReason$Reason getLastReason() {
        return (HistoricalProcessExitReason$Reason) lastReason.getValue();
    }
}
