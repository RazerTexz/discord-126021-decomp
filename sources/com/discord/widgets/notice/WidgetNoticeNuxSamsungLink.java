package com.discord.widgets.notice;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppDialog;
import com.discord.databinding.WidgetNoticeNuxSamsungLinkBinding;
import com.discord.stores.StoreStream;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetNoticeNuxSamsungLink.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetNoticeNuxSamsungLink extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetNoticeNuxSamsungLink.class, "binding", "getBinding()Lcom/discord/databinding/WidgetNoticeNuxSamsungLinkBinding;", 0)};
    public static final WidgetNoticeNuxSamsungLink$Companion Companion = new WidgetNoticeNuxSamsungLink$Companion(null);
    private static final String NOTICE_NAME = "NUX/SamsungLink";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    public WidgetNoticeNuxSamsungLink() {
        super(R$layout.widget_notice_nux_samsung_link);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetNoticeNuxSamsungLink$binding$2.INSTANCE, null, 2, null);
    }

    private final WidgetNoticeNuxSamsungLinkBinding getBinding() {
        return (WidgetNoticeNuxSamsungLinkBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        StoreStream.Companion.getNotices().markDialogSeen(NOTICE_NAME);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.takeSingleUntilTimeout$default(ObservableExtensionsKt.computationLatest(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().getOAuthTokens(), false, 1, null)), 0L, false, 1, null), this, null, 2, null), WidgetNoticeNuxSamsungLink.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetNoticeNuxSamsungLink$onViewBound$1(this), 62, (Object) null);
        getBinding().c.setOnClickListener(new WidgetNoticeNuxSamsungLink$onViewBound$2(this));
        getBinding().f2502b.setOnClickListener(new WidgetNoticeNuxSamsungLink$onViewBound$3(this));
    }
}
