package com.discord.utilities.uri;

import android.os.Bundle;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import b.a.a.g.a;
import b.a.a.g.a$b;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Objects;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: UriHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UriHandler$handleOrUntrusted$notice$1 extends o implements Function1<FragmentActivity, Boolean> {
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
        m.checkNotNullParameter(fragmentActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        a$b a_b = a.k;
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        m.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
        String str = this.$url;
        Objects.requireNonNull(a_b);
        m.checkNotNullParameter(supportFragmentManager, "fragmentManager");
        m.checkNotNullParameter(str, "url");
        a aVar = new a();
        Bundle bundle = new Bundle();
        bundle.putString("WIDGET_SPOOPY_LINKS_DIALOG_URL", str);
        aVar.setArguments(bundle);
        aVar.show(supportFragmentManager, "WIDGET_SPOOPY_LINKS_DIALOG");
        return true;
    }
}
