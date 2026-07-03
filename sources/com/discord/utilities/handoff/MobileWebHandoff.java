package com.discord.utilities.handoff;

import android.content.Context;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import androidx.view.LifecycleCoroutineScope;
import androidx.view.LifecycleOwnerKt;
import com.discord.BuildConfig;
import com.discord.analytics.generated.events.TrackMobileWebHandoffFailure;
import com.discord.api.handoff.HandoffToken;
import com.discord.stores.StoreAuthentication;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsUtils;
import com.discord.utilities.context.ContextExtensionsKt;
import com.discord.utilities.coroutines.CoroutineProgressDialog;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.uri.UriHandler;
import java.util.UUID;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineScope;
import p507d0.C12113l;
import p507d0.p584w.p585h.C12183c;
import p507d0.p584w.p586i.p587a.AbstractC12187d;
import p507d0.p584w.p586i.p587a.AbstractC12194k;
import p507d0.p584w.p586i.p587a.InterfaceC12188e;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: MobileWebHandoff.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MobileWebHandoff {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final AnalyticsUtils.Tracker analytics;
    private final StoreAuthentication authStore;
    private final Context context;
    private final RestAPI restAPI;

    /* JADX INFO: compiled from: MobileWebHandoff.kt */
    public static final class Companion {
        private Companion() {
        }

        public final String generateNonce() {
            String string = UUID.randomUUID().toString();
            C12238m.checkNotNullExpressionValue(string, "UUID.randomUUID().toString()");
            return string;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.handoff.MobileWebHandoff$redirectWithHandoffToken$1 */
    /* JADX INFO: compiled from: MobileWebHandoff.kt */
    @InterfaceC12188e(m10084c = "com.discord.utilities.handoff.MobileWebHandoff", m10085f = "MobileWebHandoff.kt", m10086l = {44}, m10087m = "redirectWithHandoffToken")
    public static final class C67701 extends AbstractC12187d {
        public Object L$0;
        public Object L$1;
        public Object L$2;
        public boolean Z$0;
        public boolean Z$1;
        public int label;
        public /* synthetic */ Object result;

        public C67701(Continuation continuation) {
            super(continuation);
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MobileWebHandoff.this.redirectWithHandoffToken(null, false, false, this);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.handoff.MobileWebHandoff$tryLaunchRedirectTo$1 */
    /* JADX INFO: compiled from: MobileWebHandoff.kt */
    @InterfaceC12188e(m10084c = "com.discord.utilities.handoff.MobileWebHandoff$tryLaunchRedirectTo$1", m10085f = "MobileWebHandoff.kt", m10086l = {36}, m10087m = "invokeSuspend")
    public static final class C67721 extends AbstractC12194k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ boolean $preventCustomTab;
        public final /* synthetic */ boolean $skipLoginRedirect;
        public final /* synthetic */ String $url;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C67721(String str, boolean z2, boolean z3, Continuation continuation) {
            super(2, continuation);
            this.$url = str;
            this.$skipLoginRedirect = z2;
            this.$preventCustomTab = z3;
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C12238m.checkNotNullParameter(continuation, "completion");
            return MobileWebHandoff.this.new C67721(this.$url, this.$skipLoginRedirect, this.$preventCustomTab, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C67721) create(coroutineScope, continuation)).invokeSuspend(Unit.f27425a);
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = C12183c.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                C12113l.throwOnFailure(obj);
                MobileWebHandoff mobileWebHandoff = MobileWebHandoff.this;
                String str = this.$url;
                boolean z2 = this.$skipLoginRedirect;
                boolean z3 = this.$preventCustomTab;
                this.label = 1;
                if (mobileWebHandoff.redirectWithHandoffToken(str, z2, z3, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C12113l.throwOnFailure(obj);
            }
            return Unit.f27425a;
        }
    }

    public MobileWebHandoff(Context context, RestAPI restAPI, AnalyticsUtils.Tracker tracker, StoreAuthentication storeAuthentication) {
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(restAPI, "restAPI");
        C12238m.checkNotNullParameter(tracker, "analytics");
        C12238m.checkNotNullParameter(storeAuthentication, "authStore");
        this.context = context;
        this.restAPI = restAPI;
        this.analytics = tracker;
        this.authStore = storeAuthentication;
    }

    public static /* synthetic */ boolean tryLaunchRedirectTo$default(MobileWebHandoff mobileWebHandoff, String str, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        if ((i & 4) != 0) {
            z3 = false;
        }
        return mobileWebHandoff.tryLaunchRedirectTo(str, z2, z3);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [T, java.lang.String] */
    public final /* synthetic */ Object redirectWithHandoffToken(String str, boolean z2, boolean z3, Continuation<? super Unit> continuation) {
        C67701 c67701;
        Ref$ObjectRef ref$ObjectRef;
        Object objWithCancellableProgressDialog;
        boolean z4;
        MobileWebHandoff mobileWebHandoff;
        Uri uriBuild;
        if (continuation instanceof C67701) {
            c67701 = (C67701) continuation;
            int i = c67701.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c67701.label = i - Integer.MIN_VALUE;
            } else {
                c67701 = new C67701(continuation);
            }
        } else {
            c67701 = new C67701(continuation);
        }
        Object obj = c67701.result;
        Object coroutine_suspended = C12183c.getCOROUTINE_SUSPENDED();
        int i2 = c67701.label;
        if (i2 == 0) {
            C12113l.throwOnFailure(obj);
            ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = INSTANCE.generateNonce();
            CoroutineProgressDialog coroutineProgressDialog = CoroutineProgressDialog.INSTANCE;
            Context context = this.context;
            MobileWebHandoff$redirectWithHandoffToken$token$1 mobileWebHandoff$redirectWithHandoffToken$token$1 = new MobileWebHandoff$redirectWithHandoffToken$token$1(this, ref$ObjectRef, null);
            c67701.L$0 = this;
            c67701.L$1 = str;
            c67701.L$2 = ref$ObjectRef;
            c67701.Z$0 = z2;
            c67701.Z$1 = z3;
            c67701.label = 1;
            objWithCancellableProgressDialog = coroutineProgressDialog.withCancellableProgressDialog(context, mobileWebHandoff$redirectWithHandoffToken$token$1, c67701);
            if (objWithCancellableProgressDialog == coroutine_suspended) {
                return coroutine_suspended;
            }
            z4 = z3;
            mobileWebHandoff = this;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            boolean z5 = c67701.Z$1;
            z2 = c67701.Z$0;
            Ref$ObjectRef ref$ObjectRef2 = (Ref$ObjectRef) c67701.L$2;
            String str2 = (String) c67701.L$1;
            MobileWebHandoff mobileWebHandoff2 = (MobileWebHandoff) c67701.L$0;
            C12113l.throwOnFailure(obj);
            z4 = z5;
            mobileWebHandoff = mobileWebHandoff2;
            objWithCancellableProgressDialog = obj;
            ref$ObjectRef = ref$ObjectRef2;
            str = str2;
        }
        HandoffToken handoffToken = (HandoffToken) objWithCancellableProgressDialog;
        if (z2) {
            uriBuild = Uri.parse(str).buildUpon().appendQueryParameter("handoff_token", handoffToken.getHandoffToken()).build();
        } else {
            Uri uri = Uri.parse(str);
            C12238m.checkNotNullExpressionValue(uri, "targetUri");
            String path = uri.getPath();
            if (path == null) {
                path = uri.toString();
            }
            C12238m.checkNotNullExpressionValue(path, "targetUri.path ?: targetUri.toString()");
            uriBuild = Uri.parse(BuildConfig.HOST).buildUpon().path("login/handoff").appendQueryParameter("redirect_to", path).appendQueryParameter("handoff_key", (String) ref$ObjectRef.element).appendQueryParameter("handoff_token", handoffToken.getHandoffToken()).build();
        }
        UriHandler.handle$default(UriHandler.INSTANCE, mobileWebHandoff.context, uriBuild.toString(), true, z4, null, 16, null);
        return Unit.f27425a;
    }

    public final boolean tryLaunchRedirectTo(String url, boolean skipLoginRedirect, boolean preventCustomTab) {
        LifecycleCoroutineScope lifecycleScope;
        C12238m.checkNotNullParameter(url, "url");
        if (!this.authStore.isAuthed()) {
            this.analytics.track(new TrackMobileWebHandoffFailure("user_not_authenticated_in_app", null, 2));
            return false;
        }
        AppCompatActivity appCompatActivityFindActivity = ContextExtensionsKt.findActivity(this.context);
        if (appCompatActivityFindActivity == null || (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(appCompatActivityFindActivity)) == null) {
            return false;
        }
        lifecycleScope.launchWhenStarted(new C67721(url, skipLoginRedirect, preventCustomTab, null));
        return true;
    }

    public /* synthetic */ MobileWebHandoff(Context context, RestAPI restAPI, AnalyticsUtils.Tracker tracker, StoreAuthentication storeAuthentication, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? RestAPI.INSTANCE.getApi() : restAPI, (i & 4) != 0 ? AnalyticsUtils.Tracker.INSTANCE.getInstance() : tracker, (i & 8) != 0 ? StoreStream.INSTANCE.getAuthentication() : storeAuthentication);
    }
}
