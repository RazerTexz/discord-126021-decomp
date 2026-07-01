package com.discord.views;

import android.widget.TextView;
import b.a.i.x0;
import com.discord.api.auth.OAuthScope;
import com.discord.utilities.views.SimpleRecyclerAdapter$ViewHolder;
import d0.z.d.m;

/* JADX INFO: compiled from: OAuthPermissionViews.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class OAuthPermissionViews$a extends SimpleRecyclerAdapter$ViewHolder<OAuthScope> {
    public final x0 a;

    /* JADX WARN: Illegal instructions before constructor call */
    public OAuthPermissionViews$a(x0 x0Var) {
        m.checkNotNullParameter(x0Var, "binding");
        TextView textView = x0Var.a;
        m.checkNotNullExpressionValue(textView, "binding.root");
        super(textView);
        this.a = x0Var;
    }

    @Override // com.discord.utilities.views.SimpleRecyclerAdapter$ViewHolder
    public void bind(OAuthScope oAuthScope) {
        OAuthScope oAuthScope2 = oAuthScope;
        m.checkNotNullParameter(oAuthScope2, "data");
        TextView textView = this.a.a;
        m.checkNotNullExpressionValue(textView, "binding.root");
        OAuthPermissionViews.a(textView, oAuthScope2);
    }
}
