package com.discord.utilities.string;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import com.discord.utilities.locale.LocaleManager;
import com.discord.utils.C7063R;
import com.discord.widgets.chat.input.MentionUtilsKt;
import java.net.IDN;
import java.net.URL;
import java.text.Normalizer;
import java.text.NumberFormat;
import java.util.Locale;
import kotlin.jvm.functions.Function1;
import kotlin.text.Regex;
import p007b.p008a.p027k.C1107b;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: StringUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StringUtilsKt {
    private static final String STATIC_IMAGE_EXTENSION;
    private static final Regex STRIP_ACCENTS_REGEX = new Regex("[\\p{InCombiningDiacriticalMarks}]");

    static {
        STATIC_IMAGE_EXTENSION = C12147n.listOf((Object[]) new Integer[]{28, 29}).contains(Integer.valueOf(Build.VERSION.SDK_INT)) ? "png" : "webp";
    }

    public static final String encodeToBase32String(byte[] bArr) {
        int i;
        int i2;
        C12238m.checkNotNullParameter(bArr, "$this$encodeToBase32String");
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
        C12238m.checkNotNullExpressionValue(string, "Base32.encodeOriginal(this)");
        return string;
    }

    public static final String filenameSanitized(CharSequence charSequence) {
        C12238m.checkNotNullParameter(charSequence, "$this$filenameSanitized");
        return new Regex("[/\\\\]").replace(charSequence, "_");
    }

    public static final String format(int i, Context context) {
        C12238m.checkNotNullParameter(context, "context");
        String str = NumberFormat.getInstance(new LocaleManager().getPrimaryLocale(context)).format(Integer.valueOf(i));
        C12238m.checkNotNullExpressionValue(str, "NumberFormat.getInstance…le(context)).format(this)");
        return str;
    }

    public static final String getSTATIC_IMAGE_EXTENSION() {
        return STATIC_IMAGE_EXTENSION;
    }

    public static final CharSequence getStringByLocale(Context context, int i, String str) {
        C12238m.checkNotNullParameter(context, "$this$getStringByLocale");
        C12238m.checkNotNullParameter(str, "locale");
        try {
            Resources resources = context.getResources();
            C12238m.checkNotNullExpressionValue(resources, "resources");
            Configuration configuration = new Configuration(resources.getConfiguration());
            configuration.setLocale(new Locale(str));
            Context contextCreateConfigurationContext = context.createConfigurationContext(configuration);
            C12238m.checkNotNullExpressionValue(contextCreateConfigurationContext, "createConfigurationContext(configuration)");
            Resources resources2 = contextCreateConfigurationContext.getResources();
            C12238m.checkNotNullExpressionValue(resources2, "createConfigurationConte…(configuration).resources");
            return C1107b.m211c(resources2, i, new Object[0], (4 & 4) != 0 ? C1107b.d.f1493j : null);
        } catch (Resources.NotFoundException unused) {
            return null;
        }
    }

    public static final String stripAccents(String str) {
        C12238m.checkNotNullParameter(str, "$this$stripAccents");
        String strNormalize = Normalizer.normalize(str, Normalizer.Form.NFKD);
        C12238m.checkNotNullExpressionValue(strNormalize, "normalizedString");
        return STRIP_ACCENTS_REGEX.replace(strNormalize, "");
    }

    public static final void test(Context context, Resources resources) {
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(resources, "resources");
        context.getString(C7063R.a.common_google_play_services_unknown_issue, 1);
        resources.getString(C7063R.a.common_google_play_services_enable_button, 1);
    }

    public static final String toPunyCodeASCIIUrl(String str) {
        C12238m.checkNotNullParameter(str, "$this$toPunyCodeASCIIUrl");
        URL url = new URL(str);
        StringBuilder sb = new StringBuilder(new URL(url.getProtocol(), IDN.toASCII(url.getHost(), 1), url.getPort(), url.getFile()).toString());
        if (url.getRef() != null) {
            sb.append(MentionUtilsKt.CHANNELS_CHAR);
            sb.append(url.getRef());
        }
        String string = sb.toString();
        C12238m.checkNotNullExpressionValue(string, "safeUrlStringBuilder.toString()");
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
