package b.i.a.b.i;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Log;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.b.Encoding2;
import b.i.a.b.i.e.AutoBatchedLogRequestEncoder;
import b.i.a.b.i.e.AutoValue_AndroidClientInfo;
import b.i.a.b.i.e.AutoValue_BatchedLogRequest;
import b.i.a.b.i.e.AutoValue_ClientInfo;
import b.i.a.b.i.e.AutoValue_LogEvent;
import b.i.a.b.i.e.AutoValue_LogRequest;
import b.i.a.b.i.e.AutoValue_NetworkConnectionInfo;
import b.i.a.b.i.e.BatchedLogRequest;
import b.i.a.b.i.e.ClientInfo2;
import b.i.a.b.i.e.NetworkConnectionInfo;
import b.i.a.b.i.e.QosTier;
import b.i.a.b.j.EncodedPayload;
import b.i.a.b.j.EventInternal;
import b.i.a.b.j.q.AutoValue_BackendRequest;
import b.i.a.b.j.q.AutoValue_BackendResponse;
import b.i.a.b.j.q.BackendRequest;
import b.i.a.b.j.q.BackendResponse;
import b.i.a.b.j.q.TransportBackend;
import b.i.a.b.j.s.RetryStrategy;
import b.i.a.b.j.v.Clock3;
import b.i.c.p.DataEncoder;
import b.i.c.p.h.JsonDataEncoderBuilder4;
import b.i.c.p.h.JsonDataEncoderBuilder5;
import com.adjust.sdk.Constants;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* JADX INFO: renamed from: b.i.a.b.i.d, reason: use source file name */
/* JADX INFO: compiled from: CctTransportBackend.java */
/* JADX INFO: loaded from: classes3.dex */
public final class CctTransportBackend3 implements TransportBackend {
    public final DataEncoder a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConnectivityManager f744b;
    public final Context c;
    public final URL d;
    public final Clock3 e;
    public final Clock3 f;
    public final int g;

    /* JADX INFO: renamed from: b.i.a.b.i.d$a */
    /* JADX INFO: compiled from: CctTransportBackend.java */
    public static final class a {
        public final URL a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final BatchedLogRequest f745b;

        @Nullable
        public final String c;

        public a(URL url, BatchedLogRequest batchedLogRequest, @Nullable String str) {
            this.a = url;
            this.f745b = batchedLogRequest;
            this.c = str;
        }
    }

    /* JADX INFO: renamed from: b.i.a.b.i.d$b */
    /* JADX INFO: compiled from: CctTransportBackend.java */
    public static final class b {
        public final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public final URL f746b;
        public final long c;

        public b(int i, @Nullable URL url, long j) {
            this.a = i;
            this.f746b = url;
            this.c = j;
        }
    }

    public CctTransportBackend3(Context context, Clock3 clock3, Clock3 clock4) {
        JsonDataEncoderBuilder5 jsonDataEncoderBuilder5 = new JsonDataEncoderBuilder5();
        ((AutoBatchedLogRequestEncoder) AutoBatchedLogRequestEncoder.a).a(jsonDataEncoderBuilder5);
        jsonDataEncoderBuilder5.e = true;
        this.a = new JsonDataEncoderBuilder4(jsonDataEncoderBuilder5);
        this.c = context;
        this.f744b = (ConnectivityManager) context.getSystemService("connectivity");
        this.d = c(CCTDestination.a);
        this.e = clock4;
        this.f = clock3;
        this.g = 40000;
    }

    public static URL c(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(outline.w("Invalid url: ", str), e);
        }
    }

    @Override // b.i.a.b.j.q.TransportBackend
    public BackendResponse a(BackendRequest backendRequest) {
        BackendResponse.a aVar;
        Integer numValueOf;
        String str;
        AutoValue_LogEvent.b bVar;
        BackendResponse.a aVar2 = BackendResponse.a.TRANSIENT_ERROR;
        HashMap map = new HashMap();
        AutoValue_BackendRequest autoValue_BackendRequest = (AutoValue_BackendRequest) backendRequest;
        for (EventInternal eventInternal : autoValue_BackendRequest.a) {
            String strG = eventInternal.g();
            if (map.containsKey(strG)) {
                ((List) map.get(strG)).add(eventInternal);
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(eventInternal);
                map.put(strG, arrayList);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = map.entrySet().iterator();
        while (true) {
            String str2 = null;
            if (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                EventInternal eventInternal2 = (EventInternal) ((List) entry.getValue()).get(0);
                QosTier qosTier = QosTier.DEFAULT;
                Long lValueOf = Long.valueOf(this.f.a());
                Long lValueOf2 = Long.valueOf(this.e.a());
                AutoValue_ClientInfo autoValue_ClientInfo = new AutoValue_ClientInfo(ClientInfo2.a.ANDROID_FIREBASE, new AutoValue_AndroidClientInfo(Integer.valueOf(eventInternal2.f("sdk-version")), eventInternal2.a("model"), eventInternal2.a("hardware"), eventInternal2.a("device"), eventInternal2.a("product"), eventInternal2.a("os-uild"), eventInternal2.a("manufacturer"), eventInternal2.a("fingerprint"), eventInternal2.a("locale"), eventInternal2.a("country"), eventInternal2.a("mcc_mnc"), eventInternal2.a("application_build"), null), null);
                try {
                    str = null;
                    numValueOf = Integer.valueOf(Integer.parseInt((String) entry.getKey()));
                } catch (NumberFormatException unused) {
                    numValueOf = null;
                    str = (String) entry.getKey();
                }
                ArrayList arrayList3 = new ArrayList();
                Iterator it2 = ((List) entry.getValue()).iterator();
                while (it2.hasNext()) {
                    EventInternal eventInternal3 = (EventInternal) it2.next();
                    EncodedPayload encodedPayloadD = eventInternal3.d();
                    Iterator it3 = it;
                    Encoding2 encoding2 = encodedPayloadD.a;
                    Iterator it4 = it2;
                    if (encoding2.equals(new Encoding2("proto"))) {
                        byte[] bArr = encodedPayloadD.f766b;
                        bVar = new AutoValue_LogEvent.b();
                        bVar.d = bArr;
                    } else {
                        if (encoding2.equals(new Encoding2("json"))) {
                            String str3 = new String(encodedPayloadD.f766b, Charset.forName(Constants.ENCODING));
                            bVar = new AutoValue_LogEvent.b();
                            bVar.e = str3;
                        } else {
                            Log.w(AnimatableValueParser.D0("CctTransportBackend"), String.format("Received event of unsupported encoding %s. Skipping...", encoding2));
                        }
                        it2 = it4;
                        it = it3;
                        aVar2 = aVar2;
                    }
                    bVar.a = Long.valueOf(eventInternal3.e());
                    bVar.c = Long.valueOf(eventInternal3.h());
                    String str4 = eventInternal3.b().get("tz-offset");
                    bVar.f = Long.valueOf(str4 == null ? 0L : Long.valueOf(str4).longValue());
                    bVar.g = new AutoValue_NetworkConnectionInfo(NetworkConnectionInfo.b.C.get(eventInternal3.f("net-type")), NetworkConnectionInfo.a.E.get(eventInternal3.f("mobile-subtype")), null);
                    if (eventInternal3.c() != null) {
                        bVar.f750b = eventInternal3.c();
                    }
                    String strW = bVar.a == null ? " eventTimeMs" : "";
                    if (bVar.c == null) {
                        strW = outline.w(strW, " eventUptimeMs");
                    }
                    if (bVar.f == null) {
                        strW = outline.w(strW, " timezoneOffsetSeconds");
                    }
                    if (!strW.isEmpty()) {
                        throw new IllegalStateException(outline.w("Missing required properties:", strW));
                    }
                    arrayList3.add(new AutoValue_LogEvent(bVar.a.longValue(), bVar.f750b, bVar.c.longValue(), bVar.d, bVar.e, bVar.f.longValue(), bVar.g, null));
                    it2 = it4;
                    it = it3;
                    aVar2 = aVar2;
                }
                Iterator it5 = it;
                BackendResponse.a aVar3 = aVar2;
                String strW2 = lValueOf == null ? " requestTimeMs" : "";
                if (lValueOf2 == null) {
                    strW2 = outline.w(strW2, " requestUptimeMs");
                }
                if (!strW2.isEmpty()) {
                    throw new IllegalStateException(outline.w("Missing required properties:", strW2));
                }
                arrayList2.add(new AutoValue_LogRequest(lValueOf.longValue(), lValueOf2.longValue(), autoValue_ClientInfo, numValueOf, str, arrayList3, qosTier, null));
                it = it5;
                aVar2 = aVar3;
            } else {
                BackendResponse.a aVar4 = aVar2;
                AutoValue_BatchedLogRequest autoValue_BatchedLogRequest = new AutoValue_BatchedLogRequest(arrayList2);
                URL urlC = this.d;
                if (autoValue_BackendRequest.f771b != null) {
                    try {
                        CCTDestination cCTDestinationA = CCTDestination.a(((AutoValue_BackendRequest) backendRequest).f771b);
                        String str5 = cCTDestinationA.g;
                        str2 = str5 != null ? str5 : null;
                        String str6 = cCTDestinationA.f;
                        if (str6 != null) {
                            urlC = c(str6);
                        }
                    } catch (IllegalArgumentException unused2) {
                        return BackendResponse.a();
                    }
                }
                try {
                    b bVar2 = (b) AnimatableValueParser.V1(5, new a(urlC, autoValue_BatchedLogRequest, str2), new CctTransportBackend(this), new RetryStrategy() { // from class: b.i.a.b.i.c
                    });
                    int i = bVar2.a;
                    if (i == 200) {
                        return new AutoValue_BackendResponse(BackendResponse.a.OK, bVar2.c);
                    }
                    if (i < 500 && i != 404) {
                        return BackendResponse.a();
                    }
                    aVar = aVar4;
                    try {
                        return new AutoValue_BackendResponse(aVar, -1L);
                    } catch (IOException e) {
                        e = e;
                        AnimatableValueParser.c0("CctTransportBackend", "Could not make request to the backend", e);
                        return new AutoValue_BackendResponse(aVar, -1L);
                    }
                } catch (IOException e2) {
                    e = e2;
                    aVar = aVar4;
                }
            }
        }
    }

    @Override // b.i.a.b.j.q.TransportBackend
    public EventInternal b(EventInternal eventInternal) {
        int subtype;
        NetworkInfo activeNetworkInfo = this.f744b.getActiveNetworkInfo();
        EventInternal.a aVarI = eventInternal.i();
        aVarI.c().put("sdk-version", String.valueOf(Build.VERSION.SDK_INT));
        aVarI.c().put("model", Build.MODEL);
        aVarI.c().put("hardware", Build.HARDWARE);
        aVarI.c().put("device", Build.DEVICE);
        aVarI.c().put("product", Build.PRODUCT);
        aVarI.c().put("os-uild", Build.ID);
        aVarI.c().put("manufacturer", Build.MANUFACTURER);
        aVarI.c().put("fingerprint", Build.FINGERPRINT);
        Calendar.getInstance();
        aVarI.c().put("tz-offset", String.valueOf(TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis()) / 1000));
        aVarI.c().put("net-type", String.valueOf(activeNetworkInfo == null ? NetworkConnectionInfo.b.NONE.f() : activeNetworkInfo.getType()));
        int i = -1;
        if (activeNetworkInfo == null) {
            subtype = NetworkConnectionInfo.a.UNKNOWN_MOBILE_SUBTYPE.f();
        } else {
            subtype = activeNetworkInfo.getSubtype();
            if (subtype == -1) {
                subtype = NetworkConnectionInfo.a.COMBINED.f();
            } else if (NetworkConnectionInfo.a.E.get(subtype) == null) {
                subtype = 0;
            }
        }
        aVarI.c().put("mobile-subtype", String.valueOf(subtype));
        aVarI.c().put("country", Locale.getDefault().getCountry());
        aVarI.c().put("locale", Locale.getDefault().getLanguage());
        aVarI.c().put("mcc_mnc", ((TelephonyManager) this.c.getSystemService("phone")).getSimOperator());
        Context context = this.c;
        try {
            i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            AnimatableValueParser.c0("CctTransportBackend", "Unable to find version code for package", e);
        }
        aVarI.c().put("application_build", Integer.toString(i));
        return aVarI.b();
    }
}
