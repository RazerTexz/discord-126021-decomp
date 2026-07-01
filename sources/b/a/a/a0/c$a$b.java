package b.a.a.a0;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.discord.stores.StoreStream;
import d0.z.d.a0;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGiftAcceptDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class c$a$b extends o implements Function1<FragmentActivity, Boolean> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ String $giftCode;
    public final /* synthetic */ String $source;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c$a$b(String str, String str2, long j) {
        super(1);
        this.$giftCode = str;
        this.$source = str2;
        this.$channelId = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public Boolean invoke(FragmentActivity fragmentActivity) {
        FragmentActivity fragmentActivity2 = fragmentActivity;
        m.checkNotNullParameter(fragmentActivity2, "appActivity");
        StoreStream.Companion.getAnalytics().trackOpenGiftAcceptModal(this.$giftCode, this.$source, this.$channelId);
        c cVar = new c();
        Bundle bundle = new Bundle();
        bundle.putString("ARG_GIFT_CODE", this.$giftCode);
        cVar.setArguments(bundle);
        FragmentManager supportFragmentManager = fragmentActivity2.getSupportFragmentManager();
        m.checkNotNullExpressionValue(supportFragmentManager, "appActivity.supportFragmentManager");
        cVar.show(supportFragmentManager, a0.getOrCreateKotlinClass(c.class).toString());
        return Boolean.TRUE;
    }
}
