package b.a.d;

import android.annotation.SuppressLint;
import com.discord.stores.StoreStream;
import com.discord.widgets.chat.input.MentionUtilsKt;
import java.util.Objects;

/* JADX INFO: compiled from: AppHelpDesk.kt */
/* JADX INFO: loaded from: classes.dex */
public final class f {
    public static final f a = new f();

    public static final String c() {
        StringBuilder sbX = b.d.b.a.a.X("https://support.discord.com", "/hc/");
        String locale = StoreStream.Companion.getUserSettingsSystem().getLocale();
        Objects.requireNonNull(locale, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = locale.toLowerCase();
        d0.z.d.m.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
        sbX.append(lowerCase);
        sbX.append("/requests/new");
        return sbX.toString();
    }

    public final String a(long j, String str) {
        if (str == null) {
            StringBuilder sbX = b.d.b.a.a.X("https://support.discord.com", "/hc/");
            sbX.append(b());
            sbX.append("/articles/");
            sbX.append(j);
            return sbX.toString();
        }
        StringBuilder sbX2 = b.d.b.a.a.X("https://support.discord.com", "/hc/");
        sbX2.append(b());
        sbX2.append("/articles/");
        sbX2.append(j);
        sbX2.append(MentionUtilsKt.CHANNELS_CHAR);
        sbX2.append(str);
        return sbX2.toString();
    }

    @SuppressLint({"DefaultLocale"})
    public final String b() {
        String locale = StoreStream.Companion.getUserSettingsSystem().getLocale();
        Objects.requireNonNull(locale, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = locale.toLowerCase();
        d0.z.d.m.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
        return lowerCase;
    }
}
