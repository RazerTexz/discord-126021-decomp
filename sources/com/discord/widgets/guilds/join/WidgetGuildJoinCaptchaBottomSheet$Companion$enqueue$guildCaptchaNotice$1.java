package com.discord.widgets.guilds.join;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.discord.app.AppFragment;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.utilities.captcha.CaptchaErrorBody;
import com.discord.widgets.tabs.WidgetTabsHost;
import d0.z.d.a0;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetGuildJoinCaptchaBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildJoinCaptchaBottomSheet$Companion$enqueue$guildCaptchaNotice$1 extends o implements Function1<FragmentActivity, Boolean> {
    public final /* synthetic */ CaptchaErrorBody $error;
    public final /* synthetic */ Function2 $onCaptchaPayloadReceived;
    public final /* synthetic */ String $requestKey;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildJoinCaptchaBottomSheet$Companion$enqueue$guildCaptchaNotice$1(String str, CaptchaErrorBody captchaErrorBody, Function2 function2) {
        super(1);
        this.$requestKey = str;
        this.$error = captchaErrorBody;
        this.$onCaptchaPayloadReceived = function2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
        return Boolean.valueOf(invoke2(fragmentActivity));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(FragmentActivity fragmentActivity) {
        Object next;
        m.checkNotNullParameter(fragmentActivity, "appActivity");
        WidgetGuildJoinCaptchaBottomSheet$Companion widgetGuildJoinCaptchaBottomSheet$Companion = WidgetGuildJoinCaptchaBottomSheet.Companion;
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        m.checkNotNullExpressionValue(supportFragmentManager, "appActivity.supportFragmentManager");
        widgetGuildJoinCaptchaBottomSheet$Companion.show(supportFragmentManager, this.$requestKey, this.$error);
        StoreNotices.markSeen$default(StoreStream.Companion.getNotices(), "guild captcha notice", 0L, 2, null);
        FragmentManager supportFragmentManager2 = fragmentActivity.getSupportFragmentManager();
        m.checkNotNullExpressionValue(supportFragmentManager2, "appActivity.supportFragmentManager");
        List<Fragment> fragments = supportFragmentManager2.getFragments();
        m.checkNotNullExpressionValue(fragments, "appActivity.supportFragmentManager.fragments");
        Iterator<T> it = fragments.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!m.areEqual(a0.getOrCreateKotlinClass(((Fragment) next).getClass()), a0.getOrCreateKotlinClass(WidgetTabsHost.class)));
        Fragment fragment = (Fragment) next;
        if (fragment == null) {
            return true;
        }
        WidgetGuildJoinCaptchaBottomSheet.Companion.registerForResult((AppFragment) fragment, this.$requestKey, this.$onCaptchaPayloadReceived);
        return true;
    }
}
