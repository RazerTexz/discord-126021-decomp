package b.a.r;

import android.net.Uri;
import androidx.browser.trusted.sharing.ShareTarget;
import androidx.core.os.EnvironmentCompat;
import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.samsung.SamsungConnect3;
import d0.Result3;
import d0.Tuples;
import d0.g0.Strings4;
import d0.t.Maps6;
import d0.t._Collections;
import d0.w.h.Intrinsics2;
import d0.w.i.a.ContinuationImpl6;
import d0.w.i.a.DebugMetadata;
import d0.z.d.Intrinsics3;
import f0.OkHttpClient;
import f0.e0.g.RealCall;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/* JADX INFO: renamed from: b.a.r.b, reason: use source file name */
/* JADX INFO: compiled from: SamsungConnect.kt */
/* JADX INFO: loaded from: classes.dex */
@DebugMetadata(c = "com.discord.samsung.SamsungConnect$postSamsungAuthorizeCallback$2", f = "SamsungConnect.kt", l = {}, m = "invokeSuspend")
public final class SamsungConnect2 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Uri>, Object> {
    public final /* synthetic */ OkHttpClient $okHttpClient;
    public final /* synthetic */ String $samsungAuthCode;
    public final /* synthetic */ String $state;
    public final /* synthetic */ String $url;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SamsungConnect2(String str, String str2, String str3, OkHttpClient okHttpClient, Continuation continuation) {
        super(2, continuation);
        this.$state = str;
        this.$samsungAuthCode = str2;
        this.$url = str3;
        this.$okHttpClient = okHttpClient;
    }

    @Override // d0.w.i.a.ContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics3.checkNotNullParameter(continuation, "completion");
        return new SamsungConnect2(this.$state, this.$samsungAuthCode, this.$url, this.$okHttpClient, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Uri> continuation) {
        return ((SamsungConnect2) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x00f1  */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00f2, code lost:
    
        if (r2 != false) goto L29;
     */
    @Override // d0.w.i.a.ContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        String queryParameter;
        String query;
        Intrinsics2.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Result3.throwOnFailure(obj);
        boolean z2 = false;
        StringBuilder sbU = outline.U("{\"code\":\"");
        sbU.append(this.$samsungAuthCode);
        sbU.append("\"}");
        Map mapMapOf = Maps6.mapOf(Tuples.to("state", this.$state), Tuples.to(ModelAuditLogEntry.CHANGE_KEY_CODE, sbU.toString()));
        ArrayList arrayList = new ArrayList(mapMapOf.size());
        for (Map.Entry entry : mapMapOf.entrySet()) {
            arrayList.add(((String) entry.getKey()) + '=' + ((String) entry.getValue()));
        }
        String strJoinToString$default = _Collections.joinToString$default(arrayList, "&", null, null, 0, null, null, 62, null);
        RequestBody.Companion companion = RequestBody.INSTANCE;
        MediaType.Companion companion2 = MediaType.INSTANCE;
        RequestBody requestBodyA = companion.a(strJoinToString$default, MediaType.Companion.a(ShareTarget.ENCODING_TYPE_URL_ENCODED));
        Request.a aVar = new Request.a();
        Intrinsics3.checkParameterIsNotNull(requestBodyA, "body");
        aVar.c(ShareTarget.METHOD_POST, requestBodyA);
        aVar.f(this.$url);
        Response responseExecute = ((RealCall) this.$okHttpClient.b(aVar.a())).execute();
        String strA = Response.a(responseExecute, "Location", null, 2);
        Uri uri = strA != null ? Uri.parse(strA) : null;
        if (!((uri == null || (query = uri.getQuery()) == null) ? false : Strings4.contains$default((CharSequence) query, (CharSequence) "error", false, 2, (Object) null))) {
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
        Intrinsics3.checkNotNullExpressionValue(queryParameter, "location?.getQueryParameter(\"error\") ?: \"unknown\"");
        throw new SamsungConnect3(queryParameter, uri != null ? uri.getQueryParameter("error_description") : null);
    }
}
