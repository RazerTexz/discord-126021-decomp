package com.discord.widgets.stage.sheet;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentKt;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetEndStageBottomSheetBinding;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.ScreenTitleView;
import com.google.android.material.button.MaterialButton;
import d0.g;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetEndStageBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEndStageBottomSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetEndStageBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetEndStageBottomSheetBinding;", 0)};
    public static final WidgetEndStageBottomSheet$Companion Companion = new WidgetEndStageBottomSheet$Companion(null);
    private static final String EXTRA_REQUEST_KEY = "INTENT_EXTRA_REQUEST_KEY";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: channelId$delegate, reason: from kotlin metadata */
    private final Lazy channelId;

    /* JADX INFO: renamed from: requestKey$delegate, reason: from kotlin metadata */
    private final Lazy requestKey;

    public WidgetEndStageBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetEndStageBottomSheet$binding$2.INSTANCE, null, 2, null);
        this.channelId = g.lazy(new WidgetEndStageBottomSheet$channelId$2(this));
        this.requestKey = g.lazy(new WidgetEndStageBottomSheet$requestKey$2(this));
    }

    public static final /* synthetic */ void access$callOnActionTaken(WidgetEndStageBottomSheet widgetEndStageBottomSheet) {
        widgetEndStageBottomSheet.callOnActionTaken();
    }

    public static final /* synthetic */ void access$onConfirmEnd(WidgetEndStageBottomSheet widgetEndStageBottomSheet) {
        widgetEndStageBottomSheet.onConfirmEnd();
    }

    private final void callOnActionTaken() {
        String requestKey = getRequestKey();
        m.checkNotNullExpressionValue(requestKey, "requestKey");
        FragmentKt.setFragmentResult(this, requestKey, new Bundle());
    }

    private final WidgetEndStageBottomSheetBinding getBinding() {
        return (WidgetEndStageBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getChannelId() {
        return ((Number) this.channelId.getValue()).longValue();
    }

    private final String getRequestKey() {
        return (String) this.requestKey.getValue();
    }

    private final void onConfirmEnd() {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().endStageInstance(getChannelId()), false, 1, null), WidgetEndStageBottomSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, WidgetEndStageBottomSheet$onConfirmEnd$1.INSTANCE, 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R$layout.widget_end_stage_bottom_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ScreenTitleView screenTitleView = getBinding().d;
        String string = requireContext().getString(2131888982);
        m.checkNotNullExpressionValue(string, "requireContext().getStri…explicit_end_stage_title)");
        screenTitleView.setTitle(string);
        getBinding().d.setSubtitle(requireContext().getString(2131888981));
        MaterialButton materialButton = getBinding().f2382b;
        m.checkNotNullExpressionValue(materialButton, "binding.cancel");
        materialButton.setText(requireContext().getString(2131888978));
        MaterialButton materialButton2 = getBinding().c;
        m.checkNotNullExpressionValue(materialButton2, "binding.confirm");
        materialButton2.setText(requireContext().getString(2131888980));
        getBinding().f2382b.setOnClickListener(new WidgetEndStageBottomSheet$onViewCreated$1(this));
        getBinding().c.setOnClickListener(new WidgetEndStageBottomSheet$onViewCreated$2(this));
    }
}
