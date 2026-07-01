package com.discord.widgets.chat;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.d.AppToast;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetUrlActionsBinding;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.utilities.intent.IntentUtils;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.home.WidgetHome;
import com.discord.widgets.search.results.WidgetSearchResults;
import d0.LazyJVM;
import d0.e0.KClass;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetUrlActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetUrlActions extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetUrlActions.class, "binding", "getBinding()Lcom/discord/databinding/WidgetUrlActionsBinding;", 0)};

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
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(url, "url");
            WidgetUrlActions widgetUrlActions = new WidgetUrlActions();
            Bundle bundle = new Bundle();
            bundle.putString(WidgetUrlActions.INTENT_URL, url);
            widgetUrlActions.setArguments(bundle);
            widgetUrlActions.show(fragmentManager, WidgetUrlActions.class.getName());
        }

        public final void requestNotice(String url) {
            Intrinsics3.checkNotNullParameter(url, "url");
            StoreStream.INSTANCE.getNotices().requestToShow(new StoreNotices.Notice(url, null, 0L, 0, false, Collections2.listOf((Object[]) new KClass[]{Reflection2.getOrCreateKotlinClass(WidgetHome.class), Reflection2.getOrCreateKotlinClass(WidgetSearchResults.class)}), 0L, false, 0L, new WidgetUrlActions2(url), 150, null));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WidgetUrlActions() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetUrlActions3.INSTANCE, null, 2, null);
        this.url = LazyJVM.lazy(new WidgetUrlActions4(this));
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
        return R.layout.widget_url_actions;
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
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        TextView textView = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.dialogUrlActionsUrl");
        ViewExtensions.setTextAndVisibilityBy(textView, getUrl());
        getBinding().f2678b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.WidgetUrlActions.onViewCreated.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AppToast.c(outline.x(view2, "it", "it.context"), WidgetUrlActions.this.getUrl(), 0, 4);
                WidgetUrlActions.this.dismiss();
            }
        });
        getBinding().c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.WidgetUrlActions.onViewCreated.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                UriHandler.handle$default(UriHandler.INSTANCE, outline.x(view2, "it", "it.context"), WidgetUrlActions.this.getUrl(), false, false, null, 28, null);
                WidgetUrlActions.this.dismiss();
            }
        });
        getBinding().d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.WidgetUrlActions.onViewCreated.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Context contextRequireContext = WidgetUrlActions.this.requireContext();
                Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                String url = WidgetUrlActions.this.getUrl();
                String string = WidgetUrlActions.this.getString(R.string.form_label_send_to);
                Intrinsics3.checkNotNullExpressionValue(string, "getString(R.string.form_label_send_to)");
                IntentUtils.performChooserSendIntent(contextRequireContext, url, string);
                WidgetUrlActions.this.dismiss();
            }
        });
    }
}
