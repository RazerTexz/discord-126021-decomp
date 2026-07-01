package b.a.r;

import android.net.Uri;
import androidx.browser.trusted.sharing.ShareTarget;
import androidx.core.os.EnvironmentCompat;
import com.discord.samsung.SamsungConnect3;
import d0.Result3;
import d0.g0.Strings4;
import d0.w.h.Intrinsics2;
import d0.w.i.a.ContinuationImpl6;
import d0.w.i.a.DebugMetadata;
import d0.z.d.Intrinsics3;
import f0.OkHttpClient;
import f0.e0.g.RealCall;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: renamed from: b.a.r.a, reason: use source file name */
/* JADX INFO: compiled from: SamsungConnect.kt */
/* JADX INFO: loaded from: classes.dex */
@DebugMetadata(c = "com.discord.samsung.SamsungConnect$getSamsungAuthorizeCallback$2", f = "SamsungConnect.kt", l = {}, m = "invokeSuspend")
public final class SamsungConnect extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Uri>, Object> {
    public final /* synthetic */ OkHttpClient $okHttpClient;
    public final /* synthetic */ String $url;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SamsungConnect(String str, OkHttpClient okHttpClient, Continuation continuation) {
        super(2, continuation);
        this.$url = str;
        this.$okHttpClient = okHttpClient;
    }

    @Override // d0.w.i.a.ContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics3.checkNotNullParameter(continuation, "completion");
        return new SamsungConnect(this.$url, this.$okHttpClient, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Uri> continuation) {
        Continuation<? super Uri> continuation2 = continuation;
        Intrinsics3.checkNotNullParameter(continuation2, "completion");
        return new SamsungConnect(this.$url, this.$okHttpClient, continuation2).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0060  */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0061, code lost:
    
        if (r4 != false) goto L25;
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
        Request.a aVar = new Request.a();
        aVar.c(ShareTarget.METHOD_GET, null);
        aVar.f(this.$url);
        Response responseExecute = ((RealCall) this.$okHttpClient.b(aVar.a())).execute();
        String strA = Response.a(responseExecute, "Location", null, 2);
        Uri uri = strA != null ? Uri.parse(strA) : null;
        boolean z2 = false;
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
