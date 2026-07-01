package f0.e0.j;

import androidx.browser.trusted.sharing.ShareTarget;
import com.adjust.sdk.Constants;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: compiled from: Hpack.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public static final b[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<ByteString, Integer> f3634b;
    public static final c c = new c();

    static {
        b bVar = new b(b.f, "");
        ByteString byteString = b.c;
        ByteString byteString2 = b.d;
        ByteString byteString3 = b.e;
        ByteString byteString4 = b.f3633b;
        b[] bVarArr = {bVar, new b(byteString, ShareTarget.METHOD_GET), new b(byteString, ShareTarget.METHOD_POST), new b(byteString2, AutocompleteViewModel.COMMAND_DISCOVER_TOKEN), new b(byteString2, "/index.html"), new b(byteString3, "http"), new b(byteString3, Constants.SCHEME), new b(byteString4, "200"), new b(byteString4, "204"), new b(byteString4, "206"), new b(byteString4, "304"), new b(byteString4, "400"), new b(byteString4, "404"), new b(byteString4, "500"), new b("accept-charset", ""), new b("accept-encoding", "gzip, deflate"), new b("accept-language", ""), new b("accept-ranges", ""), new b("accept", ""), new b("access-control-allow-origin", ""), new b("age", ""), new b(ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS_GRANTED, ""), new b("authorization", ""), new b("cache-control", ""), new b("content-disposition", ""), new b("content-encoding", ""), new b("content-language", ""), new b("content-length", ""), new b("content-location", ""), new b("content-range", ""), new b("content-type", ""), new b("cookie", ""), new b("date", ""), new b("etag", ""), new b("expect", ""), new b("expires", ""), new b("from", ""), new b("host", ""), new b("if-match", ""), new b("if-modified-since", ""), new b("if-none-match", ""), new b("if-range", ""), new b("if-unmodified-since", ""), new b("last-modified", ""), new b("link", ""), new b(ModelAuditLogEntry.CHANGE_KEY_LOCATION, ""), new b("max-forwards", ""), new b("proxy-authenticate", ""), new b("proxy-authorization", ""), new b("range", ""), new b("referer", ""), new b("refresh", ""), new b("retry-after", ""), new b("server", ""), new b("set-cookie", ""), new b("strict-transport-security", ""), new b("transfer-encoding", ""), new b("user-agent", ""), new b("vary", ""), new b("via", ""), new b("www-authenticate", "")};
        a = bVarArr;
        LinkedHashMap linkedHashMap = new LinkedHashMap(bVarArr.length);
        int length = bVarArr.length;
        for (int i = 0; i < length; i++) {
            b[] bVarArr2 = a;
            if (!linkedHashMap.containsKey(bVarArr2[i].h)) {
                linkedHashMap.put(bVarArr2[i].h, Integer.valueOf(i));
            }
        }
        Map<ByteString, Integer> mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        d0.z.d.m.checkExpressionValueIsNotNull(mapUnmodifiableMap, "Collections.unmodifiableMap(result)");
        f3634b = mapUnmodifiableMap;
    }

    public final ByteString a(ByteString byteString) throws IOException {
        d0.z.d.m.checkParameterIsNotNull(byteString, ModelAuditLogEntry.CHANGE_KEY_NAME);
        int iJ = byteString.j();
        for (int i = 0; i < iJ; i++) {
            byte b2 = (byte) 65;
            byte b3 = (byte) 90;
            byte bM = byteString.m(i);
            if (b2 <= bM && b3 >= bM) {
                StringBuilder sbU = b.d.b.a.a.U("PROTOCOL_ERROR response malformed: mixed case name: ");
                sbU.append(byteString.q());
                throw new IOException(sbU.toString());
            }
        }
        return byteString;
    }
}
