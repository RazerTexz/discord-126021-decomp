package p600f0.p601e0.p607i;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.MentionUtilsKt;
import java.io.IOException;
import java.util.ArrayList;
import kotlin.TypeCastException;
import okhttp3.Headers;
import p507d0.p579g0.C12106w;
import p507d0.p592z.p594d.C12238m;
import p615g0.InterfaceC12390g;

/* JADX INFO: renamed from: f0.e0.i.a */
/* JADX INFO: compiled from: HeadersReader.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12305a {

    /* JADX INFO: renamed from: a */
    public long f25547a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC12390g f25548b;

    public C12305a(InterfaceC12390g interfaceC12390g) {
        C12238m.checkParameterIsNotNull(interfaceC12390g, "source");
        this.f25548b = interfaceC12390g;
        this.f25547a = 262144;
    }

    /* JADX INFO: renamed from: a */
    public final Headers m10235a() throws IOException {
        ArrayList arrayList = new ArrayList(20);
        while (true) {
            String strM10236b = m10236b();
            if (strM10236b.length() == 0) {
                break;
            }
            C12238m.checkParameterIsNotNull(strM10236b, "line");
            int iIndexOf$default = C12106w.indexOf$default((CharSequence) strM10236b, MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR, 1, false, 4, (Object) null);
            if (iIndexOf$default != -1) {
                String strSubstring = strM10236b.substring(0, iIndexOf$default);
                C12238m.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                String strSubstring2 = strM10236b.substring(iIndexOf$default + 1);
                C12238m.checkExpressionValueIsNotNull(strSubstring2, "(this as java.lang.String).substring(startIndex)");
                C12238m.checkParameterIsNotNull(strSubstring, ModelAuditLogEntry.CHANGE_KEY_NAME);
                C12238m.checkParameterIsNotNull(strSubstring2, "value");
                arrayList.add(strSubstring);
                arrayList.add(C12106w.trim(strSubstring2).toString());
            } else if (strM10236b.charAt(0) == ':') {
                String strSubstring3 = strM10236b.substring(1);
                C12238m.checkExpressionValueIsNotNull(strSubstring3, "(this as java.lang.String).substring(startIndex)");
                C12238m.checkParameterIsNotNull("", ModelAuditLogEntry.CHANGE_KEY_NAME);
                C12238m.checkParameterIsNotNull(strSubstring3, "value");
                arrayList.add("");
                arrayList.add(C12106w.trim(strSubstring3).toString());
            } else {
                C12238m.checkParameterIsNotNull("", ModelAuditLogEntry.CHANGE_KEY_NAME);
                C12238m.checkParameterIsNotNull(strM10236b, "value");
                arrayList.add("");
                arrayList.add(C12106w.trim(strM10236b).toString());
            }
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return new Headers((String[]) array, null);
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    /* JADX INFO: renamed from: b */
    public final String m10236b() throws IOException {
        String strMo10432G = this.f25548b.mo10432G(this.f25547a);
        this.f25547a -= (long) strMo10432G.length();
        return strMo10432G;
    }
}
