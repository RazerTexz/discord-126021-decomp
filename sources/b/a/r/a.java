package b.a.r;

import android.net.Uri;
import androidx.browser.trusted.sharing.ShareTarget;
import androidx.core.os.EnvironmentCompat;
import com.discord.samsung.SamsungConnect$SamsungCallbackException;
import d0.g0.w;
import d0.l;
import d0.w.i.a.e;
import d0.w.i.a.k;
import d0.z.d.m;
import f0.x;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.Request$a;
import okhttp3.Response;

/* JADX INFO: compiled from: SamsungConnect.kt */
/* JADX INFO: loaded from: classes.dex */
@e(c = "com.discord.samsung.SamsungConnect$getSamsungAuthorizeCallback$2", f = "SamsungConnect.kt", l = {}, m = "invokeSuspend")
public final class a extends k implements Function2<CoroutineScope, Continuation<? super Uri>, Object> {
    public final /* synthetic */ x $okHttpClient;
    public final /* synthetic */ String $url;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(String str, x xVar, Continuation continuation) {
        super(2, continuation);
        this.$url = str;
        this.$okHttpClient = xVar;
    }

    @Override // d0.w.i.a.a
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        m.checkNotNullParameter(continuation, "completion");
        return new a(this.$url, this.$okHttpClient, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Uri> continuation) {
        Continuation<? super Uri> continuation2 = continuation;
        m.checkNotNullParameter(continuation2, "completion");
        return new a(this.$url, this.$okHttpClient, continuation2).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0060  */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0061, code lost:
    
        if (r4 != false) goto L25;
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
        Request$a request$a = new Request$a();
        request$a.c(ShareTarget.METHOD_GET, null);
        request$a.f(this.$url);
        Response responseExecute = ((f0.e0.g.e) this.$okHttpClient.b(request$a.a())).execute();
        String strA = Response.a(responseExecute, "Location", null, 2);
        Uri uri = strA != null ? Uri.parse(strA) : null;
        boolean z2 = false;
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
