package com.discord.widgets.voice.call;

import android.content.Context;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import b.a.o.b;
import b.a.o.b$b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetVoiceCallInlineBinding;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection$InputMode;
import com.discord.utilities.press.OnPressListener;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.utilities.views.ViewVisibilityObserver;
import com.discord.utilities.views.ViewVisibilityObserverProvider;
import com.google.android.material.button.MaterialButton;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetVoiceCallInline.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceCallInline extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetVoiceCallInline.class, "binding", "getBinding()Lcom/discord/databinding/WidgetVoiceCallInlineBinding;", 0)};

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final ViewVisibilityObserver inlineVoiceVisibilityObserver;

    public WidgetVoiceCallInline() {
        super(R$layout.widget_voice_call_inline);
        this.binding = FragmentViewBindingDelegateKt.viewBinding(this, WidgetVoiceCallInline$binding$2.INSTANCE, new WidgetVoiceCallInline$binding$3(this));
        this.inlineVoiceVisibilityObserver = ViewVisibilityObserverProvider.INSTANCE.get(ViewVisibilityObserverProvider.INLINE_VOICE_FEATURE);
    }

    public static final /* synthetic */ void access$configureUI(WidgetVoiceCallInline widgetVoiceCallInline, WidgetVoiceCallInline$Model widgetVoiceCallInline$Model) {
        widgetVoiceCallInline.configureUI(widgetVoiceCallInline$Model);
    }

    public static final /* synthetic */ void access$onViewBindingDestroy(WidgetVoiceCallInline widgetVoiceCallInline, WidgetVoiceCallInlineBinding widgetVoiceCallInlineBinding) {
        widgetVoiceCallInline.onViewBindingDestroy(widgetVoiceCallInlineBinding);
    }

    private final void configureUI(WidgetVoiceCallInline$Model data) {
        WidgetVoiceCallInline$Model$VoiceConnected voiceConnected;
        boolean z2 = ((data == null || (voiceConnected = data.getVoiceConnected()) == null) ? null : voiceConnected.getInputMode()) == MediaEngineConnection$InputMode.PUSH_TO_TALK;
        View view = getView();
        if (view != null) {
            ViewKt.setVisible(view, z2);
        }
        this.inlineVoiceVisibilityObserver.updateVisibility(z2);
        if (data == null) {
        }
    }

    private final WidgetVoiceCallInlineBinding getBinding() {
        return (WidgetVoiceCallInlineBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void onViewBindingDestroy(WidgetVoiceCallInlineBinding binding) {
        b bVarA = b$b.a();
        MaterialButton materialButton = binding.c;
        m.checkNotNullExpressionValue(materialButton, "binding.voiceConnectedPtt");
        bVarA.c(materialButton);
    }

    private final void setWindowInsetsListeners() {
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().f2701b, WidgetVoiceCallInline$setWindowInsetsListeners$1.INSTANCE);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().c.setOnClickListener(WidgetVoiceCallInline$onViewBound$1.INSTANCE);
        getBinding().c.setOnTouchListener(new OnPressListener(WidgetVoiceCallInline$onViewBound$2.INSTANCE));
        b bVarA = b$b.a();
        MaterialButton materialButton = getBinding().c;
        m.checkNotNullExpressionValue(materialButton, "binding.voiceConnectedPtt");
        bVarA.b(materialButton);
        setWindowInsetsListeners();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(WidgetVoiceCallInline$Model.Companion.get(), this, null, 2, null), WidgetVoiceCallInline.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetVoiceCallInline$onViewBoundOrOnResume$1(this), 62, (Object) null);
    }
}
