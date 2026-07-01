package b.a.a.b;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits$Location;
import com.discord.utilities.analytics.Traits$Location$ObjType;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GuildBoostUpsellDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class e$b {
    public e$b(DefaultConstructorMarker defaultConstructorMarker) {
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0041  */
    /* JADX WARN: Code duplicated, block: B:24:0x004c  */
    /* JADX WARN: Code duplicated, block: B:31:0x0076  */
    /* JADX WARN: Code duplicated, block: B:32:0x007c  */
    /* JADX WARN: Code duplicated, block: B:34:0x007f  */
    /* JADX WARN: Code duplicated, block: B:35:0x0085  */
    /* JADX WARN: Code duplicated, block: B:37:0x0088  */
    public final void a(FragmentManager fragmentManager, long j, Long l, Integer num, Traits$Location traits$Location) {
        String str;
        String str2;
        Bundle bundleT;
        String page;
        String str3;
        String page2;
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        e eVar = new e();
        if (num != null && num.intValue() == 1) {
            str2 = Traits$Location$ObjType.TIER_1;
        } else {
            if (num == null || num.intValue() != 2) {
                if (num != null && num.intValue() == 3) {
                    str2 = Traits$Location$ObjType.TIER_3;
                } else {
                    str = null;
                }
                bundleT = b.d.b.a.a.T("extra_guild_id", j);
                if (l != null) {
                    bundleT.putLong("extra_channel_id", l.longValue());
                }
                if (str != null) {
                    bundleT.putString("extra_object_type", str);
                }
                if (traits$Location != null && (page2 = traits$Location.getPage()) != null) {
                    bundleT.putString("extra_page", page2);
                }
                eVar.setArguments(bundleT);
                eVar.show(fragmentManager, e.class.getSimpleName());
                AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
                String strW = b.d.b.a.a.w("Premium Guild Upsell Modal - Tier ", str);
                if (traits$Location != null) {
                    page = traits$Location.getPage();
                } else {
                    page = null;
                }
                if (traits$Location != null) {
                    str3 = traits$Location.get_object();
                } else {
                    str3 = null;
                }
                analyticsTracker.openModal(strW, new Traits$Location(page, traits$Location != null ? traits$Location.getSection() : null, str3, str, null, 16, null));
            }
            str2 = Traits$Location$ObjType.TIER_2;
        }
        str = str2;
        bundleT = b.d.b.a.a.T("extra_guild_id", j);
        if (l != null) {
            bundleT.putLong("extra_channel_id", l.longValue());
        }
        if (str != null) {
            bundleT.putString("extra_object_type", str);
        }
        if (traits$Location != null) {
            bundleT.putString("extra_page", page2);
        }
        eVar.setArguments(bundleT);
        eVar.show(fragmentManager, e.class.getSimpleName());
        AnalyticsTracker analyticsTracker2 = AnalyticsTracker.INSTANCE;
        String strW2 = b.d.b.a.a.w("Premium Guild Upsell Modal - Tier ", str);
        if (traits$Location != null) {
            page = traits$Location.getPage();
        } else {
            page = null;
        }
        if (traits$Location != null) {
            str3 = traits$Location.get_object();
        } else {
            str3 = null;
        }
        analyticsTracker2.openModal(strW2, new Traits$Location(page, traits$Location != null ? traits$Location.getSection() : null, str3, str, null, 16, null));
    }
}
