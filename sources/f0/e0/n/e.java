package f0.e0.n;

import androidx.core.app.NotificationCompat;
import androidx.core.view.PointerIconCompat;
import d0.g0.s;
import d0.g0.t;
import d0.g0.w;
import d0.z.d.m;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: compiled from: RealWebSocket.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e implements f0.f {
    public final /* synthetic */ d a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Request f3663b;

    public e(d dVar, Request request) {
        this.a = dVar;
        this.f3663b = request;
    }

    /* JADX WARN: Code duplicated, block: B:54:0x00e4 A[PHI: r15 r16
      0x00e4: PHI (r15v7 java.lang.Integer) = (r15v5 java.lang.Integer), (r15v5 java.lang.Integer), (r15v9 java.lang.Integer) binds: [B:48:0x00d8, B:45:0x00cf, B:29:0x00a3] A[DONT_GENERATE, DONT_INLINE]
      0x00e4: PHI (r16v10 java.lang.Integer) = (r16v5 java.lang.Integer), (r16v7 java.lang.Integer), (r16v5 java.lang.Integer) binds: [B:48:0x00d8, B:45:0x00cf, B:29:0x00a3] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // f0.f
    public void a(f0.e eVar, Response response) {
        int iIntValue;
        m.checkParameterIsNotNull(eVar, NotificationCompat.CATEGORY_CALL);
        m.checkParameterIsNotNull(response, "response");
        f0.e0.g.c cVar = response.exchange;
        try {
            this.a.h(response, cVar);
            d$c d_cD = cVar.d();
            Headers headers = response.headers;
            m.checkParameterIsNotNull(headers, "responseHeaders");
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
                if (t.equals(headers.d(i2), "Sec-WebSocket-Extensions", true)) {
                    String strG = headers.g(i2);
                    int i3 = 0;
                    while (i3 < strG.length()) {
                        int iH = f0.e0.c.h(strG, ',', i3, i, 4);
                        int iF = f0.e0.c.f(strG, ';', i3, iH);
                        String strC = f0.e0.c.C(strG, i3, iF);
                        int i4 = iF + 1;
                        if (t.equals(strC, "permessage-deflate", true)) {
                            if (z2) {
                                z5 = true;
                            }
                            while (i4 < iH) {
                                int iF2 = f0.e0.c.f(strG, ';', i4, iH);
                                int iF3 = f0.e0.c.f(strG, '=', i4, iF2);
                                String strC2 = f0.e0.c.C(strG, i4, iF3);
                                String strRemoveSurrounding = iF3 < iF2 ? w.removeSurrounding(f0.e0.c.C(strG, iF3 + 1, iF2), "\"") : null;
                                int i5 = iF2 + 1;
                                if (t.equals(strC2, "client_max_window_bits", true)) {
                                    if (intOrNull != null) {
                                        z5 = true;
                                    }
                                    intOrNull = strRemoveSurrounding != null ? s.toIntOrNull(strRemoveSurrounding) : null;
                                    if (intOrNull == null) {
                                        z5 = true;
                                    }
                                } else if (t.equals(strC2, "client_no_context_takeover", true)) {
                                    if (z3) {
                                        z5 = true;
                                    }
                                    if (strRemoveSurrounding != null) {
                                        z5 = true;
                                    }
                                    z3 = true;
                                } else if (t.equals(strC2, "server_max_window_bits", true)) {
                                    if (intOrNull2 != null) {
                                        z5 = true;
                                    }
                                    intOrNull2 = strRemoveSurrounding != null ? s.toIntOrNull(strRemoveSurrounding) : null;
                                    if (intOrNull2 == null) {
                                        z5 = true;
                                    }
                                } else if (t.equals(strC2, "server_no_context_takeover", true)) {
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
            this.a.f3659y = new f(z2, intOrNull, z3, intOrNull2, z4, z5);
            if (!(!z5 && intOrNull == null && (intOrNull2 == null || (8 <= (iIntValue = intOrNull2.intValue()) && 15 >= iIntValue)))) {
                synchronized (this.a) {
                    this.a.k.clear();
                    this.a.e(PointerIconCompat.TYPE_ALIAS, "unexpected Sec-WebSocket-Extensions in response header");
                }
            }
            try {
                this.a.j(f0.e0.c.g + " WebSocket " + this.f3663b.url.h(), d_cD);
                d dVar = this.a;
                dVar.v.onOpen(dVar, response);
                this.a.k();
            } catch (Exception e) {
                this.a.i(e, null);
            }
        } catch (IOException e2) {
            if (cVar != null) {
                cVar.a(-1L, true, true, null);
            }
            this.a.i(e2, response);
            byte[] bArr = f0.e0.c.a;
            m.checkParameterIsNotNull(response, "$this$closeQuietly");
            try {
                response.close();
            } catch (RuntimeException e3) {
                throw e3;
            } catch (Exception unused) {
            }
        }
    }

    @Override // f0.f
    public void b(f0.e eVar, IOException iOException) {
        m.checkParameterIsNotNull(eVar, NotificationCompat.CATEGORY_CALL);
        m.checkParameterIsNotNull(iOException, "e");
        this.a.i(iOException, null);
    }
}
