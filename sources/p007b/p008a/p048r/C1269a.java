package p007b.p008a.p048r;

import android.net.Uri;
import androidx.browser.trusted.sharing.ShareTarget;
import androidx.core.os.EnvironmentCompat;
import com.discord.samsung.SamsungConnect$SamsungCallbackException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.Request;
import okhttp3.Response;
import p507d0.C12113l;
import p507d0.p579g0.C12106w;
import p507d0.p584w.p585h.C12183c;
import p507d0.p584w.p586i.p587a.AbstractC12194k;
import p507d0.p584w.p586i.p587a.InterfaceC12188e;
import p507d0.p592z.p594d.C12238m;
import p600f0.C12380x;
import p600f0.p601e0.p605g.C12285e;

/* JADX INFO: renamed from: b.a.r.a */
/* JADX INFO: compiled from: SamsungConnect.kt */
/* JADX INFO: loaded from: classes.dex */
@InterfaceC12188e(m10084c = "com.discord.samsung.SamsungConnect$getSamsungAuthorizeCallback$2", m10085f = "SamsungConnect.kt", m10086l = {}, m10087m = "invokeSuspend")
public final class C1269a extends AbstractC12194k implements Function2<CoroutineScope, Continuation<? super Uri>, Object> {
    public final /* synthetic */ C12380x $okHttpClient;
    public final /* synthetic */ String $url;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1269a(String str, C12380x c12380x, Continuation continuation) {
        super(2, continuation);
        this.$url = str;
        this.$okHttpClient = c12380x;
    }

    @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        C12238m.checkNotNullParameter(continuation, "completion");
        return new C1269a(this.$url, this.$okHttpClient, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Uri> continuation) {
        Continuation<? super Uri> continuation2 = continuation;
        C12238m.checkNotNullParameter(continuation2, "completion");
        return new C1269a(this.$url, this.$okHttpClient, continuation2).invokeSuspend(Unit.f27425a);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0060  */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0061, code lost:
    
        if (r4 != false) goto L25;
     */
    @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        String queryParameter;
        String query;
        C12183c.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C12113l.throwOnFailure(obj);
        Request.C12935a c12935a = new Request.C12935a();
        c12935a.m10980c(ShareTarget.METHOD_GET, null);
        c12935a.m10983f(this.$url);
        Response responseExecute = ((C12285e) this.$okHttpClient.mo10114b(c12935a.m10978a())).execute();
        String strM10989a = Response.m10989a(responseExecute, "Location", null, 2);
        Uri uri = strM10989a != null ? Uri.parse(strM10989a) : null;
        boolean z2 = false;
        if (!((uri == null || (query = uri.getQuery()) == null) ? false : C12106w.contains$default((CharSequence) query, (CharSequence) "error", false, 2, (Object) null))) {
            if (!responseExecute.m10990b()) {
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
        C12238m.checkNotNullExpressionValue(queryParameter, "location?.getQueryParameter(\"error\") ?: \"unknown\"");
        throw new SamsungConnect$SamsungCallbackException(queryParameter, uri != null ? uri.getQueryParameter("error_description") : null);
    }
}
