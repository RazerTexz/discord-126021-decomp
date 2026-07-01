package com.discord.widgets.notice;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import com.discord.R;
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
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import d0.Tuples;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func2;

/* JADX INFO: compiled from: WidgetNoticeNuxSamsungLink.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetNoticeNuxSamsungLink extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetNoticeNuxSamsungLink.class, "binding", "getBinding()Lcom/discord/databinding/WidgetNoticeNuxSamsungLinkBinding;", 0)};

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
            StoreStream.INSTANCE.getNotices().requestToShow(new StoreNotices.Notice(WidgetNoticeNuxSamsungLink.NOTICE_NAME, null, 0L, 0, true, null, 0L, false, RecyclerView.FOREVER_NS, WidgetNoticeNuxSamsungLink4.INSTANCE, 230, null));
        }

        /* JADX WARN: Code duplicated, block: B:13:0x0032  */
        public final void enqueue(Context context, Clock clock) {
            boolean z2;
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(clock, "clock");
            if (Build.VERSION.SDK_INT >= 28 && StringsJVM.equals(Build.MANUFACTURER, "samsung", true)) {
                Intrinsics3.checkNotNullParameter(context, "context");
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
                    Observable observableJ = Observable.j(companion.getAuthentication().observeIsAuthed$app_productionGoogleRelease(), StoreUser.observeMe$default(companion.getUsers(), false, 1, null), new Func2<Boolean, MeUser, Tuples2<? extends Boolean, ? extends MeUser>>() { // from class: com.discord.widgets.notice.WidgetNoticeNuxSamsungLink$Companion$enqueue$1
                        @Override // rx.functions.Func2
                        public final Tuples2<Boolean, MeUser> call(Boolean bool, MeUser meUser) {
                            return Tuples.to(bool, meUser);
                        }
                    });
                    Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable\n          .co…hed to meUser\n          }");
                    ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.computationLatest(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableJ, 0L, false, 3, null)), (Class<?>) WidgetNoticeNuxSamsungLink.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new WidgetNoticeNuxSamsungLink3(clock));
                }
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.notice.WidgetNoticeNuxSamsungLink$onViewBound$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetNoticeNuxSamsungLink.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<List<? extends ModelOAuth2Token>, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelOAuth2Token> list) {
            invoke2((List<ModelOAuth2Token>) list);
            return Unit.a;
        }

        /* JADX WARN: Code duplicated, block: B:20:0x004e  */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<ModelOAuth2Token> list) {
            boolean z2;
            Intrinsics3.checkNotNullExpressionValue(list, "authedApps");
            boolean z3 = true;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                do {
                    if (!it.hasNext()) {
                        z3 = false;
                        break;
                    } else if (Intrinsics3.areEqual(String.valueOf(((ModelOAuth2Token) it.next()).getApplication().getId()), "591317049637339146")) {
                        if (Build.VERSION.SDK_INT >= 28 && StringsJVM.equals(Build.MANUFACTURER, "samsung", true)) {
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
        super(R.layout.widget_notice_nux_samsung_link);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetNoticeNuxSamsungLink5.INSTANCE, null, 2, null);
    }

    private final WidgetNoticeNuxSamsungLinkBinding getBinding() {
        return (WidgetNoticeNuxSamsungLinkBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        StoreStream.INSTANCE.getNotices().markDialogSeen(NOTICE_NAME);
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.takeSingleUntilTimeout$default(ObservableExtensionsKt.computationLatest(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getOAuthTokens(), false, 1, null)), 0L, false, 1, null), this, null, 2, null), (Class<?>) WidgetNoticeNuxSamsungLink.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
        getBinding().c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.notice.WidgetNoticeNuxSamsungLink.onViewBound.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetNoticeNuxSamsungLink widgetNoticeNuxSamsungLink = WidgetNoticeNuxSamsungLink.this;
                Uri oauth2Authorize = IntentUtils.RouteBuilders.Uris.INSTANCE.getOauth2Authorize();
                Intrinsics3.checkNotNullParameter(oauth2Authorize, "oAuthUri");
                widgetNoticeNuxSamsungLink.startActivity(new Intent("android.intent.action.VIEW", oauth2Authorize.buildUpon().appendQueryParameter("client_id", "591317049637339146").appendQueryParameter("prompt", "consent").appendQueryParameter("response_type", ModelAuditLogEntry.CHANGE_KEY_CODE).appendQueryParameter("scope", "identify activities.read activities.write").build()));
                WidgetNoticeNuxSamsungLink.this.dismiss();
            }
        });
        getBinding().f2502b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.notice.WidgetNoticeNuxSamsungLink.onViewBound.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetNoticeNuxSamsungLink.this.dismiss();
            }
        });
    }
}
