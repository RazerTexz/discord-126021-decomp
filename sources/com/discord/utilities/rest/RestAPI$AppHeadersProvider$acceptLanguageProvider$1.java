package com.discord.utilities.rest;

import android.os.Build$VERSION;
import android.os.LocaleList;
import d0.d0.f;
import d0.t.u;
import d0.z.d.m;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: RestAPI.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RestAPI$AppHeadersProvider$acceptLanguageProvider$1 extends o implements Function0<String> {
    public static final RestAPI$AppHeadersProvider$acceptLanguageProvider$1 INSTANCE = new RestAPI$AppHeadersProvider$acceptLanguageProvider$1();

    public RestAPI$AppHeadersProvider$acceptLanguageProvider$1() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2() {
        ArrayList arrayList = new ArrayList();
        if (Build$VERSION.SDK_INT >= 24) {
            LocaleList adjustedDefault = LocaleList.getAdjustedDefault();
            m.checkNotNullExpressionValue(adjustedDefault, "LocaleList.getAdjustedDefault()");
            int iCoerceAtLeast = 10;
            int size = adjustedDefault.size();
            for (int i = 0; i < size; i++) {
                String languageTag = adjustedDefault.get(i).toLanguageTag();
                if (i != 0) {
                    arrayList.add(languageTag + ";q=0." + iCoerceAtLeast);
                } else {
                    arrayList.add(languageTag);
                }
                iCoerceAtLeast = f.coerceAtLeast(1, iCoerceAtLeast - 1);
            }
        } else {
            arrayList.add(Locale.getDefault().toLanguageTag());
        }
        return u.joinToString$default(arrayList, ",", null, null, 0, null, null, 62, null);
    }
}
