package com.discord.utilities.resources;

import android.content.Context;
import android.content.res.Resources;
import androidx.annotation.PluralsRes;
import androidx.annotation.StringRes;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.string.StringUtilsKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import p007b.p008a.p027k.C1107b;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: StringResourceUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StringResourceUtilsKt {
    public static final CharSequence getI18nPluralString(Context context, @PluralsRes int i, int i2, Object... objArr) {
        C12238m.checkNotNullParameter(context, "$this$getI18nPluralString");
        C12238m.checkNotNullParameter(objArr, "formatArgs");
        String quantityString = context.getResources().getQuantityString(i, i2);
        C12238m.checkNotNullExpressionValue(quantityString, "resources.getQuantityString(resId, quantity)");
        return objArr.length == 0 ? C1107b.m215g(quantityString, new Object[0], (2 & 2) != 0 ? C1107b.e.f1494j : null) : C1107b.m215g(quantityString, Arrays.copyOf(objArr, objArr.length), (2 & 2) != 0 ? C1107b.e.f1494j : null);
    }

    public static final CharSequence getQuantityString(Resources resources, @PluralsRes int i, @StringRes int i2, int i3, Object... objArr) throws Resources.NotFoundException {
        C12238m.checkNotNullParameter(resources, "$this$getQuantityString");
        C12238m.checkNotNullParameter(objArr, "formatArgs");
        if (i3 == 0) {
            return C1107b.m211c(resources, i2, new Object[0], (4 & 4) != 0 ? C1107b.d.f1493j : null);
        }
        String quantityString = resources.getQuantityString(i, i3);
        C12238m.checkNotNullExpressionValue(quantityString, "getQuantityString(id, quantity)");
        return objArr.length == 0 ? C1107b.m215g(quantityString, new Object[0], (2 & 2) != 0 ? C1107b.e.f1494j : null) : C1107b.m215g(quantityString, Arrays.copyOf(objArr, objArr.length), (2 & 2) != 0 ? C1107b.e.f1494j : null);
    }

    public static final CharSequence getQuantityString(Resources resources, Context context, @PluralsRes int i, int i2, Object... objArr) {
        C12238m.checkNotNullParameter(resources, "$this$getQuantityString");
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(objArr, "formatArgs");
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            if (obj instanceof Integer) {
                obj = StringUtilsKt.format(i2, context);
            }
            arrayList.add(obj);
        }
        Object[] array = arrayList.toArray(new Object[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        String quantityString = resources.getQuantityString(i, i2);
        C12238m.checkNotNullExpressionValue(quantityString, "getQuantityString(resId, quantity)");
        return array.length == 0 ? C1107b.m215g(quantityString, new Object[0], (2 & 2) != 0 ? C1107b.e.f1494j : null) : C1107b.m215g(quantityString, Arrays.copyOf(array, array.length), (2 & 2) != 0 ? C1107b.e.f1494j : null);
    }
}
