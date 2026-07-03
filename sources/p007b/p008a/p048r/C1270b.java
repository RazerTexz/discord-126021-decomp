package p007b.p008a.p048r;

import android.net.Uri;
import androidx.browser.trusted.sharing.ShareTarget;
import androidx.core.os.EnvironmentCompat;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.samsung.SamsungConnect$SamsungCallbackException;
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
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12113l;
import p507d0.C12116o;
import p507d0.p579g0.C12106w;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12163u;
import p507d0.p584w.p585h.C12183c;
import p507d0.p584w.p586i.p587a.AbstractC12194k;
import p507d0.p584w.p586i.p587a.InterfaceC12188e;
import p507d0.p592z.p594d.C12238m;
import p600f0.C12380x;
import p600f0.p601e0.p605g.C12285e;

/* JADX INFO: renamed from: b.a.r.b */
/* JADX INFO: compiled from: SamsungConnect.kt */
/* JADX INFO: loaded from: classes.dex */
@InterfaceC12188e(m10084c = "com.discord.samsung.SamsungConnect$postSamsungAuthorizeCallback$2", m10085f = "SamsungConnect.kt", m10086l = {}, m10087m = "invokeSuspend")
public final class C1270b extends AbstractC12194k implements Function2<CoroutineScope, Continuation<? super Uri>, Object> {
    public final /* synthetic */ C12380x $okHttpClient;
    public final /* synthetic */ String $samsungAuthCode;
    public final /* synthetic */ String $state;
    public final /* synthetic */ String $url;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1270b(String str, String str2, String str3, C12380x c12380x, Continuation continuation) {
        super(2, continuation);
        this.$state = str;
        this.$samsungAuthCode = str2;
        this.$url = str3;
        this.$okHttpClient = c12380x;
    }

    @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        C12238m.checkNotNullParameter(continuation, "completion");
        return new C1270b(this.$state, this.$samsungAuthCode, this.$url, this.$okHttpClient, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Uri> continuation) {
        return ((C1270b) create(coroutineScope, continuation)).invokeSuspend(Unit.f27425a);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x00f1  */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00f2, code lost:
    
        if (r2 != false) goto L29;
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
        boolean z2 = false;
        StringBuilder sbM833U = C1643a.m833U("{\"code\":\"");
        sbM833U.append(this.$samsungAuthCode);
        sbM833U.append("\"}");
        Map mapMapOf = C12136h0.mapOf(C12116o.m10073to("state", this.$state), C12116o.m10073to(ModelAuditLogEntry.CHANGE_KEY_CODE, sbM833U.toString()));
        ArrayList arrayList = new ArrayList(mapMapOf.size());
        for (Map.Entry entry : mapMapOf.entrySet()) {
            arrayList.add(((String) entry.getKey()) + '=' + ((String) entry.getValue()));
        }
        String strJoinToString$default = C12163u.joinToString$default(arrayList, "&", null, null, 0, null, null, 62, null);
        RequestBody.Companion companion = RequestBody.INSTANCE;
        MediaType.Companion companion2 = MediaType.INSTANCE;
        RequestBody requestBodyM10987a = companion.m10987a(strJoinToString$default, MediaType.Companion.m10967a(ShareTarget.ENCODING_TYPE_URL_ENCODED));
        Request.C12935a c12935a = new Request.C12935a();
        C12238m.checkParameterIsNotNull(requestBodyM10987a, "body");
        c12935a.m10980c(ShareTarget.METHOD_POST, requestBodyM10987a);
        c12935a.m10983f(this.$url);
        Response responseExecute = ((C12285e) this.$okHttpClient.mo10114b(c12935a.m10978a())).execute();
        String strM10989a = Response.m10989a(responseExecute, "Location", null, 2);
        Uri uri = strM10989a != null ? Uri.parse(strM10989a) : null;
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
