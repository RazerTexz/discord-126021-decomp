package com.discord.stores;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.RecentlyNonNull;
import androidx.core.app.NotificationCompat;
import b.a.d.m0.RoutingPatterns;
import b.a.e.Backgrounded4;
import b.d.b.a.outline;
import b.i.a.f.n.d;
import b.i.a.f.n.e;
import b.i.c.FirebaseApp2;
import b.i.c.o.a;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.error.Error;
import com.discord.utilities.intent.IntentUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.google.android.gms.tasks.Task;
import com.google.firebase.dynamiclinks.PendingDynamicLinkData;
import com.google.firebase.dynamiclinks.internal.DynamicLinkData;
import d0.g0.Strings4;
import d0.g0.StringsJVM;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import rx.Emitter;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;

/* JADX INFO: compiled from: StoreDynamicLink.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreDynamicLink {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    private static final long DYNAMIC_LINK_TIMEOUT_MS = 1000;
    private final Dispatcher dispatcher;
    private final StoreStream stream;

    /* JADX INFO: compiled from: StoreDynamicLink.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: StoreDynamicLink.kt */
    public static final /* data */ class DynamicLinkData {
        private final String attemptId;
        private final String authToken;
        private final String fingerprint;
        private final String guildTemplateCode;
        private final String inviteCode;
        private final Uri uri;

        public DynamicLinkData(Uri uri, String str, String str2, String str3, String str4, String str5) {
            this.uri = uri;
            this.fingerprint = str;
            this.attemptId = str2;
            this.inviteCode = str3;
            this.guildTemplateCode = str4;
            this.authToken = str5;
        }

        public static /* synthetic */ DynamicLinkData copy$default(DynamicLinkData dynamicLinkData, Uri uri, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
            if ((i & 1) != 0) {
                uri = dynamicLinkData.uri;
            }
            if ((i & 2) != 0) {
                str = dynamicLinkData.fingerprint;
            }
            String str6 = str;
            if ((i & 4) != 0) {
                str2 = dynamicLinkData.attemptId;
            }
            String str7 = str2;
            if ((i & 8) != 0) {
                str3 = dynamicLinkData.inviteCode;
            }
            String str8 = str3;
            if ((i & 16) != 0) {
                str4 = dynamicLinkData.guildTemplateCode;
            }
            String str9 = str4;
            if ((i & 32) != 0) {
                str5 = dynamicLinkData.authToken;
            }
            return dynamicLinkData.copy(uri, str6, str7, str8, str9, str5);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Uri getUri() {
            return this.uri;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getFingerprint() {
            return this.fingerprint;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getAttemptId() {
            return this.attemptId;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getInviteCode() {
            return this.inviteCode;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getGuildTemplateCode() {
            return this.guildTemplateCode;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getAuthToken() {
            return this.authToken;
        }

        public final DynamicLinkData copy(Uri uri, String fingerprint, String attemptId, String inviteCode, String guildTemplateCode, String authToken) {
            return new DynamicLinkData(uri, fingerprint, attemptId, inviteCode, guildTemplateCode, authToken);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DynamicLinkData)) {
                return false;
            }
            DynamicLinkData dynamicLinkData = (DynamicLinkData) other;
            return Intrinsics3.areEqual(this.uri, dynamicLinkData.uri) && Intrinsics3.areEqual(this.fingerprint, dynamicLinkData.fingerprint) && Intrinsics3.areEqual(this.attemptId, dynamicLinkData.attemptId) && Intrinsics3.areEqual(this.inviteCode, dynamicLinkData.inviteCode) && Intrinsics3.areEqual(this.guildTemplateCode, dynamicLinkData.guildTemplateCode) && Intrinsics3.areEqual(this.authToken, dynamicLinkData.authToken);
        }

        public final String getAttemptId() {
            return this.attemptId;
        }

        public final String getAuthToken() {
            return this.authToken;
        }

        public final String getFingerprint() {
            return this.fingerprint;
        }

        public final String getGuildTemplateCode() {
            return this.guildTemplateCode;
        }

        public final String getInviteCode() {
            return this.inviteCode;
        }

        public final Uri getUri() {
            return this.uri;
        }

        public int hashCode() {
            Uri uri = this.uri;
            int iHashCode = (uri != null ? uri.hashCode() : 0) * 31;
            String str = this.fingerprint;
            int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.attemptId;
            int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.inviteCode;
            int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.guildTemplateCode;
            int iHashCode5 = (iHashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
            String str5 = this.authToken;
            return iHashCode5 + (str5 != null ? str5.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("DynamicLinkData(uri=");
            sbU.append(this.uri);
            sbU.append(", fingerprint=");
            sbU.append(this.fingerprint);
            sbU.append(", attemptId=");
            sbU.append(this.attemptId);
            sbU.append(", inviteCode=");
            sbU.append(this.inviteCode);
            sbU.append(", guildTemplateCode=");
            sbU.append(this.guildTemplateCode);
            sbU.append(", authToken=");
            return outline.J(sbU, this.authToken, ")");
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreDynamicLink$handleDataReceived$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreDynamicLink.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ DynamicLinkData $data;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(DynamicLinkData dynamicLinkData) {
            super(0);
            this.$data = dynamicLinkData;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreAuthentication authentication = StoreDynamicLink.this.stream.getAuthentication();
            DynamicLinkData dynamicLinkData = this.$data;
            authentication.setFingerprint(dynamicLinkData != null ? dynamicLinkData.getFingerprint() : null, false);
            DynamicLinkData dynamicLinkData2 = this.$data;
            if ((dynamicLinkData2 != null ? dynamicLinkData2.getAuthToken() : null) != null) {
                StoreDynamicLink.this.stream.getAuthentication().setAuthed(this.$data.getAuthToken());
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreDynamicLink$storeLinkIfExists$3, reason: invalid class name */
    /* JADX INFO: compiled from: StoreDynamicLink.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<DynamicLinkData, Unit> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DynamicLinkData dynamicLinkData) {
            invoke2(dynamicLinkData);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DynamicLinkData dynamicLinkData) {
            StoreDynamicLink.this.handleDataReceived(dynamicLinkData, this.$context);
        }
    }

    public StoreDynamicLink(StoreStream storeStream, Dispatcher dispatcher) {
        Intrinsics3.checkNotNullParameter(storeStream, "stream");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        this.stream = storeStream;
        this.dispatcher = dispatcher;
    }

    private final Observable<Uri> getDynamicLinkObservable(final Intent intent) {
        Observable observableO = Observable.o(new Action1<Emitter<Uri>>() { // from class: com.discord.stores.StoreDynamicLink$getDynamicLinkObservable$firebaseDynamicLinks$1

            /* JADX INFO: renamed from: com.discord.stores.StoreDynamicLink$getDynamicLinkObservable$firebaseDynamicLinks$1$1, reason: invalid class name */
            /* JADX INFO: compiled from: StoreDynamicLink.kt */
            public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Throwable, Unit> {
                public AnonymousClass1(Emitter emitter) {
                    super(1, emitter, Emitter.class, "onError", "onError(Ljava/lang/Throwable;)V", 0);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                    ((Emitter) this.receiver).onError(th);
                }
            }

            @Override // rx.functions.Action1
            public final void call(final Emitter<Uri> emitter) {
                a aVar;
                synchronized (a.class) {
                    FirebaseApp2 firebaseApp2B = FirebaseApp2.b();
                    synchronized (a.class) {
                        firebaseApp2B.a();
                        aVar = (a) firebaseApp2B.g.a(a.class);
                    }
                    Task<PendingDynamicLinkData> taskA = aVar.a(intent);
                    final AnonymousClass1 anonymousClass1 = new AnonymousClass1(emitter);
                    taskA.d(new d() { // from class: com.discord.stores.StoreDynamicLink$sam$com_google_android_gms_tasks_OnFailureListener$0
                        @Override // b.i.a.f.n.d
                        public final /* synthetic */ void onFailure(@RecentlyNonNull Exception exc) {
                            Intrinsics3.checkNotNullExpressionValue(anonymousClass1.invoke(exc), "invoke(...)");
                        }
                    }).f(new e<PendingDynamicLinkData>() { // from class: com.discord.stores.StoreDynamicLink$getDynamicLinkObservable$firebaseDynamicLinks$1.2
                        /* JADX WARN: Code duplicated, block: B:12:0x0015  */
                        @Override // b.i.a.f.n.e
                        public final void onSuccess(PendingDynamicLinkData pendingDynamicLinkData) {
                            Uri uri;
                            String str;
                            Emitter emitter2 = emitter;
                            if (pendingDynamicLinkData != null) {
                                DynamicLinkData dynamicLinkData = pendingDynamicLinkData.a;
                                uri = null;
                                if (dynamicLinkData != null && (str = dynamicLinkData.k) != null) {
                                    uri = Uri.parse(str);
                                }
                                if (uri == null) {
                                    uri = Uri.EMPTY;
                                }
                            } else {
                                uri = Uri.EMPTY;
                            }
                            emitter2.onNext(uri);
                            emitter.onCompleted();
                        }
                    });
                }
                Task<PendingDynamicLinkData> taskA2 = aVar.a(intent);
                final Function1 anonymousClass2 = new AnonymousClass1(emitter);
                taskA2.d(new d() { // from class: com.discord.stores.StoreDynamicLink$sam$com_google_android_gms_tasks_OnFailureListener$0
                    @Override // b.i.a.f.n.d
                    public final /* synthetic */ void onFailure(@RecentlyNonNull Exception exc) {
                        Intrinsics3.checkNotNullExpressionValue(anonymousClass2.invoke(exc), "invoke(...)");
                    }
                }).f(new e<PendingDynamicLinkData>() { // from class: com.discord.stores.StoreDynamicLink$getDynamicLinkObservable$firebaseDynamicLinks$1.2
                    /* JADX WARN: Code duplicated, block: B:12:0x0015  */
                    @Override // b.i.a.f.n.e
                    public final void onSuccess(PendingDynamicLinkData pendingDynamicLinkData) {
                        Uri uri;
                        String str;
                        Emitter emitter2 = emitter;
                        if (pendingDynamicLinkData != null) {
                            DynamicLinkData dynamicLinkData = pendingDynamicLinkData.a;
                            uri = null;
                            if (dynamicLinkData != null && (str = dynamicLinkData.k) != null) {
                                uri = Uri.parse(str);
                            }
                            if (uri == null) {
                                uri = Uri.EMPTY;
                            }
                        } else {
                            uri = Uri.EMPTY;
                        }
                        emitter2.onNext(uri);
                        emitter.onCompleted();
                    }
                });
            }
        }, Emitter.BackpressureMode.BUFFER);
        Intrinsics3.checkNotNullExpressionValue(observableO, "Observable.create({\n    ….BackpressureMode.BUFFER)");
        Observable<Uri> observableM = Observable.I(new ScalarSynchronousObservable(Uri.EMPTY).q(1000L, TimeUnit.MILLISECONDS), observableO).M(new Func1<Throwable, Uri>() { // from class: com.discord.stores.StoreDynamicLink.getDynamicLinkObservable.1
            @Override // j0.k.Func1
            public final Uri call(Throwable th) {
                return Uri.EMPTY;
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableM, "Observable\n        .merg…ErrorReturn { Uri.EMPTY }");
        return observableM;
    }

    private final void handleDataReceived(DynamicLinkData data, Context context) {
        String guildTemplateCode;
        String inviteCode;
        this.dispatcher.schedule(new AnonymousClass1(data));
        if (data != null && (inviteCode = data.getInviteCode()) != null && (!StringsJVM.isBlank(inviteCode))) {
            IntentUtils.RouteBuilders routeBuilders = IntentUtils.RouteBuilders.INSTANCE;
            String inviteCode2 = data.getInviteCode();
            Objects.requireNonNull(inviteCode2, "null cannot be cast to non-null type kotlin.CharSequence");
            IntentUtils.consumeRoutingIntent$default(IntentUtils.INSTANCE, routeBuilders.selectInvite(Strings4.trim(inviteCode2).toString(), StoreInviteSettings.LOCATION_DEEPLINK), context, null, 4, null);
            return;
        }
        if (data != null && (guildTemplateCode = data.getGuildTemplateCode()) != null && (!StringsJVM.isBlank(guildTemplateCode))) {
            IntentUtils.RouteBuilders routeBuilders2 = IntentUtils.RouteBuilders.INSTANCE;
            String guildTemplateCode2 = data.getGuildTemplateCode();
            Objects.requireNonNull(guildTemplateCode2, "null cannot be cast to non-null type kotlin.CharSequence");
            IntentUtils.consumeRoutingIntent$default(IntentUtils.INSTANCE, routeBuilders2.selectGuildTemplate(Strings4.trim(guildTemplateCode2).toString(), StoreInviteSettings.LOCATION_DEEPLINK), context, null, 4, null);
            return;
        }
        if ((data != null ? data.getUri() : null) != null) {
            Intent data2 = new Intent().setData(data.getUri());
            Intrinsics3.checkNotNullExpressionValue(data2, "Intent().setData(data.uri)");
            IntentUtils.consumeRoutingIntent$default(IntentUtils.INSTANCE, data2, context, null, 4, null);
        }
    }

    public final void storeLinkIfExists(Intent intent, Context context) {
        Intrinsics3.checkNotNullParameter(intent, "intent");
        Intrinsics3.checkNotNullParameter(context, "context");
        Observable<R> observableG = getDynamicLinkObservable(intent).G(new Func1<Uri, DynamicLinkData>() { // from class: com.discord.stores.StoreDynamicLink.storeLinkIfExists.1
            /* JADX WARN: Code duplicated, block: B:40:0x009b  */
            /* JADX WARN: Code duplicated, block: B:68:0x0112  */
            @Override // j0.k.Func1
            public final DynamicLinkData call(Uri uri) {
                String str;
                String str2;
                String queryParameter;
                String queryParameter2;
                List<String> groupValues;
                String strPrevious;
                String path;
                List<String> groupValues2;
                String strPrevious2;
                String path2;
                String queryParameter3 = null;
                if (Intrinsics3.areEqual(uri, Uri.EMPTY)) {
                    return null;
                }
                IntentUtils intentUtils = IntentUtils.INSTANCE;
                Intrinsics3.checkNotNullExpressionValue(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
                Uri uri2 = intentUtils.isHttpDomainUrl(uri) ? uri : null;
                RoutingPatterns routingPatterns = RoutingPatterns.G;
                Intrinsics3.checkNotNullParameter(uri, "$this$isInviteLink");
                boolean z2 = false;
                if (StringsJVM.equals(uri.getHost(), RoutingPatterns.d, true) || ((StringsJVM.equals(uri.getHost(), RoutingPatterns.a, true) || StringsJVM.equals(uri.getHost(), RoutingPatterns.f60b, true)) && (path2 = uri.getPath()) != null && RoutingPatterns.n.matches(path2))) {
                    Regex regex = RoutingPatterns.n;
                    String path3 = uri.getPath();
                    if (path3 == null) {
                        path3 = "";
                    }
                    Intrinsics3.checkNotNullExpressionValue(path3, "uri.path ?: \"\"");
                    MatchResult matchResultMatchEntire = regex.matchEntire(path3);
                    if (matchResultMatchEntire == null || (groupValues2 = matchResultMatchEntire.getGroupValues()) == null) {
                        str = null;
                    } else {
                        ListIterator<String> listIterator = groupValues2.listIterator(groupValues2.size());
                        do {
                            if (!listIterator.hasPrevious()) {
                                strPrevious2 = null;
                                break;
                            }
                            strPrevious2 = listIterator.previous();
                        } while (!(!StringsJVM.isBlank(strPrevious2)));
                        str = strPrevious2;
                    }
                } else {
                    str = null;
                }
                RoutingPatterns routingPatterns2 = RoutingPatterns.G;
                Intrinsics3.checkNotNullParameter(uri, "$this$isGuildTemplateLink");
                if (StringsJVM.equals(uri.getHost(), RoutingPatterns.e, true) || ((StringsJVM.equals(uri.getHost(), RoutingPatterns.a, true) || StringsJVM.equals(uri.getHost(), RoutingPatterns.f60b, true)) && (path = uri.getPath()) != null && RoutingPatterns.p.matches(path))) {
                    z2 = true;
                }
                if (z2) {
                    Regex regex2 = RoutingPatterns.p;
                    String path4 = uri.getPath();
                    String str3 = path4 != null ? path4 : "";
                    Intrinsics3.checkNotNullExpressionValue(str3, "uri.path ?: \"\"");
                    MatchResult matchResultMatchEntire2 = regex2.matchEntire(str3);
                    if (matchResultMatchEntire2 == null || (groupValues = matchResultMatchEntire2.getGroupValues()) == null) {
                        str2 = null;
                    } else {
                        ListIterator<String> listIterator2 = groupValues.listIterator(groupValues.size());
                        do {
                            if (!listIterator2.hasPrevious()) {
                                strPrevious = null;
                                break;
                            }
                            strPrevious = listIterator2.previous();
                        } while (!(!StringsJVM.isBlank(strPrevious)));
                        str2 = strPrevious;
                    }
                } else {
                    str2 = null;
                }
                try {
                    queryParameter = uri.getQueryParameter("fingerprint");
                } catch (Exception unused) {
                    queryParameter = null;
                }
                try {
                    queryParameter2 = uri.getQueryParameter("attemptId");
                } catch (Exception unused2) {
                    queryParameter2 = null;
                }
                try {
                    queryParameter3 = uri.getQueryParameter("auth_token");
                } catch (Exception unused3) {
                }
                return new DynamicLinkData(uri2, queryParameter, queryParameter2, str, str2, queryParameter3);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableG, "getDynamicLinkObservable…ode, authToken)\n        }");
        Observable observableU = ObservableExtensionsKt.computationBuffered(observableG).r().u(new Action1<DynamicLinkData>() { // from class: com.discord.stores.StoreDynamicLink.storeLinkIfExists.2
            @Override // rx.functions.Action1
            public final void call(DynamicLinkData dynamicLinkData) {
                if (dynamicLinkData != null) {
                    AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
                    String fingerprint = dynamicLinkData.getFingerprint();
                    String attemptId = dynamicLinkData.getAttemptId();
                    String inviteCode = dynamicLinkData.getInviteCode();
                    String guildTemplateCode = dynamicLinkData.getGuildTemplateCode();
                    String authToken = dynamicLinkData.getAuthToken();
                    Backgrounded4 backgrounded4 = Backgrounded4.d;
                    analyticsTracker.externalDynamicLinkReceived(fingerprint, attemptId, inviteCode, guildTemplateCode, authToken, Backgrounded4.a);
                }
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableU, "getDynamicLinkObservable…  )\n          }\n        }");
        ObservableExtensionsKt.appSubscribe(observableU, (Class<?>) StoreDynamicLink.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass3(context));
    }
}
