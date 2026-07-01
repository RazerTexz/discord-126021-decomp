package f0.e0.i;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.MentionUtils;
import d0.g0.Strings4;
import d0.z.d.Intrinsics3;
import g0.BufferedSource;
import java.io.IOException;
import java.util.ArrayList;
import kotlin.TypeCastException;
import okhttp3.Headers;

/* JADX INFO: renamed from: f0.e0.i.a, reason: use source file name */
/* JADX INFO: compiled from: HeadersReader.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class HeadersReader {
    public long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BufferedSource f3631b;

    public HeadersReader(BufferedSource bufferedSource) {
        Intrinsics3.checkParameterIsNotNull(bufferedSource, "source");
        this.f3631b = bufferedSource;
        this.a = 262144;
    }

    public final Headers a() throws IOException {
        ArrayList arrayList = new ArrayList(20);
        while (true) {
            String strB = b();
            if (strB.length() == 0) {
                break;
            }
            Intrinsics3.checkParameterIsNotNull(strB, "line");
            int iIndexOf$default = Strings4.indexOf$default((CharSequence) strB, MentionUtils.EMOJIS_AND_STICKERS_CHAR, 1, false, 4, (Object) null);
            if (iIndexOf$default != -1) {
                String strSubstring = strB.substring(0, iIndexOf$default);
                Intrinsics3.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                String strSubstring2 = strB.substring(iIndexOf$default + 1);
                Intrinsics3.checkExpressionValueIsNotNull(strSubstring2, "(this as java.lang.String).substring(startIndex)");
                Intrinsics3.checkParameterIsNotNull(strSubstring, ModelAuditLogEntry.CHANGE_KEY_NAME);
                Intrinsics3.checkParameterIsNotNull(strSubstring2, "value");
                arrayList.add(strSubstring);
                arrayList.add(Strings4.trim(strSubstring2).toString());
            } else if (strB.charAt(0) == ':') {
                String strSubstring3 = strB.substring(1);
                Intrinsics3.checkExpressionValueIsNotNull(strSubstring3, "(this as java.lang.String).substring(startIndex)");
                Intrinsics3.checkParameterIsNotNull("", ModelAuditLogEntry.CHANGE_KEY_NAME);
                Intrinsics3.checkParameterIsNotNull(strSubstring3, "value");
                arrayList.add("");
                arrayList.add(Strings4.trim(strSubstring3).toString());
            } else {
                Intrinsics3.checkParameterIsNotNull("", ModelAuditLogEntry.CHANGE_KEY_NAME);
                Intrinsics3.checkParameterIsNotNull(strB, "value");
                arrayList.add("");
                arrayList.add(Strings4.trim(strB).toString());
            }
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return new Headers((String[]) array, null);
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public final String b() throws IOException {
        String strG = this.f3631b.G(this.a);
        this.a -= (long) strG.length();
        return strG;
    }
}
