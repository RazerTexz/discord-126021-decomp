package com.discord.stores;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.RecentlyNonNull;
import androidx.core.app.NotificationCompat;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.error.Error;
import com.discord.utilities.intent.IntentUtils;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.google.android.gms.tasks.Task;
import com.google.firebase.dynamiclinks.PendingDynamicLinkData;
import com.google.firebase.dynamiclinks.internal.DynamicLinkData;
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
import p007b.p008a.p018d.p019m0.C0877a;
import p007b.p008a.p020e.C0894d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4359d;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4361e;
import p007b.p225i.p361c.C4542c;
import p007b.p225i.p361c.p391o.AbstractC4767a;
import p507d0.p579g0.C12103t;
import p507d0.p579g0.C12106w;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p647e.C12721k;
import p658rx.Emitter;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Action1;

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
            return C12238m.areEqual(this.uri, dynamicLinkData.uri) && C12238m.areEqual(this.fingerprint, dynamicLinkData.fingerprint) && C12238m.areEqual(this.attemptId, dynamicLinkData.attemptId) && C12238m.areEqual(this.inviteCode, dynamicLinkData.inviteCode) && C12238m.areEqual(this.guildTemplateCode, dynamicLinkData.guildTemplateCode) && C12238m.areEqual(this.authToken, dynamicLinkData.authToken);
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
            StringBuilder sbM833U = C1643a.m833U("DynamicLinkData(uri=");
            sbM833U.append(this.uri);
            sbM833U.append(", fingerprint=");
            sbM833U.append(this.fingerprint);
            sbM833U.append(", attemptId=");
            sbM833U.append(this.attemptId);
            sbM833U.append(", inviteCode=");
            sbM833U.append(this.inviteCode);
            sbM833U.append(", guildTemplateCode=");
            sbM833U.append(this.guildTemplateCode);
            sbM833U.append(", authToken=");
            return C1643a.m822J(sbM833U, this.authToken, ")");
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreDynamicLink$handleDataReceived$1 */
    /* JADX INFO: compiled from: StoreDynamicLink.kt */
    public static final class C58811 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ DynamicLinkData $data;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C58811(DynamicLinkData dynamicLinkData) {
            super(0);
            this.$data = dynamicLinkData;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
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

    /* JADX INFO: renamed from: com.discord.stores.StoreDynamicLink$storeLinkIfExists$3 */
    /* JADX INFO: compiled from: StoreDynamicLink.kt */
    public static final class C58853 extends AbstractC12240o implements Function1<DynamicLinkData, Unit> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C58853(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DynamicLinkData dynamicLinkData) {
            invoke2(dynamicLinkData);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DynamicLinkData dynamicLinkData) {
            StoreDynamicLink.this.handleDataReceived(dynamicLinkData, this.$context);
        }
    }

    public StoreDynamicLink(StoreStream storeStream, Dispatcher dispatcher) {
        C12238m.checkNotNullParameter(storeStream, "stream");
        C12238m.checkNotNullParameter(dispatcher, "dispatcher");
        this.stream = storeStream;
        this.dispatcher = dispatcher;
    }

    private final Observable<Uri> getDynamicLinkObservable(final Intent intent) {
        Observable observableM11080o = Observable.m11080o(new Action1<Emitter<Uri>>() { // from class: com.discord.stores.StoreDynamicLink$getDynamicLinkObservable$firebaseDynamicLinks$1

            /* JADX INFO: renamed from: com.discord.stores.StoreDynamicLink$getDynamicLinkObservable$firebaseDynamicLinks$1$1 */
            /* JADX INFO: compiled from: StoreDynamicLink.kt */
            public static final /* synthetic */ class C58791 extends C12236k implements Function1<Throwable, Unit> {
                public C58791(Emitter emitter) {
                    super(1, emitter, Emitter.class, "onError", "onError(Ljava/lang/Throwable;)V", 0);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.f27425a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                    ((Emitter) this.receiver).onError(th);
                }
            }

            @Override // p658rx.functions.Action1
            public final void call(final Emitter<Uri> emitter) {
                AbstractC4767a abstractC4767a;
                synchronized (AbstractC4767a.class) {
                    C4542c c4542cM6327b = C4542c.m6327b();
                    synchronized (AbstractC4767a.class) {
                        c4542cM6327b.m6330a();
                        abstractC4767a = (AbstractC4767a) c4542cM6327b.f12121g.mo6346a(AbstractC4767a.class);
                    }
                    Task<PendingDynamicLinkData> taskMo6703a = abstractC4767a.mo6703a(intent);
                    final C58791 c58791 = new C58791(emitter);
                    taskMo6703a.mo6009d(new InterfaceC4359d() { // from class: com.discord.stores.StoreDynamicLink$sam$com_google_android_gms_tasks_OnFailureListener$0
                        @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4359d
                        public final /* synthetic */ void onFailure(@RecentlyNonNull Exception exc) {
                            C12238m.checkNotNullExpressionValue(c58791.invoke(exc), "invoke(...)");
                        }
                    }).mo6011f(new InterfaceC4361e<PendingDynamicLinkData>() { // from class: com.discord.stores.StoreDynamicLink$getDynamicLinkObservable$firebaseDynamicLinks$1.2
                        /* JADX WARN: Code duplicated, block: B:12:0x0015  */
                        @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4361e
                        public final void onSuccess(PendingDynamicLinkData pendingDynamicLinkData) {
                            Uri uri;
                            String str;
                            Emitter emitter2 = emitter;
                            if (pendingDynamicLinkData != null) {
                                DynamicLinkData dynamicLinkData = pendingDynamicLinkData.f21421a;
                                uri = null;
                                if (dynamicLinkData != null && (str = dynamicLinkData.f21423k) != null) {
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
                Task<PendingDynamicLinkData> taskMo6703a2 = abstractC4767a.mo6703a(intent);
                final Function1 c58792 = new C58791(emitter);
                taskMo6703a2.mo6009d(new InterfaceC4359d() { // from class: com.discord.stores.StoreDynamicLink$sam$com_google_android_gms_tasks_OnFailureListener$0
                    @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4359d
                    public final /* synthetic */ void onFailure(@RecentlyNonNull Exception exc) {
                        C12238m.checkNotNullExpressionValue(c58792.invoke(exc), "invoke(...)");
                    }
                }).mo6011f(new InterfaceC4361e<PendingDynamicLinkData>() { // from class: com.discord.stores.StoreDynamicLink$getDynamicLinkObservable$firebaseDynamicLinks$1.2
                    /* JADX WARN: Code duplicated, block: B:12:0x0015  */
                    @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4361e
                    public final void onSuccess(PendingDynamicLinkData pendingDynamicLinkData) {
                        Uri uri;
                        String str;
                        Emitter emitter2 = emitter;
                        if (pendingDynamicLinkData != null) {
                            DynamicLinkData dynamicLinkData = pendingDynamicLinkData.f21421a;
                            uri = null;
                            if (dynamicLinkData != null && (str = dynamicLinkData.f21423k) != null) {
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
        C12238m.checkNotNullExpressionValue(observableM11080o, "Observable.create({\n    ….BackpressureMode.BUFFER)");
        Observable<Uri> observableM11087M = Observable.m11064I(new C12721k(Uri.EMPTY).m11111q(1000L, TimeUnit.MILLISECONDS), observableM11080o).m11087M(new InterfaceC12589b<Throwable, Uri>() { // from class: com.discord.stores.StoreDynamicLink.getDynamicLinkObservable.1
            @Override // p637j0.p641k.InterfaceC12589b
            public final Uri call(Throwable th) {
                return Uri.EMPTY;
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11087M, "Observable\n        .merg…ErrorReturn { Uri.EMPTY }");
        return observableM11087M;
    }

    private final void handleDataReceived(DynamicLinkData data, Context context) {
        String guildTemplateCode;
        String inviteCode;
        this.dispatcher.schedule(new C58811(data));
        if (data != null && (inviteCode = data.getInviteCode()) != null && (!C12103t.isBlank(inviteCode))) {
            IntentUtils.RouteBuilders routeBuilders = IntentUtils.RouteBuilders.INSTANCE;
            String inviteCode2 = data.getInviteCode();
            Objects.requireNonNull(inviteCode2, "null cannot be cast to non-null type kotlin.CharSequence");
            IntentUtils.consumeRoutingIntent$default(IntentUtils.INSTANCE, routeBuilders.selectInvite(C12106w.trim(inviteCode2).toString(), StoreInviteSettings.LOCATION_DEEPLINK), context, null, 4, null);
            return;
        }
        if (data != null && (guildTemplateCode = data.getGuildTemplateCode()) != null && (!C12103t.isBlank(guildTemplateCode))) {
            IntentUtils.RouteBuilders routeBuilders2 = IntentUtils.RouteBuilders.INSTANCE;
            String guildTemplateCode2 = data.getGuildTemplateCode();
            Objects.requireNonNull(guildTemplateCode2, "null cannot be cast to non-null type kotlin.CharSequence");
            IntentUtils.consumeRoutingIntent$default(IntentUtils.INSTANCE, routeBuilders2.selectGuildTemplate(C12106w.trim(guildTemplateCode2).toString(), StoreInviteSettings.LOCATION_DEEPLINK), context, null, 4, null);
            return;
        }
        if ((data != null ? data.getUri() : null) != null) {
            Intent data2 = new Intent().setData(data.getUri());
            C12238m.checkNotNullExpressionValue(data2, "Intent().setData(data.uri)");
            IntentUtils.consumeRoutingIntent$default(IntentUtils.INSTANCE, data2, context, null, 4, null);
        }
    }

    public final void storeLinkIfExists(Intent intent, Context context) {
        C12238m.checkNotNullParameter(intent, "intent");
        C12238m.checkNotNullParameter(context, "context");
        Observable<R> observableM11083G = getDynamicLinkObservable(intent).m11083G(new InterfaceC12589b<Uri, DynamicLinkData>() { // from class: com.discord.stores.StoreDynamicLink.storeLinkIfExists.1
            /* JADX WARN: Code duplicated, block: B:40:0x009b  */
            /* JADX WARN: Code duplicated, block: B:68:0x0112  */
            @Override // p637j0.p641k.InterfaceC12589b
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
                if (C12238m.areEqual(uri, Uri.EMPTY)) {
                    return null;
                }
                IntentUtils intentUtils = IntentUtils.INSTANCE;
                C12238m.checkNotNullExpressionValue(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
                Uri uri2 = intentUtils.isHttpDomainUrl(uri) ? uri : null;
                C0877a c0877a = C0877a.f538G;
                C12238m.checkNotNullParameter(uri, "$this$isInviteLink");
                boolean z2 = false;
                if (C12103t.equals(uri.getHost(), C0877a.f542d, true) || ((C12103t.equals(uri.getHost(), C0877a.f539a, true) || C12103t.equals(uri.getHost(), C0877a.f540b, true)) && (path2 = uri.getPath()) != null && C0877a.f552n.matches(path2))) {
                    Regex regex = C0877a.f552n;
                    String path3 = uri.getPath();
                    if (path3 == null) {
                        path3 = "";
                    }
                    C12238m.checkNotNullExpressionValue(path3, "uri.path ?: \"\"");
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
                        } while (!(!C12103t.isBlank(strPrevious2)));
                        str = strPrevious2;
                    }
                } else {
                    str = null;
                }
                C0877a c0877a2 = C0877a.f538G;
                C12238m.checkNotNullParameter(uri, "$this$isGuildTemplateLink");
                if (C12103t.equals(uri.getHost(), C0877a.f543e, true) || ((C12103t.equals(uri.getHost(), C0877a.f539a, true) || C12103t.equals(uri.getHost(), C0877a.f540b, true)) && (path = uri.getPath()) != null && C0877a.f554p.matches(path))) {
                    z2 = true;
                }
                if (z2) {
                    Regex regex2 = C0877a.f554p;
                    String path4 = uri.getPath();
                    String str3 = path4 != null ? path4 : "";
                    C12238m.checkNotNullExpressionValue(str3, "uri.path ?: \"\"");
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
                        } while (!(!C12103t.isBlank(strPrevious)));
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
        C12238m.checkNotNullExpressionValue(observableM11083G, "getDynamicLinkObservable…ode, authToken)\n        }");
        Observable observableM11115u = ObservableExtensionsKt.computationBuffered(observableM11083G).m11112r().m11115u(new Action1<DynamicLinkData>() { // from class: com.discord.stores.StoreDynamicLink.storeLinkIfExists.2
            @Override // p658rx.functions.Action1
            public final void call(DynamicLinkData dynamicLinkData) {
                if (dynamicLinkData != null) {
                    AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
                    String fingerprint = dynamicLinkData.getFingerprint();
                    String attemptId = dynamicLinkData.getAttemptId();
                    String inviteCode = dynamicLinkData.getInviteCode();
                    String guildTemplateCode = dynamicLinkData.getGuildTemplateCode();
                    String authToken = dynamicLinkData.getAuthToken();
                    C0894d c0894d = C0894d.f600d;
                    analyticsTracker.externalDynamicLinkReceived(fingerprint, attemptId, inviteCode, guildTemplateCode, authToken, C0894d.f597a);
                }
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11115u, "getDynamicLinkObservable…  )\n          }\n        }");
        ObservableExtensionsKt.appSubscribe(observableM11115u, (Class<?>) StoreDynamicLink.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C58853(context));
    }
}
