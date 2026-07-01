package f0.e0.n;

import androidx.core.app.NotificationCompat;
import androidx.core.view.PointerIconCompat;
import d0.g0.StringNumberConversions;
import d0.g0.Strings4;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import f0.Call2;
import f0.Callback2;
import f0.e0.Util7;
import f0.e0.g.Exchange;
import f0.e0.n.RealWebSocket;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: renamed from: f0.e0.n.e, reason: use source file name */
/* JADX INFO: compiled from: RealWebSocket.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class RealWebSocket2 implements Callback2 {
    public final /* synthetic */ RealWebSocket a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Request f3663b;

    public RealWebSocket2(RealWebSocket realWebSocket, Request request) {
        this.a = realWebSocket;
        this.f3663b = request;
    }

    /* JADX WARN: Code duplicated, block: B:54:0x00e4 A[PHI: r15 r16
      0x00e4: PHI (r15v7 java.lang.Integer) = (r15v5 java.lang.Integer), (r15v5 java.lang.Integer), (r15v9 java.lang.Integer) binds: [B:48:0x00d8, B:45:0x00cf, B:29:0x00a3] A[DONT_GENERATE, DONT_INLINE]
      0x00e4: PHI (r16v10 java.lang.Integer) = (r16v5 java.lang.Integer), (r16v7 java.lang.Integer), (r16v5 java.lang.Integer) binds: [B:48:0x00d8, B:45:0x00cf, B:29:0x00a3] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // f0.Callback2
    public void a(Call2 call2, Response response) {
        int iIntValue;
        Intrinsics3.checkParameterIsNotNull(call2, NotificationCompat.CATEGORY_CALL);
        Intrinsics3.checkParameterIsNotNull(response, "response");
        Exchange exchange = response.exchange;
        try {
            this.a.h(response, exchange);
            RealWebSocket.c cVarD = exchange.d();
            Headers headers = response.headers;
            Intrinsics3.checkParameterIsNotNull(headers, "responseHeaders");
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
                if (StringsJVM.equals(headers.d(i2), "Sec-WebSocket-Extensions", true)) {
                    String strG = headers.g(i2);
                    int i3 = 0;
                    while (i3 < strG.length()) {
                        int iH = Util7.h(strG, ',', i3, i, 4);
                        int iF = Util7.f(strG, ';', i3, iH);
                        String strC = Util7.C(strG, i3, iF);
                        int i4 = iF + 1;
                        if (StringsJVM.equals(strC, "permessage-deflate", true)) {
                            if (z2) {
                                z5 = true;
                            }
                            while (i4 < iH) {
                                int iF2 = Util7.f(strG, ';', i4, iH);
                                int iF3 = Util7.f(strG, '=', i4, iF2);
                                String strC2 = Util7.C(strG, i4, iF3);
                                String strRemoveSurrounding = iF3 < iF2 ? Strings4.removeSurrounding(Util7.C(strG, iF3 + 1, iF2), "\"") : null;
                                int i5 = iF2 + 1;
                                if (StringsJVM.equals(strC2, "client_max_window_bits", true)) {
                                    if (intOrNull != null) {
                                        z5 = true;
                                    }
                                    intOrNull = strRemoveSurrounding != null ? StringNumberConversions.toIntOrNull(strRemoveSurrounding) : null;
                                    if (intOrNull == null) {
                                        z5 = true;
                                    }
                                } else if (StringsJVM.equals(strC2, "client_no_context_takeover", true)) {
                                    if (z3) {
                                        z5 = true;
                                    }
                                    if (strRemoveSurrounding != null) {
                                        z5 = true;
                                    }
                                    z3 = true;
                                } else if (StringsJVM.equals(strC2, "server_max_window_bits", true)) {
                                    if (intOrNull2 != null) {
                                        z5 = true;
                                    }
                                    intOrNull2 = strRemoveSurrounding != null ? StringNumberConversions.toIntOrNull(strRemoveSurrounding) : null;
                                    if (intOrNull2 == null) {
                                        z5 = true;
                                    }
                                } else if (StringsJVM.equals(strC2, "server_no_context_takeover", true)) {
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
            this.a.f3659y = new WebSocketExtensions(z2, intOrNull, z3, intOrNull2, z4, z5);
            if (!(!z5 && intOrNull == null && (intOrNull2 == null || (8 <= (iIntValue = intOrNull2.intValue()) && 15 >= iIntValue)))) {
                synchronized (this.a) {
                    this.a.k.clear();
                    this.a.e(PointerIconCompat.TYPE_ALIAS, "unexpected Sec-WebSocket-Extensions in response header");
                }
            }
            try {
                this.a.j(Util7.g + " WebSocket " + this.f3663b.url.h(), cVarD);
                RealWebSocket realWebSocket = this.a;
                realWebSocket.v.onOpen(realWebSocket, response);
                this.a.k();
            } catch (Exception e) {
                this.a.i(e, null);
            }
        } catch (IOException e2) {
            if (exchange != null) {
                exchange.a(-1L, true, true, null);
            }
            this.a.i(e2, response);
            byte[] bArr = Util7.a;
            Intrinsics3.checkParameterIsNotNull(response, "$this$closeQuietly");
            try {
                response.close();
            } catch (RuntimeException e3) {
                throw e3;
            } catch (Exception unused) {
            }
        }
    }

    @Override // f0.Callback2
    public void b(Call2 call2, IOException iOException) {
        Intrinsics3.checkParameterIsNotNull(call2, NotificationCompat.CATEGORY_CALL);
        Intrinsics3.checkParameterIsNotNull(iOException, "e");
        this.a.i(iOException, null);
    }
}
