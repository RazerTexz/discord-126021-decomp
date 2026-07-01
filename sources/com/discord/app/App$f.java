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
public final class App$f extends o implements Function2<View, String, Unit> {
    public static final App$f j = new App$f();

    public App$f() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public Unit invoke(View view, String str) {
        View view2 = view;
        String str2 = str;
        m.checkNotNullParameter(view2, "textView");
        m.checkNotNullParameter(str2, "url");
        UriHandler uriHandler = UriHandler.INSTANCE;
        Context context = view2.getContext();
        m.checkNotNullExpressionValue(context, "textView.context");
        UriHandler.handle$default(uriHandler, context, str2, false, false, null, 28, null);
        return Unit.a;
    }
}
