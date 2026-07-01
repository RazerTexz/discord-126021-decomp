package com.discord.utilities.context;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build$VERSION;
import android.os.LocaleList;
import android.util.AttributeSet;
import androidx.annotation.StyleableRes;
import androidx.appcompat.app.AppCompatActivity;
import d0.z.d.m;
import java.util.Locale;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ContextExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ContextExtensionsKt {
    public static final AppCompatActivity findActivity(Context context) {
        m.checkNotNullParameter(context, "$this$findActivity");
        while (context != null) {
            if (context instanceof AppCompatActivity) {
                return (AppCompatActivity) context;
            }
            if (!(context instanceof ContextWrapper)) {
                context = null;
            }
            ContextWrapper contextWrapper = (ContextWrapper) context;
            context = contextWrapper != null ? contextWrapper.getBaseContext() : null;
        }
        return null;
    }

    public static final Locale getLocaleOrNull(Context context) {
        Configuration configuration;
        Configuration configuration2;
        LocaleList locales;
        m.checkNotNullParameter(context, "$this$getLocaleOrNull");
        if (Build$VERSION.SDK_INT < 24) {
            Resources resources = context.getResources();
            if (resources == null || (configuration = resources.getConfiguration()) == null) {
                return null;
            }
            return configuration.locale;
        }
        Resources resources2 = context.getResources();
        if (resources2 == null || (configuration2 = resources2.getConfiguration()) == null || (locales = configuration2.getLocales()) == null) {
            return null;
        }
        return locales.get(0);
    }

    public static final void useAttrs(Context context, AttributeSet attributeSet, @StyleableRes int[] iArr, Function1<? super TypedArray, Unit> function1) {
        m.checkNotNullParameter(context, "$this$useAttrs");
        m.checkNotNullParameter(iArr, "styleable");
        m.checkNotNullParameter(function1, "block");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        m.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(attrs, styleable)");
        function1.invoke(typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
    }
}
