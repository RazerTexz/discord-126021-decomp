package b.a.d;

import android.annotation.SuppressLint;
import b.d.b.a.outline;
import com.discord.stores.StoreStream;
import com.discord.widgets.chat.input.MentionUtils;
import d0.z.d.Intrinsics3;
import java.util.Objects;

/* JADX INFO: renamed from: b.a.d.f, reason: use source file name */
/* JADX INFO: compiled from: AppHelpDesk.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AppHelpDesk {
    public static final AppHelpDesk a = new AppHelpDesk();

    public static final String c() {
        StringBuilder sbX = outline.X("https://support.discord.com", "/hc/");
        String locale = StoreStream.INSTANCE.getUserSettingsSystem().getLocale();
        Objects.requireNonNull(locale, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = locale.toLowerCase();
        Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
        sbX.append(lowerCase);
        sbX.append("/requests/new");
        return sbX.toString();
    }

    public final String a(long j, String str) {
        if (str == null) {
            StringBuilder sbX = outline.X("https://support.discord.com", "/hc/");
            sbX.append(b());
            sbX.append("/articles/");
            sbX.append(j);
            return sbX.toString();
        }
        StringBuilder sbX2 = outline.X("https://support.discord.com", "/hc/");
        sbX2.append(b());
        sbX2.append("/articles/");
        sbX2.append(j);
        sbX2.append(MentionUtils.CHANNELS_CHAR);
        sbX2.append(str);
        return sbX2.toString();
    }

    @SuppressLint({"DefaultLocale"})
    public final String b() {
        String locale = StoreStream.INSTANCE.getUserSettingsSystem().getLocale();
        Objects.requireNonNull(locale, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = locale.toLowerCase();
        Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
        return lowerCase;
    }
}
