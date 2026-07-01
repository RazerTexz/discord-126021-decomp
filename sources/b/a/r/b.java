package b.a.r;

import android.net.Uri;
import androidx.browser.trusted.sharing.ShareTarget;
import androidx.core.os.EnvironmentCompat;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.samsung.SamsungConnect$SamsungCallbackException;
import d0.g0.w;
import d0.l;
import d0.o;
import d0.t.h0;
import d0.t.u;
import d0.w.i.a.e;
import d0.w.i.a.k;
import d0.z.d.m;
import f0.x;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map$Entry;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.MediaType;
import okhttp3.MediaType$a;
import okhttp3.Request$a;
import okhttp3.RequestBody;
import okhttp3.RequestBody$Companion;
import okhttp3.Response;

/* JADX INFO: compiled from: SamsungConnect.kt */
/* JADX INFO: loaded from: classes.dex */
@e(c = "com.discord.samsung.SamsungConnect$postSamsungAuthorizeCallback$2", f = "SamsungConnect.kt", l = {}, m = "invokeSuspend")
public final class b extends k implements Function2<CoroutineScope, Continuation<? super Uri>, Object> {
    public final /* synthetic */ x $okHttpClient;
    public final /* synthetic */ String $samsungAuthCode;
    public final /* synthetic */ String $state;
    public final /* synthetic */ String $url;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(String str, String str2, String str3, x xVar, Continuation continuation) {
        super(2, continuation);
        this.$state = str;
        this.$samsungAuthCode = str2;
        this.$url = str3;
        this.$okHttpClient = xVar;
    }

    @Override // d0.w.i.a.a
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        m.checkNotNullParameter(continuation, "completion");
        return new b(this.$state, this.$samsungAuthCode, this.$url, this.$okHttpClient, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Uri> continuation) {
        return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x00f1  */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00f2, code lost:
    
        if (r2 != false) goto L29;
     */
    @Override // d0.w.i.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        String queryParameter;
        String query;
        d0.w.h.c.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        l.throwOnFailure(obj);
        boolean z2 = false;
        StringBuilder sbU = b.d.b.a.a.U("{\"code\":\"");
        sbU.append(this.$samsungAuthCode);
        sbU.append("\"}");
        Map mapMapOf = h0.mapOf(o.to("state", this.$state), o.to(ModelAuditLogEntry.CHANGE_KEY_CODE, sbU.toString()));
        ArrayList arrayList = new ArrayList(mapMapOf.size());
        for (Map$Entry map$Entry : mapMapOf.entrySet()) {
            arrayList.add(((String) map$Entry.getKey()) + '=' + ((String) map$Entry.getValue()));
        }
        String strJoinToString$default = u.joinToString$default(arrayList, "&", null, null, 0, null, null, 62, null);
        RequestBody$Companion requestBody$Companion = RequestBody.Companion;
        MediaType$a mediaType$a = MediaType.c;
        RequestBody requestBodyA = requestBody$Companion.a(strJoinToString$default, MediaType$a.a(ShareTarget.ENCODING_TYPE_URL_ENCODED));
        Request$a request$a = new Request$a();
        m.checkParameterIsNotNull(requestBodyA, "body");
        request$a.c(ShareTarget.METHOD_POST, requestBodyA);
        request$a.f(this.$url);
        Response responseExecute = ((f0.e0.g.e) this.$okHttpClient.b(request$a.a())).execute();
        String strA = Response.a(responseExecute, "Location", null, 2);
        Uri uri = strA != null ? Uri.parse(strA) : null;
        if (!((uri == null || (query = uri.getQuery()) == null) ? false : w.contains$default((CharSequence) query, (CharSequence) "error", false, 2, (Object) null))) {
            if (!responseExecute.b()) {
                int i = responseExecute.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String;
                if (i != 307 && i != 308) {
                    switch (i) {
                        case 300:
                        case 301:
                        case 302:
                        case 303:
                            z2 = true;
                            break;
                    }
                } else {
                    z2 = true;
                }
            }
            return uri;
        }
        if (uri == null || (queryParameter = uri.getQueryParameter("error")) == null) {
            queryParameter = EnvironmentCompat.MEDIA_UNKNOWN;
        }
        m.checkNotNullExpressionValue(queryParameter, "location?.getQueryParameter(\"error\") ?: \"unknown\"");
        throw new SamsungConnect$SamsungCallbackException(queryParameter, uri != null ? uri.getQueryParameter("error_description") : null);
    }
}
