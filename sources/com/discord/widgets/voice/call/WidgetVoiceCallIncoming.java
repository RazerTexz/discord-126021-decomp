package com.discord.widgets.voice.call;

import android.content.Context;
import android.os.Build$VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetVoiceCallIncomingBinding;
import com.discord.models.user.User;
import com.discord.stores.StoreCalls;
import com.discord.stores.StoreMediaEngine;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreVoiceParticipants$VoiceUser;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.fcm.NotificationClient;
import com.discord.utilities.media.AppSound;
import com.discord.utilities.media.AppSoundManager$Provider;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.user.calls.PrivateCallLauncher;
import com.discord.widgets.voice.model.CallModel;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetVoiceCallIncoming.kt */
/* JADX INFO: loaded from: classes.dex */
public class WidgetVoiceCallIncoming extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetVoiceCallIncoming.class, "binding", "getBinding()Lcom/discord/databinding/WidgetVoiceCallIncomingBinding;", 0)};

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    public WidgetVoiceCallIncoming() {
        super(R$layout.widget_voice_call_incoming);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetVoiceCallIncoming$binding$2.INSTANCE, null, 2, null);
    }

    private final WidgetVoiceCallIncomingBinding getBinding() {
        return (WidgetVoiceCallIncomingBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public void configureUI(WidgetVoiceCallIncoming$Model model) {
        User user;
        String username = null;
        if ((model != null ? model.getCallModel() : null) == null) {
            onEmptyCallModel();
            return;
        }
        CallModel callModel = model.getCallModel();
        List<StoreVoiceParticipants$VoiceUser> listComponent2 = model.component2();
        AppFragment.setOnBackPressed$default(this, new WidgetVoiceCallIncoming$configureUI$1(this, model), 0, 2, null);
        AppSoundManager$Provider.INSTANCE.get().play(AppSound.Companion.getSOUND_CALL_RINGING());
        TextView textView = getBinding().g;
        m.checkNotNullExpressionValue(textView, "binding.incomingCallStatusPrimary");
        if (ChannelUtils.z(callModel.getChannel())) {
            username = ChannelUtils.c(callModel.getChannel());
        } else {
            StoreVoiceParticipants$VoiceUser dmRecipient = callModel.getDmRecipient();
            if (dmRecipient != null && (user = dmRecipient.getUser()) != null) {
                username = user.getUsername();
            }
        }
        textView.setText(username);
        getBinding().h.setText(callModel.getIsVideoCall() ? 2131892034 : 2131892028);
        getBinding().i.configure(listComponent2);
        getBinding().e.configure(listComponent2);
        LinearLayout linearLayout = getBinding().f2700b;
        m.checkNotNullExpressionValue(linearLayout, "binding.incomingCallAcceptAltContainer");
        linearLayout.setVisibility(callModel.getIsVideoCall() ? 0 : 8);
        getBinding().d.setOnClickListener(new WidgetVoiceCallIncoming$configureUI$2(this, model));
        getBinding().c.setOnClickListener(new WidgetVoiceCallIncoming$configureUI$3(this, model));
        getBinding().f.setOnClickListener(new WidgetVoiceCallIncoming$configureUI$4(this, model));
    }

    public void onConnect(WidgetVoiceCallIncoming$Model model, boolean useVideo) {
        m.checkNotNullParameter(model, "model");
        long channelId = model.getChannelId();
        if (model.getNumIncomingCalls() == 1) {
            Context contextRequireContext = requireContext();
            FragmentManager parentFragmentManager = getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            PrivateCallLauncher privateCallLauncher = new PrivateCallLauncher(this, this, contextRequireContext, parentFragmentManager);
            if (useVideo) {
                privateCallLauncher.launchVideoCall(channelId);
            } else {
                privateCallLauncher.launchVoiceCall(channelId);
            }
        } else {
            if (useVideo) {
                StoreMediaEngine.selectDefaultVideoDevice$default(StoreStream.Companion.getMediaEngine(), null, 1, null);
            }
            StoreStream.Companion.getVoiceChannelSelected().selectVoiceChannel(channelId);
        }
        NotificationClient.clear$default(NotificationClient.INSTANCE, channelId, requireContext(), false, 4, null);
    }

    @MainThread
    public void onDecline(long channelId) {
        StoreCalls.stopRinging$default(StoreStream.Companion.getCalls(), channelId, null, 2, null);
        NotificationClient.clear$default(NotificationClient.INSTANCE, channelId, requireContext(), false, 4, null);
    }

    public void onEmptyCallModel() {
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            appActivity.finish();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        AppSoundManager$Provider.INSTANCE.get().stop(AppSound.Companion.getSOUND_CALL_RINGING());
        super.onStop();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        m.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
        Window window = fragmentActivityRequireActivity.getWindow();
        m.checkNotNullExpressionValue(window, "requireActivity().window");
        m.checkNotNullParameter(window, "window");
        if (Build$VERSION.SDK_INT >= 28) {
            window.getAttributes().layoutInDisplayCutoutMode = 1;
        }
        int color = ColorCompat.getColor(this, 2131100438);
        ColorCompat.setStatusBarTranslucent(this);
        ColorCompat.setStatusBarColor((Fragment) this, color, true);
        ViewCompat.setOnApplyWindowInsetsListener((ViewGroup) view, WidgetVoiceCallIncoming$onViewBound$1.INSTANCE);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(WidgetVoiceCallIncoming$Model.Companion.get(), this, null, 2, null), getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetVoiceCallIncoming$onViewBoundOrOnResume$1(this), 62, (Object) null);
    }
}
