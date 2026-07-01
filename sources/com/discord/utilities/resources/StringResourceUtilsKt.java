package com.discord.utilities.resources;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources$NotFoundException;
import androidx.annotation.PluralsRes;
import androidx.annotation.StringRes;
import b.a.k.b;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.string.StringUtilsKt;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: StringResourceUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StringResourceUtilsKt {
    public static final CharSequence getI18nPluralString(Context context, @PluralsRes int i, int i2, Object... objArr) {
        m.checkNotNullParameter(context, "$this$getI18nPluralString");
        m.checkNotNullParameter(objArr, "formatArgs");
        String quantityString = context.getResources().getQuantityString(i, i2);
        m.checkNotNullExpressionValue(quantityString, "resources.getQuantityString(resId, quantity)");
        return objArr.length == 0 ? b.l(quantityString, new Object[0], null, 2) : b.l(quantityString, Arrays.copyOf(objArr, objArr.length), null, 2);
    }

    public static final CharSequence getQuantityString(Resources resources, @PluralsRes int i, @StringRes int i2, int i3, Object... objArr) throws Resources$NotFoundException {
        m.checkNotNullParameter(resources, "$this$getQuantityString");
        m.checkNotNullParameter(objArr, "formatArgs");
        if (i3 == 0) {
            return b.i(resources, i2, new Object[0], null, 4);
        }
        String quantityString = resources.getQuantityString(i, i3);
        m.checkNotNullExpressionValue(quantityString, "getQuantityString(id, quantity)");
        return objArr.length == 0 ? b.l(quantityString, new Object[0], null, 2) : b.l(quantityString, Arrays.copyOf(objArr, objArr.length), null, 2);
    }

    public static final CharSequence getQuantityString(Resources resources, Context context, @PluralsRes int i, int i2, Object... objArr) {
        m.checkNotNullParameter(resources, "$this$getQuantityString");
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(objArr, "formatArgs");
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
        m.checkNotNullExpressionValue(quantityString, "getQuantityString(resId, quantity)");
        if (array.length == 0) {
            return b.l(quantityString, new Object[0], null, 2);
        }
        return b.l(quantityString, Arrays.copyOf(array, array.length), null, 2);
    }
}
