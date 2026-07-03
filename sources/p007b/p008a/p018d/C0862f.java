package p007b.p008a.p018d;

import android.annotation.SuppressLint;
import com.discord.stores.StoreStream;
import com.discord.widgets.chat.input.MentionUtilsKt;
import java.util.Objects;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.d.f */
/* JADX INFO: compiled from: AppHelpDesk.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0862f {

    /* JADX INFO: renamed from: a */
    public static final C0862f f507a = new C0862f();

    /* JADX INFO: renamed from: c */
    public static final String m148c() {
        StringBuilder sbM836X = C1643a.m836X("https://support.discord.com", "/hc/");
        String locale = StoreStream.INSTANCE.getUserSettingsSystem().getLocale();
        Objects.requireNonNull(locale, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = locale.toLowerCase();
        C12238m.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
        sbM836X.append(lowerCase);
        sbM836X.append("/requests/new");
        return sbM836X.toString();
    }

    /* JADX INFO: renamed from: a */
    public final String m149a(long j, String str) {
        if (str == null) {
            StringBuilder sbM836X = C1643a.m836X("https://support.discord.com", "/hc/");
            sbM836X.append(m150b());
            sbM836X.append("/articles/");
            sbM836X.append(j);
            return sbM836X.toString();
        }
        StringBuilder sbM836X2 = C1643a.m836X("https://support.discord.com", "/hc/");
        sbM836X2.append(m150b());
        sbM836X2.append("/articles/");
        sbM836X2.append(j);
        sbM836X2.append(MentionUtilsKt.CHANNELS_CHAR);
        sbM836X2.append(str);
        return sbM836X2.toString();
    }

    @SuppressLint({"DefaultLocale"})
    /* JADX INFO: renamed from: b */
    public final String m150b() {
        String locale = StoreStream.INSTANCE.getUserSettingsSystem().getLocale();
        Objects.requireNonNull(locale, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = locale.toLowerCase();
        C12238m.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
        return lowerCase;
    }
}
