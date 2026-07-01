package b.a.a.b;

import android.os.Bundle;
import androidx.annotation.DrawableRes;
import androidx.fragment.app.FragmentManager;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.AnalyticsTracker$PremiumUpsellType;
import com.discord.utilities.analytics.Traits$Source;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SingleValuePropPremiumUpsellDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class d$b {
    public d$b(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public final void a(FragmentManager fragmentManager, AnalyticsTracker$PremiumUpsellType analyticsTracker$PremiumUpsellType, @DrawableRes int i, String str, String str2, String str3, String str4, String str5) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        m.checkNotNullParameter(analyticsTracker$PremiumUpsellType, "premiumUpsellType");
        d dVar = new d();
        Bundle bundle = new Bundle();
        bundle.putInt("extra_image_drawable_res", i);
        bundle.putString("extra_header_text", str);
        bundle.putString("extra_body_text", str2);
        dVar.setArguments(bundle);
        dVar.show(fragmentManager, d.class.getName());
        AnalyticsTracker.premiumUpsellViewed$default(AnalyticsTracker.INSTANCE, analyticsTracker$PremiumUpsellType, null, null, new Traits$Source(str3, str4, str5, null, null, 24, null), 6, null);
    }
}
