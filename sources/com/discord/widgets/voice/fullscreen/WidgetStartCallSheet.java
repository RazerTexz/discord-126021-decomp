package com.discord.widgets.voice.fullscreen;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetStartCallSheetBinding;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.user.calls.PrivateCallLauncher;
import d0.z.d.m;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetStartCallSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetStartCallSheet extends AppBottomSheet {
    private static final String ARG_VOICE_CHANNEL_ID = "ARG_VOICE_CHANNEL_ID";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private PrivateCallLauncher privateCallLauncher;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetStartCallSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetStartCallSheetBinding;", 0)};
    public static final WidgetStartCallSheet$Companion Companion = new WidgetStartCallSheet$Companion(null);

    public WidgetStartCallSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetStartCallSheet$binding$2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ PrivateCallLauncher access$getPrivateCallLauncher$p(WidgetStartCallSheet widgetStartCallSheet) {
        PrivateCallLauncher privateCallLauncher = widgetStartCallSheet.privateCallLauncher;
        if (privateCallLauncher == null) {
            m.throwUninitializedPropertyAccessException("privateCallLauncher");
        }
        return privateCallLauncher;
    }

    public static final /* synthetic */ void access$setPrivateCallLauncher$p(WidgetStartCallSheet widgetStartCallSheet, PrivateCallLauncher privateCallLauncher) {
        widgetStartCallSheet.privateCallLauncher = privateCallLauncher;
    }

    private final WidgetStartCallSheetBinding getBinding() {
        return (WidgetStartCallSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public static final void show(long j, FragmentManager fragmentManager) {
        Companion.show(j, fragmentManager);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R$layout.widget_start_call_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context contextRequireContext = requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        this.privateCallLauncher = new PrivateCallLauncher(this, this, contextRequireContext, parentFragmentManager);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        long j = getArgumentsOrDefault().getLong(ARG_VOICE_CHANNEL_ID);
        getBinding().c.setOnClickListener(new WidgetStartCallSheet$onViewCreated$1(this, j));
        getBinding().f2659b.setOnClickListener(new WidgetStartCallSheet$onViewCreated$2(this, j));
    }
}
