package com.discord.widgets.voice.fullscreen;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetStartCallSheetBinding;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.user.calls.PrivateCallLauncher;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetStartCallSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetStartCallSheet extends AppBottomSheet {
    private static final String ARG_VOICE_CHANNEL_ID = "ARG_VOICE_CHANNEL_ID";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private PrivateCallLauncher privateCallLauncher;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetStartCallSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetStartCallSheetBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: WidgetStartCallSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(long voiceChannelId, FragmentManager fragmentManager) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetStartCallSheet widgetStartCallSheet = new WidgetStartCallSheet();
            Bundle bundle = new Bundle();
            bundle.putLong(WidgetStartCallSheet.ARG_VOICE_CHANNEL_ID, voiceChannelId);
            widgetStartCallSheet.setArguments(bundle);
            widgetStartCallSheet.show(fragmentManager, WidgetStartCallSheet.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WidgetStartCallSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetStartCallSheet2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ PrivateCallLauncher access$getPrivateCallLauncher$p(WidgetStartCallSheet widgetStartCallSheet) {
        PrivateCallLauncher privateCallLauncher = widgetStartCallSheet.privateCallLauncher;
        if (privateCallLauncher == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("privateCallLauncher");
        }
        return privateCallLauncher;
    }

    private final WidgetStartCallSheetBinding getBinding() {
        return (WidgetStartCallSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public static final void show(long j, FragmentManager fragmentManager) {
        INSTANCE.show(j, fragmentManager);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_start_call_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context contextRequireContext = requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        this.privateCallLauncher = new PrivateCallLauncher(this, this, contextRequireContext, parentFragmentManager);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        final long j = getArgumentsOrDefault().getLong(ARG_VOICE_CHANNEL_ID);
        getBinding().c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.fullscreen.WidgetStartCallSheet.onViewCreated.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetStartCallSheet.access$getPrivateCallLauncher$p(WidgetStartCallSheet.this).launchVoiceCall(j);
                WidgetStartCallSheet.this.dismiss();
            }
        });
        getBinding().f2659b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.fullscreen.WidgetStartCallSheet.onViewCreated.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetStartCallSheet.access$getPrivateCallLauncher$p(WidgetStartCallSheet.this).launchVideoCall(j);
                WidgetStartCallSheet.this.dismiss();
            }
        });
    }
}
