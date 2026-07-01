package f0.e0.i;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.MentionUtilsKt;
import d0.g0.w;
import d0.z.d.m;
import g0.g;
import java.io.IOException;
import java.util.ArrayList;
import kotlin.TypeCastException;
import okhttp3.Headers;

/* JADX INFO: compiled from: HeadersReader.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f3631b;

    public a(g gVar) {
        m.checkParameterIsNotNull(gVar, "source");
        this.f3631b = gVar;
        this.a = 262144;
    }

    public final Headers a() throws IOException {
        ArrayList arrayList = new ArrayList(20);
        while (true) {
            String strB = b();
            if (strB.length() == 0) {
                break;
            }
            m.checkParameterIsNotNull(strB, "line");
            int iIndexOf$default = w.indexOf$default((CharSequence) strB, MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR, 1, false, 4, (Object) null);
            if (iIndexOf$default != -1) {
                String strSubstring = strB.substring(0, iIndexOf$default);
                m.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                String strSubstring2 = strB.substring(iIndexOf$default + 1);
                m.checkExpressionValueIsNotNull(strSubstring2, "(this as java.lang.String).substring(startIndex)");
                m.checkParameterIsNotNull(strSubstring, ModelAuditLogEntry.CHANGE_KEY_NAME);
                m.checkParameterIsNotNull(strSubstring2, "value");
                arrayList.add(strSubstring);
                arrayList.add(w.trim(strSubstring2).toString());
            } else if (strB.charAt(0) == ':') {
                String strSubstring3 = strB.substring(1);
                m.checkExpressionValueIsNotNull(strSubstring3, "(this as java.lang.String).substring(startIndex)");
                m.checkParameterIsNotNull("", ModelAuditLogEntry.CHANGE_KEY_NAME);
                m.checkParameterIsNotNull(strSubstring3, "value");
                arrayList.add("");
                arrayList.add(w.trim(strSubstring3).toString());
            } else {
                m.checkParameterIsNotNull("", ModelAuditLogEntry.CHANGE_KEY_NAME);
                m.checkParameterIsNotNull(strB, "value");
                arrayList.add("");
                arrayList.add(w.trim(strB).toString());
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
