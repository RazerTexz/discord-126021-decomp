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
import com.discord.utilities.analytics.AnalyticsUtils$Tracker;
import com.discord.utilities.context.ContextExtensionsKt;
import com.discord.utilities.coroutines.CoroutineProgressDialog;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.uri.UriHandler;
import d0.l;
import d0.w.h.c;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: MobileWebHandoff.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MobileWebHandoff {
    public static final MobileWebHandoff$Companion Companion = new MobileWebHandoff$Companion(null);
    private final AnalyticsUtils$Tracker analytics;
    private final StoreAuthentication authStore;
    private final Context context;
    private final RestAPI restAPI;

    public MobileWebHandoff(Context context, RestAPI restAPI, AnalyticsUtils$Tracker analyticsUtils$Tracker, StoreAuthentication storeAuthentication) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(restAPI, "restAPI");
        m.checkNotNullParameter(analyticsUtils$Tracker, "analytics");
        m.checkNotNullParameter(storeAuthentication, "authStore");
        this.context = context;
        this.restAPI = restAPI;
        this.analytics = analyticsUtils$Tracker;
        this.authStore = storeAuthentication;
    }

    public static final /* synthetic */ AnalyticsUtils$Tracker access$getAnalytics$p(MobileWebHandoff mobileWebHandoff) {
        return mobileWebHandoff.analytics;
    }

    public static final /* synthetic */ Context access$getContext$p(MobileWebHandoff mobileWebHandoff) {
        return mobileWebHandoff.context;
    }

    public static final /* synthetic */ RestAPI access$getRestAPI$p(MobileWebHandoff mobileWebHandoff) {
        return mobileWebHandoff.restAPI;
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
    public final /* synthetic */ Object redirectWithHandoffToken(String str, boolean z2, boolean z3, Continuation<? super Unit> continuation) throws Throwable {
        MobileWebHandoff$redirectWithHandoffToken$1 mobileWebHandoff$redirectWithHandoffToken$1;
        Ref$ObjectRef ref$ObjectRef;
        Object objWithCancellableProgressDialog;
        boolean z4;
        MobileWebHandoff mobileWebHandoff;
        Uri uriBuild;
        if (continuation instanceof MobileWebHandoff$redirectWithHandoffToken$1) {
            mobileWebHandoff$redirectWithHandoffToken$1 = (MobileWebHandoff$redirectWithHandoffToken$1) continuation;
            int i = mobileWebHandoff$redirectWithHandoffToken$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                mobileWebHandoff$redirectWithHandoffToken$1.label = i - Integer.MIN_VALUE;
            } else {
                mobileWebHandoff$redirectWithHandoffToken$1 = new MobileWebHandoff$redirectWithHandoffToken$1(this, continuation);
            }
        } else {
            mobileWebHandoff$redirectWithHandoffToken$1 = new MobileWebHandoff$redirectWithHandoffToken$1(this, continuation);
        }
        Object obj = mobileWebHandoff$redirectWithHandoffToken$1.result;
        Object coroutine_suspended = c.getCOROUTINE_SUSPENDED();
        int i2 = mobileWebHandoff$redirectWithHandoffToken$1.label;
        if (i2 == 0) {
            l.throwOnFailure(obj);
            ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = Companion.generateNonce();
            CoroutineProgressDialog coroutineProgressDialog = CoroutineProgressDialog.INSTANCE;
            Context context = this.context;
            MobileWebHandoff$redirectWithHandoffToken$token$1 mobileWebHandoff$redirectWithHandoffToken$token$1 = new MobileWebHandoff$redirectWithHandoffToken$token$1(this, ref$ObjectRef, null);
            mobileWebHandoff$redirectWithHandoffToken$1.L$0 = this;
            mobileWebHandoff$redirectWithHandoffToken$1.L$1 = str;
            mobileWebHandoff$redirectWithHandoffToken$1.L$2 = ref$ObjectRef;
            mobileWebHandoff$redirectWithHandoffToken$1.Z$0 = z2;
            mobileWebHandoff$redirectWithHandoffToken$1.Z$1 = z3;
            mobileWebHandoff$redirectWithHandoffToken$1.label = 1;
            objWithCancellableProgressDialog = coroutineProgressDialog.withCancellableProgressDialog(context, mobileWebHandoff$redirectWithHandoffToken$token$1, mobileWebHandoff$redirectWithHandoffToken$1);
            if (objWithCancellableProgressDialog == coroutine_suspended) {
                return coroutine_suspended;
            }
            z4 = z3;
            mobileWebHandoff = this;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            boolean z5 = mobileWebHandoff$redirectWithHandoffToken$1.Z$1;
            z2 = mobileWebHandoff$redirectWithHandoffToken$1.Z$0;
            Ref$ObjectRef ref$ObjectRef2 = (Ref$ObjectRef) mobileWebHandoff$redirectWithHandoffToken$1.L$2;
            String str2 = (String) mobileWebHandoff$redirectWithHandoffToken$1.L$1;
            MobileWebHandoff mobileWebHandoff2 = (MobileWebHandoff) mobileWebHandoff$redirectWithHandoffToken$1.L$0;
            l.throwOnFailure(obj);
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
            m.checkNotNullExpressionValue(uri, "targetUri");
            String path = uri.getPath();
            if (path == null) {
                path = uri.toString();
            }
            m.checkNotNullExpressionValue(path, "targetUri.path ?: targetUri.toString()");
            uriBuild = Uri.parse(BuildConfig.HOST).buildUpon().path("login/handoff").appendQueryParameter("redirect_to", path).appendQueryParameter("handoff_key", (String) ref$ObjectRef.element).appendQueryParameter("handoff_token", handoffToken.getHandoffToken()).build();
        }
        UriHandler.handle$default(UriHandler.INSTANCE, mobileWebHandoff.context, uriBuild.toString(), true, z4, null, 16, null);
        return Unit.a;
    }

    public final boolean tryLaunchRedirectTo(String url, boolean skipLoginRedirect, boolean preventCustomTab) {
        LifecycleCoroutineScope lifecycleScope;
        m.checkNotNullParameter(url, "url");
        if (!this.authStore.isAuthed()) {
            this.analytics.track(new TrackMobileWebHandoffFailure("user_not_authenticated_in_app", null, 2));
            return false;
        }
        AppCompatActivity appCompatActivityFindActivity = ContextExtensionsKt.findActivity(this.context);
        if (appCompatActivityFindActivity == null || (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(appCompatActivityFindActivity)) == null) {
            return false;
        }
        lifecycleScope.launchWhenStarted(new MobileWebHandoff$tryLaunchRedirectTo$1(this, url, skipLoginRedirect, preventCustomTab, null));
        return true;
    }

    public /* synthetic */ MobileWebHandoff(Context context, RestAPI restAPI, AnalyticsUtils$Tracker analyticsUtils$Tracker, StoreAuthentication storeAuthentication, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? RestAPI.Companion.getApi() : restAPI, (i & 4) != 0 ? AnalyticsUtils$Tracker.Companion.getInstance() : analyticsUtils$Tracker, (i & 8) != 0 ? StoreStream.Companion.getAuthentication() : storeAuthentication);
    }
}
