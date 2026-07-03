package androidx.core.net;

import android.net.Uri;
import androidx.annotation.NonNull;
import com.adjust.sdk.Constants;
import com.discord.widgets.chat.input.MentionUtilsKt;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: loaded from: classes.dex */
public final class UriCompat {
    private UriCompat() {
    }

    @NonNull
    public static String toSafeString(@NonNull Uri uri) {
        String scheme = uri.getScheme();
        String schemeSpecificPart = uri.getSchemeSpecificPart();
        if (scheme != null) {
            if (scheme.equalsIgnoreCase("tel") || scheme.equalsIgnoreCase("sip") || scheme.equalsIgnoreCase("sms") || scheme.equalsIgnoreCase("smsto") || scheme.equalsIgnoreCase("mailto") || scheme.equalsIgnoreCase("nfc")) {
                StringBuilder sb = new StringBuilder(64);
                sb.append(scheme);
                sb.append(MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR);
                if (schemeSpecificPart != null) {
                    for (int i = 0; i < schemeSpecificPart.length(); i++) {
                        char cCharAt = schemeSpecificPart.charAt(i);
                        if (cCharAt == '-' || cCharAt == '@' || cCharAt == '.') {
                            sb.append(cCharAt);
                        } else {
                            sb.append('x');
                        }
                    }
                }
                return sb.toString();
            }
            if (scheme.equalsIgnoreCase("http") || scheme.equalsIgnoreCase(Constants.SCHEME) || scheme.equalsIgnoreCase("ftp") || scheme.equalsIgnoreCase("rtsp")) {
                StringBuilder sbM833U = C1643a.m833U("//");
                String string = "";
                sbM833U.append(uri.getHost() != null ? uri.getHost() : "");
                if (uri.getPort() != -1) {
                    StringBuilder sbM833U2 = C1643a.m833U(":");
                    sbM833U2.append(uri.getPort());
                    string = sbM833U2.toString();
                }
                schemeSpecificPart = C1643a.m822J(sbM833U, string, "/...");
            }
        }
        StringBuilder sb2 = new StringBuilder(64);
        if (scheme != null) {
            sb2.append(scheme);
            sb2.append(MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR);
        }
        if (schemeSpecificPart != null) {
            sb2.append(schemeSpecificPart);
        }
        return sb2.toString();
    }
}
