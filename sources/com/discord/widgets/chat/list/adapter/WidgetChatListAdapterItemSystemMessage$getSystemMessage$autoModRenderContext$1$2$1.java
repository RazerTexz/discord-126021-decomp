package com.discord.widgets.chat.list.adapter;

import d0.z.d.m;
import d0.z.d.o;
import java.util.Locale;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListAdapterItemSystemMessage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemSystemMessage$getSystemMessage$autoModRenderContext$1$2$1 extends o implements Function1<String, String> {
    public static final WidgetChatListAdapterItemSystemMessage$getSystemMessage$autoModRenderContext$1$2$1 INSTANCE = new WidgetChatListAdapterItemSystemMessage$getSystemMessage$autoModRenderContext$1$2$1();

    public WidgetChatListAdapterItemSystemMessage$getSystemMessage$autoModRenderContext$1$2$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(String str) {
        return invoke2(str);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(String str) {
        if (str == null) {
            return null;
        }
        Locale locale = Locale.ROOT;
        m.checkNotNullExpressionValue(locale, "Locale.ROOT");
        String upperCase = str.toUpperCase(locale);
        m.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase(locale)");
        return upperCase;
    }
}
