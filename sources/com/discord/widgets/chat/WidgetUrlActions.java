package com.discord.widgets.chat;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetUrlActionsBinding;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.utilities.intent.IntentUtils;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.home.WidgetHome;
import com.discord.widgets.search.results.WidgetSearchResults;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0876m;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p513e0.InterfaceC11230c;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetUrlActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetUrlActions extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetUrlActions.class, "binding", "getBinding()Lcom/discord/databinding/WidgetUrlActionsBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_URL = "INTENT_URL";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: url$delegate, reason: from kotlin metadata */
    private final Lazy url;

    /* JADX INFO: compiled from: WidgetUrlActions.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(FragmentManager fragmentManager, String url) {
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            C12238m.checkNotNullParameter(url, "url");
            WidgetUrlActions widgetUrlActions = new WidgetUrlActions();
            Bundle bundle = new Bundle();
            bundle.putString(WidgetUrlActions.INTENT_URL, url);
            widgetUrlActions.setArguments(bundle);
            widgetUrlActions.show(fragmentManager, WidgetUrlActions.class.getName());
        }

        public final void requestNotice(String url) {
            C12238m.checkNotNullParameter(url, "url");
            StoreStream.INSTANCE.getNotices().requestToShow(new StoreNotices.Notice(url, null, 0L, 0, false, C12147n.listOf((Object[]) new InterfaceC11230c[]{C12216a0.getOrCreateKotlinClass(WidgetHome.class), C12216a0.getOrCreateKotlinClass(WidgetSearchResults.class)}), 0L, false, 0L, new WidgetUrlActions$Companion$requestNotice$notice$1(url), 150, null));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WidgetUrlActions() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetUrlActions$binding$2.INSTANCE, null, 2, null);
        this.url = C12083g.lazy(new WidgetUrlActions$url$2(this));
    }

    private final WidgetUrlActionsBinding getBinding() {
        return (WidgetUrlActionsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final String getUrl() {
        return (String) this.url.getValue();
    }

    public static final void launch(FragmentManager fragmentManager, String str) {
        INSTANCE.launch(fragmentManager, str);
    }

    public static final void requestNotice(String str) {
        INSTANCE.requestNotice(str);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return C5419R.layout.widget_url_actions;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        StoreNotices.markSeen$default(StoreStream.INSTANCE.getNotices(), getUrl(), 0L, 2, null);
        super.onDestroy();
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onPause() {
        dismiss();
        super.onPause();
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        AppBottomSheet.hideKeyboard$default(this, null, 1, null);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        TextView textView = getBinding().f18319e;
        C12238m.checkNotNullExpressionValue(textView, "binding.dialogUrlActionsUrl");
        ViewExtensions.setTextAndVisibilityBy(textView, getUrl());
        getBinding().f18316b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.WidgetUrlActions.onViewCreated.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                C0876m.m165c(C1643a.m885x(view2, "it", "it.context"), WidgetUrlActions.this.getUrl(), 0, 4);
                WidgetUrlActions.this.dismiss();
            }
        });
        getBinding().f18317c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.WidgetUrlActions.onViewCreated.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                UriHandler.handle$default(UriHandler.INSTANCE, C1643a.m885x(view2, "it", "it.context"), WidgetUrlActions.this.getUrl(), false, false, null, 28, null);
                WidgetUrlActions.this.dismiss();
            }
        });
        getBinding().f18318d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.WidgetUrlActions.onViewCreated.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Context contextRequireContext = WidgetUrlActions.this.requireContext();
                C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                String url = WidgetUrlActions.this.getUrl();
                String string = WidgetUrlActions.this.getString(C5419R.string.form_label_send_to);
                C12238m.checkNotNullExpressionValue(string, "getString(R.string.form_label_send_to)");
                IntentUtils.performChooserSendIntent(contextRequireContext, url, string);
                WidgetUrlActions.this.dismiss();
            }
        });
    }
}
