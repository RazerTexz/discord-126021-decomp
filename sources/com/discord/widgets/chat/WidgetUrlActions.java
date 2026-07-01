package com.discord.widgets.chat;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetUrlActionsBinding;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.g;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetUrlActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetUrlActions extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetUrlActions.class, "binding", "getBinding()Lcom/discord/databinding/WidgetUrlActionsBinding;", 0)};
    public static final WidgetUrlActions$Companion Companion = new WidgetUrlActions$Companion(null);
    private static final String INTENT_URL = "INTENT_URL";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: url$delegate, reason: from kotlin metadata */
    private final Lazy url;

    public WidgetUrlActions() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetUrlActions$binding$2.INSTANCE, null, 2, null);
        this.url = g.lazy(new WidgetUrlActions$url$2(this));
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetUrlActions widgetUrlActions) {
        return widgetUrlActions.getArgumentsOrDefault();
    }

    public static final /* synthetic */ String access$getUrl$p(WidgetUrlActions widgetUrlActions) {
        return widgetUrlActions.getUrl();
    }

    private final WidgetUrlActionsBinding getBinding() {
        return (WidgetUrlActionsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final String getUrl() {
        return (String) this.url.getValue();
    }

    public static final void launch(FragmentManager fragmentManager, String str) {
        Companion.launch(fragmentManager, str);
    }

    public static final void requestNotice(String str) {
        Companion.requestNotice(str);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R$layout.widget_url_actions;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        StoreNotices.markSeen$default(StoreStream.Companion.getNotices(), getUrl(), 0L, 2, null);
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
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        TextView textView = getBinding().e;
        m.checkNotNullExpressionValue(textView, "binding.dialogUrlActionsUrl");
        ViewExtensions.setTextAndVisibilityBy(textView, getUrl());
        getBinding().f2678b.setOnClickListener(new WidgetUrlActions$onViewCreated$1(this));
        getBinding().c.setOnClickListener(new WidgetUrlActions$onViewCreated$2(this));
        getBinding().d.setOnClickListener(new WidgetUrlActions$onViewCreated$3(this));
    }
}
