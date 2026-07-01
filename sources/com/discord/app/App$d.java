package com.discord.app;

import android.content.Context;
import android.view.View;
import com.discord.utilities.uri.UriHandler;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: App.kt */
/* JADX INFO: loaded from: classes.dex */
public final class App$d extends o implements Function2<String, View, Unit> {
    public static final App$d j = new App$d();

    public App$d() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public Unit invoke(String str, View view) {
        String str2 = str;
        View view2 = view;
        m.checkNotNullParameter(str2, "url");
        m.checkNotNullParameter(view2, "view");
        UriHandler uriHandler = UriHandler.INSTANCE;
        Context context = view2.getContext();
        m.checkNotNullExpressionValue(context, "view.context");
        UriHandler.handle$default(uriHandler, context, str2, false, false, null, 28, null);
        return Unit.a;
    }
}
