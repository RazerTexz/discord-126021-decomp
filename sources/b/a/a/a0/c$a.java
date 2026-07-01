package b.a.a.a0;

import com.discord.stores.StoreNotices$Notice;
import com.discord.stores.StoreStream;
import com.discord.utilities.premium.BlockRussianPurchasesUtils;
import com.discord.widgets.home.WidgetHome;
import com.discord.widgets.settings.premium.WidgetSettingsGifting;
import d0.t.n;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetGiftAcceptDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class c$a {
    public c$a(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public final void a(String str, String str2, long j) {
        m.checkNotNullParameter(str, "giftCode");
        m.checkNotNullParameter(str2, "source");
        if (BlockRussianPurchasesUtils.Companion.getINSTANCE().showDialog()) {
            return;
        }
        m.checkNotNullParameter(str, "giftCode");
        StoreStream.Companion.getNotices().requestToShow(new StoreNotices$Notice("gift:" + str, null, 0L, 0, false, n.listOf((Object[]) new d0.e0.c[]{a0.getOrCreateKotlinClass(WidgetSettingsGifting.class), a0.getOrCreateKotlinClass(WidgetHome.class)}), 0L, false, 0L, new c$a$b(str, str2, j), 150, null));
    }
}
