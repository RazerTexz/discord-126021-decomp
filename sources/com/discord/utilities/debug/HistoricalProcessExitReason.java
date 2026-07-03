package com.discord.utilities.debug;

import android.app.ActivityManager;
import android.app.ApplicationExitInfo;
import android.os.Build;
import androidx.appcompat.widget.ActivityChooserModel;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.lifecycle.ApplicationProvider;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.C12116o;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: HistoricalProcessExitReason.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class HistoricalProcessExitReason {
    public static final HistoricalProcessExitReason INSTANCE = new HistoricalProcessExitReason();

    /* JADX INFO: renamed from: lastReason$delegate, reason: from kotlin metadata */
    private static final Lazy lastReason = C12083g.lazy(HistoricalProcessExitReason$lastReason$2.INSTANCE);

    /* JADX INFO: compiled from: HistoricalProcessExitReason.kt */
    public static final /* data */ class Reason {
        private final String description;
        private final String reason;

        public Reason(String str, String str2) {
            C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_REASON);
            this.reason = str;
            this.description = str2;
        }

        public static /* synthetic */ Reason copy$default(Reason reason, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = reason.reason;
            }
            if ((i & 2) != 0) {
                str2 = reason.description;
            }
            return reason.copy(str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getReason() {
            return this.reason;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        public final Reason copy(String reason, String description) {
            C12238m.checkNotNullParameter(reason, ModelAuditLogEntry.CHANGE_KEY_REASON);
            return new Reason(reason, description);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Reason)) {
                return false;
            }
            Reason reason = (Reason) other;
            return C12238m.areEqual(this.reason, reason.reason) && C12238m.areEqual(this.description, reason.description);
        }

        public final String getDescription() {
            return this.description;
        }

        public final String getReason() {
            return this.reason;
        }

        public int hashCode() {
            String str = this.reason;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.description;
            return iHashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("Reason(reason=");
            sbM833U.append(this.reason);
            sbM833U.append(", description=");
            return C1643a.m822J(sbM833U, this.description, ")");
        }
    }

    private HistoricalProcessExitReason() {
    }

    private final Reason createLastReason() {
        Reason reason = null;
        if (Build.VERSION.SDK_INT < 30) {
            return null;
        }
        Map mapMapOf = C12136h0.mapOf(C12116o.m10073to(6, "ANR"), C12116o.m10073to(4, "CRASH"), C12116o.m10073to(5, "CRASH_NATIVE"), C12116o.m10073to(12, "DEPENDENCY_DIED"), C12116o.m10073to(9, "EXCESSIVE_RESOURCE_USAGE"), C12116o.m10073to(1, "EXIT_SELF"), C12116o.m10073to(7, "INITIALIZATION_FAILURE"), C12116o.m10073to(3, "LOW_MEMORY"), C12116o.m10073to(13, "OTHER"), C12116o.m10073to(8, "PERMISSION_CHANGE"), C12116o.m10073to(2, "SIGNALED"), C12116o.m10073to(0, "UNKNOWN"), C12116o.m10073to(10, "USER_REQUESTED"), C12116o.m10073to(11, "USER_STOPPED"));
        Object systemService = ApplicationProvider.INSTANCE.get().getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        if (!(systemService instanceof ActivityManager)) {
            systemService = null;
        }
        ActivityManager activityManager = (ActivityManager) systemService;
        if (activityManager != null) {
            List<ApplicationExitInfo> historicalProcessExitReasons = activityManager.getHistoricalProcessExitReasons(null, 0, 1);
            C12238m.checkNotNullExpressionValue(historicalProcessExitReasons, "activityManager.getHisto…ssExitReasons(null, 0, 1)");
            ApplicationExitInfo applicationExitInfo = (ApplicationExitInfo) C12163u.firstOrNull((List) historicalProcessExitReasons);
            if (applicationExitInfo != null) {
                String string = (String) mapMapOf.get(Integer.valueOf(applicationExitInfo.getReason()));
                if (string == null) {
                    StringBuilder sbM833U = C1643a.m833U("Unknown ");
                    sbM833U.append(applicationExitInfo.getReason());
                    string = sbM833U.toString();
                }
                reason = new Reason(string, applicationExitInfo.getDescription());
            }
        }
        return reason;
    }

    public final Reason getLastReason() {
        return (Reason) lastReason.getValue();
    }
}
