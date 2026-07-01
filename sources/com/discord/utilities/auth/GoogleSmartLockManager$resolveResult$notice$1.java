package com.discord.utilities.auth;

import androidx.appcompat.widget.ActivityChooserModel;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.google.android.gms.common.api.ResolvableApiException;
import d0.t.u;
import d0.z.d.a0;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GoogleSmartLockManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GoogleSmartLockManager$resolveResult$notice$1 extends o implements Function1<FragmentActivity, Boolean> {
    public final /* synthetic */ ResolvableApiException $rae;
    public final /* synthetic */ GoogleSmartLockManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoogleSmartLockManager$resolveResult$notice$1(GoogleSmartLockManager googleSmartLockManager, ResolvableApiException resolvableApiException) {
        super(1);
        this.this$0 = googleSmartLockManager;
        this.$rae = resolvableApiException;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
        return Boolean.valueOf(invoke2(fragmentActivity));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(FragmentActivity fragmentActivity) {
        Object next;
        m.checkNotNullParameter(fragmentActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        m.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
        List<Fragment> fragments = supportFragmentManager.getFragments();
        m.checkNotNullExpressionValue(fragments, "activity.supportFragmentManager.fragments");
        Iterator<T> it = fragments.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!u.contains(GoogleSmartLockManager.access$getResolvableFragments$p(this.this$0), a0.getOrCreateKotlinClass(((Fragment) next).getClass())));
        Fragment fragment = (Fragment) next;
        if (fragment == null) {
            return true;
        }
        GoogleSmartLockManager.access$resolveResult(this.this$0, fragment, GoogleSmartLockManager.GOOGLE_SMART_LOCK_REQUEST_CODE_RESOLVE, this.$rae);
        return true;
    }
}
