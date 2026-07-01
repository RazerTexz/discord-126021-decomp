package com.discord.utilities.string;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import b.a.k.FormatUtils;
import com.discord.utilities.locale.LocaleManager;
import com.discord.utils.R;
import com.discord.widgets.chat.input.MentionUtils;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.net.IDN;
import java.net.URL;
import java.text.Normalizer;
import java.text.NumberFormat;
import java.util.Locale;
import kotlin.jvm.functions.Function1;
import kotlin.text.Regex;

/* JADX INFO: renamed from: com.discord.utilities.string.StringUtilsKt, reason: use source file name */
/* JADX INFO: compiled from: StringUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StringUtils2 {
    private static final String STATIC_IMAGE_EXTENSION;
    private static final Regex STRIP_ACCENTS_REGEX = new Regex("[\\p{InCombiningDiacriticalMarks}]");

    static {
        STATIC_IMAGE_EXTENSION = Collections2.listOf((Object[]) new Integer[]{28, 29}).contains(Integer.valueOf(Build.VERSION.SDK_INT)) ? "png" : "webp";
    }

    public static final String encodeToBase32String(byte[] bArr) {
        int i;
        int i2;
        Intrinsics3.checkNotNullParameter(bArr, "$this$encodeToBase32String");
        StringBuffer stringBuffer = new StringBuffer(((bArr.length + 7) * 8) / 5);
        int i3 = 0;
        int i4 = 0;
        while (i3 < bArr.length) {
            int i5 = bArr[i3] >= 0 ? bArr[i3] : bArr[i3] + 256;
            if (i4 > 3) {
                i3++;
                if (i3 < bArr.length) {
                    i2 = bArr[i3] >= 0 ? bArr[i3] : bArr[i3] + 256;
                } else {
                    i2 = 0;
                }
                int i6 = i5 & (255 >> i4);
                i4 = (i4 + 5) % 8;
                i = (i6 << i4) | (i2 >> (8 - i4));
            } else {
                int i7 = i4 + 5;
                i = (i5 >> (8 - i7)) & 31;
                i4 = i7 % 8;
                if (i4 == 0) {
                    i3++;
                }
            }
            stringBuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567".charAt(i));
        }
        String string = stringBuffer.toString();
        Intrinsics3.checkNotNullExpressionValue(string, "Base32.encodeOriginal(this)");
        return string;
    }

    public static final String filenameSanitized(CharSequence charSequence) {
        Intrinsics3.checkNotNullParameter(charSequence, "$this$filenameSanitized");
        return new Regex("[/\\\\]").replace(charSequence, "_");
    }

    public static final String format(int i, Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        String str = NumberFormat.getInstance(new LocaleManager().getPrimaryLocale(context)).format(Integer.valueOf(i));
        Intrinsics3.checkNotNullExpressionValue(str, "NumberFormat.getInstance…le(context)).format(this)");
        return str;
    }

    public static final String getSTATIC_IMAGE_EXTENSION() {
        return STATIC_IMAGE_EXTENSION;
    }

    public static final CharSequence getStringByLocale(Context context, int i, String str) {
        Intrinsics3.checkNotNullParameter(context, "$this$getStringByLocale");
        Intrinsics3.checkNotNullParameter(str, "locale");
        try {
            Resources resources = context.getResources();
            Intrinsics3.checkNotNullExpressionValue(resources, "resources");
            Configuration configuration = new Configuration(resources.getConfiguration());
            configuration.setLocale(new Locale(str));
            Context contextCreateConfigurationContext = context.createConfigurationContext(configuration);
            Intrinsics3.checkNotNullExpressionValue(contextCreateConfigurationContext, "createConfigurationContext(configuration)");
            Resources resources2 = contextCreateConfigurationContext.getResources();
            Intrinsics3.checkNotNullExpressionValue(resources2, "createConfigurationConte…(configuration).resources");
            return FormatUtils.c(resources2, i, new Object[0], (4 & 4) != 0 ? FormatUtils.d.j : null);
        } catch (Resources.NotFoundException unused) {
            return null;
        }
    }

    public static final String stripAccents(String str) {
        Intrinsics3.checkNotNullParameter(str, "$this$stripAccents");
        String strNormalize = Normalizer.normalize(str, Normalizer.Form.NFKD);
        Intrinsics3.checkNotNullExpressionValue(strNormalize, "normalizedString");
        return STRIP_ACCENTS_REGEX.replace(strNormalize, "");
    }

    public static final void test(Context context, Resources resources) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(resources, "resources");
        context.getString(R.a.common_google_play_services_unknown_issue, 1);
        resources.getString(R.a.common_google_play_services_enable_button, 1);
    }

    public static final String toPunyCodeASCIIUrl(String str) {
        Intrinsics3.checkNotNullParameter(str, "$this$toPunyCodeASCIIUrl");
        URL url = new URL(str);
        StringBuilder sb = new StringBuilder(new URL(url.getProtocol(), IDN.toASCII(url.getHost(), 1), url.getPort(), url.getFile()).toString());
        if (url.getRef() != null) {
            sb.append(MentionUtils.CHANNELS_CHAR);
            sb.append(url.getRef());
        }
        String string = sb.toString();
        Intrinsics3.checkNotNullExpressionValue(string, "safeUrlStringBuilder.toString()");
        return string;
    }

    public static final String transformOrEmpty(String str, Function1<? super String, String> function1) {
        String strInvoke;
        if (function1 != null && (strInvoke = function1.invoke(str)) != null) {
            str = strInvoke;
        }
        return str != null ? str : "";
    }
}
