package com.discord.widgets.channels.threads;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetThreadArchiveActionsSheetBinding;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreThreadDraft$ThreadDraftState;
import com.discord.utilities.analytics.Traits$Location;
import com.discord.utilities.analytics.Traits$Location$Obj;
import com.discord.utilities.analytics.Traits$Location$Page;
import com.discord.utilities.analytics.Traits$Location$Section;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.radiobutton.MaterialRadioButton;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.subscriptions.CompositeSubscription;

/* JADX INFO: compiled from: WidgetThreadDraftArchiveSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadDraftArchiveSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetThreadDraftArchiveSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetThreadArchiveActionsSheetBinding;", 0)};
    public static final WidgetThreadDraftArchiveSheet$Companion Companion = new WidgetThreadDraftArchiveSheet$Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    public WidgetThreadDraftArchiveSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetThreadDraftArchiveSheet$binding$2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$configureUI(WidgetThreadDraftArchiveSheet widgetThreadDraftArchiveSheet, WidgetThreadDraftArchiveSheet$Model widgetThreadDraftArchiveSheet$Model) {
        widgetThreadDraftArchiveSheet.configureUI(widgetThreadDraftArchiveSheet$Model);
    }

    public static final /* synthetic */ void access$setAutoArchiveDuration(WidgetThreadDraftArchiveSheet widgetThreadDraftArchiveSheet, StoreThreadDraft$ThreadDraftState storeThreadDraft$ThreadDraftState, int i) {
        widgetThreadDraftArchiveSheet.setAutoArchiveDuration(storeThreadDraft$ThreadDraftState, i);
    }

    private final void configureUI(WidgetThreadDraftArchiveSheet$Model model) {
        StoreThreadDraft$ThreadDraftState draftState = model.getDraftState();
        model.getGuild();
        model.getChannel();
        Integer autoArchiveDuration = draftState.getAutoArchiveDuration();
        int iIntValue = autoArchiveDuration != null ? autoArchiveDuration.intValue() : 1440;
        new Traits$Location(Traits$Location$Page.GUILD_CHANNEL, Traits$Location$Section.THREAD_ARCHIVAL_DURATION_SHEET, Traits$Location$Obj.LIST_ITEM, null, null, 24, null);
        getBinding().d.setOnClickListener(new WidgetThreadDraftArchiveSheet$configureUI$1(this, draftState));
        MaterialRadioButton materialRadioButton = getBinding().e;
        m.checkNotNullExpressionValue(materialRadioButton, "binding.optionOneHourRadio");
        materialRadioButton.setChecked(iIntValue == 60);
        getBinding().j.setOnClickListener(new WidgetThreadDraftArchiveSheet$configureUI$2(this, draftState));
        MaterialRadioButton materialRadioButton2 = getBinding().k;
        m.checkNotNullExpressionValue(materialRadioButton2, "binding.optionTwentyFourHoursRadio");
        materialRadioButton2.setChecked(iIntValue == 1440);
        getBinding().h.setOnClickListener(new WidgetThreadDraftArchiveSheet$configureUI$3(this, draftState));
        MaterialRadioButton materialRadioButton3 = getBinding().i;
        m.checkNotNullExpressionValue(materialRadioButton3, "binding.optionThreeDaysRadio");
        materialRadioButton3.setChecked(iIntValue == 4320);
        getBinding().f.setOnClickListener(new WidgetThreadDraftArchiveSheet$configureUI$4(this, draftState));
        MaterialRadioButton materialRadioButton4 = getBinding().g;
        m.checkNotNullExpressionValue(materialRadioButton4, "binding.optionSevenDaysRadio");
        materialRadioButton4.setChecked(iIntValue == 10080);
    }

    private final WidgetThreadArchiveActionsSheetBinding getBinding() {
        return (WidgetThreadArchiveActionsSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void setAutoArchiveDuration(StoreThreadDraft$ThreadDraftState draftState, int minutes) {
        StoreStream.Companion.getThreadDraft().setDraftState(StoreThreadDraft$ThreadDraftState.copy$default(draftState, false, Integer.valueOf(minutes), null, false, false, 29, null));
        dismiss();
    }

    public static final void show(FragmentManager fragmentManager, long j) {
        Companion.show(fragmentManager, j);
    }

    @Override // com.discord.app.AppBottomSheet
    public void bindSubscriptions(CompositeSubscription compositeSubscription) {
        m.checkNotNullParameter(compositeSubscription, "compositeSubscription");
        super.bindSubscriptions(compositeSubscription);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(WidgetThreadDraftArchiveSheet$Model.Companion.get(getArgumentsOrDefault().getLong("INTENT_EXTRA_GUILD_ID", -1L)), this, null, 2, null), WidgetThreadDraftArchiveSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetThreadDraftArchiveSheet$bindSubscriptions$1(this), 62, (Object) null);
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
