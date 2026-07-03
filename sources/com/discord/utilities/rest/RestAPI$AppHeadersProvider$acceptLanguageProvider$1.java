package com.discord.utilities.rest;

import android.os.Build;
import android.os.LocaleList;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.jvm.functions.Function0;
import p507d0.p512d0.C11226f;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: RestAPI.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RestAPI$AppHeadersProvider$acceptLanguageProvider$1 extends AbstractC12240o implements Function0<String> {
    public static final RestAPI$AppHeadersProvider$acceptLanguageProvider$1 INSTANCE = new RestAPI$AppHeadersProvider$acceptLanguageProvider$1();

    public RestAPI$AppHeadersProvider$acceptLanguageProvider$1() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 24) {
            LocaleList adjustedDefault = LocaleList.getAdjustedDefault();
            C12238m.checkNotNullExpressionValue(adjustedDefault, "LocaleList.getAdjustedDefault()");
            int iCoerceAtLeast = 10;
            int size = adjustedDefault.size();
            for (int i = 0; i < size; i++) {
                String languageTag = adjustedDefault.get(i).toLanguageTag();
                if (i != 0) {
                    arrayList.add(languageTag + ";q=0." + iCoerceAtLeast);
                } else {
                    arrayList.add(languageTag);
                }
                iCoerceAtLeast = C11226f.coerceAtLeast(1, iCoerceAtLeast - 1);
            }
        } else {
            arrayList.add(Locale.getDefault().toLanguageTag());
        }
        return C12163u.joinToString$default(arrayList, ",", null, null, 0, null, null, 62, null);
    }
}
