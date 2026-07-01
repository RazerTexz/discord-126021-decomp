package com.discord.utilities.uri;

import android.view.View;
import android.view.View$OnClickListener;
import b.a.d.m;
import b.d.b.a.a;
import com.discord.databinding.LayoutUnhandledUriBinding;

/* JADX INFO: compiled from: UriHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UriHandler$showUnhandledUrlDialog$$inlined$apply$lambda$1 implements View$OnClickListener {
    public final /* synthetic */ LayoutUnhandledUriBinding $binding$inlined;
    public final /* synthetic */ String $url$inlined;

    public UriHandler$showUnhandledUrlDialog$$inlined$apply$lambda$1(LayoutUnhandledUriBinding layoutUnhandledUriBinding, String str) {
        this.$binding$inlined = layoutUnhandledUriBinding;
        this.$url$inlined = str;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        m.c(a.x(view, "v", "v.context"), this.$url$inlined, 0, 4);
    }
}
