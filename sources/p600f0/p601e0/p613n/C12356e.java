package p600f0.p601e0.p613n;

import androidx.core.app.NotificationCompat;
import androidx.core.view.PointerIconCompat;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import p507d0.p579g0.C12102s;
import p507d0.p579g0.C12103t;
import p507d0.p579g0.C12106w;
import p507d0.p592z.p594d.C12238m;
import p600f0.InterfaceC12269e;
import p600f0.InterfaceC12361f;
import p600f0.p601e0.C12272c;
import p600f0.p601e0.p605g.C12283c;

/* JADX INFO: renamed from: f0.e0.n.e */
/* JADX INFO: compiled from: RealWebSocket.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12356e implements InterfaceC12361f {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C12355d f25859a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Request f25860b;

    public C12356e(C12355d c12355d, Request request) {
        this.f25859a = c12355d;
        this.f25860b = request;
    }

    /* JADX WARN: Code duplicated, block: B:54:0x00e4 A[PHI: r15 r16
      0x00e4: PHI (r15v7 java.lang.Integer) = (r15v5 java.lang.Integer), (r15v5 java.lang.Integer), (r15v9 java.lang.Integer) binds: [B:48:0x00d8, B:45:0x00cf, B:29:0x00a3] A[DONT_GENERATE, DONT_INLINE]
      0x00e4: PHI (r16v10 java.lang.Integer) = (r16v5 java.lang.Integer), (r16v7 java.lang.Integer), (r16v5 java.lang.Integer) binds: [B:48:0x00d8, B:45:0x00cf, B:29:0x00a3] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // p600f0.InterfaceC12361f
    /* JADX INFO: renamed from: a */
    public void mo10358a(InterfaceC12269e interfaceC12269e, Response response) {
        int iIntValue;
        C12238m.checkParameterIsNotNull(interfaceC12269e, NotificationCompat.CATEGORY_CALL);
        C12238m.checkParameterIsNotNull(response, "response");
        C12283c c12283c = response.exchange;
        try {
            this.f25859a.m10352h(response, c12283c);
            C12355d.c cVarM10170d = c12283c.m10170d();
            Headers headers = response.headers;
            C12238m.checkParameterIsNotNull(headers, "responseHeaders");
            int size = headers.size();
            int i = 0;
            int i2 = 0;
            boolean z2 = false;
            boolean z3 = false;
            boolean z4 = false;
            Integer intOrNull = null;
            Integer intOrNull2 = null;
            boolean z5 = false;
            while (i2 < size) {
                if (C12103t.equals(headers.m10955d(i2), "Sec-WebSocket-Extensions", true)) {
                    String strM10957g = headers.m10957g(i2);
                    int i3 = 0;
                    while (i3 < strM10957g.length()) {
                        int iM10127h = C12272c.m10127h(strM10957g, ',', i3, i, 4);
                        int iM10125f = C12272c.m10125f(strM10957g, ';', i3, iM10127h);
                        String strM10118C = C12272c.m10118C(strM10957g, i3, iM10125f);
                        int i4 = iM10125f + 1;
                        if (C12103t.equals(strM10118C, "permessage-deflate", true)) {
                            if (z2) {
                                z5 = true;
                            }
                            while (i4 < iM10127h) {
                                int iM10125f2 = C12272c.m10125f(strM10957g, ';', i4, iM10127h);
                                int iM10125f3 = C12272c.m10125f(strM10957g, '=', i4, iM10125f2);
                                String strM10118C2 = C12272c.m10118C(strM10957g, i4, iM10125f3);
                                String strRemoveSurrounding = iM10125f3 < iM10125f2 ? C12106w.removeSurrounding(C12272c.m10118C(strM10957g, iM10125f3 + 1, iM10125f2), "\"") : null;
                                int i5 = iM10125f2 + 1;
                                if (C12103t.equals(strM10118C2, "client_max_window_bits", true)) {
                                    if (intOrNull != null) {
                                        z5 = true;
                                    }
                                    intOrNull = strRemoveSurrounding != null ? C12102s.toIntOrNull(strRemoveSurrounding) : null;
                                    if (intOrNull == null) {
                                        z5 = true;
                                    }
                                } else if (C12103t.equals(strM10118C2, "client_no_context_takeover", true)) {
                                    if (z3) {
                                        z5 = true;
                                    }
                                    if (strRemoveSurrounding != null) {
                                        z5 = true;
                                    }
                                    z3 = true;
                                } else if (C12103t.equals(strM10118C2, "server_max_window_bits", true)) {
                                    if (intOrNull2 != null) {
                                        z5 = true;
                                    }
                                    intOrNull2 = strRemoveSurrounding != null ? C12102s.toIntOrNull(strRemoveSurrounding) : null;
                                    if (intOrNull2 == null) {
                                        z5 = true;
                                    }
                                } else if (C12103t.equals(strM10118C2, "server_no_context_takeover", true)) {
                                    if (z4) {
                                        z5 = true;
                                    }
                                    if (strRemoveSurrounding != null) {
                                        z5 = true;
                                    }
                                    z4 = true;
                                } else {
                                    z5 = true;
                                }
                                i4 = i5;
                            }
                            i3 = i4;
                            z2 = true;
                        } else {
                            i3 = i4;
                            z5 = true;
                        }
                        i = 0;
                    }
                }
                i2++;
                i = 0;
            }
            this.f25859a.f25845y = new C12357f(z2, intOrNull, z3, intOrNull2, z4, z5);
            if (!(!z5 && intOrNull == null && (intOrNull2 == null || (8 <= (iIntValue = intOrNull2.intValue()) && 15 >= iIntValue)))) {
                synchronized (this.f25859a) {
                    this.f25859a.f25831k.clear();
                    this.f25859a.mo10349e(PointerIconCompat.TYPE_ALIAS, "unexpected Sec-WebSocket-Extensions in response header");
                }
            }
            try {
                this.f25859a.m10354j(C12272c.f25403g + " WebSocket " + this.f25860b.url.m10406h(), cVarM10170d);
                C12355d c12355d = this.f25859a;
                c12355d.f25842v.onOpen(c12355d, response);
                this.f25859a.m10355k();
            } catch (Exception e) {
                this.f25859a.m10353i(e, null);
            }
        } catch (IOException e2) {
            if (c12283c != null) {
                c12283c.m10167a(-1L, true, true, null);
            }
            this.f25859a.m10353i(e2, response);
            byte[] bArr = C12272c.f25397a;
            C12238m.checkParameterIsNotNull(response, "$this$closeQuietly");
            try {
                response.close();
            } catch (RuntimeException e3) {
                throw e3;
            } catch (Exception unused) {
            }
        }
    }

    @Override // p600f0.InterfaceC12361f
    /* JADX INFO: renamed from: b */
    public void mo10359b(InterfaceC12269e interfaceC12269e, IOException iOException) {
        C12238m.checkParameterIsNotNull(interfaceC12269e, NotificationCompat.CATEGORY_CALL);
        C12238m.checkParameterIsNotNull(iOException, "e");
        this.f25859a.m10353i(iOException, null);
    }
}
