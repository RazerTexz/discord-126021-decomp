package com.discord.utilities.uri;

import android.os.Bundle;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import java.util.Objects;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p009a.p016g.C0830a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: UriHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UriHandler$handleOrUntrusted$notice$1 extends AbstractC12240o implements Function1<FragmentActivity, Boolean> {
    public final /* synthetic */ String $url;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UriHandler$handleOrUntrusted$notice$1(String str) {
        super(1);
        this.$url = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
        return Boolean.valueOf(invoke2(fragmentActivity));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(FragmentActivity fragmentActivity) {
        C12238m.checkNotNullParameter(fragmentActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        C0830a.Companion bVar = C0830a.INSTANCE;
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        C12238m.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
        String str = this.$url;
        Objects.requireNonNull(bVar);
        C12238m.checkNotNullParameter(supportFragmentManager, "fragmentManager");
        C12238m.checkNotNullParameter(str, "url");
        C0830a c0830a = new C0830a();
        Bundle bundle = new Bundle();
        bundle.putString("WIDGET_SPOOPY_LINKS_DIALOG_URL", str);
        c0830a.setArguments(bundle);
        c0830a.show(supportFragmentManager, "WIDGET_SPOOPY_LINKS_DIALOG");
        return true;
    }
}
