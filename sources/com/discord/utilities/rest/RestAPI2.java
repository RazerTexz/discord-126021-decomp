package com.discord.utilities.rest;

import android.os.Build;
import android.os.LocaleList;
import d0.d0._Ranges;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.utilities.rest.RestAPI$AppHeadersProvider$acceptLanguageProvider$1, reason: use source file name */
/* JADX INFO: compiled from: RestAPI.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RestAPI2 extends Lambda implements Function0<String> {
    public static final RestAPI2 INSTANCE = new RestAPI2();

    public RestAPI2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 24) {
            LocaleList adjustedDefault = LocaleList.getAdjustedDefault();
            Intrinsics3.checkNotNullExpressionValue(adjustedDefault, "LocaleList.getAdjustedDefault()");
            int iCoerceAtLeast = 10;
            int size = adjustedDefault.size();
            for (int i = 0; i < size; i++) {
                String languageTag = adjustedDefault.get(i).toLanguageTag();
                if (i != 0) {
                    arrayList.add(languageTag + ";q=0." + iCoerceAtLeast);
                } else {
                    arrayList.add(languageTag);
                }
                iCoerceAtLeast = _Ranges.coerceAtLeast(1, iCoerceAtLeast - 1);
            }
        } else {
            arrayList.add(Locale.getDefault().toLanguageTag());
        }
        return _Collections.joinToString$default(arrayList, ",", null, null, 0, null, null, 62, null);
    }
}
