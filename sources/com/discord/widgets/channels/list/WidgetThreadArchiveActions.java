package com.discord.widgets.channels.list;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.api.channel.Channel;
import com.discord.api.thread.ThreadMetadata;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetThreadArchiveActionsSheetBinding;
import com.discord.restapi.RestAPIParams$ThreadSettings;
import com.discord.utilities.analytics.Traits$Location;
import com.discord.utilities.analytics.Traits$Location$Obj;
import com.discord.utilities.analytics.Traits$Location$Page;
import com.discord.utilities.analytics.Traits$Location$Section;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.threads.ThreadUtils;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.radiobutton.MaterialRadioButton;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.subscriptions.CompositeSubscription;

/* JADX INFO: compiled from: WidgetThreadArchiveActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadArchiveActions extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetThreadArchiveActions.class, "binding", "getBinding()Lcom/discord/databinding/WidgetThreadArchiveActionsSheetBinding;", 0)};
    public static final WidgetThreadArchiveActions$Companion Companion = new WidgetThreadArchiveActions$Companion(null);
    private static final String INTENT_EXTRA_CHANNEL_ID = "INTENT_EXTRA_CHANNEL_ID";
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    public WidgetThreadArchiveActions() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetThreadArchiveActions$binding$2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$archiveThread(WidgetThreadArchiveActions widgetThreadArchiveActions, Channel channel, boolean z2) {
        widgetThreadArchiveActions.archiveThread(channel, z2);
    }

    public static final /* synthetic */ void access$configureUI(WidgetThreadArchiveActions widgetThreadArchiveActions, WidgetThreadArchiveActions$Model widgetThreadArchiveActions$Model) {
        widgetThreadArchiveActions.configureUI(widgetThreadArchiveActions$Model);
    }

    public static final /* synthetic */ void access$setAutoArchiveDuration(WidgetThreadArchiveActions widgetThreadArchiveActions, Channel channel, int i) {
        widgetThreadArchiveActions.setAutoArchiveDuration(channel, i);
    }

    private final void archiveThread(Channel channel, boolean lockThread) {
        RestAPI api = RestAPI.Companion.getApi();
        long id2 = channel.getId();
        Boolean bool = Boolean.TRUE;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(api.editThread(id2, new RestAPIParams$ThreadSettings(bool, lockThread ? bool : null, null, 4, null)), false, 1, null), this, null, 2, null), getContext(), "REST: archiveThread", (Function1) null, new WidgetThreadArchiveActions$archiveThread$1(this), (Function1) null, (Function0) null, (Function0) null, 116, (Object) null);
    }

    private final void configureUI(WidgetThreadArchiveActions$Model model) {
        if (model == null) {
            dismiss();
            return;
        }
        Context contextRequireContext = requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        Channel channel = model.getChannel();
        model.getGuild();
        new Traits$Location(Traits$Location$Page.GUILD_CHANNEL, Traits$Location$Section.THREAD_ARCHIVAL_DURATION_SHEET, Traits$Location$Obj.LIST_ITEM, null, null, 24, null);
        LinearLayout linearLayout = getBinding().c;
        m.checkNotNullExpressionValue(linearLayout, "binding.autoArchiveHeader");
        boolean z2 = false;
        linearLayout.setVisibility(0);
        long jComputeThreadAutoArchiveTimeMs = ThreadUtils.INSTANCE.computeThreadAutoArchiveTimeMs(channel);
        TextView textView = getBinding().l;
        m.checkNotNullExpressionValue(textView, "binding.subtitle");
        textView.setText(b.h(contextRequireContext, 2131886941, new Object[]{TimeUtils.toReadableTimeString$default(contextRequireContext, jComputeThreadAutoArchiveTimeMs, null, 4, null)}, null, 4));
        ThreadMetadata threadMetadata = channel.getThreadMetadata();
        Integer numValueOf = threadMetadata != null ? Integer.valueOf(threadMetadata.getAutoArchiveDuration()) : null;
        TextView textView2 = getBinding().f2667b;
        m.checkNotNullExpressionValue(textView2, "binding.archiveNow");
        textView2.setVisibility(0);
        getBinding().f2667b.setOnClickListener(new WidgetThreadArchiveActions$configureUI$1(this, channel, model));
        getBinding().d.setOnClickListener(new WidgetThreadArchiveActions$configureUI$2(this, channel));
        MaterialRadioButton materialRadioButton = getBinding().e;
        m.checkNotNullExpressionValue(materialRadioButton, "binding.optionOneHourRadio");
        materialRadioButton.setChecked(numValueOf != null && numValueOf.intValue() == 60);
        getBinding().j.setOnClickListener(new WidgetThreadArchiveActions$configureUI$3(this, channel));
        MaterialRadioButton materialRadioButton2 = getBinding().k;
        m.checkNotNullExpressionValue(materialRadioButton2, "binding.optionTwentyFourHoursRadio");
        materialRadioButton2.setChecked(numValueOf != null && numValueOf.intValue() == 1440);
        getBinding().h.setOnClickListener(new WidgetThreadArchiveActions$configureUI$4(this, channel));
        MaterialRadioButton materialRadioButton3 = getBinding().i;
        m.checkNotNullExpressionValue(materialRadioButton3, "binding.optionThreeDaysRadio");
        materialRadioButton3.setChecked(numValueOf != null && numValueOf.intValue() == 4320);
        getBinding().f.setOnClickListener(new WidgetThreadArchiveActions$configureUI$5(this, channel));
        MaterialRadioButton materialRadioButton4 = getBinding().g;
        m.checkNotNullExpressionValue(materialRadioButton4, "binding.optionSevenDaysRadio");
        if (numValueOf != null && numValueOf.intValue() == 10080) {
            z2 = true;
        }
        materialRadioButton4.setChecked(z2);
    }

    private final WidgetThreadArchiveActionsSheetBinding getBinding() {
        return (WidgetThreadArchiveActionsSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void setAutoArchiveDuration(Channel channel, int minutes) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().editThread(channel.getId(), new RestAPIParams$ThreadSettings(null, null, Integer.valueOf(minutes), 3, null)), false, 1, null), this, null, 2, null), getContext(), "REST: setAutoArchiveDuration", (Function1) null, new WidgetThreadArchiveActions$setAutoArchiveDuration$1(this), (Function1) null, (Function0) null, (Function0) null, 116, (Object) null);
    }

    public static final void show(FragmentManager fragmentManager, long j, long j2) {
        Companion.show(fragmentManager, j, j2);
    }

    @Override // com.discord.app.AppBottomSheet
    public void bindSubscriptions(CompositeSubscription compositeSubscription) {
        m.checkNotNullParameter(compositeSubscription, "compositeSubscription");
        super.bindSubscriptions(compositeSubscription);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(WidgetThreadArchiveActions$Model.Companion.get(getArgumentsOrDefault().getLong(INTENT_EXTRA_CHANNEL_ID, -1L), getArgumentsOrDefault().getLong("INTENT_EXTRA_GUILD_ID", -1L)), this, null, 2, null), WidgetThreadArchiveActions.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetThreadArchiveActions$bindSubscriptions$1(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R$layout.widget_thread_archive_actions_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        dismiss();
    }
}
