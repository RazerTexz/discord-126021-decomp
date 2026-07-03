package com.discord.widgets.notice;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.databinding.WidgetNoticeNuxSamsungLinkBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelOAuth2Token;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.error.Error;
import com.discord.utilities.intent.IntentUtils;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.time.Clock;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12116o;
import p507d0.p579g0.C12103t;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func2;

/* JADX INFO: compiled from: WidgetNoticeNuxSamsungLink.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetNoticeNuxSamsungLink extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetNoticeNuxSamsungLink.class, "binding", "getBinding()Lcom/discord/databinding/WidgetNoticeNuxSamsungLinkBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String NOTICE_NAME = "NUX/SamsungLink";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: compiled from: WidgetNoticeNuxSamsungLink.kt */
    public static final class Companion {
        private Companion() {
        }

        private final void internalEnqueue() {
            StoreStream.INSTANCE.getNotices().requestToShow(new StoreNotices.Notice(WidgetNoticeNuxSamsungLink.NOTICE_NAME, null, 0L, 0, true, null, 0L, false, RecyclerView.FOREVER_NS, WidgetNoticeNuxSamsungLink$Companion$internalEnqueue$notice$1.INSTANCE, 230, null));
        }

        /* JADX WARN: Code duplicated, block: B:13:0x0032  */
        public final void enqueue(Context context, Clock clock) {
            boolean z2;
            C12238m.checkNotNullParameter(context, "context");
            C12238m.checkNotNullParameter(clock, "clock");
            if (Build.VERSION.SDK_INT >= 28 && C12103t.equals(Build.MANUFACTURER, "samsung", true)) {
                C12238m.checkNotNullParameter(context, "context");
                try {
                    try {
                        if (context.getPackageManager().getPackageInfo("com.samsung.android.game.gametools", 0) != null) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                    } catch (PackageManager.NameNotFoundException unused) {
                        if (context.getPackageManager().getPackageInfo("com.samsung.android.game.gamehome", 0) == null) {
                            z2 = false;
                        }
                    }
                } catch (PackageManager.NameNotFoundException unused2) {
                }
                if (z2) {
                    StoreStream.Companion companion = StoreStream.INSTANCE;
                    Observable observableM11076j = Observable.m11076j(companion.getAuthentication().observeIsAuthed$app_productionGoogleRelease(), StoreUser.observeMe$default(companion.getUsers(), false, 1, null), new Func2<Boolean, MeUser, Pair<? extends Boolean, ? extends MeUser>>() { // from class: com.discord.widgets.notice.WidgetNoticeNuxSamsungLink$Companion$enqueue$1
                        @Override // p658rx.functions.Func2
                        public final Pair<Boolean, MeUser> call(Boolean bool, MeUser meUser) {
                            return C12116o.m10073to(bool, meUser);
                        }
                    });
                    C12238m.checkNotNullExpressionValue(observableM11076j, "Observable\n          .co…hed to meUser\n          }");
                    ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.computationLatest(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableM11076j, 0L, false, 3, null)), (Class<?>) WidgetNoticeNuxSamsungLink.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new WidgetNoticeNuxSamsungLink$Companion$enqueue$2(clock));
                }
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.notice.WidgetNoticeNuxSamsungLink$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetNoticeNuxSamsungLink.kt */
    public static final class C91001 extends AbstractC12240o implements Function1<List<? extends ModelOAuth2Token>, Unit> {
        public C91001() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelOAuth2Token> list) {
            invoke2((List<ModelOAuth2Token>) list);
            return Unit.f27425a;
        }

        /* JADX WARN: Code duplicated, block: B:20:0x004e  */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<ModelOAuth2Token> list) {
            boolean z2;
            C12238m.checkNotNullExpressionValue(list, "authedApps");
            boolean z3 = true;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                do {
                    if (!it.hasNext()) {
                        z3 = false;
                        break;
                    } else if (C12238m.areEqual(String.valueOf(((ModelOAuth2Token) it.next()).getApplication().getId()), "591317049637339146")) {
                        if (Build.VERSION.SDK_INT >= 28 && C12103t.equals(Build.MANUFACTURER, "samsung", true)) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                    } else {
                        z2 = false;
                    }
                } while (!z2);
            } else {
                z3 = false;
                break;
            }
            if (z3) {
                WidgetNoticeNuxSamsungLink.this.dismiss();
            }
        }
    }

    public WidgetNoticeNuxSamsungLink() {
        super(C5419R.layout.widget_notice_nux_samsung_link);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetNoticeNuxSamsungLink$binding$2.INSTANCE, null, 2, null);
    }

    private final WidgetNoticeNuxSamsungLinkBinding getBinding() {
        return (WidgetNoticeNuxSamsungLinkBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        StoreStream.INSTANCE.getNotices().markDialogSeen(NOTICE_NAME);
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.takeSingleUntilTimeout$default(ObservableExtensionsKt.computationLatest(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getOAuthTokens(), false, 1, null)), 0L, false, 1, null), this, null, 2, null), (Class<?>) WidgetNoticeNuxSamsungLink.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C91001());
        getBinding().f17307c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.notice.WidgetNoticeNuxSamsungLink.onViewBound.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetNoticeNuxSamsungLink widgetNoticeNuxSamsungLink = WidgetNoticeNuxSamsungLink.this;
                Uri oauth2Authorize = IntentUtils.RouteBuilders.Uris.INSTANCE.getOauth2Authorize();
                C12238m.checkNotNullParameter(oauth2Authorize, "oAuthUri");
                widgetNoticeNuxSamsungLink.startActivity(new Intent("android.intent.action.VIEW", oauth2Authorize.buildUpon().appendQueryParameter("client_id", "591317049637339146").appendQueryParameter("prompt", "consent").appendQueryParameter("response_type", ModelAuditLogEntry.CHANGE_KEY_CODE).appendQueryParameter("scope", "identify activities.read activities.write").build()));
                WidgetNoticeNuxSamsungLink.this.dismiss();
            }
        });
        getBinding().f17306b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.notice.WidgetNoticeNuxSamsungLink.onViewBound.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetNoticeNuxSamsungLink.this.dismiss();
            }
        });
    }
}
